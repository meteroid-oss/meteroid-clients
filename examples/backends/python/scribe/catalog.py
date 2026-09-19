"""Catalog resolution.

The demo **never creates catalog objects** — the operator seeds them once, by hand
(``examples/CATALOG.md``). Everything here is a lookup by a stable identifier, and
every failure becomes ``503 CATALOG_NOT_SEEDED`` naming exactly what was missing.

Two things are resolved:

- the four **features**, by code, which is what tells an unseeded tenant apart from a
  workspace that simply has no subscription (both show zero entitlements); and
- the three **plans**, by their exact seeded name, because Meteroid plans carry no
  user-supplied code.

The result is cached for the life of the process once it succeeds. Failures are not
cached, so seeding the tenant while the backend runs fixes it without a restart.
"""

from __future__ import annotations

from decimal import Decimal
from typing import Final, assert_never

from meteroid import MeteroidAsync
from meteroid.models import (
    BillingCycleResetPeriod,
    BillingPeriodEnum,
    BooleanConfigValue,
    BooleanResolvedEntitlementValue,
    CalendarResetPeriod,
    CalendarUnit,
    CapacityPlanFee,
    ConfigResolvedEntitlementValue,
    ExtraRecurringPlanFee,
    Fee,
    FixedWindowResetPeriod,
    JsonConfigValue,
    MeteredResolvedEntitlementValue,
    NeverResetPeriod,
    NumberConfigValue,
    OneTimePlanFee,
    PerUnitPlanPricing,
    PlanStatusEnum,
    PlanTypeEnum,
    RatePlanFee,
    ResetPeriod,
    ResolvedEntitlementValue,
    SlidingWindowResetPeriod,
    SlotPlanFee,
    TermRate,
    TextConfigValue,
    UsagePlanFee,
)

from .decimals import render
from .dto import METEROID_PLAN_NAME, PLAN_CODES, Plan, PlanCode, PlanFeatureLine, PlanPrice
from .error import ApiError, is_not_found, to_api_error, upstream

# The four feature codes this demo gates on. Seeded in the dashboard; GET-only over REST.
FEATURE_CODES: Final = ("transcription_minutes", "sso", "retention_days", "seats")

# The metered feature the transcription endpoint enforces, and the billable metric code
# the ingested events carry.
TRANSCRIPTION_MINUTES: Final = "transcription_minutes"

_SEED_HINT = "Seed the catalog per examples/CATALOG.md."


class Catalog:
    def __init__(self, plans: list[Plan], plan_codes_by_id: dict[str, PlanCode]) -> None:
        # In `PLAN_CODES` order — cheapest first.
        self.plans = plans
        # Meteroid plan id → the demo's plan code, for labelling a subscription's plan.
        self._plan_codes_by_id = plan_codes_by_id

    def plan(self, code: PlanCode) -> Plan:
        for candidate in self.plans:
            if candidate["code"] == code:
                return candidate
        raise ApiError.internal(f'The resolved catalog holds no "{code}" plan.')

    def plan_code_for(self, plan_id: str, plan_name: str) -> PlanCode | None:
        """Label a Meteroid subscription's plan. Matches on `plan_id` first — a dashboard
        rename then still resolves — and falls back to the exact seeded name.
        """
        by_id = self._plan_codes_by_id.get(plan_id)
        if by_id is not None:
            return by_id
        return next((code for code in PLAN_CODES if METEROID_PLAN_NAME[code] == plan_name), None)


class CatalogCache:
    """Process-wide cache of the resolved catalog. Only successes are cached."""

    def __init__(self) -> None:
        self._resolved: Catalog | None = None

    async def get(
        self, client: MeteroidAsync, metrics: MetricCache, expected_currency: str
    ) -> Catalog:
        if self._resolved is None:
            self._resolved = await _resolve(client, metrics, expected_currency)
        return self._resolved


class MetricCache:
    """Meteroid identifies the metric behind a metered entitlement, and behind a
    `USAGE`/`CAPACITY` price component, by **id** only. This maps ids back onto the codes
    application code actually knows.
    """

    def __init__(self) -> None:
        self._codes_by_id: dict[str, str] = {}

    async def refresh(self, client: MeteroidAsync) -> None:
        """Load (or reload) the whole map. Cheap: one page covers any realistic demo tenant."""
        with upstream("GET /api/v1/metrics"):
            response = await client.metrics.list_metrics(per_page=100)

        self._codes_by_id = {metric.id: metric.code for metric in response.data}

    async def code_for(self, client: MeteroidAsync, metric_id: str) -> str | None:
        """Resolve one metric id, refreshing once on a miss so a metric seeded after
        startup still shows up. `None` is not fatal anywhere — the code is presentational.
        """
        if metric_id not in self._codes_by_id:
            try:
                await self.refresh(client)
            except ApiError:
                return None
        return self.code_for_cached(metric_id)

    def code_for_cached(self, metric_id: str) -> str | None:
        return self._codes_by_id.get(metric_id)


async def _resolve(client: MeteroidAsync, metrics: MetricCache, expected_currency: str) -> Catalog:
    # 1. The four features must exist. This is the check that keeps an unseeded tenant
    #    from masquerading as "your plan doesn't include that" on the first transcription.
    for feature_code in FEATURE_CODES:
        try:
            await client.features.get_feature(feature_code)
        except Exception as exc:
            if is_not_found(exc):
                raise ApiError.catalog_not_seeded(
                    f'No feature with code "{feature_code}". Features cannot be created over '
                    f"the REST API; create it in the Meteroid dashboard. {_SEED_HINT}"
                ) from exc
            raise to_api_error(f"GET /api/v1/features/{feature_code}", exc) from exc

    # 2. metric id → code, used to name the unit of usage-priced components below.
    await metrics.refresh(client)

    # 3. The three plans, by exact seeded name.
    plans: list[Plan] = []
    plan_codes_by_id: dict[str, PlanCode] = {}
    for code in PLAN_CODES:
        plan = await _resolve_plan(client, metrics, code, expected_currency)
        plan_codes_by_id[plan["plan_id"]] = code
        plans.append(plan)

    return Catalog(plans, plan_codes_by_id)


async def _resolve_plan(
    client: MeteroidAsync, metrics: MetricCache, code: PlanCode, expected_currency: str
) -> Plan:
    name = METEROID_PLAN_NAME[code]

    # `search` is a fuzzy name match — "Scribe" alone returns all three plans — so the
    # exact-name filter below is what actually pins the plan down.
    with upstream("GET /api/v1/plans"):
        found = await client.plans.list_plans(
            search=name, status=[PlanStatusEnum.ACTIVE], per_page=100
        )

    plan = next((candidate for candidate in found.data if candidate.name == name), None)
    if plan is None:
        raise ApiError.catalog_not_seeded(
            f'No published plan named "{name}" (plan_code={code}). {_SEED_HINT}'
        )

    # Meteroid refuses to check a customer out against a plan version in another
    # currency, so catching the mismatch here beats a confusing failure at checkout.
    if plan.currency.upper() != expected_currency.upper():
        raise ApiError.catalog_not_seeded(
            f'Plan "{name}" is priced in {plan.currency} but SCRIBE_DEFAULT_CURRENCY is '
            f"{expected_currency}; Meteroid will not check out a customer against a plan in "
            "another currency."
        )

    # The marketing bullets come from the plan version's entitlements, so the pricing
    # page and the enforcement path cannot drift apart.
    with upstream(f"GET /api/v1/plan-versions/{plan.version_id}/entitlements"):
        entitlements = await client.plans.list_plan_version_entitlements(plan.version_id)

    features: list[PlanFeatureLine] = [
        {
            "feature_code": entitlement.feature.code,
            "label": feature_label(entitlement.feature.name, entitlement.value),
        }
        for entitlement in entitlements.data
    ]

    prices = [
        _flatten_fee(metrics, component.id, component.name, component.fee)
        for component in plan.price_components
        # A component with no fee has nothing to show, so it is dropped entirely.
        if component.fee is not None
    ]

    return {
        "code": code,
        "name": plan.name,
        "description": plan.description,
        "plan_id": plan.id,
        "plan_version_id": plan.version_id,
        "version": plan.version,
        "currency": plan.currency,
        "is_free": plan.plan_type is PlanTypeEnum.FREE,
        "trial_days": None if plan.trial is None else plan.trial.duration_days,
        "prices": prices,
        "features": features,
    }


def _flatten_fee(
    metrics: MetricCache, component_id: str, component_name: str, fee: Fee
) -> PlanPrice:
    """Flatten one Meteroid price component into the display-oriented `PlanPrice` of the
    contract. Deliberately lossy: this renders a pricing table, it does not reprice.

    The SDK models `Fee` as a tag plus a `content` holding the variant's dataclass, so
    the `match` is on the content's class and `assert_never` has mypy prove all six
    variants are handled.
    """
    price: PlanPrice = {
        "component_id": component_id,
        "name": component_name,
        "kind": fee.type,
        "cadence": None,
        "amount": None,
        "unit_amount": None,
        "included_amount": None,
        "unit_name": None,
        "pricing_model": None,
    }

    match fee.content:
        case RatePlanFee(rates=rates) | SlotPlanFee(rates=rates):
            term = _pick_term(rates)
            if term is not None:
                price["cadence"] = term.term.value
                price["amount"] = render(term.price)
            if isinstance(fee.content, SlotPlanFee):
                price["unit_name"] = fee.content.slot_unit_name
        case CapacityPlanFee() as capacity:
            price["cadence"] = capacity.cadence.value
            price["unit_name"] = metrics.code_for_cached(capacity.metric_id)
            if capacity.thresholds:
                threshold = capacity.thresholds[0]
                price["amount"] = render(threshold.price)
                price["unit_amount"] = render(threshold.per_unit_overage)
                # Meteroid types this one as an integer count; the contract carries every
                # quantity as a decimal string.
                price["included_amount"] = render(Decimal(threshold.included_amount))
        case UsagePlanFee() as usage:
            price["cadence"] = usage.cadence.value
            price["unit_name"] = metrics.code_for_cached(usage.metric_id)
            price["pricing_model"] = usage.pricing.type
            # Only PER_UNIT has a single displayable unit price.
            if isinstance(usage.pricing.content, PerUnitPlanPricing):
                price["unit_amount"] = render(usage.pricing.content.rate)
        case ExtraRecurringPlanFee() as recurring:
            price["cadence"] = recurring.cadence.value
            price["amount"] = render(recurring.unit_price)
        case OneTimePlanFee() as one_time:
            price["amount"] = render(one_time.unit_price)
        case _ as unreachable:
            assert_never(unreachable)
    return price


def _pick_term(rates: list[TermRate]) -> TermRate | None:
    """A `RATE` or `SLOT` fee prices one billing term each. The table shows one of them:
    the monthly term when it exists (that is what the seeded catalog uses), else the
    first. Meteroid's `Plan` carries no cadence of its own to match against.
    """
    monthly = next((rate for rate in rates if rate.term is BillingPeriodEnum.MONTHLY), None)
    return monthly if monthly is not None else next(iter(rates), None)


def feature_label(feature_name: str, value: ResolvedEntitlementValue) -> str:
    """Render one plan-version entitlement as a marketing bullet."""

    def included(on: bool) -> str:
        return f"{feature_name} {'included' if on else 'not included'}"

    match value.content:
        case BooleanResolvedEntitlementValue(enabled=enabled):
            return included(enabled)
        case MeteredResolvedEntitlementValue() as metered:
            if not metered.enabled:
                return included(False)
            if metered.limit is None:
                return f"Unlimited {_lower_first(feature_name)}"
            return (
                f"{render(metered.limit)} {_lower_first(feature_name)}"
                f"{_reset_suffix(metered.reset_period)}"
            )
        case ConfigResolvedEntitlementValue(value=config):
            match config.content:
                case NumberConfigValue(value=number):
                    return f"{render(number)} {_lower_first(feature_name)}"
                case BooleanConfigValue(value=flag):
                    return included(flag)
                case TextConfigValue(value=text):
                    return f"{feature_name}: {text}"
                case JsonConfigValue():
                    return f"{feature_name} configured"
                case _ as unreachable_config:
                    assert_never(unreachable_config)
        case _ as unreachable:
            assert_never(unreachable)


def _reset_suffix(reset_period: ResetPeriod) -> str:
    match reset_period.content:
        case BillingCycleResetPeriod():
            return " per billing cycle"
        case NeverResetPeriod():
            return ""
        case (
            CalendarResetPeriod(interval=count, unit=unit)
            | FixedWindowResetPeriod(interval=count, unit=unit)
        ):
            return f" per {_interval(count, unit)}"
        case SlidingWindowResetPeriod(interval=count, unit=unit):
            return f" per rolling {_interval(count, unit)}"
        case _ as unreachable:
            assert_never(unreachable)


def _interval(count: int, unit: CalendarUnit) -> str:
    name = unit.value.lower()
    return name if count == 1 else f"{count} {name}s"


def _lower_first(value: str) -> str:
    return value[:1].lower() + value[1:]

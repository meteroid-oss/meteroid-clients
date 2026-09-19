"""Turning Meteroid's effective entitlements into the contract's normalized view.

This is the single most important piece of modelling in the demo, because it is what
both the UI gating and the server-side enforcement read.

Meteroid's ``EffectiveEntitlementValue`` is a union tagged on ``type``
(``BOOLEAN`` / ``METERED`` / ``CONFIG``), with the metered variant split into a ``spec``
(what the plan grants) and a ``usage`` (what has been consumed). The contract keeps the
tag, flattens spec+usage into one object, and keeps every decimal a string.
"""

from decimal import Decimal
from typing import assert_never

from meteroid.models import (
    BillingCycleResetPeriod,
    BooleanConfigValue,
    BooleanEffectiveEntitlementValue,
    CalendarResetPeriod,
    ConfigEffectiveEntitlementValue,
    EffectiveEntitlement,
    FixedWindowResetPeriod,
    JsonConfigValue,
    MeteredEffectiveEntitlementValue,
    NeverResetPeriod,
    NumberConfigValue,
    SlidingWindowResetPeriod,
    TextConfigValue,
)
from meteroid.models import ConfigValue as SdkConfigValue
from meteroid.models import ResetPeriod as SdkResetPeriod

from .decimals import render, render_opt, subtract
from .dto import (
    ConfigValue,
    Entitlement,
    EntitlementValue,
    QuotaSnapshot,
    ResetPeriod,
    timestamp_opt,
)
from .error import upstream
from .state import AppState


async def fetch_entitlements(state: AppState, alias: str) -> list[EffectiveEntitlement]:
    """Read the workspace's effective entitlements from Meteroid.

    One call, by customer alias. Meteroid merges feature defaults, plan-version
    entitlements, product and add-on entitlements, and attaches live usage counters.
    """
    with upstream(f"GET /api/v1/customers/{alias}/entitlements"):
        response = await state.meteroid.customers.get_effective_entitlements(alias)

    return response.data


async def normalize_entitlement(state: AppState, entitlement: EffectiveEntitlement) -> Entitlement:
    """Project one Meteroid entitlement onto the contract's tagged union."""
    feature = entitlement.feature

    normalized: EntitlementValue
    match entitlement.value.content:
        case BooleanEffectiveEntitlementValue(enabled=enabled):
            normalized = {"type": "BOOLEAN", "enabled": enabled}
        case MeteredEffectiveEntitlementValue() as metered:
            # Meteroid names the metric behind an entitlement by id only. The code is
            # presentational (it lines this view up with `GET /api/usage`), so an
            # unresolvable id is a null rather than an error.
            metric_code = await state.metrics.code_for(state.meteroid, metered.spec.metric_id)
            quota = quota_snapshot(feature.code, metered)

            normalized = {
                "type": "METERED",
                "enabled": quota["enabled"],
                "limit": quota["limit"],
                "consumed": quota["consumed"],
                "remaining": quota["remaining"],
                "unlimited": quota["unlimited"],
                "reset_at": quota["reset_at"],
                "reset_period": _reset_period(metered.spec.reset_period),
                "metric_code": metric_code,
            }
        case ConfigEffectiveEntitlementValue(value=config):
            normalized = {"type": "CONFIG", "value": _config_value(config)}
        case _ as unreachable:
            assert_never(unreachable)

    return {"feature_code": feature.code, "feature_name": feature.name, "value": normalized}


def quota_snapshot(feature_code: str, metered: MeteredEffectiveEntitlementValue) -> QuotaSnapshot:
    """The consumption state of a metered entitlement, as both the entitlement view and
    the quota-exhausted error report it.

    `remaining` is the number the quota check compares against, and Meteroid does not
    always supply it: `MeteredEntitlementUsage` requires none of its properties, so an
    entitlement whose counter has not been written yet arrives with `remaining` absent
    but `limit` set. The contract therefore fixes the fallback — `limit - consumed`, then
    `limit` — so that a limited entitlement always reports a balance and no two backends
    can disagree about it.
    """
    spec, usage = metered.spec, metered.usage

    return {
        "feature_code": feature_code,
        "enabled": spec.enabled,
        "limit": render_opt(spec.limit),
        "consumed": render_opt(usage.consumed),
        "remaining": render_opt(remaining_balance(spec.limit, usage.consumed, usage.remaining)),
        "reset_at": timestamp_opt(usage.reset_at),
        # A null limit is Meteroid's way of saying "unlimited"; mirroring it as a boolean
        # saves every client the same null special-case.
        "unlimited": spec.limit is None,
    }


def remaining_balance(
    limit: Decimal | None, consumed: Decimal | None, reported: Decimal | None
) -> Decimal | None:
    """Exact decimal arithmetic, never binary floating point — this is money. The SDK
    hands all three over as `Decimal`, and they stay `Decimal` until they are rendered.
    """
    if limit is None:
        return None
    if reported is not None:
        return reported
    return subtract(limit, consumed if consumed is not None else Decimal(0))


def _reset_period(period: SdkResetPeriod) -> ResetPeriod:
    """Meteroid models the reset period as its own five-variant tagged union, but every
    variant beyond the tag carries at most an `interval`+`unit` pair. The contract keeps
    the tag and nullable fields rather than nesting a second union inside the first.
    """
    match period.content:
        case BillingCycleResetPeriod() | NeverResetPeriod():
            return {"type": period.type, "interval": None, "unit": None}
        case (
            CalendarResetPeriod(interval=interval, unit=unit)
            | FixedWindowResetPeriod(interval=interval, unit=unit)
            | SlidingWindowResetPeriod(interval=interval, unit=unit)
        ):
            return {"type": period.type, "interval": interval, "unit": unit.value}
        case _ as unreachable:
            assert_never(unreachable)


def _config_value(value: SdkConfigValue) -> ConfigValue:
    """Meteroid's `ConfigValueType` also lists `MAP` and `SELECT`, but its `ConfigValue`
    union carries only these four, which is exactly the set the contract exposes.
    """
    match value.content:
        # Numbers stay decimal strings: Meteroid types this `format: decimal`.
        case NumberConfigValue(value=number):
            return {"kind": "NUMBER", "value": render(number)}
        case BooleanConfigValue(value=flag):
            return {"kind": "BOOLEAN", "value": flag}
        case TextConfigValue(value=text):
            return {"kind": "TEXT", "value": text}
        case JsonConfigValue(value=document):
            return {"kind": "JSON", "value": document}
        case _ as unreachable:
            assert_never(unreachable)

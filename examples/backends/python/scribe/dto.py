"""The wire types of ``examples/openapi.yaml``, one ``TypedDict`` per schema.

Two rules from the contract are enforced here by construction:

- **Decimals are strings.** Every Meteroid ``format: decimal`` value is a ``str``
  produced by ``decimals.render``, never a JSON number.
- **Nullable means present-and-null.** Every ``TypedDict`` below is total and none uses
  ``NotRequired``, so ``mypy`` refuses a literal that leaves a key out. Optionality is
  ``T | None``, which serializes as ``null``. A strict deserializer on the other side
  never has to distinguish "absent" from "null".

Request bodies are the opposite by design (absent and ``null`` are equivalent) and are
decoded by hand at the bottom of this file, because ``json.loads`` validates nothing:
the contract says ``additionalProperties: false`` and types every scalar, and a request
that breaks either is a ``400``, not something to coerce.
"""

from __future__ import annotations

import json
from dataclasses import dataclass
from datetime import UTC, datetime
from typing import Any, Final, Literal, TypedDict, TypeGuard, get_args

from .error import ApiError

# ---------------------------------------------------------------- shared

PlanCode = Literal["free", "pro", "scale"]

# Cheapest first, matching the order `GET /api/plans` promises.
PLAN_CODES: Final[tuple[PlanCode, ...]] = get_args(PlanCode)

# The exact Meteroid plan **name** each code maps onto. Meteroid plans have no
# user-supplied code, so the seeded name is the lookup key — see `examples/CATALOG.md`.
METEROID_PLAN_NAME: Final[dict[PlanCode, str]] = {
    "free": "Scribe Free",
    "pro": "Scribe Pro",
    "scale": "Scribe Scale",
}


def next_up(code: PlanCode) -> PlanCode | None:
    """The plan to offer as an upgrade when this one runs out of quota."""
    return "pro" if code == "free" else "scale" if code == "pro" else None


# ---------------------------------------------------------------- ops


class Health(TypedDict):
    status: Literal["ok"]
    backend: Literal["python"]
    meteroid_configured: bool
    version: str | None


# ---------------------------------------------------------------- session


class Workspace(TypedDict):
    id: str
    name: str
    customer_id: str
    customer_alias: str
    currency: str


class CreateSessionResponse(TypedDict):
    session_token: str
    workspace: Workspace


class Subscription(TypedDict):
    id: str
    status: str
    plan_code: PlanCode | None
    plan_name: str
    plan_version_id: str
    currency: str
    current_period_start: str
    current_period_end: str | None
    trial_duration_days: int | None
    created_at: str


class MeResponse(TypedDict):
    workspace: Workspace
    subscription: Subscription | None
    plan: Plan | None


# ---------------------------------------------------------------- catalog

PriceKind = Literal["RATE", "SLOT", "CAPACITY", "USAGE", "EXTRA_RECURRING", "ONE_TIME"]

UsagePricingModel = Literal["PER_UNIT", "TIERED", "VOLUME", "PACKAGE", "MATRIX"]


class PlanPrice(TypedDict):
    component_id: str
    name: str
    kind: PriceKind
    cadence: str | None
    amount: str | None
    unit_amount: str | None
    included_amount: str | None
    unit_name: str | None
    pricing_model: UsagePricingModel | None


class PlanFeatureLine(TypedDict):
    feature_code: str
    label: str


class Plan(TypedDict):
    code: PlanCode
    name: str
    description: str | None
    plan_id: str
    plan_version_id: str
    version: int
    currency: str
    is_free: bool
    trial_days: int | None
    prices: list[PlanPrice]
    features: list[PlanFeatureLine]


class PlanListResponse(TypedDict):
    plans: list[Plan]


# ---------------------------------------------------------------- checkout


class CreateCheckoutResponse(TypedDict):
    checkout_url: str
    checkout_session_id: str
    plan_code: PlanCode
    plan_version_id: str
    expires_at: str | None


# ----------------------------------------------------------- entitlements


class ResetPeriod(TypedDict):
    type: Literal["BILLING_CYCLE", "CALENDAR", "FIXED_WINDOW", "SLIDING_WINDOW", "NEVER"]
    interval: int | None
    unit: str | None


class QuotaSnapshot(TypedDict):
    feature_code: str
    enabled: bool
    limit: str | None
    consumed: str | None
    remaining: str | None
    reset_at: str | None
    unlimited: bool


class NumberConfigValue(TypedDict):
    kind: Literal["NUMBER"]
    value: str


class BooleanConfigValue(TypedDict):
    kind: Literal["BOOLEAN"]
    value: bool


class TextConfigValue(TypedDict):
    kind: Literal["TEXT"]
    value: str


class JsonConfigValue(TypedDict):
    kind: Literal["JSON"]
    value: Any


# A typed configuration value, tagged by `kind`.
ConfigValue = NumberConfigValue | BooleanConfigValue | TextConfigValue | JsonConfigValue


class BooleanEntitlementValue(TypedDict):
    type: Literal["BOOLEAN"]
    enabled: bool


class MeteredEntitlementValue(TypedDict):
    type: Literal["METERED"]
    enabled: bool
    limit: str | None
    consumed: str | None
    remaining: str | None
    unlimited: bool
    reset_at: str | None
    reset_period: ResetPeriod
    metric_code: str | None


class ConfigEntitlementValue(TypedDict):
    type: Literal["CONFIG"]
    value: ConfigValue


# The three-way entitlement union, tagged by `type` exactly as Meteroid tags it.
EntitlementValue = BooleanEntitlementValue | MeteredEntitlementValue | ConfigEntitlementValue


class Entitlement(TypedDict):
    feature_code: str
    feature_name: str
    value: EntitlementValue


class EntitlementListResponse(TypedDict):
    entitlements: list[Entitlement]


# ----------------------------------------------------------- transcription


class Transcription(TypedDict):
    id: str
    title: str
    duration_seconds: int
    minutes_billed: str
    text: str
    created_at: str
    event_id: str


class CreateTranscriptionResponse(TypedDict):
    transcription: Transcription
    quota: QuotaSnapshot


class TranscriptionListResponse(TypedDict):
    transcriptions: list[Transcription]


# ---------------------------------------------------------------- usage


class GroupedUsage(TypedDict):
    dimensions: dict[str, str]
    value: str


class MetricUsage(TypedDict):
    metric_code: str
    metric_name: str
    total_value: str
    grouped_usage: list[GroupedUsage]


class UsageResponse(TypedDict):
    period_start: str
    period_end: str
    scope: Literal["subscription", "customer"]
    metrics: list[MetricUsage]


# ---------------------------------------------------------------- portal


class CreatePortalSessionResponse(TypedDict):
    portal_url: str
    token: str
    expires_in_seconds: int


# ---------------------------------------------------------------- invoices


class Invoice(TypedDict):
    id: str
    invoice_number: str
    status: str
    currency: str
    invoice_date: str
    due_date: str | None
    total: int
    amount_due: int


class InvoiceListResponse(TypedDict):
    invoices: list[Invoice]


# ---------------------------------------------------------------- webhooks


class WebhookAck(TypedDict):
    received: Literal[True]
    event_id: str
    type: str | None
    handled: bool


# ------------------------------------------------------------ timestamps


def timestamp(value: datetime) -> str:
    """The SDK hands every `format: date-time` field over as a `datetime`; the contract
    wants RFC 3339 back. Same instant, re-rendered in UTC with a `Z`.
    """
    # The SDK's datetimes are always aware; a naive one can only be a test's.
    aware = value if value.tzinfo is not None else value.replace(tzinfo=UTC)
    return aware.astimezone(UTC).isoformat().replace("+00:00", "Z")


def timestamp_opt(value: datetime | None) -> str | None:
    return None if value is None else timestamp(value)


# ------------------------------------------------------- request decoding


@dataclass(frozen=True)
class CreateSessionRequest:
    workspace_name: str | None
    email: str | None


@dataclass(frozen=True)
class CreateCheckoutRequest:
    plan_code: PlanCode
    coupon_code: str | None


@dataclass(frozen=True)
class CreateTranscriptionRequest:
    title: str
    duration_seconds: int


@dataclass(frozen=True)
class CreatePortalSessionRequest:
    expires_in_seconds: int | None


def decode_create_session_request(data: object) -> CreateSessionRequest:
    body = _strict_object(data, "CreateSessionRequest", ("workspace_name", "email"))
    return CreateSessionRequest(
        workspace_name=_optional_string(body, "workspace_name"),
        email=_optional_string(body, "email"),
    )


def decode_create_checkout_request(data: object) -> CreateCheckoutRequest:
    body = _strict_object(data, "CreateCheckoutRequest", ("plan_code", "coupon_code"))
    plan_code = _required_string(body, "plan_code")
    if not _is_plan_code(plan_code):
        raise _invalid(
            f"unknown plan_code {json.dumps(plan_code)}, expected one of {', '.join(PLAN_CODES)}"
        )
    return CreateCheckoutRequest(
        plan_code=plan_code, coupon_code=_optional_string(body, "coupon_code")
    )


def decode_create_transcription_request(data: object) -> CreateTranscriptionRequest:
    body = _strict_object(data, "CreateTranscriptionRequest", ("title", "duration_seconds"))
    return CreateTranscriptionRequest(
        title=_required_string(body, "title"),
        duration_seconds=_required_int32(body, "duration_seconds"),
    )


def decode_create_portal_session_request(data: object) -> CreatePortalSessionRequest:
    body = _strict_object(data, "CreatePortalSessionRequest", ("expires_in_seconds",))
    return CreatePortalSessionRequest(
        expires_in_seconds=(
            None
            if body.get("expires_in_seconds") is None
            else _required_int32(body, "expires_in_seconds")
        ),
    )


def _is_plan_code(value: str) -> TypeGuard[PlanCode]:
    return value in PLAN_CODES


def _invalid(detail: str) -> ApiError:
    return ApiError.bad_request(f"Invalid body: {detail}")


def _strict_object(data: object, schema: str, allowed: tuple[str, ...]) -> dict[str, object]:
    """`additionalProperties: false`: a JSON object, and no key the schema does not list."""
    if not isinstance(data, dict):
        raise _invalid(f"expected a {schema} object, got {_kind_of(data)}")
    for key in data:
        if key not in allowed:
            expected = " or ".join(f"`{name}`" for name in allowed)
            raise _invalid(f"unknown field `{key}`, expected {expected}")
    return data


def _required_string(body: dict[str, object], key: str) -> str:
    if key not in body:
        raise _invalid(f"missing field `{key}`")
    value = body[key]
    # No coercion: `{"title": 123}` is a type error, not the string "123".
    if not isinstance(value, str):
        raise _invalid(f"{key}: expected a string, got {_kind_of(value)}")
    return value


def _optional_string(body: dict[str, object], key: str) -> str | None:
    return None if body.get(key) is None else _required_string(body, key)


def _required_int32(body: dict[str, object], key: str) -> int:
    """The contract types its integers `format: int32`, so the range is part of the type."""
    if key not in body:
        raise _invalid(f"missing field `{key}`")
    value = body[key]
    # `bool` is a subclass of `int` in Python, so `true` has to be turned away by name
    # before anything else gets to call it 1.
    if isinstance(value, bool) or not isinstance(value, (int, float)):
        raise _invalid(f"{key}: expected a 32-bit integer, got {_kind_of(value)}")
    # JSON Schema's `integer` is about the value, not the spelling: `60.0` and `6e1` are
    # integers, `60.5` is not. `is_integer()` is also false for the `inf` that
    # `json.loads` makes of `1e400`.
    if isinstance(value, float) and not value.is_integer():
        raise _invalid(f"{key}: expected a 32-bit integer, got {_kind_of(value)}")
    if abs(value) > 2_147_483_647:
        raise _invalid(f"{key}: expected a 32-bit integer, got {_kind_of(value)}")
    return int(value)


def _kind_of(value: object) -> str:
    if value is None:
        return "null"
    if isinstance(value, list):
        return "an array"
    if isinstance(value, dict):
        return "an object"
    kind = (
        "boolean" if isinstance(value, bool) else "string" if isinstance(value, str) else "number"
    )
    return f"{kind} `{value if isinstance(value, str) else json.dumps(value)}`"

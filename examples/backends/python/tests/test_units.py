"""The pure pieces: session tokens, decimals, quota arithmetic, labels, wire shapes."""

import base64
import hashlib
import hmac
import json
from datetime import UTC, datetime, timedelta, timezone
from decimal import Decimal

import pytest
from meteroid.models import (
    BillingCycleResetPeriod,
    BillingPeriodEnum,
    BooleanResolvedEntitlementValue,
    ConfigResolvedEntitlementValue,
    ConfigValue,
    Currency,
    MeteredEffectiveEntitlementValue,
    MeteredEntitlementSpec,
    MeteredEntitlementUsage,
    MeteredResolvedEntitlementValue,
    NumberConfigValue,
    ResetPeriod,
    ResolvedEntitlementValue,
    SlidingWindowResetPeriod,
    Subscription,
    SubscriptionStatusEnum,
)
from meteroid.models.calendar_unit import CalendarUnit

from scribe.catalog import feature_label
from scribe.config import ConfigError, config_from_env
from scribe.decimals import add, billable_minutes, render, subtract
from scribe.dto import QuotaSnapshot, timestamp
from scribe.entitlements import quota_snapshot
from scribe.error import ApiError
from scribe.routes.session import project_subscription
from scribe.routes.transcriptions import project_quota
from scribe.session import mint, verify

# ---------------------------------------------------------------- session tokens


def test_a_session_token_round_trips_an_alias() -> None:
    token = mint("s3cret", "scribe-demo-8f2a1c")
    assert verify("s3cret", token) == "scribe-demo-8f2a1c"
    # Not only ASCII: the alias is UTF-8 on both sides of the HMAC.
    assert verify("s3cret", mint("s3cret", "scribe-démo-日本")) == "scribe-démo-日本"


def test_a_session_token_is_the_construction_the_contract_documents() -> None:
    # Spelled out independently of `session.py`, the way tests/contract/src/session.ts
    # does it, and pinned to the same literal the TypeScript backend's tests pin: tokens
    # minted by one backend must verify on another.
    alias = "scribe-demo-8f2a1c"
    signature = hmac.new(b"s3cret", alias.encode(), hashlib.sha256).digest()
    expected = (
        f"v1.{base64.urlsafe_b64encode(alias.encode()).decode().rstrip('=')}"
        f".{base64.urlsafe_b64encode(signature).decode().rstrip('=')}"
    )

    assert mint("s3cret", alias) == expected
    assert expected == "v1.c2NyaWJlLWRlbW8tOGYyYTFj.r50D_RuGiV8vaYqwra8Kvs1fDBE7cJ3EV1jYTRWQXiY"


def test_another_deployments_secret_is_rejected() -> None:
    token = mint("s3cret", "scribe-demo-8f2a1c")
    with pytest.raises(ApiError):
        verify("other", token)


def test_a_tampered_payload_is_rejected() -> None:
    token = mint("s3cret", "scribe-demo-8f2a1c")
    forged = f"v1.{base64.urlsafe_b64encode(b'someone-else').decode()}.{token.split('.')[2]}"
    with pytest.raises(ApiError):
        verify("s3cret", forged)


@pytest.mark.parametrize(
    "suffix_or_token",
    [
        "",
        "garbage",
        "v1.only",
        "v2.YQ.YQ",
        "v1.!!!.abc",
        "v1.YQ.*",
        "v1.YQ==.YQ",
        "v1./w.YQ",
        "v1.YR.YQ",
    ],
)
def test_a_structurally_invalid_token_is_rejected_never_partially_decoded(
    suffix_or_token: str,
) -> None:
    with pytest.raises(ApiError) as caught:
        verify("s3cret", suffix_or_token)
    assert caught.value.status == 401


@pytest.mark.parametrize("suffix", [".extra", "=", "é", " "])
def test_a_valid_token_with_anything_appended_is_rejected(suffix: str) -> None:
    with pytest.raises(ApiError):
        verify("s3cret", mint("s3cret", "alias") + suffix)


# ---------------------------------------------------------------- configuration


def test_the_session_secret_has_no_default() -> None:
    with pytest.raises(ConfigError):
        config_from_env({})
    with pytest.raises(ConfigError):
        config_from_env({"SCRIBE_SESSION_SECRET": "   "})


def test_port_wins_over_scribe_port_and_the_default_is_this_backends_own_port() -> None:
    base = {"SCRIBE_SESSION_SECRET": "s"}
    assert config_from_env(base).port == 8083
    assert config_from_env({**base, "SCRIBE_PORT": "9001"}).port == 9001
    assert config_from_env({**base, "SCRIBE_PORT": "9001", "PORT": "9002"}).port == 9002
    for bad in ["http", "70000", "0", "-1", "٨٠٨٣"]:
        with pytest.raises(ConfigError):
            config_from_env({**base, "PORT": bad})


def test_the_currency_must_be_one_meteroid_knows() -> None:
    base = {"SCRIBE_SESSION_SECRET": "s"}
    assert config_from_env(base).default_currency is Currency.USD
    assert (
        config_from_env({**base, "SCRIBE_DEFAULT_CURRENCY": "eur"}).default_currency is Currency.EUR
    )
    with pytest.raises(ConfigError):
        config_from_env({**base, "SCRIBE_DEFAULT_CURRENCY": "XYZ1"})


def test_only_the_session_secret_is_required() -> None:
    config = config_from_env({"SCRIBE_SESSION_SECRET": "s", "METEROID_API_KEY": " "})
    assert config.meteroid_configured is False
    assert config.meteroid_webhook_secret == ""
    assert config.meteroid_base_url == "https://api.meteroid.com"


# ---------------------------------------------------------------- decimals


def test_billable_minutes_round_up_to_two_decimals() -> None:
    assert render(billable_minutes(60)) == "1"
    assert render(billable_minutes(210)) == "3.5"
    # 100/60 = 1.666… must never round down: the demo bills what it used.
    assert render(billable_minutes(100)) == "1.67"
    assert render(billable_minutes(1)) == "0.02"
    assert render(billable_minutes(7200)) == "120"


def test_decimal_arithmetic_is_exact_and_renders_without_trailing_zeros() -> None:
    assert render(Decimal("3.50")) == "3.5"
    assert render(Decimal("600.000")) == "600"
    assert render(Decimal("-0.0")) == "0"
    assert render(Decimal("100")) == "100"
    # Never scientific notation, which is what `str()` and `normalize()` would give.
    assert render(Decimal("1E+3")) == "1000"
    assert render(Decimal("0.00000001")) == "0.00000001"
    # The classic: 0.1 + 0.2 in binary floating point is 0.30000000000000004.
    assert render(add(Decimal("0.1"), Decimal("0.2"))) == "0.3"
    assert render(subtract(Decimal("60"), Decimal("56.5"))) == "3.5"
    assert render(subtract(Decimal("1"), Decimal("1.05"))) == "-0.05"
    # Beyond what a double can hold exactly — and beyond the 28 significant digits the
    # default `decimal` context would silently round to.
    big = add(Decimal("90071992547409930000000000"), Decimal("0.0000000001"))
    assert render(big) == "90071992547409930000000000.0000000001"
    assert Decimal("3.51") > Decimal("3.5")
    assert not Decimal("3.50") > Decimal("3.5")


@pytest.mark.parametrize("bad", ["NaN", "Infinity", "-Infinity", "sNaN"])
def test_a_value_that_is_not_a_finite_decimal_is_meteroids_error_not_a_nan(bad: str) -> None:
    with pytest.raises(ApiError) as caught:
        render(Decimal(bad))
    assert caught.value.code == "UPSTREAM_ERROR"


# ---------------------------------------------------------------- quota


def metered(
    limit: str | None, consumed: str | None, remaining: str | None
) -> MeteredEffectiveEntitlementValue:
    def decimal(value: str | None) -> Decimal | None:
        return None if value is None else Decimal(value)

    return MeteredEffectiveEntitlementValue(
        spec=MeteredEntitlementSpec(
            enabled=True,
            limit=decimal(limit),
            metric_id="met_1",
            reset_period=ResetPeriod(type="BILLING_CYCLE", content=BillingCycleResetPeriod()),
        ),
        usage=MeteredEntitlementUsage(consumed=decimal(consumed), remaining=decimal(remaining)),
    )


def test_meteroids_remaining_is_used_when_it_has_one() -> None:
    quota = quota_snapshot("transcription_minutes", metered("60", "15", "45.0"))
    assert quota["remaining"] == "45"
    assert quota["unlimited"] is False


def test_remaining_is_derived_when_meteroid_has_no_counter() -> None:
    assert quota_snapshot("transcription_minutes", metered("60", "15", None))["remaining"] == "45"
    assert quota_snapshot("transcription_minutes", metered("60", None, None))["remaining"] == "60"


def test_an_absent_limit_is_unlimited_and_every_key_is_still_there() -> None:
    quota = quota_snapshot("transcription_minutes", metered(None, "900", None))
    assert json.loads(json.dumps(quota)) == {
        "feature_code": "transcription_minutes",
        "enabled": True,
        "limit": None,
        "consumed": "900",
        "remaining": None,
        "reset_at": None,
        "unlimited": True,
    }


QUOTA: QuotaSnapshot = {
    "feature_code": "transcription_minutes",
    "enabled": True,
    "limit": "60",
    "consumed": "56.5",
    "remaining": "3.5",
    "reset_at": None,
    "unlimited": False,
}


def test_the_quota_is_projected_forward_by_what_was_billed() -> None:
    projected = project_quota(QUOTA, billable_minutes(60))
    assert projected["consumed"] == "57.5"
    assert projected["remaining"] == "2.5"


def test_an_unlimited_quota_stays_unlimited() -> None:
    unlimited: QuotaSnapshot = {
        **QUOTA,
        "limit": None,
        "consumed": None,
        "remaining": None,
        "unlimited": True,
    }
    projected = project_quota(unlimited, billable_minutes(120))
    assert projected["unlimited"] is True
    assert projected["limit"] is None
    assert projected["remaining"] is None
    assert projected["consumed"] == "2"


# ---------------------------------------------------------------- labels


def resolved_metered(limit: str | None, reset_period: ResetPeriod) -> ResolvedEntitlementValue:
    return ResolvedEntitlementValue(
        type="METERED",
        content=MeteredResolvedEntitlementValue(
            enabled=True,
            limit=None if limit is None else Decimal(limit),
            metric_id="met_1",
            reset_period=reset_period,
        ),
    )


BILLING_CYCLE = ResetPeriod(type="BILLING_CYCLE", content=BillingCycleResetPeriod())


def test_a_metered_limit_is_labelled_with_its_reset_period() -> None:
    label = feature_label("Transcription minutes", resolved_metered("600.00", BILLING_CYCLE))
    assert label == "600 transcription minutes per billing cycle"

    rolling = ResetPeriod(
        type="SLIDING_WINDOW",
        content=SlidingWindowResetPeriod(interval=7, unit=CalendarUnit.DAY),
    )
    label = feature_label("Transcription minutes", resolved_metered("30", rolling))
    assert label == "30 transcription minutes per rolling 7 days"


def test_an_unlimited_entitlement_is_labelled_as_such() -> None:
    label = feature_label("Transcription minutes", resolved_metered(None, BILLING_CYCLE))
    assert label == "Unlimited transcription minutes"


def test_boolean_and_config_entitlements_are_labelled() -> None:
    sso = ResolvedEntitlementValue(
        type="BOOLEAN", content=BooleanResolvedEntitlementValue(enabled=True)
    )
    assert feature_label("SSO", sso) == "SSO included"

    retention = ResolvedEntitlementValue(
        type="CONFIG",
        content=ConfigResolvedEntitlementValue(
            value=ConfigValue(kind="NUMBER", content=NumberConfigValue(value=Decimal("90")))
        ),
    )
    assert feature_label("Retention days", retention) == "90 retention days"


# ---------------------------------------------------------------- wire shapes


def test_timestamps_are_rendered_in_utc_with_a_z() -> None:
    assert timestamp(datetime(2026, 9, 1, 12, 0, tzinfo=UTC)) == "2026-09-01T12:00:00Z"
    paris = timezone(timedelta(hours=2))
    assert timestamp(datetime(2026, 9, 1, 14, 0, 0, 250000, tzinfo=paris)) == (
        "2026-09-01T12:00:00.250000Z"
    )


def test_nullable_response_fields_are_serialized_as_null_not_omitted() -> None:
    # Every optional SDK field absent. The shape must not change.
    subscription = Subscription(
        auto_advance_invoices=True,
        billing_day_anchor=1,
        charge_automatically=True,
        created_at=datetime(2026, 9, 1, 12, 0, tzinfo=UTC),
        currency=Currency.USD,
        current_period_start="2026-09-01",
        custom_properties={},
        customer_id="cus_1",
        customer_name="Acme",
        id="sub_1",
        mrr_cents=0,
        net_terms=0,
        period=BillingPeriodEnum.MONTHLY,
        plan_id="plan_9",
        plan_name="Something bespoke",
        plan_version=1,
        plan_version_id="pv_9",
        start_date="2026-09-01",
        status=SubscriptionStatusEnum.PENDING_ACTIVATION,
    )
    wire = json.loads(json.dumps(project_subscription(subscription, None)))

    assert wire == {
        "id": "sub_1",
        "status": "PENDING_ACTIVATION",
        "plan_code": None,
        "plan_name": "Something bespoke",
        "plan_version_id": "pv_9",
        "currency": "USD",
        "current_period_start": "2026-09-01",
        "current_period_end": None,
        "trial_duration_days": None,
        "created_at": "2026-09-01T12:00:00Z",
    }

    assert ApiError.internal("boom").to_json() == {
        "code": "INTERNAL",
        "message": "boom",
        "quota": None,
        "upgrade_plan_code": None,
    }

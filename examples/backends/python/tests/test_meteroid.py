"""The Meteroid-backed handlers, against a stubbed Meteroid.

There is no tenant to run these against, but the SDK takes a custom ``httpx`` client, so
the wire JSON below goes through the SDK's real deserializers and the handlers' real
projections. What this pins down is the part of the contract that matters most and that
nothing else can reach offline: the 201 / 402 / 403 / 503 split of the metered action,
and that a refused request reports **no** usage.
"""

import json
import re
from typing import Any

import httpx
import pytest

from scribe.session import mint, verify

from .support import (
    SESSION_SECRET,
    FakeMeteroid,
    TestResponse,
    assert_error_envelope,
    fake_meteroid,
    meteroid_over,
    send,
    state_with,
)

ALIAS = "scribe-demo-1"
HEADERS = {
    "authorization": f"Bearer {mint(SESSION_SECRET, ALIAS)}",
    "content-type": "application/json",
}
PAGE = {"page": 0, "per_page": 100, "total_items": 0, "total_pages": 1}


def metered_entitlement(
    limit: str | None, usage: dict[str, Any], enabled: bool = True
) -> dict[str, Any]:
    return {
        "data": [
            {
                "feature": {
                    "id": "feat_1",
                    "code": "transcription_minutes",
                    "name": "Transcription minutes",
                },
                "value": {
                    "type": "METERED",
                    "spec": {
                        "enabled": enabled,
                        "limit": limit,
                        "metric_id": "met_1",
                        "reset_period": {"type": "CALENDAR", "interval": 1, "unit": "MONTH"},
                    },
                    "usage": usage,
                },
            },
            {
                "feature": {"id": "feat_2", "code": "retention_days", "name": "Retention days"},
                "value": {"type": "CONFIG", "value": {"kind": "NUMBER", "value": "90.0"}},
            },
        ]
    }


ENTITLEMENTS = f"GET /api/v1/customers/{ALIAS}/entitlements"
INGEST = "POST /api/v1/events/ingest"
NO_SUBSCRIPTIONS = {"GET /api/v1/subscriptions": {"data": [], "pagination_meta": PAGE}}


def transcribe(meteroid: FakeMeteroid, duration_seconds: int) -> TestResponse:
    return send(
        "POST",
        "/api/transcriptions",
        headers=HEADERS,
        body=json.dumps({"title": " Weekly standup ", "duration_seconds": duration_seconds}),
        meteroid=meteroid.client,
    )


def test_a_transcription_within_quota_is_billed_reported_to_meteroid_and_projected() -> None:
    meteroid = fake_meteroid(
        {
            ENTITLEMENTS: metered_entitlement("60", {"consumed": "56.50", "remaining": "3.50"}),
            INGEST: {},
        }
    )
    response = transcribe(meteroid, 210)

    assert response.status == 201
    assert meteroid.calls == [ENTITLEMENTS, INGEST]
    transcription = response.body["transcription"]
    assert transcription["title"] == "Weekly standup"
    assert transcription["minutes_billed"] == "3.5"
    assert transcription["event_id"] == transcription["id"]
    assert response.body["quota"] == {
        "feature_code": "transcription_minutes",
        "enabled": True,
        "limit": "60",
        "consumed": "60",
        "remaining": "0",
        "reset_at": None,
        "unlimited": False,
    }

    # The event Meteroid received: the alias as customer, the minutes as a decimal string.
    assert meteroid.bodies[1] == {
        "events": [
            {
                "code": "transcription_minutes",
                "customer_id": ALIAS,
                "event_id": transcription["id"],
                "properties": {"minutes": "3.5"},
                "timestamp": transcription["created_at"],
            }
        ]
    }
    assert re.fullmatch(r"\d{4}-\d\d-\d\dT\d\d:\d\d:\d\dZ", transcription["created_at"])


def test_a_request_larger_than_the_balance_is_402_and_reports_no_usage() -> None:
    meteroid = fake_meteroid(
        {ENTITLEMENTS: metered_entitlement("60", {"consumed": "56.5"}), **NO_SUBSCRIPTIONS}
    )
    # 3.5 minutes remain (derived: Meteroid sent no `remaining`); 211 s bills 3.52.
    response = transcribe(meteroid, 211)

    assert response.status == 402
    assert_error_envelope(response.body, "QUOTA_EXHAUSTED")
    assert response.body["quota"]["remaining"] == "3.5"
    assert response.body["quota"]["limit"] == "60"
    assert response.body["upgrade_plan_code"] == "pro"
    assert INGEST not in meteroid.calls, "a refused request must not ingest an event"


def test_the_balance_may_be_spent_exactly() -> None:
    meteroid = fake_meteroid(
        {ENTITLEMENTS: metered_entitlement("60", {"remaining": "3.50"}), INGEST: {}}
    )
    response = transcribe(meteroid, 210)

    assert response.status == 201
    assert response.body["quota"]["remaining"] == "0"
    assert response.body["quota"]["consumed"] == "3.5"


def test_an_unlimited_entitlement_never_trips_the_quota() -> None:
    meteroid = fake_meteroid({ENTITLEMENTS: metered_entitlement(None, {}), INGEST: {}})
    response = transcribe(meteroid, 7200)

    assert response.status == 201
    assert response.body["quota"]["unlimited"] is True
    assert response.body["quota"]["limit"] is None
    assert response.body["quota"]["remaining"] is None
    assert response.body["quota"]["consumed"] == "120"


@pytest.mark.parametrize(
    "entitlements", [{"data": []}, metered_entitlement("60", {}, enabled=False)]
)
def test_a_missing_or_disabled_entitlement_is_403_naming_the_upgrade(
    entitlements: dict[str, Any],
) -> None:
    meteroid = fake_meteroid({ENTITLEMENTS: entitlements, **NO_SUBSCRIPTIONS})
    response = transcribe(meteroid, 60)

    assert response.status == 403
    assert_error_envelope(response.body, "FEATURE_NOT_ENTITLED")
    assert response.body["quota"] is None
    assert response.body["upgrade_plan_code"] == "pro"
    assert INGEST not in meteroid.calls


def test_a_failed_upgrade_lookup_never_replaces_the_error_it_decorates() -> None:
    # No subscriptions stub: that call 404s, and the answer is still the 403.
    meteroid = fake_meteroid({ENTITLEMENTS: {"data": []}})
    response = transcribe(meteroid, 60)

    assert response.status == 403
    assert response.body["upgrade_plan_code"] == "pro"


def test_a_feature_seeded_with_the_wrong_type_is_the_operators_503_never_a_paywall() -> None:
    meteroid = fake_meteroid(
        {
            ENTITLEMENTS: {
                "data": [
                    {
                        "feature": {
                            "id": "feat_1",
                            "code": "transcription_minutes",
                            "name": "Transcription minutes",
                        },
                        "value": {"type": "BOOLEAN", "enabled": True},
                    }
                ]
            }
        }
    )
    response = transcribe(meteroid, 60)

    assert response.status == 503
    assert_error_envelope(response.body, "CATALOG_NOT_SEEDED")
    assert INGEST not in meteroid.calls


def test_a_rejected_usage_event_is_not_recorded_as_a_transcription() -> None:
    meteroid = fake_meteroid(
        {
            ENTITLEMENTS: metered_entitlement("60", {}),
            INGEST: {"failures": [{"event_id": "tr_x", "reason": "too old"}]},
        }
    )
    state = state_with(meteroid.client)
    response = send(
        "POST",
        "/api/transcriptions",
        headers=HEADERS,
        body='{"title":"x","duration_seconds":60}',
        state=state,
    )

    assert response.status == 502
    assert_error_envelope(response.body, "UPSTREAM_ERROR")
    history = send("GET", "/api/transcriptions", headers=HEADERS, state=state)
    assert history.body == {"transcriptions": []}


def test_entitlements_are_normalized_onto_the_tagged_union_decimals_as_strings() -> None:
    meteroid = fake_meteroid(
        {
            ENTITLEMENTS: metered_entitlement(
                "60", {"consumed": "1", "reset_at": "2026-10-01T02:00:00+02:00"}
            ),
            "GET /api/v1/metrics": {
                "data": [
                    {
                        "id": "met_1",
                        "code": "transcription_minutes",
                        "name": "Minutes",
                        "aggregation_type": "SUM",
                        "created_at": "2026-01-01T00:00:00Z",
                        "product_family_id": "pf_1",
                    }
                ],
                "pagination_meta": PAGE,
            },
        }
    )
    response = send("GET", "/api/entitlements", headers=HEADERS, meteroid=meteroid.client)

    assert response.status == 200
    assert response.body["entitlements"] == [
        {
            "feature_code": "transcription_minutes",
            "feature_name": "Transcription minutes",
            "value": {
                "type": "METERED",
                "enabled": True,
                "limit": "60",
                "consumed": "1",
                "remaining": "59",
                "unlimited": False,
                # Re-rendered by this backend: same instant, in UTC.
                "reset_at": "2026-10-01T00:00:00Z",
                "reset_period": {"type": "CALENDAR", "interval": 1, "unit": "MONTH"},
                "metric_code": "transcription_minutes",
            },
        },
        {
            "feature_code": "retention_days",
            "feature_name": "Retention days",
            # A decimal, as a string — never a JSON number.
            "value": {"type": "CONFIG", "value": {"kind": "NUMBER", "value": "90"}},
        },
    ]


def test_a_session_creates_one_meteroid_customer_and_mints_a_token_bound_to_its_alias() -> None:
    meteroid = fake_meteroid(
        {
            "POST /api/v1/customers": lambda body: {
                **body,
                "id": "cus_1",
                "custom_properties": {},
                "invoicing_entity_id": "ive_1",
            }
        }
    )
    response = send(
        "POST",
        "/api/session",
        body='{"workspace_name":"  Acme  ","email":null}',
        meteroid=meteroid.client,
    )

    assert response.status == 201
    alias = response.body["workspace"]["customer_alias"]
    assert re.fullmatch(r"scribe-demo-[0-9a-f]{32}", alias)
    assert response.body["workspace"] == {
        "id": alias,
        "name": "Acme",
        "customer_id": "cus_1",
        "customer_alias": alias,
        "currency": "USD",
    }
    assert verify(SESSION_SECRET, response.body["session_token"]) == alias
    assert meteroid.bodies[0] == {
        "alias": alias,
        "currency": "USD",
        "custom_taxes": [],
        "invoicing_emails": [f"{alias}@example.invalid"],
        "name": "Acme",
    }


@pytest.mark.parametrize(
    ("upstream_status", "code", "expected"),
    [
        (401, "UPSTREAM_UNAUTHORIZED", 502),
        (403, "UPSTREAM_UNAUTHORIZED", 502),
        (429, "RATE_LIMITED", 429),
        (400, "UPSTREAM_ERROR", 502),
        (500, "UPSTREAM_ERROR", 502),
    ],
)
def test_meteroids_own_failures_map_onto_the_contracts_upstream_codes(
    upstream_status: int, code: str, expected: int
) -> None:
    def handler(_request: httpx.Request) -> httpx.Response:
        return httpx.Response(upstream_status, json={"code": "BAD_REQUEST", "message": "nope"})

    history = send("GET", "/api/transcriptions", headers=HEADERS, meteroid=meteroid_over(handler))
    assert history.status == 200, "history never calls Meteroid"
    assert history.body == {"transcriptions": []}

    failed = send("GET", "/api/entitlements", headers=HEADERS, meteroid=meteroid_over(handler))
    assert failed.status == expected
    assert_error_envelope(failed.body, code)


@pytest.mark.parametrize("body", [b"<html>gateway</html>", b'{"data": "not a list"}', b"[]"])
def test_a_2xx_the_sdk_cannot_decode_is_an_upstream_error_not_a_500(body: bytes) -> None:
    def handler(_request: httpx.Request) -> httpx.Response:
        return httpx.Response(200, content=body)

    response = send("GET", "/api/entitlements", headers=HEADERS, meteroid=meteroid_over(handler))

    assert response.status == 502
    assert_error_envelope(response.body, "UPSTREAM_ERROR")


def test_a_decimal_that_is_not_a_number_is_meteroids_error_not_a_nan_on_the_wire() -> None:
    # The SDK builds `Decimal("NaN")` from this without complaint.
    meteroid = fake_meteroid({ENTITLEMENTS: metered_entitlement("NaN", {})})
    response = send("GET", "/api/entitlements", headers=HEADERS, meteroid=meteroid.client)

    assert response.status == 502
    assert_error_envelope(response.body, "UPSTREAM_ERROR")

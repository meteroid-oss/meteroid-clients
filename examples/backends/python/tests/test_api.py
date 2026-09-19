"""End-to-end checks that need no Meteroid tenant.

Everything reachable without an API key is exercised here against the shapes
``examples/openapi.yaml`` promises: the health probe, the session-token gate, the error
envelope, the 404 fallback, and — the interesting one — webhook signature verification,
which works offline because the SDK ships a *signer* as well as a verifier. The contract
suite uses the same trick to test the receiver for real.
"""

import json
import time
from dataclasses import replace

import pytest

from scribe.http import MAX_BODY_BYTES
from scribe.session import mint
from scribe.state import AppState

from .support import (
    CONFIG,
    SESSION_SECRET,
    assert_error_envelope,
    fake_meteroid,
    send,
    signed,
    state_with,
)


def bearer(alias: str = "scribe-demo-1") -> dict[str, str]:
    return {
        "authorization": f"Bearer {mint(SESSION_SECRET, alias)}",
        "content-type": "application/json",
    }


def test_health_reports_the_backend_and_its_configuration() -> None:
    response = send("GET", "/api/health")

    assert response.status == 200
    assert response.body == {
        "status": "ok",
        "backend": "python",
        "meteroid_configured": False,
        "version": "1.0.0",
    }


def test_a_missing_session_token_is_401_in_the_standard_envelope() -> None:
    response = send("GET", "/api/me")

    assert response.status == 401
    assert_error_envelope(response.body, "UNAUTHORIZED")


def test_a_token_from_another_deployment_is_rejected() -> None:
    forged = mint("some-other-secret", "scribe-demo-1")
    response = send("GET", "/api/me", headers={"authorization": f"Bearer {forged}"})

    assert response.status == 401
    assert_error_envelope(response.body, "UNAUTHORIZED")


@pytest.mark.parametrize(
    "authorization",
    ["Basic abc", f"bearer {mint(SESSION_SECRET, 'a')}", "Bearer ", "Bearer garbage"],
)
def test_an_authorization_header_that_is_not_a_bearer_token_is_rejected(
    authorization: str,
) -> None:
    response = send("GET", "/api/me", headers={"authorization": authorization})

    assert response.status == 401
    assert_error_envelope(response.body, "UNAUTHORIZED")


def test_the_session_token_is_checked_before_the_body_is_looked_at() -> None:
    response = send("POST", "/api/transcriptions", body="{not json")

    assert response.status == 401
    assert_error_envelope(response.body, "UNAUTHORIZED")


@pytest.mark.parametrize("path", ["/api/nope", "/", "/api/health/", "/api/%68ealth"])
def test_an_unknown_route_is_404_in_the_standard_envelope(path: str) -> None:
    response = send("GET", path)

    assert response.status == 404
    assert_error_envelope(response.body, "NOT_FOUND")


def test_a_known_route_with_the_wrong_method_is_a_bare_405_naming_what_is_allowed() -> None:
    wrong = send("DELETE", "/api/health")
    assert wrong.status == 405
    assert wrong.headers["allow"] == "GET,HEAD"
    assert wrong.body is None

    both = send("PUT", "/api/transcriptions")
    assert both.headers["allow"] == "GET,HEAD,POST"


def test_every_answer_carries_permissive_cors_headers_and_options_is_a_preflight() -> None:
    simple = send("GET", "/api/nope")
    assert simple.headers["access-control-allow-origin"] == "*"

    preflight = send(
        "OPTIONS",
        "/api/checkout",
        headers={"origin": "http://localhost:5173", "access-control-request-method": "POST"},
    )
    assert preflight.status == 200
    assert preflight.headers["access-control-allow-origin"] == "*"
    assert preflight.headers["access-control-allow-methods"] == "*"
    assert preflight.headers["access-control-allow-headers"] == "*"


@pytest.mark.parametrize(
    "raw",
    [
        # `duration_seconds` is required, and unknown fields are rejected.
        '{"title":"x","surprise":true}',
        '{"title":"x"}',
        "{not json",
        "[]",
        "null",
        "",
        "   ",
        # Wrong scalar types are type errors, never coerced. `true` is the Python one:
        # `bool` is a subclass of `int`, and must still not be read as 1.
        '{"title":123,"duration_seconds":60}',
        '{"title":"x","duration_seconds":"60"}',
        '{"title":"x","duration_seconds":60.5}',
        '{"title":"x","duration_seconds":true}',
        '{"title":null,"duration_seconds":60}',
        # What `json.loads` accepts and JSON does not.
        '{"title":"x","duration_seconds":NaN}',
        '{"title":"x","duration_seconds":Infinity}',
        '{"title":"x","duration_seconds":1e400}',
        '﻿{"title":"x","duration_seconds":60}',
        # Well-typed, but outside the contract's bounds.
        '{"title":"x","duration_seconds":0}',
        '{"title":"x","duration_seconds":7201}',
        '{"title":"x","duration_seconds":4294967356}',
        '{"title":"   ","duration_seconds":60}',
        '{"title":"' + "x" * 201 + '","duration_seconds":60}',
    ],
)
def test_a_malformed_body_is_400_in_the_standard_envelope(raw: str) -> None:
    meteroid = fake_meteroid()
    response = send(
        "POST", "/api/transcriptions", headers=bearer(), body=raw, meteroid=meteroid.client
    )

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert meteroid.calls == [], f"Meteroid was called for {raw}"


@pytest.mark.parametrize("spelling", ["60.0", "6e1", "6.0E+1"])
def test_an_integer_is_an_integer_however_it_is_spelled(spelling: str) -> None:
    # JSON Schema's reading of `type: integer`, and the TypeScript backend's. It gets as
    # far as Meteroid (a 404 here, hence the 502), and is echoed back as `60`.
    meteroid = fake_meteroid()
    response = send(
        "POST",
        "/api/transcriptions",
        headers=bearer(),
        body=f'{{"title":"x","duration_seconds":{spelling}}}',
        meteroid=meteroid.client,
    )

    assert response.status == 502
    assert meteroid.calls == ["GET /api/v1/customers/scribe-demo-1/entitlements"]


def test_a_body_that_is_not_valid_utf8_is_400_not_a_replacement_character() -> None:
    response = send("POST", "/api/session", body=bytes([0x7B, 0x22, 0xFF, 0x22, 0x3A, 0x31, 0x7D]))

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")


@pytest.mark.parametrize(
    "raw",
    ['{"nope":1}', '{"workspace_name":123}', '{"workspace_name":"  "}', '{"email":false}', "[]"],
)
def test_an_optional_body_rejects_what_it_does_not_declare(raw: str) -> None:
    meteroid = fake_meteroid()
    response = send("POST", "/api/session", body=raw, meteroid=meteroid.client)

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert meteroid.calls == []


def test_a_plan_code_outside_the_contract_enum_is_rejected_before_the_catalog() -> None:
    meteroid = fake_meteroid()
    response = send(
        "POST",
        "/api/checkout",
        headers=bearer(),
        body='{"plan_code":"gold"}',
        meteroid=meteroid.client,
    )

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert meteroid.calls == []


@pytest.mark.parametrize(
    "raw",
    [
        '{"expires_in_seconds":5}',
        '{"expires_in_seconds":2592001}',
        '{"expires_in_seconds":"60"}',
        '{"expires_in_seconds":true}',
    ],
)
def test_an_out_of_range_portal_lifetime_is_rejected_before_meteroid_sees_it(raw: str) -> None:
    meteroid = fake_meteroid()
    response = send(
        "POST", "/api/portal-session", headers=bearer(), body=raw, meteroid=meteroid.client
    )

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert meteroid.calls == []


@pytest.mark.parametrize(
    "query",
    [
        "limit=0",
        "limit=101",
        "limit=abc",
        "limit=",
        "limit=1.5",
        "limit=٣",
        "foo=1",
        "limit=1&limit=2",
    ],
)
def test_an_invalid_invoice_limit_is_rejected_before_meteroid_sees_it(query: str) -> None:
    meteroid = fake_meteroid()
    response = send("GET", f"/api/invoices?{query}", headers=bearer(), meteroid=meteroid.client)

    assert response.status == 400
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert meteroid.calls == []


def test_an_oversized_body_is_refused_in_the_standard_envelope() -> None:
    response = send("POST", "/api/session", body=None)

    assert response.status == 413
    assert_error_envelope(response.body, "BAD_REQUEST")
    assert response.body["message"] == f"The request body exceeds the {MAX_BODY_BYTES}-byte limit."
    assert MAX_BODY_BYTES == 2_097_152


def test_an_unreachable_meteroid_is_502_not_a_crash() -> None:
    # No fake here: the real client, pointed at a port nothing listens on.
    state = AppState(replace(CONFIG, meteroid_base_url="http://127.0.0.1:9"))
    response = send("GET", "/api/plans", state=state)

    assert response.status == 502
    assert_error_envelope(response.body, "UPSTREAM_ERROR")


# ---------------------------------------------------------------- webhooks

WEBHOOKS = "/api/webhooks/meteroid"


def test_a_correctly_signed_event_is_accepted() -> None:
    payload = json.dumps(
        {"id": "evt_123", "type": "invoice.paid", "timestamp": "2026-09-01T12:00:00Z"}
    )
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_1"), body=payload)

    assert response.status == 202
    assert response.body == {
        "received": True,
        "event_id": "evt_123",
        "type": "invoice.paid",
        "handled": True,
    }


def test_the_raw_bytes_are_verified_not_a_reserialization_of_them() -> None:
    # Spacing and key order no JSON serializer would reproduce.
    payload = '{ "type" : "invoice.paid",\n\t"id":"evt_raw"   }'
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_raw"), body=payload)

    assert response.status == 202
    assert response.body["event_id"] == "evt_raw"


def test_an_unknown_event_type_is_acknowledged_not_rejected() -> None:
    # A receiver that 400s on an unrecognized type breaks the first time Meteroid ships a
    # new one — so this must be a 202 with `handled: false`. The body also carries no
    # `timestamp`, which must not matter either.
    payload = json.dumps({"id": "evt_9", "type": "something.invented.later"})
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_9"), body=payload)

    assert response.status == 202
    assert response.body["handled"] is False
    assert response.body["event_id"] == "evt_9"


@pytest.mark.parametrize("payload", ["[1,2]", '{"id":7,"type":["x"]}', '"just a string"'])
def test_a_signed_body_of_an_unexpected_shape_is_acknowledged_too(payload: str) -> None:
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_shape"), body=payload)

    assert response.status == 202
    assert response.body == {
        "received": True,
        "event_id": "msg_shape",
        "type": None,
        "handled": False,
    }


def test_an_event_with_no_id_falls_back_to_the_webhook_id_header() -> None:
    payload = json.dumps({"type": "subscription.created"})
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_42"), body=payload)

    assert response.status == 202
    assert response.body["event_id"] == "msg_42"
    assert response.body["handled"] is True


def test_svix_headers_are_accepted_as_aliases() -> None:
    payload = json.dumps({"type": "invoice.finalized"})
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_s", "svix"), body=payload)

    assert response.status == 202
    # The id fallback has to follow the alias as well.
    assert response.body["event_id"] == "msg_s"


def test_a_body_that_does_not_match_its_signature_is_rejected() -> None:
    payload = json.dumps({"id": "evt_1", "type": "invoice.paid"})
    response = send(
        "POST",
        WEBHOOKS,
        headers=signed(payload, "msg_1"),
        # One field different from what was signed.
        body=json.dumps({"id": "evt_1", "type": "invoice.void"}),
    )

    assert response.status == 400
    assert_error_envelope(response.body, "WEBHOOK_SIGNATURE_INVALID")


def test_a_stale_timestamp_is_rejected() -> None:
    payload = json.dumps({"type": "invoice.paid"})
    headers = signed(payload, "msg_old")
    headers["webhook-timestamp"] = str(int(time.time()) - 3600)
    response = send("POST", WEBHOOKS, headers=headers, body=payload)

    assert response.status == 400
    assert_error_envelope(response.body, "WEBHOOK_SIGNATURE_INVALID")


def test_an_unsigned_event_is_rejected() -> None:
    response = send(
        "POST",
        WEBHOOKS,
        headers={"content-type": "application/json"},
        body='{"type":"invoice.paid"}',
    )

    assert response.status == 400
    assert_error_envelope(response.body, "WEBHOOK_SIGNATURE_INVALID")


@pytest.mark.parametrize("payload", [b"not json", b"", b'{"type":NaN}', b'{"type":"\xff"}'])
def test_a_correctly_signed_body_that_is_not_json_is_rejected(payload: bytes) -> None:
    response = send("POST", WEBHOOKS, headers=signed(payload, "msg_nj"), body=payload)

    assert response.status == 400
    assert_error_envelope(response.body, "WEBHOOK_SIGNATURE_INVALID")


def test_a_missing_webhook_secret_is_the_operators_problem_not_a_bad_signature() -> None:
    response = send("POST", WEBHOOKS, state=state_with(meteroid_webhook_secret=""), body="{}")

    assert response.status == 500
    assert_error_envelope(response.body, "INTERNAL")


def test_a_webhook_secret_that_is_not_base64_never_verifies_anything() -> None:
    payload = "{}"
    response = send(
        "POST",
        WEBHOOKS,
        state=state_with(meteroid_webhook_secret="whsec_abc"),
        headers=signed(payload, "msg_1"),
        body=payload,
    )

    assert response.status == 400
    assert_error_envelope(response.body, "WEBHOOK_SIGNATURE_INVALID")

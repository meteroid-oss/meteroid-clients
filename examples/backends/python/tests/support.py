"""Shared fixtures for the offline tests.

Nothing here opens a socket. The router is a pure function, so the tests call it
directly; and the SDK takes a custom ``httpx`` client, so "Meteroid" is an
``httpx.MockTransport`` that either answers from a table or reports, in ``calls``, that
it was reached at all.
"""

from __future__ import annotations

import asyncio
import json
import time
from collections.abc import Callable, Mapping
from dataclasses import dataclass, field, replace
from typing import Any
from urllib.parse import parse_qsl, urlsplit

import httpx
from meteroid import MeteroidAsync, MeteroidOptions, Webhook
from meteroid.models import Currency

from scribe.app import router
from scribe.config import Config
from scribe.http import ScribeRequest
from scribe.state import AppState

# Any base64 string is a valid Standard Webhooks secret.
WEBHOOK_SECRET = "c2NyaWJlLWRlbW8td2ViaG9vay1zZWNyZXQ="
SESSION_SECRET = "test-session-secret"

CONFIG = Config(
    # No API key: every Meteroid-backed operation is out of scope unless a test stubs it.
    meteroid_api_key="",
    meteroid_base_url="http://meteroid.invalid",
    meteroid_webhook_secret=WEBHOOK_SECRET,
    session_secret=SESSION_SECRET,
    default_currency=Currency.USD,
    port=0,
)

# One stubbed Meteroid answer: a JSON body, or a function of the request body producing one.
Stub = Any | Callable[[Any], Any]


@dataclass
class FakeMeteroid:
    client: MeteroidAsync
    # Every request the SDK made, as `"METHOD /path"`.
    calls: list[str] = field(default_factory=list)
    # The parsed JSON body of each request, in the same order.
    bodies: list[Any] = field(default_factory=list)


def meteroid_over(handler: Callable[[httpx.Request], httpx.Response]) -> MeteroidAsync:
    """The real SDK client, with `handler` where the network would be."""
    return MeteroidAsync(
        "test-key",
        MeteroidOptions(server_url="http://meteroid.test", num_retries=0),
        httpx.AsyncClient(transport=httpx.MockTransport(handler)),
    )


def fake_meteroid(routes: Mapping[str, Stub] | None = None) -> FakeMeteroid:
    """A Meteroid client that answers from `routes` (keyed `"METHOD /path"`). A request
    with no stub is a `404` in Meteroid's own error envelope.
    """
    stubs = dict(routes or {})

    def handler(request: httpx.Request) -> httpx.Response:
        key = f"{request.method} {request.url.path}"
        body = json.loads(request.content) if request.content else None
        fake.calls.append(key)
        fake.bodies.append(body)

        if key not in stubs:
            return httpx.Response(404, json={"code": "NOT_FOUND", "message": f"no stub for {key}"})
        stub = stubs[key]
        return httpx.Response(200, json=stub(body) if callable(stub) else stub)

    fake = FakeMeteroid(client=meteroid_over(handler))
    return fake


@dataclass
class TestResponse:
    __test__ = False

    status: int
    headers: dict[str, str]
    # `Any` on purpose: the tests index into whatever shape the operation answers with.
    body: Any


def state_with(meteroid: MeteroidAsync | None = None, **overrides: Any) -> AppState:
    return AppState(replace(CONFIG, **overrides), meteroid or fake_meteroid().client)


def send(
    method: str,
    target: str,
    *,
    headers: Mapping[str, str] | None = None,
    body: str | bytes | None = "",
    meteroid: MeteroidAsync | None = None,
    state: AppState | None = None,
) -> TestResponse:
    """Drive the router in-process. `body=None` is how `http.py` reports a body it
    stopped buffering at the limit.
    """
    url = urlsplit(target)
    request = ScribeRequest(
        method=method,
        path=url.path,
        query=parse_qsl(url.query, keep_blank_values=True),
        headers=dict(headers or {}),
        body=body.encode() if isinstance(body, str) else body,
    )
    response = asyncio.run(router(state or state_with(meteroid))(request))
    return TestResponse(
        status=response.status,
        headers=response.headers,
        body=json.loads(response.body) if response.body else None,
    )


def assert_error_envelope(body: Any, code: str) -> None:
    """Every error in the contract is the same envelope, with `quota` and
    `upgrade_plan_code` always present — never absent, `null` when they do not apply.
    """
    assert isinstance(body, dict), body
    assert sorted(body) == ["code", "message", "quota", "upgrade_plan_code"]
    assert body["code"] == code, body
    assert isinstance(body["message"], str)


def signed(payload: str | bytes, msg_id: str, prefix: str = "webhook") -> dict[str, str]:
    """Sign a payload exactly the way Meteroid does, using the SDK's own signer."""
    now = int(time.time())
    return {
        "content-type": "application/json",
        f"{prefix}-id": msg_id,
        f"{prefix}-timestamp": str(now),
        f"{prefix}-signature": Webhook(WEBHOOK_SECRET).sign(msg_id, now, payload),
    }

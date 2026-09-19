"""The router: twelve operations, one table.

:func:`router` is a pure function from request to response — no socket, no global
state — so ``__main__.py`` can put it on a port and the tests can call it directly.
"""

import json
from typing import Any

from . import log
from .error import ApiError
from .http import Handle, ScribeRequest, ScribeResponse
from .routes import Handler, not_found
from .routes.checkout import create_checkout
from .routes.entitlements import list_entitlements
from .routes.health import get_health
from .routes.invoices import list_invoices
from .routes.plans import list_plans
from .routes.portal import create_portal_session
from .routes.session import create_session, get_me
from .routes.transcriptions import create_transcription, list_transcriptions
from .routes.usage import get_usage
from .routes.webhooks import receive_webhook
from .state import AppState

ROUTES: dict[str, dict[str, Handler]] = {
    "/api/health": {"GET": get_health},
    "/api/session": {"POST": create_session},
    "/api/me": {"GET": get_me},
    "/api/plans": {"GET": list_plans},
    "/api/checkout": {"POST": create_checkout},
    "/api/entitlements": {"GET": list_entitlements},
    "/api/transcriptions": {"GET": list_transcriptions, "POST": create_transcription},
    "/api/usage": {"GET": get_usage},
    "/api/portal-session": {"POST": create_portal_session},
    "/api/invoices": {"GET": list_invoices},
    "/api/webhooks/meteroid": {"POST": receive_webhook},
}

# The SPA is served from its own origin (the Vite dev server), so it needs CORS.
# Permissive is fine for a demo; a real backend would name its origins.
_VARY = {"vary": "origin, access-control-request-method, access-control-request-headers"}
_CORS = {**_VARY, "access-control-allow-origin": "*", "access-control-expose-headers": "*"}
_PREFLIGHT = {
    **_VARY,
    "access-control-allow-origin": "*",
    "access-control-allow-methods": "*",
    "access-control-allow-headers": "*",
}


def router(state: AppState) -> Handle:
    async def handle(request: ScribeRequest) -> ScribeResponse:
        route = ROUTES.get(request.path)
        allow = route and ",".join("GET,HEAD" if method == "GET" else method for method in route)

        # Every OPTIONS is answered as a preflight, whether or not the path exists: the
        # browser only wants to know it may send the real request.
        if request.method == "OPTIONS":
            return ScribeResponse(200, {**_PREFLIGHT, **({"allow": allow} if allow else {})}, b"")

        # HEAD is GET without the body; `http.py` drops the body on the way out.
        method = "GET" if request.method == "HEAD" else request.method
        handler = route.get(method) if route else None

        # A known path with the wrong method. There is no error code for it in the
        # contract, so it is the bare `405` + `Allow` that HTTP itself specifies.
        if allow and handler is None:
            return ScribeResponse(405, {**_CORS, "allow": allow}, b"")

        status, body = await _run(state, request, handler)
        return ScribeResponse(
            status,
            {**_CORS, "content-type": "application/json"},
            # Compact and unescaped, which is what the other backends' serializers emit.
            json.dumps(body, ensure_ascii=False, separators=(",", ":")).encode(),
        )

    return handle


async def _run(state: AppState, request: ScribeRequest, handler: Handler | None) -> tuple[int, Any]:
    """Run one handler; whatever goes wrong comes back as the contract's error envelope."""
    try:
        if handler is None:
            raise not_found()
        reply = await handler(state, request)
        return reply.status, reply.body
    except ApiError as err:
        if err.code == "INTERNAL":
            log.error(f"internal error: {err.message}")
        return err.status, err.to_json()
    except Exception as err:
        # A bug in this backend. The detail goes to the log, never to the client.
        log.error(f"unhandled error in {request.method} {request.path}: {err!r}")
        internal = ApiError.internal("Unexpected error handling the request.")
        return internal.status, internal.to_json()

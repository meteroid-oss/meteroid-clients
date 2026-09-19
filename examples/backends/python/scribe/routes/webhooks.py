"""`POST /api/webhooks/meteroid` — the signed webhook receiver."""

from meteroid import Webhook, WebhookVerificationError

from .. import log
from ..dto import WebhookAck
from ..error import ApiError
from ..http import Reply, ScribeRequest, accepted, raw_body
from ..state import AppState
from . import parse_json


async def receive_webhook(state: AppState, request: ScribeRequest) -> Reply[WebhookAck]:
    """Verify the Standard Webhooks signature over the **raw** request body, then act on
    what the demo recognizes and acknowledge the rest.

    Two rules matter more than anything else here:

    1. **Verify the raw bytes.** `raw_body(request)` is the exact payload Meteroid
       signed. Parsing the JSON and re-serializing it before verifying is the classic
       bug — any difference in key order or spacing breaks the signature. It is also why
       this backend has no body-parsing middleware for one to forget to turn off.
    2. **Never reject a correctly signed body for its shape.** Meteroid owns the event
       envelope and adds event types over time; a receiver that 400s on an unknown type
       breaks the first time the sender ships a new one. `400` is for a bad signature
       and for a body that is not JSON at all — nothing else.
    """
    secret = state.config.meteroid_webhook_secret
    if secret == "":
        # An operator problem, not a caller problem: never report it as a bad signature.
        raise ApiError.internal(
            "METEROID_WEBHOOK_SECRET is not set, so inbound webhooks cannot be verified. "
            "Copy the signing secret from your Meteroid webhook endpoint (examples/CATALOG.md)."
        )

    # The SDK accepts both `webhook-*` and `svix-*` headers and enforces the five-minute
    # timestamp tolerance itself.
    body = raw_body(request)
    try:
        Webhook(secret).verify(body, request.headers)
    # `ValueError` is the constructor's: a secret that is not base64 is reported the
    # way the other backends report it, as a verification failure.
    except (WebhookVerificationError, ValueError) as exc:
        raise ApiError(
            "WEBHOOK_SIGNATURE_INVALID", f"Webhook signature verification failed: {exc}"
        ) from exc

    # `verify` only verifies; what it verified is still bytes.
    try:
        event = parse_json(body)
    except ValueError as exc:
        raise ApiError(
            "WEBHOOK_SIGNATURE_INVALID", f"Webhook body is signed but is not JSON: {exc}"
        ) from exc

    def field(name: str) -> str | None:
        value = event.get(name) if isinstance(event, dict) else None
        return value if isinstance(value, str) else None

    event_type = field("type")
    # `webhook-id` is required and verification just passed, so there is always something
    # to echo.
    event_id = field("id")
    if event_id is None:
        event_id = request.headers.get("webhook-id", request.headers.get("svix-id", ""))

    # The demo "handles" invoice and subscription events by logging them; the frontend
    # shows the last few in its activity feed. Everything else is acknowledged, ignored,
    # and explicitly reported as unhandled.
    handled = event_type is not None and event_type.startswith(("invoice.", "subscription."))
    if handled:
        log.info(f"meteroid webhook handled event_id={event_id} event_type={event_type}")

    # 202: the signature verified and the body was accepted. Whether the demo understood
    # the event is what `handled` reports.
    return accepted(
        {"received": True, "event_id": event_id, "type": event_type, "handled": handled}
    )

"""`GET /api/entitlements` — the normalized entitlement view the SPA gates on."""

from ..dto import EntitlementListResponse
from ..entitlements import fetch_entitlements, normalize_entitlement
from ..http import Reply, ScribeRequest, ok
from ..session import require_session
from ..state import AppState


async def list_entitlements(
    state: AppState, request: ScribeRequest
) -> Reply[EntitlementListResponse]:
    """One Meteroid call, then a straight projection. The list may legitimately be empty
    for a workspace that has never subscribed and has no feature-level defaults — that is
    not an error, and it is why the demo checks the *features* exist at startup instead
    of inferring "unseeded tenant" from an empty list here.
    """
    session = require_session(state, request)

    effective = await fetch_entitlements(state, session.customer_alias)

    # Sequentially, so a cold metric cache is refreshed once rather than once per entry.
    entitlements = [await normalize_entitlement(state, entitlement) for entitlement in effective]

    return ok({"entitlements": entitlements})

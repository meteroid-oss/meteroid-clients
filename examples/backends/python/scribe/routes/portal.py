"""`POST /api/portal-session` — mint a Meteroid customer-portal token."""

from meteroid.models import CustomerPortalTokenRequest

from ..dto import CreatePortalSessionResponse, decode_create_portal_session_request
from ..error import ApiError, upstream
from ..http import Reply, ScribeRequest, created
from ..session import require_session
from ..state import AppState
from . import optional_json_body

# Meteroid's default lifetime, in seconds.
_DEFAULT_EXPIRY = 86_400
_MIN_EXPIRY = 60
_MAX_EXPIRY = 2_592_000


async def create_portal_session(
    state: AppState, request: ScribeRequest
) -> Reply[CreatePortalSessionResponse]:
    """The portal is where the visitor manages their payment method and downloads
    invoices, so the demo does not have to implement any of it. The frontend opens
    `portal_url` with the `token`.
    """
    session = require_session(state, request)
    body = optional_json_body(request, decode_create_portal_session_request)

    # Meteroid documents 60..2592000 but types the field as a plain int32, so the range
    # is validated here rather than forwarding a value Meteroid would reject.
    expires_in_seconds = (
        _DEFAULT_EXPIRY if body.expires_in_seconds is None else body.expires_in_seconds
    )
    if not _MIN_EXPIRY <= expires_in_seconds <= _MAX_EXPIRY:
        raise ApiError.bad_request(
            f"expires_in_seconds must be between {_MIN_EXPIRY} and {_MAX_EXPIRY}."
        )

    with upstream(f"POST /api/v1/customers/{session.customer_alias}/portal-token"):
        portal = await state.meteroid.customers.create_portal_token(
            session.customer_alias,
            CustomerPortalTokenRequest(expires_in_seconds=expires_in_seconds),
        )

    return created(
        {
            "portal_url": portal.portal_url,
            "token": portal.token,
            # Meteroid returns only `{ token, portal_url }`, so this echoes what was asked
            # for rather than pretending to read it back out of the JWT.
            "expires_in_seconds": expires_in_seconds,
        }
    )

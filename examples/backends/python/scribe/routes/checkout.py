"""`POST /api/checkout` — start a hosted Meteroid checkout for a plan."""

from meteroid.models import CreateCheckoutSessionRequest

from ..dto import CreateCheckoutResponse, decode_create_checkout_request, timestamp_opt
from ..error import ApiError, upstream
from ..http import Reply, ScribeRequest, created
from ..session import require_session
from ..state import AppState
from . import bounded, json_body


async def create_checkout(state: AppState, request: ScribeRequest) -> Reply[CreateCheckoutResponse]:
    """Used both for the first subscription and for upgrades — Meteroid decides which by
    looking at what the customer already has, and reports it back as `checkout_type`.
    """
    session = require_session(state, request)
    body = json_body(request, decode_create_checkout_request)
    coupon_code = None if body.coupon_code is None else bounded("coupon_code", body.coupon_code, 64)

    # Which plan version to check out against comes from the seeded catalog; if the plan
    # is missing this fails with CATALOG_NOT_SEEDED naming the plan.
    catalog = await state.catalog()
    plan = catalog.plan(body.plan_code)

    with upstream("POST /api/v1/checkout-sessions"):
        response = await state.meteroid.checkout_sessions.create_checkout_session(
            CreateCheckoutSessionRequest(
                # `customer_id` takes a Meteroid id *or* an external alias.
                customer_id=session.customer_alias,
                plan_version_id=plan["plan_version_id"],
                coupon_code=coupon_code,
            )
        )

    checkout = response.session

    # Meteroid may legitimately return a session with no hosted URL (non-self-serve
    # checkout types). That is unusable for this demo, so it becomes an explicit error
    # rather than a null the frontend has to guess about.
    if checkout.checkout_url is None:
        raise ApiError(
            "CHECKOUT_UNAVAILABLE",
            "Meteroid returned a checkout session without a hosted URL "
            f"(checkout_type={checkout.checkout_type.value}).",
        )

    return created(
        {
            "checkout_url": checkout.checkout_url,
            "checkout_session_id": checkout.id,
            "plan_code": body.plan_code,
            "plan_version_id": checkout.plan_version_id,
            "expires_at": timestamp_opt(checkout.expires_at),
        }
    )

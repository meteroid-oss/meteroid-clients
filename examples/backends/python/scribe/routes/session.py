"""`POST /api/session` and `GET /api/me` — the demo workspace and what it is subscribed to."""

import uuid

from meteroid.models import CustomerCreateRequest
from meteroid.models import Subscription as SdkSubscription

from ..dto import (
    CreateSessionResponse,
    MeResponse,
    Plan,
    PlanCode,
    Subscription,
    decode_create_session_request,
    timestamp,
)
from ..error import upstream
from ..http import Reply, ScribeRequest, created, ok
from ..session import mint, require_session
from ..state import AppState
from ..workspace import current_subscription, load_customer, to_workspace
from . import bounded, optional_json_body


async def create_session(state: AppState, request: ScribeRequest) -> Reply[CreateSessionResponse]:
    """Create a brand-new Meteroid customer and hand back a session token bound to it.

    This is the only object the demo ever creates in Meteroid. The catalog is seeded
    once, by hand (`examples/CATALOG.md`); customers are per demo run and disposable.
    """
    body = optional_json_body(request, decode_create_session_request)

    # A short random alias is the workspace's identity everywhere: it is what the
    # session token carries, what ingested events reference, and what every
    # `id_or_alias` parameter below receives.
    alias = f"scribe-demo-{uuid.uuid4().hex}"
    name = (
        "Scribe demo workspace"
        if body.workspace_name is None
        else bounded("workspace_name", body.workspace_name, 120)
    )
    email = f"{alias}@example.invalid" if body.email is None else bounded("email", body.email, 254)

    with upstream("POST /api/v1/customers"):
        customer = await state.meteroid.customers.create_customer(
            CustomerCreateRequest(
                alias=alias,
                # Meteroid requires all four of these. The currency must match the seeded
                # plans' currency or checkout will refuse the plan version later on.
                currency=state.config.default_currency,
                custom_taxes=[],
                invoicing_emails=[email],
                name=name,
            )
        )

    return created(
        {
            "session_token": mint(state.config.session_secret, alias),
            "workspace": to_workspace(customer, alias),
        }
    )


async def get_me(state: AppState, request: ScribeRequest) -> Reply[MeResponse]:
    """The current workspace, its subscription, and the plan that subscription is on."""
    alias = require_session(state, request).customer_alias

    customer = await load_customer(state, alias)
    subscription = await current_subscription(state, alias)

    # The plan is only looked up when there is a subscription to look it up for, so a
    # never-subscribed workspace works even before the catalog is reachable.
    projected: Subscription | None = None
    plan: Plan | None = None
    if subscription is not None:
        catalog = await state.catalog()
        plan_code = catalog.plan_code_for(subscription.plan_id, subscription.plan_name)
        projected = project_subscription(subscription, plan_code)
        plan = None if plan_code is None else catalog.plan(plan_code)

    return ok({"workspace": to_workspace(customer, alias), "subscription": projected, "plan": plan})


def project_subscription(subscription: SdkSubscription, plan_code: PlanCode | None) -> Subscription:
    """Every field is a 1:1 projection of a Meteroid field — nothing is derived, so the
    demo's view and Meteroid's can never drift. In particular `trial_duration_days` is
    Meteroid's `trial_duration`, not a computed trial end date.
    """
    return {
        "id": subscription.id,
        "status": subscription.status.value,
        "plan_code": plan_code,
        "plan_name": subscription.plan_name,
        "plan_version_id": subscription.plan_version_id,
        "currency": subscription.currency.value,
        "current_period_start": subscription.current_period_start,
        "current_period_end": subscription.current_period_end,
        "trial_duration_days": subscription.trial_duration,
        "created_at": timestamp(subscription.created_at),
    }

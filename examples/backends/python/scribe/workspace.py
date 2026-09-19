"""Per-workspace Meteroid lookups shared by several handlers.

A "workspace" is one Meteroid **customer**. The demo addresses it everywhere by its
*alias* (``scribe-demo-…``), never by the Meteroid id: every Meteroid endpoint the demo
touches accepts an id or an alias, which is the point being demonstrated — you can
drive Meteroid entirely from your own identifiers.
"""

from meteroid.models import Customer, Subscription, SubscriptionStatusEnum

from .dto import PlanCode, Workspace, next_up
from .error import ApiError, upstream
from .state import AppState

# Statuses that count as "the subscription this workspace is living on right now".
_LIVE_STATUSES = (SubscriptionStatusEnum.ACTIVE, SubscriptionStatusEnum.TRIAL_ACTIVE)


async def load_customer(state: AppState, alias: str) -> Customer:
    with upstream(f"GET /api/v1/customers/{alias}"):
        return await state.meteroid.customers.get_customer(alias)


async def current_subscription(state: AppState, alias: str) -> Subscription | None:
    """The workspace's most relevant subscription, or `None` if it has never checked out.

    The contract pins the rule down so every backend picks the same one: ask Meteroid for
    the customer's subscriptions newest-first, take the first `ACTIVE` or `TRIAL_ACTIVE`
    one, and otherwise the most recently created regardless of status.
    """
    # `customer_id` accepts a Meteroid id *or* an external alias, so no id lookup first.
    with upstream("GET /api/v1/subscriptions"):
        response = await state.meteroid.subscriptions.list_subscriptions(
            customer_id=alias, order_by="created_at.desc", per_page=100
        )

    subscriptions = response.data
    live = (subscription for subscription in subscriptions if subscription.status in _LIVE_STATUSES)
    return next(live, subscriptions[0] if subscriptions else None)


def to_workspace(customer: Customer, fallback_alias: str) -> Workspace:
    """Project a Meteroid customer onto the contract's `Workspace`.

    Note there is no `created_at`: Meteroid's `Customer` carries no creation timestamp,
    so the contract does not pretend it does.
    """
    alias = customer.alias if customer.alias is not None else fallback_alias

    return {
        "id": alias,
        "name": customer.name,
        "customer_id": customer.id,
        "customer_alias": alias,
        "currency": customer.currency.value,
    }


async def upgrade_target(state: AppState, alias: str) -> PlanCode | None:
    """The plan to offer when a workspace hits a wall (`402` / `403`).

    One plan up from where it is now: `pro` for an unsubscribed workspace or one on a
    plan outside the Scribe catalog, `scale` for a `pro` workspace, and `None` on `scale`
    — there is nothing left to sell. Never raises: this decorates an error response, and
    a failed lookup here must not replace the error the caller actually hit.
    """
    try:
        subscription = await current_subscription(state, alias)
    except ApiError:
        subscription = None
    if subscription is None:
        return "pro"

    try:
        catalog = await state.catalog()
    except ApiError:
        return None
    current = catalog.plan_code_for(subscription.plan_id, subscription.plan_name)
    return "pro" if current is None else next_up(current)

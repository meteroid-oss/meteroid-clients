"""`GET /api/usage` — current-period usage, straight from Meteroid."""

from datetime import UTC, datetime
from typing import Literal

from meteroid.models import UsageResponse as SdkUsageResponse

from ..decimals import render
from ..dto import UsageResponse
from ..error import upstream
from ..http import Reply, ScribeRequest, ok
from ..session import require_session
from ..state import AppState
from ..workspace import current_subscription


async def get_usage(state: AppState, request: ScribeRequest) -> Reply[UsageResponse]:
    """Two Meteroid endpoints, chosen by whether the workspace has a subscription, and the
    choice is reported back in `scope` so the frontend can label the period honestly.
    """
    alias = require_session(state, request).customer_alias
    subscription = await current_subscription(state, alias)

    # Subscription scope: omitting start_date/end_date makes Meteroid use the
    # subscription's own billing period, so the numbers line up with the invoice.
    if subscription is not None:
        with upstream(f"GET /api/v1/usage/subscription/{subscription.id}"):
            usage = await state.meteroid.usage.get_subscription_usage(subscription.id)
        return ok(_project("subscription", usage))

    # Customer scope: this endpoint *requires* a date range, and with no subscription
    # there is no billing period to borrow. The demo supplies the current UTC calendar
    # month — a demo convention, not a billing period.
    today = datetime.now(UTC).date()
    with upstream(f"GET /api/v1/usage/customer/{alias}"):
        usage = await state.meteroid.usage.get_customer_usage(
            alias, start_date=today.replace(day=1).isoformat(), end_date=today.isoformat()
        )
    return ok(_project("customer", usage))


def _project(scope: Literal["subscription", "customer"], usage: SdkUsageResponse) -> UsageResponse:
    return {
        "period_start": usage.period_start,
        "period_end": usage.period_end,
        "scope": scope,
        # Meteroid also returns `metric_id`; the demo drops it because `metric_code` is
        # the stable identifier application code uses.
        "metrics": [
            {
                "metric_code": metric.metric_code,
                "metric_name": metric.metric_name,
                # Decimals stay strings all the way to the client.
                "total_value": render(metric.total_value),
                "grouped_usage": [
                    {"dimensions": group.dimensions, "value": render(group.value)}
                    for group in metric.grouped_usage
                ],
            }
            for metric in usage.usage
        ],
    }

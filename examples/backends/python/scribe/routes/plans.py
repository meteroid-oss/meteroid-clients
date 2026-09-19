"""`GET /api/plans` — the pricing table, straight from the seeded Meteroid catalog."""

from ..dto import PlanListResponse
from ..http import Reply, ScribeRequest, ok
from ..state import AppState


async def list_plans(state: AppState, _request: ScribeRequest) -> Reply[PlanListResponse]:
    """Unauthenticated: the pricing page is public.

    All the work happens in `catalog.py`, which resolves each plan by its exact seeded
    name, flattens its price components and turns the plan version's entitlements into
    marketing bullets. The result is cached for the life of the process.
    """
    catalog = await state.catalog()

    return ok({"plans": [*catalog.plans]})

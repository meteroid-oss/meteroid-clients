/** `GET /api/plans` — the pricing table, straight from the seeded Meteroid catalog. */

import type { PlanListResponse } from "../dto.js";
import { ok, type Reply } from "../http.js";
import type { AppState } from "../state.js";

/**
 * Unauthenticated: the pricing page is public.
 *
 * All the work happens in `catalog.ts`, which resolves each plan by its exact seeded
 * name, flattens its price components and turns the plan version's entitlements into
 * marketing bullets. The result is cached for the life of the process.
 */
export async function listPlans(state: AppState): Promise<Reply<PlanListResponse>> {
  const catalog = await state.catalog();

  return ok({ plans: [...catalog.plans] });
}

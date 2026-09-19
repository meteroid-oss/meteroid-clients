/**
 * The pricing table, fetched once per run.
 *
 * Several tests need a `plan_version_id` or a plan's currency; refetching the catalog in
 * each of them would add Meteroid round trips to every file for data that cannot change
 * mid-run (the catalog is seeded out of band and the demo never writes to it).
 */

import { api } from './api.js';
import { expectStatus } from './assert.js';
import type { Plan, PlanCode, PlanListResponse } from './types.js';

let plansPromise: Promise<Plan[]> | undefined;

export function plans(): Promise<Plan[]> {
  plansPromise ??= api.listPlans().then((response) => {
    if (response.status === 503) {
      const body = response.body as { message?: string };
      throw new Error(
        `GET /api/plans returned 503 CATALOG_NOT_SEEDED: ${body.message}\n` +
          `Seed the catalog once, by hand, per examples/CATALOG.md.`,
      );
    }
    return expectStatus<PlanListResponse>(response, 200).plans;
  });
  return plansPromise;
}

export async function planByCode(code: PlanCode): Promise<Plan | undefined> {
  return (await plans()).find((plan) => plan.code === code);
}

/** One step up the `free` → `pro` → `scale` ladder the contract fixes for upsells. */
export function nextPlanUp(current: PlanCode | null): PlanCode | null {
  switch (current) {
    case 'free':
      return 'pro';
    case 'pro':
      return 'scale';
    case 'scale':
      return null;
    default:
      // No subscription, or a plan outside the Scribe catalog.
      return 'pro';
  }
}

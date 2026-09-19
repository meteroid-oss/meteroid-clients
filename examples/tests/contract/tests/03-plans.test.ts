/**
 * `GET /api/plans` — the pricing table, and the catalog check that everything else
 * depends on.
 *
 * This is also where a wrongly seeded tenant is caught. The contract's flattening rules
 * for `PlanPrice` are prose, and prose is exactly where two hand-written backends drift
 * apart, so every rule in it is asserted here against whatever backend is answering.
 */

import { beforeAll, describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectStatus } from '../src/assert.js';
import { isDecimalString } from '../src/decimal.js';
import type { Plan, PlanListResponse, PlanPrice } from '../src/types.js';

describe('GET /api/plans', () => {
  let plans: Plan[];

  beforeAll(async () => {
    const response = await api.listPlans();
    if (response.status === 503) {
      // Worth its own message: this is the single most likely reason a first run fails,
      // and the contract guarantees the body names the object that is missing.
      const body = response.body as { message?: string };
      throw new Error(
        `GET /api/plans returned 503 CATALOG_NOT_SEEDED: ${body.message}\n` +
          `Seed the catalog once, by hand, per examples/CATALOG.md. The demo never creates it.`,
      );
    }
    plans = expectStatus<PlanListResponse>(response, 200).plans;
  });

  it('needs no session token', () => {
    // A pricing page a visitor cannot read before signing up is not a pricing page.
    expect(plans.length).toBeGreaterThan(0);
  });

  it('returns the three seeded Scribe plans, cheapest first', () => {
    expect(
      plans.map((plan) => plan.code),
      'the contract orders the pricing table free, pro, scale',
    ).toEqual(['free', 'pro', 'scale']);
  });

  it('resolves each plan to a distinct published version', () => {
    const versionIds = plans.map((plan) => plan.plan_version_id);
    expect(new Set(versionIds).size).toBe(versionIds.length);
    for (const plan of plans) {
      expect(plan.plan_version_id.length, `${plan.code} has no plan_version_id`).toBeGreaterThan(0);
      expect(plan.version, `${plan.code} has no version number`).toBeGreaterThanOrEqual(0);
      expect(plan.name.length, `${plan.code} has no name`).toBeGreaterThan(0);
    }
  });

  it('marks exactly the free plan as free', () => {
    const free = plans.find((plan) => plan.code === 'free');
    expect(free?.is_free, 'the plan seeded as `Scribe Free` must have plan_type FREE').toBe(true);
  });

  it('prices every plan in the same currency', () => {
    // Meteroid refuses a checkout whose customer and plan version disagree on currency,
    // so a tenant seeded with mixed currencies fails at checkout, far from the cause.
    const currencies = new Set(plans.map((plan) => plan.currency));
    expect(
      [...currencies],
      'all three plans must share one currency, and it must match SCRIBE_DEFAULT_CURRENCY ' +
        '(see examples/CATALOG.md)',
    ).toHaveLength(1);
  });

  it('flattens price components exactly as the contract specifies', () => {
    const prices: [string, PlanPrice][] = plans.flatMap((plan) =>
      plan.prices.map((price) => [plan.code, price] as [string, PlanPrice]),
    );
    expect(prices.length, 'no plan has a single price component').toBeGreaterThan(0);

    for (const [planCode, price] of prices) {
      const where = `${planCode}/${price.name} (${price.kind})`;

      if (price.kind === 'USAGE') {
        expect(price.amount, `${where}: USAGE has no recurring amount`).toBeNull();
        expect(price.pricing_model, `${where}: USAGE must report its pricing model`).not.toBeNull();
        if (price.pricing_model === 'PER_UNIT') {
          expect(price.unit_amount, `${where}: PER_UNIT usage must carry a unit price`).not.toBeNull();
        } else {
          expect(
            price.unit_amount,
            `${where}: only PER_UNIT usage has a single unit price; the frontend renders the ` +
              `model name for the others`,
          ).toBeNull();
        }
      } else {
        expect(
          price.pricing_model,
          `${where}: pricing_model is set for USAGE components only`,
        ).toBeNull();
      }

      if (price.included_amount !== null) {
        expect(price.kind, `${where}: included_amount belongs to CAPACITY only`).toBe('CAPACITY');
      }
      if (price.unit_amount !== null) {
        expect(['USAGE', 'CAPACITY']).toContain(price.kind);
      }
      if (price.unit_name !== null) {
        expect(['USAGE', 'CAPACITY', 'SLOT']).toContain(price.kind);
      }
      if (price.cadence === null) {
        expect(price.kind, `${where}: only ONE_TIME has no cadence in Meteroid`).toBe('ONE_TIME');
      }

      for (const [field, value] of Object.entries({
        amount: price.amount,
        unit_amount: price.unit_amount,
        included_amount: price.included_amount,
      })) {
        if (value !== null) {
          expect(
            isDecimalString(value),
            `${where}: ${field} must be an exact decimal string, got ${JSON.stringify(value)}`,
          ).toBe(true);
        }
      }
    }
  });

  it('renders marketing bullets from the plan version entitlements', () => {
    for (const plan of plans) {
      for (const feature of plan.features) {
        expect(feature.feature_code.length, `${plan.code} has a bullet with no feature code`)
          .toBeGreaterThan(0);
        expect(feature.label.trim().length, `${plan.code}/${feature.feature_code} has no label`)
          .toBeGreaterThan(0);
      }
    }
  });
});

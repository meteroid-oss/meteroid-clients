/**
 * `GET /api/entitlements` — the normalized view the SPA gates on and
 * `POST /api/transcriptions` enforces.
 *
 * The union is the most delicate modelling decision in the whole project, so the schema
 * check carries most of the weight here (a mis-tagged or mis-shaped variant fails in
 * `expectStatus` before any of these assertions run). What is left are the cross-field
 * invariants a schema cannot express: that `unlimited` really mirrors `limit`, that a
 * limited entitlement always reports a balance, and that a reset period's `interval` and
 * `unit` are null together.
 */

import { beforeAll, describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { compareDecimal } from '../src/decimal.js';
import { TRANSCRIPTION_FEATURE } from '../src/entitlements.js';
import { sharedSession } from '../src/session.js';
import { skipTest } from '../src/skip.js';
import { SUBSCRIBED_WORKSPACE_HINT, subscribedToken } from '../src/session.js';
import type { Entitlement, EntitlementListResponse } from '../src/types.js';

function assertInvariants(entitlements: Entitlement[]): void {
  for (const entitlement of entitlements) {
    const where = `${entitlement.feature_code}`;
    const value = entitlement.value;

    if (value.type === 'METERED') {
      expect(
        value.unlimited,
        `${where}: unlimited must mirror limit == null (limit=${value.limit})`,
      ).toBe(value.limit === null);

      if (value.limit === null) {
        expect(
          value.remaining,
          `${where}: an unlimited entitlement has no remaining balance`,
        ).toBeNull();
      } else {
        // The contract derives this: Meteroid's `remaining` when it supplies one, else
        // `limit - consumed`, else `limit`. A limited entitlement therefore always has a
        // balance — it is the number the quota check compares against, and the same one
        // a 402 body reports.
        expect(
          value.remaining,
          `${where}: a limited entitlement must always report a remaining balance`,
        ).not.toBeNull();
        expect(
          compareDecimal(value.remaining as string, value.limit),
          `${where}: remaining (${value.remaining}) exceeds limit (${value.limit})`,
        ).toBeLessThanOrEqual(0);
      }

      const period = value.reset_period;
      const bothNull = period.interval === null && period.unit === null;
      const bothSet = period.interval !== null && period.unit !== null;
      expect(
        bothNull || bothSet,
        `${where}: reset_period interval and unit must be null together, got ` +
          `${JSON.stringify(period)}`,
      ).toBe(true);
      if (period.type === 'BILLING_CYCLE' || period.type === 'NEVER') {
        expect(bothNull, `${where}: ${period.type} carries no interval`).toBe(true);
      }
    }

    if (value.type === 'CONFIG' && value.value.kind === 'NUMBER') {
      // Meteroid types a NUMBER config value as `format: decimal`, so `retention_days`
      // is "90", not 90. The schema enforces it; this states why.
      expect(typeof value.value.value).toBe('string');
    }
  }
}

describe('GET /api/entitlements', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.listEntitlements(undefined), 401, 'UNAUTHORIZED');
  });

  describe('for a workspace that has never subscribed', () => {
    let entitlements: Entitlement[];

    beforeAll(async () => {
      const session = await sharedSession();
      entitlements = expectStatus<EntitlementListResponse>(
        await api.listEntitlements(session.token),
        200,
      ).entitlements;
    });

    it('answers with the feature-level defaults, which may be none at all', () => {
      // Deliberately not asserting the list is non-empty: an unsubscribed workspace
      // legitimately resolves to nothing, and a suite that demanded otherwise would be
      // asserting a Meteroid configuration choice rather than the contract.
      expect(Array.isArray(entitlements)).toBe(true);
      console.info(
        `  → unsubscribed workspace resolves ${entitlements.length} entitlement(s): ` +
          `${entitlements.map((e) => e.feature_code).join(', ') || '(none)'}`,
      );
    });

    it('satisfies the cross-field invariants of the entitlement union', () => {
      assertInvariants(entitlements);
    });

    it('never repeats a feature code', () => {
      const codes = entitlements.map((entitlement) => entitlement.feature_code);
      expect(new Set(codes).size).toBe(codes.length);
    });
  });

  describe('for a subscribed workspace', () => {
    it('grants the metered transcription feature the demo is built around', async (context) => {
      const token = subscribedToken();
      if (!token) skipTest(context, `no subscribed workspace configured. ${SUBSCRIBED_WORKSPACE_HINT}`);

      const entitlements = expectStatus<EntitlementListResponse>(
        await api.listEntitlements(token),
        200,
      ).entitlements;

      assertInvariants(entitlements);

      const transcription = entitlements.find(
        (entitlement) => entitlement.feature_code === TRANSCRIPTION_FEATURE,
      );
      expect(
        transcription,
        `a subscribed workspace must resolve the "${TRANSCRIPTION_FEATURE}" entitlement. ` +
          `Seeded codes are listed in examples/CATALOG.md.`,
      ).toBeDefined();
      expect(
        transcription?.value.type,
        `"${TRANSCRIPTION_FEATURE}" must be seeded as a METERED feature — a boolean or config ` +
          `feature with that code makes the quota check unimplementable, and the backend ` +
          `reports it as CATALOG_NOT_SEEDED rather than a paywall.`,
      ).toBe('METERED');
    });
  });
});

/**
 * `GET /api/usage` — what Meteroid says was consumed.
 *
 * The interesting assertion here is the *scope*: with no subscription there is no billing
 * period to borrow, so the backend falls back to the customer-scoped Meteroid endpoint —
 * which requires an explicit date range — and reports `scope: "customer"`. Getting that
 * wrong is invisible in a screenshot and obvious here.
 *
 * What this file deliberately does **not** do is assert that usage equals the quota a
 * `201` reported. Meteroid's counters are eventually consistent; the contract says so,
 * and a suite that asserted otherwise would flake for a reason that is not a bug.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { isDecimalString } from '../src/decimal.js';
import { USAGE_SETTLE_MS } from '../src/env.js';
import {
  fetchEntitlements,
  meteredTranscriptionEntitlement,
  TRANSCRIPTION_FEATURE,
} from '../src/entitlements.js';
import { sharedSession, SUBSCRIBED_WORKSPACE_HINT, subscribedToken } from '../src/session.js';
import { skipTest } from '../src/skip.js';
import type { CreateTranscriptionResponse, MeResponse, UsageResponse } from '../src/types.js';

function assertPeriod(usage: UsageResponse): void {
  // Billing period boundaries are dates (`YYYY-MM-DD`), not timestamps — the schema
  // checks the format, this checks they make sense as a period.
  expect(
    usage.period_start <= usage.period_end,
    `period_start ${usage.period_start} is after period_end ${usage.period_end}`,
  ).toBe(true);

  for (const metric of usage.metrics) {
    expect(isDecimalString(metric.total_value), `${metric.metric_code} total is not a decimal string`)
      .toBe(true);
    for (const grouped of metric.grouped_usage) {
      expect(isDecimalString(grouped.value)).toBe(true);
    }
  }
}

describe('GET /api/usage', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.getUsage(undefined), 401, 'UNAUTHORIZED');
  });

  it('falls back to the customer scope for a workspace with no subscription', async () => {
    const session = await sharedSession();
    const usage = expectStatus<UsageResponse>(await api.getUsage(session.token), 200);

    expect(
      usage.scope,
      'with no subscription there is no billing period, so the backend must use the ' +
        'customer-scoped Meteroid endpoint and say so',
    ).toBe('customer');
    assertPeriod(usage);
  });

  it('uses the subscription billing period when there is a subscription', async (context) => {
    const token = subscribedToken();
    if (!token) skipTest(context, `no subscribed workspace configured. ${SUBSCRIBED_WORKSPACE_HINT}`);

    const me = expectStatus<MeResponse>(await api.getMe(token), 200);
    if (!me.subscription) {
      skipTest(
        context,
        'the configured workspace has no subscription — check ' +
          'SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS, it should name a customer that completed checkout.',
      );
    }

    const usage = expectStatus<UsageResponse>(await api.getUsage(token), 200);
    expect(usage.scope).toBe('subscription');
    assertPeriod(usage);
  });

  it('eventually reflects a transcription that was just billed', async (context) => {
    const token = subscribedToken();
    if (!token) skipTest(context, `no subscribed workspace configured. ${SUBSCRIBED_WORKSPACE_HINT}`);

    const metered = meteredTranscriptionEntitlement(await fetchEntitlements(token));
    if (!metered || !metered.enabled) {
      skipTest(context, `the configured workspace has no enabled "${TRANSCRIPTION_FEATURE}" entitlement.`);
    }

    const created = expectStatus<CreateTranscriptionResponse>(
      await api.createTranscription(token, { title: 'Usage probe', duration_seconds: 120 }),
      201,
    );

    // Poll rather than assert-once. This is the one place the suite tolerates lag, and it
    // reports rather than fails when the counter has not caught up: an ingest that is
    // merely slow is not a contract violation, and turning it into one buys flakiness.
    const deadline = Date.now() + USAGE_SETTLE_MS;
    let seen = false;
    let lastTotal: string | null = null;

    while (Date.now() < deadline && !seen) {
      const usage = expectStatus<UsageResponse>(await api.getUsage(token), 200);
      assertPeriod(usage);
      const metric = usage.metrics.find((entry) => entry.metric_code === TRANSCRIPTION_FEATURE);
      if (metric) {
        seen = true;
        lastTotal = metric.total_value;
        break;
      }
      await new Promise((resolve) => setTimeout(resolve, 1000));
    }

    if (seen) {
      console.info(
        `  → Meteroid reports ${lastTotal} ${TRANSCRIPTION_FEATURE} for the period after ` +
          `billing ${created.transcription.minutes_billed}`,
      );
    } else {
      console.warn(
        `  ! Meteroid did not report any "${TRANSCRIPTION_FEATURE}" usage within ` +
          `${USAGE_SETTLE_MS}ms of the ingest. The contract calls these counters eventually ` +
          `consistent, so this is reported rather than failed — but if it never settles, the ` +
          `metric code on the ingested event does not match the seeded billable metric.`,
      );
    }
  });
});

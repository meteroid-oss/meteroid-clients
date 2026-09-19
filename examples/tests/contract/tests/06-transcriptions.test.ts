/**
 * `POST /api/transcriptions` — the metered action, and the reason the demo exists.
 *
 * Three outcomes have to stay distinguishable, and this file exists to keep them that
 * way across every backend:
 *
 *   403 FEATURE_NOT_ENTITLED — the plan does not grant it ("upgrade to get this")
 *   402 QUOTA_EXHAUSTED      — granted, used up ("upgrade to get more"), with a snapshot
 *   201 + quota              — allowed, billed, and the consumption reported to Meteroid
 *
 * A backend that collapses 402 into 403 still "works"; the product it powers cannot tell
 * a paywall from an upsell. That is what is being tested here.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { addDecimal, billableMinutes, compareDecimal, secondsForMinutes, subtractDecimal } from '../src/decimal.js';
import { nextPlanUp } from '../src/catalog.js';
import {
  fetchEntitlements,
  meteredTranscriptionEntitlement,
  TRANSCRIPTION_FEATURE,
} from '../src/entitlements.js';
import { sharedSession, SUBSCRIBED_WORKSPACE_HINT, subscribedToken } from '../src/session.js';
import { skipTest } from '../src/skip.js';
import type { Skippable } from '../src/skip.js';
import type {
  CreateTranscriptionResponse,
  MeResponse,
  MeteredEntitlementValue,
  TranscriptionListResponse,
} from '../src/types.js';

/**
 * The workspace the metered tests run against.
 *
 * Preferably one an operator subscribed by hand (the suite cannot complete a hosted
 * checkout). If the tenant's feature-level defaults happen to grant a fresh workspace the
 * metered entitlement, the fresh one will do just as well.
 */
async function meteredWorkspace(): Promise<{ token: string; metered: MeteredEntitlementValue } | null> {
  const candidates = [subscribedToken(), (await sharedSession()).token].filter(
    (token): token is string => Boolean(token),
  );

  for (const token of candidates) {
    const metered = meteredTranscriptionEntitlement(await fetchEntitlements(token));
    if (metered && metered.enabled) return { token, metered };
  }
  return null;
}

async function requireMeteredWorkspace(context: Skippable) {
  const workspace = await meteredWorkspace();
  if (!workspace) {
    skipTest(
      context,
      `no workspace has an enabled "${TRANSCRIPTION_FEATURE}" entitlement, so the metered path ` +
        `cannot be exercised. ${SUBSCRIBED_WORKSPACE_HINT}`,
    );
  }
  return workspace;
}

describe('POST /api/transcriptions — request validation', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(
      await api.createTranscription(undefined, { title: 'Standup', duration_seconds: 60 }),
      401,
      'UNAUTHORIZED',
    );
  });

  it('rejects a duration below the contract minimum', async () => {
    const session = await sharedSession();
    expectError(
      await api.createTranscription(session.token, { title: 'Standup', duration_seconds: 0 }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects a duration above the contract maximum', async () => {
    const session = await sharedSession();
    expectError(
      await api.createTranscription(session.token, { title: 'Standup', duration_seconds: 7201 }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects an empty title', async () => {
    const session = await sharedSession();
    expectError(
      await api.createTranscription(session.token, { title: '   ', duration_seconds: 60 }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects a missing required field', async () => {
    const session = await sharedSession();
    expectError(await api.createTranscription(session.token, { title: 'Standup' }), 400, 'BAD_REQUEST');
  });

  it('rejects an unknown property', async () => {
    const session = await sharedSession();
    expectError(
      await api.createTranscription(session.token, {
        title: 'Standup',
        duration_seconds: 60,
        language: 'en',
      }),
      400,
      'BAD_REQUEST',
    );
  });

  it('validates the request before consulting the entitlement', async () => {
    // Ordering matters: a malformed request must be a 400 even for a workspace that would
    // also fail the entitlement check, or the caller is told the wrong thing is wrong.
    const session = await sharedSession();
    expectError(
      await api.createTranscription(session.token, { title: '', duration_seconds: -1 }),
      400,
      'BAD_REQUEST',
    );
  });
});

describe('POST /api/transcriptions — a workspace with no entitlement', () => {
  it('answers 403 FEATURE_NOT_ENTITLED and names the plan that fixes it', async (context) => {
    const session = await sharedSession();
    const metered = meteredTranscriptionEntitlement(await fetchEntitlements(session.token));
    if (metered && metered.enabled) {
      skipTest(
        context,
        `this tenant grants a fresh workspace an enabled "${TRANSCRIPTION_FEATURE}" entitlement, ` +
          `so the not-entitled path is unreachable from here.`,
      );
    }

    const error = expectError(
      await api.createTranscription(session.token, { title: 'Standup', duration_seconds: 60 }),
      403,
      'FEATURE_NOT_ENTITLED',
    );

    // Not 402: nothing was granted, so nothing was used up. `expectError` already asserted
    // that a non-QUOTA_EXHAUSTED error carries no quota snapshot.
    expect(
      error.upgrade_plan_code,
      'the contract offers `pro` to a workspace with no subscription',
    ).toBe('pro');
  });
});

describe('POST /api/transcriptions — the metered path', () => {
  it('bills the minutes it consumed and reports them to Meteroid', async (context) => {
    const workspace = await requireMeteredWorkspace(context);

    const created = expectStatus<CreateTranscriptionResponse>(
      await api.createTranscription(workspace.token, {
        title: 'Weekly standup',
        duration_seconds: 210,
      }),
      201,
    );

    const { transcription, quota } = created;
    expect(transcription.duration_seconds).toBe(210);
    expect(
      compareDecimal(transcription.minutes_billed, billableMinutes(210)),
      `210 seconds bills ${billableMinutes(210)} minutes (seconds/60, rounded up to two ` +
        `decimals), got ${transcription.minutes_billed}`,
    ).toBe(0);
    expect(transcription.text.length, 'the demo returns a simulated transcript').toBeGreaterThan(0);
    expect(
      transcription.event_id.length,
      'event_id is the id of the usage event ingested into Meteroid; it makes the ingest ' +
        'idempotent on retry, so it cannot be blank',
    ).toBeGreaterThan(0);
    expect(Number.isNaN(Date.parse(transcription.created_at))).toBe(false);

    // A 201 always carries a quota: a missing or disabled entitlement would have been a
    // 403, so there is always something to report.
    expect(quota.feature_code).toBe(TRANSCRIPTION_FEATURE);
    expect(quota.enabled).toBe(true);
    expect(quota.unlimited).toBe(quota.limit === null);
    if (quota.unlimited) {
      expect(quota.remaining, 'an unlimited quota reports no balance').toBeNull();
    } else {
      expect(quota.remaining).not.toBeNull();
    }
  });

  it('decrements the balance by exactly the minutes it billed', async (context) => {
    const workspace = await requireMeteredWorkspace(context);
    if (workspace.metered.limit === null) {
      skipTest(
        context,
        `this workspace's "${TRANSCRIPTION_FEATURE}" entitlement is unlimited, so there is no ` +
          `balance to decrement. Pin this to a Free workspace (CATALOG.md seeds a limit of 30).`,
      );
    }

    const before = workspace.metered.remaining as string;
    const created = expectStatus<CreateTranscriptionResponse>(
      await api.createTranscription(workspace.token, { title: 'Retro', duration_seconds: 60 }),
      201,
    );

    const minutes = created.transcription.minutes_billed;
    const after = created.quota.remaining as string;
    const expected = subtractDecimal(before, minutes);

    // Meteroid's counters are eventually consistent, so the entitlement the backend read
    // may already have moved past the one this test read a moment earlier. The balance can
    // therefore be *lower* than expected, but never higher — and it must have moved.
    expect(
      compareDecimal(after, expected) <= 0,
      `balance went from ${before} to ${after} after billing ${minutes} minutes; it must be at ` +
        `most ${expected}`,
    ).toBe(true);
    expect(
      compareDecimal(after, before) < 0,
      `billing ${minutes} minutes did not move the balance (still ${after})`,
    ).toBe(true);

    if (compareDecimal(after, expected) !== 0) {
      console.warn(
        `  ! balance is ${after}, expected ${expected} — Meteroid's counter moved between the ` +
          `entitlement read and the transcription. Not a failure; the counters are ` +
          `eventually consistent.`,
      );
    }
  });

  it('refuses a request larger than the remaining balance with 402 and a live snapshot', async (context) => {
    const workspace = await requireMeteredWorkspace(context);
    if (workspace.metered.limit === null) {
      skipTest(
        context,
        `this workspace's "${TRANSCRIPTION_FEATURE}" entitlement is unlimited, so 402 is ` +
          `unreachable by design. Run the quota tests against a Free workspace.`,
      );
    }

    // Re-read: the tests above consumed some of it.
    const metered = meteredTranscriptionEntitlement(await fetchEntitlements(workspace.token));
    const remaining = metered?.remaining ?? '0';
    const overrun = secondsForMinutes(addDecimal(remaining, '0.01'));
    if (overrun > 7200) {
      skipTest(
        context,
        `the workspace has ${remaining} minutes left, and a single request bills at most 120 ` +
          `(7200 seconds), so the quota cannot be overrun in one call. Run the quota tests ` +
          `against a Free workspace — CATALOG.md seeds its limit at 30 for exactly this reason.`,
      );
    }

    const error = expectError(
      await api.createTranscription(workspace.token, {
        title: 'Quarterly all-hands',
        duration_seconds: overrun,
      }),
      402,
      'QUOTA_EXHAUSTED',
    );

    const quota = error.quota;
    expect(quota, '402 must carry the live quota snapshot').not.toBeNull();
    expect(quota?.feature_code).toBe(TRANSCRIPTION_FEATURE);
    expect(quota?.enabled, 'the feature is granted — it is used up, not switched off').toBe(true);
    expect(quota?.unlimited).toBe(false);
    expect(quota?.limit).not.toBeNull();
    expect(
      quota?.remaining,
      'the snapshot must report the balance the request was measured against',
    ).not.toBeNull();

    const me = expectStatus<MeResponse>(await api.getMe(workspace.token), 200);
    expect(
      error.upgrade_plan_code,
      `the contract fixes the upsell ladder at free → pro → scale; this workspace is on ` +
        `${me.subscription?.plan_code ?? 'no plan'}`,
    ).toBe(nextPlanUp(me.subscription?.plan_code ?? null));
  });
});

describe('GET /api/transcriptions', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.listTranscriptions(undefined), 401, 'UNAUTHORIZED');
  });

  it('lists the workspace history newest first', async () => {
    const session = await sharedSession();
    const listed = expectStatus<TranscriptionListResponse>(
      await api.listTranscriptions(session.token),
      200,
    ).transcriptions;

    const timestamps = listed.map((transcription) => Date.parse(transcription.created_at));
    const sorted = [...timestamps].sort((a, b) => b - a);
    expect(timestamps, 'history is newest first').toEqual(sorted);

    const ids = listed.map((transcription) => transcription.id);
    expect(new Set(ids).size, 'a transcription must not appear twice').toBe(ids.length);
  });

  it('contains a transcription it just created', async (context) => {
    const workspace = await requireMeteredWorkspace(context);

    const created = expectStatus<CreateTranscriptionResponse>(
      await api.createTranscription(workspace.token, { title: 'Design review', duration_seconds: 60 }),
      201,
    );
    const listed = expectStatus<TranscriptionListResponse>(
      await api.listTranscriptions(workspace.token),
      200,
    ).transcriptions;

    const found = listed.find(
      (transcription) => transcription.id === created.transcription.id,
    );
    expect(
      found,
      'the history is in-memory and per-process — if the backend restarted mid-run, or two ' +
        'processes are answering one BASE_URL, this is where it shows up',
    ).toBeDefined();
    expect(found?.title).toBe('Design review');
  });
});

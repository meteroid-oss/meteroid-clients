/**
 * A very small typed client for the demo backend, used only to put the browser into a known state.
 *
 * This is *setup*, not assertion. Everything this file touches is already validated far more
 * thoroughly by `tests/contract`, which checks each response against `openapi.yaml`. Here we only
 * need the handful of fields the browser tests branch on, so the types below are a deliberate
 * subset of the contract rather than a second copy of it.
 *
 * Using the API for setup is what keeps the suite fast and sleep-free: burning 30 minutes of quota
 * through the UI would be thirty page interactions, each with its own network round trip, to test
 * something the UI is not what's being tested for.
 */
import type { APIRequestContext } from '@playwright/test';

import { BASE_URL } from './env.js';

export interface Workspace {
  id: string;
  name: string;
  customer_id: string;
  customer_alias: string;
  currency: string;
}

export interface Session {
  session_token: string;
  workspace: Workspace;
}

/** Mirrors the contract's `QuotaSnapshot`. Amounts are decimal *strings* — never numbers. */
export interface QuotaSnapshot {
  feature_code: string;
  enabled: boolean;
  limit: string | null;
  consumed: string | null;
  remaining: string | null;
  reset_at: string | null;
  unlimited: boolean;
}

/** The subset of the contract's `Error` envelope these tests read. */
export interface ApiError {
  code: string;
  message: string;
  quota: QuotaSnapshot | null;
  upgrade_plan_code: string | null;
}

const METERED_FEATURE = 'transcription_minutes';

async function fail(response: { status(): number; url(): string; text(): Promise<string> }, what: string): Promise<never> {
  const body = await response.text().catch(() => '<unreadable>');
  throw new Error(`${what} failed: ${response.status()} from ${response.url()}\n${body}`);
}

/** Creates a fresh workspace, which creates a fresh Meteroid customer. Cheap and expected. */
export async function createSession(request: APIRequestContext, workspaceName: string): Promise<Session> {
  const response = await request.post(`${BASE_URL}/api/session`, {
    data: { workspace_name: workspaceName },
  });
  if (!response.ok()) await fail(response, 'POST /api/session');
  return (await response.json()) as Session;
}

/** One entry of `GET /api/entitlements`. The value is a union tagged on `type`. */
interface Entitlement {
  feature_code: string;
  feature_name: string;
  value: { type: string } & Partial<Omit<QuotaSnapshot, 'feature_code'>>;
}

/**
 * Reads the live `transcription_minutes` quota as a `QuotaSnapshot`, or null when the workspace has
 * no such entitlement — which is the normal state for a workspace that has never subscribed.
 *
 * `GET /api/entitlements` and the `402` body carry the same numbers in two different shapes: the
 * entitlement nests them under a `type`-tagged `value` and puts the feature code on the wrapper,
 * while the error carries a flat `QuotaSnapshot`. Normalizing to the latter here means the specs
 * compare like with like.
 */
export async function readQuota(request: APIRequestContext, token: string): Promise<QuotaSnapshot | null> {
  const response = await request.get(`${BASE_URL}/api/entitlements`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  if (!response.ok()) await fail(response, 'GET /api/entitlements');

  const body = (await response.json()) as { entitlements: Entitlement[] };
  const metered = body.entitlements.find(
    (entitlement) => entitlement.feature_code === METERED_FEATURE && entitlement.value.type === 'METERED',
  );
  if (!metered) return null;

  return {
    feature_code: metered.feature_code,
    enabled: metered.value.enabled ?? false,
    limit: metered.value.limit ?? null,
    consumed: metered.value.consumed ?? null,
    remaining: metered.value.remaining ?? null,
    reset_at: metered.value.reset_at ?? null,
    unlimited: metered.value.unlimited ?? false,
  };
}

/**
 * Consumes minutes by transcribing through the API.
 *
 * `durationSeconds` is capped at the contract's maximum of 7200 by the caller.
 */
async function transcribe(
  request: APIRequestContext,
  token: string,
  durationSeconds: number,
): Promise<{ status: number; quota: QuotaSnapshot | null }> {
  const response = await request.post(`${BASE_URL}/api/transcriptions`, {
    headers: { Authorization: `Bearer ${token}` },
    data: { title: `e2e quota burn ${durationSeconds}s`, duration_seconds: durationSeconds },
  });

  if (response.status() === 201) {
    const body = (await response.json()) as { quota: QuotaSnapshot };
    return { status: 201, quota: body.quota };
  }
  if (response.status() === 402) {
    const body = (await response.json()) as ApiError;
    return { status: 402, quota: body.quota };
  }
  return await fail(response, 'POST /api/transcriptions');
}

/**
 * Drives the workspace's remaining balance below one minute, so that the *next* transcription —
 * the one the browser makes — is guaranteed to be rejected with `402 QUOTA_EXHAUSTED`.
 *
 * Deliberately stops short of tripping the 402 itself: the point of the browser test is to watch
 * the SPA handle that response, so the 402 has to happen in the page, not here.
 *
 * The parsing to `Number` below is for *control flow only* — deciding how many more minutes to
 * burn. No assertion is ever made on a parsed decimal; the contract keeps these as strings because
 * binary floating point is how a 0.1-minute clip eventually bills wrong, and that rule is enforced
 * where it matters, in `tests/contract`.
 */
export async function drainQuota(
  request: APIRequestContext,
  token: string,
  quota: QuotaSnapshot,
): Promise<QuotaSnapshot> {
  const MAX_DURATION_SECONDS = 7200; // the contract's per-transcription cap
  const MAX_CALLS = 40; // a bounded loop: a backend whose counter never moves must fail, not hang

  let current = quota;

  for (let call = 0; call < MAX_CALLS; call += 1) {
    const remaining = Number(current.remaining ?? '0');
    if (!Number.isFinite(remaining) || remaining < 1) return current;

    // Whole minutes only, so `duration_seconds / 60` needs no rounding and we can never
    // overshoot the balance by a rounding step and trip the 402 in here.
    const minutes = Math.min(Math.floor(remaining), MAX_DURATION_SECONDS / 60);
    const result = await transcribe(request, token, minutes * 60);

    if (result.status === 402) {
      // Meteroid's counters are eventually consistent, so the balance we read a moment ago can be
      // stale. Hitting the wall early is not a failure — it is the state we were aiming for.
      return result.quota ?? current;
    }
    if (!result.quota) {
      throw new Error('POST /api/transcriptions returned 201 without a quota, which the contract forbids');
    }

    const next = Number(result.quota.remaining ?? '0');
    if (Number.isFinite(next) && next >= remaining) {
      throw new Error(
        `Quota is not decreasing: remaining was ${current.remaining} and is still ${result.quota.remaining} ` +
          `after billing ${minutes} minutes. The backend is not reporting consumption to Meteroid.`,
      );
    }
    current = result.quota;
  }

  throw new Error(`Could not drain the quota in ${MAX_CALLS} transcriptions; last balance ${current.remaining}`);
}

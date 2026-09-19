/**
 * `GET /api/transcriptions` and `POST /api/transcriptions` — the metered action.
 *
 * `POST` is the centerpiece of the demo and the reason the whole thing exists:
 * **check the entitlement, then report the consumption.** Everything else is framing.
 */

import { randomUUID } from "node:crypto";

import type { EffectiveEntitlement, MeteredEffectiveEntitlementValue } from "@meteroid/sdk";

import { TRANSCRIPTION_MINUTES } from "../catalog.js";
import { add, billableMinutes, greaterThan, subtract } from "../decimal.js";
import {
  type CreateTranscriptionResponse,
  decodeCreateTranscriptionRequest,
  type QuotaSnapshot,
  type Transcription,
  type TranscriptionListResponse,
} from "../dto.js";
import { fetchEntitlements, quotaSnapshot } from "../entitlements.js";
import { ApiError, upstream } from "../error.js";
import { created, ok, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";
import { upgradeTarget } from "../workspace.js";
import { bounded, jsonBody } from "./index.js";

/**
 * Demo-local history, newest first. In memory: Meteroid is the source of truth for
 * *usage*, not for the application objects that produced it.
 */
export async function listTranscriptions(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<TranscriptionListResponse>> {
  const session = requireSession(state, request);

  return ok({ transcriptions: state.transcriptions.list(session.customerAlias) });
}

export async function createTranscription(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<CreateTranscriptionResponse>> {
  const { customerAlias: alias } = requireSession(state, request);
  const body = jsonBody(request, decodeCreateTranscriptionRequest);
  const title = bounded("title", body.title, 200);
  if (body.duration_seconds < 1 || body.duration_seconds > 7200) {
    throw ApiError.badRequest("duration_seconds must be between 1 and 7200.");
  }
  const minutes = billableMinutes(body.duration_seconds);

  // ---- 1. Read the entitlement ------------------------------------------------
  const effective = await fetchEntitlements(state, alias);
  const metered = await findMetered(state, alias, effective);
  const quota = quotaSnapshot(TRANSCRIPTION_MINUTES, metered);

  // ---- 2. Gate ----------------------------------------------------------------
  // "Not granted" and "granted but used up" are different answers and get different
  // status codes, so the frontend can tell an upsell from a paywall.
  if (!metered.spec.enabled) {
    throw notEntitled(await upgradeTarget(state, alias));
  }

  // A null limit means unlimited — `remaining` is then null and never trips this branch.
  if (quota.remaining !== null && greaterThan(minutes, quota.remaining)) {
    throw new ApiError(
      "QUOTA_EXHAUSTED",
      `This request needs ${minutes} transcription minutes but only ${quota.remaining} ` +
        "remain in the current period.",
    )
      .withQuota(quota)
      .withUpgrade(await upgradeTarget(state, alias));
  }

  // ---- 3. Do the work and report the consumption ------------------------------
  const id = `tr_${randomUUID().replaceAll("-", "")}`;
  // Whole seconds: sub-second precision means nothing for a usage event.
  const now = new Date().toISOString().replace(/\.\d{3}Z$/, "Z");

  const response = await state.meteroid.events
    .ingestEvents({
      events: [
        {
          // The billable metric's code, seeded per examples/CATALOG.md.
          code: TRANSCRIPTION_MINUTES,
          // Events accept the customer's *external alias*, so the demo never has to
          // carry Meteroid ids around.
          customerId: alias,
          // Meteroid deduplicates on (eventId, customerId). Reusing the transcription's
          // own id makes a retried ingest idempotent.
          eventId: id,
          // Aggregated by the metric's `aggregation_key`, as a decimal string.
          properties: { minutes },
          // Must be within 24h ago .. 1h ahead unless `allowBackfilling` is set, which
          // this demo never does.
          timestamp: now,
        },
      ],
    })
    .catch(upstream("POST /api/v1/events/ingest"));

  // With `allowPartialFailures` unset, a bad event rejects the whole batch and the call
  // above already threw — but check anyway rather than silently losing usage.
  if (response.failures != null && response.failures.length > 0) {
    throw new ApiError(
      "UPSTREAM_ERROR",
      `Meteroid rejected the usage event: ${JSON.stringify(response.failures)}`,
    );
  }

  const transcription: Transcription = {
    id,
    title,
    duration_seconds: body.duration_seconds,
    minutes_billed: minutes,
    text: transcript(body.duration_seconds),
    created_at: now,
    event_id: id,
  };
  state.transcriptions.record(alias, transcription);

  return created({ transcription, quota: projectQuota(quota, minutes) });
}

/**
 * Find the metered `transcription_minutes` entitlement, or explain why there is none.
 *
 * A *missing* entitlement is a 403: the workspace's plan does not grant the feature. An
 * entitlement of the *wrong type* is a seeding error — the feature exists but was
 * created as boolean or config in the dashboard — and gets `CATALOG_NOT_SEEDED`, so an
 * operator mistake never masquerades as a customer-facing paywall.
 */
async function findMetered(
  state: AppState,
  alias: string,
  effective: readonly EffectiveEntitlement[],
): Promise<MeteredEffectiveEntitlementValue> {
  const entitlement = effective.find(({ feature }) => feature.code === TRANSCRIPTION_MINUTES);

  if (entitlement === undefined) {
    throw notEntitled(await upgradeTarget(state, alias));
  }
  if (entitlement.value.type !== "METERED") {
    throw ApiError.catalogNotSeeded(
      `The feature "${TRANSCRIPTION_MINUTES}" exists but is not a metered feature. ` +
        "Recreate it as metered in the Meteroid dashboard; see examples/CATALOG.md.",
    );
  }
  return entitlement.value;
}

function notEntitled(upgrade: Awaited<ReturnType<typeof upgradeTarget>>): ApiError {
  return new ApiError(
    "FEATURE_NOT_ENTITLED",
    `The ${TRANSCRIPTION_MINUTES} entitlement is not enabled for this workspace.`,
  ).withUpgrade(upgrade);
}

/**
 * The backend's optimistic projection of the entitlement after this call: what it read
 * from Meteroid, minus the minutes it just billed. Meteroid's own counters are
 * eventually consistent, so `GET /api/usage` may briefly disagree — it is the authority
 * once it catches up.
 */
export function projectQuota(quota: QuotaSnapshot, minutes: string): QuotaSnapshot {
  return {
    ...quota,
    consumed: quota.consumed === null ? minutes : add(quota.consumed, minutes),
    remaining: quota.remaining === null ? null : subtract(quota.remaining, minutes),
  };
}

/**
 * The demo does no real speech recognition; it invents a transcript so the metered path
 * has something to return.
 */
function transcript(durationSeconds: number): string {
  return (
    `[demo transcript] This is simulated output for ${durationSeconds} seconds of audio. ` +
    "Scribe does no real speech recognition — the point of this endpoint is the " +
    "entitlement check and the usage event it reports to Meteroid."
  );
}

/** `GET /api/entitlements` — the normalized entitlement view the SPA gates on. */

import type { Entitlement, EntitlementListResponse } from "../dto.js";
import { fetchEntitlements, normalizeEntitlement } from "../entitlements.js";
import { ok, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";

/**
 * One Meteroid call, then a straight projection. The list may legitimately be empty for
 * a workspace that has never subscribed and has no feature-level defaults — that is not
 * an error, and it is why the demo checks the *features* exist at startup instead of
 * inferring "unseeded tenant" from an empty list here.
 */
export async function listEntitlements(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<EntitlementListResponse>> {
  const session = requireSession(state, request);

  const effective = await fetchEntitlements(state, session.customerAlias);

  // Sequentially, so a cold metric cache is refreshed once rather than once per entry.
  const entitlements: Entitlement[] = [];
  for (const entitlement of effective) {
    entitlements.push(await normalizeEntitlement(state, entitlement));
  }

  return ok({ entitlements });
}

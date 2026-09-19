/**
 * Reading the entitlement view the way a client would.
 *
 * The metered entitlement is the one the whole demo turns on, so finding it — and
 * deciding whether the quota path is even reachable — is factored out here rather than
 * repeated in three test files with three slightly different ideas of what "has a quota"
 * means.
 */

import { api } from './api.js';
import { expectStatus } from './assert.js';
import type {
  Entitlement,
  EntitlementListResponse,
  MeteredEntitlementValue,
} from './types.js';

/** The feature code the seeded catalog uses for transcription minutes (CATALOG.md). */
export const TRANSCRIPTION_FEATURE = 'transcription_minutes';

export async function fetchEntitlements(token: string): Promise<Entitlement[]> {
  const response = await api.listEntitlements(token);
  return expectStatus<EntitlementListResponse>(response, 200).entitlements;
}

export function findEntitlement(
  entitlements: Entitlement[],
  featureCode: string,
): Entitlement | undefined {
  return entitlements.find((entitlement) => entitlement.feature_code === featureCode);
}

/**
 * The metered `transcription_minutes` entitlement, or `null` when the workspace does not
 * have one — which is the normal state of a workspace that has never checked out, and
 * the reason `POST /api/transcriptions` answers `403` there.
 */
export function meteredTranscriptionEntitlement(
  entitlements: Entitlement[],
): MeteredEntitlementValue | null {
  const entitlement = findEntitlement(entitlements, TRANSCRIPTION_FEATURE);
  if (!entitlement || entitlement.value.type !== 'METERED') return null;
  return entitlement.value;
}

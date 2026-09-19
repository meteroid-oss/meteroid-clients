/** `POST /api/portal-session` — mint a Meteroid customer-portal token. */

import { type CreatePortalSessionResponse, decodeCreatePortalSessionRequest } from "../dto.js";
import { ApiError, upstream } from "../error.js";
import { created, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";
import { optionalJsonBody } from "./index.js";

/** Meteroid's default lifetime, in seconds. */
const DEFAULT_EXPIRY = 86_400;
const MIN_EXPIRY = 60;
const MAX_EXPIRY = 2_592_000;

/**
 * The portal is where the visitor manages their payment method and downloads invoices,
 * so the demo does not have to implement any of it. The frontend opens `portal_url`
 * with the `token`.
 */
export async function createPortalSession(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<CreatePortalSessionResponse>> {
  const session = requireSession(state, request);
  const body = optionalJsonBody(request, decodeCreatePortalSessionRequest);

  // Meteroid documents 60..2592000 but types the field as a plain int32, so the range
  // is validated here rather than forwarding a value Meteroid would reject.
  const expiresInSeconds = body.expires_in_seconds ?? DEFAULT_EXPIRY;
  if (expiresInSeconds < MIN_EXPIRY || expiresInSeconds > MAX_EXPIRY) {
    throw ApiError.badRequest(
      `expires_in_seconds must be between ${MIN_EXPIRY} and ${MAX_EXPIRY}.`,
    );
  }

  const portal = await state.meteroid.customers
    .createPortalToken(session.customerAlias, { expiresInSeconds })
    .catch(upstream(`POST /api/v1/customers/${session.customerAlias}/portal-token`));

  return created({
    portal_url: portal.portalUrl,
    token: portal.token,
    // Meteroid returns only `{ token, portalUrl }`, so this echoes what was asked for
    // rather than pretending to read it back out of the JWT.
    expires_in_seconds: expiresInSeconds,
  });
}

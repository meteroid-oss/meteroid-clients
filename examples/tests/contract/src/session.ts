/**
 * Workspaces the tests run against.
 *
 * Two of them, and the difference matters:
 *
 * * **The fresh workspace** — created by the suite through `POST /api/session`, so every
 *   run gets its own Meteroid customer. It has *no subscription*, which is exactly what
 *   makes it useful: it is how the suite exercises the unsubscribed shape of `/api/me`,
 *   the `403 FEATURE_NOT_ENTITLED` path, and the customer-scoped usage fallback.
 *
 * * **The subscribed workspace** — optional, supplied through the environment. Hosted
 *   checkout needs a browser, so the suite cannot subscribe anyone; an operator does it
 *   once and points the suite at the result. Without it the metered-action, quota and
 *   invoice-content tests skip with a message instead of failing.
 *
 * One fresh workspace is shared by the whole run (the suite runs in a single process, so
 * this module is loaded once) — a Meteroid customer per test file would be wasteful and
 * would make the transcription history assertions depend on file ordering.
 */

import { createHmac } from 'node:crypto';

import { api } from './api.js';
import { expectStatus } from './assert.js';
import { SESSION_SECRET, SUBSCRIBED_CUSTOMER_ALIAS, SUBSCRIBED_SESSION_TOKEN } from './env.js';
import type { CreateSessionResponse, Workspace } from './types.js';

export interface SessionHandle {
  token: string;
  workspace: Workspace;
}

/**
 * Mint a session token the way the contract specifies:
 * `v1.<base64url(alias)>.<base64url(hmac_sha256(secret, alias))>`.
 *
 * The token is opaque to clients, and tests treat it that way — this exists only so a
 * *subscribed* workspace can be reached from an alias plus the backend's session secret.
 * Prefer `SCRIBE_SUBSCRIBED_SESSION_TOKEN` when you have one; then nothing here is used.
 */
export function mintSessionToken(secret: string, alias: string): string {
  const signature = createHmac('sha256', secret).update(alias).digest();
  return `v1.${Buffer.from(alias, 'utf8').toString('base64url')}.${signature.toString('base64url')}`;
}

/** Create a brand-new demo workspace (and, upstream, a Meteroid customer). */
export async function createSession(body?: unknown): Promise<SessionHandle> {
  const response = await api.createSession(body);
  const created = expectStatus<CreateSessionResponse>(response, 201);
  return { token: created.session_token, workspace: created.workspace };
}

let sharedSessionPromise: Promise<SessionHandle> | undefined;

/** The one fresh workspace this run shares. Created on first use. */
export function sharedSession(): Promise<SessionHandle> {
  sharedSessionPromise ??= createSession({ workspace_name: 'Scribe contract suite' });
  return sharedSessionPromise;
}

/**
 * A token for a workspace that already has a subscription, or `null` when the
 * environment does not provide one.
 */
export function subscribedToken(): string | null {
  if (SUBSCRIBED_SESSION_TOKEN) return SUBSCRIBED_SESSION_TOKEN;
  if (SESSION_SECRET && SUBSCRIBED_CUSTOMER_ALIAS) {
    return mintSessionToken(SESSION_SECRET, SUBSCRIBED_CUSTOMER_ALIAS);
  }
  return null;
}

export const SUBSCRIBED_WORKSPACE_HINT =
  'Set SCRIBE_SUBSCRIBED_SESSION_TOKEN (or SCRIBE_SESSION_SECRET + ' +
  'SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS) to a workspace that has completed checkout. ' +
  'See tests/contract/README.md — hosted checkout needs a browser, so the suite cannot ' +
  'create a subscribed workspace by itself.';

/**
 * Browser-local demo state: the session token, and the marker that survives the round trip to
 * Meteroid's hosted checkout. Both are namespaced by API base URL, so pointing the SPA at the
 * Java backend does not resurrect the workspace you created against the Rust one.
 */
import { API_BASE_URL } from "../api/client";
import type { PlanCode } from "../api/types";

const namespace = `scribe:${API_BASE_URL}`;
const TOKEN_KEY = `${namespace}:session_token`;
const CHECKOUT_KEY = `${namespace}:pending_checkout`;

/** Private browsing and blocked site data both throw on access; the demo must still run. */
function read(key: string): string | null {
  try {
    return window.localStorage.getItem(key);
  } catch {
    return null;
  }
}

function write(key: string, value: string | null): void {
  try {
    if (value === null) window.localStorage.removeItem(key);
    else window.localStorage.setItem(key, value);
  } catch {
    /* ignore — the session simply does not survive a reload */
  }
}

export function loadToken(): string | null {
  return read(TOKEN_KEY);
}

export function saveToken(token: string | null): void {
  write(TOKEN_KEY, token);
}

export type PendingCheckout = { plan_code: PlanCode; started_at: number };

/**
 * Remembered just before the redirect to Meteroid. On the way back the URL belongs to Meteroid's
 * checkout flow, not to us, so this marker — not a query parameter — is what tells the app a
 * checkout is in flight and which plan to wait for.
 */
export function loadPendingCheckout(): PendingCheckout | null {
  const raw = read(CHECKOUT_KEY);
  if (!raw) return null;
  try {
    const parsed = JSON.parse(raw) as PendingCheckout;
    return typeof parsed.plan_code === "string" ? parsed : null;
  } catch {
    return null;
  }
}

export function savePendingCheckout(pending: PendingCheckout | null): void {
  write(CHECKOUT_KEY, pending === null ? null : JSON.stringify(pending));
}

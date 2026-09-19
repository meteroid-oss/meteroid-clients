/**
 * Everything the suite reads from the environment, in one place.
 *
 * Only `BASE_URL` is required. The rest unlock tests that cannot be run without them;
 * those tests skip with a message naming the variable rather than failing, so a partial
 * environment still produces a useful report instead of a wall of red.
 */

function optional(name: string): string {
  return (process.env[name] ?? '').trim();
}

function stripTrailingSlash(url: string): string {
  return url.replace(/\/+$/, '');
}

/**
 * Which backend the suite drives. The one variable that must be set.
 *
 * Read from `SCRIBE_BASE_URL` first, because **Vitest claims `BASE_URL` for itself**: it
 * is Vite's public-base-path variable, and inside a test worker `process.env.BASE_URL` has
 * been overwritten with `/`. `vitest.config.ts` captures the real value in the parent
 * process and forwards it, so `BASE_URL=… npm test` keeps working; the direct read below
 * is the fallback for anything that imports this module outside Vitest, and it ignores a
 * bare `/` for the same reason.
 */
function resolveBaseUrl(): string {
  const forwarded = optional('SCRIBE_BASE_URL');
  if (forwarded) return forwarded;
  const raw = optional('BASE_URL');
  if (raw && raw !== '/') return raw;
  return 'http://localhost:8080';
}

export const BASE_URL = stripTrailingSlash(resolveBaseUrl());

/**
 * `whsec_…` signing secret of the Meteroid webhook endpoint, the *same* value the
 * backend under test has in `METEROID_WEBHOOK_SECRET`. The suite signs its own payloads
 * with it, which is how the webhook receiver is exercised with no live tenant and no
 * public tunnel.
 */
export const WEBHOOK_SECRET = optional('METEROID_WEBHOOK_SECRET');

/**
 * The backend's `SCRIBE_SESSION_SECRET`. Only used together with
 * `SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS`, to mint a session token for a workspace an
 * operator subscribed by hand.
 *
 * This deliberately reaches into an implementation detail: the contract calls the
 * session token opaque, and it is — but it also documents the exact HMAC construction
 * so every backend mints interchangeable tokens, and that construction is the only way
 * a test can get a handle on a *subscribed* workspace. Hosted checkout needs a browser,
 * so the suite cannot subscribe anyone itself. Prefer `SCRIBE_SUBSCRIBED_SESSION_TOKEN`
 * if you have a token already; then the secret is not needed at all.
 */
export const SESSION_SECRET = optional('SCRIBE_SESSION_SECRET');

/** A session token for a workspace that already has a subscription. */
export const SUBSCRIBED_SESSION_TOKEN = optional('SCRIBE_SUBSCRIBED_SESSION_TOKEN');

/** Meteroid customer alias of a workspace that already has a subscription. */
export const SUBSCRIBED_CUSTOMER_ALIAS = optional('SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS');

/**
 * Optional: assert `GET /api/health` reports this implementation. Set it in CI so a
 * mis-pointed `BASE_URL` (running the Java suite against the Rust port) fails loudly
 * instead of passing.
 */
export const EXPECT_BACKEND = optional('SCRIBE_EXPECT_BACKEND');

/** Per-request timeout. Meteroid-backed operations make one or two upstream calls. */
export const REQUEST_TIMEOUT_MS = Number(optional('SCRIBE_REQUEST_TIMEOUT_MS') || 20_000);

/** How long to wait for Meteroid's eventually-consistent usage counters to catch up. */
export const USAGE_SETTLE_MS = Number(optional('SCRIBE_USAGE_SETTLE_MS') || 15_000);

export const env = {
  BASE_URL,
  WEBHOOK_SECRET,
  SESSION_SECRET,
  SUBSCRIBED_SESSION_TOKEN,
  SUBSCRIBED_CUSTOMER_ALIAS,
  EXPECT_BACKEND,
  REQUEST_TIMEOUT_MS,
  USAGE_SETTLE_MS,
};

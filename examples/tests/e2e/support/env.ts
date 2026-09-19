/**
 * Every knob this suite reads, in one place.
 *
 * The suite is parameterized so the *same* script runs against any backend: point `BASE_URL` at
 * the Rust backend (8080), the Java one (8081) or the TypeScript one (8082) and nothing else
 * changes. `FRONTEND_URL` is separate because one SPA build serves all of them — it is the SPA's
 * own `VITE_API_BASE_URL` that decides which backend it talks to, and it is the operator's job to
 * make that agree with `BASE_URL` here.
 */

function required(name: string, fallback: string): string {
  const raw = process.env[name];
  return raw === undefined || raw.trim() === '' ? fallback : raw.trim();
}

function stripTrailingSlash(url: string): string {
  return url.replace(/\/+$/, '');
}

/** The demo backend under test. Matches the contract suite's variable of the same name. */
export const BASE_URL = stripTrailingSlash(required('BASE_URL', 'http://localhost:8080'));

/** The SPA under test. Vite's dev server default. */
export const FRONTEND_URL = stripTrailingSlash(required('FRONTEND_URL', 'http://localhost:5173'));

/**
 * A session token for a workspace that is already subscribed to a plan with a *finite*
 * `transcription_minutes` limit — i.e. Free.
 *
 * Why this cannot be created by the test: reaching a subscribed state means completing a hosted
 * Meteroid checkout, which is a payment flow on Meteroid's own domain. Automating someone else's
 * payment page is exactly the kind of brittle, breaks-on-their-redesign test this suite exists to
 * avoid. So the operator provisions one Free workspace by hand and exports its token.
 *
 * Session tokens are stateless HMACs over the customer alias (see `openapi.yaml`), so this value
 * does not expire and one fixture workspace serves every nightly run.
 *
 * Deliberately the *same* variable `tests/contract` reads: both suites need the same
 * hand-provisioned workspace for the same reason, and making an operator export one token under two
 * names would be a trap.
 *
 * Unset → the quota spec skips with a message rather than failing.
 */
export const SUBSCRIBED_SESSION_TOKEN =
  process.env.SCRIBE_SUBSCRIBED_SESSION_TOKEN?.trim() || undefined;

/** Plan the checkout spec starts a hosted checkout for. Must be a paid plan. */
export const CHECKOUT_PLAN_CODE = required('SCRIBE_E2E_CHECKOUT_PLAN', 'pro');

/**
 * localStorage key the SPA keeps its session token under.
 *
 * Part of the frontend contract (see README) — the suite writes it directly to put the browser in
 * a known state without clicking through workspace creation on every test.
 *
 * The key is **namespaced by the SPA's own API base URL** (`frontend/src/lib/storage.ts`), so that
 * pointing the SPA at the Java backend does not resurrect a workspace created against the Rust
 * one. That is why this is derived rather than a literal: it must be built the same way the SPA
 * builds it, from the same base URL, with trailing slashes stripped on both sides.
 *
 * This is the one place the suite depends on the SPA's `VITE_API_BASE_URL` agreeing with
 * `BASE_URL` here. They have to agree anyway — otherwise the browser and the spec's own HTTP
 * calls would be talking to two different backends — but if the token ever appears not to take,
 * this mismatch is the first thing to check.
 */
export const SESSION_STORAGE_KEY = `scribe:${BASE_URL}:session_token`;

/**
 * Demo session tokens.
 *
 * There is no real user auth in this demo — that is not what it teaches. A session
 * token is a stateless HMAC over the Meteroid customer alias:
 *
 * ```text
 * v1.<base64url(alias)>.<base64url(hmac_sha256(SCRIBE_SESSION_SECRET, alias))>
 * ```
 *
 * Stateless and deterministic means every backend that shares the secret mints and
 * accepts the same tokens, so one contract-suite session works against all of them.
 * The Meteroid API key never leaves the backend.
 */

import { createHmac, timingSafeEqual } from "node:crypto";

import { ApiError } from "./error.js";
import type { ScribeRequest } from "./http.js";
import type { AppState } from "./state.js";

export function mint(secret: string, alias: string): string {
  return `v1.${Buffer.from(alias, "utf8").toString("base64url")}.${sign(secret, alias).toString("base64url")}`;
}

/**
 * Returns the customer alias the token is bound to, or throws the `401 UNAUTHORIZED`
 * the caller answers with.
 */
export function verify(secret: string, token: string): string {
  const [version, aliasB64, ...rest] = token.split(".");
  if (version !== "v1" || aliasB64 === undefined || rest.length === 0) {
    throw ApiError.unauthorized("Session token is malformed; expected `v1.<payload>.<signature>`.");
  }

  const aliasBytes = decodeBase64Url(aliasB64);
  const alias = aliasBytes && decodeUtf8(aliasBytes);
  if (alias == null) {
    throw ApiError.unauthorized("Session token payload is not valid base64url UTF-8.");
  }
  // Everything after the second dot is the signature, so a token with a fourth segment
  // fails here rather than being quietly truncated.
  const signature = decodeBase64Url(rest.join("."));
  if (signature === null) {
    throw ApiError.unauthorized("Session token signature is not valid base64url.");
  }

  // Constant-time comparison. `timingSafeEqual` insists on equal lengths, and the
  // length of an HMAC-SHA256 is not a secret.
  const expected = sign(secret, alias);
  if (signature.length !== expected.length || !timingSafeEqual(signature, expected)) {
    throw ApiError.unauthorized("Session token was not signed by this deployment.");
  }
  return alias;
}

function sign(secret: string, alias: string): Buffer {
  return createHmac("sha256", secret).update(alias, "utf8").digest();
}

/**
 * Strict unpadded base64url. `Buffer.from(_, "base64url")` never fails — it skips what
 * it does not understand — so a forged token would decode to *something*. Re-encoding
 * and comparing is what makes this reject exactly what the other backends reject.
 */
function decodeBase64Url(value: string): Buffer | null {
  const bytes = Buffer.from(value, "base64url");
  return bytes.toString("base64url") === value ? bytes : null;
}

function decodeUtf8(bytes: Buffer): string | null {
  try {
    return new TextDecoder("utf-8", { fatal: true, ignoreBOM: true }).decode(bytes);
  } catch {
    return null;
  }
}

/** The workspace a request is acting on. */
export interface Session {
  /**
   * The Meteroid customer alias this workspace maps onto. Every Meteroid call in this
   * backend passes it where an `idOrAlias` is accepted.
   */
  customerAlias: string;
}

/**
 * Call this first in a handler and the route requires a valid
 * `Authorization: Bearer <session_token>` header.
 */
export function requireSession(state: AppState, request: ScribeRequest): Session {
  const header = request.headers["authorization"];
  const token = header?.startsWith("Bearer ") ? header.slice("Bearer ".length).trim() : "";
  if (token === "") {
    throw ApiError.unauthorized("Missing Authorization: Bearer <session_token> header.");
  }
  return { customerAlias: verify(state.config.sessionSecret, token) };
}

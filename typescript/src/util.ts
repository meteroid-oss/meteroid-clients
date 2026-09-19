import { parseOAuthErrorResponse, parseRestErrorResponse } from "./errors";
import type { OAuthErrorResponse } from "./models/oAuthErrorResponse";
import type { RestErrorResponse } from "./models/restErrorResponse";

/**
 * Thrown when the API answers with a non-2xx status.
 *
 * The body is parsed as a `RestErrorResponse` (`{code, message}`, what every
 * endpoint but the OAuth ones returns) and, failing that, as an
 * `OAuthErrorResponse`. At most one of `restError` / `oauthError` is set.
 *
 * `status`, `headers` and the raw `body` are always available, whatever the
 * status and whether or not the body parsed. Parsing is strict: a body that is
 * not JSON, does not match either shape, or carries an error code this SDK
 * version does not know (e.g. one added to the API later) leaves both typed
 * fields `undefined` — fall back to `status` and `body` in that case.
 *
 * ```typescript
 * if (err instanceof ApiException && err.restError?.code === ErrorCode.NotFound) {
 *   console.error(err.restError.message);
 * }
 * ```
 */
export class ApiException extends Error {
  /** HTTP status code of the response. */
  public readonly status: number;
  /** Raw response body, as received. */
  public readonly body: string;
  /** Response headers, keyed by lower-case name. */
  public readonly headers: Record<string, string> = {};
  /** The error body, when it is a `RestErrorResponse`. */
  public readonly restError: RestErrorResponse | undefined;
  /** The error body, when it is an `OAuthErrorResponse` (OAuth endpoints only). */
  public readonly oauthError: OAuthErrorResponse | undefined;

  public constructor(status: number, body: string, headers: Headers) {
    let json: unknown;
    try {
      json = JSON.parse(body);
    } catch {
      json = undefined;
    }
    const restError = parseRestErrorResponse(json);
    const oauthError =
      restError === undefined ? parseOAuthErrorResponse(json) : undefined;

    let detail = "";
    if (restError !== undefined) {
      detail = `: ${restError.code}: ${restError.message}`;
    } else if (oauthError !== undefined) {
      detail = `: ${oauthError.error}${oauthError.errorDescription ? `: ${oauthError.errorDescription}` : ""}`;
    }
    super(`API Error ${status}${detail}`);

    this.name = "ApiException";
    this.status = status;
    this.body = body;
    this.restError = restError;
    this.oauthError = oauthError;
    headers.forEach((value, key) => {
      this.headers[key] = value;
    });
  }
}

/**
 * XOR type helper - ensures exactly one of the properties is present.
 */
export type XOR<T, U> =
  | (T & { [K in keyof U]?: never })
  | (U & { [K in keyof T]?: never });

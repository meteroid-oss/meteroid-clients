/**
 * The single error envelope of `examples/openapi.yaml`.
 *
 * Every non-2xx response in this backend is an {@link ApiError}. `quota` and
 * `upgrade_plan_code` are always serialized, `null` where they do not apply, so a
 * strict client never has to tell an absent key from a null one.
 */

import { ApiException } from "@meteroid/sdk";

import type { PlanCode, QuotaSnapshot } from "./dto.js";

export type ErrorCode =
  | "BAD_REQUEST"
  | "UNAUTHORIZED"
  | "NOT_FOUND"
  // Reserved by the contract; no operation requires a subscription.
  | "NO_SUBSCRIPTION"
  | "FEATURE_NOT_ENTITLED"
  | "QUOTA_EXHAUSTED"
  | "CHECKOUT_UNAVAILABLE"
  | "CATALOG_NOT_SEEDED"
  | "WEBHOOK_SIGNATURE_INVALID"
  | "UPSTREAM_UNAUTHORIZED"
  | "UPSTREAM_ERROR"
  | "RATE_LIMITED"
  | "INTERNAL";

const STATUS: Record<ErrorCode, number> = {
  BAD_REQUEST: 400,
  WEBHOOK_SIGNATURE_INVALID: 400,
  UNAUTHORIZED: 401,
  QUOTA_EXHAUSTED: 402,
  FEATURE_NOT_ENTITLED: 403,
  NOT_FOUND: 404,
  NO_SUBSCRIPTION: 409,
  CHECKOUT_UNAVAILABLE: 409,
  RATE_LIMITED: 429,
  INTERNAL: 500,
  UPSTREAM_UNAUTHORIZED: 502,
  UPSTREAM_ERROR: 502,
  CATALOG_NOT_SEEDED: 503,
};

/** The wire shape of the contract's `Error` schema. */
export interface ErrorBody {
  code: ErrorCode;
  message: string;
  quota: QuotaSnapshot | null;
  upgrade_plan_code: PlanCode | null;
}

export class ApiError extends Error {
  public readonly code: ErrorCode;
  public quota: QuotaSnapshot | null = null;
  public upgradePlanCode: PlanCode | null = null;
  /** Set only where the HTTP status is not the one the code implies (a 413). */
  private statusOverride: number | null = null;

  public constructor(code: ErrorCode, message: string) {
    super(message);
    this.name = "ApiError";
    this.code = code;
  }

  public get status(): number {
    return this.statusOverride ?? STATUS[this.code];
  }

  public withQuota(quota: QuotaSnapshot): this {
    this.quota = quota;
    return this;
  }

  public withUpgrade(plan: PlanCode | null): this {
    this.upgradePlanCode = plan;
    return this;
  }

  public withStatus(status: number): this {
    this.statusOverride = status;
    return this;
  }

  public static badRequest(message: string): ApiError {
    return new ApiError("BAD_REQUEST", message);
  }

  public static unauthorized(message: string): ApiError {
    return new ApiError("UNAUTHORIZED", message);
  }

  public static catalogNotSeeded(message: string): ApiError {
    return new ApiError("CATALOG_NOT_SEEDED", message);
  }

  public static internal(message: string): ApiError {
    return new ApiError("INTERNAL", message);
  }

  /** Every key, every time: this is what `JSON.stringify` sends. */
  public toJSON(): ErrorBody {
    return {
      code: this.code,
      message: this.message,
      quota: this.quota,
      upgrade_plan_code: this.upgradePlanCode,
    };
  }
}

/**
 * Translate an SDK failure into this contract's envelope. Written to sit in a
 * `.catch(...)` directly under the SDK call it belongs to:
 *
 * ```ts
 * await meteroid.customers.getCustomer(alias).catch(upstream(`GET /api/v1/customers/${alias}`));
 * ```
 *
 * The SDK throws an `ApiException` for every non-2xx answer, and its `status` is what
 * separates "your API key is wrong" (an operator problem) from "Meteroid is throttling"
 * (retry) from everything else. When the body parsed as Meteroid's error envelope,
 * `restError` carries the typed `code` and `message`. Anything that is *not* an
 * `ApiException` never got an HTTP answer at all: a refused connection, a timeout, or a
 * 2xx body the SDK could not decode.
 */
export function upstream(context: string): (err: unknown) => never {
  return (err) => {
    throw toApiError(context, err);
  };
}

function toApiError(context: string, err: unknown): ApiError {
  if (err instanceof ApiError) {
    return err;
  }
  if (!(err instanceof ApiException)) {
    return new ApiError(
      "UPSTREAM_ERROR",
      `Could not reach Meteroid for ${context}: ${describe(err)}`,
    );
  }

  const { status } = err;
  if (status === 401 || status === 403) {
    return new ApiError(
      "UPSTREAM_UNAUTHORIZED",
      `Meteroid rejected the API key on ${context} (HTTP ${status}). Check METEROID_API_KEY.`,
    );
  }
  if (status === 429) {
    return new ApiError("RATE_LIMITED", `Meteroid responded 429 to ${context}. Retry shortly.`);
  }

  const detail = err.restError
    ? `${err.restError.code}: ${err.restError.message}`
    : err.oauthError
      ? `${err.oauthError.error}: ${err.oauthError.errorDescription ?? ""}`
      : err.body;
  return new ApiError(
    "UPSTREAM_ERROR",
    `Meteroid responded ${status} to ${context}: ${truncate(detail)}`,
  );
}

/**
 * True when the SDK error is an upstream 404 — "this object does not exist", which for
 * a catalog lookup means "not seeded" rather than "Meteroid is broken".
 */
export function isNotFound(err: unknown): boolean {
  return err instanceof ApiException && err.status === 404;
}

/** `fetch` reports a refused connection as a bare "fetch failed"; the reason is in `cause`. */
function describe(err: unknown): string {
  if (!(err instanceof Error)) {
    return String(err);
  }
  return err.cause instanceof Error ? `${err.message} (${err.cause.message})` : err.message;
}

function truncate(body: string): string {
  const MAX = 300;
  const chars = Array.from(body);
  return chars.length <= MAX ? body : `${chars.slice(0, MAX).join("")}…`;
}

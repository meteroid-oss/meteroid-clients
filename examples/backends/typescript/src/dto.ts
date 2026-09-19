/**
 * The wire types of `examples/openapi.yaml`, one interface per schema.
 *
 * Two rules from the contract are enforced here by construction:
 *
 * - **Decimals are strings.** Every Meteroid `format: decimal` value is a `string`
 *   produced by `decimal.normalize`, never a JSON number.
 * - **Nullable means present-and-null.** No response property is declared with `?`, so
 *   the compiler refuses an object literal that leaves a key out, and
 *   `exactOptionalPropertyTypes` refuses an `undefined` — the one value `JSON.stringify`
 *   would silently drop. A strict deserializer on the other side never has to
 *   distinguish "absent" from "null".
 *
 * Request bodies are the opposite by design (absent and `null` are equivalent) and are
 * decoded by hand at the bottom of this file, because `JSON.parse` validates nothing:
 * the contract says `additionalProperties: false` and types every scalar, and a request
 * that breaks either is a `400`, not something to coerce.
 */

import { ApiError } from "./error.js";

// ---------------------------------------------------------------- shared

/** Cheapest first, matching the order `GET /api/plans` promises. */
export const PLAN_CODES = ["free", "pro", "scale"] as const;

export type PlanCode = (typeof PLAN_CODES)[number];

/**
 * The exact Meteroid plan **name** each code maps onto. Meteroid plans have no
 * user-supplied code, so the seeded name is the lookup key — see `examples/CATALOG.md`.
 */
export const METEROID_PLAN_NAME: Record<PlanCode, string> = {
  free: "Scribe Free",
  pro: "Scribe Pro",
  scale: "Scribe Scale",
};

/** The plan to offer as an upgrade when this one runs out of quota. */
export function nextUp(code: PlanCode): PlanCode | null {
  return code === "free" ? "pro" : code === "pro" ? "scale" : null;
}

// ---------------------------------------------------------------- ops

export interface Health {
  status: "ok";
  backend: "typescript";
  meteroid_configured: boolean;
  version: string | null;
}

// ---------------------------------------------------------------- session

export interface CreateSessionRequest {
  workspace_name: string | null;
  email: string | null;
}

export interface Workspace {
  id: string;
  name: string;
  customer_id: string;
  customer_alias: string;
  currency: string;
}

export interface CreateSessionResponse {
  session_token: string;
  workspace: Workspace;
}

export interface Subscription {
  id: string;
  status: string;
  plan_code: PlanCode | null;
  plan_name: string;
  plan_version_id: string;
  currency: string;
  current_period_start: string;
  current_period_end: string | null;
  trial_duration_days: number | null;
  created_at: string;
}

export interface MeResponse {
  workspace: Workspace;
  subscription: Subscription | null;
  plan: Plan | null;
}

// ---------------------------------------------------------------- catalog

export type PriceKind = "RATE" | "SLOT" | "CAPACITY" | "USAGE" | "EXTRA_RECURRING" | "ONE_TIME";

export type UsagePricingModel = "PER_UNIT" | "TIERED" | "VOLUME" | "PACKAGE" | "MATRIX";

export interface PlanPrice {
  component_id: string;
  name: string;
  kind: PriceKind;
  cadence: string | null;
  amount: string | null;
  unit_amount: string | null;
  included_amount: string | null;
  unit_name: string | null;
  pricing_model: UsagePricingModel | null;
}

export interface PlanFeatureLine {
  feature_code: string;
  label: string;
}

export interface Plan {
  code: PlanCode;
  name: string;
  description: string | null;
  plan_id: string;
  plan_version_id: string;
  version: number;
  currency: string;
  is_free: boolean;
  trial_days: number | null;
  prices: PlanPrice[];
  features: PlanFeatureLine[];
}

export interface PlanListResponse {
  plans: Plan[];
}

// ---------------------------------------------------------------- checkout

export interface CreateCheckoutRequest {
  plan_code: PlanCode;
  coupon_code: string | null;
}

export interface CreateCheckoutResponse {
  checkout_url: string;
  checkout_session_id: string;
  plan_code: PlanCode;
  plan_version_id: string;
  expires_at: string | null;
}

// ----------------------------------------------------------- entitlements

export interface ResetPeriod {
  type: "BILLING_CYCLE" | "CALENDAR" | "FIXED_WINDOW" | "SLIDING_WINDOW" | "NEVER";
  interval: number | null;
  unit: string | null;
}

export interface QuotaSnapshot {
  feature_code: string;
  enabled: boolean;
  limit: string | null;
  consumed: string | null;
  remaining: string | null;
  reset_at: string | null;
  unlimited: boolean;
}

/** A typed configuration value, tagged by `kind`. */
export type ConfigValue =
  | { kind: "NUMBER"; value: string }
  | { kind: "BOOLEAN"; value: boolean }
  | { kind: "TEXT"; value: string }
  | { kind: "JSON"; value: unknown };

/** The three-way entitlement union, tagged by `type` exactly as Meteroid tags it. */
export type EntitlementValue =
  | { type: "BOOLEAN"; enabled: boolean }
  | {
      type: "METERED";
      enabled: boolean;
      limit: string | null;
      consumed: string | null;
      remaining: string | null;
      unlimited: boolean;
      reset_at: string | null;
      reset_period: ResetPeriod;
      metric_code: string | null;
    }
  | { type: "CONFIG"; value: ConfigValue };

export interface Entitlement {
  feature_code: string;
  feature_name: string;
  value: EntitlementValue;
}

export interface EntitlementListResponse {
  entitlements: Entitlement[];
}

// ----------------------------------------------------------- transcription

export interface CreateTranscriptionRequest {
  title: string;
  duration_seconds: number;
}

export interface Transcription {
  id: string;
  title: string;
  duration_seconds: number;
  minutes_billed: string;
  text: string;
  created_at: string;
  event_id: string;
}

export interface CreateTranscriptionResponse {
  transcription: Transcription;
  quota: QuotaSnapshot;
}

export interface TranscriptionListResponse {
  transcriptions: Transcription[];
}

// ---------------------------------------------------------------- usage

export interface GroupedUsage {
  dimensions: Record<string, string>;
  value: string;
}

export interface MetricUsage {
  metric_code: string;
  metric_name: string;
  total_value: string;
  grouped_usage: GroupedUsage[];
}

export interface UsageResponse {
  period_start: string;
  period_end: string;
  scope: "subscription" | "customer";
  metrics: MetricUsage[];
}

// ---------------------------------------------------------------- portal

export interface CreatePortalSessionRequest {
  expires_in_seconds: number | null;
}

export interface CreatePortalSessionResponse {
  portal_url: string;
  token: string;
  expires_in_seconds: number;
}

// ---------------------------------------------------------------- invoices

export interface Invoice {
  id: string;
  invoice_number: string;
  status: string;
  currency: string;
  invoice_date: string;
  due_date: string | null;
  total: number;
  amount_due: number;
}

export interface InvoiceListResponse {
  invoices: Invoice[];
}

// ---------------------------------------------------------------- webhooks

export interface WebhookAck {
  received: true;
  event_id: string;
  type: string | null;
  handled: boolean;
}

// ------------------------------------------------------------ timestamps

/**
 * The SDK hands every `format: date-time` field over as a `Date`; the contract wants
 * RFC 3339 back. A `Date` the SDK built from something unparseable is "Invalid Date",
 * and `toISOString()` throws on it — which is Meteroid's problem, not an internal error.
 */
export function timestamp(value: Date): string {
  if (Number.isNaN(value.getTime())) {
    throw new ApiError("UPSTREAM_ERROR", "Meteroid returned a timestamp that is not a date-time.");
  }
  return value.toISOString();
}

export function timestampOpt(value: Date | null | undefined): string | null {
  return value == null ? null : timestamp(value);
}

// ------------------------------------------------------- request decoding

export function decodeCreateSessionRequest(json: unknown): CreateSessionRequest {
  const body = strictObject(json, "CreateSessionRequest", ["workspace_name", "email"]);
  return {
    workspace_name: optionalString(body, "workspace_name"),
    email: optionalString(body, "email"),
  };
}

export function decodeCreateCheckoutRequest(json: unknown): CreateCheckoutRequest {
  const body = strictObject(json, "CreateCheckoutRequest", ["plan_code", "coupon_code"]);
  const planCode = requiredString(body, "plan_code");
  if (!isPlanCode(planCode)) {
    throw invalid(
      `unknown plan_code ${JSON.stringify(planCode)}, expected one of ${PLAN_CODES.join(", ")}`,
    );
  }
  return { plan_code: planCode, coupon_code: optionalString(body, "coupon_code") };
}

export function decodeCreateTranscriptionRequest(json: unknown): CreateTranscriptionRequest {
  const body = strictObject(json, "CreateTranscriptionRequest", ["title", "duration_seconds"]);
  return {
    title: requiredString(body, "title"),
    duration_seconds: requiredInt32(body, "duration_seconds"),
  };
}

export function decodeCreatePortalSessionRequest(json: unknown): CreatePortalSessionRequest {
  const body = strictObject(json, "CreatePortalSessionRequest", ["expires_in_seconds"]);
  return {
    expires_in_seconds:
      body["expires_in_seconds"] == null ? null : requiredInt32(body, "expires_in_seconds"),
  };
}

function isPlanCode(value: string): value is PlanCode {
  return (PLAN_CODES as readonly string[]).includes(value);
}

function invalid(detail: string): ApiError {
  return ApiError.badRequest(`Invalid body: ${detail}`);
}

/** `additionalProperties: false`: a JSON object, and no key the schema does not list. */
function strictObject(
  json: unknown,
  schema: string,
  allowed: readonly string[],
): Record<string, unknown> {
  if (typeof json !== "object" || json === null || Array.isArray(json)) {
    throw invalid(`expected a ${schema} object, got ${kindOf(json)}`);
  }
  for (const key of Object.keys(json)) {
    if (!allowed.includes(key)) {
      throw invalid(`unknown field \`${key}\`, expected ${allowed.map((k) => `\`${k}\``).join(" or ")}`);
    }
  }
  return json as Record<string, unknown>;
}

function requiredString(body: Record<string, unknown>, key: string): string {
  const value = body[key];
  if (value === undefined) {
    throw invalid(`missing field \`${key}\``);
  }
  // No coercion: `{"title": 123}` is a type error, not the string "123".
  if (typeof value !== "string") {
    throw invalid(`${key}: expected a string, got ${kindOf(value)}`);
  }
  return value;
}

function optionalString(body: Record<string, unknown>, key: string): string | null {
  return body[key] == null ? null : requiredString(body, key);
}

/** The contract types its integers `format: int32`, so the range is part of the type. */
function requiredInt32(body: Record<string, unknown>, key: string): number {
  const value = body[key];
  if (value === undefined) {
    throw invalid(`missing field \`${key}\``);
  }
  if (typeof value !== "number" || !Number.isInteger(value) || Math.abs(value) > 2_147_483_647) {
    throw invalid(`${key}: expected a 32-bit integer, got ${kindOf(value)}`);
  }
  return value;
}

function kindOf(value: unknown): string {
  if (value === null) return "null";
  if (Array.isArray(value)) return "an array";
  return typeof value === "object" ? "an object" : `${typeof value} \`${String(value)}\``;
}

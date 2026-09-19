/**
 * Friendly aliases over the generated `schema.ts`.
 *
 * Nothing is re-declared here — every type below is the one openapi-typescript derived from
 * `examples/openapi.yaml`, so a change to the contract shows up as a type error in this app.
 */
import type { components } from "./schema";

type S = components["schemas"];

export type PlanCode = S["PlanCode"];
export type Currency = S["Currency"];
/** An exact decimal, as a string. Never parse one to a number except for display. */
export type Decimal = S["Decimal"];

export type Health = S["Health"];
export type Workspace = S["Workspace"];
export type Subscription = S["Subscription"];
export type SubscriptionStatus = S["SubscriptionStatus"];
export type MeResponse = S["MeResponse"];

export type Plan = S["Plan"];
export type PlanPrice = S["PlanPrice"];
export type PlanFeatureLine = S["PlanFeatureLine"];
export type PriceKind = S["PriceKind"];
export type BillingPeriod = S["BillingPeriod"];

export type CreateCheckoutRequest = S["CreateCheckoutRequest"];
export type CreateCheckoutResponse = S["CreateCheckoutResponse"];

export type Entitlement = S["Entitlement"];
export type EntitlementValue = S["EntitlementValue"];
export type BooleanEntitlementValue = S["BooleanEntitlementValue"];
export type MeteredEntitlementValue = S["MeteredEntitlementValue"];
export type ConfigEntitlementValue = S["ConfigEntitlementValue"];
export type ConfigValue = S["ConfigValue"];
export type QuotaSnapshot = S["QuotaSnapshot"];
export type ResetPeriod = S["ResetPeriod"];

export type Transcription = S["Transcription"];
export type CreateTranscriptionRequest = S["CreateTranscriptionRequest"];
export type CreateTranscriptionResponse = S["CreateTranscriptionResponse"];

export type UsageResponse = S["UsageResponse"];
export type MetricUsage = S["MetricUsage"];

export type Invoice = S["Invoice"];
export type InvoiceStatus = S["InvoiceStatus"];

export type CreateSessionRequest = S["CreateSessionRequest"];
export type CreateSessionResponse = S["CreateSessionResponse"];
export type CreatePortalSessionResponse = S["CreatePortalSessionResponse"];

export type ErrorCode = S["ErrorCode"];
export type ErrorBody = S["Error"];

/** The feature codes the seeded Scribe catalog uses. See `examples/CATALOG.md`. */
export const FEATURE = {
  minutes: "transcription_minutes",
  sso: "sso",
  retention: "retention_days",
  seats: "seats",
} as const;

/** Narrowing helpers, so screens switch on the tag instead of sniffing the shape. */
export function asMetered(e: Entitlement | undefined): MeteredEntitlementValue | null {
  return e && e.value.type === "METERED" ? e.value : null;
}

export function asBoolean(e: Entitlement | undefined): BooleanEntitlementValue | null {
  return e && e.value.type === "BOOLEAN" ? e.value : null;
}

export function asConfig(e: Entitlement | undefined): ConfigValue | null {
  return e && e.value.type === "CONFIG" ? e.value.value : null;
}

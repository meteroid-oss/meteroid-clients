/**
 * TypeScript views of the contract's response bodies.
 *
 * These are a *convenience for reading the tests*, not the thing being enforced. Ajv,
 * driven by `examples/openapi.yaml`, is what decides whether a body conforms; these
 * interfaces only let a test say `me.subscription?.plan_code` without casting. If one of
 * them ever disagrees with the YAML, the YAML wins and the schema check catches it first.
 */

export type PlanCode = 'free' | 'pro' | 'scale';

export type ErrorCode =
  | 'BAD_REQUEST'
  | 'UNAUTHORIZED'
  | 'NOT_FOUND'
  | 'NO_SUBSCRIPTION'
  | 'FEATURE_NOT_ENTITLED'
  | 'QUOTA_EXHAUSTED'
  | 'CHECKOUT_UNAVAILABLE'
  | 'CATALOG_NOT_SEEDED'
  | 'WEBHOOK_SIGNATURE_INVALID'
  | 'UPSTREAM_UNAUTHORIZED'
  | 'UPSTREAM_ERROR'
  | 'RATE_LIMITED'
  | 'INTERNAL';

export interface QuotaSnapshot {
  feature_code: string;
  enabled: boolean;
  limit: string | null;
  consumed: string | null;
  remaining: string | null;
  reset_at: string | null;
  unlimited: boolean;
}

export interface ScribeError {
  code: ErrorCode;
  message: string;
  quota: QuotaSnapshot | null;
  upgrade_plan_code: PlanCode | null;
}

export interface Health {
  status: 'ok';
  backend: 'rust' | 'java' | 'typescript' | 'python' | 'go';
  meteroid_configured: boolean;
  version: string | null;
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

export interface PlanPrice {
  component_id: string;
  name: string;
  kind: 'RATE' | 'SLOT' | 'CAPACITY' | 'USAGE' | 'EXTRA_RECURRING' | 'ONE_TIME';
  cadence: string | null;
  amount: string | null;
  unit_amount: string | null;
  included_amount: string | null;
  unit_name: string | null;
  pricing_model: 'PER_UNIT' | 'TIERED' | 'VOLUME' | 'PACKAGE' | 'MATRIX' | null;
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

export interface MeResponse {
  workspace: Workspace;
  subscription: Subscription | null;
  plan: Plan | null;
}

export interface PlanListResponse {
  plans: Plan[];
}

export interface CreateCheckoutResponse {
  checkout_url: string;
  checkout_session_id: string;
  plan_code: PlanCode;
  plan_version_id: string;
  expires_at: string | null;
}

export interface ResetPeriod {
  type: 'BILLING_CYCLE' | 'CALENDAR' | 'FIXED_WINDOW' | 'SLIDING_WINDOW' | 'NEVER';
  interval: number | null;
  unit: 'HOUR' | 'DAY' | 'WEEK' | 'MONTH' | 'YEAR' | null;
}

export type ConfigValue =
  | { kind: 'NUMBER'; value: string }
  | { kind: 'BOOLEAN'; value: boolean }
  | { kind: 'TEXT'; value: string }
  | { kind: 'JSON'; value: unknown };

export interface BooleanEntitlementValue {
  type: 'BOOLEAN';
  enabled: boolean;
}

export interface MeteredEntitlementValue {
  type: 'METERED';
  enabled: boolean;
  limit: string | null;
  consumed: string | null;
  remaining: string | null;
  unlimited: boolean;
  reset_at: string | null;
  reset_period: ResetPeriod;
  metric_code: string | null;
}

export interface ConfigEntitlementValue {
  type: 'CONFIG';
  value: ConfigValue;
}

export type EntitlementValue =
  | BooleanEntitlementValue
  | MeteredEntitlementValue
  | ConfigEntitlementValue;

export interface Entitlement {
  feature_code: string;
  feature_name: string;
  value: EntitlementValue;
}

export interface EntitlementListResponse {
  entitlements: Entitlement[];
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
  scope: 'subscription' | 'customer';
  metrics: MetricUsage[];
}

export interface CreatePortalSessionResponse {
  portal_url: string;
  token: string;
  expires_in_seconds: number;
}

export interface Invoice {
  id: string;
  invoice_number: string;
  status: 'DRAFT' | 'FINALIZED' | 'UNCOLLECTIBLE' | 'VOID' | 'CLOSED';
  currency: string;
  invoice_date: string;
  due_date: string | null;
  total: number;
  amount_due: number;
}

export interface InvoiceListResponse {
  invoices: Invoice[];
}

export interface WebhookAck {
  received: true;
  event_id: string;
  type: string | null;
  handled: boolean;
}

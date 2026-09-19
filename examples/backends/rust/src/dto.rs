//! The wire types of `examples/openapi.yaml`, one struct per schema.
//!
//! Two rules from the contract are enforced here by construction:
//!
//! * **Decimals are strings.** Every Meteroid `format: decimal` value is carried
//!   as a `String` produced by [`decimal`], never as a JSON number.
//! * **Nullable means present-and-null.** Nothing is `skip_serializing_if`, so
//!   every response object serializes every key. A strict deserializer on the
//!   other side never has to distinguish "absent" from "null".

use rust_decimal::Decimal;
use serde::{Deserialize, Serialize};

/// Render a decimal the way the contract requires: an exact string, trailing
/// zeros trimmed, never scientific notation.
pub fn decimal(value: Decimal) -> String {
    value.normalize().to_string()
}

pub fn decimal_opt(value: Option<Decimal>) -> Option<String> {
    value.map(decimal)
}

// ---------------------------------------------------------------- shared

#[derive(Clone, Copy, Debug, PartialEq, Eq, Serialize, Deserialize)]
#[serde(rename_all = "lowercase")]
pub enum PlanCode {
    Free,
    Pro,
    Scale,
}

impl PlanCode {
    /// Cheapest first, matching the order `GET /api/plans` promises.
    pub const ALL: [PlanCode; 3] = [PlanCode::Free, PlanCode::Pro, PlanCode::Scale];

    /// The wire value of this code, exactly as it appears in the contract's enum.
    pub fn as_str(self) -> &'static str {
        match self {
            PlanCode::Free => "free",
            PlanCode::Pro => "pro",
            PlanCode::Scale => "scale",
        }
    }

    /// The exact Meteroid plan **name** this code maps onto. Meteroid plans have
    /// no user-supplied code, so the seeded name is the lookup key — see
    /// `examples/CATALOG.md`.
    pub fn meteroid_plan_name(self) -> &'static str {
        match self {
            PlanCode::Free => "Scribe Free",
            PlanCode::Pro => "Scribe Pro",
            PlanCode::Scale => "Scribe Scale",
        }
    }

    /// The plan to offer as an upgrade when this one runs out of quota.
    pub fn next_up(self) -> Option<PlanCode> {
        match self {
            PlanCode::Free => Some(PlanCode::Pro),
            PlanCode::Pro => Some(PlanCode::Scale),
            PlanCode::Scale => None,
        }
    }
}

// ---------------------------------------------------------------- ops

#[derive(Debug, Serialize)]
pub struct Health {
    pub status: &'static str,
    pub backend: &'static str,
    pub meteroid_configured: bool,
    pub version: Option<String>,
}

// ---------------------------------------------------------------- session

#[derive(Debug, Default, Deserialize)]
#[serde(deny_unknown_fields)]
pub struct CreateSessionRequest {
    #[serde(default)]
    pub workspace_name: Option<String>,
    #[serde(default)]
    pub email: Option<String>,
}

#[derive(Debug, Serialize)]
pub struct Workspace {
    pub id: String,
    pub name: String,
    pub customer_id: String,
    pub customer_alias: String,
    pub currency: String,
}

#[derive(Debug, Serialize)]
pub struct CreateSessionResponse {
    pub session_token: String,
    pub workspace: Workspace,
}

#[derive(Debug, Serialize)]
pub struct Subscription {
    pub id: String,
    pub status: String,
    pub plan_code: Option<PlanCode>,
    pub plan_name: String,
    pub plan_version_id: String,
    pub currency: String,
    pub current_period_start: String,
    pub current_period_end: Option<String>,
    pub trial_duration_days: Option<i32>,
    pub created_at: String,
}

#[derive(Debug, Serialize)]
pub struct MeResponse {
    pub workspace: Workspace,
    pub subscription: Option<Subscription>,
    pub plan: Option<Plan>,
}

// ---------------------------------------------------------------- catalog

#[derive(Clone, Debug, Serialize)]
pub struct PlanPrice {
    pub component_id: String,
    pub name: String,
    pub kind: &'static str,
    pub cadence: Option<String>,
    pub amount: Option<String>,
    pub unit_amount: Option<String>,
    pub included_amount: Option<String>,
    pub unit_name: Option<String>,
    pub pricing_model: Option<&'static str>,
}

#[derive(Clone, Debug, Serialize)]
pub struct PlanFeatureLine {
    pub feature_code: String,
    pub label: String,
}

#[derive(Clone, Debug, Serialize)]
pub struct Plan {
    pub code: PlanCode,
    pub name: String,
    pub description: Option<String>,
    pub plan_id: String,
    pub plan_version_id: String,
    pub version: i32,
    pub currency: String,
    pub is_free: bool,
    pub trial_days: Option<i32>,
    pub prices: Vec<PlanPrice>,
    pub features: Vec<PlanFeatureLine>,
}

#[derive(Debug, Serialize)]
pub struct PlanListResponse {
    pub plans: Vec<Plan>,
}

// ---------------------------------------------------------------- checkout

#[derive(Debug, Deserialize)]
#[serde(deny_unknown_fields)]
pub struct CreateCheckoutRequest {
    pub plan_code: PlanCode,
    #[serde(default)]
    pub coupon_code: Option<String>,
}

#[derive(Debug, Serialize)]
pub struct CreateCheckoutResponse {
    pub checkout_url: String,
    pub checkout_session_id: String,
    pub plan_code: PlanCode,
    pub plan_version_id: String,
    pub expires_at: Option<String>,
}

// ----------------------------------------------------------- entitlements

#[derive(Clone, Debug, Serialize)]
pub struct ResetPeriod {
    #[serde(rename = "type")]
    pub kind: &'static str,
    pub interval: Option<i32>,
    pub unit: Option<String>,
}

#[derive(Clone, Debug, Serialize)]
pub struct QuotaSnapshot {
    pub feature_code: String,
    pub enabled: bool,
    pub limit: Option<String>,
    pub consumed: Option<String>,
    pub remaining: Option<String>,
    pub reset_at: Option<String>,
    pub unlimited: bool,
}

/// The three-way entitlement union, tagged by `type` exactly as Meteroid tags it.
#[derive(Clone, Debug, Serialize)]
#[serde(tag = "type")]
pub enum EntitlementValue {
    #[serde(rename = "BOOLEAN")]
    Boolean { enabled: bool },
    #[serde(rename = "METERED")]
    Metered {
        enabled: bool,
        limit: Option<String>,
        consumed: Option<String>,
        remaining: Option<String>,
        unlimited: bool,
        reset_at: Option<String>,
        reset_period: ResetPeriod,
        metric_code: Option<String>,
    },
    #[serde(rename = "CONFIG")]
    Config { value: ConfigValue },
}

/// A typed configuration value, tagged by `kind`.
#[derive(Clone, Debug, Serialize)]
#[serde(tag = "kind", content = "value")]
pub enum ConfigValue {
    #[serde(rename = "NUMBER")]
    Number(String),
    #[serde(rename = "BOOLEAN")]
    Boolean(bool),
    #[serde(rename = "TEXT")]
    Text(String),
    #[serde(rename = "JSON")]
    Json(serde_json::Value),
}

#[derive(Clone, Debug, Serialize)]
pub struct Entitlement {
    pub feature_code: String,
    pub feature_name: String,
    pub value: EntitlementValue,
}

#[derive(Debug, Serialize)]
pub struct EntitlementListResponse {
    pub entitlements: Vec<Entitlement>,
}

// ----------------------------------------------------------- transcription

#[derive(Debug, Deserialize)]
#[serde(deny_unknown_fields)]
pub struct CreateTranscriptionRequest {
    pub title: String,
    pub duration_seconds: i32,
}

#[derive(Clone, Debug, Serialize)]
pub struct Transcription {
    pub id: String,
    pub title: String,
    pub duration_seconds: i32,
    pub minutes_billed: String,
    pub text: String,
    pub created_at: String,
    pub event_id: String,
}

#[derive(Debug, Serialize)]
pub struct CreateTranscriptionResponse {
    pub transcription: Transcription,
    pub quota: QuotaSnapshot,
}

#[derive(Debug, Serialize)]
pub struct TranscriptionListResponse {
    pub transcriptions: Vec<Transcription>,
}

// ---------------------------------------------------------------- usage

#[derive(Debug, Serialize)]
pub struct GroupedUsage {
    pub dimensions: std::collections::HashMap<String, String>,
    pub value: String,
}

#[derive(Debug, Serialize)]
pub struct MetricUsage {
    pub metric_code: String,
    pub metric_name: String,
    pub total_value: String,
    pub grouped_usage: Vec<GroupedUsage>,
}

#[derive(Debug, Serialize)]
pub struct UsageResponse {
    pub period_start: String,
    pub period_end: String,
    pub scope: &'static str,
    pub metrics: Vec<MetricUsage>,
}

// ---------------------------------------------------------------- portal

#[derive(Debug, Default, Deserialize)]
#[serde(deny_unknown_fields)]
pub struct CreatePortalSessionRequest {
    #[serde(default)]
    pub expires_in_seconds: Option<i32>,
}

#[derive(Debug, Serialize)]
pub struct CreatePortalSessionResponse {
    pub portal_url: String,
    pub token: String,
    pub expires_in_seconds: i32,
}

// ---------------------------------------------------------------- invoices

#[derive(Debug, Serialize)]
pub struct Invoice {
    pub id: String,
    pub invoice_number: String,
    pub status: String,
    pub currency: String,
    pub invoice_date: String,
    pub due_date: Option<String>,
    pub total: i64,
    pub amount_due: i64,
}

#[derive(Debug, Serialize)]
pub struct InvoiceListResponse {
    pub invoices: Vec<Invoice>,
}

// ---------------------------------------------------------------- webhooks

#[derive(Debug, Serialize)]
pub struct WebhookAck {
    pub received: bool,
    pub event_id: String,
    #[serde(rename = "type")]
    pub kind: Option<String>,
    pub handled: bool,
}

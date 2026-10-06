// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billing_period_enum::BillingPeriodEnum, customer_id::CustomerId,
    subscription_id::SubscriptionId, subscription_status_enum::SubscriptionStatusEnum,
    subscription_update_type::SubscriptionUpdateType,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct SubscriptionEventData {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub activated_at: Option<chrono::DateTime<chrono::Utc>>,

    pub auto_advance_invoices: bool,

    pub billing_day_anchor: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_start_date: Option<chrono::NaiveDate>,

    /// Present on `subscription.cancelled` when a reason was supplied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub cancellation_reason: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub change_type: Option<SubscriptionUpdateType>,

    pub charge_automatically: bool,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: String,

    /// User-defined custom property values, keyed by definition key.
    pub custom_properties: serde_json::Value,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub customer_alias: Option<String>,

    pub customer_id: CustomerId,

    pub customer_name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub end_date: Option<chrono::NaiveDate>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_memo: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_threshold: Option<String>,

    pub mrr_cents: i64,

    pub net_terms: i32,

    pub period: BillingPeriodEnum,

    pub plan_name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub purchase_order: Option<String>,

    pub start_date: chrono::NaiveDate,

    pub status: SubscriptionStatusEnum,

    pub subscription_id: SubscriptionId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial_duration: Option<i32>,

    pub version: i32,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        auto_advance_invoices: bool,
        billing_day_anchor: i32,
        charge_automatically: bool,
        created_at: chrono::DateTime<chrono::Utc>,
        currency: impl Into<String>,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        customer_name: impl Into<String>,
        mrr_cents: i64,
        net_terms: i32,
        period: BillingPeriodEnum,
        plan_name: impl Into<String>,
        start_date: chrono::NaiveDate,
        status: SubscriptionStatusEnum,
        subscription_id: SubscriptionId,
        version: i32,
    ) -> Self {
        Self {
            activated_at: None,
            auto_advance_invoices,
            billing_day_anchor,
            billing_start_date: None,
            cancellation_reason: None,
            change_type: None,
            charge_automatically,
            created_at,
            currency: currency.into(),
            custom_properties,
            customer_alias: None,
            customer_id,
            customer_name: customer_name.into(),
            end_date: None,
            invoice_memo: None,
            invoice_threshold: None,
            mrr_cents,
            net_terms,
            period,
            plan_name: plan_name.into(),
            purchase_order: None,
            start_date,
            status,
            subscription_id,
            trial_duration: None,
            version,
            extra: serde_json::Map::new(),
        }
    }
}

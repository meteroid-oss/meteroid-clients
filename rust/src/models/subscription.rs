// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billing_period_enum::BillingPeriodEnum, currency::Currency, customer_id::CustomerId,
    payment_methods_config::PaymentMethodsConfig, plan_id::PlanId, plan_version_id::PlanVersionId,
    subscription_id::SubscriptionId, subscription_status_enum::SubscriptionStatusEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Subscription {
    /// When the subscription was activated (first payment or activation condition met)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub activated_at: Option<chrono::DateTime<chrono::Utc>>,

    /// If false, invoices will stay in Draft until manually reviewed and finalized. Default to true.
    pub auto_advance_invoices: bool,

    pub billing_day_anchor: i32,

    /// When billing started (after any trial period)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_start_date: Option<chrono::NaiveDate>,

    /// Automatically try to charge the customer's configured payment method on finalize.
    pub charge_automatically: bool,

    /// When the subscription was created
    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: Currency,

    /// Current billing period end date
    #[serde(skip_serializing_if = "Option::is_none")]
    pub current_period_end: Option<chrono::NaiveDate>,

    /// Current billing period start date
    pub current_period_start: chrono::NaiveDate,

    /// User-defined custom property values, keyed by definition `key`.
    pub custom_properties: serde_json::Value,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub customer_alias: Option<String>,

    pub customer_id: CustomerId,

    pub customer_name: String,

    /// When the subscription ends (if set)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub end_date: Option<chrono::NaiveDate>,

    pub id: SubscriptionId,

    /// Default memo for invoices
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_memo: Option<String>,

    /// Monthly recurring revenue in cents
    pub mrr_cents: i64,

    /// Payment terms in days (0 = due on issue)
    pub net_terms: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub payment_methods_config: Option<PaymentMethodsConfig>,

    /// Billing period (monthly, annual, etc.)
    pub period: BillingPeriodEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub plan_description: Option<String>,

    pub plan_id: PlanId,

    pub plan_name: String,

    pub plan_version: i32,

    pub plan_version_id: PlanVersionId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub purchase_order: Option<String>,

    /// When the subscription contract starts (benefits apply from this date)
    pub start_date: chrono::NaiveDate,

    pub status: SubscriptionStatusEnum,

    /// Trial duration in days
    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial_duration: Option<i32>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Subscription {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        auto_advance_invoices: bool,
        billing_day_anchor: i32,
        charge_automatically: bool,
        created_at: chrono::DateTime<chrono::Utc>,
        currency: Currency,
        current_period_start: chrono::NaiveDate,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        customer_name: impl Into<String>,
        id: SubscriptionId,
        mrr_cents: i64,
        net_terms: i32,
        period: BillingPeriodEnum,
        plan_id: PlanId,
        plan_name: impl Into<String>,
        plan_version: i32,
        plan_version_id: PlanVersionId,
        start_date: chrono::NaiveDate,
        status: SubscriptionStatusEnum,
    ) -> Self {
        Self {
            activated_at: None,
            auto_advance_invoices,
            billing_day_anchor,
            billing_start_date: None,
            charge_automatically,
            created_at,
            currency,
            current_period_end: None,
            current_period_start,
            custom_properties,
            customer_alias: None,
            customer_id,
            customer_name: customer_name.into(),
            end_date: None,
            id,
            invoice_memo: None,
            mrr_cents,
            net_terms,
            payment_methods_config: None,
            period,
            plan_description: None,
            plan_id,
            plan_name: plan_name.into(),
            plan_version,
            plan_version_id,
            purchase_order: None,
            start_date,
            status,
            trial_duration: None,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    checkout_session_id::CheckoutSessionId, checkout_session_status::CheckoutSessionStatus,
    checkout_type::CheckoutType, customer_id::CustomerId,
    payment_methods_config::PaymentMethodsConfig, plan_version_id::PlanVersionId,
    subscription_id::SubscriptionId,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CheckoutSession {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_day_anchor: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_start_date: Option<chrono::NaiveDate>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub cancel_url: Option<String>,

    pub checkout_type: CheckoutType,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub checkout_url: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub completed_at: Option<chrono::DateTime<chrono::Utc>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub coupon_code: Option<String>,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub customer_id: CustomerId,

    /// When the session expires. None means the session never expires.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_at: Option<chrono::DateTime<chrono::Utc>>,

    pub id: CheckoutSessionId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub net_terms: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub payment_methods_config: Option<PaymentMethodsConfig>,

    pub plan_version_id: PlanVersionId,

    pub status: CheckoutSessionStatus,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub subscription_id: Option<SubscriptionId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub success_url: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial_duration_days: Option<i32>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CheckoutSession {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        checkout_type: CheckoutType,
        created_at: chrono::DateTime<chrono::Utc>,
        customer_id: CustomerId,
        id: CheckoutSessionId,
        plan_version_id: PlanVersionId,
        status: CheckoutSessionStatus,
    ) -> Self {
        Self {
            billing_day_anchor: None,
            billing_start_date: None,
            cancel_url: None,
            checkout_type,
            checkout_url: None,
            completed_at: None,
            coupon_code: None,
            created_at,
            customer_id,
            expires_at: None,
            id,
            net_terms: None,
            payment_methods_config: None,
            plan_version_id,
            status,
            subscription_id: None,
            success_url: None,
            trial_duration_days: None,
            extra: serde_json::Map::new(),
        }
    }
}

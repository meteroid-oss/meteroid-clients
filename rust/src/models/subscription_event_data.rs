// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billing_period_enum::BillingPeriodEnum, customer_id::CustomerId,
    subscription_id::SubscriptionId, subscription_status_enum::SubscriptionStatusEnum,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionEventData {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub activated_at: Option<String>,

    pub billing_day_anchor: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_start_date: Option<String>,

    pub created_at: String,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub customer_alias: Option<String>,

    pub customer_id: CustomerId,

    pub customer_name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub end_date: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_memo: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_threshold: Option<String>,

    pub mrr_cents: i32,

    pub net_terms: i32,

    pub period: BillingPeriodEnum,

    pub plan_name: String,

    pub start_date: String,

    pub status: SubscriptionStatusEnum,

    pub subscription_id: SubscriptionId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trial_duration: Option<i32>,

    pub version: i32,
}

impl SubscriptionEventData {
    pub fn new(
        billing_day_anchor: i32,
        created_at: String,
        currency: String,
        customer_id: CustomerId,
        customer_name: String,
        mrr_cents: i32,
        net_terms: i32,
        period: BillingPeriodEnum,
        plan_name: String,
        start_date: String,
        status: SubscriptionStatusEnum,
        subscription_id: SubscriptionId,
        version: i32,
    ) -> Self {
        Self {
            activated_at: None,
            billing_day_anchor,
            billing_start_date: None,
            created_at,
            currency,
            customer_alias: None,
            customer_id,
            customer_name,
            end_date: None,
            invoice_memo: None,
            invoice_threshold: None,
            mrr_cents,
            net_terms,
            period,
            plan_name,
            start_date,
            status,
            subscription_id,
            trial_duration: None,
            version,
        }
    }
}

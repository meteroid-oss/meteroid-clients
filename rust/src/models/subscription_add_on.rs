// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    add_on_id::AddOnId, subscription_add_on_id::SubscriptionAddOnId,
    subscription_fee::SubscriptionFee,
    subscription_fee_billing_period_enum::SubscriptionFeeBillingPeriodEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct SubscriptionAddOn {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub add_on_id: Option<AddOnId>,

    pub fee: SubscriptionFee,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub id: Option<SubscriptionAddOnId>,

    pub name: String,

    pub period: SubscriptionFeeBillingPeriodEnum,

    pub quantity: i32,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionAddOn {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        fee: SubscriptionFee,
        name: impl Into<String>,
        period: SubscriptionFeeBillingPeriodEnum,
        quantity: i32,
    ) -> Self {
        Self {
            add_on_id: None,
            fee,
            id: None,
            name: name.into(),
            period,
            quantity,
            extra: serde_json::Map::new(),
        }
    }
}

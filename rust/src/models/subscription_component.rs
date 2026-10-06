// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    price_component_id::PriceComponentId, product_id::ProductId, subscription_fee::SubscriptionFee,
    subscription_fee_billing_period_enum::SubscriptionFeeBillingPeriodEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct SubscriptionComponent {
    pub fee: SubscriptionFee,

    pub name: String,

    pub period: SubscriptionFeeBillingPeriodEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub price_component_id: Option<PriceComponentId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product_id: Option<ProductId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionComponent {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        fee: SubscriptionFee,
        name: impl Into<String>,
        period: SubscriptionFeeBillingPeriodEnum,
    ) -> Self {
        Self {
            fee,
            name: name.into(),
            period,
            price_component_id: None,
            product_id: None,
            extra: serde_json::Map::new(),
        }
    }
}

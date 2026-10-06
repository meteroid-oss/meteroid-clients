// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billing_period_enum::BillingPeriodEnum, pricing::Pricing};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct PriceInput {
    pub cadence: BillingPeriodEnum,

    pub currency: String,

    pub pricing: Pricing,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PriceInput {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(cadence: BillingPeriodEnum, currency: impl Into<String>, pricing: Pricing) -> Self {
        Self {
            cadence,
            currency: currency.into(),
            pricing,
            extra: serde_json::Map::new(),
        }
    }
}

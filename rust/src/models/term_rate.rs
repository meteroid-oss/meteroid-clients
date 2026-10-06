// this file is @generated
use serde::{Deserialize, Serialize};

use super::billing_period_enum::BillingPeriodEnum;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct TermRate {
    pub price: rust_decimal::Decimal,

    pub term: BillingPeriodEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TermRate {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(price: rust_decimal::Decimal, term: BillingPeriodEnum) -> Self {
        Self {
            price,
            term,
            extra: serde_json::Map::new(),
        }
    }
}

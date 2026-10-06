// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CapacityPricing {
    pub included: i64,

    pub overage_rate: rust_decimal::Decimal,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CapacityPricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        included: i64,
        overage_rate: rust_decimal::Decimal,
        rate: rust_decimal::Decimal,
    ) -> Self {
        Self {
            included,
            overage_rate,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}

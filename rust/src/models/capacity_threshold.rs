// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CapacityThreshold {
    pub included_amount: i64,

    pub per_unit_overage: rust_decimal::Decimal,

    pub price: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CapacityThreshold {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        included_amount: i64,
        per_unit_overage: rust_decimal::Decimal,
        price: rust_decimal::Decimal,
    ) -> Self {
        Self {
            included_amount,
            per_unit_overage,
            price,
            extra: serde_json::Map::new(),
        }
    }
}

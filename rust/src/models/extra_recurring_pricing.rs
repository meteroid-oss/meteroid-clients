// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExtraRecurringPricing {
    pub quantity: i32,

    pub unit_price: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExtraRecurringPricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(quantity: i32, unit_price: rust_decimal::Decimal) -> Self {
        Self {
            quantity,
            unit_price,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct OneTimeFee {
    pub quantity: i32,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OneTimeFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(quantity: i32, rate: rust_decimal::Decimal) -> Self {
        Self {
            quantity,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}

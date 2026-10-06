// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct PackagePricing {
    pub block_size: i64,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PackagePricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(block_size: i64, rate: rust_decimal::Decimal) -> Self {
        Self {
            block_size,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}

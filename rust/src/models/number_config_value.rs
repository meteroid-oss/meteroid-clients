// this file is @generated
use serde::{Deserialize, Serialize};

/// A number config value (decimal, encoded as a string).
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct NumberConfigValue {
    pub value: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl NumberConfigValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: rust_decimal::Decimal) -> Self {
        Self {
            value,
            extra: serde_json::Map::new(),
        }
    }
}

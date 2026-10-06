// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct FixedDiscount {
    pub amount: String,

    pub currency: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl FixedDiscount {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(amount: impl Into<String>, currency: impl Into<String>) -> Self {
        Self {
            amount: amount.into(),
            currency: currency.into(),
            extra: serde_json::Map::new(),
        }
    }
}

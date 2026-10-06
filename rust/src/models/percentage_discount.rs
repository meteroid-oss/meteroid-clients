// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct PercentageDiscount {
    pub percentage: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PercentageDiscount {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(percentage: impl Into<String>) -> Self {
        Self {
            percentage: percentage.into(),
            extra: serde_json::Map::new(),
        }
    }
}

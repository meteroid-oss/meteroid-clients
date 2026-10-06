// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct GroupedUsage {
    pub dimensions: std::collections::HashMap<String, String>,

    pub value: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl GroupedUsage {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        dimensions: std::collections::HashMap<String, String>,
        value: rust_decimal::Decimal,
    ) -> Self {
        Self {
            dimensions,
            value,
            extra: serde_json::Map::new(),
        }
    }
}

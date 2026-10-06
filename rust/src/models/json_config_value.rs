// this file is @generated
use serde::{Deserialize, Serialize};

/// A structured (JSON) config value — the "metadata" case, several fields in one entitlement.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct JsonConfigValue {
    pub value: serde_json::Value,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl JsonConfigValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: serde_json::Value) -> Self {
        Self {
            value,
            extra: serde_json::Map::new(),
        }
    }
}

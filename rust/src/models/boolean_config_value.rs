// this file is @generated
use serde::{Deserialize, Serialize};

/// A boolean config value.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BooleanConfigValue {
    pub value: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BooleanConfigValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: bool) -> Self {
        Self {
            value,
            extra: serde_json::Map::new(),
        }
    }
}

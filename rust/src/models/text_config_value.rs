// this file is @generated
use serde::{Deserialize, Serialize};

/// A text config value.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct TextConfigValue {
    pub value: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TextConfigValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: impl Into<String>) -> Self {
        Self {
            value: value.into(),
            extra: serde_json::Map::new(),
        }
    }
}

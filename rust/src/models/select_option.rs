// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct SelectOption {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub label: Option<String>,

    pub value: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SelectOption {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: impl Into<String>) -> Self {
        Self {
            label: None,
            value: value.into(),
            extra: serde_json::Map::new(),
        }
    }
}

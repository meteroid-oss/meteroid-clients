// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct OneTimeFeeStructure {
    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OneTimeFeeStructure {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            extra: serde_json::Map::new(),
        }
    }
}

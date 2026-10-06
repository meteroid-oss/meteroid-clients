// this file is @generated
use serde::{Deserialize, Serialize};

/// Every revenue line counts toward the floor.
#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct AllComponentsScope {
    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl AllComponentsScope {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            extra: serde_json::Map::new(),
        }
    }
}

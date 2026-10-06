// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BooleanEffectiveEntitlementValue {
    pub enabled: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BooleanEffectiveEntitlementValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(enabled: bool) -> Self {
        Self {
            enabled,
            extra: serde_json::Map::new(),
        }
    }
}

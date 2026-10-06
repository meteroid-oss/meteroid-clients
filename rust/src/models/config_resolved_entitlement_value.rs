// this file is @generated
use serde::{Deserialize, Serialize};

use super::config_value::ConfigValue;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ConfigResolvedEntitlementValue {
    pub value: ConfigValue,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ConfigResolvedEntitlementValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value: ConfigValue) -> Self {
        Self {
            value,
            extra: serde_json::Map::new(),
        }
    }
}

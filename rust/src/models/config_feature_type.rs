// this file is @generated
use serde::{Deserialize, Serialize};

use super::config_value_type::ConfigValueType;

/// A static, typed configuration value. No metric — resolved synchronously.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ConfigFeatureType {
    /// Allowed values when `value_type = SELECT`. Empty otherwise.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub options: Option<Vec<String>>,

    /// The feature's value type, fixed at creation.
    pub value_type: ConfigValueType,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ConfigFeatureType {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(value_type: ConfigValueType) -> Self {
        Self {
            options: None,
            value_type,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    custom_property_entity_type::CustomPropertyEntityType,
    custom_property_type::CustomPropertyType, property_config::PropertyConfig,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CustomPropertyDefinitionCreateRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub config: Option<PropertyConfig>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub default_value: Option<serde_json::Value>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub display_order: Option<i32>,

    pub entity_type: CustomPropertyEntityType,

    /// Immutable machine name; letters, digits and underscores only. Unique per entity type.
    pub key: String,

    pub name: String,

    pub property_type: CustomPropertyType,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub required: Option<bool>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomPropertyDefinitionCreateRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        entity_type: CustomPropertyEntityType,
        key: impl Into<String>,
        name: impl Into<String>,
        property_type: CustomPropertyType,
    ) -> Self {
        Self {
            config: None,
            default_value: None,
            description: None,
            display_order: None,
            entity_type,
            key: key.into(),
            name: name.into(),
            property_type,
            required: None,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    custom_property_definition_id::CustomPropertyDefinitionId,
    custom_property_entity_type::CustomPropertyEntityType,
    custom_property_type::CustomPropertyType, property_config::PropertyConfig,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CustomPropertyDefinition {
    pub archived: bool,

    pub config: PropertyConfig,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub default_value: Option<serde_json::Value>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub display_order: i32,

    pub entity_type: CustomPropertyEntityType,

    pub id: CustomPropertyDefinitionId,

    pub key: String,

    pub name: String,

    pub property_type: CustomPropertyType,

    pub required: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomPropertyDefinition {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        archived: bool,
        config: PropertyConfig,
        display_order: i32,
        entity_type: CustomPropertyEntityType,
        id: CustomPropertyDefinitionId,
        key: impl Into<String>,
        name: impl Into<String>,
        property_type: CustomPropertyType,
        required: bool,
    ) -> Self {
        Self {
            archived,
            config,
            default_value: None,
            description: None,
            display_order,
            entity_type,
            id,
            key: key.into(),
            name: name.into(),
            property_type,
            required,
            extra: serde_json::Map::new(),
        }
    }
}

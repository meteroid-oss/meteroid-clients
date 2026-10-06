// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    boolean_config_value::BooleanConfigValue, json_config_value::JsonConfigValue,
    number_config_value::NumberConfigValue, text_config_value::TextConfigValue,
};
use crate::models::codec;

/// A static, typed configuration value carried by a Config entitlement. Resolved synchronously
/// through the entitlement hierarchy — no metric, no usage counter.
///
/// Variants are told apart by `kind`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum ConfigValue {
    Number(NumberConfigValue),
    Boolean(BooleanConfigValue),
    Text(TextConfigValue),
    Json(JsonConfigValue),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl ConfigValue {
    /// The `kind` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Number(_) => Some("NUMBER"),
            Self::Boolean(_) => Some("BOOLEAN"),
            Self::Text(_) => Some("TEXT"),
            Self::Json(_) => Some("JSON"),
            Self::Unknown(value) => value.get("kind")?.as_str(),
        }
    }
}

impl Serialize for ConfigValue {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Number(value) => codec::internally_tagged(serializer, "kind", "NUMBER", value),
            Self::Boolean(value) => codec::internally_tagged(serializer, "kind", "BOOLEAN", value),
            Self::Text(value) => codec::internally_tagged(serializer, "kind", "TEXT", value),
            Self::Json(value) => codec::internally_tagged(serializer, "kind", "JSON", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for ConfigValue {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "kind")?;
        Ok(match tag.as_str() {
            "NUMBER" => Self::Number(codec::from_value(value)?),
            "BOOLEAN" => Self::Boolean(codec::from_value(value)?),
            "TEXT" => Self::Text(codec::from_value(value)?),
            "JSON" => Self::Json(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}

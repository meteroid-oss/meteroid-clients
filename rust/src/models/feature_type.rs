// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    boolean_feature_type::BooleanFeatureType, config_feature_type::ConfigFeatureType,
    metered_feature_type::MeteredFeatureType,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum FeatureType {
    Boolean(BooleanFeatureType),
    Metered(MeteredFeatureType),
    Config(ConfigFeatureType),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl FeatureType {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Boolean(_) => Some("BOOLEAN"),
            Self::Metered(_) => Some("METERED"),
            Self::Config(_) => Some("CONFIG"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for FeatureType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Boolean(value) => codec::internally_tagged(serializer, "type", "BOOLEAN", value),
            Self::Metered(value) => codec::internally_tagged(serializer, "type", "METERED", value),
            Self::Config(value) => codec::internally_tagged(serializer, "type", "CONFIG", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for FeatureType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "BOOLEAN" => Self::Boolean(codec::from_value(value)?),
            "METERED" => Self::Metered(codec::from_value(value)?),
            "CONFIG" => Self::Config(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}

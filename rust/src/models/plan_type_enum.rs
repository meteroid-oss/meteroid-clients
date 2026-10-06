// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum PlanTypeEnum {
    Standard,
    Free,
    Custom,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl PlanTypeEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Standard => "STANDARD",
            Self::Free => "FREE",
            Self::Custom => "CUSTOM",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for PlanTypeEnum {
    fn from(value: &str) -> Self {
        match value {
            "STANDARD" => Self::Standard,
            "FREE" => Self::Free,
            "CUSTOM" => Self::Custom,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for PlanTypeEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for PlanTypeEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for PlanTypeEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for PlanTypeEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

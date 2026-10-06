// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum UsageModelEnum {
    PerUnit,
    Tiered,
    Volume,
    Package,
    Matrix,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl UsageModelEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::PerUnit => "PER_UNIT",
            Self::Tiered => "TIERED",
            Self::Volume => "VOLUME",
            Self::Package => "PACKAGE",
            Self::Matrix => "MATRIX",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for UsageModelEnum {
    fn from(value: &str) -> Self {
        match value {
            "PER_UNIT" => Self::PerUnit,
            "TIERED" => Self::Tiered,
            "VOLUME" => Self::Volume,
            "PACKAGE" => Self::Package,
            "MATRIX" => Self::Matrix,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for UsageModelEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for UsageModelEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for UsageModelEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for UsageModelEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum ConfigValueType {
    Number,
    Boolean,
    Text,
    Map,
    Json,
    Select,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl ConfigValueType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Number => "NUMBER",
            Self::Boolean => "BOOLEAN",
            Self::Text => "TEXT",
            Self::Map => "MAP",
            Self::Json => "JSON",
            Self::Select => "SELECT",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for ConfigValueType {
    fn from(value: &str) -> Self {
        match value {
            "NUMBER" => Self::Number,
            "BOOLEAN" => Self::Boolean,
            "TEXT" => Self::Text,
            "MAP" => Self::Map,
            "JSON" => Self::Json,
            "SELECT" => Self::Select,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for ConfigValueType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for ConfigValueType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for ConfigValueType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for ConfigValueType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

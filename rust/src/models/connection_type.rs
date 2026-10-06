// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Type of connection between platform and connected account
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum ConnectionType {
    Standard,
    Express,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl ConnectionType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Standard => "standard",
            Self::Express => "express",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for ConnectionType {
    fn from(value: &str) -> Self {
        match value {
            "standard" => Self::Standard,
            "express" => Self::Express,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for ConnectionType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for ConnectionType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for ConnectionType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for ConnectionType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

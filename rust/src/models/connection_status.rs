// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Status of a connected account
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum ConnectionStatus {
    Pending,
    Active,
    Revoked,
    Suspended,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl ConnectionStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Pending => "pending",
            Self::Active => "active",
            Self::Revoked => "revoked",
            Self::Suspended => "suspended",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for ConnectionStatus {
    fn from(value: &str) -> Self {
        match value {
            "pending" => Self::Pending,
            "active" => Self::Active,
            "revoked" => Self::Revoked,
            "suspended" => Self::Suspended,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for ConnectionStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for ConnectionStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for ConnectionStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for ConnectionStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

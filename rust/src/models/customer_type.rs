// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Company vs. individual (B2C). Defaults to `COMPANY`.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CustomerType {
    Company,
    Individual,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CustomerType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Company => "COMPANY",
            Self::Individual => "INDIVIDUAL",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CustomerType {
    fn from(value: &str) -> Self {
        match value {
            "COMPANY" => Self::Company,
            "INDIVIDUAL" => Self::Individual,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CustomerType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CustomerType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CustomerType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CustomerType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

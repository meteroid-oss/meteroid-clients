// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum BillingType {
    Advance,
    Arrears,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl BillingType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Advance => "ADVANCE",
            Self::Arrears => "ARREARS",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for BillingType {
    fn from(value: &str) -> Self {
        match value {
            "ADVANCE" => Self::Advance,
            "ARREARS" => Self::Arrears,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for BillingType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for BillingType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for BillingType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for BillingType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

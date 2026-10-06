// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum InvoiceStatus {
    Draft,
    Finalized,
    Uncollectible,
    Void,
    Closed,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl InvoiceStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Draft => "DRAFT",
            Self::Finalized => "FINALIZED",
            Self::Uncollectible => "UNCOLLECTIBLE",
            Self::Void => "VOID",
            Self::Closed => "CLOSED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for InvoiceStatus {
    fn from(value: &str) -> Self {
        match value {
            "DRAFT" => Self::Draft,
            "FINALIZED" => Self::Finalized,
            "UNCOLLECTIBLE" => Self::Uncollectible,
            "VOID" => Self::Void,
            "CLOSED" => Self::Closed,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for InvoiceStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for InvoiceStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for InvoiceStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for InvoiceStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

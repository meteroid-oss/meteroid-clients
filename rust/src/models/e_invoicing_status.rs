// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Whether the structured e-invoice was produced with the accounting PDF. Absent when the
/// invoicing entity had not opted in at the time the invoice was issued.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum EInvoicingStatus {
    Generated,
    Failed,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl EInvoicingStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Generated => "GENERATED",
            Self::Failed => "FAILED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for EInvoicingStatus {
    fn from(value: &str) -> Self {
        match value {
            "GENERATED" => Self::Generated,
            "FAILED" => Self::Failed,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for EInvoicingStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for EInvoicingStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for EInvoicingStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for EInvoicingStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

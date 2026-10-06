// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum InvoicePaymentStatus {
    Unpaid,
    PartiallyPaid,
    Paid,
    Errored,
    Processing,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl InvoicePaymentStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Unpaid => "UNPAID",
            Self::PartiallyPaid => "PARTIALLY_PAID",
            Self::Paid => "PAID",
            Self::Errored => "ERRORED",
            Self::Processing => "PROCESSING",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for InvoicePaymentStatus {
    fn from(value: &str) -> Self {
        match value {
            "UNPAID" => Self::Unpaid,
            "PARTIALLY_PAID" => Self::PartiallyPaid,
            "PAID" => Self::Paid,
            "ERRORED" => Self::Errored,
            "PROCESSING" => Self::Processing,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for InvoicePaymentStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for InvoicePaymentStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for InvoicePaymentStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for InvoicePaymentStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

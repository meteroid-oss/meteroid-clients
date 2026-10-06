// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum InvoiceType {
    Recurring,
    OneOff,
    Adjustment,
    UsageThreshold,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl InvoiceType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Recurring => "RECURRING",
            Self::OneOff => "ONE_OFF",
            Self::Adjustment => "ADJUSTMENT",
            Self::UsageThreshold => "USAGE_THRESHOLD",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for InvoiceType {
    fn from(value: &str) -> Self {
        match value {
            "RECURRING" => Self::Recurring,
            "ONE_OFF" => Self::OneOff,
            "ADJUSTMENT" => Self::Adjustment,
            "USAGE_THRESHOLD" => Self::UsageThreshold,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for InvoiceType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for InvoiceType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for InvoiceType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for InvoiceType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

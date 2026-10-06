// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CustomPropertyEntityType {
    Customer,
    Subscription,
    Invoice,
    CreditNote,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CustomPropertyEntityType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Customer => "CUSTOMER",
            Self::Subscription => "SUBSCRIPTION",
            Self::Invoice => "INVOICE",
            Self::CreditNote => "CREDIT_NOTE",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CustomPropertyEntityType {
    fn from(value: &str) -> Self {
        match value {
            "CUSTOMER" => Self::Customer,
            "SUBSCRIPTION" => Self::Subscription,
            "INVOICE" => Self::Invoice,
            "CREDIT_NOTE" => Self::CreditNote,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CustomPropertyEntityType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CustomPropertyEntityType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CustomPropertyEntityType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CustomPropertyEntityType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

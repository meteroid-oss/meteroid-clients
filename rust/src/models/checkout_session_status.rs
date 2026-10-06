// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CheckoutSessionStatus {
    Created,
    AwaitingPayment,
    Completed,
    Expired,
    Cancelled,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CheckoutSessionStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Created => "CREATED",
            Self::AwaitingPayment => "AWAITING_PAYMENT",
            Self::Completed => "COMPLETED",
            Self::Expired => "EXPIRED",
            Self::Cancelled => "CANCELLED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CheckoutSessionStatus {
    fn from(value: &str) -> Self {
        match value {
            "CREATED" => Self::Created,
            "AWAITING_PAYMENT" => Self::AwaitingPayment,
            "COMPLETED" => Self::Completed,
            "EXPIRED" => Self::Expired,
            "CANCELLED" => Self::Cancelled,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CheckoutSessionStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CheckoutSessionStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CheckoutSessionStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CheckoutSessionStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

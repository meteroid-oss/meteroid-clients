// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum PaymentStatusEnum {
    Ready,
    Pending,
    Settled,
    Cancelled,
    Failed,
    Refunded,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl PaymentStatusEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Ready => "READY",
            Self::Pending => "PENDING",
            Self::Settled => "SETTLED",
            Self::Cancelled => "CANCELLED",
            Self::Failed => "FAILED",
            Self::Refunded => "REFUNDED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for PaymentStatusEnum {
    fn from(value: &str) -> Self {
        match value {
            "READY" => Self::Ready,
            "PENDING" => Self::Pending,
            "SETTLED" => Self::Settled,
            "CANCELLED" => Self::Cancelled,
            "FAILED" => Self::Failed,
            "REFUNDED" => Self::Refunded,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for PaymentStatusEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for PaymentStatusEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for PaymentStatusEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for PaymentStatusEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

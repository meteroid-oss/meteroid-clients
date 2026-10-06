// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum PaymentMethodTypeEnum {
    Card,
    BankTransfer,
    Wallet,
    Other,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl PaymentMethodTypeEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Card => "CARD",
            Self::BankTransfer => "BANK_TRANSFER",
            Self::Wallet => "WALLET",
            Self::Other => "OTHER",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for PaymentMethodTypeEnum {
    fn from(value: &str) -> Self {
        match value {
            "CARD" => Self::Card,
            "BANK_TRANSFER" => Self::BankTransfer,
            "WALLET" => Self::Wallet,
            "OTHER" => Self::Other,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for PaymentMethodTypeEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for PaymentMethodTypeEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for PaymentMethodTypeEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for PaymentMethodTypeEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

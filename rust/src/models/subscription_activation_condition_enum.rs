// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum SubscriptionActivationConditionEnum {
    OnStart,
    OnCheckout,
    Manual,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl SubscriptionActivationConditionEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::OnStart => "ON_START",
            Self::OnCheckout => "ON_CHECKOUT",
            Self::Manual => "MANUAL",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for SubscriptionActivationConditionEnum {
    fn from(value: &str) -> Self {
        match value {
            "ON_START" => Self::OnStart,
            "ON_CHECKOUT" => Self::OnCheckout,
            "MANUAL" => Self::Manual,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for SubscriptionActivationConditionEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for SubscriptionActivationConditionEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for SubscriptionActivationConditionEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for SubscriptionActivationConditionEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

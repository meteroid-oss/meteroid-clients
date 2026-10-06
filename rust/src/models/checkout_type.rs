// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CheckoutType {
    SelfServe,
    SubscriptionActivation,
    PlanChange,
    AddonPurchase,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CheckoutType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::SelfServe => "SELF_SERVE",
            Self::SubscriptionActivation => "SUBSCRIPTION_ACTIVATION",
            Self::PlanChange => "PLAN_CHANGE",
            Self::AddonPurchase => "ADDON_PURCHASE",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CheckoutType {
    fn from(value: &str) -> Self {
        match value {
            "SELF_SERVE" => Self::SelfServe,
            "SUBSCRIPTION_ACTIVATION" => Self::SubscriptionActivation,
            "PLAN_CHANGE" => Self::PlanChange,
            "ADDON_PURCHASE" => Self::AddonPurchase,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CheckoutType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CheckoutType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CheckoutType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CheckoutType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

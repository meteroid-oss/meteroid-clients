// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum BillingPeriodEnum {
    Monthly,
    Quarterly,
    Semiannual,
    Annual,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl BillingPeriodEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Monthly => "MONTHLY",
            Self::Quarterly => "QUARTERLY",
            Self::Semiannual => "SEMIANNUAL",
            Self::Annual => "ANNUAL",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for BillingPeriodEnum {
    fn from(value: &str) -> Self {
        match value {
            "MONTHLY" => Self::Monthly,
            "QUARTERLY" => Self::Quarterly,
            "SEMIANNUAL" => Self::Semiannual,
            "ANNUAL" => Self::Annual,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for BillingPeriodEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for BillingPeriodEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for BillingPeriodEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for BillingPeriodEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

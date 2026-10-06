// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum ProductFeeTypeEnum {
    Rate,
    Slot,
    Capacity,
    Usage,
    ExtraRecurring,
    OneTime,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl ProductFeeTypeEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Rate => "RATE",
            Self::Slot => "SLOT",
            Self::Capacity => "CAPACITY",
            Self::Usage => "USAGE",
            Self::ExtraRecurring => "EXTRA_RECURRING",
            Self::OneTime => "ONE_TIME",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for ProductFeeTypeEnum {
    fn from(value: &str) -> Self {
        match value {
            "RATE" => Self::Rate,
            "SLOT" => Self::Slot,
            "CAPACITY" => Self::Capacity,
            "USAGE" => Self::Usage,
            "EXTRA_RECURRING" => Self::ExtraRecurring,
            "ONE_TIME" => Self::OneTime,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for ProductFeeTypeEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for ProductFeeTypeEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for ProductFeeTypeEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for ProductFeeTypeEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

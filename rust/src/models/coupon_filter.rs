// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CouponFilter {
    All,
    Active,
    Inactive,
    Archived,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CouponFilter {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::All => "ALL",
            Self::Active => "ACTIVE",
            Self::Inactive => "INACTIVE",
            Self::Archived => "ARCHIVED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CouponFilter {
    fn from(value: &str) -> Self {
        match value {
            "ALL" => Self::All,
            "ACTIVE" => Self::Active,
            "INACTIVE" => Self::Inactive,
            "ARCHIVED" => Self::Archived,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CouponFilter {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CouponFilter {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CouponFilter {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CouponFilter {
    fn encode(&self) -> String {
        self.to_string()
    }
}

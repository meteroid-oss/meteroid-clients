// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum PlanStatusEnum {
    Draft,
    Active,
    Inactive,
    Archived,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl PlanStatusEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Draft => "DRAFT",
            Self::Active => "ACTIVE",
            Self::Inactive => "INACTIVE",
            Self::Archived => "ARCHIVED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for PlanStatusEnum {
    fn from(value: &str) -> Self {
        match value {
            "DRAFT" => Self::Draft,
            "ACTIVE" => Self::Active,
            "INACTIVE" => Self::Inactive,
            "ARCHIVED" => Self::Archived,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for PlanStatusEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for PlanStatusEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for PlanStatusEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for PlanStatusEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Lifecycle status of a feature.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum FeatureStatus {
    Active,
    Disabled,
    Archived,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl FeatureStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Active => "ACTIVE",
            Self::Disabled => "DISABLED",
            Self::Archived => "ARCHIVED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for FeatureStatus {
    fn from(value: &str) -> Self {
        match value {
            "ACTIVE" => Self::Active,
            "DISABLED" => Self::Disabled,
            "ARCHIVED" => Self::Archived,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for FeatureStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for FeatureStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for FeatureStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for FeatureStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

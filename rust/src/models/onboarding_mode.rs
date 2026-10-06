// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Onboarding mode for connected accounts
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum OnboardingMode {
    Express,
    Full,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl OnboardingMode {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Express => "express",
            Self::Full => "full",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for OnboardingMode {
    fn from(value: &str) -> Self {
        match value {
            "express" => Self::Express,
            "full" => Self::Full,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for OnboardingMode {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for OnboardingMode {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for OnboardingMode {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for OnboardingMode {
    fn encode(&self) -> String {
        self.to_string()
    }
}

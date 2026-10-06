// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum SlotDowngradePolicyEnum {
    RemoveAtEndOfPeriod,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl SlotDowngradePolicyEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::RemoveAtEndOfPeriod => "REMOVE_AT_END_OF_PERIOD",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for SlotDowngradePolicyEnum {
    fn from(value: &str) -> Self {
        match value {
            "REMOVE_AT_END_OF_PERIOD" => Self::RemoveAtEndOfPeriod,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for SlotDowngradePolicyEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for SlotDowngradePolicyEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for SlotDowngradePolicyEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for SlotDowngradePolicyEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

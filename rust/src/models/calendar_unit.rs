// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CalendarUnit {
    Hour,
    Day,
    Week,
    Month,
    Year,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CalendarUnit {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Hour => "HOUR",
            Self::Day => "DAY",
            Self::Week => "WEEK",
            Self::Month => "MONTH",
            Self::Year => "YEAR",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CalendarUnit {
    fn from(value: &str) -> Self {
        match value {
            "HOUR" => Self::Hour,
            "DAY" => Self::Day,
            "WEEK" => Self::Week,
            "MONTH" => Self::Month,
            "YEAR" => Self::Year,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CalendarUnit {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CalendarUnit {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CalendarUnit {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CalendarUnit {
    fn encode(&self) -> String {
        self.to_string()
    }
}

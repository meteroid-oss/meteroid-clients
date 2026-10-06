// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum CustomPropertyType {
    Text,
    Number,
    Boolean,
    Date,
    Datetime,
    SingleSelect,
    MultiSelect,
    Json,
    Url,
    Email,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl CustomPropertyType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Text => "TEXT",
            Self::Number => "NUMBER",
            Self::Boolean => "BOOLEAN",
            Self::Date => "DATE",
            Self::Datetime => "DATETIME",
            Self::SingleSelect => "SINGLE_SELECT",
            Self::MultiSelect => "MULTI_SELECT",
            Self::Json => "JSON",
            Self::Url => "URL",
            Self::Email => "EMAIL",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for CustomPropertyType {
    fn from(value: &str) -> Self {
        match value {
            "TEXT" => Self::Text,
            "NUMBER" => Self::Number,
            "BOOLEAN" => Self::Boolean,
            "DATE" => Self::Date,
            "DATETIME" => Self::Datetime,
            "SINGLE_SELECT" => Self::SingleSelect,
            "MULTI_SELECT" => Self::MultiSelect,
            "JSON" => Self::Json,
            "URL" => Self::Url,
            "EMAIL" => Self::Email,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for CustomPropertyType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for CustomPropertyType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for CustomPropertyType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for CustomPropertyType {
    fn encode(&self) -> String {
        self.to_string()
    }
}

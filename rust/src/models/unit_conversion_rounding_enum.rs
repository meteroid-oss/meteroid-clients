// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum UnitConversionRoundingEnum {
    Up,
    Down,
    Nearest,
    NearestHalf,
    NearestDecile,
    None,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl UnitConversionRoundingEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Up => "UP",
            Self::Down => "DOWN",
            Self::Nearest => "NEAREST",
            Self::NearestHalf => "NEAREST_HALF",
            Self::NearestDecile => "NEAREST_DECILE",
            Self::None => "NONE",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for UnitConversionRoundingEnum {
    fn from(value: &str) -> Self {
        match value {
            "UP" => Self::Up,
            "DOWN" => Self::Down,
            "NEAREST" => Self::Nearest,
            "NEAREST_HALF" => Self::NearestHalf,
            "NEAREST_DECILE" => Self::NearestDecile,
            "NONE" => Self::None,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for UnitConversionRoundingEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for UnitConversionRoundingEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for UnitConversionRoundingEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for UnitConversionRoundingEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

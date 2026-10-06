// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

/// Operator of a pre-aggregation [`MetricFilter`]. `EQUAL`/`NOT_EQUAL` are the single-value
/// forms of `IN`/`NOT_IN`. Negation (`NOT_EQUAL`/`NOT_IN`) is presence-required: an event
/// missing the property is excluded.
#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum MetricFilterOperator {
    Equal,
    NotEqual,
    In,
    NotIn,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl MetricFilterOperator {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Equal => "EQUAL",
            Self::NotEqual => "NOT_EQUAL",
            Self::In => "IN",
            Self::NotIn => "NOT_IN",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for MetricFilterOperator {
    fn from(value: &str) -> Self {
        match value {
            "EQUAL" => Self::Equal,
            "NOT_EQUAL" => Self::NotEqual,
            "IN" => Self::In,
            "NOT_IN" => Self::NotIn,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for MetricFilterOperator {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for MetricFilterOperator {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for MetricFilterOperator {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for MetricFilterOperator {
    fn encode(&self) -> String {
        self.to_string()
    }
}

// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum BillingMetricAggregateEnum {
    Count,
    Latest,
    Max,
    Min,
    Mean,
    Sum,
    CountDistinct,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl BillingMetricAggregateEnum {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Count => "COUNT",
            Self::Latest => "LATEST",
            Self::Max => "MAX",
            Self::Min => "MIN",
            Self::Mean => "MEAN",
            Self::Sum => "SUM",
            Self::CountDistinct => "COUNT_DISTINCT",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for BillingMetricAggregateEnum {
    fn from(value: &str) -> Self {
        match value {
            "COUNT" => Self::Count,
            "LATEST" => Self::Latest,
            "MAX" => Self::Max,
            "MIN" => Self::Min,
            "MEAN" => Self::Mean,
            "SUM" => Self::Sum,
            "COUNT_DISTINCT" => Self::CountDistinct,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for BillingMetricAggregateEnum {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for BillingMetricAggregateEnum {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for BillingMetricAggregateEnum {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for BillingMetricAggregateEnum {
    fn encode(&self) -> String {
        self.to_string()
    }
}

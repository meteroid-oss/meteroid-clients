// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum BatchJobStatus {
    Pending,
    Chunking,
    Processing,
    Completed,
    CompletedWithErrors,
    Failed,
    Cancelled,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl BatchJobStatus {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::Pending => "PENDING",
            Self::Chunking => "CHUNKING",
            Self::Processing => "PROCESSING",
            Self::Completed => "COMPLETED",
            Self::CompletedWithErrors => "COMPLETED_WITH_ERRORS",
            Self::Failed => "FAILED",
            Self::Cancelled => "CANCELLED",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for BatchJobStatus {
    fn from(value: &str) -> Self {
        match value {
            "PENDING" => Self::Pending,
            "CHUNKING" => Self::Chunking,
            "PROCESSING" => Self::Processing,
            "COMPLETED" => Self::Completed,
            "COMPLETED_WITH_ERRORS" => Self::CompletedWithErrors,
            "FAILED" => Self::Failed,
            "CANCELLED" => Self::Cancelled,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for BatchJobStatus {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for BatchJobStatus {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for BatchJobStatus {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for BatchJobStatus {
    fn encode(&self) -> String {
        self.to_string()
    }
}

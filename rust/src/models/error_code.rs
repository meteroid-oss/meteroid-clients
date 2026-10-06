// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum ErrorCode {
    BadRequest,
    NotFound,
    Conflict,
    Forbidden,
    Unauthorized,
    TooManyRequests,
    InternalServerError,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl ErrorCode {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::BadRequest => "BAD_REQUEST",
            Self::NotFound => "NOT_FOUND",
            Self::Conflict => "CONFLICT",
            Self::Forbidden => "FORBIDDEN",
            Self::Unauthorized => "UNAUTHORIZED",
            Self::TooManyRequests => "TOO_MANY_REQUESTS",
            Self::InternalServerError => "INTERNAL_SERVER_ERROR",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for ErrorCode {
    fn from(value: &str) -> Self {
        match value {
            "BAD_REQUEST" => Self::BadRequest,
            "NOT_FOUND" => Self::NotFound,
            "CONFLICT" => Self::Conflict,
            "FORBIDDEN" => Self::Forbidden,
            "UNAUTHORIZED" => Self::Unauthorized,
            "TOO_MANY_REQUESTS" => Self::TooManyRequests,
            "INTERNAL_SERVER_ERROR" => Self::InternalServerError,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for ErrorCode {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for ErrorCode {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for ErrorCode {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for ErrorCode {
    fn encode(&self) -> String {
        self.to_string()
    }
}

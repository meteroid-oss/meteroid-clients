// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum ErrorCode {
    #[default]
    #[serde(rename = "BAD_REQUEST")]
    BadRequest,

    #[serde(rename = "NOT_FOUND")]
    NotFound,

    #[serde(rename = "CONFLICT")]
    Conflict,

    #[serde(rename = "FORBIDDEN")]
    Forbidden,

    #[serde(rename = "UNAUTHORIZED")]
    Unauthorized,

    #[serde(rename = "TOO_MANY_REQUESTS")]
    TooManyRequests,

    #[serde(rename = "INTERNAL_SERVER_ERROR")]
    InternalServerError,
}

impl fmt::Display for ErrorCode {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::BadRequest => "BAD_REQUEST",
            Self::NotFound => "NOT_FOUND",
            Self::Conflict => "CONFLICT",
            Self::Forbidden => "FORBIDDEN",
            Self::Unauthorized => "UNAUTHORIZED",
            Self::TooManyRequests => "TOO_MANY_REQUESTS",
            Self::InternalServerError => "INTERNAL_SERVER_ERROR",
        };
        f.write_str(value)
    }
}

impl crate::request::QueryParamValue for ErrorCode {
    fn encode(&self) -> String {
        self.to_string()
    }
}

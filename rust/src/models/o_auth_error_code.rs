// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

/// OAuth 2.0 error codes as per RFC 6749
#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum OAuthErrorCode {
    #[default]
    #[serde(rename = "invalid_request")]
    InvalidRequest,

    #[serde(rename = "unauthorized_client")]
    UnauthorizedClient,

    #[serde(rename = "access_denied")]
    AccessDenied,

    #[serde(rename = "unsupported_response_type")]
    UnsupportedResponseType,

    #[serde(rename = "invalid_scope")]
    InvalidScope,

    #[serde(rename = "server_error")]
    ServerError,

    #[serde(rename = "temporarily_unavailable")]
    TemporarilyUnavailable,

    #[serde(rename = "invalid_grant")]
    InvalidGrant,

    #[serde(rename = "invalid_client")]
    InvalidClient,

    #[serde(rename = "unsupported_grant_type")]
    UnsupportedGrantType,
}

impl fmt::Display for OAuthErrorCode {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::InvalidRequest => "invalid_request",
            Self::UnauthorizedClient => "unauthorized_client",
            Self::AccessDenied => "access_denied",
            Self::UnsupportedResponseType => "unsupported_response_type",
            Self::InvalidScope => "invalid_scope",
            Self::ServerError => "server_error",
            Self::TemporarilyUnavailable => "temporarily_unavailable",
            Self::InvalidGrant => "invalid_grant",
            Self::InvalidClient => "invalid_client",
            Self::UnsupportedGrantType => "unsupported_grant_type",
        };
        f.write_str(value)
    }
}

impl crate::request::QueryParamValue for OAuthErrorCode {
    fn encode(&self) -> String {
        self.to_string()
    }
}

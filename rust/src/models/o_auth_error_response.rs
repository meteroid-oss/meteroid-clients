// this file is @generated
use serde::{Deserialize, Serialize};

use super::o_auth_error_code::OAuthErrorCode;

/// OAuth 2.0 error response as per RFC 6749 Section 5.2
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct OAuthErrorResponse {
    pub error: OAuthErrorCode,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub error_description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub error_uri: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OAuthErrorResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(error: OAuthErrorCode) -> Self {
        Self {
            error,
            error_description: None,
            error_uri: None,
            extra: serde_json::Map::new(),
        }
    }
}

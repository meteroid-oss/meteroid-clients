// this file is @generated
use serde::{Deserialize, Serialize};

use super::o_auth_error_code::OAuthErrorCode;

/// OAuth 2.0 error response as per RFC 6749 Section 5.2
#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct OAuthErrorResponse {
    pub error: OAuthErrorCode,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub error_description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub error_uri: Option<String>,
}

impl OAuthErrorResponse {
    pub fn new(error: OAuthErrorCode) -> Self {
        Self {
            error,
            error_description: None,
            error_uri: None,
        }
    }
}

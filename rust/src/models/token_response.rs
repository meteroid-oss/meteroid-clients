// this file is @generated
use serde::{Deserialize, Serialize};

/// Token response as per OAuth 2.0 spec
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct TokenResponse {
    pub access_token: String,

    pub expires_in: i64,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub refresh_token: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub scope: Option<String>,

    pub token_type: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TokenResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        access_token: impl Into<String>,
        expires_in: i64,
        token_type: impl Into<String>,
    ) -> Self {
        Self {
            access_token: access_token.into(),
            expires_in,
            refresh_token: None,
            scope: None,
            token_type: token_type.into(),
            extra: serde_json::Map::new(),
        }
    }
}

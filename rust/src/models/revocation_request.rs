// this file is @generated
use serde::{Deserialize, Serialize};

/// Token revocation request
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct RevocationRequest {
    /// The token to revoke
    pub token: String,

    /// Optional hint about the token type (access_token or refresh_token)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub token_type_hint: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl RevocationRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(token: impl Into<String>) -> Self {
        Self {
            token: token.into(),
            token_type_hint: None,
            extra: serde_json::Map::new(),
        }
    }
}

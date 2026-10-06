// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CustomerPortalTokenRequest {
    /// Token lifetime in seconds. Defaults to 86400 (24 hours).
    /// Must be between 60 and 2592000 (30 days).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_in_seconds: Option<i32>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomerPortalTokenRequest {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            expires_in_seconds: None,
            extra: serde_json::Map::new(),
        }
    }
}

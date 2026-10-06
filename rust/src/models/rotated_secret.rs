// this file is @generated
use serde::{Deserialize, Serialize};

/// Result of rotating a client secret
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct RotatedSecret {
    pub client_secret: String,

    pub client_secret_hint: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl RotatedSecret {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(client_secret: impl Into<String>, client_secret_hint: impl Into<String>) -> Self {
        Self {
            client_secret: client_secret.into(),
            client_secret_hint: client_secret_hint.into(),
            extra: serde_json::Map::new(),
        }
    }
}

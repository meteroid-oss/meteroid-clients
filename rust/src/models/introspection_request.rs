// this file is @generated
use serde::{Deserialize, Serialize};

/// Token introspection request
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct IntrospectionRequest {
    /// The token to introspect
    pub token: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl IntrospectionRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(token: impl Into<String>) -> Self {
        Self {
            token: token.into(),
            extra: serde_json::Map::new(),
        }
    }
}

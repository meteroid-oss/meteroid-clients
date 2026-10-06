// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateOAuthAppRequest {
    pub name: String,

    pub redirect_uris: Vec<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub scopes: Option<Vec<String>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateOAuthAppRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(name: impl Into<String>, redirect_uris: Vec<String>) -> Self {
        Self {
            name: name.into(),
            redirect_uris,
            scopes: None,
            extra: serde_json::Map::new(),
        }
    }
}

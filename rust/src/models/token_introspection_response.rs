// this file is @generated
use serde::{Deserialize, Serialize};

/// Token introspection response as per RFC 7662
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct TokenIntrospectionResponse {
    pub active: bool,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub client_id: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub exp: Option<i64>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub iat: Option<i64>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub scope: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub sub: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub token_type: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TokenIntrospectionResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(active: bool) -> Self {
        Self {
            active,
            client_id: None,
            exp: None,
            iat: None,
            scope: None,
            sub: None,
            token_type: None,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::o_auth_app::OAuthApp;

/// Result of creating an OAuth app (includes the plain-text secret)
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct OAuthAppWithSecret {
    pub app: OAuthApp,

    pub client_secret: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OAuthAppWithSecret {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(app: OAuthApp, client_secret: impl Into<String>) -> Self {
        Self {
            app,
            client_secret: client_secret.into(),
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateOnboardingLinkRequest {
    pub redirect_url: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateOnboardingLinkRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(redirect_url: impl Into<String>) -> Self {
        Self {
            redirect_url: redirect_url.into(),
            extra: serde_json::Map::new(),
        }
    }
}

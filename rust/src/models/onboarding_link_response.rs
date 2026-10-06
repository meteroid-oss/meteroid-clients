// this file is @generated
use serde::{Deserialize, Serialize};

/// Result of creating an onboarding link
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct OnboardingLinkResponse {
    pub expires_at: chrono::DateTime<chrono::Utc>,

    pub url: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl OnboardingLinkResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(expires_at: chrono::DateTime<chrono::Utc>, url: impl Into<String>) -> Self {
        Self {
            expires_at,
            url: url.into(),
            extra: serde_json::Map::new(),
        }
    }
}

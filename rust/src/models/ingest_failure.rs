// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct IngestFailure {
    pub event_id: String,

    pub reason: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl IngestFailure {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(event_id: impl Into<String>, reason: impl Into<String>) -> Self {
        Self {
            event_id: event_id.into(),
            reason: reason.into(),
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::ingest_failure::IngestFailure;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct IngestEventsResponse {
    /// Events that failed to ingest. Omitted when no failures.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub failures: Option<Vec<IngestFailure>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl IngestEventsResponse {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            failures: None,
            extra: serde_json::Map::new(),
        }
    }
}

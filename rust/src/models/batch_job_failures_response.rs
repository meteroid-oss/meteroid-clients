// this file is @generated
use serde::{Deserialize, Serialize};

use super::batch_job_item_failure_response::BatchJobItemFailureResponse;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BatchJobFailuresResponse {
    pub data: Vec<BatchJobItemFailureResponse>,

    pub total_count: i64,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BatchJobFailuresResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<BatchJobItemFailureResponse>, total_count: i64) -> Self {
        Self {
            data,
            total_count,
            extra: serde_json::Map::new(),
        }
    }
}

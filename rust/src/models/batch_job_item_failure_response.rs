// this file is @generated
use serde::{Deserialize, Serialize};

use super::batch_job_chunk_id::BatchJobChunkId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BatchJobItemFailureResponse {
    pub chunk_id: BatchJobChunkId,

    pub id: uuid::Uuid,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub item_identifier: Option<String>,

    pub item_index: i32,

    pub reason: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BatchJobItemFailureResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        chunk_id: BatchJobChunkId,
        id: uuid::Uuid,
        item_index: i32,
        reason: impl Into<String>,
    ) -> Self {
        Self {
            chunk_id,
            id,
            item_identifier: None,
            item_index,
            reason: reason.into(),
            extra: serde_json::Map::new(),
        }
    }
}

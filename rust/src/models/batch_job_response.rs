// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    batch_job_id::BatchJobId, batch_job_status::BatchJobStatus, batch_job_type::BatchJobType,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BatchJobResponse {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub completed_at: Option<chrono::DateTime<chrono::Utc>>,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub created_by: uuid::Uuid,

    pub failed_items: i32,

    pub id: BatchJobId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_file_name: Option<String>,

    pub job_type: BatchJobType,

    pub processed_items: i32,

    pub status: BatchJobStatus,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub total_items: Option<i32>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BatchJobResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        created_by: uuid::Uuid,
        failed_items: i32,
        id: BatchJobId,
        job_type: BatchJobType,
        processed_items: i32,
        status: BatchJobStatus,
    ) -> Self {
        Self {
            completed_at: None,
            created_at,
            created_by,
            failed_items,
            id,
            input_file_name: None,
            job_type,
            processed_items,
            status,
            total_items: None,
            extra: serde_json::Map::new(),
        }
    }
}

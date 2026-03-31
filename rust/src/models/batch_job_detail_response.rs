// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    batch_job_id::BatchJobId, batch_job_status::BatchJobStatus, batch_job_type::BatchJobType,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct BatchJobDetailResponse {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub completed_at: Option<String>,

    pub created_at: String,

    pub created_by: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub error_csv_url: Option<String>,

    pub failed_items: i32,

    pub failure_count: i32,

    pub has_error_csv: bool,

    pub id: BatchJobId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_file_name: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_file_url: Option<String>,

    pub job_type: BatchJobType,

    pub processed_items: i32,

    pub status: BatchJobStatus,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub total_items: Option<i32>,
}

impl BatchJobDetailResponse {
    pub fn new(
        created_at: String,
        created_by: String,
        failed_items: i32,
        failure_count: i32,
        has_error_csv: bool,
        id: BatchJobId,
        job_type: BatchJobType,
        processed_items: i32,
        status: BatchJobStatus,
    ) -> Self {
        Self {
            completed_at: None,
            created_at,
            created_by,
            error_csv_url: None,
            failed_items,
            failure_count,
            has_error_csv,
            id,
            input_file_name: None,
            input_file_url: None,
            job_type,
            processed_items,
            status,
            total_items: None,
        }
    }
}

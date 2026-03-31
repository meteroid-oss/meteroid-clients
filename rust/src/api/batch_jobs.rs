// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

#[derive(Default)]
pub struct BatchJobsListBatchJobFailuresOptions {
    pub chunk_id: Option<BatchJobChunkId>,

    pub limit: Option<i32>,

    pub offset: Option<i32>,
}

pub struct BatchJobs<'a> {
    cfg: &'a Configuration,
}

impl<'a> BatchJobs<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    /// Retrieve a single batch job with its chunks and failures.
    pub async fn get_batch_job(
        &self,
        batch_job_id: String,
    ) -> Result<crate::models::BatchJobDetailResponse> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/batch-jobs/{batch_job_id}")
            .with_path_param("batch_job_id", batch_job_id)
            .execute(self.cfg)
            .await
    }

    /// Retrieve paginated failures for a batch job.
    pub async fn list_batch_job_failures(
        &self,
        batch_job_id: String,
        options: Option<BatchJobsListBatchJobFailuresOptions>,
    ) -> Result<crate::models::BatchJobFailuresResponse> {
        let BatchJobsListBatchJobFailuresOptions {
            chunk_id,
            limit,
            offset,
        } = options.unwrap_or_default();

        crate::request::Request::new(
            http1::Method::GET,
            "/api/v1/batch-jobs/{batch_job_id}/failures",
        )
        .with_path_param("batch_job_id", batch_job_id)
        .with_optional_query_param("chunk_id", chunk_id)
        .with_optional_query_param("limit", limit)
        .with_optional_query_param("offset", offset)
        .execute(self.cfg)
        .await
    }
}

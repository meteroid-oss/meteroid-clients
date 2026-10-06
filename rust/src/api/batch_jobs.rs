// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`BatchJobs::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct BatchJobsListOptions {
    /// The `job_type` query parameter.
    pub job_type: Option<BatchJobType>,
    /// The `status` query parameter.
    pub status: Option<Vec<BatchJobStatus>>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl BatchJobsListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            job_type: None,
            status: None,
            page: None,
            per_page: None,
        }
    }

    /// Sets the `job_type` query parameter.
    #[must_use]
    pub fn job_type(mut self, job_type: impl Into<BatchJobType>) -> Self {
        self.job_type = Some(job_type.into());
        self
    }

    /// Sets the `status` query parameter.
    #[must_use]
    pub fn status(mut self, status: impl Into<Vec<BatchJobStatus>>) -> Self {
        self.status = Some(status.into());
        self
    }

    /// Sets the `page` query parameter.
    #[must_use]
    pub fn page(mut self, page: impl Into<i32>) -> Self {
        self.page = Some(page.into());
        self
    }

    /// Sets the `per_page` query parameter.
    #[must_use]
    pub fn per_page(mut self, per_page: impl Into<i32>) -> Self {
        self.per_page = Some(per_page.into());
        self
    }
}

/// Query and header parameters of [`BatchJobs::list_failures`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct BatchJobsListFailuresOptions {
    /// The `chunk_id` query parameter.
    pub chunk_id: Option<BatchJobChunkId>,
    /// The `limit` query parameter.
    pub limit: Option<i32>,
    /// The `offset` query parameter.
    pub offset: Option<i32>,
}

impl BatchJobsListFailuresOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            chunk_id: None,
            limit: None,
            offset: None,
        }
    }

    /// Sets the `chunk_id` query parameter.
    #[must_use]
    pub fn chunk_id(mut self, chunk_id: impl Into<BatchJobChunkId>) -> Self {
        self.chunk_id = Some(chunk_id.into());
        self
    }

    /// Sets the `limit` query parameter.
    #[must_use]
    pub fn limit(mut self, limit: impl Into<i32>) -> Self {
        self.limit = Some(limit.into());
        self
    }

    /// Sets the `offset` query parameter.
    #[must_use]
    pub fn offset(mut self, offset: impl Into<i32>) -> Self {
        self.offset = Some(offset.into());
        self
    }
}

/// The batch jobs API, from the client's
/// [`batch_jobs`](crate::api::Meteroid::batch_jobs).
#[derive(Clone)]
pub struct BatchJobs {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for BatchJobs {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("BatchJobs")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl BatchJobs {
    pub(super) fn new(cfg: std::sync::Arc<Configuration>) -> Self {
        Self {
            cfg,
            options: crate::api::RequestOptions::default(),
        }
    }

    /// Applies `options` (headers, timeout, retries, idempotency key) to the calls made
    /// through the returned value.
    #[must_use]
    pub fn with_options(mut self, options: crate::api::RequestOptions) -> Self {
        self.options = options;
        self
    }

    /// List batch jobs with optional filtering by type and status.
    ///
    /// `GET /api/v1/batch-jobs`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn list(
        &self,
        options: impl Into<Option<BatchJobsListOptions>>,
    ) -> crate::api::Call<crate::models::BatchJobListResponse> {
        let BatchJobsListOptions {
            job_type,
            status,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/batch-jobs")
            .with_optional_query_param("job_type", job_type)
            .with_optional_exploded_query_param("status", status)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get batch job detail
    ///
    /// Retrieve a single batch job with its chunks and failures.
    ///
    /// `GET /api/v1/batch-jobs/{batch_job_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve(
        &self,
        batch_job_id: &str,
    ) -> crate::api::Call<crate::models::BatchJobDetailResponse> {
        crate::request::Request::new(http::Method::GET, "/api/v1/batch-jobs/{batch_job_id}")
            .with_path_param("batch_job_id", batch_job_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// List batch job failures
    ///
    /// Retrieve paginated failures for a batch job.
    ///
    /// `GET /api/v1/batch-jobs/{batch_job_id}/failures`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn list_failures(
        &self,
        batch_job_id: &str,
        options: impl Into<Option<BatchJobsListFailuresOptions>>,
    ) -> crate::api::Call<crate::models::BatchJobFailuresResponse> {
        let BatchJobsListFailuresOptions {
            chunk_id,
            limit,
            offset,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(
            http::Method::GET,
            "/api/v1/batch-jobs/{batch_job_id}/failures",
        )
        .with_path_param("batch_job_id", batch_job_id)
        .with_optional_query_param("chunk_id", chunk_id)
        .with_optional_query_param("limit", limit)
        .with_optional_query_param("offset", offset)
        .with_options(&self.options)
        .json(&self.cfg)
    }
}

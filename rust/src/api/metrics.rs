// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`Metrics::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct MetricsListOptions {
    /// The `product_family_id` query parameter.
    pub product_family_id: Option<ProductFamilyId>,
    /// Search by metric name or code
    pub search: Option<String>,
    /// Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
    pub order_by: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl MetricsListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            product_family_id: None,
            search: None,
            order_by: None,
            page: None,
            per_page: None,
        }
    }

    /// Sets the `product_family_id` query parameter.
    #[must_use]
    pub fn product_family_id(mut self, product_family_id: impl Into<ProductFamilyId>) -> Self {
        self.product_family_id = Some(product_family_id.into());
        self
    }

    /// Sets the `search` query parameter.
    #[must_use]
    pub fn search(mut self, search: impl Into<String>) -> Self {
        self.search = Some(search.into());
        self
    }

    /// Sets the `order_by` query parameter.
    #[must_use]
    pub fn order_by(mut self, order_by: impl Into<String>) -> Self {
        self.order_by = Some(order_by.into());
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

/// The metrics API, from the client's
/// [`metrics`](crate::api::Meteroid::metrics).
#[derive(Clone)]
pub struct Metrics {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Metrics {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Metrics")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Metrics {
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

    /// List billable metrics
    ///
    /// `GET /api/v1/metrics`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429).
    pub fn list(
        &self,
        options: impl Into<Option<MetricsListOptions>>,
    ) -> crate::api::Call<crate::models::MetricListResponse> {
        let MetricsListOptions {
            product_family_id,
            search,
            order_by,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/metrics")
            .with_optional_query_param("product_family_id", product_family_id)
            .with_optional_query_param("search", search)
            .with_optional_query_param("order_by", order_by)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create a billable metric
    ///
    /// `POST /api/v1/metrics`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 429).
    pub fn create(
        &self,
        create_metric_request: crate::models::CreateMetricRequest,
    ) -> crate::api::Call<crate::models::Metric> {
        crate::request::Request::new(http::Method::POST, "/api/v1/metrics")
            .with_body_param(create_metric_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get metric details
    ///
    /// `GET /api/v1/metrics/{metric_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn retrieve(&self, metric_id: &str) -> crate::api::Call<crate::models::Metric> {
        crate::request::Request::new(http::Method::GET, "/api/v1/metrics/{metric_id}")
            .with_path_param("metric_id", metric_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Update a billable metric
    ///
    /// Partially update metric fields. Code and aggregation_type are immutable.
    ///
    /// `PATCH /api/v1/metrics/{metric_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429).
    pub fn update(
        &self,
        metric_id: &str,
        update_metric_request: crate::models::UpdateMetricRequest,
    ) -> crate::api::Call<crate::models::Metric> {
        crate::request::Request::new(http::Method::PATCH, "/api/v1/metrics/{metric_id}")
            .with_path_param("metric_id", metric_id)
            .with_body_param(update_metric_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Archive a billable metric
    ///
    /// `POST /api/v1/metrics/{metric_id}/archive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn archive(&self, metric_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/metrics/{metric_id}/archive")
            .with_path_param("metric_id", metric_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Unarchive a billable metric
    ///
    /// `POST /api/v1/metrics/{metric_id}/unarchive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn unarchive(&self, metric_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/metrics/{metric_id}/unarchive")
            .with_path_param("metric_id", metric_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }
}

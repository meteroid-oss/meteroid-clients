// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`Coupons::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct CouponsListOptions {
    /// The `search` query parameter.
    pub search: Option<String>,
    /// The `filter` query parameter.
    pub filter: Option<CouponFilter>,
    /// Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
    pub order_by: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl CouponsListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            search: None,
            filter: None,
            order_by: None,
            page: None,
            per_page: None,
        }
    }

    /// Sets the `search` query parameter.
    #[must_use]
    pub fn search(mut self, search: impl Into<String>) -> Self {
        self.search = Some(search.into());
        self
    }

    /// Sets the `filter` query parameter.
    #[must_use]
    pub fn filter(mut self, filter: impl Into<CouponFilter>) -> Self {
        self.filter = Some(filter.into());
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

/// The coupons API, from the client's
/// [`coupons`](crate::api::Meteroid::coupons).
#[derive(Clone)]
pub struct Coupons {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Coupons {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Coupons")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Coupons {
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

    /// List coupons
    ///
    /// `GET /api/v1/coupons`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429).
    pub fn list(
        &self,
        options: impl Into<Option<CouponsListOptions>>,
    ) -> crate::api::Call<crate::models::CouponListResponse> {
        let CouponsListOptions {
            search,
            filter,
            order_by,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/coupons")
            .with_optional_query_param("search", search)
            .with_optional_query_param("filter", filter)
            .with_optional_query_param("order_by", order_by)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create a coupon
    ///
    /// `POST /api/v1/coupons`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 429).
    pub fn create(
        &self,
        create_coupon_request: crate::models::CreateCouponRequest,
    ) -> crate::api::Call<crate::models::Coupon> {
        crate::request::Request::new(http::Method::POST, "/api/v1/coupons")
            .with_body_param(create_coupon_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get coupon details
    ///
    /// `GET /api/v1/coupons/{coupon_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn retrieve(&self, coupon_id: &str) -> crate::api::Call<crate::models::Coupon> {
        crate::request::Request::new(http::Method::GET, "/api/v1/coupons/{coupon_id}")
            .with_path_param("coupon_id", coupon_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Update a coupon
    ///
    /// `PATCH /api/v1/coupons/{coupon_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429).
    pub fn update(
        &self,
        coupon_id: &str,
        update_coupon_request: crate::models::UpdateCouponRequest,
    ) -> crate::api::Call<crate::models::Coupon> {
        crate::request::Request::new(http::Method::PATCH, "/api/v1/coupons/{coupon_id}")
            .with_path_param("coupon_id", coupon_id)
            .with_body_param(update_coupon_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Archive a coupon
    ///
    /// `POST /api/v1/coupons/{coupon_id}/archive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn archive(&self, coupon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/coupons/{coupon_id}/archive")
            .with_path_param("coupon_id", coupon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Disable a coupon
    ///
    /// `POST /api/v1/coupons/{coupon_id}/disable`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn disable(&self, coupon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/coupons/{coupon_id}/disable")
            .with_path_param("coupon_id", coupon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Enable a coupon
    ///
    /// `POST /api/v1/coupons/{coupon_id}/enable`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn enable(&self, coupon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/coupons/{coupon_id}/enable")
            .with_path_param("coupon_id", coupon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Unarchive a coupon
    ///
    /// `POST /api/v1/coupons/{coupon_id}/unarchive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn unarchive(&self, coupon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/coupons/{coupon_id}/unarchive")
            .with_path_param("coupon_id", coupon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }
}

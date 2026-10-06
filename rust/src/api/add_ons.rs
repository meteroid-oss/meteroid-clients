// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`AddOns::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct AddOnsListOptions {
    /// The `search` query parameter.
    pub search: Option<String>,
    /// The `currency` query parameter.
    pub currency: Option<String>,
    /// Include archived add-ons in the results (default: false)
    pub include_archived: Option<bool>,
    /// Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
    pub order_by: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl AddOnsListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            search: None,
            currency: None,
            include_archived: None,
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

    /// Sets the `currency` query parameter.
    #[must_use]
    pub fn currency(mut self, currency: impl Into<String>) -> Self {
        self.currency = Some(currency.into());
        self
    }

    /// Sets the `include_archived` query parameter.
    #[must_use]
    pub fn include_archived(mut self, include_archived: impl Into<bool>) -> Self {
        self.include_archived = Some(include_archived.into());
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

/// The add ons API, from the client's
/// [`add_ons`](crate::api::Meteroid::add_ons).
#[derive(Clone)]
pub struct AddOns {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for AddOns {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("AddOns")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl AddOns {
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

    /// List add-ons
    ///
    /// `GET /api/v1/addons`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429).
    pub fn list(
        &self,
        options: impl Into<Option<AddOnsListOptions>>,
    ) -> crate::api::Call<crate::models::AddOnListResponse> {
        let AddOnsListOptions {
            search,
            currency,
            include_archived,
            order_by,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/addons")
            .with_optional_query_param("search", search)
            .with_optional_query_param("currency", currency)
            .with_optional_query_param("include_archived", include_archived)
            .with_optional_query_param("order_by", order_by)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create an add-on
    ///
    /// `POST /api/v1/addons`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 429).
    pub fn create(
        &self,
        create_add_on_request: crate::models::CreateAddOnRequest,
    ) -> crate::api::Call<crate::models::AddOn> {
        crate::request::Request::new(http::Method::POST, "/api/v1/addons")
            .with_body_param(create_add_on_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get add-on details
    ///
    /// `GET /api/v1/addons/{addon_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn retrieve(&self, addon_id: &str) -> crate::api::Call<crate::models::AddOn> {
        crate::request::Request::new(http::Method::GET, "/api/v1/addons/{addon_id}")
            .with_path_param("addon_id", addon_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Update an add-on
    ///
    /// `PATCH /api/v1/addons/{addon_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429).
    pub fn update(
        &self,
        addon_id: &str,
        update_add_on_request: crate::models::UpdateAddOnRequest,
    ) -> crate::api::Call<crate::models::AddOn> {
        crate::request::Request::new(http::Method::PATCH, "/api/v1/addons/{addon_id}")
            .with_path_param("addon_id", addon_id)
            .with_body_param(update_add_on_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Archive an add-on
    ///
    /// `POST /api/v1/addons/{addon_id}/archive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn archive(&self, addon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/addons/{addon_id}/archive")
            .with_path_param("addon_id", addon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// List add-on entitlements
    ///
    /// `GET /api/v1/addons/{addon_id}/entitlements`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn list_entitlements(
        &self,
        addon_id: &str,
    ) -> crate::api::Call<crate::models::ResolvedEntitlementListResponse> {
        crate::request::Request::new(http::Method::GET, "/api/v1/addons/{addon_id}/entitlements")
            .with_path_param("addon_id", addon_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Unarchive an add-on
    ///
    /// `POST /api/v1/addons/{addon_id}/unarchive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn unarchive(&self, addon_id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/addons/{addon_id}/unarchive")
            .with_path_param("addon_id", addon_id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }
}

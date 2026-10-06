// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`Customers::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct CustomersListOptions {
    /// Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
    pub order_by: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
    /// The `search` query parameter.
    pub search: Option<String>,
    /// The `archived` query parameter.
    pub archived: Option<bool>,
}

impl CustomersListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            order_by: None,
            page: None,
            per_page: None,
            search: None,
            archived: None,
        }
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

    /// Sets the `search` query parameter.
    #[must_use]
    pub fn search(mut self, search: impl Into<String>) -> Self {
        self.search = Some(search.into());
        self
    }

    /// Sets the `archived` query parameter.
    #[must_use]
    pub fn archived(mut self, archived: impl Into<bool>) -> Self {
        self.archived = Some(archived.into());
        self
    }
}

/// The customers API, from the client's
/// [`customers`](crate::api::Meteroid::customers).
#[derive(Clone)]
pub struct Customers {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Customers {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Customers")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Customers {
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

    /// List customers with optional pagination and search filtering.
    ///
    /// `GET /api/v1/customers`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn list(
        &self,
        options: impl Into<Option<CustomersListOptions>>,
    ) -> crate::api::Call<crate::models::CustomerListResponse> {
        let CustomersListOptions {
            order_by,
            page,
            per_page,
            search,
            archived,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/customers")
            .with_optional_query_param("order_by", order_by)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_optional_query_param("search", search)
            .with_optional_query_param("archived", archived)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create customer
    ///
    /// `POST /api/v1/customers`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 409, 429, 500).
    pub fn create(
        &self,
        customer_create_request: crate::models::CustomerCreateRequest,
    ) -> crate::api::Call<crate::models::Customer> {
        crate::request::Request::new(http::Method::POST, "/api/v1/customers")
            .with_body_param(customer_create_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get customer
    ///
    /// Retrieve a single customer by ID or alias.
    ///
    /// `GET /api/v1/customers/{id_or_alias}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve(&self, id_or_alias: &str) -> crate::api::Call<crate::models::Customer> {
        crate::request::Request::new(http::Method::GET, "/api/v1/customers/{id_or_alias}")
            .with_path_param("id_or_alias", id_or_alias)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Update customer
    ///
    /// `PUT /api/v1/customers/{id_or_alias}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429, 500).
    pub fn replace(
        &self,
        id_or_alias: &str,
        customer_update_request: crate::models::CustomerUpdateRequest,
    ) -> crate::api::Call<crate::models::Customer> {
        crate::request::Request::new(http::Method::PUT, "/api/v1/customers/{id_or_alias}")
            .with_path_param("id_or_alias", id_or_alias)
            .with_body_param(customer_update_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Archive a customer
    ///
    /// No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail.
    ///
    /// `DELETE /api/v1/customers/{id_or_alias}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn archive(&self, id_or_alias: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::DELETE, "/api/v1/customers/{id_or_alias}")
            .with_path_param("id_or_alias", id_or_alias)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Patch customer
    ///
    /// Partially update a customer. Only provided fields will be updated.
    ///
    /// `PATCH /api/v1/customers/{id_or_alias}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429, 500).
    pub fn update(
        &self,
        id_or_alias: &str,
        customer_patch_request: crate::models::CustomerPatchRequest,
    ) -> crate::api::Call<crate::models::Customer> {
        crate::request::Request::new(http::Method::PATCH, "/api/v1/customers/{id_or_alias}")
            .with_path_param("id_or_alias", id_or_alias)
            .with_body_param(customer_patch_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// List customer entitlements
    ///
    /// `GET /api/v1/customers/{id_or_alias}/entitlements`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429).
    pub fn list_entitlements(
        &self,
        id_or_alias: &str,
    ) -> crate::api::Call<crate::models::EffectiveEntitlementListResponse> {
        crate::request::Request::new(
            http::Method::GET,
            "/api/v1/customers/{id_or_alias}/entitlements",
        )
        .with_path_param("id_or_alias", id_or_alias)
        .with_options(&self.options)
        .json(&self.cfg)
    }

    /// Generate a portal token for a customer
    ///
    /// Generates a JWT token that grants access to the customer portal.
    /// The token can be used to access invoices, payment methods, and other portal features.
    ///
    /// `POST /api/v1/customers/{id_or_alias}/portal-token`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429, 500).
    pub fn create_portal_token(
        &self,
        id_or_alias: &str,
        customer_portal_token_request: crate::models::CustomerPortalTokenRequest,
    ) -> crate::api::Call<crate::models::CustomerPortalTokenResponse> {
        crate::request::Request::new(
            http::Method::POST,
            "/api/v1/customers/{id_or_alias}/portal-token",
        )
        .with_path_param("id_or_alias", id_or_alias)
        .with_body_param(customer_portal_token_request)
        .with_options(&self.options)
        .json(&self.cfg)
    }

    /// Restore an archived customer
    ///
    /// `POST /api/v1/customers/{id_or_alias}/unarchive`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn unarchive(&self, id_or_alias: &str) -> crate::api::Call<()> {
        crate::request::Request::new(
            http::Method::POST,
            "/api/v1/customers/{id_or_alias}/unarchive",
        )
        .with_path_param("id_or_alias", id_or_alias)
        .with_options(&self.options)
        .empty(&self.cfg)
    }
}

// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`CheckoutSessions::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct CheckoutSessionsListOptions {
    /// The `customer_id` query parameter.
    pub customer_id: Option<CustomerId>,
    /// The `status` query parameter.
    pub status: Option<CheckoutSessionStatus>,
}

impl CheckoutSessionsListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            customer_id: None,
            status: None,
        }
    }

    /// Sets the `customer_id` query parameter.
    #[must_use]
    pub fn customer_id(mut self, customer_id: impl Into<CustomerId>) -> Self {
        self.customer_id = Some(customer_id.into());
        self
    }

    /// Sets the `status` query parameter.
    #[must_use]
    pub fn status(mut self, status: impl Into<CheckoutSessionStatus>) -> Self {
        self.status = Some(status.into());
        self
    }
}

/// The checkout sessions API, from the client's
/// [`checkout_sessions`](crate::api::Meteroid::checkout_sessions).
#[derive(Clone)]
pub struct CheckoutSessions {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for CheckoutSessions {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("CheckoutSessions")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl CheckoutSessions {
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

    /// List checkout sessions
    ///
    /// `GET /api/v1/checkout-sessions`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn list(
        &self,
        options: impl Into<Option<CheckoutSessionsListOptions>>,
    ) -> crate::api::Call<crate::models::ListCheckoutSessionsResponse> {
        let CheckoutSessionsListOptions {
            customer_id,
            status,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/checkout-sessions")
            .with_optional_query_param("customer_id", customer_id)
            .with_optional_query_param("status", status)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create a checkout session
    ///
    /// `POST /api/v1/checkout-sessions`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 429, 500).
    pub fn create(
        &self,
        create_checkout_session_request: crate::models::CreateCheckoutSessionRequest,
    ) -> crate::api::Call<crate::models::CreateCheckoutSessionResponse> {
        crate::request::Request::new(http::Method::POST, "/api/v1/checkout-sessions")
            .with_body_param(create_checkout_session_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get a checkout session by ID
    ///
    /// `GET /api/v1/checkout-sessions/{id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve(
        &self,
        id: &str,
    ) -> crate::api::Call<crate::models::GetCheckoutSessionResponse> {
        crate::request::Request::new(http::Method::GET, "/api/v1/checkout-sessions/{id}")
            .with_path_param("id", id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Cancel a checkout session
    ///
    /// `POST /api/v1/checkout-sessions/{id}/cancel`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429, 500).
    pub fn cancel(
        &self,
        id: &str,
    ) -> crate::api::Call<crate::models::CancelCheckoutSessionResponse> {
        crate::request::Request::new(http::Method::POST, "/api/v1/checkout-sessions/{id}/cancel")
            .with_path_param("id", id)
            .with_options(&self.options)
            .json(&self.cfg)
    }
}

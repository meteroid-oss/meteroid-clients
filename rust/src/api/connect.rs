// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// The connect API, from the client's
/// [`connect`](crate::api::Meteroid::connect).
#[derive(Clone)]
pub struct Connect {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Connect {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Connect")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Connect {
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

    /// List connected accounts
    ///
    /// List all connected accounts for this platform.
    ///
    /// `GET /api/v1/connected-accounts`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn list_connected_accounts(
        &self,
    ) -> crate::api::Call<crate::models::ConnectedAccountsResponse> {
        crate::request::Request::new(http::Method::GET, "/api/v1/connected-accounts")
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create connected account
    ///
    /// Create a new connected account (Express flow). Returns the account
    /// and an onboarding link for the user to complete setup.
    ///
    /// `POST /api/v1/connected-accounts`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn create_connected_account(
        &self,
        create_connected_account_request: crate::models::CreateConnectedAccountRequest,
    ) -> crate::api::Call<crate::models::ConnectedAccount> {
        crate::request::Request::new(http::Method::POST, "/api/v1/connected-accounts")
            .with_body_param(create_connected_account_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get connected account
    ///
    /// Retrieve a connected account by ID.
    ///
    /// `GET /api/v1/connected-accounts/{id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn retrieve_connected_account(
        &self,
        id: &str,
    ) -> crate::api::Call<crate::models::ConnectedAccount> {
        crate::request::Request::new(http::Method::GET, "/api/v1/connected-accounts/{id}")
            .with_path_param("id", id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Disconnect account
    ///
    /// Revoke a connected account. All associated tokens are invalidated.
    ///
    /// `DELETE /api/v1/connected-accounts/{id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn disconnect_account(&self, id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::DELETE, "/api/v1/connected-accounts/{id}")
            .with_path_param("id", id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Create onboarding link
    ///
    /// Generate a new onboarding link for a connected account. Any existing
    /// unused link is invalidated. The link expires after a configured duration.
    ///
    /// `POST /api/v1/connected-accounts/{id}/onboarding`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn create_onboarding_link(
        &self,
        id: &str,
        create_onboarding_link_request: crate::models::CreateOnboardingLinkRequest,
    ) -> crate::api::Call<crate::models::OnboardingLinkResponse> {
        crate::request::Request::new(
            http::Method::POST,
            "/api/v1/connected-accounts/{id}/onboarding",
        )
        .with_path_param("id", id)
        .with_body_param(create_onboarding_link_request)
        .with_options(&self.options)
        .json(&self.cfg)
    }
}

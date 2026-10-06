// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// The oauth apps API, from the client's
/// [`oauth_apps`](crate::api::Meteroid::oauth_apps).
#[derive(Clone)]
pub struct OauthApps {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for OauthApps {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("OauthApps")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl OauthApps {
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

    /// List OAuth apps
    ///
    /// List all OAuth applications registered for this platform.
    ///
    /// `GET /api/v1/oauth-apps`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn list(&self) -> crate::api::Call<crate::models::OAuthAppsResponse> {
        crate::request::Request::new(http::Method::GET, "/api/v1/oauth-apps")
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Create OAuth app
    ///
    /// Register a new OAuth application. Returns the app with its client secret
    /// (only shown once).
    ///
    /// `POST /api/v1/oauth-apps`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn create(
        &self,
        create_o_auth_app_request: crate::models::CreateOAuthAppRequest,
    ) -> crate::api::Call<crate::models::OAuthAppWithSecret> {
        crate::request::Request::new(http::Method::POST, "/api/v1/oauth-apps")
            .with_body_param(create_o_auth_app_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get OAuth app
    ///
    /// Retrieve an OAuth application by ID.
    ///
    /// `GET /api/v1/oauth-apps/{id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn retrieve(&self, id: &str) -> crate::api::Call<crate::models::OAuthApp> {
        crate::request::Request::new(http::Method::GET, "/api/v1/oauth-apps/{id}")
            .with_path_param("id", id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Delete OAuth app
    ///
    /// Delete an OAuth application and revoke all associated tokens.
    ///
    /// `DELETE /api/v1/oauth-apps/{id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn delete(&self, id: &str) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::DELETE, "/api/v1/oauth-apps/{id}")
            .with_path_param("id", id)
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Rotate client secret
    ///
    /// Generate a new client secret for an OAuth app. The old secret is
    /// immediately invalidated.
    ///
    /// `POST /api/v1/oauth-apps/{id}/rotate`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn rotate(&self, id: &str) -> crate::api::Call<crate::models::RotatedSecret> {
        crate::request::Request::new(http::Method::POST, "/api/v1/oauth-apps/{id}/rotate")
            .with_path_param("id", id)
            .with_options(&self.options)
            .json(&self.cfg)
    }
}

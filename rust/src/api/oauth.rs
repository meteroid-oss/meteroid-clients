// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// The oauth API, from the client's
/// [`oauth`](crate::api::Meteroid::oauth).
#[derive(Clone)]
pub struct Oauth {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Oauth {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Oauth")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Oauth {
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

    /// Introspect token
    ///
    /// Token introspection endpoint (RFC 7662). Requires client credentials
    /// via HTTP Basic auth.
    ///
    /// `POST /api/v1/oauth/introspect`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`OAuthErrorResponse`](crate::models::OAuthErrorResponse) (401) or [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn introspect(
        &self,
        introspection_request: crate::models::IntrospectionRequest,
    ) -> crate::api::Call<crate::models::TokenIntrospectionResponse> {
        crate::request::Request::new(http::Method::POST, "/api/v1/oauth/introspect")
            .with_security(&[])
            .with_form_body_param(introspection_request, &[], &[])
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Revoke token
    ///
    /// Token revocation endpoint (RFC 7009). Always returns 200 per spec.
    /// Requires client credentials via HTTP Basic auth.
    ///
    /// `POST /api/v1/oauth/revoke`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`OAuthErrorResponse`](crate::models::OAuthErrorResponse) (401) or [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn revoke(
        &self,
        revocation_request: crate::models::RevocationRequest,
    ) -> crate::api::Call<()> {
        crate::request::Request::new(http::Method::POST, "/api/v1/oauth/revoke")
            .with_security(&[])
            .with_form_body_param(revocation_request, &[], &[])
            .with_options(&self.options)
            .empty(&self.cfg)
    }

    /// Exchange tokens
    ///
    /// OAuth 2.0 token endpoint. Supports two grant types:
    /// - `authorization_code`: Exchange an authorization code for tokens
    /// - `refresh_token`: Refresh an access token
    ///
    /// Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.
    ///
    /// `POST /api/v1/oauth/token`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`OAuthErrorResponse`](crate::models::OAuthErrorResponse) (400, 401) or [`RestErrorResponse`](crate::models::RestErrorResponse) (429).
    pub fn token(
        &self,
        token_request: crate::models::TokenRequest,
    ) -> crate::api::Call<crate::models::TokenResponse> {
        crate::request::Request::new(http::Method::POST, "/api/v1/oauth/token")
            .with_security(&[])
            .with_form_body_param(token_request, &[], &[])
            .with_options(&self.options)
            .json(&self.cfg)
    }
}

// this file is @generated
//! The `Meteroid` client and its builder.

use std::{fmt, sync::Arc, time::Duration};

use hyper_util::client::legacy::connect::Connect;

use super::{
    middleware::{Middleware, Middlewares},
    HttpClient,
};
use crate::{error::Error, request::Failure, Configuration};

use super::auth_schemes::{Credentials, Scheme, Security};

const CRATE_VERSION: &str = env!("CARGO_PKG_VERSION");
const DEFAULT_BASE_URL: Option<&str> = Some("https://api.meteroid.com");
const API_KEY_ENV: &str = "METEROID_API_KEY";
const BASE_URL_ENV: &str = "METEROID_BASE_URL";
static SECURITY_SCHEMES: &[(&str, Scheme)] = &[("bearer_auth", Scheme::Bearer)];

static DEFAULT_SECURITY: Security = &[&["bearer_auth"]];

/// The `Meteroid` API client, cheap to clone: clones share their connections.
///
/// ```no_run
/// use meteroid_rs::api::Meteroid;
///
/// # async fn example() -> Result<(), meteroid_rs::error::Error> {
/// // `METEROID_API_KEY` and `METEROID_BASE_URL`, when set
/// let client = Meteroid::from_env()?;
/// let client = Meteroid::builder()
///     .token("your-api-key")
///     .timeout(std::time::Duration::from_secs(20))
///     .max_retries(3)
///     .build()?;
/// # Ok(())
/// # }
/// ```
#[derive(Clone)]
pub struct Meteroid {
    pub(super) cfg: Arc<Configuration>,
}

impl Meteroid {
    /// A client sending `token`, configured otherwise like [`from_env`](Self::from_env).
    ///
    /// # Errors
    ///
    /// See [`MeteroidBuilder::build`].
    pub fn new(token: impl Into<String>) -> Result<Self, Error> {
        Self::builder().token(token).build()
    }

    /// A client configured from the environment: the token from `METEROID_API_KEY`,
    /// and the base URL from `METEROID_BASE_URL` when set.
    ///
    /// # Errors
    ///
    /// See [`MeteroidBuilder::build`].
    pub fn from_env() -> Result<Self, Error> {
        Self::builder().build()
    }

    /// A builder of a client, to set its token, base URL, timeout, retries, headers or HTTP
    /// client.
    pub fn builder() -> MeteroidBuilder {
        MeteroidBuilder::default()
    }

    /// The same client sending another token, sharing its connections.
    #[must_use]
    pub fn with_token(&self, token: impl Into<String>) -> Self {
        let cfg = Arc::new(Configuration {
            base_path: self.cfg.base_path.clone(),
            user_agent: self.cfg.user_agent.clone(),
            bearer_access_token: Some(token.into()),
            client: self.cfg.client.clone(),
            timeout: self.cfg.timeout,
            max_retries: self.cfg.max_retries,
            middleware: self.cfg.middleware.clone(),
            headers: self.cfg.headers.clone(),
            credentials: self.cfg.credentials.clone(),
        });

        Self { cfg }
    }

    /// The add ons API.
    #[must_use]
    pub fn add_ons(&self) -> super::AddOns {
        super::AddOns::new(self.cfg.clone())
    }

    /// The batch jobs API.
    #[must_use]
    pub fn batch_jobs(&self) -> super::BatchJobs {
        super::BatchJobs::new(self.cfg.clone())
    }

    /// The checkout sessions API.
    #[must_use]
    pub fn checkout_sessions(&self) -> super::CheckoutSessions {
        super::CheckoutSessions::new(self.cfg.clone())
    }

    /// The connect API.
    #[must_use]
    pub fn connect(&self) -> super::Connect {
        super::Connect::new(self.cfg.clone())
    }

    /// The coupons API.
    #[must_use]
    pub fn coupons(&self) -> super::Coupons {
        super::Coupons::new(self.cfg.clone())
    }

    /// The credit notes API.
    #[must_use]
    pub fn credit_notes(&self) -> super::CreditNotes {
        super::CreditNotes::new(self.cfg.clone())
    }

    /// The custom properties API.
    #[must_use]
    pub fn custom_properties(&self) -> super::CustomProperties {
        super::CustomProperties::new(self.cfg.clone())
    }

    /// The customers API.
    #[must_use]
    pub fn customers(&self) -> super::Customers {
        super::Customers::new(self.cfg.clone())
    }

    /// The events API.
    #[must_use]
    pub fn events(&self) -> super::Events {
        super::Events::new(self.cfg.clone())
    }

    /// The features API.
    #[must_use]
    pub fn features(&self) -> super::Features {
        super::Features::new(self.cfg.clone())
    }

    /// The invoices API.
    #[must_use]
    pub fn invoices(&self) -> super::Invoices {
        super::Invoices::new(self.cfg.clone())
    }

    /// The metrics API.
    #[must_use]
    pub fn metrics(&self) -> super::Metrics {
        super::Metrics::new(self.cfg.clone())
    }

    /// The oauth API.
    #[must_use]
    pub fn oauth(&self) -> super::Oauth {
        super::Oauth::new(self.cfg.clone())
    }

    /// The oauth apps API.
    #[must_use]
    pub fn oauth_apps(&self) -> super::OauthApps {
        super::OauthApps::new(self.cfg.clone())
    }

    /// The plans API.
    #[must_use]
    pub fn plans(&self) -> super::Plans {
        super::Plans::new(self.cfg.clone())
    }

    /// The product families API.
    #[must_use]
    pub fn product_families(&self) -> super::ProductFamilies {
        super::ProductFamilies::new(self.cfg.clone())
    }

    /// The products API.
    #[must_use]
    pub fn products(&self) -> super::Products {
        super::Products::new(self.cfg.clone())
    }

    /// The subscriptions API.
    #[must_use]
    pub fn subscriptions(&self) -> super::Subscriptions {
        super::Subscriptions::new(self.cfg.clone())
    }

    /// The usage API.
    #[must_use]
    pub fn usage(&self) -> super::Usage {
        super::Usage::new(self.cfg.clone())
    }
}

impl fmt::Debug for Meteroid {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.debug_struct("Meteroid")
            .field("base_url", &self.cfg.base_path)
            .finish_non_exhaustive()
    }
}

/// Settings of a [`Meteroid`]: `Meteroid::builder().token("...").build()?`.
#[derive(Clone)]
#[must_use]
pub struct MeteroidBuilder {
    token: Option<String>,
    base_url: Option<String>,
    timeout: Option<Duration>,
    max_retries: Option<u32>,
    headers: Vec<(String, String)>,
    middleware: Middlewares,
    http_client: Option<Arc<dyn HttpClient>>,
    token_provider: Option<super::TokenProvider>,
    basic_auth: Option<super::BasicAuth>,
    api_keys: std::collections::HashMap<String, String>,
}

impl MeteroidBuilder {
    /// The token sent to the API. Defaults to `METEROID_API_KEY`.
    pub fn token(mut self, token: impl Into<String>) -> Self {
        self.token = Some(token.into());
        self
    }

    /// The URL the API is served at. Defaults to `METEROID_BASE_URL`, or
    /// `https://api.meteroid.com`.
    pub fn base_url(mut self, base_url: impl Into<String>) -> Self {
        self.base_url = Some(base_url.into());
        self
    }

    /// Timeout of each attempt, from connecting until the response body is read (for event
    /// streams, until the stream opens). `None` never times out.
    ///
    /// Default: 60 seconds.
    pub fn timeout(mut self, timeout: impl Into<Option<Duration>>) -> Self {
        self.timeout = timeout.into();
        self
    }

    /// How many times a failed request is retried: on connection errors, timeouts, and
    /// 408, 429 and 5xx responses. Only idempotent requests are retried; POST requests are
    /// made idempotent with an automatic `Idempotency-Key`. `Retry-After` is honored up to
    /// a minute, otherwise delays grow from 500ms to 8s with jitter.
    ///
    /// Default: 2.
    pub fn max_retries(mut self, max_retries: u32) -> Self {
        self.max_retries = Some(max_retries);
        self
    }

    /// Adds a header to every request. Headers of one call win over it.
    pub fn header(mut self, name: impl Into<String>, value: impl Into<String>) -> Self {
        self.headers.push((name.into(), value.into()));
        self
    }

    /// Wraps every HTTP attempt: caching, logging, custom headers. The first one added is the
    /// outermost.
    pub fn middleware(mut self, middleware: impl Middleware + 'static) -> Self {
        self.middleware.push(middleware);
        self
    }

    /// Sends the requests. Defaults to hyper over rustls, or native-tls with the
    /// `native-tls` feature.
    pub fn http_client(mut self, http_client: Arc<dyn HttpClient>) -> Self {
        self.http_client = Some(http_client);
        self
    }

    /// Sends requests through `connector`, e.g. a `hyper_rustls::HttpsConnector` with its
    /// own `rustls::ClientConfig`, for custom TLS roots, client certificates or a proxy.
    pub fn connector<C>(self, connector: C) -> Self
    where
        C: Connect + Clone + Send + Sync + 'static,
    {
        self.http_client(super::http_client(connector))
    }

    /// Called before each request for a fresh bearer token, e.g. a short-lived access token.
    /// Takes precedence over the token.
    pub fn token_provider(mut self, provider: super::TokenProvider) -> Self {
        self.token_provider = Some(provider);
        self
    }

    /// The client.
    ///
    /// # Errors
    ///
    /// Fails with [`Error::Request`] when the base URL is not an absolute URL.
    pub fn build(self) -> Result<Meteroid, Error> {
        let env = |name| {
            std::env::var(name)
                .ok()
                .filter(|value: &String| !value.is_empty())
        };
        let base_path = self
            .base_url
            .or_else(|| env(BASE_URL_ENV))
            .or_else(|| DEFAULT_BASE_URL.map(str::to_owned))
            .ok_or_else(|| {
                invalid(format!(
                    "no base URL: call `base_url()` on the builder or set `{BASE_URL_ENV}`"
                ))
            })?;
        let absolute = base_path.parse::<http::Uri>().ok().is_some_and(|uri| {
            uri.authority().is_some() && matches!(uri.scheme_str(), Some("http" | "https"))
        });
        if !absolute {
            return Err(invalid(format!(
                "the base URL `{base_path}` is not an absolute http(s) URL"
            )));
        }
        let cfg = Arc::new(Configuration {
            user_agent: Some(format!("meteroid-rust/{CRATE_VERSION}")),
            client: self
                .http_client
                .unwrap_or_else(|| super::http_client(crate::make_connector())),
            timeout: self.timeout,
            base_path,
            bearer_access_token: self.token.or_else(|| env(API_KEY_ENV)),
            max_retries: self.max_retries.unwrap_or(2),
            middleware: self.middleware.0,
            headers: self.headers,
            credentials: Credentials {
                schemes: SECURITY_SCHEMES,
                security: DEFAULT_SECURITY,
                token_provider: self.token_provider,
                oauth: None,
                basic_auth: self.basic_auth,
                api_keys: self.api_keys,
            },
        });
        Ok(Meteroid { cfg })
    }
}

fn invalid(message: String) -> Error {
    Error::generic(Failure::Request(message.into()))
}

impl Default for MeteroidBuilder {
    fn default() -> Self {
        Self {
            token: None,
            base_url: None,
            timeout: Some(Duration::from_secs(60)),
            max_retries: None,
            headers: Vec::new(),
            middleware: Middlewares::default(),
            http_client: None,
            token_provider: None,
            basic_auth: None,
            api_keys: std::collections::HashMap::new(),
        }
    }
}

impl fmt::Debug for MeteroidBuilder {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.debug_struct("MeteroidBuilder")
            .field("base_url", &self.base_url)
            .field("timeout", &self.timeout)
            .field("max_retries", &self.max_retries)
            .finish_non_exhaustive()
    }
}

#[cfg(test)]
mod tests {
    use super::Meteroid;

    #[test]
    fn test_client_send_sync() {
        fn require_send_sync<T: Send + Sync>() {}

        require_send_sync::<Meteroid>();
    }
}

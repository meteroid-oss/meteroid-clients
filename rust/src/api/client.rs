//! Meteroid API client.

use std::{sync::Arc, time::Duration};

use hyper_util::{client::legacy::Client as HyperClient, rt::TokioExecutor};

use crate::Configuration;

const CRATE_VERSION: &str = env!("CARGO_PKG_VERSION");

/// Options for configuring the Meteroid client.
#[derive(Debug, Clone)]
pub struct MeteroidOptions {
    /// Enable debug logging.
    pub debug: bool,

    /// Custom server URL. Defaults to `https://api.meteroid.com`.
    pub server_url: Option<String>,

    /// Timeout for HTTP requests.
    ///
    /// The timeout is applied from when the request starts connecting until
    /// the response body has finished. If set to `None`, requests never time
    /// out.
    ///
    /// Default: 15 seconds.
    pub timeout: Option<Duration>,

    /// Number of retries.
    ///
    /// The number of times the client will retry if a server-side error
    /// or timeout is received.
    ///
    /// Default: 2
    pub num_retries: Option<u32>,

    /// Retry Schedule.
    ///
    /// List of delays to wait before each retry attempt.
    /// Takes precedence over `num_retries`.
    pub retry_schedule: Option<Vec<Duration>>,
}

impl Default for MeteroidOptions {
    fn default() -> Self {
        Self {
            debug: false,
            server_url: None,
            timeout: Some(Duration::from_secs(15)),
            num_retries: None,
            retry_schedule: None,
        }
    }
}

/// Meteroid API client.
///
/// This is the main entry point for interacting with the Meteroid API.
///
/// # Example
///
/// ```no_run
/// use meteroid::api::{Meteroid, MeteroidOptions};
///
/// # async fn example() -> Result<(), meteroid::error::Error> {
/// let client = Meteroid::new("your-api-key".to_string(), None);
///
/// // Access API resources
/// let customers = client.customers().list_customers(None).await?;
/// # Ok(())
/// # }
/// ```
#[derive(Clone)]
pub struct Meteroid {
    pub(super) cfg: Arc<Configuration>,
}

impl Meteroid {
    /// Create a new Meteroid client with the given API key.
    ///
    /// # Arguments
    ///
    /// * `token` - Your Meteroid API key
    /// * `options` - Optional configuration options
    pub fn new(token: String, options: Option<MeteroidOptions>) -> Self {
        let options = options.unwrap_or_default();

        let cfg = Arc::new(Configuration {
            user_agent: Some(format!("meteroid-rust/{CRATE_VERSION}")),
            client: HyperClient::builder(TokioExecutor::new()).build(crate::make_connector()),
            timeout: options.timeout,
            base_path: options
                .server_url
                .unwrap_or_else(|| "https://api.meteroid.com".to_string()),
            bearer_access_token: Some(token),
            num_retries: options.num_retries.unwrap_or(2),
            retry_schedule: options.retry_schedule,
        });

        Self { cfg }
    }

    /// Creates a new `Meteroid` API client with a different token,
    /// re-using all of the settings and the Hyper client from
    /// an existing `Meteroid` instance.
    ///
    /// This can be used to change the token without incurring
    /// the cost of TLS initialization.
    pub fn with_token(&self, token: String) -> Self {
        let cfg = Arc::new(Configuration {
            base_path: self.cfg.base_path.clone(),
            user_agent: self.cfg.user_agent.clone(),
            bearer_access_token: Some(token),
            client: self.cfg.client.clone(),
            timeout: self.cfg.timeout,
            num_retries: self.cfg.num_retries,
            retry_schedule: self.cfg.retry_schedule.clone(),
        });

        Self { cfg }
    }

    // Resource accessors - these are generated based on the API

    /// Access the checkout sessions API.
    pub fn checkout_sessions(&self) -> super::CheckoutSessions<'_> {
        super::CheckoutSessions::new(&self.cfg)
    }

    /// Access the credit notes API.
    pub fn credit_notes(&self) -> super::CreditNotes<'_> {
        super::CreditNotes::new(&self.cfg)
    }

    /// Access the customers API.
    pub fn customers(&self) -> super::Customers<'_> {
        super::Customers::new(&self.cfg)
    }

    /// Access the events API.
    pub fn events(&self) -> super::Events<'_> {
        super::Events::new(&self.cfg)
    }

    /// Access the invoices API.
    pub fn invoices(&self) -> super::Invoices<'_> {
        super::Invoices::new(&self.cfg)
    }

    /// Access the plans API.
    pub fn plans(&self) -> super::Plan<'_> {
        super::Plan::new(&self.cfg)
    }

    /// Access the product families API.
    pub fn product_families(&self) -> super::ProductFamily<'_> {
        super::ProductFamily::new(&self.cfg)
    }

    /// Access the subscriptions API.
    pub fn subscriptions(&self) -> super::Subscription<'_> {
        super::Subscription::new(&self.cfg)
    }
}

#[cfg(test)]
mod tests {
    use super::Meteroid;

    #[test]
    fn test_future_send_sync() {
        fn require_send_sync<T: Send + Sync>(_: T) {}

        let meteroid = Meteroid::new(String::new(), None);
        let customer_api = meteroid.customers();
        let fut = customer_api.list_customers(None);
        require_send_sync(fut);
    }
}

//! Configuration, entirely from the environment. Nothing here is ever hard-coded —
//! see `examples/.env.example` for the full list and `README.md` for how to set it.

use std::{env, time::Duration};

use meteroid_rs::{
    api::{Meteroid, MeteroidOptions},
    models::Currency,
};

/// Everything the backend needs to start. Read once, at boot.
#[derive(Clone, Debug)]
pub struct Config {
    /// Meteroid API key. May be empty: the process still starts so that
    /// `GET /api/health` can report `meteroid_configured: false` instead of the
    /// operator getting a silent crash.
    pub meteroid_api_key: String,
    pub meteroid_base_url: String,
    /// Signing secret of the Meteroid webhook endpoint (`whsec_…`). May be empty.
    pub meteroid_webhook_secret: String,
    /// HMAC key for demo session tokens. Not a Meteroid credential.
    pub session_secret: String,
    /// Currency new demo customers are created with. Must match the seeded plans.
    pub default_currency: Currency,
    pub port: u16,
}

/// A configuration problem the operator has to fix. Reported at startup, never to a client.
#[derive(Debug)]
pub struct ConfigError(pub String);

impl std::fmt::Display for ConfigError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.write_str(&self.0)
    }
}

impl std::error::Error for ConfigError {}

impl Config {
    pub fn from_env() -> Result<Self, ConfigError> {
        let meteroid_base_url = non_empty("METEROID_BASE_URL")
            .unwrap_or_else(|| "https://api.meteroid.com".to_string());

        // `PORT` is the convention every host uses; `SCRIBE_PORT` is what
        // examples/.env.example calls it. Accept both, `PORT` wins.
        let port = non_empty("PORT")
            .or_else(|| non_empty("SCRIBE_PORT"))
            .unwrap_or_else(|| "8080".to_string());
        let port: u16 = port.parse().map_err(|_| {
            ConfigError(format!(
                "PORT must be a number between 1 and 65535, got {port:?}"
            ))
        })?;

        let currency_code =
            non_empty("SCRIBE_DEFAULT_CURRENCY").unwrap_or_else(|| "USD".to_string());
        let default_currency = parse_currency(&currency_code)?;

        // The session secret has no safe default: a predictable one would let
        // anyone mint a token for any workspace. Refuse to start without it.
        let session_secret = non_empty("SCRIBE_SESSION_SECRET").ok_or_else(|| {
            ConfigError(
                "SCRIBE_SESSION_SECRET is not set. It is the HMAC key for demo session tokens; \
                 generate one with `openssl rand -hex 32`. See examples/.env.example."
                    .to_string(),
            )
        })?;

        Ok(Self {
            meteroid_api_key: non_empty("METEROID_API_KEY").unwrap_or_default(),
            meteroid_base_url,
            meteroid_webhook_secret: non_empty("METEROID_WEBHOOK_SECRET").unwrap_or_default(),
            session_secret,
            default_currency,
            port,
        })
    }

    /// True when the backend has enough credentials to reach Meteroid at all.
    pub fn meteroid_configured(&self) -> bool {
        !self.meteroid_api_key.is_empty() && !self.meteroid_base_url.is_empty()
    }

    /// Build the Meteroid SDK client. One client is shared by every handler: it
    /// owns a connection pool, so cloning it per request would be wasteful.
    pub fn meteroid_client(&self) -> Meteroid {
        Meteroid::new(
            self.meteroid_api_key.clone(),
            Some(MeteroidOptions {
                server_url: Some(self.meteroid_base_url.clone()),
                timeout: Some(Duration::from_secs(15)),
                ..MeteroidOptions::default()
            }),
        )
    }
}

fn non_empty(key: &str) -> Option<String> {
    env::var(key)
        .ok()
        .map(|v| v.trim().to_string())
        .filter(|v| !v.is_empty())
}

/// `Currency` is a closed enum in the SDK with no `FromStr`, so the only way in
/// from a configuration string is its `Deserialize` impl.
fn parse_currency(code: &str) -> Result<Currency, ConfigError> {
    serde_json::from_value(serde_json::Value::String(code.to_uppercase())).map_err(|_| {
        ConfigError(format!(
            "SCRIBE_DEFAULT_CURRENCY={code:?} is not an ISO 4217 code Meteroid recognizes."
        ))
    })
}

//! Demo session tokens.
//!
//! There is no real user auth in this demo — that is not what it teaches. A session
//! token is a stateless HMAC over the Meteroid customer alias:
//!
//! ```text
//! v1.<base64url(alias)>.<base64url(hmac_sha256(SCRIBE_SESSION_SECRET, alias))>
//! ```
//!
//! Stateless and deterministic means every backend that shares the secret mints and
//! accepts the same tokens, so one contract-suite session works against all of them.
//! The Meteroid API key never leaves the backend.

use axum::{extract::FromRequestParts, http::request::Parts};
use base64::{engine::general_purpose::URL_SAFE_NO_PAD, Engine as _};
use hmac::{Hmac, Mac};
use sha2::Sha256;

use crate::{
    error::{ApiError, ApiResult},
    state::AppState,
};

type HmacSha256 = Hmac<Sha256>;

pub fn mint(secret: &str, alias: &str) -> String {
    format!(
        "v1.{}.{}",
        URL_SAFE_NO_PAD.encode(alias),
        URL_SAFE_NO_PAD.encode(sign(secret, alias))
    )
}

/// Returns the customer alias the token is bound to, or an error the caller turns
/// into `401 UNAUTHORIZED`.
pub fn verify(secret: &str, token: &str) -> Result<String, &'static str> {
    let mut parts = token.splitn(3, '.');
    match (parts.next(), parts.next(), parts.next()) {
        (Some("v1"), Some(alias_b64), Some(sig_b64)) => {
            let alias = URL_SAFE_NO_PAD
                .decode(alias_b64)
                .ok()
                .and_then(|bytes| String::from_utf8(bytes).ok())
                .ok_or("Session token payload is not valid base64url UTF-8.")?;
            let signature = URL_SAFE_NO_PAD
                .decode(sig_b64)
                .map_err(|_| "Session token signature is not valid base64url.")?;

            // Constant-time comparison — `Mac::verify_slice` does it for us.
            let mut mac = HmacSha256::new_from_slice(secret.as_bytes())
                .expect("HMAC accepts a key of any length");
            mac.update(alias.as_bytes());
            mac.verify_slice(&signature)
                .map_err(|_| "Session token was not signed by this deployment.")?;

            Ok(alias)
        }
        _ => Err("Session token is malformed; expected `v1.<payload>.<signature>`."),
    }
}

fn sign(secret: &str, alias: &str) -> Vec<u8> {
    let mut mac =
        HmacSha256::new_from_slice(secret.as_bytes()).expect("HMAC accepts a key of any length");
    mac.update(alias.as_bytes());
    mac.finalize().into_bytes().to_vec()
}

/// Axum extractor: put `Session` in a handler's arguments and the route requires a
/// valid `Authorization: Bearer <session_token>` header.
#[derive(Clone, Debug)]
pub struct Session {
    /// The Meteroid customer alias this workspace maps onto. Every Meteroid call
    /// in this backend passes it where an `id_or_alias` is accepted.
    pub customer_alias: String,
}

impl FromRequestParts<AppState> for Session {
    type Rejection = ApiError;

    async fn from_request_parts(parts: &mut Parts, state: &AppState) -> ApiResult<Self> {
        let token = parts
            .headers
            .get(axum::http::header::AUTHORIZATION)
            .and_then(|value| value.to_str().ok())
            .and_then(|value| value.strip_prefix("Bearer "))
            .map(str::trim)
            .filter(|value| !value.is_empty())
            .ok_or_else(|| {
                ApiError::unauthorized("Missing Authorization: Bearer <session_token> header.")
            })?;

        let customer_alias =
            verify(&state.config.session_secret, token).map_err(ApiError::unauthorized)?;

        Ok(Self { customer_alias })
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn round_trips_an_alias() {
        let token = mint("s3cret", "scribe-demo-8f2a1c");
        assert_eq!(verify("s3cret", &token).unwrap(), "scribe-demo-8f2a1c");
    }

    #[test]
    fn rejects_another_deployments_secret() {
        let token = mint("s3cret", "scribe-demo-8f2a1c");
        assert!(verify("other", &token).is_err());
    }

    #[test]
    fn rejects_a_tampered_payload() {
        let token = mint("s3cret", "scribe-demo-8f2a1c");
        let forged = format!(
            "v1.{}.{}",
            URL_SAFE_NO_PAD.encode("someone-else"),
            token.rsplit('.').next().unwrap()
        );
        assert!(verify("s3cret", &forged).is_err());
    }
}

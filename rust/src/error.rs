//! Error types for the Meteroid SDK.

use std::fmt;

use http_body_util::BodyExt;
use hyper::body::{Bytes, Incoming};

use crate::models::{ErrorCode, OAuthErrorResponse, RestErrorResponse};

pub type Result<T> = std::result::Result<T, Error>;

/// The error type returned from the Meteroid API.
///
/// For a non-2xx response, the body is parsed as a [`RestErrorResponse`] first
/// ([`Error::Http`] with `payload: Some(..)`), then as an [`OAuthErrorResponse`]
/// ([`Error::OAuth`]). If it matches neither, the result is [`Error::Http`] with
/// `payload: None`. The HTTP status and the raw body are always available,
/// whatever the status code.
///
/// The typed parse is strict: a body carrying an error code this version of the
/// SDK doesn't know (e.g. a new [`ErrorCode`] variant added server-side) does not
/// parse, and only the status and raw body are available.
#[derive(Debug, Clone)]
pub enum Error {
    /// A generic error (transport, timeout, (de)serialization of a successful response, ...).
    Generic(String),
    /// A non-2xx response. `payload` is the parsed [`RestErrorResponse`], or `None`
    /// when the body matched none of the API's error schemas.
    Http(HttpErrorContent<RestErrorResponse>),
    /// A non-2xx response whose body is an OAuth 2.0 error (RFC 6749 §5.2).
    OAuth(HttpErrorContent<OAuthErrorResponse>),
}

impl Error {
    pub(crate) fn generic(err: impl std::error::Error) -> Self {
        Self::Generic(format!("{err:?}"))
    }

    pub(crate) async fn from_response(status_code: http1::StatusCode, body: Incoming) -> Self {
        match body.collect().await {
            Ok(collected) => Self::from_body(status_code, collected.to_bytes()),
            Err(e) => Self::Generic(e.to_string()),
        }
    }

    fn from_body(status: http1::StatusCode, raw_body: Bytes) -> Self {
        if let Ok(payload) = serde_json::from_slice::<RestErrorResponse>(&raw_body) {
            return Self::Http(HttpErrorContent {
                status,
                payload: Some(payload),
                raw_body,
            });
        }
        if let Ok(payload) = serde_json::from_slice::<OAuthErrorResponse>(&raw_body) {
            return Self::OAuth(HttpErrorContent {
                status,
                payload: Some(payload),
                raw_body,
            });
        }
        Self::Http(HttpErrorContent {
            status,
            payload: None,
            raw_body,
        })
    }

    /// The HTTP status of the response, if the error came from one.
    pub fn status(&self) -> Option<http1::StatusCode> {
        match self {
            Error::Generic(_) => None,
            Error::Http(e) => Some(e.status),
            Error::OAuth(e) => Some(e.status),
        }
    }

    /// The API error code, if the body parsed as a [`RestErrorResponse`].
    pub fn code(&self) -> Option<ErrorCode> {
        match self {
            Error::Http(HttpErrorContent {
                payload: Some(p), ..
            }) => Some(p.code),
            _ => None,
        }
    }

    /// The API error message, if the body parsed as a [`RestErrorResponse`].
    pub fn message(&self) -> Option<&str> {
        match self {
            Error::Http(HttpErrorContent {
                payload: Some(p), ..
            }) => Some(&p.message),
            _ => None,
        }
    }
}

impl From<Error> for String {
    fn from(err: Error) -> Self {
        err.to_string()
    }
}

impl fmt::Display for Error {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        match self {
            Error::Generic(s) => s.fmt(f),
            Error::Http(e) => match &e.payload {
                Some(p) => write!(
                    f,
                    "Http error (status={}) {}: {}",
                    e.status, p.code, p.message
                ),
                None => write!(
                    f,
                    "Http error (status={}) body={}",
                    e.status,
                    e.body_as_str()
                ),
            },
            Error::OAuth(e) => match &e.payload {
                Some(p) => {
                    write!(f, "OAuth error (status={}) {}", e.status, p.error)?;
                    if let Some(d) = &p.error_description {
                        write!(f, ": {d}")?;
                    }
                    Ok(())
                }
                None => write!(
                    f,
                    "OAuth error (status={}) body={}",
                    e.status,
                    e.body_as_str()
                ),
            },
        }
    }
}

impl std::error::Error for Error {}

#[derive(Clone)]
pub struct HttpErrorContent<T> {
    pub status: http1::StatusCode,
    /// Parsed payload if the body matched the expected error schema. `None`
    /// when the server returned a body in a different shape (or with an error
    /// code unknown to this SDK version); inspect [`Self::raw_body`] in that case.
    pub payload: Option<T>,
    /// Raw response body, always captured so debugging is possible even when
    /// the server's error format doesn't match the SDK's expected schema.
    pub raw_body: Bytes,
}

impl<T> HttpErrorContent<T> {
    /// Lossy UTF-8 view of the raw response body, for logging.
    pub fn body_as_str(&self) -> std::borrow::Cow<'_, str> {
        String::from_utf8_lossy(&self.raw_body)
    }
}

impl<T: fmt::Debug> fmt::Debug for HttpErrorContent<T> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.debug_struct("HttpErrorContent")
            .field("status", &self.status)
            .field("payload", &self.payload)
            .field("raw_body", &self.body_as_str())
            .finish()
    }
}

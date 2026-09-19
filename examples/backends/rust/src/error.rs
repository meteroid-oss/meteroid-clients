//! The single error envelope of `examples/openapi.yaml`.
//!
//! Every non-2xx response in this backend is an [`ApiError`]. `quota` and
//! `upgrade_plan_code` are always serialized, `null` where they do not apply, so
//! a strict client never has to tell an absent key from a null one.

use axum::{
    http::StatusCode,
    response::{IntoResponse, Response},
    Json,
};
use serde::Serialize;

use crate::dto::{PlanCode, QuotaSnapshot};

#[derive(Clone, Copy, Debug, Serialize, PartialEq, Eq)]
#[serde(rename_all = "SCREAMING_SNAKE_CASE")]
pub enum ErrorCode {
    BadRequest,
    Unauthorized,
    NotFound,
    #[allow(dead_code)] // Reserved by the contract; no operation requires a subscription.
    NoSubscription,
    FeatureNotEntitled,
    QuotaExhausted,
    CheckoutUnavailable,
    CatalogNotSeeded,
    WebhookSignatureInvalid,
    UpstreamUnauthorized,
    UpstreamError,
    RateLimited,
    Internal,
}

impl ErrorCode {
    fn status(self) -> StatusCode {
        match self {
            Self::BadRequest | Self::WebhookSignatureInvalid => StatusCode::BAD_REQUEST,
            Self::Unauthorized => StatusCode::UNAUTHORIZED,
            Self::NotFound => StatusCode::NOT_FOUND,
            Self::NoSubscription | Self::CheckoutUnavailable => StatusCode::CONFLICT,
            Self::QuotaExhausted => StatusCode::PAYMENT_REQUIRED,
            Self::FeatureNotEntitled => StatusCode::FORBIDDEN,
            Self::CatalogNotSeeded => StatusCode::SERVICE_UNAVAILABLE,
            Self::UpstreamUnauthorized | Self::UpstreamError => StatusCode::BAD_GATEWAY,
            Self::RateLimited => StatusCode::TOO_MANY_REQUESTS,
            Self::Internal => StatusCode::INTERNAL_SERVER_ERROR,
        }
    }
}

#[derive(Debug, Serialize)]
pub struct ApiError {
    pub code: ErrorCode,
    pub message: String,
    /// Boxed only to keep `ApiError` small: it travels in the `Err` arm of every
    /// handler's `Result`, and a seven-field quota snapshot inline would make every
    /// one of those `Result`s pay for the rare error case. Serializes identically.
    pub quota: Option<Box<QuotaSnapshot>>,
    pub upgrade_plan_code: Option<PlanCode>,
}

impl ApiError {
    pub fn new(code: ErrorCode, message: impl Into<String>) -> Self {
        Self {
            code,
            message: message.into(),
            quota: None,
            upgrade_plan_code: None,
        }
    }

    pub fn with_quota(mut self, quota: QuotaSnapshot) -> Self {
        self.quota = Some(Box::new(quota));
        self
    }

    pub fn with_upgrade(mut self, plan: Option<PlanCode>) -> Self {
        self.upgrade_plan_code = plan;
        self
    }

    pub fn bad_request(message: impl Into<String>) -> Self {
        Self::new(ErrorCode::BadRequest, message)
    }

    pub fn unauthorized(message: impl Into<String>) -> Self {
        Self::new(ErrorCode::Unauthorized, message)
    }

    pub fn catalog_not_seeded(message: impl Into<String>) -> Self {
        Self::new(ErrorCode::CatalogNotSeeded, message)
    }

    pub fn internal(message: impl Into<String>) -> Self {
        Self::new(ErrorCode::Internal, message)
    }
}

impl std::fmt::Display for ApiError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:?}: {}", self.code, self.message)
    }
}

impl IntoResponse for ApiError {
    fn into_response(self) -> Response {
        if self.code == ErrorCode::Internal {
            tracing::error!(message = %self.message, "internal error");
        }
        (self.code.status(), Json(self)).into_response()
    }
}

pub type ApiResult<T> = Result<T, ApiError>;

/// Translate an SDK failure into this contract's envelope.
///
/// The SDK reports the upstream status through [`meteroid_rs::error::Error::status`],
/// which is what separates "your API key is wrong" (an operator problem) from
/// "Meteroid is throttling" (retry) from everything else. When the body parsed as
/// Meteroid's error envelope, `code()` and `message()` carry the typed detail.
pub fn upstream(context: &str, err: meteroid_rs::error::Error) -> ApiError {
    use meteroid_rs::error::Error;

    let Some(status) = err.status() else {
        return ApiError::new(
            ErrorCode::UpstreamError,
            format!("Could not reach Meteroid for {context}: {err}"),
        );
    };

    match status {
        StatusCode::UNAUTHORIZED | StatusCode::FORBIDDEN => ApiError::new(
            ErrorCode::UpstreamUnauthorized,
            format!(
                "Meteroid rejected the API key on {context} (HTTP {status}). Check METEROID_API_KEY."
            ),
        ),
        StatusCode::TOO_MANY_REQUESTS => ApiError::new(
            ErrorCode::RateLimited,
            format!("Meteroid responded 429 to {context}. Retry shortly."),
        ),
        _ => {
            let detail = match (&err, err.code(), err.message()) {
                (_, Some(code), Some(message)) => format!("{code}: {message}"),
                (Error::Http(http), ..) => http.body_as_str().into_owned(),
                (Error::OAuth(oauth), ..) => oauth.body_as_str().into_owned(),
                (Error::Generic(msg), ..) => msg.clone(),
            };
            ApiError::new(
                ErrorCode::UpstreamError,
                format!(
                    "Meteroid responded {status} to {context}: {}",
                    truncate(&detail)
                ),
            )
        }
    }
}

/// True when the SDK error is an upstream 404 — "this object does not exist",
/// which for a catalog lookup means "not seeded" rather than "Meteroid is broken".
pub fn is_not_found(err: &meteroid_rs::error::Error) -> bool {
    err.status() == Some(StatusCode::NOT_FOUND)
}

fn truncate(body: &str) -> String {
    const MAX: usize = 300;
    match body.char_indices().nth(MAX) {
        None => body.to_string(),
        Some((idx, _)) => format!("{}…", &body[..idx]),
    }
}

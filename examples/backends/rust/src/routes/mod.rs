//! One module per group of operations in `examples/openapi.yaml`.
//!
//! Each handler is deliberately shaped the same way: parse and validate the request,
//! make **one obvious Meteroid SDK call**, then project the result onto the contract's
//! wire type. The SDK call is the line worth reading.

pub mod checkout;
pub mod entitlements;
pub mod health;
pub mod invoices;
pub mod plans;
pub mod portal;
pub mod session;
pub mod transcriptions;
pub mod usage;
pub mod webhooks;

use axum::{
    body::Bytes,
    extract::{rejection::QueryRejection, Query},
    http::StatusCode,
    response::{IntoResponse, Response},
    Json,
};
use serde::de::DeserializeOwned;

use crate::error::{ApiError, ApiResult};

/// Parse a **required** JSON request body into the contract's envelope on failure.
///
/// Axum's own `Json` rejection renders plain text, which would break the contract's
/// promise that every non-2xx response is an `Error` object — hence the explicit parse.
pub fn json_body<T: DeserializeOwned>(body: &Bytes) -> ApiResult<T> {
    if body.is_empty() {
        return Err(ApiError::bad_request("A JSON request body is required."));
    }
    serde_json::from_slice(body)
        .map_err(|err| ApiError::bad_request(format!("Invalid body: {err}")))
}

/// Parse an **optional** JSON request body.
///
/// The contract states that for these operations no body, an empty body, `{}` and
/// `{"field": null}` all mean the same thing: use the defaults. That rule is literally
/// this function.
pub fn optional_json_body<T: DeserializeOwned + Default>(body: &Bytes) -> ApiResult<T> {
    if body.iter().all(u8::is_ascii_whitespace) {
        return Ok(T::default());
    }
    serde_json::from_slice(body)
        .map_err(|err| ApiError::bad_request(format!("Invalid body: {err}")))
}

/// Same idea for the query string: keep the error envelope instead of axum's default.
pub fn query<T>(query: Result<Query<T>, QueryRejection>) -> ApiResult<T> {
    query
        .map(|Query(value)| value)
        .map_err(|err| ApiError::bad_request(err.body_text()))
}

/// `404` for an unmatched route, in the standard envelope. No operation in the
/// contract takes a path parameter, so this only ever fires on a typo.
pub async fn not_found() -> ApiError {
    ApiError::new(
        crate::error::ErrorCode::NotFound,
        "No such endpoint. See examples/openapi.yaml for the operations this demo serves.",
    )
}

/// `413` in the standard envelope. It keeps axum's status; `BAD_REQUEST` is the closest
/// code the contract has, and every backend answers an oversized body the same way.
pub async fn envelope_payload_too_large(response: Response) -> Response {
    if response.status() != StatusCode::PAYLOAD_TOO_LARGE {
        return response;
    }
    let mut enveloped =
        ApiError::bad_request("The request body exceeds the 2097152-byte limit.").into_response();
    *enveloped.status_mut() = StatusCode::PAYLOAD_TOO_LARGE;
    enveloped
}

/// Trim a string field and reject it when it is empty or too long.
pub fn bounded(field: &str, value: &str, max: usize) -> ApiResult<String> {
    let value = value.trim();
    if value.is_empty() {
        return Err(ApiError::bad_request(format!("{field} must not be empty.")));
    }
    if value.chars().count() > max {
        return Err(ApiError::bad_request(format!(
            "{field} must be at most {max} characters."
        )));
    }
    Ok(value.to_string())
}

/// Shorthand for the `(StatusCode, Json<T>)` pairs the handlers return.
pub type Created<T> = (axum::http::StatusCode, Json<T>);

pub fn created<T>(value: T) -> Created<T> {
    (axum::http::StatusCode::CREATED, Json(value))
}

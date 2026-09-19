//! `POST /api/portal-session` — mint a Meteroid customer-portal token.

use axum::{body::Bytes, extract::State};
use meteroid_rs::models::CustomerPortalTokenRequest;

use crate::{
    dto::{CreatePortalSessionRequest, CreatePortalSessionResponse},
    error::{upstream, ApiError, ApiResult},
    routes::{created, optional_json_body, Created},
    session::Session,
    state::AppState,
};

/// Meteroid's default lifetime, in seconds.
const DEFAULT_EXPIRY: i32 = 86_400;
const MIN_EXPIRY: i32 = 60;
const MAX_EXPIRY: i32 = 2_592_000;

/// The portal is where the visitor manages their payment method and downloads invoices,
/// so the demo does not have to implement any of it. The frontend opens `portal_url`
/// with the `token`.
pub async fn create_portal_session(
    State(state): State<AppState>,
    session: Session,
    body: Bytes,
) -> ApiResult<Created<CreatePortalSessionResponse>> {
    let request: CreatePortalSessionRequest = optional_json_body(&body)?;

    // Meteroid documents 60..2592000 but types the field as a plain int32, so the range
    // is validated here rather than forwarding a value Meteroid would reject.
    let expires_in_seconds = request.expires_in_seconds.unwrap_or(DEFAULT_EXPIRY);
    if !(MIN_EXPIRY..=MAX_EXPIRY).contains(&expires_in_seconds) {
        return Err(ApiError::bad_request(format!(
            "expires_in_seconds must be between {MIN_EXPIRY} and {MAX_EXPIRY}."
        )));
    }

    let portal = state
        .meteroid
        .customers()
        .create_portal_token(
            session.customer_alias.clone(),
            CustomerPortalTokenRequest {
                expires_in_seconds: Some(expires_in_seconds),
            },
        )
        .await
        .map_err(|err| {
            upstream(
                &format!(
                    "POST /api/v1/customers/{}/portal-token",
                    session.customer_alias
                ),
                err,
            )
        })?;

    Ok(created(CreatePortalSessionResponse {
        portal_url: portal.portal_url,
        token: portal.token,
        // Meteroid returns only `{ token, portal_url }`, so this echoes what was asked
        // for rather than pretending to read it back out of the JWT.
        expires_in_seconds,
    }))
}

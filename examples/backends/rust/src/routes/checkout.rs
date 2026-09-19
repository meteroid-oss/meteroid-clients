//! `POST /api/checkout` — start a hosted Meteroid checkout for a plan.

use axum::{body::Bytes, extract::State};
use meteroid_rs::models::CreateCheckoutSessionRequest;

use crate::{
    dto::{CreateCheckoutRequest, CreateCheckoutResponse},
    error::{upstream, ApiError, ApiResult, ErrorCode},
    routes::{bounded, created, json_body, Created},
    session::Session,
    state::AppState,
};

/// Used both for the first subscription and for upgrades — Meteroid decides which by
/// looking at what the customer already has, and reports it back as `checkout_type`.
pub async fn create_checkout(
    State(state): State<AppState>,
    session: Session,
    body: Bytes,
) -> ApiResult<Created<CreateCheckoutResponse>> {
    let request: CreateCheckoutRequest = json_body(&body)?;
    let coupon_code = match &request.coupon_code {
        Some(code) => Some(bounded("coupon_code", code, 64)?),
        None => None,
    };

    // Which plan version to check out against comes from the seeded catalog; if the
    // plan is missing this fails with CATALOG_NOT_SEEDED naming the plan.
    let catalog = state.catalog().await?;
    let plan = catalog.plan(request.plan_code);

    let response = state
        .meteroid
        .checkout_sessions()
        .create_checkout_session(CreateCheckoutSessionRequest {
            // `customer_id` takes a Meteroid id *or* an external alias.
            customer_id: session.customer_alias.clone(),
            plan_version_id: plan.plan_version_id.clone(),
            coupon_code,
            ..Default::default()
        })
        .await
        .map_err(|err| upstream("POST /api/v1/checkout-sessions", err))?;

    let checkout = response.session;

    // Meteroid may legitimately return a session with no hosted URL (non-self-serve
    // checkout types). That is unusable for this demo, so it becomes an explicit error
    // rather than a null the frontend has to guess about.
    let checkout_url = checkout.checkout_url.ok_or_else(|| {
        ApiError::new(
            ErrorCode::CheckoutUnavailable,
            format!(
                "Meteroid returned a checkout session without a hosted URL \
                 (checkout_type={}).",
                checkout.checkout_type
            ),
        )
    })?;

    Ok(created(CreateCheckoutResponse {
        checkout_url,
        checkout_session_id: checkout.id,
        plan_code: request.plan_code,
        plan_version_id: checkout.plan_version_id,
        expires_at: checkout.expires_at,
    }))
}

//! `GET /api/entitlements` — the normalized entitlement view the SPA gates on.

use axum::{extract::State, Json};

use crate::{
    dto::EntitlementListResponse, entitlements, error::ApiResult, session::Session, state::AppState,
};

/// One Meteroid call, then a straight projection. The list may legitimately be empty
/// for a workspace that has never subscribed and has no feature-level defaults — that
/// is not an error, and it is why the demo checks the *features* exist at startup
/// instead of inferring "unseeded tenant" from an empty list here.
pub async fn list_entitlements(
    State(state): State<AppState>,
    session: Session,
) -> ApiResult<Json<EntitlementListResponse>> {
    let effective = entitlements::fetch(&state, &session.customer_alias).await?;

    let mut normalized = Vec::with_capacity(effective.len());
    for entitlement in effective {
        normalized.push(entitlements::normalize(&state, entitlement).await);
    }

    Ok(Json(EntitlementListResponse {
        entitlements: normalized,
    }))
}

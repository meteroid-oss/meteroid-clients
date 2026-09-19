//! `GET /api/plans` — the pricing table, straight from the seeded Meteroid catalog.

use axum::{extract::State, Json};

use crate::{dto::PlanListResponse, error::ApiResult, state::AppState};

/// Unauthenticated: the pricing page is public.
///
/// All the work happens in [`crate::catalog`], which resolves each plan by its exact
/// seeded name, flattens its price components and turns the plan version's entitlements
/// into marketing bullets. The result is cached for the life of the process.
pub async fn list_plans(State(state): State<AppState>) -> ApiResult<Json<PlanListResponse>> {
    let catalog = state.catalog().await?;

    Ok(Json(PlanListResponse {
        plans: catalog
            .plans
            .iter()
            .map(|resolved| resolved.plan.clone())
            .collect(),
    }))
}

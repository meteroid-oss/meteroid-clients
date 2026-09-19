//! `GET /api/health` — unauthenticated liveness and configuration probe.

use axum::{extract::State, Json};

use crate::{dto::Health, state::AppState};

pub async fn get_health(State(state): State<AppState>) -> Json<Health> {
    Json(Health {
        status: "ok",
        backend: "rust",
        // False means METEROID_API_KEY (or the base URL) is missing, and every
        // Meteroid-backed operation below will fail with UPSTREAM_UNAUTHORIZED.
        // Reporting it here is what turns a wall of 502s into one clear message.
        meteroid_configured: state.config.meteroid_configured(),
        version: Some(env!("CARGO_PKG_VERSION").to_string()),
    })
}

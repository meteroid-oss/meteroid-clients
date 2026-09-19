//! Scribe — the Rust reference backend for the Meteroid SDK demo.
//!
//! Implements every operation of `examples/openapi.yaml` on top of `meteroid-rs`.
//! Read the handlers in `src/routes/`; each one is written so that the Meteroid SDK
//! call is the line worth reading, and everything around it is framing.
//!
//! Start here:
//!
//! * `routes/transcriptions.rs` — the metered action: check the entitlement, then
//!   report the consumption. This is what the demo exists to show.
//! * `entitlements.rs` — normalizing Meteroid's three-way entitlement union.
//! * `catalog.rs` — resolving a catalog the demo never creates.
//! * `routes/webhooks.rs` — verifying a Standard Webhooks signature over raw bytes.

mod catalog;
mod config;
#[cfg(test)]
mod contract_samples;
mod dto;
mod entitlements;
mod error;
mod routes;
mod session;
mod state;
#[cfg(test)]
mod tests;
mod workspace;

use std::net::{Ipv4Addr, SocketAddr};

use axum::{
    routing::{get, post},
    Router,
};
use tower_http::{cors::CorsLayer, trace::TraceLayer};

use crate::{config::Config, state::AppState};

#[tokio::main]
async fn main() {
    tracing_subscriber::fmt()
        .with_env_filter(
            tracing_subscriber::EnvFilter::try_from_default_env()
                .unwrap_or_else(|_| "scribe_backend=info,tower_http=warn".into()),
        )
        .init();

    // A configuration error is the operator's to fix and there is nothing useful to
    // serve without it, so say what is wrong and stop.
    let config = match Config::from_env() {
        Ok(config) => config,
        Err(err) => {
            tracing::error!("{err}");
            std::process::exit(1);
        }
    };

    let port = config.port;
    if !config.meteroid_configured() {
        tracing::warn!(
            "METEROID_API_KEY is not set. The server will start and GET /api/health will \
             report meteroid_configured=false, but every Meteroid-backed operation will fail. \
             See examples/.env.example."
        );
    }

    let state = AppState::new(config);
    let app = router(state.clone());
    let addr = SocketAddr::from((Ipv4Addr::UNSPECIFIED, port));
    let listener = match tokio::net::TcpListener::bind(addr).await {
        Ok(listener) => listener,
        Err(err) => {
            tracing::error!("Cannot bind {addr}: {err}");
            std::process::exit(1);
        }
    };

    // Probe the catalog in the background rather than before binding: an unreachable
    // Meteroid would otherwise hold the port closed for the length of the SDK's retry
    // schedule, and `GET /api/health` is exactly what you want answering during that.
    tokio::spawn(async move { probe_catalog(&state).await });

    tracing::info!("Scribe (rust) listening on http://localhost:{port}");
    if let Err(err) = axum::serve(listener, app)
        .with_graceful_shutdown(shutdown_signal())
        .await
    {
        tracing::error!("Server error: {err}");
        std::process::exit(1);
    }
}

fn router(state: AppState) -> Router {
    Router::new()
        .route("/api/health", get(routes::health::get_health))
        .route("/api/session", post(routes::session::create_session))
        .route("/api/me", get(routes::session::get_me))
        .route("/api/plans", get(routes::plans::list_plans))
        .route("/api/checkout", post(routes::checkout::create_checkout))
        .route(
            "/api/entitlements",
            get(routes::entitlements::list_entitlements),
        )
        .route(
            "/api/transcriptions",
            get(routes::transcriptions::list_transcriptions)
                .post(routes::transcriptions::create_transcription),
        )
        .route("/api/usage", get(routes::usage::get_usage))
        .route(
            "/api/portal-session",
            post(routes::portal::create_portal_session),
        )
        .route("/api/invoices", get(routes::invoices::list_invoices))
        .route(
            "/api/webhooks/meteroid",
            post(routes::webhooks::receive_webhook),
        )
        // A 404 still arrives in the contract's error envelope.
        .fallback(routes::not_found)
        // axum rejects an oversized body before any handler runs, in plain text. The
        // contract says every error is the envelope, so that one rejection is rewritten.
        .layer(axum::middleware::map_response(
            routes::envelope_payload_too_large,
        ))
        // The SPA is served from its own origin (the Vite dev server), so it needs CORS.
        // Permissive is fine for a demo; a real backend would name its origins.
        .layer(CorsLayer::permissive())
        .layer(TraceLayer::new_for_http())
        .with_state(state)
}

/// Resolve the seeded catalog once at boot.
///
/// This is not a hard requirement to start — the process stays up so that
/// `GET /api/health` answers and so that seeding the tenant fixes things without a
/// restart — but it turns "my first transcription says I'm not entitled" into an
/// unmissable startup error naming the object that is missing.
async fn probe_catalog(state: &AppState) {
    if !state.config.meteroid_configured() {
        return;
    }
    match state.catalog().await {
        Ok(catalog) => tracing::info!(
            "Meteroid catalog resolved: {} plans ({}).",
            catalog.plans.len(),
            catalog
                .plans
                .iter()
                .map(|resolved| resolved.plan.name.as_str())
                .collect::<Vec<_>>()
                .join(", ")
        ),
        Err(err) => tracing::error!(
            "Meteroid catalog is not usable yet: {}\n\
             The demo never creates catalog objects — seed them once, by hand, as described in \
             examples/CATALOG.md. Requests that need the catalog will keep returning \
             503 CATALOG_NOT_SEEDED until it is there.",
            err
        ),
    }
}

async fn shutdown_signal() {
    let _ = tokio::signal::ctrl_c().await;
    tracing::info!("Shutting down.");
}

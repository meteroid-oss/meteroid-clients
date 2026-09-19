//! `POST /api/session` and `GET /api/me` — the demo workspace and what it is subscribed to.

use axum::{body::Bytes, extract::State, Json};
use meteroid_rs::models::CustomerCreateRequest;
use uuid::Uuid;

use crate::{
    dto::{CreateSessionRequest, CreateSessionResponse, MeResponse, Subscription},
    error::{upstream, ApiResult},
    routes::{bounded, created, optional_json_body, Created},
    session::{self, Session},
    state::AppState,
    workspace,
};

/// Create a brand-new Meteroid customer and hand back a session token bound to it.
///
/// This is the only object the demo ever creates in Meteroid. The catalog is seeded
/// once, by hand (`examples/CATALOG.md`); customers are per demo run and disposable.
pub async fn create_session(
    State(state): State<AppState>,
    body: Bytes,
) -> ApiResult<Created<CreateSessionResponse>> {
    let request: CreateSessionRequest = optional_json_body(&body)?;

    // A short random alias is the workspace's identity everywhere: it is what the
    // session token carries, what ingested events reference, and what every
    // `id_or_alias` path parameter below receives.
    let alias = format!("scribe-demo-{}", Uuid::new_v4().simple());
    let name = match &request.workspace_name {
        Some(name) => bounded("workspace_name", name, 120)?,
        None => "Scribe demo workspace".to_string(),
    };
    let email = match &request.email {
        Some(email) => bounded("email", email, 254)?,
        None => format!("{alias}@example.invalid"),
    };

    let customer = state
        .meteroid
        .customers()
        .create_customer(CustomerCreateRequest {
            alias: Some(alias.clone()),
            // Meteroid requires all four of these. The currency must match the seeded
            // plans' currency or checkout will refuse the plan version later on.
            currency: state.config.default_currency,
            custom_taxes: Vec::new(),
            invoicing_emails: vec![email],
            name,
            ..Default::default()
        })
        .await
        .map_err(|err| upstream("POST /api/v1/customers", err))?;

    Ok(created(CreateSessionResponse {
        session_token: session::mint(&state.config.session_secret, &alias),
        workspace: workspace::to_workspace(customer, &alias),
    }))
}

/// The current workspace, its subscription, and the plan that subscription is on.
pub async fn get_me(
    State(state): State<AppState>,
    session: Session,
) -> ApiResult<Json<MeResponse>> {
    let alias = &session.customer_alias;

    let customer = workspace::load_customer(&state, alias).await?;
    let subscription = workspace::current_subscription(&state, alias).await?;

    // The plan is only looked up when there is a subscription to look it up for, so a
    // never-subscribed workspace works even before the catalog is reachable.
    let (subscription, plan) = match subscription {
        None => (None, None),
        Some(subscription) => {
            let catalog = state.catalog().await?;
            let plan_code = catalog.plan_code_for(&subscription.plan_id, &subscription.plan_name);
            let plan = plan_code.map(|code| catalog.plan(code).clone());
            (Some(project(subscription, plan_code)), plan)
        }
    };

    Ok(Json(MeResponse {
        workspace: workspace::to_workspace(customer, alias),
        subscription,
        plan,
    }))
}

/// Every field is a 1:1 projection of a Meteroid field — nothing is derived, so the
/// demo's view and Meteroid's can never drift. In particular `trial_duration_days` is
/// Meteroid's `trial_duration`, not a computed trial end date.
fn project(
    subscription: meteroid_rs::models::Subscription,
    plan_code: Option<crate::dto::PlanCode>,
) -> Subscription {
    Subscription {
        id: subscription.id,
        status: subscription.status.to_string(),
        plan_code,
        plan_name: subscription.plan_name,
        plan_version_id: subscription.plan_version_id,
        currency: subscription.currency.to_string(),
        current_period_start: subscription.current_period_start,
        current_period_end: subscription.current_period_end,
        trial_duration_days: subscription.trial_duration,
        created_at: subscription.created_at,
    }
}

//! Per-workspace Meteroid lookups shared by several handlers.
//!
//! A "workspace" is one Meteroid **customer**. The demo addresses it everywhere by its
//! *alias* (`scribe-demo-…`), never by the Meteroid id: every Meteroid endpoint the demo
//! touches accepts `id_or_alias`, which is the point being demonstrated — you can drive
//! Meteroid entirely from your own identifiers.

use meteroid_rs::{
    api::SubscriptionsListSubscriptionsOptions,
    models::{Customer, Subscription, SubscriptionStatusEnum},
};

use crate::{
    dto::{self, PlanCode},
    error::{upstream, ApiResult},
    state::AppState,
};

/// Statuses that count as "the subscription this workspace is living on right now".
const LIVE_STATUSES: [SubscriptionStatusEnum; 2] = [
    SubscriptionStatusEnum::Active,
    SubscriptionStatusEnum::TrialActive,
];

pub async fn load_customer(state: &AppState, alias: &str) -> ApiResult<Customer> {
    state
        .meteroid
        .customers()
        .get_customer(alias.to_string())
        .await
        .map_err(|err| upstream(&format!("GET /api/v1/customers/{alias}"), err))
}

/// The workspace's most relevant subscription, or `None` if it has never checked out.
///
/// The contract pins the rule down so every backend picks the same one: ask Meteroid
/// for the customer's subscriptions newest-first, take the first `ACTIVE` or
/// `TRIAL_ACTIVE` one, and otherwise the most recently created regardless of status.
pub async fn current_subscription(
    state: &AppState,
    alias: &str,
) -> ApiResult<Option<Subscription>> {
    // `customer_id` accepts a Meteroid id *or* an external alias, so no id lookup first.
    let response = state
        .meteroid
        .subscriptions()
        .list_subscriptions(Some(SubscriptionsListSubscriptionsOptions {
            customer_id: Some(alias.to_string()),
            order_by: Some("created_at.desc".to_string()),
            per_page: Some(100),
            ..Default::default()
        }))
        .await
        .map_err(|err| upstream("GET /api/v1/subscriptions", err))?;

    let subscriptions = response.data;
    let live = subscriptions
        .iter()
        .position(|subscription| LIVE_STATUSES.contains(&subscription.status));

    Ok(match live {
        Some(index) => subscriptions.into_iter().nth(index),
        None => subscriptions.into_iter().next(),
    })
}

/// Project a Meteroid customer onto the contract's `Workspace`.
///
/// Note there is no `created_at`: Meteroid's `Customer` carries no creation timestamp,
/// so the contract does not pretend it does.
pub fn to_workspace(customer: Customer, fallback_alias: &str) -> dto::Workspace {
    let alias = customer
        .alias
        .clone()
        .unwrap_or_else(|| fallback_alias.to_string());

    dto::Workspace {
        id: alias.clone(),
        name: customer.name,
        customer_id: customer.id,
        customer_alias: alias,
        currency: customer.currency.to_string(),
    }
}

/// The plan to offer when a workspace hits a wall (`402` / `403`).
///
/// One plan up from where it is now: `pro` for an unsubscribed workspace or one on a
/// plan outside the Scribe catalog, `scale` for a `pro` workspace, and `None` on
/// `scale` — there is nothing left to sell. Never fails: this decorates an error
/// response, and a failed lookup here must not replace the error the caller actually hit.
pub async fn upgrade_target(state: &AppState, alias: &str) -> Option<PlanCode> {
    let subscription = current_subscription(state, alias).await.ok().flatten();
    let Some(subscription) = subscription else {
        return Some(PlanCode::Pro);
    };

    let catalog = state.catalog().await.ok()?;
    match catalog.plan_code_for(&subscription.plan_id, &subscription.plan_name) {
        Some(current) => current.next_up(),
        None => Some(PlanCode::Pro),
    }
}

//! `GET /api/usage` — current-period usage, straight from Meteroid.

use axum::{extract::State, Json};
use chrono::{Datelike, NaiveDate, Utc};
use meteroid_rs::{api::UsageGetCustomerUsageOptions, models::UsageResponse as SdkUsageResponse};

use crate::{
    dto::{self, GroupedUsage, MetricUsage, UsageResponse},
    error::{upstream, ApiResult},
    session::Session,
    state::AppState,
    workspace,
};

/// Two Meteroid endpoints, chosen by whether the workspace has a subscription, and the
/// choice is reported back in `scope` so the frontend can label the period honestly.
pub async fn get_usage(
    State(state): State<AppState>,
    session: Session,
) -> ApiResult<Json<UsageResponse>> {
    let alias = &session.customer_alias;
    let subscription = workspace::current_subscription(&state, alias).await?;

    let (scope, usage) = match subscription {
        // Subscription scope: omitting start_date/end_date makes Meteroid use the
        // subscription's own billing period, so the numbers line up with the invoice.
        Some(subscription) => {
            let usage = state
                .meteroid
                .usage()
                .get_subscription_usage(subscription.id.clone(), None)
                .await
                .map_err(|err| {
                    upstream(
                        &format!("GET /api/v1/usage/subscription/{}", subscription.id),
                        err,
                    )
                })?;
            ("subscription", usage)
        }
        // Customer scope: this endpoint *requires* a date range, and with no
        // subscription there is no billing period to borrow. The demo supplies the
        // current UTC calendar month — a demo convention, not a billing period.
        None => {
            let (start, end) = current_calendar_month();
            let usage = state
                .meteroid
                .usage()
                .get_customer_usage(
                    alias.clone(),
                    UsageGetCustomerUsageOptions {
                        start_date: start,
                        end_date: end,
                        metric_id: None,
                    },
                )
                .await
                .map_err(|err| upstream(&format!("GET /api/v1/usage/customer/{alias}"), err))?;
            ("customer", usage)
        }
    };

    Ok(Json(project(scope, usage)))
}

fn project(scope: &'static str, usage: SdkUsageResponse) -> UsageResponse {
    UsageResponse {
        period_start: usage.period_start,
        period_end: usage.period_end,
        scope,
        metrics: usage
            .usage
            .into_iter()
            .map(|metric| MetricUsage {
                // Meteroid also returns `metric_id`; the demo drops it because
                // `metric_code` is the stable identifier application code uses.
                metric_code: metric.metric_code,
                metric_name: metric.metric_name,
                // Decimals stay strings all the way to the client.
                total_value: dto::decimal(metric.total_value),
                grouped_usage: metric
                    .grouped_usage
                    .into_iter()
                    .map(|group| GroupedUsage {
                        dimensions: group.dimensions,
                        value: dto::decimal(group.value),
                    })
                    .collect(),
            })
            .collect(),
    }
}

/// First of the current UTC month .. today, as `YYYY-MM-DD`.
fn current_calendar_month() -> (String, String) {
    let today = Utc::now().date_naive();
    let first = NaiveDate::from_ymd_opt(today.year(), today.month(), 1).unwrap_or(today);
    (first.to_string(), today.to_string())
}

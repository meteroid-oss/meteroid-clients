//! `GET /api/transcriptions` and `POST /api/transcriptions` — the metered action.
//!
//! `POST` is the centerpiece of the demo and the reason the whole thing exists:
//! **check the entitlement, then report the consumption.** Everything else is framing.

use axum::{body::Bytes, extract::State, Json};
use chrono::{SecondsFormat, Utc};
use meteroid_rs::models::{
    EffectiveEntitlementValue, Event, IngestEventsRequest, MeteredEffectiveEntitlementValue,
};
use rust_decimal::{Decimal, RoundingStrategy};
use uuid::Uuid;

use crate::{
    catalog::TRANSCRIPTION_MINUTES,
    dto::{
        self, CreateTranscriptionRequest, CreateTranscriptionResponse, QuotaSnapshot,
        Transcription, TranscriptionListResponse,
    },
    entitlements,
    error::{upstream, ApiError, ApiResult, ErrorCode},
    routes::{bounded, created, json_body, Created},
    session::Session,
    state::AppState,
    workspace,
};

/// Demo-local history, newest first. In memory: Meteroid is the source of truth for
/// *usage*, not for the application objects that produced it.
pub async fn list_transcriptions(
    State(state): State<AppState>,
    session: Session,
) -> Json<TranscriptionListResponse> {
    Json(TranscriptionListResponse {
        transcriptions: state.transcriptions.list(&session.customer_alias).await,
    })
}

pub async fn create_transcription(
    State(state): State<AppState>,
    session: Session,
    body: Bytes,
) -> ApiResult<Created<CreateTranscriptionResponse>> {
    let request: CreateTranscriptionRequest = json_body(&body)?;
    let title = bounded("title", &request.title, 200)?;
    if !(1..=7200).contains(&request.duration_seconds) {
        return Err(ApiError::bad_request(
            "duration_seconds must be between 1 and 7200.",
        ));
    }
    let minutes = billable_minutes(request.duration_seconds);
    let alias = &session.customer_alias;

    // ---- 1. Read the entitlement ------------------------------------------------
    let effective = entitlements::fetch(&state, alias).await?;
    let metered = find_metered(&state, alias, &effective).await?;
    let quota = entitlements::quota_snapshot(TRANSCRIPTION_MINUTES, &metered);

    // ---- 2. Gate ----------------------------------------------------------------
    // "Not granted" and "granted but used up" are different answers and get different
    // status codes, so the frontend can tell an upsell from a paywall.
    if !metered.spec.enabled {
        return Err(ApiError::new(
            ErrorCode::FeatureNotEntitled,
            format!("The {TRANSCRIPTION_MINUTES} entitlement is not enabled for this workspace."),
        )
        .with_upgrade(workspace::upgrade_target(&state, alias).await));
    }

    let remaining = entitlements::remaining_balance(
        metered.spec.limit,
        metered.usage.consumed,
        metered.usage.remaining,
    );
    // A null limit means unlimited and never trips this branch.
    if let Some(remaining) = remaining {
        if minutes > remaining {
            return Err(ApiError::new(
                ErrorCode::QuotaExhausted,
                format!(
                    "This request needs {} transcription minutes but only {} remain in the \
                     current period.",
                    dto::decimal(minutes),
                    dto::decimal(remaining)
                ),
            )
            .with_quota(quota)
            .with_upgrade(workspace::upgrade_target(&state, alias).await));
        }
    }

    // ---- 3. Do the work and report the consumption ------------------------------
    let id = format!("tr_{}", Uuid::new_v4().simple());
    let now = Utc::now().to_rfc3339_opts(SecondsFormat::Secs, true);

    let response = state
        .meteroid
        .events()
        .ingest_events(IngestEventsRequest::new(vec![Event {
            // The billable metric's code, seeded per examples/CATALOG.md.
            code: TRANSCRIPTION_MINUTES.to_string(),
            // Events accept the customer's *external alias*, so the demo never has to
            // carry Meteroid ids around.
            customer_id: alias.clone(),
            // Meteroid deduplicates on (event_id, customer_id). Reusing the
            // transcription's own id makes a retried ingest idempotent.
            event_id: id.clone(),
            // Aggregated by the metric's `aggregation_key`, as a decimal string.
            properties: Some([("minutes".to_string(), dto::decimal(minutes))].into()),
            // Must be within 24h ago .. 1h ahead unless `allow_backfilling` is set,
            // which this demo never does.
            timestamp: now.clone(),
        }]))
        .await
        .map_err(|err| upstream("POST /api/v1/events/ingest", err))?;

    // With `allow_partial_failures` unset, a bad event rejects the whole batch and the
    // call above already errored — but check anyway rather than silently losing usage.
    if let Some(failures) = response.failures.filter(|failures| !failures.is_empty()) {
        return Err(ApiError::new(
            ErrorCode::UpstreamError,
            format!("Meteroid rejected the usage event: {failures:?}"),
        ));
    }

    let transcription = Transcription {
        event_id: id.clone(),
        id,
        title,
        duration_seconds: request.duration_seconds,
        minutes_billed: dto::decimal(minutes),
        text: transcript(request.duration_seconds),
        created_at: now,
    };
    state
        .transcriptions
        .record(alias, transcription.clone())
        .await;

    Ok(created(CreateTranscriptionResponse {
        transcription,
        quota: project_quota(quota, minutes),
    }))
}

/// Find the metered `transcription_minutes` entitlement, or explain why there is none.
///
/// A *missing* entitlement is a 403: the workspace's plan does not grant the feature.
/// An entitlement of the *wrong type* is a seeding error — the feature exists but was
/// created as boolean or config in the dashboard — and gets `CATALOG_NOT_SEEDED`, so
/// an operator mistake never masquerades as a customer-facing paywall.
async fn find_metered(
    state: &AppState,
    alias: &str,
    effective: &[meteroid_rs::models::EffectiveEntitlement],
) -> ApiResult<MeteredEffectiveEntitlementValue> {
    let entitlement = effective
        .iter()
        .find(|entitlement| entitlement.feature.code == TRANSCRIPTION_MINUTES);

    match entitlement.map(|entitlement| &entitlement.value) {
        Some(EffectiveEntitlementValue::Metered(metered)) => Ok(metered.clone()),
        Some(_) => Err(ApiError::catalog_not_seeded(format!(
            "The feature \"{TRANSCRIPTION_MINUTES}\" exists but is not a metered feature. \
             Recreate it as metered in the Meteroid dashboard; see examples/CATALOG.md."
        ))),
        None => {
            let upgrade = workspace::upgrade_target(state, alias).await;
            Err(ApiError::new(
                ErrorCode::FeatureNotEntitled,
                format!(
                    "The {TRANSCRIPTION_MINUTES} entitlement is not enabled for this workspace."
                ),
            )
            .with_upgrade(upgrade))
        }
    }
}

/// `duration_seconds / 60`, rounded **up** to two decimals — the demo always bills at
/// least what it used. Exact decimal arithmetic: a binary float here is how a
/// 0.1-minute clip eventually bills wrong.
fn billable_minutes(duration_seconds: i32) -> Decimal {
    (Decimal::from(duration_seconds) / Decimal::from(60))
        .round_dp_with_strategy(2, RoundingStrategy::ToPositiveInfinity)
}

/// The backend's optimistic projection of the entitlement after this call: what it read
/// from Meteroid, minus the minutes it just billed. Meteroid's own counters are
/// eventually consistent, so `GET /api/usage` may briefly disagree — it is the
/// authority once it catches up.
fn project_quota(quota: QuotaSnapshot, minutes: Decimal) -> QuotaSnapshot {
    fn shift(value: &Option<String>, by: Decimal) -> Option<String> {
        value
            .as_deref()
            .and_then(|value| value.parse::<Decimal>().ok())
            .map(|value| dto::decimal(value + by))
    }

    QuotaSnapshot {
        consumed: shift(&quota.consumed, minutes).or(Some(dto::decimal(minutes))),
        remaining: shift(&quota.remaining, -minutes),
        ..quota
    }
}

/// The demo does no real speech recognition; it invents a transcript so the metered
/// path has something to return.
fn transcript(duration_seconds: i32) -> String {
    format!(
        "[demo transcript] This is simulated output for {duration_seconds} seconds of audio. \
         Scribe does no real speech recognition — the point of this endpoint is the \
         entitlement check and the usage event it reports to Meteroid."
    )
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn rounds_billable_minutes_up_to_two_decimals() {
        assert_eq!(dto::decimal(billable_minutes(60)), "1");
        assert_eq!(dto::decimal(billable_minutes(210)), "3.5");
        // 100/60 = 1.666… must never round down: the demo bills what it used.
        assert_eq!(dto::decimal(billable_minutes(100)), "1.67");
        assert_eq!(dto::decimal(billable_minutes(1)), "0.02");
    }

    #[test]
    fn projects_the_quota_forward() {
        let quota = QuotaSnapshot {
            feature_code: TRANSCRIPTION_MINUTES.to_string(),
            enabled: true,
            limit: Some("60".to_string()),
            consumed: Some("56.5".to_string()),
            remaining: Some("3.5".to_string()),
            reset_at: None,
            unlimited: false,
        };
        let projected = project_quota(quota, billable_minutes(60));
        assert_eq!(projected.consumed.as_deref(), Some("57.5"));
        assert_eq!(projected.remaining.as_deref(), Some("2.5"));
    }

    #[test]
    fn an_unlimited_quota_stays_unlimited() {
        let quota = QuotaSnapshot {
            feature_code: TRANSCRIPTION_MINUTES.to_string(),
            enabled: true,
            limit: None,
            consumed: None,
            remaining: None,
            reset_at: None,
            unlimited: true,
        };
        let projected = project_quota(quota, billable_minutes(120));
        assert!(projected.unlimited);
        assert_eq!(projected.limit, None);
        assert_eq!(projected.remaining, None);
        assert_eq!(projected.consumed.as_deref(), Some("2"));
    }
}

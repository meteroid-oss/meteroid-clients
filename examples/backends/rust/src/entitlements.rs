//! Turning Meteroid's effective entitlements into the contract's normalized view.
//!
//! This is the single most important piece of modelling in the demo, because it is
//! what both the UI gating and the server-side enforcement read.
//!
//! Meteroid's `EffectiveEntitlementValue` is a `oneOf` tagged on `type`
//! (`BOOLEAN` / `METERED` / `CONFIG`), with the metered variant split into a `spec`
//! (what the plan grants) and a `usage` (what has been consumed). The contract keeps
//! the tag, flattens spec+usage into one object, and keeps every decimal a string.

use meteroid_rs::models::{
    ConfigValue as SdkConfigValue, EffectiveEntitlement, EffectiveEntitlementValue,
    MeteredEffectiveEntitlementValue, ResetPeriod as SdkResetPeriod,
};
use rust_decimal::Decimal;

use crate::{
    dto::{self, ConfigValue, Entitlement, EntitlementValue, QuotaSnapshot, ResetPeriod},
    error::{upstream, ApiResult},
    state::AppState,
};

/// Read the workspace's effective entitlements from Meteroid.
///
/// One call, by customer alias. Meteroid merges feature defaults, plan-version
/// entitlements, product and add-on entitlements, and attaches live usage counters.
pub async fn fetch(state: &AppState, alias: &str) -> ApiResult<Vec<EffectiveEntitlement>> {
    let response = state
        .meteroid
        .customers()
        .get_effective_entitlements(alias.to_string())
        .await
        .map_err(|err| upstream(&format!("GET /api/v1/customers/{alias}/entitlements"), err))?;

    Ok(response.data)
}

/// Project one Meteroid entitlement onto the contract's tagged union.
pub async fn normalize(state: &AppState, entitlement: EffectiveEntitlement) -> Entitlement {
    let feature = entitlement.feature;

    let value = match entitlement.value {
        EffectiveEntitlementValue::Boolean(boolean) => EntitlementValue::Boolean {
            enabled: boolean.enabled,
        },
        EffectiveEntitlementValue::Metered(metered) => {
            // Meteroid names the metric behind an entitlement by id only. The code is
            // presentational (it lines this view up with `GET /api/usage`), so an
            // unresolvable id is a null rather than an error.
            let metric_code = state
                .metrics
                .code_for(&state.meteroid, &metered.spec.metric_id)
                .await;
            let quota = quota_snapshot(&feature.code, &metered);

            EntitlementValue::Metered {
                enabled: quota.enabled,
                limit: quota.limit,
                consumed: quota.consumed,
                remaining: quota.remaining,
                unlimited: quota.unlimited,
                reset_at: quota.reset_at,
                reset_period: reset_period(&metered.spec.reset_period),
                metric_code,
            }
        }
        EffectiveEntitlementValue::Config(config) => EntitlementValue::Config {
            value: config_value(config.value),
        },
    };

    Entitlement {
        feature_code: feature.code,
        feature_name: feature.name,
        value,
    }
}

/// The consumption state of a metered entitlement, as both the entitlement view and
/// the quota-exhausted error report it.
///
/// `remaining` is the number the quota check compares against, and Meteroid does not
/// always supply it: `MeteredEntitlementUsage` requires none of its properties, so an
/// entitlement whose counter has not been written yet arrives with `remaining` absent
/// but `limit` set. The contract therefore fixes the fallback — `limit - consumed`,
/// then `limit` — so that a limited entitlement always reports a balance and Rust and
/// Java can never disagree about it.
pub fn quota_snapshot(
    feature_code: &str,
    metered: &MeteredEffectiveEntitlementValue,
) -> QuotaSnapshot {
    let limit = metered.spec.limit;
    let consumed = metered.usage.consumed;
    let remaining = remaining_balance(limit, consumed, metered.usage.remaining);

    QuotaSnapshot {
        feature_code: feature_code.to_string(),
        enabled: metered.spec.enabled,
        limit: dto::decimal_opt(limit),
        consumed: dto::decimal_opt(consumed),
        remaining: dto::decimal_opt(remaining),
        reset_at: metered.usage.reset_at.clone(),
        // A null limit is Meteroid's way of saying "unlimited"; mirroring it as a
        // boolean saves every client the same null special-case.
        unlimited: limit.is_none(),
    }
}

/// Exact decimal arithmetic, never binary floating point — this is money.
pub fn remaining_balance(
    limit: Option<Decimal>,
    consumed: Option<Decimal>,
    reported: Option<Decimal>,
) -> Option<Decimal> {
    let limit = limit?;
    Some(reported.unwrap_or_else(|| limit - consumed.unwrap_or_default()))
}

/// Meteroid models the reset period as its own five-variant tagged union, but every
/// variant beyond the tag carries at most an `interval`+`unit` pair. The contract keeps
/// the tag and nullable fields rather than nesting a second union inside the first.
fn reset_period(period: &SdkResetPeriod) -> ResetPeriod {
    match period {
        SdkResetPeriod::BillingCycle(_) => ResetPeriod {
            kind: "BILLING_CYCLE",
            interval: None,
            unit: None,
        },
        SdkResetPeriod::Never(_) => ResetPeriod {
            kind: "NEVER",
            interval: None,
            unit: None,
        },
        SdkResetPeriod::Calendar(calendar) => ResetPeriod {
            kind: "CALENDAR",
            interval: Some(calendar.interval),
            unit: Some(calendar.unit.to_string()),
        },
        SdkResetPeriod::FixedWindow(window) => ResetPeriod {
            kind: "FIXED_WINDOW",
            interval: Some(window.interval),
            unit: Some(window.unit.to_string()),
        },
        SdkResetPeriod::SlidingWindow(window) => ResetPeriod {
            kind: "SLIDING_WINDOW",
            interval: Some(window.interval),
            unit: Some(window.unit.to_string()),
        },
    }
}

/// Meteroid's `ConfigValueType` also lists `MAP` and `SELECT`, but its `ConfigValue`
/// union carries only these four, which is exactly the set the contract exposes.
fn config_value(value: SdkConfigValue) -> ConfigValue {
    match value {
        // Numbers stay decimal strings: Meteroid types this `format: decimal`.
        SdkConfigValue::Number(number) => ConfigValue::Number(dto::decimal(number.value)),
        SdkConfigValue::Boolean(boolean) => ConfigValue::Boolean(boolean.value),
        SdkConfigValue::Text(text) => ConfigValue::Text(text.value),
        SdkConfigValue::Json(json) => ConfigValue::Json(json.value),
    }
}

#[cfg(test)]
mod tests {
    use meteroid_rs::models::{
        BillingCycleResetPeriod, MeteredEntitlementSpec, MeteredEntitlementUsage,
    };

    use super::*;

    fn metered(
        limit: Option<i64>,
        consumed: Option<i64>,
        remaining: Option<i64>,
    ) -> MeteredEffectiveEntitlementValue {
        MeteredEffectiveEntitlementValue {
            spec: MeteredEntitlementSpec {
                enabled: true,
                limit: limit.map(Decimal::from),
                metric_id: "met_1".to_string(),
                reset_period: SdkResetPeriod::BillingCycle(BillingCycleResetPeriod {}),
            },
            usage: MeteredEntitlementUsage {
                consumed: consumed.map(Decimal::from),
                remaining: remaining.map(Decimal::from),
                reset_at: None,
            },
        }
    }

    #[test]
    fn uses_meteroids_remaining_when_it_has_one() {
        let quota = quota_snapshot(
            "transcription_minutes",
            &metered(Some(60), Some(15), Some(45)),
        );
        assert_eq!(quota.remaining.as_deref(), Some("45"));
        assert!(!quota.unlimited);
    }

    #[test]
    fn derives_remaining_when_meteroid_has_no_counter() {
        let quota = quota_snapshot("transcription_minutes", &metered(Some(60), Some(15), None));
        assert_eq!(quota.remaining.as_deref(), Some("45"));

        let untouched = quota_snapshot("transcription_minutes", &metered(Some(60), None, None));
        assert_eq!(untouched.remaining.as_deref(), Some("60"));
    }

    #[test]
    fn an_absent_limit_is_unlimited() {
        let quota = quota_snapshot("transcription_minutes", &metered(None, Some(900), None));
        assert!(quota.unlimited);
        assert_eq!(quota.limit, None);
        assert_eq!(quota.remaining, None);
        assert_eq!(quota.consumed.as_deref(), Some("900"));
    }
}

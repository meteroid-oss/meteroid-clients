//! Catalog resolution.
//!
//! The demo **never creates catalog objects** — the operator seeds them once, by hand
//! (`examples/CATALOG.md`). Everything here is a lookup by a stable identifier, and
//! every failure becomes `503 CATALOG_NOT_SEEDED` naming exactly what was missing.
//!
//! Two things are resolved:
//!
//! * the four **features**, by code, which is what tells an unseeded tenant apart from
//!   a workspace that simply has no subscription (both show zero entitlements); and
//! * the three **plans**, by their exact seeded name, because Meteroid plans carry no
//!   user-supplied code.
//!
//! The result is cached for the life of the process once it succeeds. Failures are not
//! cached, so seeding the tenant while the backend runs fixes it without a restart.

use std::{collections::HashMap, sync::Arc};

use meteroid_rs::{
    api::{Meteroid, MetricsListMetricsOptions, PlansListPlansOptions},
    models::{
        ConfigValue, Fee, PlanStatusEnum, PlanTypeEnum, PlanUsagePricingModel, ResetPeriod,
        ResolvedEntitlementValue, TermRate,
    },
};
use rust_decimal::Decimal;
use tokio::sync::RwLock;

use crate::{
    dto::{self, PlanCode, PlanFeatureLine, PlanPrice},
    error::{is_not_found, upstream, ApiError, ApiResult},
};

/// The four feature codes this demo gates on. Seeded in the dashboard; GET-only over REST.
pub const FEATURE_CODES: [&str; 4] = ["transcription_minutes", "sso", "retention_days", "seats"];

/// The metered feature the transcription endpoint enforces, and the billable metric code
/// the ingested events carry.
pub const TRANSCRIPTION_MINUTES: &str = "transcription_minutes";

const SEED_HINT: &str = "Seed the catalog per examples/CATALOG.md.";

/// A plan resolved from Meteroid, ready to serve and to check out against.
#[derive(Clone, Debug)]
pub struct ResolvedPlan {
    pub plan: dto::Plan,
}

#[derive(Debug)]
pub struct Catalog {
    /// In `PlanCode::ALL` order — cheapest first.
    pub plans: Vec<ResolvedPlan>,
    /// Meteroid plan id → the demo's plan code, for labelling a subscription's plan.
    plan_codes_by_id: HashMap<String, PlanCode>,
}

impl Catalog {
    pub fn plan(&self, code: PlanCode) -> &dto::Plan {
        self.plans
            .iter()
            .map(|resolved| &resolved.plan)
            .find(|plan| plan.code == code)
            .expect("the catalog always holds every plan code once resolved")
    }

    /// Label a Meteroid subscription's plan. Matches on `plan_id` first — a dashboard
    /// rename then still resolves — and falls back to the exact seeded name.
    pub fn plan_code_for(&self, plan_id: &str, plan_name: &str) -> Option<PlanCode> {
        self.plan_codes_by_id.get(plan_id).copied().or_else(|| {
            PlanCode::ALL
                .into_iter()
                .find(|code| code.meteroid_plan_name() == plan_name)
        })
    }
}

/// Process-wide cache of the resolved catalog. Only successes are cached.
#[derive(Default)]
pub struct CatalogCache {
    resolved: RwLock<Option<Arc<Catalog>>>,
}

impl CatalogCache {
    pub async fn get(
        &self,
        client: &Meteroid,
        metrics: &MetricCache,
        expected_currency: &str,
    ) -> ApiResult<Arc<Catalog>> {
        if let Some(catalog) = self.resolved.read().await.clone() {
            return Ok(catalog);
        }

        let catalog = Arc::new(resolve(client, metrics, expected_currency).await?);
        *self.resolved.write().await = Some(catalog.clone());
        Ok(catalog)
    }
}

/// Meteroid identifies the metric behind a metered entitlement, and behind a
/// `USAGE`/`CAPACITY` price component, by **id** only. This maps ids back onto the codes
/// application code actually knows.
#[derive(Default)]
pub struct MetricCache {
    codes_by_id: RwLock<HashMap<String, String>>,
}

impl MetricCache {
    /// Load (or reload) the whole map. Cheap: one page covers any realistic demo tenant.
    pub async fn refresh(&self, client: &Meteroid) -> ApiResult<()> {
        let response = client
            .metrics()
            .list_metrics(Some(MetricsListMetricsOptions {
                per_page: Some(100),
                ..Default::default()
            }))
            .await
            .map_err(|err| upstream("GET /api/v1/metrics", err))?;

        let map = response
            .data
            .into_iter()
            .map(|metric| (metric.id, metric.code))
            .collect();
        *self.codes_by_id.write().await = map;
        Ok(())
    }

    /// Resolve one metric id, refreshing once on a miss so a metric seeded after startup
    /// still shows up. `None` is not fatal anywhere — the code is presentational.
    pub async fn code_for(&self, client: &Meteroid, metric_id: &str) -> Option<String> {
        if let Some(code) = self.codes_by_id.read().await.get(metric_id) {
            return Some(code.clone());
        }
        if self.refresh(client).await.is_err() {
            return None;
        }
        self.codes_by_id.read().await.get(metric_id).cloned()
    }

    async fn code_for_cached(&self, metric_id: &str) -> Option<String> {
        self.codes_by_id.read().await.get(metric_id).cloned()
    }
}

async fn resolve(
    client: &Meteroid,
    metrics: &MetricCache,
    expected_currency: &str,
) -> ApiResult<Catalog> {
    // 1. The four features must exist. This is the check that keeps an unseeded tenant
    //    from masquerading as "your plan doesn't include that" on the first transcription.
    for code in FEATURE_CODES {
        client
            .features()
            .get_feature(code.to_string())
            .await
            .map_err(|err| {
                if is_not_found(&err) {
                    ApiError::catalog_not_seeded(format!(
                        "No feature with code \"{code}\". Features cannot be created over the \
                         REST API; create it in the Meteroid dashboard. {SEED_HINT}"
                    ))
                } else {
                    upstream(&format!("GET /api/v1/features/{code}"), err)
                }
            })?;
    }

    // 2. metric id → code, used to name the unit of usage-priced components below.
    metrics.refresh(client).await?;

    // 3. The three plans, by exact seeded name.
    let mut plans = Vec::with_capacity(PlanCode::ALL.len());
    let mut plan_codes_by_id = HashMap::new();
    for code in PlanCode::ALL {
        let plan = resolve_plan(client, metrics, code, expected_currency).await?;
        plan_codes_by_id.insert(plan.plan.plan_id.clone(), code);
        plans.push(plan);
    }

    Ok(Catalog {
        plans,
        plan_codes_by_id,
    })
}

async fn resolve_plan(
    client: &Meteroid,
    metrics: &MetricCache,
    code: PlanCode,
    expected_currency: &str,
) -> ApiResult<ResolvedPlan> {
    let name = code.meteroid_plan_name();

    // `search` is a fuzzy name match — "Scribe" alone returns all three plans — so the
    // exact-name filter below is what actually pins the plan down.
    let found = client
        .plans()
        .list_plans(Some(PlansListPlansOptions {
            search: Some(name.to_string()),
            status: Some(vec![PlanStatusEnum::Active]),
            per_page: Some(100),
            ..Default::default()
        }))
        .await
        .map_err(|err| upstream("GET /api/v1/plans", err))?;

    let plan = found
        .data
        .into_iter()
        .find(|plan| plan.name == name)
        .ok_or_else(|| {
            ApiError::catalog_not_seeded(format!(
                "No published plan named \"{name}\" (plan_code={}). {SEED_HINT}",
                code.as_str()
            ))
        })?;

    // Meteroid refuses to check a customer out against a plan version in another
    // currency, so catching the mismatch here beats a confusing failure at checkout.
    if !plan.currency.eq_ignore_ascii_case(expected_currency) {
        return Err(ApiError::catalog_not_seeded(format!(
            "Plan \"{name}\" is priced in {} but SCRIBE_DEFAULT_CURRENCY is {expected_currency}; \
             Meteroid will not check out a customer against a plan in another currency.",
            plan.currency
        )));
    }

    // The marketing bullets come from the plan version's entitlements, so the pricing
    // page and the enforcement path cannot drift apart.
    let entitlements = client
        .plans()
        .list_plan_version_entitlements(plan.version_id.clone())
        .await
        .map_err(|err| {
            upstream(
                &format!("GET /api/v1/plan-versions/{}/entitlements", plan.version_id),
                err,
            )
        })?;

    let mut features = Vec::with_capacity(entitlements.data.len());
    for entitlement in entitlements.data {
        features.push(PlanFeatureLine {
            label: feature_label(&entitlement.feature.name, &entitlement.value),
            feature_code: entitlement.feature.code,
        });
    }

    let mut prices = Vec::new();
    for component in &plan.price_components {
        // A component with no fee has nothing to show, so it is dropped entirely.
        if let Some(fee) = &component.fee {
            prices.push(flatten_fee(metrics, &component.id, &component.name, fee).await);
        }
    }

    Ok(ResolvedPlan {
        plan: dto::Plan {
            code,
            name: plan.name,
            description: plan.description,
            plan_id: plan.id,
            plan_version_id: plan.version_id,
            version: plan.version,
            currency: plan.currency,
            is_free: plan.plan_type == PlanTypeEnum::Free,
            trial_days: plan.trial.map(|trial| trial.duration_days),
            prices,
            features,
        },
    })
}

/// Flatten one Meteroid price component into the display-oriented `PlanPrice` of the
/// contract. Deliberately lossy: this renders a pricing table, it does not reprice.
async fn flatten_fee(
    metrics: &MetricCache,
    component_id: &str,
    component_name: &str,
    fee: &Fee,
) -> PlanPrice {
    let mut price = PlanPrice {
        component_id: component_id.to_string(),
        name: component_name.to_string(),
        kind: "RATE",
        cadence: None,
        amount: None,
        unit_amount: None,
        included_amount: None,
        unit_name: None,
        pricing_model: None,
    };

    match fee {
        Fee::Rate(rate) => {
            price.kind = "RATE";
            if let Some(term) = pick_term(&rate.rates) {
                price.cadence = Some(term.term.to_string());
                price.amount = Some(dto::decimal(term.price));
            }
        }
        Fee::Slot(slot) => {
            price.kind = "SLOT";
            price.unit_name = Some(slot.slot_unit_name.clone());
            if let Some(term) = pick_term(&slot.rates) {
                price.cadence = Some(term.term.to_string());
                price.amount = Some(dto::decimal(term.price));
            }
        }
        Fee::Capacity(capacity) => {
            price.kind = "CAPACITY";
            price.cadence = Some(capacity.cadence.to_string());
            price.unit_name = metrics.code_for_cached(&capacity.metric_id).await;
            if let Some(threshold) = capacity.thresholds.first() {
                price.amount = Some(dto::decimal(threshold.price));
                price.unit_amount = Some(dto::decimal(threshold.per_unit_overage));
                price.included_amount =
                    Some(dto::decimal(Decimal::from(threshold.included_amount)));
            }
        }
        Fee::Usage(usage) => {
            price.kind = "USAGE";
            price.cadence = Some(usage.cadence.to_string());
            price.unit_name = metrics.code_for_cached(&usage.metric_id).await;
            price.pricing_model = Some(match &usage.pricing {
                PlanUsagePricingModel::PerUnit(_) => "PER_UNIT",
                PlanUsagePricingModel::Tiered(_) => "TIERED",
                PlanUsagePricingModel::Volume(_) => "VOLUME",
                PlanUsagePricingModel::Package(_) => "PACKAGE",
                PlanUsagePricingModel::Matrix(_) => "MATRIX",
            });
            // Only PER_UNIT has a single displayable unit price.
            if let PlanUsagePricingModel::PerUnit(per_unit) = &usage.pricing {
                price.unit_amount = Some(dto::decimal(per_unit.rate));
            }
        }
        Fee::ExtraRecurring(extra) => {
            price.kind = "EXTRA_RECURRING";
            price.cadence = Some(extra.cadence.to_string());
            price.amount = Some(dto::decimal(extra.unit_price));
        }
        Fee::OneTime(one_time) => {
            price.kind = "ONE_TIME";
            price.amount = Some(dto::decimal(one_time.unit_price));
        }
    }

    price
}

/// A `RATE` or `SLOT` fee prices one billing term each. The table shows one of them:
/// the monthly term when it exists (that is what the seeded catalog uses), else the
/// first. Meteroid's `Plan` carries no cadence of its own to match against.
fn pick_term(rates: &[TermRate]) -> Option<&TermRate> {
    rates
        .iter()
        .find(|rate| rate.term == meteroid_rs::models::BillingPeriodEnum::Monthly)
        .or_else(|| rates.first())
}

/// Render one plan-version entitlement as a marketing bullet.
fn feature_label(feature_name: &str, value: &ResolvedEntitlementValue) -> String {
    match value {
        ResolvedEntitlementValue::Boolean(boolean) => {
            if boolean.enabled {
                format!("{feature_name} included")
            } else {
                format!("{feature_name} not included")
            }
        }
        ResolvedEntitlementValue::Metered(metered) => {
            if !metered.enabled {
                return format!("{feature_name} not included");
            }
            match metered.limit {
                None => format!("Unlimited {}", lower_first(feature_name)),
                Some(limit) => format!(
                    "{} {}{}",
                    dto::decimal(limit),
                    lower_first(feature_name),
                    reset_suffix(&metered.reset_period)
                ),
            }
        }
        ResolvedEntitlementValue::Config(config) => match &config.value {
            ConfigValue::Number(number) => {
                format!(
                    "{} {}",
                    dto::decimal(number.value),
                    lower_first(feature_name)
                )
            }
            ConfigValue::Boolean(boolean) => {
                if boolean.value {
                    format!("{feature_name} included")
                } else {
                    format!("{feature_name} not included")
                }
            }
            ConfigValue::Text(text) => format!("{feature_name}: {}", text.value),
            ConfigValue::Json(_) => format!("{feature_name} configured"),
        },
    }
}

fn reset_suffix(reset_period: &ResetPeriod) -> String {
    match reset_period {
        ResetPeriod::BillingCycle(_) => " per billing cycle".to_string(),
        ResetPeriod::Never(_) => String::new(),
        ResetPeriod::Calendar(period) => format!(" per {}", interval(period.interval, period.unit)),
        ResetPeriod::FixedWindow(period) => {
            format!(" per {}", interval(period.interval, period.unit))
        }
        ResetPeriod::SlidingWindow(period) => {
            format!(" per rolling {}", interval(period.interval, period.unit))
        }
    }
}

fn interval(interval: i32, unit: meteroid_rs::models::CalendarUnit) -> String {
    let unit = unit.to_string().to_lowercase();
    if interval == 1 {
        unit
    } else {
        format!("{interval} {unit}s")
    }
}

fn lower_first(value: &str) -> String {
    let mut chars = value.chars();
    match chars.next() {
        None => String::new(),
        Some(first) => first.to_lowercase().collect::<String>() + chars.as_str(),
    }
}

#[cfg(test)]
mod tests {
    use meteroid_rs::models::{
        BillingCycleResetPeriod, BooleanResolvedEntitlementValue, MeteredResolvedEntitlementValue,
        NumberConfigValue,
    };

    use super::*;

    #[test]
    fn labels_a_metered_limit() {
        let value = ResolvedEntitlementValue::Metered(MeteredResolvedEntitlementValue {
            enabled: true,
            limit: Some(Decimal::from(600)),
            metric_id: "met_1".to_string(),
            reset_period: ResetPeriod::BillingCycle(BillingCycleResetPeriod {}),
        });
        assert_eq!(
            feature_label("Transcription minutes", &value),
            "600 transcription minutes per billing cycle"
        );
    }

    #[test]
    fn labels_an_unlimited_entitlement() {
        let value = ResolvedEntitlementValue::Metered(MeteredResolvedEntitlementValue {
            enabled: true,
            limit: None,
            metric_id: "met_1".to_string(),
            reset_period: ResetPeriod::BillingCycle(BillingCycleResetPeriod {}),
        });
        assert_eq!(
            feature_label("Transcription minutes", &value),
            "Unlimited transcription minutes"
        );
    }

    #[test]
    fn labels_boolean_and_config() {
        let sso =
            ResolvedEntitlementValue::Boolean(BooleanResolvedEntitlementValue { enabled: true });
        assert_eq!(feature_label("SSO", &sso), "SSO included");

        let retention =
            ResolvedEntitlementValue::Config(meteroid_rs::models::ConfigResolvedEntitlementValue {
                value: ConfigValue::Number(NumberConfigValue {
                    value: Decimal::from(90),
                }),
            });
        assert_eq!(
            feature_label("Retention days", &retention),
            "90 retention days"
        );
    }
}

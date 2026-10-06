// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billable_metric_id::BillableMetricId, billing_period_enum::BillingPeriodEnum,
    plan_usage_pricing_model::PlanUsagePricingModel,
};

/// Usage-based fee
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct UsagePlanFee {
    pub cadence: BillingPeriodEnum,

    pub metric_id: BillableMetricId,

    pub pricing: PlanUsagePricingModel,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UsagePlanFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        cadence: BillingPeriodEnum,
        metric_id: BillableMetricId,
        pricing: PlanUsagePricingModel,
    ) -> Self {
        Self {
            cadence,
            metric_id,
            pricing,
            extra: serde_json::Map::new(),
        }
    }
}

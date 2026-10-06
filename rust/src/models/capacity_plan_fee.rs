// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billable_metric_id::BillableMetricId, billing_period_enum::BillingPeriodEnum,
    capacity_threshold::CapacityThreshold,
};

/// Capacity-based fee with included committed usage and overage
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CapacityPlanFee {
    pub cadence: BillingPeriodEnum,

    pub metric_id: BillableMetricId,

    pub thresholds: Vec<CapacityThreshold>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CapacityPlanFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        cadence: BillingPeriodEnum,
        metric_id: BillableMetricId,
        thresholds: Vec<CapacityThreshold>,
    ) -> Self {
        Self {
            cadence,
            metric_id,
            thresholds,
            extra: serde_json::Map::new(),
        }
    }
}

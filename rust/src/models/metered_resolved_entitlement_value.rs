// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billable_metric_id::BillableMetricId, reset_period::ResetPeriod};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MeteredResolvedEntitlementValue {
    pub enabled: bool,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub limit: Option<rust_decimal::Decimal>,

    pub metric_id: BillableMetricId,

    pub reset_period: ResetPeriod,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MeteredResolvedEntitlementValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(enabled: bool, metric_id: BillableMetricId, reset_period: ResetPeriod) -> Self {
        Self {
            enabled,
            limit: None,
            metric_id,
            reset_period,
            extra: serde_json::Map::new(),
        }
    }
}

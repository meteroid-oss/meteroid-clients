// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billable_metric_id::BillableMetricId, grouped_usage::GroupedUsage};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MetricUsage {
    pub grouped_usage: Vec<GroupedUsage>,

    pub metric_code: String,

    pub metric_id: BillableMetricId,

    pub metric_name: String,

    pub total_value: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MetricUsage {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        grouped_usage: Vec<GroupedUsage>,
        metric_code: impl Into<String>,
        metric_id: BillableMetricId,
        metric_name: impl Into<String>,
        total_value: rust_decimal::Decimal,
    ) -> Self {
        Self {
            grouped_usage,
            metric_code: metric_code.into(),
            metric_id,
            metric_name: metric_name.into(),
            total_value,
            extra: serde_json::Map::new(),
        }
    }
}

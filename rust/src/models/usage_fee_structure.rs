// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billable_metric_id::BillableMetricId, usage_model_enum::UsageModelEnum};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct UsageFeeStructure {
    pub metric_id: BillableMetricId,

    pub model: UsageModelEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UsageFeeStructure {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(metric_id: BillableMetricId, model: UsageModelEnum) -> Self {
        Self {
            metric_id,
            model,
            extra: serde_json::Map::new(),
        }
    }
}

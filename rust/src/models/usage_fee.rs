// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billable_metric_id::BillableMetricId, usage_pricing_model::UsagePricingModel};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct UsageFee {
    pub metric_id: BillableMetricId,

    pub model: UsagePricingModel,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UsageFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(metric_id: BillableMetricId, model: UsagePricingModel) -> Self {
        Self {
            metric_id,
            model,
            extra: serde_json::Map::new(),
        }
    }
}

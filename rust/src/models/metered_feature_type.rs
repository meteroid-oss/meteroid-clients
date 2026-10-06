// this file is @generated
use serde::{Deserialize, Serialize};

use super::billable_metric_id::BillableMetricId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MeteredFeatureType {
    pub metric_id: BillableMetricId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MeteredFeatureType {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(metric_id: BillableMetricId) -> Self {
        Self {
            metric_id,
            extra: serde_json::Map::new(),
        }
    }
}

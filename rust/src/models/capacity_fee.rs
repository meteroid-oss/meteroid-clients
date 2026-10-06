// this file is @generated
use serde::{Deserialize, Serialize};

use super::billable_metric_id::BillableMetricId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CapacityFee {
    pub included: i64,

    pub metric_id: BillableMetricId,

    pub overage_rate: rust_decimal::Decimal,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CapacityFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        included: i64,
        metric_id: BillableMetricId,
        overage_rate: rust_decimal::Decimal,
        rate: rust_decimal::Decimal,
    ) -> Self {
        Self {
            included,
            metric_id,
            overage_rate,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}

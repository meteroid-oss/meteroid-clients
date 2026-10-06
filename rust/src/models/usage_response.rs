// this file is @generated
use serde::{Deserialize, Serialize};

use super::metric_usage::MetricUsage;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct UsageResponse {
    pub period_end: chrono::NaiveDate,

    pub period_start: chrono::NaiveDate,

    pub usage: Vec<MetricUsage>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UsageResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        period_end: chrono::NaiveDate,
        period_start: chrono::NaiveDate,
        usage: Vec<MetricUsage>,
    ) -> Self {
        Self {
            period_end,
            period_start,
            usage,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billable_metric_id::BillableMetricId, billing_metric_aggregate_enum::BillingMetricAggregateEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MetricSummary {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub aggregation_key: Option<String>,

    pub aggregation_type: BillingMetricAggregateEnum,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub archived_at: Option<chrono::DateTime<chrono::Utc>>,

    pub code: String,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub id: BillableMetricId,

    pub name: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MetricSummary {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        aggregation_type: BillingMetricAggregateEnum,
        code: impl Into<String>,
        created_at: chrono::DateTime<chrono::Utc>,
        id: BillableMetricId,
        name: impl Into<String>,
    ) -> Self {
        Self {
            aggregation_key: None,
            aggregation_type,
            archived_at: None,
            code: code.into(),
            created_at,
            description: None,
            id,
            name: name.into(),
            extra: serde_json::Map::new(),
        }
    }
}

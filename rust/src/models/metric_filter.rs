// this file is @generated
use serde::{Deserialize, Serialize};

use super::metric_filter_operator::MetricFilterOperator;

/// A pre-aggregation filter: only events whose `property` matches feed the metric's
/// aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple
/// filters are ANDed.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct MetricFilter {
    pub op: MetricFilterOperator,

    pub property: String,

    pub values: Vec<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MetricFilter {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(op: MetricFilterOperator, property: impl Into<String>, values: Vec<String>) -> Self {
        Self {
            op,
            property: property.into(),
            values,
            extra: serde_json::Map::new(),
        }
    }
}

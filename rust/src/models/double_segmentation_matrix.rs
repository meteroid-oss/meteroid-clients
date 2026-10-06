// this file is @generated
use serde::{Deserialize, Serialize};

use super::metric_dimension::MetricDimension;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct DoubleSegmentationMatrix {
    pub dimension1: MetricDimension,

    pub dimension2: MetricDimension,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl DoubleSegmentationMatrix {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(dimension1: MetricDimension, dimension2: MetricDimension) -> Self {
        Self {
            dimension1,
            dimension2,
            extra: serde_json::Map::new(),
        }
    }
}

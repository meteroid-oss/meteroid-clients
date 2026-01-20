// this file is @generated
use serde::{Deserialize, Serialize};

use super::metric_dimension::MetricDimension;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "discriminator")]
pub enum MetricSegmentationMatrix {
    #[serde(rename = "SINGLE")]
    Single(MetricDimension),
    #[serde(rename = "DOUBLE")]
    Double {
        dimension1: MetricDimension,
        dimension2: MetricDimension,
    },
    #[serde(rename = "LINKED")]
    Linked {
        dimension1_key: String,
        dimension2_key: String,
        values: std::collections::HashMap<String, Vec<String>>,
    },
}

impl Default for MetricSegmentationMatrix {
    fn default() -> Self {
        Self::Single(MetricDimension::default())
    }
}

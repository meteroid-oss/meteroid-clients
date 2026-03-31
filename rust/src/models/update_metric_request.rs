// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    metric_segmentation_matrix::MetricSegmentationMatrix, unit_conversion::UnitConversion,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct UpdateMetricRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub segmentation_matrix: Option<MetricSegmentationMatrix>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub unit_conversion: Option<UnitConversion>,
}

impl UpdateMetricRequest {
    pub fn new() -> Self {
        Self {
            description: None,
            name: None,
            segmentation_matrix: None,
            unit_conversion: None,
        }
    }
}

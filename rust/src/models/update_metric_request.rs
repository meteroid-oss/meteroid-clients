// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    metric_filter::MetricFilter, metric_segmentation_matrix::MetricSegmentationMatrix,
    unit_conversion::UnitConversion,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct UpdateMetricRequest {
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub description: Option<Option<String>>,

    /// Absent = leave filters untouched; present (even empty) = replace them.
    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub filters: Option<Option<Vec<MetricFilter>>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub name: Option<Option<String>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub segmentation_matrix: Option<Option<MetricSegmentationMatrix>>,

    #[serde(
        default,
        skip_serializing_if = "Option::is_none",
        deserialize_with = "crate::models::codec::nullable"
    )]
    pub unit_conversion: Option<Option<UnitConversion>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UpdateMetricRequest {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            description: None,
            filters: None,
            name: None,
            segmentation_matrix: None,
            unit_conversion: None,
            extra: serde_json::Map::new(),
        }
    }
}

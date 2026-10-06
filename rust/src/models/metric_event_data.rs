// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    billable_metric_id::BillableMetricId,
    billing_metric_aggregate_enum::BillingMetricAggregateEnum,
    metric_segmentation_matrix::MetricSegmentationMatrix, product_family_id::ProductFamilyId,
    product_id::ProductId, unit_conversion_rounding_enum::UnitConversionRoundingEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MetricEventData {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub aggregation_key: Option<String>,

    pub aggregation_type: BillingMetricAggregateEnum,

    pub code: String,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub metric_id: BillableMetricId,

    pub name: String,

    pub product_family_id: ProductFamilyId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product_id: Option<ProductId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub segmentation_matrix: Option<MetricSegmentationMatrix>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub unit_conversion_factor: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub unit_conversion_rounding: Option<UnitConversionRoundingEnum>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub usage_group_key: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MetricEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        aggregation_type: BillingMetricAggregateEnum,
        code: impl Into<String>,
        created_at: chrono::DateTime<chrono::Utc>,
        metric_id: BillableMetricId,
        name: impl Into<String>,
        product_family_id: ProductFamilyId,
    ) -> Self {
        Self {
            aggregation_key: None,
            aggregation_type,
            code: code.into(),
            created_at,
            description: None,
            metric_id,
            name: name.into(),
            product_family_id,
            product_id: None,
            segmentation_matrix: None,
            unit_conversion_factor: None,
            unit_conversion_rounding: None,
            usage_group_key: None,
            extra: serde_json::Map::new(),
        }
    }
}

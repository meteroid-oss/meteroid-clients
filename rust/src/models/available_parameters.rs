// this file is @generated
use serde::{Deserialize, Serialize};

use super::billing_period_enum::BillingPeriodEnum;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct AvailableParameters {
    /// Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL")
    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_periods: Option<std::collections::HashMap<String, Vec<BillingPeriodEnum>>>,

    /// Map of component_id -> available capacity values
    #[serde(skip_serializing_if = "Option::is_none")]
    pub capacity_thresholds: Option<std::collections::HashMap<String, Vec<i64>>>,

    /// List of component_ids that support slot parametrization (initial slot count)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub slot_components: Option<Vec<String>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl AvailableParameters {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            billing_periods: None,
            capacity_thresholds: None,
            slot_components: None,
            extra: serde_json::Map::new(),
        }
    }
}

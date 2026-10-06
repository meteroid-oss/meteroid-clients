// this file is @generated
use serde::{Deserialize, Serialize};

use super::billing_period_enum::BillingPeriodEnum;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionAddOnParameterization {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_period: Option<BillingPeriodEnum>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub committed_capacity: Option<i64>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub initial_slot_count: Option<i32>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionAddOnParameterization {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            billing_period: None,
            committed_capacity: None,
            initial_slot_count: None,
            extra: serde_json::Map::new(),
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::tier_row::TierRow;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct VolumePlanPricing {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub block_size: Option<i64>,

    pub tiers: Vec<TierRow>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl VolumePlanPricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(tiers: Vec<TierRow>) -> Self {
        Self {
            block_size: None,
            tiers,
            extra: serde_json::Map::new(),
        }
    }
}

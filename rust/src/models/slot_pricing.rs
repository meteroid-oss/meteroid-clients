// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct SlotPricing {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_slots: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub min_slots: Option<i32>,

    pub unit_rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SlotPricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(unit_rate: rust_decimal::Decimal) -> Self {
        Self {
            max_slots: None,
            min_slots: None,
            unit_rate,
            extra: serde_json::Map::new(),
        }
    }
}

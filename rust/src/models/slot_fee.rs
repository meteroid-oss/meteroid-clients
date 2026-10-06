// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct SlotFee {
    pub initial_slots: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_slots: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub min_slots: Option<i32>,

    pub unit: String,

    pub unit_rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SlotFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        initial_slots: i32,
        unit: impl Into<String>,
        unit_rate: rust_decimal::Decimal,
    ) -> Self {
        Self {
            initial_slots,
            max_slots: None,
            min_slots: None,
            unit: unit.into(),
            unit_rate,
            extra: serde_json::Map::new(),
        }
    }
}

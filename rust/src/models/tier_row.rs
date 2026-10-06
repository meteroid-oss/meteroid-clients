// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct TierRow {
    pub first_unit: i64,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub flat_cap: Option<rust_decimal::Decimal>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub flat_fee: Option<rust_decimal::Decimal>,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TierRow {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(first_unit: i64, rate: rust_decimal::Decimal) -> Self {
        Self {
            first_unit,
            flat_cap: None,
            flat_fee: None,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}

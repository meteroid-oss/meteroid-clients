// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct SubLineItem {
    pub id: String,

    pub name: String,

    pub quantity: rust_decimal::Decimal,

    pub total: i64,

    pub unit_price: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubLineItem {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        id: impl Into<String>,
        name: impl Into<String>,
        quantity: rust_decimal::Decimal,
        total: i64,
        unit_price: rust_decimal::Decimal,
    ) -> Self {
        Self {
            id: id.into(),
            name: name.into(),
            quantity,
            total,
            unit_price,
            extra: serde_json::Map::new(),
        }
    }
}

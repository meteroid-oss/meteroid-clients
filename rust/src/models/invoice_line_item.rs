// this file is @generated
use serde::{Deserialize, Serialize};

use super::sub_line_item::SubLineItem;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct InvoiceLineItem {
    pub amount_total: i64,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub end_date: chrono::NaiveDate,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub quantity: Option<rust_decimal::Decimal>,

    pub start_date: chrono::NaiveDate,

    pub sub_line_items: Vec<SubLineItem>,

    pub tax_rate: rust_decimal::Decimal,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub unit_price: Option<rust_decimal::Decimal>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl InvoiceLineItem {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        amount_total: i64,
        end_date: chrono::NaiveDate,
        name: impl Into<String>,
        start_date: chrono::NaiveDate,
        sub_line_items: Vec<SubLineItem>,
        tax_rate: rust_decimal::Decimal,
    ) -> Self {
        Self {
            amount_total,
            description: None,
            end_date,
            name: name.into(),
            quantity: None,
            start_date,
            sub_line_items,
            tax_rate,
            unit_price: None,
            extra: serde_json::Map::new(),
        }
    }
}

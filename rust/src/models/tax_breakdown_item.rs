// this file is @generated
use serde::{Deserialize, Serialize};

use super::tax_exemption_type::TaxExemptionType;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct TaxBreakdownItem {
    /// Free-text legal exemption mention (EU exempt/reverse-charge invoices).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub exemption_reason: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub exemption_type: Option<TaxExemptionType>,

    pub name: String,

    pub tax_amount: i64,

    pub tax_rate: rust_decimal::Decimal,

    /// Accounting/reporting code of the tax rate for this line, for exports.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub tax_reference: Option<String>,

    pub taxable_amount: i64,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TaxBreakdownItem {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        name: impl Into<String>,
        tax_amount: i64,
        tax_rate: rust_decimal::Decimal,
        taxable_amount: i64,
    ) -> Self {
        Self {
            exemption_reason: None,
            exemption_type: None,
            name: name.into(),
            tax_amount,
            tax_rate,
            tax_reference: None,
            taxable_amount,
            extra: serde_json::Map::new(),
        }
    }
}

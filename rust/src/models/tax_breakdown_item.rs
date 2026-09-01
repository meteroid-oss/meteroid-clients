// this file is @generated
use serde::{Deserialize, Serialize};

use super::tax_exemption_type::TaxExemptionType;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct TaxBreakdownItem {
    /// Free-text legal exemption mention (EU exempt/reverse-charge invoices).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub exemption_reason: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub exemption_type: Option<TaxExemptionType>,

    pub name: String,

    pub tax_amount: i32,

    pub tax_rate: rust_decimal::Decimal,

    /// Accounting/reporting code of the tax rate for this line, for exports.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub tax_reference: Option<String>,

    pub taxable_amount: i32,
}

impl TaxBreakdownItem {
    pub fn new(
        name: String,
        tax_amount: i32,
        tax_rate: rust_decimal::Decimal,
        taxable_amount: i32,
    ) -> Self {
        Self {
            exemption_reason: None,
            exemption_type: None,
            name,
            tax_amount,
            tax_rate,
            tax_reference: None,
            taxable_amount,
        }
    }
}

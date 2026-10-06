// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    credit_note_id::CreditNoteId, credit_note_status::CreditNoteStatus, customer_id::CustomerId,
    invoice_id::InvoiceId, invoice_line_item::InvoiceLineItem,
    tax_breakdown_item::TaxBreakdownItem,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CreditNoteEventData {
    pub created_at: chrono::DateTime<chrono::Utc>,

    pub credit_note_id: CreditNoteId,

    /// Absent while the credit note is a draft — the number is assigned at finalization.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub credit_note_number: Option<String>,

    pub credited_amount_cents: i64,

    pub currency: String,

    /// User-defined custom property values, keyed by definition key.
    pub custom_properties: serde_json::Value,

    pub customer_id: CustomerId,

    pub invoice_id: InvoiceId,

    /// Number of the invoice being credited.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_number: Option<String>,

    /// Credited line items (negated amounts).
    pub line_items: Vec<InvoiceLineItem>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub memo: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub reason: Option<String>,

    pub refunded_amount_cents: i64,

    pub status: CreditNoteStatus,

    pub subtotal: i64,

    pub tax_amount: i64,

    /// Per-rate tax (VAT) breakdown for the credited amount.
    pub tax_breakdown: Vec<TaxBreakdownItem>,

    pub total: i64,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreditNoteEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        credit_note_id: CreditNoteId,
        credited_amount_cents: i64,
        currency: impl Into<String>,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        invoice_id: InvoiceId,
        line_items: Vec<InvoiceLineItem>,
        refunded_amount_cents: i64,
        status: CreditNoteStatus,
        subtotal: i64,
        tax_amount: i64,
        tax_breakdown: Vec<TaxBreakdownItem>,
        total: i64,
    ) -> Self {
        Self {
            created_at,
            credit_note_id,
            credit_note_number: None,
            credited_amount_cents,
            currency: currency.into(),
            custom_properties,
            customer_id,
            invoice_id,
            invoice_number: None,
            line_items,
            memo: None,
            reason: None,
            refunded_amount_cents,
            status,
            subtotal,
            tax_amount,
            tax_breakdown,
            total,
            extra: serde_json::Map::new(),
        }
    }
}

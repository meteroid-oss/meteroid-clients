// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    credit_note_id::CreditNoteId, credit_note_status::CreditNoteStatus, customer_id::CustomerId,
    invoice_id::InvoiceId,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CreditNoteEventData {
    pub created_at: String,

    pub credit_note_id: CreditNoteId,

    pub credited_amount_cents: i32,

    pub currency: String,

    pub customer_id: CustomerId,

    pub invoice_id: InvoiceId,

    pub refunded_amount_cents: i32,

    pub status: CreditNoteStatus,

    pub tax_amount: i32,

    pub total: i32,
}

impl CreditNoteEventData {
    pub fn new(
        created_at: String,
        credit_note_id: CreditNoteId,
        credited_amount_cents: i32,
        currency: String,
        customer_id: CustomerId,
        invoice_id: InvoiceId,
        refunded_amount_cents: i32,
        status: CreditNoteStatus,
        tax_amount: i32,
        total: i32,
    ) -> Self {
        Self {
            created_at,
            credit_note_id,
            credited_amount_cents,
            currency,
            customer_id,
            invoice_id,
            refunded_amount_cents,
            status,
            tax_amount,
            total,
        }
    }
}

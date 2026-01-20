// this file is @generated
use serde::{Deserialize, Serialize};

use super::{customer_id::CustomerId, invoice_id::InvoiceId, invoice_status::InvoiceStatus};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct InvoiceEventData {
    pub created_at: String,

    pub currency: String,

    pub customer_id: CustomerId,

    pub invoice_id: InvoiceId,

    pub status: InvoiceStatus,

    pub tax_amount: i32,

    pub total: i32,
}

impl InvoiceEventData {
    pub fn new(
        created_at: String,
        currency: String,
        customer_id: CustomerId,
        invoice_id: InvoiceId,
        status: InvoiceStatus,
        tax_amount: i32,
        total: i32,
    ) -> Self {
        Self {
            created_at,
            currency,
            customer_id,
            invoice_id,
            status,
            tax_amount,
            total,
        }
    }
}

// this file is @generated
use serde::{Deserialize, Serialize};

use super::{customer_id::CustomerId, invoice_id::InvoiceId, invoice_status::InvoiceStatus};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct InvoiceEventData {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub consolidated_into_invoice_id: Option<InvoiceId>,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: String,

    /// User-defined custom property values, keyed by definition key.
    pub custom_properties: serde_json::Value,

    pub customer_id: CustomerId,

    pub invoice_id: InvoiceId,

    /// Absent while the invoice is a draft — the number is assigned at finalization.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice_number: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub parent_invoice_id: Option<InvoiceId>,

    pub status: InvoiceStatus,

    pub tax_amount: i64,

    pub total: i64,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl InvoiceEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        currency: impl Into<String>,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        invoice_id: InvoiceId,
        status: InvoiceStatus,
        tax_amount: i64,
        total: i64,
    ) -> Self {
        Self {
            consolidated_into_invoice_id: None,
            created_at,
            currency: currency.into(),
            custom_properties,
            customer_id,
            invoice_id,
            invoice_number: None,
            parent_invoice_id: None,
            status,
            tax_amount,
            total,
            extra: serde_json::Map::new(),
        }
    }
}

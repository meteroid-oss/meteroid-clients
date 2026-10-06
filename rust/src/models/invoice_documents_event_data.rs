// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    customer_id::CustomerId, e_invoicing_finding::EInvoicingFinding,
    e_invoicing_status::EInvoicingStatus, invoice_id::InvoiceId,
};

/// Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
/// outcome is known: the structured document is produced with the PDF, not at finalization.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct InvoiceDocumentsEventData {
    pub customer_id: CustomerId,

    /// Set when generation failed for a reason that is not a business rule.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub einvoicing_error: Option<String>,

    /// Empty unless the status is `failed`.
    pub einvoicing_findings: Vec<EInvoicingFinding>,

    /// The profile the document was checked against, e.g. "EN 16931".
    #[serde(skip_serializing_if = "Option::is_none")]
    pub einvoicing_profile: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub einvoicing_status: Option<EInvoicingStatus>,

    pub invoice_id: InvoiceId,

    pub pdf_document_id: String,

    /// The structured e-invoice stored beside the PDF, when one was produced.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub xml_document_id: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl InvoiceDocumentsEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        customer_id: CustomerId,
        einvoicing_findings: Vec<EInvoicingFinding>,
        invoice_id: InvoiceId,
        pdf_document_id: impl Into<String>,
    ) -> Self {
        Self {
            customer_id,
            einvoicing_error: None,
            einvoicing_findings,
            einvoicing_profile: None,
            einvoicing_status: None,
            invoice_id,
            pdf_document_id: pdf_document_id.into(),
            xml_document_id: None,
            extra: serde_json::Map::new(),
        }
    }
}

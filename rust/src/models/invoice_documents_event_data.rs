// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    customer_id::CustomerId, e_invoicing_finding::EInvoicingFinding,
    e_invoicing_status::EInvoicingStatus, invoice_id::InvoiceId,
};

/// Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
/// outcome is known: the structured document is produced with the PDF, not at finalization.
#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
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
}

impl InvoiceDocumentsEventData {
    pub fn new(
        customer_id: CustomerId,
        einvoicing_findings: Vec<EInvoicingFinding>,
        invoice_id: InvoiceId,
        pdf_document_id: String,
    ) -> Self {
        Self {
            customer_id,
            einvoicing_error: None,
            einvoicing_findings,
            einvoicing_profile: None,
            einvoicing_status: None,
            invoice_id,
            pdf_document_id,
            xml_document_id: None,
        }
    }
}

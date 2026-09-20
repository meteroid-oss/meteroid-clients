// this file is @generated
package meteroid

// Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
// outcome is known: the structured document is produced with the PDF, not at finalization.
type InvoiceDocumentsEventData struct {
	CustomerId CustomerId `json:"customer_id"`

	// Set when generation failed for a reason that is not a business rule.
	EinvoicingError *string `json:"einvoicing_error,omitempty"`

	// Empty unless the status is `failed`.
	EinvoicingFindings RequiredSlice[EInvoicingFinding] `json:"einvoicing_findings"`

	// The profile the document was checked against, e.g. "EN 16931".
	EinvoicingProfile *string `json:"einvoicing_profile,omitempty"`

	EinvoicingStatus *EInvoicingStatus `json:"einvoicing_status,omitempty"`

	InvoiceId InvoiceId `json:"invoice_id"`

	PdfDocumentId string `json:"pdf_document_id"`

	// The structured e-invoice stored beside the PDF, when one was produced.
	XmlDocumentId *string `json:"xml_document_id,omitempty"`
}

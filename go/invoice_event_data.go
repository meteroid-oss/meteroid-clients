// this file is @generated
package meteroid

import (
	"encoding/json"
	"time"
)

type InvoiceEventData struct {
	ConsolidatedIntoInvoiceId *InvoiceId `json:"consolidated_into_invoice_id,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency string `json:"currency"`

	// User-defined custom property values, keyed by definition key.
	CustomProperties json.RawMessage `json:"custom_properties"`

	CustomerId CustomerId `json:"customer_id"`

	InvoiceId InvoiceId `json:"invoice_id"`

	// Absent while the invoice is a draft — the number is assigned at finalization.
	InvoiceNumber *string `json:"invoice_number,omitempty"`

	ParentInvoiceId *InvoiceId `json:"parent_invoice_id,omitempty"`

	Status InvoiceStatus `json:"status"`

	TaxAmount int64 `json:"tax_amount"`

	Total int64 `json:"total"`
}

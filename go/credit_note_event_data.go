// this file is @generated
package meteroid

import (
	"encoding/json"
	"time"
)

type CreditNoteEventData struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	CreditNoteId CreditNoteId `json:"credit_note_id"`

	// Absent while the credit note is a draft — the number is assigned at finalization.
	CreditNoteNumber *string `json:"credit_note_number,omitempty"`

	CreditedAmountCents int64 `json:"credited_amount_cents"`

	Currency string `json:"currency"`

	// User-defined custom property values, keyed by definition key.
	CustomProperties json.RawMessage `json:"custom_properties"`

	CustomerId CustomerId `json:"customer_id"`

	InvoiceId InvoiceId `json:"invoice_id"`

	// Number of the invoice being credited.
	InvoiceNumber *string `json:"invoice_number,omitempty"`

	// Credited line items (negated amounts).
	LineItems RequiredSlice[InvoiceLineItem] `json:"line_items"`

	Memo *string `json:"memo,omitempty"`

	Reason *string `json:"reason,omitempty"`

	RefundedAmountCents int64 `json:"refunded_amount_cents"`

	Status CreditNoteStatus `json:"status"`

	Subtotal int64 `json:"subtotal"`

	TaxAmount int64 `json:"tax_amount"`

	// Per-rate tax (VAT) breakdown for the credited amount.
	TaxBreakdown RequiredSlice[TaxBreakdownItem] `json:"tax_breakdown"`

	Total int64 `json:"total"`
}

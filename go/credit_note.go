// this file is @generated
package meteroid

import "time"

type CreditNote struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	CreditNoteNumber string `json:"credit_note_number"`

	CreditType CreditType `json:"credit_type"`

	CreditedAmountCents int64 `json:"credited_amount_cents"`

	Currency Currency `json:"currency"`

	// User-defined custom property values, keyed by definition `key`.
	CustomProperties RequiredMap[any] `json:"custom_properties"`

	CustomerId CustomerId `json:"customer_id"`

	// RFC 3339 timestamp.
	FinalizedAt *time.Time `json:"finalized_at,omitempty"`

	Id CreditNoteId `json:"id"`

	InvoiceId InvoiceId `json:"invoice_id"`

	InvoiceNumber string `json:"invoice_number"`

	LineItems RequiredSlice[InvoiceLineItem] `json:"line_items"`

	Memo *string `json:"memo,omitempty"`

	PlanVersionId *PlanVersionId `json:"plan_version_id,omitempty"`

	Reason *string `json:"reason,omitempty"`

	RefundedAmountCents int64 `json:"refunded_amount_cents"`

	Status CreditNoteStatus `json:"status"`

	SubscriptionId *SubscriptionId `json:"subscription_id,omitempty"`

	Subtotal int64 `json:"subtotal"`

	TaxAmount int64 `json:"tax_amount"`

	TaxBreakdown RequiredSlice[TaxBreakdownItem] `json:"tax_breakdown"`

	Total int64 `json:"total"`

	// RFC 3339 timestamp.
	UpdatedAt *time.Time `json:"updated_at,omitempty"`

	// RFC 3339 timestamp.
	VoidedAt *time.Time `json:"voided_at,omitempty"`
}

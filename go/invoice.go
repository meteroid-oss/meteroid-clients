// this file is @generated
package meteroid

import "time"

type Invoice struct {
	AmountDue int64 `json:"amount_due"`

	AppliedCredits int64 `json:"applied_credits"`

	// The period/moment this invoice is about — the subscription period start, or the invoice's
	// own date for manual/one-off. Stable and always present, distinct from `invoice_date` (the
	// emission date). Shown as "Invoice date".
	BillingPeriodStart *string `json:"billing_period_start,omitempty"`

	ChildInvoiceId *InvoiceId `json:"child_invoice_id,omitempty"`

	Coupons RequiredSlice[CouponLineItem] `json:"coupons"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency Currency `json:"currency"`

	// User-defined custom property values, keyed by definition `key`.
	CustomProperties RequiredMap[any] `json:"custom_properties"`

	CustomerDetails CustomerDetails `json:"customer_details"`

	CustomerId CustomerId `json:"customer_id"`

	DueDate *string `json:"due_date,omitempty"`

	// RFC 3339 timestamp.
	FinalizedAt *time.Time `json:"finalized_at,omitempty"`

	Id InvoiceId `json:"id"`

	InvoiceDate string `json:"invoice_date"`

	InvoiceNumber string `json:"invoice_number"`

	InvoiceType InvoiceType `json:"invoice_type"`

	LineItems RequiredSlice[InvoiceLineItem] `json:"line_items"`

	// RFC 3339 timestamp.
	MarkedAsUncollectibleAt *time.Time `json:"marked_as_uncollectible_at,omitempty"`

	Memo *string `json:"memo,omitempty"`

	NetTerms int32 `json:"net_terms"`

	// RFC 3339 timestamp.
	PaidAt *time.Time `json:"paid_at,omitempty"`

	ParentInvoiceId *InvoiceId `json:"parent_invoice_id,omitempty"`

	PaymentStatus InvoicePaymentStatus `json:"payment_status"`

	PurchaseOrder *string `json:"purchase_order,omitempty"`

	Reference *string `json:"reference,omitempty"`

	Status InvoiceStatus `json:"status"`

	SubscriptionId *SubscriptionId `json:"subscription_id,omitempty"`

	Subtotal int64 `json:"subtotal"`

	SubtotalRecurring int64 `json:"subtotal_recurring"`

	TaxAmount int64 `json:"tax_amount"`

	TaxBreakdown RequiredSlice[TaxBreakdownItem] `json:"tax_breakdown"`

	Total int64 `json:"total"`

	Transactions RequiredSlice[Transaction] `json:"transactions"`

	// RFC 3339 timestamp.
	UpdatedAt *time.Time `json:"updated_at,omitempty"`

	// RFC 3339 timestamp.
	VoidedAt *time.Time `json:"voided_at,omitempty"`
}

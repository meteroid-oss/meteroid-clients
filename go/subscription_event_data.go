// this file is @generated
package meteroid

import "time"

type SubscriptionEventData struct {
	// RFC 3339 timestamp.
	ActivatedAt *time.Time `json:"activated_at,omitempty"`

	AutoAdvanceInvoices bool `json:"auto_advance_invoices"`

	BillingDayAnchor int32 `json:"billing_day_anchor"`

	BillingStartDate *string `json:"billing_start_date,omitempty"`

	// Present on `subscription.cancelled` when a reason was supplied.
	CancellationReason *string `json:"cancellation_reason,omitempty"`

	ChangeType *SubscriptionUpdateType `json:"change_type,omitempty"`

	ChargeAutomatically bool `json:"charge_automatically"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency string `json:"currency"`

	// User-defined custom property values, keyed by definition key.
	CustomProperties RequiredMap[any] `json:"custom_properties"`

	CustomerAlias *string `json:"customer_alias,omitempty"`

	CustomerId CustomerId `json:"customer_id"`

	CustomerName string `json:"customer_name"`

	EndDate *string `json:"end_date,omitempty"`

	InvoiceMemo *string `json:"invoice_memo,omitempty"`

	InvoiceThreshold *string `json:"invoice_threshold,omitempty"`

	MrrCents int64 `json:"mrr_cents"`

	NetTerms int32 `json:"net_terms"`

	Period BillingPeriodEnum `json:"period"`

	PlanName string `json:"plan_name"`

	PurchaseOrder *string `json:"purchase_order,omitempty"`

	StartDate string `json:"start_date"`

	Status SubscriptionStatusEnum `json:"status"`

	SubscriptionId SubscriptionId `json:"subscription_id"`

	TrialDuration *int32 `json:"trial_duration,omitempty"`

	Version int32 `json:"version"`
}

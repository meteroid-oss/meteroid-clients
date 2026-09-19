// this file is @generated
package meteroid

import "time"

type Subscription struct {
	// When the subscription was activated (first payment or activation condition met)
	// RFC 3339 timestamp.
	ActivatedAt *time.Time `json:"activated_at,omitempty"`

	// If false, invoices will stay in Draft until manually reviewed and finalized. Default to true.
	AutoAdvanceInvoices bool `json:"auto_advance_invoices"`

	BillingDayAnchor int32 `json:"billing_day_anchor"`

	// When billing started (after any trial period)
	BillingStartDate *string `json:"billing_start_date,omitempty"`

	// Automatically try to charge the customer's configured payment method on finalize.
	ChargeAutomatically bool `json:"charge_automatically"`

	// When the subscription was created
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency Currency `json:"currency"`

	// Current billing period end date
	CurrentPeriodEnd *string `json:"current_period_end,omitempty"`

	// Current billing period start date
	CurrentPeriodStart string `json:"current_period_start"`

	// User-defined custom property values, keyed by definition `key`.
	CustomProperties RequiredMap[any] `json:"custom_properties"`

	CustomerAlias *string `json:"customer_alias,omitempty"`

	CustomerId CustomerId `json:"customer_id"`

	CustomerName string `json:"customer_name"`

	// When the subscription ends (if set)
	EndDate *string `json:"end_date,omitempty"`

	Id SubscriptionId `json:"id"`

	// Default memo for invoices
	InvoiceMemo *string `json:"invoice_memo,omitempty"`

	// Monthly recurring revenue in cents
	MrrCents int64 `json:"mrr_cents"`

	// Payment terms in days (0 = due on issue)
	NetTerms int32 `json:"net_terms"`

	PaymentMethodsConfig *PaymentMethodsConfig `json:"payment_methods_config,omitempty"`

	// Billing period (monthly, annual, etc.)
	Period BillingPeriodEnum `json:"period"`

	PlanDescription *string `json:"plan_description,omitempty"`

	PlanId PlanId `json:"plan_id"`

	PlanName string `json:"plan_name"`

	PlanVersion int32 `json:"plan_version"`

	PlanVersionId PlanVersionId `json:"plan_version_id"`

	PurchaseOrder *string `json:"purchase_order,omitempty"`

	// When the subscription contract starts (benefits apply from this date)
	StartDate string `json:"start_date"`

	Status SubscriptionStatusEnum `json:"status"`

	// Trial duration in days
	TrialDuration *int32 `json:"trial_duration,omitempty"`
}

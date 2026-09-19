// this file is @generated
package meteroid

type CreateCheckoutSessionRequest struct {
	AddOns []CreateSubscriptionAddOn `json:"add_ons,omitempty"`

	// If false, invoices will stay in Draft until manually reviewed and finalized. Default is true.
	AutoAdvanceInvoices *bool `json:"auto_advance_invoices,omitempty"`

	BillingDayAnchor *int32 `json:"billing_day_anchor,omitempty"`

	BillingStartDate *string `json:"billing_start_date,omitempty"`

	// Absolute http(s) URL offered to the customer to leave the checkout without paying.
	CancelUrl *string `json:"cancel_url,omitempty"`

	// Automatically try to charge the customer's configured payment method on finalize. Default is true.
	ChargeAutomatically *bool `json:"charge_automatically,omitempty"`

	Components *CreateSubscriptionComponents `json:"components,omitempty"`

	CouponCode *string `json:"coupon_code,omitempty"`

	CouponIds []CouponId `json:"coupon_ids,omitempty"`

	// Customer ID or alias
	CustomerId string `json:"customer_id"`

	EndDate *string `json:"end_date,omitempty"`

	// Session expiry time in hours. Default is 1 hour for self-serve checkout.
	ExpiresInHours *int32 `json:"expires_in_hours,omitempty"`

	InvoiceMemo *string `json:"invoice_memo,omitempty"`

	InvoiceThreshold *string `json:"invoice_threshold,omitempty"`

	Metadata map[string]any `json:"metadata,omitempty"`

	NetTerms *int32 `json:"net_terms,omitempty"`

	PaymentMethodsConfig *PaymentMethodsConfig `json:"payment_methods_config,omitempty"`

	PlanVersionId PlanVersionId `json:"plan_version_id"`

	PurchaseOrder *string `json:"purchase_order,omitempty"`

	// Absolute http(s) URL the customer is sent to after a successful checkout.
	// `checkout_session_id` is appended as a query parameter. Without it the customer stays on
	// the hosted confirmation page.
	SuccessUrl *string `json:"success_url,omitempty"`

	TrialDurationDays *int32 `json:"trial_duration_days,omitempty"`
}

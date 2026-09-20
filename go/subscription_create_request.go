// this file is @generated
package meteroid

import "encoding/json"

type SubscriptionCreateRequest struct {
	ActivationCondition SubscriptionActivationConditionEnum `json:"activation_condition"`

	AddOns []CreateSubscriptionAddOn `json:"add_ons,omitempty"`

	AutoAdvanceInvoices *bool `json:"auto_advance_invoices,omitempty"`

	// Historical import mode: when true, invoices finalized for this subscription keep their
	// billing-period date as the invoice date instead of being stamped with the emission date.
	BackdateInvoices *bool `json:"backdate_invoices,omitempty"`

	BillingDayAnchor *int32 `json:"billing_day_anchor,omitempty"`

	ChargeAutomatically *bool `json:"charge_automatically,omitempty"`

	CouponCodes []string `json:"coupon_codes,omitempty"`

	// User-defined custom property values, keyed by definition `key`. Validated against the
	// tenant's subscription definitions.
	CustomProperties json.RawMessage `json:"custom_properties,omitempty"`

	CustomerIdOrAlias string `json:"customer_id_or_alias"`

	EndDate *string `json:"end_date,omitempty"`

	InvoiceMemo *string `json:"invoice_memo,omitempty"`

	NetTerms *int32 `json:"net_terms,omitempty"`

	// Payment methods configuration. If not specified, inherits from the invoicing entity.
	PaymentMethodsConfig *PaymentMethodsConfig `json:"payment_methods_config,omitempty"`

	PlanId PlanId `json:"plan_id"`

	PriceComponents *CreateSubscriptionComponents `json:"price_components,omitempty"`

	PurchaseOrder *string `json:"purchase_order,omitempty"`

	// Migration mode: when true with a past start_date, skip creating invoices for past cycles.
	// The subscription will be set to the current billing period with correct cycle_index.
	SkipPastInvoices *bool `json:"skip_past_invoices,omitempty"`

	StartDate string `json:"start_date"`

	TrialDays *int32 `json:"trial_days,omitempty"`

	Version *int32 `json:"version,omitempty"`
}

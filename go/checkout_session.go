// this file is @generated
package meteroid

import "time"

type CheckoutSession struct {
	BillingDayAnchor *int32 `json:"billing_day_anchor,omitempty"`

	BillingStartDate *string `json:"billing_start_date,omitempty"`

	CheckoutType CheckoutType `json:"checkout_type"`

	CheckoutUrl *string `json:"checkout_url,omitempty"`

	// RFC 3339 timestamp.
	CompletedAt *time.Time `json:"completed_at,omitempty"`

	CouponCode *string `json:"coupon_code,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	CustomerId CustomerId `json:"customer_id"`

	// When the session expires. None means the session never expires.
	// RFC 3339 timestamp.
	ExpiresAt *time.Time `json:"expires_at,omitempty"`

	Id CheckoutSessionId `json:"id"`

	NetTerms *int32 `json:"net_terms,omitempty"`

	PaymentMethodsConfig *PaymentMethodsConfig `json:"payment_methods_config,omitempty"`

	PlanVersionId PlanVersionId `json:"plan_version_id"`

	Status CheckoutSessionStatus `json:"status"`

	SubscriptionId *SubscriptionId `json:"subscription_id,omitempty"`

	TrialDurationDays *int32 `json:"trial_duration_days,omitempty"`
}

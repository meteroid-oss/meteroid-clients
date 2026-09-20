// this file is @generated
package meteroid

import "time"

// Coupon as embedded in subscription details — a subset of the `Coupon` resource
// returned by the coupons API.
type SubscriptionCoupon struct {
	Code string `json:"code"`

	Description string `json:"description"`

	Disabled bool `json:"disabled"`

	Discount CouponDiscount `json:"discount"`

	// RFC 3339 timestamp.
	ExpiresAt *time.Time `json:"expires_at,omitempty"`

	Id CouponId `json:"id"`

	RecurringValue *int32 `json:"recurring_value,omitempty"`

	RedemptionLimit *int32 `json:"redemption_limit,omitempty"`

	Reusable bool `json:"reusable"`
}

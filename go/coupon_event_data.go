// this file is @generated
package meteroid

import "time"

type CouponEventData struct {
	Code string `json:"code"`

	CouponId CouponId `json:"coupon_id"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description string `json:"description"`

	Disabled bool `json:"disabled"`

	Discount CouponDiscount `json:"discount"`

	// RFC 3339 timestamp.
	ExpiresAt *time.Time `json:"expires_at,omitempty"`

	RecurringValue *int32 `json:"recurring_value,omitempty"`

	RedemptionLimit *int32 `json:"redemption_limit,omitempty"`

	Reusable bool `json:"reusable"`
}

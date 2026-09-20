// this file is @generated
package meteroid

import "time"

type AppliedCoupon struct {
	AppliedAmount *string `json:"applied_amount,omitempty"`

	AppliedCount *int32 `json:"applied_count,omitempty"`

	CouponId CouponId `json:"coupon_id"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Id AppliedCouponId `json:"id"`

	IsActive bool `json:"is_active"`

	// RFC 3339 timestamp.
	LastAppliedAt *time.Time `json:"last_applied_at,omitempty"`
}

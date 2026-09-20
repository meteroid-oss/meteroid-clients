// this file is @generated
package meteroid

import "time"

type Coupon struct {
	// RFC 3339 timestamp.
	ArchivedAt *time.Time `json:"archived_at,omitempty"`

	Code string `json:"code"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	Disabled bool `json:"disabled"`

	Discount CouponDiscount `json:"discount"`

	// RFC 3339 timestamp.
	ExpiresAt *time.Time `json:"expires_at,omitempty"`

	Id CouponId `json:"id"`

	PlanIds RequiredSlice[PlanId] `json:"plan_ids"`

	RecurringValue *int32 `json:"recurring_value,omitempty"`

	RedemptionCount int32 `json:"redemption_count"`

	RedemptionLimit *int32 `json:"redemption_limit,omitempty"`

	Reusable bool `json:"reusable"`
}

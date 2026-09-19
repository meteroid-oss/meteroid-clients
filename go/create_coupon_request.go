// this file is @generated
package meteroid

import "time"

type CreateCouponRequest struct {
	Code string `json:"code"`

	Description *string `json:"description,omitempty"`

	Discount CouponDiscount `json:"discount"`

	// RFC 3339 timestamp.
	ExpiresAt *time.Time `json:"expires_at,omitempty"`

	PlanIds []PlanId `json:"plan_ids,omitempty"`

	RecurringValue *int32 `json:"recurring_value,omitempty"`

	RedemptionLimit *int32 `json:"redemption_limit,omitempty"`

	Reusable *bool `json:"reusable,omitempty"`
}

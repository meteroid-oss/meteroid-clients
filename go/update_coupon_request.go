// this file is @generated
package meteroid

type UpdateCouponRequest struct {
	Description *string `json:"description,omitempty"`

	Discount *CouponDiscount `json:"discount,omitempty"`

	PlanIds []PlanId `json:"plan_ids,omitempty"`
}

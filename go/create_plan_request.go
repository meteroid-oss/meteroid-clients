// this file is @generated
package meteroid

type CreatePlanRequest struct {
	AddOns []PlanAddOnInput `json:"add_ons,omitempty"`

	Billing *BillingConfig `json:"billing,omitempty"`

	Components RequiredSlice[PriceComponentInput] `json:"components"`

	Currency string `json:"currency"`

	Description *string `json:"description,omitempty"`

	Name string `json:"name"`

	PlanType PlanTypeEnum `json:"plan_type"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`

	SelfServiceRank *int32 `json:"self_service_rank,omitempty"`

	Status PlanStatusEnum `json:"status"`

	Trial *TrialConfig `json:"trial,omitempty"`
}

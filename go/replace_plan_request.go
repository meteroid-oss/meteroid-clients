// this file is @generated
package meteroid

type ReplacePlanRequest struct {
	AddOns []PlanAddOnInput `json:"add_ons,omitempty"`

	Billing *BillingConfig `json:"billing,omitempty"`

	Components RequiredSlice[PriceComponentInput] `json:"components"`

	Currency string `json:"currency"`

	Description *string `json:"description,omitempty"`

	MinimumCommitment *MinimumCommitmentInput `json:"minimum_commitment,omitempty"`

	Name string `json:"name"`

	Status *PlanStatusEnum `json:"status,omitempty"`

	Trial *TrialConfig `json:"trial,omitempty"`
}

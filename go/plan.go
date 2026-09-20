// this file is @generated
package meteroid

import "time"

type Plan struct {
	AvailableParameters AvailableParameters `json:"available_parameters"`

	BillingCycles *int32 `json:"billing_cycles,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency string `json:"currency"`

	Description *string `json:"description,omitempty"`

	Entitlements []Entitlement `json:"entitlements,omitempty"`

	Id PlanId `json:"id"`

	MinimumCommitment *MinimumCommitment `json:"minimum_commitment,omitempty"`

	Name string `json:"name"`

	NetTerms int32 `json:"net_terms"`

	PeriodStartDay *int32 `json:"period_start_day,omitempty"`

	PlanType PlanTypeEnum `json:"plan_type"`

	PriceComponents RequiredSlice[PriceComponent] `json:"price_components"`

	ProductFamily ProductFamily `json:"product_family"`

	SelfServiceRank *int32 `json:"self_service_rank,omitempty"`

	Status PlanStatusEnum `json:"status"`

	Trial *TrialConfig `json:"trial,omitempty"`

	Version int32 `json:"version"`

	VersionId PlanVersionId `json:"version_id"`
}

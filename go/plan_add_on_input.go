// this file is @generated
package meteroid

type PlanAddOnInput struct {
	AddOnId AddOnId `json:"add_on_id"`

	MaxInstances *int32 `json:"max_instances,omitempty"`

	PriceId *PriceId `json:"price_id,omitempty"`

	SelfServiceable *bool `json:"self_serviceable,omitempty"`
}

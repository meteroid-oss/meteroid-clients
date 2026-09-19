// this file is @generated
package meteroid

type UpdateAddOnRequest struct {
	Description *string `json:"description,omitempty"`

	MaxInstancesPerSubscription *int32 `json:"max_instances_per_subscription,omitempty"`

	Name *string `json:"name,omitempty"`

	PriceId *PriceId `json:"price_id,omitempty"`

	SelfServiceable *bool `json:"self_serviceable,omitempty"`
}

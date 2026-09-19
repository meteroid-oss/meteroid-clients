// this file is @generated
package meteroid

type CreateAddOnRequest struct {
	Description *string `json:"description,omitempty"`

	MaxInstancesPerSubscription *int32 `json:"max_instances_per_subscription,omitempty"`

	Name string `json:"name"`

	PriceId PriceId `json:"price_id"`

	ProductId ProductId `json:"product_id"`

	SelfServiceable *bool `json:"self_serviceable,omitempty"`
}

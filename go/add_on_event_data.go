// this file is @generated
package meteroid

import "time"

type AddOnEventData struct {
	AddOnId AddOnId `json:"add_on_id"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	FeeType *ProductFeeTypeEnum `json:"fee_type,omitempty"`

	MaxInstancesPerSubscription *int32 `json:"max_instances_per_subscription,omitempty"`

	Name string `json:"name"`

	PriceId PriceId `json:"price_id"`

	ProductId ProductId `json:"product_id"`

	SelfServiceable bool `json:"self_serviceable"`
}

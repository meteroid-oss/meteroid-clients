// this file is @generated
package meteroid

import "time"

type AddOn struct {
	// RFC 3339 timestamp.
	ArchivedAt *time.Time `json:"archived_at,omitempty"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	Entitlements []Entitlement `json:"entitlements,omitempty"`

	FeeType *ProductFeeTypeEnum `json:"fee_type,omitempty"`

	Id AddOnId `json:"id"`

	MaxInstancesPerSubscription *int32 `json:"max_instances_per_subscription,omitempty"`

	Name string `json:"name"`

	PriceId PriceId `json:"price_id"`

	ProductId ProductId `json:"product_id"`

	SelfServiceable bool `json:"self_serviceable"`
}

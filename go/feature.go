// this file is @generated
package meteroid

import "time"

type Feature struct {
	// Unique key used to reference this feature in your code. Cannot be changed after creation.
	Code string `json:"code"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	Entitlement *Entitlement `json:"entitlement,omitempty"`

	FeatureType FeatureType `json:"feature_type"`

	Id FeatureId `json:"id"`

	Name string `json:"name"`

	Product *EntitlementProductRef `json:"product,omitempty"`

	Status FeatureStatus `json:"status"`
}

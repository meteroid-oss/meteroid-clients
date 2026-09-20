// this file is @generated
package meteroid

import "time"

// A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription).
type Entitlement struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	FeatureId FeatureId `json:"feature_id"`

	Id EntitlementId `json:"id"`

	// RFC 3339 timestamp.
	UpdatedAt time.Time `json:"updated_at"`

	Value EntitlementValue `json:"value"`
}

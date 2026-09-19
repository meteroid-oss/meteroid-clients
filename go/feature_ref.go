// this file is @generated
package meteroid

type FeatureRef struct {
	// Unique key used to reference this feature in your code. Cannot be changed after creation.
	Code string `json:"code"`

	Id FeatureId `json:"id"`

	Name string `json:"name"`

	Product *EntitlementProductRef `json:"product,omitempty"`
}

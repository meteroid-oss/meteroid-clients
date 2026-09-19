// this file is @generated
package meteroid

type CreateSubscriptionComponents struct {
	ExtraComponents []ExtraComponent `json:"extra_components,omitempty"`

	OverriddenComponents []ComponentOverride `json:"overridden_components,omitempty"`

	ParameterizedComponents []ComponentParameterization `json:"parameterized_components,omitempty"`

	RemoveComponents []PriceComponentId `json:"remove_components,omitempty"`
}

// this file is @generated
package meteroid

// Component names — matched against `ReplacePlanRequest::components[].name`.
type ComponentsScope struct {
	ComponentNames RequiredSlice[string] `json:"component_names"`
}

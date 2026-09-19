// this file is @generated
package meteroid

// Update of a definition. `key`, `entity_type` and `property_type` are immutable and cannot be
// changed here. Any field left absent is unchanged.
type CustomPropertyDefinitionUpdateRequest struct {
	Config *PropertyConfig `json:"config,omitempty"`

	DefaultValue map[string]any `json:"default_value,omitempty"`

	Description *string `json:"description,omitempty"`

	DisplayOrder *int32 `json:"display_order,omitempty"`

	Name *string `json:"name,omitempty"`

	Required *bool `json:"required,omitempty"`
}

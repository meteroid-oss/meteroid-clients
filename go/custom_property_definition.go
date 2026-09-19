// this file is @generated
package meteroid

type CustomPropertyDefinition struct {
	Archived bool `json:"archived"`

	Config PropertyConfig `json:"config"`

	DefaultValue map[string]any `json:"default_value,omitempty"`

	Description *string `json:"description,omitempty"`

	DisplayOrder int32 `json:"display_order"`

	EntityType CustomPropertyEntityType `json:"entity_type"`

	Id CustomPropertyDefinitionId `json:"id"`

	Key string `json:"key"`

	Name string `json:"name"`

	PropertyType CustomPropertyType `json:"property_type"`

	Required bool `json:"required"`
}

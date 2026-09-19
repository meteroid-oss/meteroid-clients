// this file is @generated
package meteroid

import "encoding/json"

type CustomPropertyDefinitionCreateRequest struct {
	Config *PropertyConfig `json:"config,omitempty"`

	DefaultValue json.RawMessage `json:"default_value,omitempty"`

	Description *string `json:"description,omitempty"`

	DisplayOrder *int32 `json:"display_order,omitempty"`

	EntityType CustomPropertyEntityType `json:"entity_type"`

	// Immutable machine name; letters, digits and underscores only. Unique per entity type.
	Key string `json:"key"`

	Name string `json:"name"`

	PropertyType CustomPropertyType `json:"property_type"`

	Required *bool `json:"required,omitempty"`
}

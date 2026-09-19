// this file is @generated
package meteroid

import "encoding/json"

type CustomPropertyDefinition struct {
	Archived bool `json:"archived"`

	Config PropertyConfig `json:"config"`

	DefaultValue json.RawMessage `json:"default_value,omitempty"`

	Description *string `json:"description,omitempty"`

	DisplayOrder int32 `json:"display_order"`

	EntityType CustomPropertyEntityType `json:"entity_type"`

	Id CustomPropertyDefinitionId `json:"id"`

	Key string `json:"key"`

	Name string `json:"name"`

	PropertyType CustomPropertyType `json:"property_type"`

	Required bool `json:"required"`
}

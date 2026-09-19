// this file is @generated
package meteroid

// Type-specific configuration. Only the fields relevant to `property_type` are interpreted.
type PropertyConfig struct {
	Max *float64 `json:"max,omitempty"`

	// Maximum length for `TEXT`.
	MaxLength *int32 `json:"max_length,omitempty"`

	// Inclusive numeric bounds for `NUMBER`.
	Min *float64 `json:"min,omitempty"`

	// Allowed choices for `SINGLE_SELECT` / `MULTI_SELECT`.
	Options []SelectOption `json:"options,omitempty"`
}

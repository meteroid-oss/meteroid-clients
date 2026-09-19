// this file is @generated
package meteroid

// A static, typed configuration value. No metric — resolved synchronously.
type ConfigFeatureType struct {
	// Allowed values when `value_type = SELECT`. Empty otherwise.
	Options []string `json:"options,omitempty"`

	// The feature's value type, fixed at creation.
	ValueType ConfigValueType `json:"value_type"`
}

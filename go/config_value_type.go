// this file is @generated
package meteroid

// Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value.
type ConfigValueType string

// Known values of ConfigValueType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ConfigValueTypeNumber  ConfigValueType = "NUMBER"
	ConfigValueTypeBoolean ConfigValueType = "BOOLEAN"
	ConfigValueTypeText    ConfigValueType = "TEXT"
	ConfigValueTypeMap     ConfigValueType = "MAP"
	ConfigValueTypeJson    ConfigValueType = "JSON"
	ConfigValueTypeSelect  ConfigValueType = "SELECT"
)

// AllConfigValueTypeValues lists every ConfigValueType value known to this SDK version.
var AllConfigValueTypeValues = []ConfigValueType{
	ConfigValueTypeNumber,
	ConfigValueTypeBoolean,
	ConfigValueTypeText,
	ConfigValueTypeMap,
	ConfigValueTypeJson,
	ConfigValueTypeSelect,
}

// String returns the wire representation of the value.
func (e ConfigValueType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ConfigValueType) IsKnown() bool {
	for _, known := range AllConfigValueTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

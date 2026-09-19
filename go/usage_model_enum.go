// this file is @generated
package meteroid

type UsageModelEnum string

// Known values of UsageModelEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	UsageModelEnumPerUnit UsageModelEnum = "PER_UNIT"
	UsageModelEnumTiered  UsageModelEnum = "TIERED"
	UsageModelEnumVolume  UsageModelEnum = "VOLUME"
	UsageModelEnumPackage UsageModelEnum = "PACKAGE"
	UsageModelEnumMatrix  UsageModelEnum = "MATRIX"
)

// AllUsageModelEnumValues lists every UsageModelEnum value known to this SDK version.
var AllUsageModelEnumValues = []UsageModelEnum{
	UsageModelEnumPerUnit,
	UsageModelEnumTiered,
	UsageModelEnumVolume,
	UsageModelEnumPackage,
	UsageModelEnumMatrix,
}

// String returns the wire representation of the value.
func (e UsageModelEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e UsageModelEnum) IsKnown() bool {
	for _, known := range AllUsageModelEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type UnitConversionRoundingEnum string

// Known values of UnitConversionRoundingEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	UnitConversionRoundingEnumUp            UnitConversionRoundingEnum = "UP"
	UnitConversionRoundingEnumDown          UnitConversionRoundingEnum = "DOWN"
	UnitConversionRoundingEnumNearest       UnitConversionRoundingEnum = "NEAREST"
	UnitConversionRoundingEnumNearestHalf   UnitConversionRoundingEnum = "NEAREST_HALF"
	UnitConversionRoundingEnumNearestDecile UnitConversionRoundingEnum = "NEAREST_DECILE"
	UnitConversionRoundingEnumNone          UnitConversionRoundingEnum = "NONE"
)

// AllUnitConversionRoundingEnumValues lists every UnitConversionRoundingEnum value known to this SDK version.
var AllUnitConversionRoundingEnumValues = []UnitConversionRoundingEnum{
	UnitConversionRoundingEnumUp,
	UnitConversionRoundingEnumDown,
	UnitConversionRoundingEnumNearest,
	UnitConversionRoundingEnumNearestHalf,
	UnitConversionRoundingEnumNearestDecile,
	UnitConversionRoundingEnumNone,
}

// String returns the wire representation of the value.
func (e UnitConversionRoundingEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e UnitConversionRoundingEnum) IsKnown() bool {
	for _, known := range AllUnitConversionRoundingEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

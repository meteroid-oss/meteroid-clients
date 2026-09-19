// this file is @generated
package meteroid

type ProductFeeTypeEnum string

// Known values of ProductFeeTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ProductFeeTypeEnumRate           ProductFeeTypeEnum = "RATE"
	ProductFeeTypeEnumSlot           ProductFeeTypeEnum = "SLOT"
	ProductFeeTypeEnumCapacity       ProductFeeTypeEnum = "CAPACITY"
	ProductFeeTypeEnumUsage          ProductFeeTypeEnum = "USAGE"
	ProductFeeTypeEnumExtraRecurring ProductFeeTypeEnum = "EXTRA_RECURRING"
	ProductFeeTypeEnumOneTime        ProductFeeTypeEnum = "ONE_TIME"
)

// AllProductFeeTypeEnumValues lists every ProductFeeTypeEnum value known to this SDK version.
var AllProductFeeTypeEnumValues = []ProductFeeTypeEnum{
	ProductFeeTypeEnumRate,
	ProductFeeTypeEnumSlot,
	ProductFeeTypeEnumCapacity,
	ProductFeeTypeEnumUsage,
	ProductFeeTypeEnumExtraRecurring,
	ProductFeeTypeEnumOneTime,
}

// String returns the wire representation of the value.
func (e ProductFeeTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ProductFeeTypeEnum) IsKnown() bool {
	for _, known := range AllProductFeeTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

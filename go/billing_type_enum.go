// this file is @generated
package meteroid

type BillingTypeEnum string

// Known values of BillingTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BillingTypeEnumAdvance BillingTypeEnum = "ADVANCE"
	BillingTypeEnumArrears BillingTypeEnum = "ARREARS"
)

// AllBillingTypeEnumValues lists every BillingTypeEnum value known to this SDK version.
var AllBillingTypeEnumValues = []BillingTypeEnum{
	BillingTypeEnumAdvance,
	BillingTypeEnumArrears,
}

// String returns the wire representation of the value.
func (e BillingTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BillingTypeEnum) IsKnown() bool {
	for _, known := range AllBillingTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type ExtraRecurringBillingTypeEnum string

// Known values of ExtraRecurringBillingTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ExtraRecurringBillingTypeEnumAdvance ExtraRecurringBillingTypeEnum = "ADVANCE"
	ExtraRecurringBillingTypeEnumArrears ExtraRecurringBillingTypeEnum = "ARREARS"
)

// AllExtraRecurringBillingTypeEnumValues lists every ExtraRecurringBillingTypeEnum value known to this SDK version.
var AllExtraRecurringBillingTypeEnumValues = []ExtraRecurringBillingTypeEnum{
	ExtraRecurringBillingTypeEnumAdvance,
	ExtraRecurringBillingTypeEnumArrears,
}

// String returns the wire representation of the value.
func (e ExtraRecurringBillingTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ExtraRecurringBillingTypeEnum) IsKnown() bool {
	for _, known := range AllExtraRecurringBillingTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

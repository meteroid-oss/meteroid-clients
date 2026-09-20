// this file is @generated
package meteroid

type BillingPeriodEnum string

// Known values of BillingPeriodEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BillingPeriodEnumMonthly    BillingPeriodEnum = "MONTHLY"
	BillingPeriodEnumQuarterly  BillingPeriodEnum = "QUARTERLY"
	BillingPeriodEnumSemiannual BillingPeriodEnum = "SEMIANNUAL"
	BillingPeriodEnumAnnual     BillingPeriodEnum = "ANNUAL"
)

// AllBillingPeriodEnumValues lists every BillingPeriodEnum value known to this SDK version.
var AllBillingPeriodEnumValues = []BillingPeriodEnum{
	BillingPeriodEnumMonthly,
	BillingPeriodEnumQuarterly,
	BillingPeriodEnumSemiannual,
	BillingPeriodEnumAnnual,
}

// String returns the wire representation of the value.
func (e BillingPeriodEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BillingPeriodEnum) IsKnown() bool {
	for _, known := range AllBillingPeriodEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

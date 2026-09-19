// this file is @generated
package meteroid

type BillingType string

// Known values of BillingType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BillingTypeAdvance BillingType = "ADVANCE"
	BillingTypeArrears BillingType = "ARREARS"
)

// AllBillingTypeValues lists every BillingType value known to this SDK version.
var AllBillingTypeValues = []BillingType{
	BillingTypeAdvance,
	BillingTypeArrears,
}

// String returns the wire representation of the value.
func (e BillingType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BillingType) IsKnown() bool {
	for _, known := range AllBillingTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

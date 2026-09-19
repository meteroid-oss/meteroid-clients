// this file is @generated
package meteroid

type CustomPropertyEntityType string

// Known values of CustomPropertyEntityType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CustomPropertyEntityTypeCustomer     CustomPropertyEntityType = "CUSTOMER"
	CustomPropertyEntityTypeSubscription CustomPropertyEntityType = "SUBSCRIPTION"
	CustomPropertyEntityTypeInvoice      CustomPropertyEntityType = "INVOICE"
	CustomPropertyEntityTypeCreditNote   CustomPropertyEntityType = "CREDIT_NOTE"
)

// AllCustomPropertyEntityTypeValues lists every CustomPropertyEntityType value known to this SDK version.
var AllCustomPropertyEntityTypeValues = []CustomPropertyEntityType{
	CustomPropertyEntityTypeCustomer,
	CustomPropertyEntityTypeSubscription,
	CustomPropertyEntityTypeInvoice,
	CustomPropertyEntityTypeCreditNote,
}

// String returns the wire representation of the value.
func (e CustomPropertyEntityType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CustomPropertyEntityType) IsKnown() bool {
	for _, known := range AllCustomPropertyEntityTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type TaxExemptionType string

// Known values of TaxExemptionType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	TaxExemptionTypeReverseCharge TaxExemptionType = "REVERSE_CHARGE"
	TaxExemptionTypeTaxExempt     TaxExemptionType = "TAX_EXEMPT"
	TaxExemptionTypeNotRegistered TaxExemptionType = "NOT_REGISTERED"
	TaxExemptionTypeExport        TaxExemptionType = "EXPORT"
)

// AllTaxExemptionTypeValues lists every TaxExemptionType value known to this SDK version.
var AllTaxExemptionTypeValues = []TaxExemptionType{
	TaxExemptionTypeReverseCharge,
	TaxExemptionTypeTaxExempt,
	TaxExemptionTypeNotRegistered,
	TaxExemptionTypeExport,
}

// String returns the wire representation of the value.
func (e TaxExemptionType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e TaxExemptionType) IsKnown() bool {
	for _, known := range AllTaxExemptionTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

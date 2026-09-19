// this file is @generated
package meteroid

// Company vs. individual (B2C). Defaults to `COMPANY`.
type CustomerType string

// Known values of CustomerType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CustomerTypeCompany    CustomerType = "COMPANY"
	CustomerTypeIndividual CustomerType = "INDIVIDUAL"
)

// AllCustomerTypeValues lists every CustomerType value known to this SDK version.
var AllCustomerTypeValues = []CustomerType{
	CustomerTypeCompany,
	CustomerTypeIndividual,
}

// String returns the wire representation of the value.
func (e CustomerType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CustomerType) IsKnown() bool {
	for _, known := range AllCustomerTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

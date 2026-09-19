// this file is @generated
package meteroid

type CreditType string

// Known values of CreditType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CreditTypeCreditToBalance  CreditType = "CREDIT_TO_BALANCE"
	CreditTypeRefund           CreditType = "REFUND"
	CreditTypeDebtCancellation CreditType = "DEBT_CANCELLATION"
)

// AllCreditTypeValues lists every CreditType value known to this SDK version.
var AllCreditTypeValues = []CreditType{
	CreditTypeCreditToBalance,
	CreditTypeRefund,
	CreditTypeDebtCancellation,
}

// String returns the wire representation of the value.
func (e CreditType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CreditType) IsKnown() bool {
	for _, known := range AllCreditTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

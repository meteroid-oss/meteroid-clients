// this file is @generated
package meteroid

type PaymentTypeEnum string

// Known values of PaymentTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	PaymentTypeEnumPayment PaymentTypeEnum = "PAYMENT"
	PaymentTypeEnumRefund  PaymentTypeEnum = "REFUND"
)

// AllPaymentTypeEnumValues lists every PaymentTypeEnum value known to this SDK version.
var AllPaymentTypeEnumValues = []PaymentTypeEnum{
	PaymentTypeEnumPayment,
	PaymentTypeEnumRefund,
}

// String returns the wire representation of the value.
func (e PaymentTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e PaymentTypeEnum) IsKnown() bool {
	for _, known := range AllPaymentTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

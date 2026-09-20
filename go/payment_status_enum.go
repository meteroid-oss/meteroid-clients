// this file is @generated
package meteroid

type PaymentStatusEnum string

// Known values of PaymentStatusEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	PaymentStatusEnumReady     PaymentStatusEnum = "READY"
	PaymentStatusEnumPending   PaymentStatusEnum = "PENDING"
	PaymentStatusEnumSettled   PaymentStatusEnum = "SETTLED"
	PaymentStatusEnumCancelled PaymentStatusEnum = "CANCELLED"
	PaymentStatusEnumFailed    PaymentStatusEnum = "FAILED"
	PaymentStatusEnumRefunded  PaymentStatusEnum = "REFUNDED"
)

// AllPaymentStatusEnumValues lists every PaymentStatusEnum value known to this SDK version.
var AllPaymentStatusEnumValues = []PaymentStatusEnum{
	PaymentStatusEnumReady,
	PaymentStatusEnumPending,
	PaymentStatusEnumSettled,
	PaymentStatusEnumCancelled,
	PaymentStatusEnumFailed,
	PaymentStatusEnumRefunded,
}

// String returns the wire representation of the value.
func (e PaymentStatusEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e PaymentStatusEnum) IsKnown() bool {
	for _, known := range AllPaymentStatusEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

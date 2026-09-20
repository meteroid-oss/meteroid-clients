// this file is @generated
package meteroid

type PaymentMethodTypeEnum string

// Known values of PaymentMethodTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	PaymentMethodTypeEnumCard         PaymentMethodTypeEnum = "CARD"
	PaymentMethodTypeEnumBankTransfer PaymentMethodTypeEnum = "BANK_TRANSFER"
	PaymentMethodTypeEnumWallet       PaymentMethodTypeEnum = "WALLET"
	PaymentMethodTypeEnumOther        PaymentMethodTypeEnum = "OTHER"
)

// AllPaymentMethodTypeEnumValues lists every PaymentMethodTypeEnum value known to this SDK version.
var AllPaymentMethodTypeEnumValues = []PaymentMethodTypeEnum{
	PaymentMethodTypeEnumCard,
	PaymentMethodTypeEnumBankTransfer,
	PaymentMethodTypeEnumWallet,
	PaymentMethodTypeEnumOther,
}

// String returns the wire representation of the value.
func (e PaymentMethodTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e PaymentMethodTypeEnum) IsKnown() bool {
	for _, known := range AllPaymentMethodTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

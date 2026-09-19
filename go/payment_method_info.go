// this file is @generated
package meteroid

type PaymentMethodInfo struct {
	AccountNumberHint *string `json:"account_number_hint,omitempty"`

	CardBrand *string `json:"card_brand,omitempty"`

	CardLast4 *string `json:"card_last4,omitempty"`

	PaymentMethodType PaymentMethodTypeEnum `json:"payment_method_type"`
}

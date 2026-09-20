// this file is @generated
package meteroid

import "time"

type Transaction struct {
	Amount int64 `json:"amount"`

	Currency string `json:"currency"`

	Error *string `json:"error,omitempty"`

	Id PaymentTransactionId `json:"id"`

	PaymentMethodId *CustomerPaymentMethodId `json:"payment_method_id,omitempty"`

	PaymentMethodInfo *PaymentMethodInfo `json:"payment_method_info,omitempty"`

	PaymentType PaymentTypeEnum `json:"payment_type"`

	// RFC 3339 timestamp.
	ProcessedAt *time.Time `json:"processed_at,omitempty"`

	ProviderTransactionId *string `json:"provider_transaction_id,omitempty"`

	Status PaymentStatusEnum `json:"status"`
}

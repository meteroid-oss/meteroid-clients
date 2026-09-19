// this file is @generated
package meteroid

type QuoteEventData struct {
	CustomerId CustomerId `json:"customer_id"`

	QuoteId QuoteId `json:"quote_id"`

	SubscriptionId *SubscriptionId `json:"subscription_id,omitempty"`
}

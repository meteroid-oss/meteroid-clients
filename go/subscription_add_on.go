// this file is @generated
package meteroid

type SubscriptionAddOn struct {
	AddOnId *AddOnId `json:"add_on_id,omitempty"`

	Fee SubscriptionFee `json:"fee"`

	Id *SubscriptionAddOnId `json:"id,omitempty"`

	Name string `json:"name"`

	Period SubscriptionFeeBillingPeriodEnum `json:"period"`

	Quantity int32 `json:"quantity"`
}

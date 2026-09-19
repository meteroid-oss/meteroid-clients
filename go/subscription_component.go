// this file is @generated
package meteroid

type SubscriptionComponent struct {
	Fee SubscriptionFee `json:"fee"`

	Name string `json:"name"`

	Period SubscriptionFeeBillingPeriodEnum `json:"period"`

	PriceComponentId *PriceComponentId `json:"price_component_id,omitempty"`

	ProductId *ProductId `json:"product_id,omitempty"`
}

// this file is @generated
package meteroid

type CreateSubscriptionAddOn struct {
	AddOnId AddOnId `json:"add_on_id"`

	Customization *SubscriptionAddOnCustomization `json:"customization,omitempty"`

	Quantity *int32 `json:"quantity,omitempty"`
}

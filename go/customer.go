// this file is @generated
package meteroid

type Customer struct {
	Alias *string `json:"alias,omitempty"`

	BillingAddress *Address `json:"billing_address,omitempty"`

	BillingEmail *string `json:"billing_email,omitempty"`

	ConnectedAccountId *string `json:"connected_account_id,omitempty"`

	Currency Currency `json:"currency"`

	// User-defined custom property values, keyed by definition `key`.
	CustomProperties RequiredMap[any] `json:"custom_properties"`

	CustomTaxes RequiredSlice[CustomTaxRate] `json:"custom_taxes"`

	Id CustomerId `json:"id"`

	InvoicingEmails RequiredSlice[string] `json:"invoicing_emails"`

	InvoicingEntityId InvoicingEntityId `json:"invoicing_entity_id"`

	// Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
	InvoicingLanguage *string `json:"invoicing_language,omitempty"`

	Name string `json:"name"`

	Phone *string `json:"phone,omitempty"`

	ShippingAddress *ShippingAddress `json:"shipping_address,omitempty"`

	VatNumber *string `json:"vat_number,omitempty"`
}

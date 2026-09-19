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

	CustomerType *CustomerType `json:"customer_type,omitempty"`

	FirstName *string `json:"first_name,omitempty"`

	Id CustomerId `json:"id"`

	InvoicingEmails RequiredSlice[string] `json:"invoicing_emails"`

	InvoicingEntityId InvoicingEntityId `json:"invoicing_entity_id"`

	// Deprecated: the first entry of `preferred_locales`.
	// Deprecated: this field is deprecated in the Meteroid API.
	InvoicingLanguage *string `json:"invoicing_language,omitempty"`

	LastName *string `json:"last_name,omitempty"`

	// BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
	LegalNumber *string `json:"legal_number,omitempty"`

	Name string `json:"name"`

	Phone *string `json:"phone,omitempty"`

	// Preferred document languages, most-preferred first (BCP-47 tags, e.g.
	// `["fr-FR", "en"]`); overrides the invoicing entity default.
	PreferredLocales RequiredSlice[string] `json:"preferred_locales"`

	ShippingAddress *ShippingAddress `json:"shipping_address,omitempty"`

	VatNumber *string `json:"vat_number,omitempty"`
}

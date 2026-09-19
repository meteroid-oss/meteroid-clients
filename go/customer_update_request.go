// this file is @generated
package meteroid

type CustomerUpdateRequest struct {
	Alias *string `json:"alias,omitempty"`

	BillingAddress *Address `json:"billing_address,omitempty"`

	BillingEmail *string `json:"billing_email,omitempty"`

	Currency Currency `json:"currency"`

	// User-defined custom property values (full replace). Omit to leave unchanged.
	CustomProperties map[string]any `json:"custom_properties,omitempty"`

	CustomTaxes RequiredSlice[CustomTaxRate] `json:"custom_taxes"`

	// Free-text legal exemption mention surfaced on exempt invoices.
	ExemptionReason *string `json:"exemption_reason,omitempty"`

	InvoicingEmails RequiredSlice[string] `json:"invoicing_emails"`

	InvoicingEntityId InvoicingEntityId `json:"invoicing_entity_id"`

	// Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
	// Omit or send `""` to reset to the invoicing entity default (full-replace update).
	// Unsupported languages fall back to `en-US` when rendering.
	InvoicingLanguage *string `json:"invoicing_language,omitempty"`

	IsTaxExempt *bool `json:"is_tax_exempt,omitempty"`

	Name string `json:"name"`

	Phone *string `json:"phone,omitempty"`

	ShippingAddress *ShippingAddress `json:"shipping_address,omitempty"`

	VatNumber *string `json:"vat_number,omitempty"`
}

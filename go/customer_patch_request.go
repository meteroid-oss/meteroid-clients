// this file is @generated
package meteroid

type CustomerPatchRequest struct {
	Alias *string `json:"alias,omitempty"`

	BillingAddress *Address `json:"billing_address,omitempty"`

	BillingEmail *string `json:"billing_email,omitempty"`

	Currency *Currency `json:"currency,omitempty"`

	// Partial update of custom property values (merge; send a key with `null` to remove it).
	// Omit to leave unchanged.
	CustomProperties map[string]any `json:"custom_properties,omitempty"`

	CustomTaxes []CustomTaxRate `json:"custom_taxes,omitempty"`

	// Free-text legal exemption mention surfaced on exempt invoices.
	ExemptionReason *string `json:"exemption_reason,omitempty"`

	InvoicingEmails []string `json:"invoicing_emails,omitempty"`

	InvoicingEntityId *InvoicingEntityId `json:"invoicing_entity_id,omitempty"`

	// Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
	// Omit to leave unchanged, send `""` to reset to the invoicing entity default.
	// Unsupported languages fall back to `en-US` when rendering.
	InvoicingLanguage *string `json:"invoicing_language,omitempty"`

	IsTaxExempt *bool `json:"is_tax_exempt,omitempty"`

	Name *string `json:"name,omitempty"`

	Phone *string `json:"phone,omitempty"`

	ShippingAddress *ShippingAddress `json:"shipping_address,omitempty"`

	VatNumber *string `json:"vat_number,omitempty"`
}

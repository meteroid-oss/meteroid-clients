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

	CustomerType *CustomerType `json:"customer_type,omitempty"`

	// Free-text legal exemption mention surfaced on exempt invoices.
	ExemptionReason *string `json:"exemption_reason,omitempty"`

	// Omit to keep the stored value (a full replace does not blank a person's name).
	FirstName *string `json:"first_name,omitempty"`

	InvoicingEmails RequiredSlice[string] `json:"invoicing_emails"`

	InvoicingEntityId InvoicingEntityId `json:"invoicing_entity_id"`

	// Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
	// Deprecated: this field is deprecated in the Meteroid API.
	InvoicingLanguage *string `json:"invoicing_language,omitempty"`

	IsTaxExempt *bool `json:"is_tax_exempt,omitempty"`

	LastName *string `json:"last_name,omitempty"`

	// BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
	LegalNumber *string `json:"legal_number,omitempty"`

	// Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
	Name *string `json:"name,omitempty"`

	Phone *string `json:"phone,omitempty"`

	// Preferred document languages, most-preferred first (BCP-47 tags, e.g.
	// `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to
	// reset to that default (full-replace update).
	PreferredLocales []string `json:"preferred_locales,omitempty"`

	ShippingAddress *ShippingAddress `json:"shipping_address,omitempty"`

	VatNumber *string `json:"vat_number,omitempty"`
}

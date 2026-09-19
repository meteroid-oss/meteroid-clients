// this file is @generated
package meteroid

type TaxBreakdownItem struct {
	// Free-text legal exemption mention (EU exempt/reverse-charge invoices).
	ExemptionReason *string `json:"exemption_reason,omitempty"`

	ExemptionType *TaxExemptionType `json:"exemption_type,omitempty"`

	Name string `json:"name"`

	TaxAmount int64 `json:"tax_amount"`

	TaxRate string `json:"tax_rate"`

	// Accounting/reporting code of the tax rate for this line, for exports.
	TaxReference *string `json:"tax_reference,omitempty"`

	TaxableAmount int64 `json:"taxable_amount"`
}

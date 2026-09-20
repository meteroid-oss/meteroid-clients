// this file is @generated
package meteroid

type InvoiceLineItem struct {
	AmountTotal int64 `json:"amount_total"`

	Description *string `json:"description,omitempty"`

	EndDate string `json:"end_date"`

	Name string `json:"name"`

	Quantity *string `json:"quantity,omitempty"`

	StartDate string `json:"start_date"`

	SubLineItems RequiredSlice[SubLineItem] `json:"sub_line_items"`

	TaxRate string `json:"tax_rate"`

	UnitPrice *string `json:"unit_price,omitempty"`
}

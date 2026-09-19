// this file is @generated
package meteroid

// Merge update of an invoice's custom property values (send a key with `null` to remove it).
// Allowed at any status — custom properties stay editable after the invoice is finalized.
type InvoiceCustomPropertiesRequest struct {
	CustomProperties RequiredMap[any] `json:"custom_properties"`
}

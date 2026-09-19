// this file is @generated
package meteroid

// Merge update of a credit note's custom property values (send a key with `null` to remove it).
// Allowed at any status — custom properties stay editable after the credit note is finalized.
type CreditNoteCustomPropertiesRequest struct {
	CustomProperties RequiredMap[any] `json:"custom_properties"`
}

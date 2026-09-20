// this file is @generated
package meteroid

import "encoding/json"

// Merge update of a credit note's custom property values (send a key with `null` to remove it).
// Allowed at any status — custom properties stay editable after the credit note is finalized.
type CreditNoteCustomPropertiesRequest struct {
	CustomProperties json.RawMessage `json:"custom_properties"`
}

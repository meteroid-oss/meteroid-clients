// this file is @generated
package meteroid

// One rule the document did not satisfy, in the standard's own vocabulary.
type EInvoicingFinding struct {
	Hint *string `json:"hint,omitempty"`

	Message string `json:"message"`

	// The rule identifier — "BR-11", "PEPPOL-EN16931-R003".
	Rule string `json:"rule"`

	// The business term path it is about — "BG-8/BT-55".
	Term string `json:"term"`
}

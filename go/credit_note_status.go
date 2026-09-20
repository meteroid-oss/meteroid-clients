// this file is @generated
package meteroid

type CreditNoteStatus string

// Known values of CreditNoteStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CreditNoteStatusDraft     CreditNoteStatus = "DRAFT"
	CreditNoteStatusFinalized CreditNoteStatus = "FINALIZED"
	CreditNoteStatusVoided    CreditNoteStatus = "VOIDED"
)

// AllCreditNoteStatusValues lists every CreditNoteStatus value known to this SDK version.
var AllCreditNoteStatusValues = []CreditNoteStatus{
	CreditNoteStatusDraft,
	CreditNoteStatusFinalized,
	CreditNoteStatusVoided,
}

// String returns the wire representation of the value.
func (e CreditNoteStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CreditNoteStatus) IsKnown() bool {
	for _, known := range AllCreditNoteStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

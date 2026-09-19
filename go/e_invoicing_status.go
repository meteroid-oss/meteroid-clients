// this file is @generated
package meteroid

// Whether the structured e-invoice was produced with the accounting PDF. Absent when the
// invoicing entity had not opted in at the time the invoice was issued.
type EInvoicingStatus string

// Known values of EInvoicingStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	EInvoicingStatusGenerated EInvoicingStatus = "GENERATED"
	EInvoicingStatusFailed    EInvoicingStatus = "FAILED"
)

// AllEInvoicingStatusValues lists every EInvoicingStatus value known to this SDK version.
var AllEInvoicingStatusValues = []EInvoicingStatus{
	EInvoicingStatusGenerated,
	EInvoicingStatusFailed,
}

// String returns the wire representation of the value.
func (e EInvoicingStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e EInvoicingStatus) IsKnown() bool {
	for _, known := range AllEInvoicingStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

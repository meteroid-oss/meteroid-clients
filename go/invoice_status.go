// this file is @generated
package meteroid

type InvoiceStatus string

// Known values of InvoiceStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	InvoiceStatusDraft         InvoiceStatus = "DRAFT"
	InvoiceStatusFinalized     InvoiceStatus = "FINALIZED"
	InvoiceStatusUncollectible InvoiceStatus = "UNCOLLECTIBLE"
	InvoiceStatusVoid          InvoiceStatus = "VOID"
	InvoiceStatusClosed        InvoiceStatus = "CLOSED"
)

// AllInvoiceStatusValues lists every InvoiceStatus value known to this SDK version.
var AllInvoiceStatusValues = []InvoiceStatus{
	InvoiceStatusDraft,
	InvoiceStatusFinalized,
	InvoiceStatusUncollectible,
	InvoiceStatusVoid,
	InvoiceStatusClosed,
}

// String returns the wire representation of the value.
func (e InvoiceStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e InvoiceStatus) IsKnown() bool {
	for _, known := range AllInvoiceStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

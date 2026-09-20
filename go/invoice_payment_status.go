// this file is @generated
package meteroid

type InvoicePaymentStatus string

// Known values of InvoicePaymentStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	InvoicePaymentStatusUnpaid        InvoicePaymentStatus = "UNPAID"
	InvoicePaymentStatusPartiallyPaid InvoicePaymentStatus = "PARTIALLY_PAID"
	InvoicePaymentStatusPaid          InvoicePaymentStatus = "PAID"
	InvoicePaymentStatusErrored       InvoicePaymentStatus = "ERRORED"
	InvoicePaymentStatusProcessing    InvoicePaymentStatus = "PROCESSING"
)

// AllInvoicePaymentStatusValues lists every InvoicePaymentStatus value known to this SDK version.
var AllInvoicePaymentStatusValues = []InvoicePaymentStatus{
	InvoicePaymentStatusUnpaid,
	InvoicePaymentStatusPartiallyPaid,
	InvoicePaymentStatusPaid,
	InvoicePaymentStatusErrored,
	InvoicePaymentStatusProcessing,
}

// String returns the wire representation of the value.
func (e InvoicePaymentStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e InvoicePaymentStatus) IsKnown() bool {
	for _, known := range AllInvoicePaymentStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

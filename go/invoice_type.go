// this file is @generated
package meteroid

type InvoiceType string

// Known values of InvoiceType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	InvoiceTypeRecurring      InvoiceType = "RECURRING"
	InvoiceTypeOneOff         InvoiceType = "ONE_OFF"
	InvoiceTypeAdjustment     InvoiceType = "ADJUSTMENT"
	InvoiceTypeUsageThreshold InvoiceType = "USAGE_THRESHOLD"
)

// AllInvoiceTypeValues lists every InvoiceType value known to this SDK version.
var AllInvoiceTypeValues = []InvoiceType{
	InvoiceTypeRecurring,
	InvoiceTypeOneOff,
	InvoiceTypeAdjustment,
	InvoiceTypeUsageThreshold,
}

// String returns the wire representation of the value.
func (e InvoiceType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e InvoiceType) IsKnown() bool {
	for _, known := range AllInvoiceTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

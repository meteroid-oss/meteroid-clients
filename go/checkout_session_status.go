// this file is @generated
package meteroid

type CheckoutSessionStatus string

// Known values of CheckoutSessionStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CheckoutSessionStatusCreated         CheckoutSessionStatus = "CREATED"
	CheckoutSessionStatusAwaitingPayment CheckoutSessionStatus = "AWAITING_PAYMENT"
	CheckoutSessionStatusCompleted       CheckoutSessionStatus = "COMPLETED"
	CheckoutSessionStatusExpired         CheckoutSessionStatus = "EXPIRED"
	CheckoutSessionStatusCancelled       CheckoutSessionStatus = "CANCELLED"
)

// AllCheckoutSessionStatusValues lists every CheckoutSessionStatus value known to this SDK version.
var AllCheckoutSessionStatusValues = []CheckoutSessionStatus{
	CheckoutSessionStatusCreated,
	CheckoutSessionStatusAwaitingPayment,
	CheckoutSessionStatusCompleted,
	CheckoutSessionStatusExpired,
	CheckoutSessionStatusCancelled,
}

// String returns the wire representation of the value.
func (e CheckoutSessionStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CheckoutSessionStatus) IsKnown() bool {
	for _, known := range AllCheckoutSessionStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

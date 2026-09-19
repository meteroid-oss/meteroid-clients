// this file is @generated
package meteroid

type CheckoutType string

// Known values of CheckoutType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	CheckoutTypeSelfServe              CheckoutType = "SELF_SERVE"
	CheckoutTypeSubscriptionActivation CheckoutType = "SUBSCRIPTION_ACTIVATION"
	CheckoutTypePlanChange             CheckoutType = "PLAN_CHANGE"
	CheckoutTypeAddonPurchase          CheckoutType = "ADDON_PURCHASE"
)

// AllCheckoutTypeValues lists every CheckoutType value known to this SDK version.
var AllCheckoutTypeValues = []CheckoutType{
	CheckoutTypeSelfServe,
	CheckoutTypeSubscriptionActivation,
	CheckoutTypePlanChange,
	CheckoutTypeAddonPurchase,
}

// String returns the wire representation of the value.
func (e CheckoutType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e CheckoutType) IsKnown() bool {
	for _, known := range AllCheckoutTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type SubscriptionActivationConditionEnum string

// Known values of SubscriptionActivationConditionEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SubscriptionActivationConditionEnumOnStart    SubscriptionActivationConditionEnum = "ON_START"
	SubscriptionActivationConditionEnumOnCheckout SubscriptionActivationConditionEnum = "ON_CHECKOUT"
	SubscriptionActivationConditionEnumManual     SubscriptionActivationConditionEnum = "MANUAL"
)

// AllSubscriptionActivationConditionEnumValues lists every SubscriptionActivationConditionEnum value known to this SDK version.
var AllSubscriptionActivationConditionEnumValues = []SubscriptionActivationConditionEnum{
	SubscriptionActivationConditionEnumOnStart,
	SubscriptionActivationConditionEnumOnCheckout,
	SubscriptionActivationConditionEnumManual,
}

// String returns the wire representation of the value.
func (e SubscriptionActivationConditionEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SubscriptionActivationConditionEnum) IsKnown() bool {
	for _, known := range AllSubscriptionActivationConditionEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

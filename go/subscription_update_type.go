// this file is @generated
package meteroid

// Identifies which mutation triggered a `subscription.updated` webhook.
type SubscriptionUpdateType string

// Known values of SubscriptionUpdateType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SubscriptionUpdateTypeActivated                   SubscriptionUpdateType = "activated"
	SubscriptionUpdateTypeTrialEnded                  SubscriptionUpdateType = "trial_ended"
	SubscriptionUpdateTypeBillingConfigurationUpdated SubscriptionUpdateType = "billing_configuration_updated"
	SubscriptionUpdateTypePlanChanged                 SubscriptionUpdateType = "plan_changed"
	SubscriptionUpdateTypeAmended                     SubscriptionUpdateType = "amended"
	SubscriptionUpdateTypeUnitsChanged                SubscriptionUpdateType = "units_changed"
	SubscriptionUpdateTypePaused                      SubscriptionUpdateType = "paused"
	SubscriptionUpdateTypeCancellationScheduled       SubscriptionUpdateType = "cancellation_scheduled"
)

// AllSubscriptionUpdateTypeValues lists every SubscriptionUpdateType value known to this SDK version.
var AllSubscriptionUpdateTypeValues = []SubscriptionUpdateType{
	SubscriptionUpdateTypeActivated,
	SubscriptionUpdateTypeTrialEnded,
	SubscriptionUpdateTypeBillingConfigurationUpdated,
	SubscriptionUpdateTypePlanChanged,
	SubscriptionUpdateTypeAmended,
	SubscriptionUpdateTypeUnitsChanged,
	SubscriptionUpdateTypePaused,
	SubscriptionUpdateTypeCancellationScheduled,
}

// String returns the wire representation of the value.
func (e SubscriptionUpdateType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SubscriptionUpdateType) IsKnown() bool {
	for _, known := range AllSubscriptionUpdateTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type SubscriptionStatusEnum string

// Known values of SubscriptionStatusEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SubscriptionStatusEnumPendingActivation SubscriptionStatusEnum = "PENDING_ACTIVATION"
	SubscriptionStatusEnumPendingCharge     SubscriptionStatusEnum = "PENDING_CHARGE"
	SubscriptionStatusEnumTrialActive       SubscriptionStatusEnum = "TRIAL_ACTIVE"
	SubscriptionStatusEnumActive            SubscriptionStatusEnum = "ACTIVE"
	SubscriptionStatusEnumTrialExpired      SubscriptionStatusEnum = "TRIAL_EXPIRED"
	SubscriptionStatusEnumPaused            SubscriptionStatusEnum = "PAUSED"
	SubscriptionStatusEnumSuspended         SubscriptionStatusEnum = "SUSPENDED"
	SubscriptionStatusEnumCancelled         SubscriptionStatusEnum = "CANCELLED"
	SubscriptionStatusEnumAborted           SubscriptionStatusEnum = "ABORTED"
	SubscriptionStatusEnumCompleted         SubscriptionStatusEnum = "COMPLETED"
	SubscriptionStatusEnumSuperseded        SubscriptionStatusEnum = "SUPERSEDED"
	SubscriptionStatusEnumErrored           SubscriptionStatusEnum = "ERRORED"
)

// AllSubscriptionStatusEnumValues lists every SubscriptionStatusEnum value known to this SDK version.
var AllSubscriptionStatusEnumValues = []SubscriptionStatusEnum{
	SubscriptionStatusEnumPendingActivation,
	SubscriptionStatusEnumPendingCharge,
	SubscriptionStatusEnumTrialActive,
	SubscriptionStatusEnumActive,
	SubscriptionStatusEnumTrialExpired,
	SubscriptionStatusEnumPaused,
	SubscriptionStatusEnumSuspended,
	SubscriptionStatusEnumCancelled,
	SubscriptionStatusEnumAborted,
	SubscriptionStatusEnumCompleted,
	SubscriptionStatusEnumSuperseded,
	SubscriptionStatusEnumErrored,
}

// String returns the wire representation of the value.
func (e SubscriptionStatusEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SubscriptionStatusEnum) IsKnown() bool {
	for _, known := range AllSubscriptionStatusEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

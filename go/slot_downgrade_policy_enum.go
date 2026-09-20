// this file is @generated
package meteroid

type SlotDowngradePolicyEnum string

// Known values of SlotDowngradePolicyEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SlotDowngradePolicyEnumRemoveAtEndOfPeriod SlotDowngradePolicyEnum = "REMOVE_AT_END_OF_PERIOD"
)

// AllSlotDowngradePolicyEnumValues lists every SlotDowngradePolicyEnum value known to this SDK version.
var AllSlotDowngradePolicyEnumValues = []SlotDowngradePolicyEnum{
	SlotDowngradePolicyEnumRemoveAtEndOfPeriod,
}

// String returns the wire representation of the value.
func (e SlotDowngradePolicyEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SlotDowngradePolicyEnum) IsKnown() bool {
	for _, known := range AllSlotDowngradePolicyEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

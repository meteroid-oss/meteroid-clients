// this file is @generated
package meteroid

type SlotUpgradePolicyEnum string

// Known values of SlotUpgradePolicyEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SlotUpgradePolicyEnumProrated SlotUpgradePolicyEnum = "PRORATED"
)

// AllSlotUpgradePolicyEnumValues lists every SlotUpgradePolicyEnum value known to this SDK version.
var AllSlotUpgradePolicyEnumValues = []SlotUpgradePolicyEnum{
	SlotUpgradePolicyEnumProrated,
}

// String returns the wire representation of the value.
func (e SlotUpgradePolicyEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SlotUpgradePolicyEnum) IsKnown() bool {
	for _, known := range AllSlotUpgradePolicyEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

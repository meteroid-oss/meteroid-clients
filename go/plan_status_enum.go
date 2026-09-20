// this file is @generated
package meteroid

type PlanStatusEnum string

// Known values of PlanStatusEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	PlanStatusEnumDraft    PlanStatusEnum = "DRAFT"
	PlanStatusEnumActive   PlanStatusEnum = "ACTIVE"
	PlanStatusEnumInactive PlanStatusEnum = "INACTIVE"
	PlanStatusEnumArchived PlanStatusEnum = "ARCHIVED"
)

// AllPlanStatusEnumValues lists every PlanStatusEnum value known to this SDK version.
var AllPlanStatusEnumValues = []PlanStatusEnum{
	PlanStatusEnumDraft,
	PlanStatusEnumActive,
	PlanStatusEnumInactive,
	PlanStatusEnumArchived,
}

// String returns the wire representation of the value.
func (e PlanStatusEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e PlanStatusEnum) IsKnown() bool {
	for _, known := range AllPlanStatusEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

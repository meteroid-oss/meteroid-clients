// this file is @generated
package meteroid

type PlanTypeEnum string

// Known values of PlanTypeEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	PlanTypeEnumStandard PlanTypeEnum = "STANDARD"
	PlanTypeEnumFree     PlanTypeEnum = "FREE"
	PlanTypeEnumCustom   PlanTypeEnum = "CUSTOM"
)

// AllPlanTypeEnumValues lists every PlanTypeEnum value known to this SDK version.
var AllPlanTypeEnumValues = []PlanTypeEnum{
	PlanTypeEnumStandard,
	PlanTypeEnumFree,
	PlanTypeEnumCustom,
}

// String returns the wire representation of the value.
func (e PlanTypeEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e PlanTypeEnum) IsKnown() bool {
	for _, known := range AllPlanTypeEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

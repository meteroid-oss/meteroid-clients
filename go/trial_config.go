// this file is @generated
package meteroid

type TrialConfig struct {
	DurationDays int32 `json:"duration_days"`

	IsFree bool `json:"is_free"`

	TrialingPlanId *PlanId `json:"trialing_plan_id,omitempty"`
}

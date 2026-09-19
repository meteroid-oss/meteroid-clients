// this file is @generated
package meteroid

type AvailableParameters struct {
	// Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL")
	BillingPeriods map[string][]BillingPeriodEnum `json:"billing_periods,omitempty"`

	// Map of component_id -> available capacity values
	CapacityThresholds map[string][]int64 `json:"capacity_thresholds,omitempty"`

	// List of component_ids that support slot parametrization (initial slot count)
	SlotComponents []string `json:"slot_components,omitempty"`
}

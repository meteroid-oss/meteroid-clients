// this file is @generated
package meteroid

// Capacity-based fee with included committed usage and overage
type CapacityPlanFee struct {
	Cadence BillingPeriodEnum `json:"cadence"`

	MetricId BillableMetricId `json:"metric_id"`

	Thresholds RequiredSlice[CapacityThreshold] `json:"thresholds"`
}

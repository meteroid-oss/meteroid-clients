// this file is @generated
package meteroid

type MeteredResolvedEntitlementValue struct {
	Enabled bool `json:"enabled"`

	Limit *string `json:"limit,omitempty"`

	MetricId BillableMetricId `json:"metric_id"`

	ResetPeriod ResetPeriod `json:"reset_period"`
}

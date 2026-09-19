// this file is @generated
package meteroid

type MetricUsage struct {
	GroupedUsage RequiredSlice[GroupedUsage] `json:"grouped_usage"`

	MetricCode string `json:"metric_code"`

	MetricId BillableMetricId `json:"metric_id"`

	MetricName string `json:"metric_name"`

	TotalValue string `json:"total_value"`
}

// this file is @generated
package meteroid

type UsageResponse struct {
	PeriodEnd string `json:"period_end"`

	PeriodStart string `json:"period_start"`

	Usage RequiredSlice[MetricUsage] `json:"usage"`
}

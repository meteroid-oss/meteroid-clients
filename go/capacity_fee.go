// this file is @generated
package meteroid

type CapacityFee struct {
	Included int64 `json:"included"`

	MetricId BillableMetricId `json:"metric_id"`

	OverageRate string `json:"overage_rate"`

	Rate string `json:"rate"`
}

// this file is @generated
package meteroid

// Usage-based fee
type UsagePlanFee struct {
	Cadence BillingPeriodEnum `json:"cadence"`

	MetricId BillableMetricId `json:"metric_id"`

	Pricing PlanUsagePricingModel `json:"pricing"`
}

// this file is @generated
package meteroid

import "time"

type MetricSummary struct {
	AggregationKey *string `json:"aggregation_key,omitempty"`

	AggregationType BillingMetricAggregateEnum `json:"aggregation_type"`

	// RFC 3339 timestamp.
	ArchivedAt *time.Time `json:"archived_at,omitempty"`

	Code string `json:"code"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	Id BillableMetricId `json:"id"`

	Name string `json:"name"`
}

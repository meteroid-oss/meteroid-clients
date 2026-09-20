// this file is @generated
package meteroid

import "time"

type Metric struct {
	AggregationKey *string `json:"aggregation_key,omitempty"`

	AggregationType BillingMetricAggregateEnum `json:"aggregation_type"`

	// RFC 3339 timestamp.
	ArchivedAt *time.Time `json:"archived_at,omitempty"`

	Code string `json:"code"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	Filters []MetricFilter `json:"filters,omitempty"`

	Id BillableMetricId `json:"id"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`

	ProductId *ProductId `json:"product_id,omitempty"`

	SegmentationMatrix *MetricSegmentationMatrix `json:"segmentation_matrix,omitempty"`

	UnitConversion *UnitConversion `json:"unit_conversion,omitempty"`

	UsageGroupKey *string `json:"usage_group_key,omitempty"`
}

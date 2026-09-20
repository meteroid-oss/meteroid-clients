// this file is @generated
package meteroid

import "time"

type MetricEventData struct {
	AggregationKey *string `json:"aggregation_key,omitempty"`

	AggregationType BillingMetricAggregateEnum `json:"aggregation_type"`

	Code string `json:"code"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	MetricId BillableMetricId `json:"metric_id"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`

	ProductId *ProductId `json:"product_id,omitempty"`

	SegmentationMatrix *MetricSegmentationMatrix `json:"segmentation_matrix,omitempty"`

	UnitConversionFactor *int32 `json:"unit_conversion_factor,omitempty"`

	UnitConversionRounding *UnitConversionRoundingEnum `json:"unit_conversion_rounding,omitempty"`

	UsageGroupKey *string `json:"usage_group_key,omitempty"`
}

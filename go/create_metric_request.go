// this file is @generated
package meteroid

type CreateMetricRequest struct {
	AggregationKey *string `json:"aggregation_key,omitempty"`

	AggregationType BillingMetricAggregateEnum `json:"aggregation_type"`

	Code string `json:"code"`

	Description *string `json:"description,omitempty"`

	// Pre-aggregation property filters. Optional and backward-compatible; omit for none.
	Filters []MetricFilter `json:"filters,omitempty"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`

	ProductId *ProductId `json:"product_id,omitempty"`

	SegmentationMatrix *MetricSegmentationMatrix `json:"segmentation_matrix,omitempty"`

	UnitConversion *UnitConversion `json:"unit_conversion,omitempty"`

	UsageGroupKey *string `json:"usage_group_key,omitempty"`
}

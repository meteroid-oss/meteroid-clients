// this file is @generated
package meteroid

type UpdateMetricRequest struct {
	Description *string `json:"description,omitempty"`

	// Absent = leave filters untouched; present (even empty) = replace them.
	Filters []MetricFilter `json:"filters,omitempty"`

	Name *string `json:"name,omitempty"`

	SegmentationMatrix *MetricSegmentationMatrix `json:"segmentation_matrix,omitempty"`

	UnitConversion *UnitConversion `json:"unit_conversion,omitempty"`
}

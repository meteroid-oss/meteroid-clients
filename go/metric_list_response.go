// this file is @generated
package meteroid

type MetricListResponse struct {
	Data RequiredSlice[MetricSummary] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

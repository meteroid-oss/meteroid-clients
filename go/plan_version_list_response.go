// this file is @generated
package meteroid

type PlanVersionListResponse struct {
	Data RequiredSlice[PlanVersionSummary] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

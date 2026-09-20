// this file is @generated
package meteroid

type PlanListResponse struct {
	Data RequiredSlice[Plan] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

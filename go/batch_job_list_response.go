// this file is @generated
package meteroid

type BatchJobListResponse struct {
	Data RequiredSlice[BatchJobResponse] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

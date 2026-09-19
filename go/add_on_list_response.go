// this file is @generated
package meteroid

type AddOnListResponse struct {
	Data RequiredSlice[AddOn] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

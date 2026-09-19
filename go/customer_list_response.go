// this file is @generated
package meteroid

type CustomerListResponse struct {
	Data RequiredSlice[Customer] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

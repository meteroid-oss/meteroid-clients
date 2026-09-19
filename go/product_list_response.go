// this file is @generated
package meteroid

type ProductListResponse struct {
	Data RequiredSlice[Product] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

// this file is @generated
package meteroid

type ProductFamilyListResponse struct {
	Data RequiredSlice[ProductFamily] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

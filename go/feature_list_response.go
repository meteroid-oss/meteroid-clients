// this file is @generated
package meteroid

type FeatureListResponse struct {
	Data RequiredSlice[Feature] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

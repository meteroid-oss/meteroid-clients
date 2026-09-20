// this file is @generated
package meteroid

type CustomPropertyDefinitionListResponse struct {
	Data RequiredSlice[CustomPropertyDefinition] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

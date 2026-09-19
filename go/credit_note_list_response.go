// this file is @generated
package meteroid

type CreditNoteListResponse struct {
	Data RequiredSlice[CreditNote] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

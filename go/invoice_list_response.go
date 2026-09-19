// this file is @generated
package meteroid

type InvoiceListResponse struct {
	Data RequiredSlice[Invoice] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

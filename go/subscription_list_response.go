// this file is @generated
package meteroid

type SubscriptionListResponse struct {
	Data RequiredSlice[Subscription] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

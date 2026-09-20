// this file is @generated
package meteroid

type CouponListResponse struct {
	Data RequiredSlice[Coupon] `json:"data"`

	PaginationMeta PaginationResponse `json:"pagination_meta"`
}

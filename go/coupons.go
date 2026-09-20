// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// CouponsListCouponsOptions carries the query and header parameters of
// Coupons.ListCoupons.
//
// Optional parameters are pointers; leave them nil to omit them.
type CouponsListCouponsOptions struct {
	Search *string

	Filter *CouponFilter

	// Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Coupons groups the coupons operations of the Meteroid API.
type Coupons struct {
	client *Client
}

func (a *Coupons) ListCoupons(ctx context.Context, options *CouponsListCouponsOptions) (*CouponListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/coupons")

	if options != nil {
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}
		if options.Filter != nil {
			req.SetQueryParam("filter", string(*options.Filter))
		}
		if options.OrderBy != nil {
			req.SetQueryParam("order_by", *options.OrderBy)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out CouponListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Coupons) CreateCoupon(ctx context.Context, createCouponRequest CreateCouponRequest) (*Coupon, error) {
	req := newRequest(http.MethodPost, "/api/v1/coupons")

	req.SetJSONBody(createCouponRequest)

	var out Coupon
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Coupons) GetCoupon(ctx context.Context, couponId string) (*Coupon, error) {
	req := newRequest(http.MethodGet, "/api/v1/coupons/{coupon_id}")
	req.SetPathParam("coupon_id", couponId)

	var out Coupon
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Coupons) UpdateCoupon(ctx context.Context, couponId string, updateCouponRequest UpdateCouponRequest) (*Coupon, error) {
	req := newRequest(http.MethodPatch, "/api/v1/coupons/{coupon_id}")
	req.SetPathParam("coupon_id", couponId)

	req.SetJSONBody(updateCouponRequest)

	var out Coupon
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Coupons) ArchiveCoupon(ctx context.Context, couponId string) error {
	req := newRequest(http.MethodPost, "/api/v1/coupons/{coupon_id}/archive")
	req.SetPathParam("coupon_id", couponId)

	return a.client.execute(ctx, req, nil)
}

func (a *Coupons) DisableCoupon(ctx context.Context, couponId string) error {
	req := newRequest(http.MethodPost, "/api/v1/coupons/{coupon_id}/disable")
	req.SetPathParam("coupon_id", couponId)

	return a.client.execute(ctx, req, nil)
}

func (a *Coupons) EnableCoupon(ctx context.Context, couponId string) error {
	req := newRequest(http.MethodPost, "/api/v1/coupons/{coupon_id}/enable")
	req.SetPathParam("coupon_id", couponId)

	return a.client.execute(ctx, req, nil)
}

func (a *Coupons) UnarchiveCoupon(ctx context.Context, couponId string) error {
	req := newRequest(http.MethodPost, "/api/v1/coupons/{coupon_id}/unarchive")
	req.SetPathParam("coupon_id", couponId)

	return a.client.execute(ctx, req, nil)
}

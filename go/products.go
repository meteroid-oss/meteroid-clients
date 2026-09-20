// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// ProductsListProductsOptions carries the query and header parameters of
// Products.ListProducts.
//
// Optional parameters are pointers; leave them nil to omit them.
type ProductsListProductsOptions struct {
	ProductFamilyId *ProductFamilyId

	Search *string

	// Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Products groups the products operations of the Meteroid API.
type Products struct {
	client *Client
}

func (a *Products) ListProducts(ctx context.Context, options *ProductsListProductsOptions) (*ProductListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/products")

	if options != nil {
		if options.ProductFamilyId != nil {
			req.SetQueryParam("product_family_id", string(*options.ProductFamilyId))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
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

	var out ProductListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Products) CreateProduct(ctx context.Context, createProductRequest CreateProductRequest) (*Product, error) {
	req := newRequest(http.MethodPost, "/api/v1/products")

	req.SetJSONBody(createProductRequest)

	var out Product
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Products) GetProduct(ctx context.Context, productId string) (*Product, error) {
	req := newRequest(http.MethodGet, "/api/v1/products/{product_id}")
	req.SetPathParam("product_id", productId)

	var out Product
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Partially update product fields. The fee_type is immutable and cannot be changed.
func (a *Products) UpdateProduct(ctx context.Context, productId string, updateProductRequest UpdateProductRequest) (*Product, error) {
	req := newRequest(http.MethodPatch, "/api/v1/products/{product_id}")
	req.SetPathParam("product_id", productId)

	req.SetJSONBody(updateProductRequest)

	var out Product
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Products) ArchiveProduct(ctx context.Context, productId string) error {
	req := newRequest(http.MethodPost, "/api/v1/products/{product_id}/archive")
	req.SetPathParam("product_id", productId)

	return a.client.execute(ctx, req, nil)
}

func (a *Products) ListProductEntitlements(ctx context.Context, productId string) (*ResolvedEntitlementListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/products/{product_id}/entitlements")
	req.SetPathParam("product_id", productId)

	var out ResolvedEntitlementListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Products) UnarchiveProduct(ctx context.Context, productId string) error {
	req := newRequest(http.MethodPost, "/api/v1/products/{product_id}/unarchive")
	req.SetPathParam("product_id", productId)

	return a.client.execute(ctx, req, nil)
}

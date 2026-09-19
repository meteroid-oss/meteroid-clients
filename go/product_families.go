// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// ProductFamiliesListProductFamiliesOptions carries the query and header parameters of
// ProductFamilies.ListProductFamilies.
//
// Optional parameters are pointers; leave them nil to omit them.
type ProductFamiliesListProductFamiliesOptions struct {
	// Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32

	Search *string
}

// ProductFamilies groups the product families operations of the Meteroid API.
type ProductFamilies struct {
	client *Client
}

func (a *ProductFamilies) ListProductFamilies(ctx context.Context, options *ProductFamiliesListProductFamiliesOptions) (*ProductFamilyListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/product_families")

	if options != nil {
		if options.OrderBy != nil {
			req.SetQueryParam("order_by", *options.OrderBy)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}
	}

	var out ProductFamilyListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *ProductFamilies) CreateProductFamily(ctx context.Context, productFamilyCreateRequest ProductFamilyCreateRequest) (*ProductFamily, error) {
	req := newRequest(http.MethodPost, "/api/v1/product_families")

	req.SetJSONBody(productFamilyCreateRequest)

	var out ProductFamily
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a single product family by ID or alias.
func (a *ProductFamilies) GetProductFamilyByIdOrAlias(ctx context.Context, idOrAlias string) (*ProductFamily, error) {
	req := newRequest(http.MethodGet, "/api/v1/product_families/{id_or_alias}")
	req.SetPathParam("id_or_alias", idOrAlias)

	var out ProductFamily
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

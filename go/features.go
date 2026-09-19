// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// FeaturesListFeaturesOptions carries the query and header parameters of
// Features.ListFeatures.
//
// Optional parameters are pointers; leave them nil to omit them.
type FeaturesListFeaturesOptions struct {
	// Filter by feature status. Repeat the param to select multiple, omit to return all.
	Statuses []FeatureStatus

	// Filter by product. Omit to return features across all products.
	ProductId *ProductId

	// Search by feature name.
	Search *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Features groups the features operations of the Meteroid API.
type Features struct {
	client *Client
}

func (a *Features) ListFeatures(ctx context.Context, options *FeaturesListFeaturesOptions) (*FeatureListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/features")

	if options != nil {

		if len(options.Statuses) > 0 {
			for _, item := range options.Statuses {
				req.AddQueryParam("statuses", string(item))
			}
		}
		if options.ProductId != nil {
			req.SetQueryParam("product_id", string(*options.ProductId))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out FeatureListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Features) GetFeature(ctx context.Context, idOrCode string) (*Feature, error) {
	req := newRequest(http.MethodGet, "/api/v1/features/{id_or_code}")
	req.SetPathParam("id_or_code", idOrCode)

	var out Feature
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

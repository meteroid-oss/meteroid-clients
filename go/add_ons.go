// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// AddOnsListAddonsOptions carries the query and header parameters of
// AddOns.ListAddons.
//
// Optional parameters are pointers; leave them nil to omit them.
type AddOnsListAddonsOptions struct {
	Search *string

	Currency *string

	// Include archived add-ons in the results (default: false)
	IncludeArchived *bool

	// Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// AddOns groups the add ons operations of the Meteroid API.
type AddOns struct {
	client *Client
}

func (a *AddOns) ListAddons(ctx context.Context, options *AddOnsListAddonsOptions) (*AddOnListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/addons")

	if options != nil {
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
		}
		if options.Currency != nil {
			req.SetQueryParam("currency", *options.Currency)
		}
		if options.IncludeArchived != nil {
			req.SetQueryParam("include_archived", formatBool(*options.IncludeArchived))
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

	var out AddOnListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *AddOns) CreateAddon(ctx context.Context, createAddOnRequest CreateAddOnRequest) (*AddOn, error) {
	req := newRequest(http.MethodPost, "/api/v1/addons")

	req.SetJSONBody(createAddOnRequest)

	var out AddOn
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *AddOns) GetAddon(ctx context.Context, addonId string) (*AddOn, error) {
	req := newRequest(http.MethodGet, "/api/v1/addons/{addon_id}")
	req.SetPathParam("addon_id", addonId)

	var out AddOn
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *AddOns) UpdateAddon(ctx context.Context, addonId string, updateAddOnRequest UpdateAddOnRequest) (*AddOn, error) {
	req := newRequest(http.MethodPatch, "/api/v1/addons/{addon_id}")
	req.SetPathParam("addon_id", addonId)

	req.SetJSONBody(updateAddOnRequest)

	var out AddOn
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *AddOns) ArchiveAddon(ctx context.Context, addonId string) error {
	req := newRequest(http.MethodPost, "/api/v1/addons/{addon_id}/archive")
	req.SetPathParam("addon_id", addonId)

	return a.client.execute(ctx, req, nil)
}

func (a *AddOns) ListAddOnEntitlements(ctx context.Context, addonId string) (*ResolvedEntitlementListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/addons/{addon_id}/entitlements")
	req.SetPathParam("addon_id", addonId)

	var out ResolvedEntitlementListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *AddOns) UnarchiveAddon(ctx context.Context, addonId string) error {
	req := newRequest(http.MethodPost, "/api/v1/addons/{addon_id}/unarchive")
	req.SetPathParam("addon_id", addonId)

	return a.client.execute(ctx, req, nil)
}

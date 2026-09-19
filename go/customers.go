// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// CustomersListCustomersOptions carries the query and header parameters of
// Customers.ListCustomers.
//
// Optional parameters are pointers; leave them nil to omit them.
type CustomersListCustomersOptions struct {
	// Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32

	Search *string

	Archived *bool
}

// Customers groups the customers operations of the Meteroid API.
type Customers struct {
	client *Client
}

// List customers with optional pagination and search filtering.
func (a *Customers) ListCustomers(ctx context.Context, options *CustomersListCustomersOptions) (*CustomerListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/customers")

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
		if options.Archived != nil {
			req.SetQueryParam("archived", formatBool(*options.Archived))
		}
	}

	var out CustomerListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Customers) CreateCustomer(ctx context.Context, customerCreateRequest CustomerCreateRequest) (*Customer, error) {
	req := newRequest(http.MethodPost, "/api/v1/customers")

	req.SetJSONBody(customerCreateRequest)

	var out Customer
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a single customer by ID or alias.
func (a *Customers) GetCustomer(ctx context.Context, idOrAlias string) (*Customer, error) {
	req := newRequest(http.MethodGet, "/api/v1/customers/{id_or_alias}")
	req.SetPathParam("id_or_alias", idOrAlias)

	var out Customer
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Customers) UpdateCustomer(ctx context.Context, idOrAlias string, customerUpdateRequest CustomerUpdateRequest) (*Customer, error) {
	req := newRequest(http.MethodPut, "/api/v1/customers/{id_or_alias}")
	req.SetPathParam("id_or_alias", idOrAlias)

	req.SetJSONBody(customerUpdateRequest)

	var out Customer
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail.
func (a *Customers) ArchiveCustomer(ctx context.Context, idOrAlias string) error {
	req := newRequest(http.MethodDelete, "/api/v1/customers/{id_or_alias}")
	req.SetPathParam("id_or_alias", idOrAlias)

	return a.client.execute(ctx, req, nil)
}

// Partially update a customer. Only provided fields will be updated.
func (a *Customers) PatchCustomer(ctx context.Context, idOrAlias string, customerPatchRequest CustomerPatchRequest) (*Customer, error) {
	req := newRequest(http.MethodPatch, "/api/v1/customers/{id_or_alias}")
	req.SetPathParam("id_or_alias", idOrAlias)

	req.SetJSONBody(customerPatchRequest)

	var out Customer
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Customers) GetEffectiveEntitlements(ctx context.Context, idOrAlias string) (*EffectiveEntitlementListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/customers/{id_or_alias}/entitlements")
	req.SetPathParam("id_or_alias", idOrAlias)

	var out EffectiveEntitlementListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Generates a JWT token that grants access to the customer portal.
// The token can be used to access invoices, payment methods, and other portal features.
func (a *Customers) CreatePortalToken(ctx context.Context, idOrAlias string, customerPortalTokenRequest CustomerPortalTokenRequest) (*CustomerPortalTokenResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/customers/{id_or_alias}/portal-token")
	req.SetPathParam("id_or_alias", idOrAlias)

	req.SetJSONBody(customerPortalTokenRequest)

	var out CustomerPortalTokenResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Customers) UnarchiveCustomer(ctx context.Context, idOrAlias string) error {
	req := newRequest(http.MethodPost, "/api/v1/customers/{id_or_alias}/unarchive")
	req.SetPathParam("id_or_alias", idOrAlias)

	return a.client.execute(ctx, req, nil)
}

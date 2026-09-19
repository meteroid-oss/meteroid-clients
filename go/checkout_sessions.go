// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// CheckoutSessionsListCheckoutSessionsOptions carries the query and header parameters of
// CheckoutSessions.ListCheckoutSessions.
//
// Optional parameters are pointers; leave them nil to omit them.
type CheckoutSessionsListCheckoutSessionsOptions struct {
	CustomerId *CustomerId

	Status *CheckoutSessionStatus
}

// CheckoutSessions groups the checkout sessions operations of the Meteroid API.
type CheckoutSessions struct {
	client *Client
}

func (a *CheckoutSessions) ListCheckoutSessions(ctx context.Context, options *CheckoutSessionsListCheckoutSessionsOptions) (*ListCheckoutSessionsResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/checkout-sessions")

	if options != nil {
		if options.CustomerId != nil {
			req.SetQueryParam("customer_id", string(*options.CustomerId))
		}
		if options.Status != nil {
			req.SetQueryParam("status", string(*options.Status))
		}
	}

	var out ListCheckoutSessionsResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CheckoutSessions) CreateCheckoutSession(ctx context.Context, createCheckoutSessionRequest CreateCheckoutSessionRequest) (*CreateCheckoutSessionResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/checkout-sessions")

	req.SetJSONBody(createCheckoutSessionRequest)

	var out CreateCheckoutSessionResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CheckoutSessions) GetCheckoutSession(ctx context.Context, id string) (*GetCheckoutSessionResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/checkout-sessions/{id}")
	req.SetPathParam("id", id)

	var out GetCheckoutSessionResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CheckoutSessions) CancelCheckoutSession(ctx context.Context, id string) (*CancelCheckoutSessionResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/checkout-sessions/{id}/cancel")
	req.SetPathParam("id", id)

	var out CancelCheckoutSessionResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

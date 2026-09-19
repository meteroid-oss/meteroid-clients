// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// Connect groups the connect operations of the Meteroid API.
type Connect struct {
	client *Client
}

// List all connected accounts for this platform.
func (a *Connect) ListConnectedAccounts(ctx context.Context) (*ConnectedAccountsResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/connected-accounts")

	var out ConnectedAccountsResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Create a new connected account (Express flow). Returns the account
// and an onboarding link for the user to complete setup.
func (a *Connect) CreateConnectedAccount(ctx context.Context, createConnectedAccountRequest CreateConnectedAccountRequest) (*ConnectedAccount, error) {
	req := newRequest(http.MethodPost, "/api/v1/connected-accounts")

	req.SetJSONBody(createConnectedAccountRequest)

	var out ConnectedAccount
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a connected account by ID.
func (a *Connect) GetConnectedAccount(ctx context.Context, id string) (*ConnectedAccount, error) {
	req := newRequest(http.MethodGet, "/api/v1/connected-accounts/{id}")
	req.SetPathParam("id", id)

	var out ConnectedAccount
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Revoke a connected account. All associated tokens are invalidated.
func (a *Connect) DisconnectAccount(ctx context.Context, id string) error {
	req := newRequest(http.MethodDelete, "/api/v1/connected-accounts/{id}")
	req.SetPathParam("id", id)

	return a.client.execute(ctx, req, nil)
}

// Generate a new onboarding link for a connected account. Any existing
// unused link is invalidated. The link expires after a configured duration.
func (a *Connect) CreateOnboardingLink(ctx context.Context, id string, createOnboardingLinkRequest CreateOnboardingLinkRequest) (*OnboardingLinkResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/connected-accounts/{id}/onboarding")
	req.SetPathParam("id", id)

	req.SetJSONBody(createOnboardingLinkRequest)

	var out OnboardingLinkResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// OAuthApps groups the o auth apps operations of the Meteroid API.
type OAuthApps struct {
	client *Client
}

// List all OAuth applications registered for this platform.
func (a *OAuthApps) ListOauthApps(ctx context.Context) (*OAuthAppsResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/oauth-apps")

	var out OAuthAppsResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Register a new OAuth application. Returns the app with its client secret
// (only shown once).
func (a *OAuthApps) CreateOauthApp(ctx context.Context, createOAuthAppRequest CreateOAuthAppRequest) (*OAuthAppWithSecret, error) {
	req := newRequest(http.MethodPost, "/api/v1/oauth-apps")

	req.SetJSONBody(createOAuthAppRequest)

	var out OAuthAppWithSecret
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve an OAuth application by ID.
func (a *OAuthApps) GetOauthApp(ctx context.Context, id string) (*OAuthApp, error) {
	req := newRequest(http.MethodGet, "/api/v1/oauth-apps/{id}")
	req.SetPathParam("id", id)

	var out OAuthApp
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Delete an OAuth application and revoke all associated tokens.
func (a *OAuthApps) DeleteOauthApp(ctx context.Context, id string) error {
	req := newRequest(http.MethodDelete, "/api/v1/oauth-apps/{id}")
	req.SetPathParam("id", id)

	return a.client.execute(ctx, req, nil)
}

// Generate a new client secret for an OAuth app. The old secret is
// immediately invalidated.
func (a *OAuthApps) RotateClientSecret(ctx context.Context, id string) (*RotatedSecret, error) {
	req := newRequest(http.MethodPost, "/api/v1/oauth-apps/{id}/rotate")
	req.SetPathParam("id", id)

	var out RotatedSecret
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

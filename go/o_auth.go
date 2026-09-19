// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// OAuth groups the o auth operations of the Meteroid API.
type OAuth struct {
	client *Client
}

// Token introspection endpoint (RFC 7662). Requires client credentials
// via HTTP Basic auth.
func (a *OAuth) IntrospectEndpoint(ctx context.Context, introspectionRequest IntrospectionRequest) (*TokenIntrospectionResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/oauth/introspect")

	req.SetFormBody(introspectionRequest)

	var out TokenIntrospectionResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Token revocation endpoint (RFC 7009). Always returns 200 per spec.
// Requires client credentials via HTTP Basic auth.
func (a *OAuth) RevokeEndpoint(ctx context.Context, revocationRequest RevocationRequest) error {
	req := newRequest(http.MethodPost, "/api/v1/oauth/revoke")

	req.SetFormBody(revocationRequest)

	return a.client.execute(ctx, req, nil)
}

// OAuth 2.0 token endpoint. Supports two grant types:
// - `authorization_code`: Exchange an authorization code for tokens
// - `refresh_token`: Refresh an access token
//
// Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.
func (a *OAuth) TokenEndpoint(ctx context.Context, tokenRequest TokenRequest) (*TokenResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/oauth/token")

	req.SetFormBody(tokenRequest)

	var out TokenResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

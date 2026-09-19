package main

import (
	"context"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

const (
	// defaultExpiry is Meteroid's default lifetime, in seconds.
	defaultExpiry int32 = 86_400
	minExpiry     int32 = 60
	maxExpiry     int32 = 2_592_000
)

// createPortalSession is `POST /api/portal-session` — mint a Meteroid customer-portal
// token.
//
// The portal is where the visitor manages their payment method and downloads invoices,
// so the demo does not have to implement any of it. The frontend opens `portal_url`
// with the `token`.
func (a *app) createPortalSession(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	body, err := optionalJSONBody(r, decodeCreatePortalSessionRequest)
	if err != nil {
		return nil, err
	}

	// Meteroid documents 60..2592000 but types the field as a plain int32, so the range
	// is validated here rather than forwarding a value Meteroid would reject.
	expiresInSeconds := defaultExpiry
	if body.ExpiresInSeconds != nil {
		expiresInSeconds = *body.ExpiresInSeconds
	}
	if expiresInSeconds < minExpiry || expiresInSeconds > maxExpiry {
		return nil, badRequest("expires_in_seconds must be between %d and %d.", minExpiry, maxExpiry)
	}

	portal, err := a.meteroid.Customers().CreatePortalToken(ctx, session.customerAlias, meteroid.CustomerPortalTokenRequest{
		ExpiresInSeconds: &expiresInSeconds,
	})
	if err != nil {
		return nil, upstream("POST /api/v1/customers/"+session.customerAlias+"/portal-token", err)
	}

	return replyCreated(CreatePortalSessionResponse{
		PortalURL: portal.PortalUrl,
		Token:     portal.Token,
		// Meteroid returns only `{ token, portal_url }`, so this echoes what was asked
		// for rather than pretending to read it back out of the JWT.
		ExpiresInSeconds: expiresInSeconds,
	})
}

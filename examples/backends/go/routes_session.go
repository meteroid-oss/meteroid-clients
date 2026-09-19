package main

import (
	"context"
	"crypto/rand"
	"encoding/hex"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// createSession is `POST /api/session`: create a brand-new Meteroid customer and hand
// back a session token bound to it.
//
// This is the only object the demo ever creates in Meteroid. The catalog is seeded
// once, by hand (examples/CATALOG.md); customers are per demo run and disposable.
func (a *app) createSession(ctx context.Context, r *request) (*reply, error) {
	body, err := optionalJSONBody(r, decodeCreateSessionRequest)
	if err != nil {
		return nil, err
	}

	// A short random alias is the workspace's identity everywhere: it is what the
	// session token carries, what ingested events reference, and what every idOrAlias
	// parameter below receives.
	alias := "scribe-demo-" + randomID()
	name, email := "Scribe demo workspace", alias+"@example.invalid"
	if body.WorkspaceName != nil {
		if name, err = bounded("workspace_name", *body.WorkspaceName, 120); err != nil {
			return nil, err
		}
	}
	if body.Email != nil {
		if email, err = bounded("email", *body.Email, 254); err != nil {
			return nil, err
		}
	}

	customer, err := a.meteroid.Customers().CreateCustomer(ctx, meteroid.CustomerCreateRequest{
		Alias: &alias,
		// Meteroid requires all four of these. The currency must match the seeded plans'
		// currency or checkout will refuse the plan version later on.
		Currency:        a.config.defaultCurrency,
		CustomTaxes:     []meteroid.CustomTaxRate{},
		InvoicingEmails: []string{email},
		Name:            name,
	})
	if err != nil {
		return nil, upstream("POST /api/v1/customers", err)
	}

	return replyCreated(CreateSessionResponse{
		SessionToken: mintToken(a.config.sessionSecret, alias),
		Workspace:    toWorkspace(customer, alias),
	})
}

// getMe is `GET /api/me`: the current workspace, its subscription, and the plan that
// subscription is on.
func (a *app) getMe(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	alias := session.customerAlias

	customer, err := a.loadCustomer(ctx, alias)
	if err != nil {
		return nil, err
	}
	subscription, err := a.currentSubscription(ctx, alias)
	if err != nil {
		return nil, err
	}

	// The plan is only looked up when there is a subscription to look it up for, so a
	// never-subscribed workspace works even before the catalog is reachable.
	me := MeResponse{Workspace: toWorkspace(customer, alias)}
	if subscription != nil {
		catalog, err := a.catalog(ctx)
		if err != nil {
			return nil, err
		}
		planCode := catalog.planCodeFor(subscription.PlanId, subscription.PlanName)
		me.Subscription = ptr(projectSubscription(subscription, planCode))
		if planCode != nil {
			if me.Plan, err = catalog.plan(*planCode); err != nil {
				return nil, err
			}
		}
	}
	return replyOK(me)
}

// projectSubscription: every field is a 1:1 projection of a Meteroid field — nothing is
// derived, so the demo's view and Meteroid's can never drift. In particular
// `trial_duration_days` is Meteroid's TrialDuration, not a computed trial end date.
//
// The SDK's optional fields are nil pointers, and so are the contract's: they go
// straight across and serialize as `null`.
func projectSubscription(subscription *meteroid.Subscription, planCode *PlanCode) Subscription {
	return Subscription{
		ID:                 subscription.Id,
		Status:             string(subscription.Status),
		PlanCode:           planCode,
		PlanName:           subscription.PlanName,
		PlanVersionID:      subscription.PlanVersionId,
		Currency:           string(subscription.Currency),
		CurrentPeriodStart: subscription.CurrentPeriodStart,
		CurrentPeriodEnd:   subscription.CurrentPeriodEnd,
		TrialDurationDays:  subscription.TrialDuration,
		CreatedAt:          timestamp(subscription.CreatedAt),
	}
}

// randomID is 32 hex characters of randomness, for aliases and transcription ids.
func randomID() string {
	var id [16]byte
	// crypto/rand.Read does not fail on any supported platform; it aborts instead.
	_, _ = rand.Read(id[:])
	return hex.EncodeToString(id[:])
}

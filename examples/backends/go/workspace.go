package main

import (
	"context"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// Per-workspace Meteroid lookups shared by several handlers.
//
// A "workspace" is one Meteroid **customer**. The demo addresses it everywhere by its
// *alias* (`scribe-demo-…`), never by the Meteroid id: every Meteroid endpoint the demo
// touches accepts an id or an alias, which is the point being demonstrated — you can
// drive Meteroid entirely from your own identifiers.

func (a *app) loadCustomer(ctx context.Context, alias string) (*meteroid.Customer, error) {
	customer, err := a.meteroid.Customers().GetCustomer(ctx, alias)
	if err != nil {
		return nil, upstream("GET /api/v1/customers/"+alias, err)
	}
	return customer, nil
}

// currentSubscription is the workspace's most relevant subscription, or nil if it has
// never checked out.
//
// The contract pins the rule down so every backend picks the same one: ask Meteroid for
// the customer's subscriptions newest-first, take the first ACTIVE or TRIAL_ACTIVE one,
// and otherwise the most recently created regardless of status.
func (a *app) currentSubscription(ctx context.Context, alias string) (*meteroid.Subscription, error) {
	// CustomerId accepts a Meteroid id *or* an external alias, so no id lookup first.
	response, err := a.meteroid.Subscriptions().ListSubscriptions(ctx, &meteroid.SubscriptionsListSubscriptionsOptions{
		CustomerId: &alias,
		OrderBy:    ptr("created_at.desc"),
		PerPage:    ptr(int32(100)),
	})
	if err != nil {
		return nil, upstream("GET /api/v1/subscriptions", err)
	}

	for i, subscription := range response.Data {
		// The statuses that count as "the subscription this workspace is living on".
		switch subscription.Status {
		case meteroid.SubscriptionStatusEnumActive, meteroid.SubscriptionStatusEnumTrialActive:
			return &response.Data[i], nil
		}
	}
	if len(response.Data) > 0 {
		return &response.Data[0], nil
	}
	return nil, nil
}

// toWorkspace projects a Meteroid customer onto the contract's `Workspace`.
//
// Note there is no `created_at`: Meteroid's `Customer` carries no creation timestamp,
// so the contract does not pretend it does.
func toWorkspace(customer *meteroid.Customer, fallbackAlias string) Workspace {
	alias := fallbackAlias
	if customer.Alias != nil {
		alias = *customer.Alias
	}
	return Workspace{
		ID:            alias,
		Name:          customer.Name,
		CustomerID:    customer.Id,
		CustomerAlias: alias,
		Currency:      string(customer.Currency),
	}
}

// upgradeTarget is the plan to offer when a workspace hits a wall (402 / 403).
//
// One plan up from where it is now: `pro` for an unsubscribed workspace or one on a
// plan outside the Scribe catalog, `scale` for a `pro` workspace, and nil on `scale` —
// there is nothing left to sell. It returns no error on purpose: this decorates an
// error response, and a failed lookup here must not replace the error the caller
// actually hit.
func (a *app) upgradeTarget(ctx context.Context, alias string) *PlanCode {
	subscription, err := a.currentSubscription(ctx, alias)
	if err != nil || subscription == nil {
		return ptr(planPro)
	}

	catalog, err := a.catalog(ctx)
	if err != nil {
		return nil
	}
	current := catalog.planCodeFor(subscription.PlanId, subscription.PlanName)
	if current == nil {
		return ptr(planPro)
	}
	return current.nextUp()
}

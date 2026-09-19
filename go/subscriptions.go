// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// SubscriptionsListSubscriptionsOptions carries the query and header parameters of
// Subscriptions.ListSubscriptions.
//
// Optional parameters are pointers; leave them nil to omit them.
type SubscriptionsListSubscriptionsOptions struct {
	// Filter by customer ID or alias
	CustomerId *string

	PlanId *PlanId

	Statuses []SubscriptionStatusEnum

	// Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Subscriptions groups the subscriptions operations of the Meteroid API.
type Subscriptions struct {
	client *Client
}

// List subscriptions with optional filtering by customer or plan.
func (a *Subscriptions) ListSubscriptions(ctx context.Context, options *SubscriptionsListSubscriptionsOptions) (*SubscriptionListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/subscriptions")

	if options != nil {
		if options.CustomerId != nil {
			req.SetQueryParam("customer_id", *options.CustomerId)
		}
		if options.PlanId != nil {
			req.SetQueryParam("plan_id", string(*options.PlanId))
		}

		if len(options.Statuses) > 0 {
			for _, item := range options.Statuses {
				req.AddQueryParam("statuses", string(item))
			}
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

	var out SubscriptionListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Create a new subscription for a customer with a specific plan.
func (a *Subscriptions) CreateSubscription(ctx context.Context, subscriptionCreateRequest SubscriptionCreateRequest) (*SubscriptionDetails, error) {
	req := newRequest(http.MethodPost, "/api/v1/subscriptions")

	req.SetJSONBody(subscriptionCreateRequest)

	var out SubscriptionDetails
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve detailed information about a subscription including price components and schedules.
func (a *Subscriptions) SubscriptionDetails(ctx context.Context, subscriptionId string) (*SubscriptionDetails, error) {
	req := newRequest(http.MethodGet, "/api/v1/subscriptions/{subscription_id}")
	req.SetPathParam("subscription_id", subscriptionId)

	var out SubscriptionDetails
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Update subscription settings like payment configuration, billing options, etc.
func (a *Subscriptions) UpdateSubscription(ctx context.Context, subscriptionId string, subscriptionUpdateRequest SubscriptionUpdateRequest) (*SubscriptionUpdateResponse, error) {
	req := newRequest(http.MethodPatch, "/api/v1/subscriptions/{subscription_id}")
	req.SetPathParam("subscription_id", subscriptionId)

	req.SetJSONBody(subscriptionUpdateRequest)

	var out SubscriptionUpdateResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Cancel a subscription either immediately or at the end of the billing period.
func (a *Subscriptions) CancelSubscription(ctx context.Context, subscriptionId string, cancelSubscriptionRequest CancelSubscriptionRequest) (*CancelSubscriptionResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/subscriptions/{subscription_id}/cancel")
	req.SetPathParam("subscription_id", subscriptionId)

	req.SetJSONBody(cancelSubscriptionRequest)

	var out CancelSubscriptionResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *Subscriptions) ListSubscriptionEntitlements(ctx context.Context, subscriptionId string) (*EffectiveEntitlementListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/subscriptions/{subscription_id}/entitlements")
	req.SetPathParam("subscription_id", subscriptionId)

	var out EffectiveEntitlementListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

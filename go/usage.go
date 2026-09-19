// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// UsageGetCustomerUsageOptions carries the query and header parameters of
// Usage.GetCustomerUsage.
//
// Optional parameters are pointers; leave them nil to omit them.
type UsageGetCustomerUsageOptions struct {
	StartDate string

	EndDate string

	MetricId *BillableMetricId
}

// UsageGetSubscriptionUsageOptions carries the query and header parameters of
// Usage.GetSubscriptionUsage.
//
// Optional parameters are pointers; leave them nil to omit them.
type UsageGetSubscriptionUsageOptions struct {
	StartDate *string

	EndDate *string

	MetricId *BillableMetricId
}

// UsageGetUsageSummaryOptions carries the query and header parameters of
// Usage.GetUsageSummary.
//
// Optional parameters are pointers; leave them nil to omit them.
type UsageGetUsageSummaryOptions struct {
	StartDate string

	EndDate string

	MetricId *BillableMetricId
}

// Usage groups the usage operations of the Meteroid API.
type Usage struct {
	client *Client
}

// Retrieve aggregated usage data for a customer over a specified period.
func (a *Usage) GetCustomerUsage(ctx context.Context, customerId string, options UsageGetCustomerUsageOptions) (*UsageResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/usage/customer/{customer_id}")
	req.SetPathParam("customer_id", customerId)

	req.SetQueryParam("start_date", options.StartDate)
	req.SetQueryParam("end_date", options.EndDate)
	if options.MetricId != nil {
		req.SetQueryParam("metric_id", string(*options.MetricId))
	}

	var out UsageResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve aggregated usage data for a subscription's usage-based components.
// If start_date/end_date are omitted, defaults to the current billing period.
func (a *Usage) GetSubscriptionUsage(ctx context.Context, subscriptionId string, options *UsageGetSubscriptionUsageOptions) (*UsageResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/usage/subscription/{subscription_id}")
	req.SetPathParam("subscription_id", subscriptionId)

	if options != nil {
		if options.StartDate != nil {
			req.SetQueryParam("start_date", *options.StartDate)
		}
		if options.EndDate != nil {
			req.SetQueryParam("end_date", *options.EndDate)
		}
		if options.MetricId != nil {
			req.SetQueryParam("metric_id", string(*options.MetricId))
		}
	}

	var out UsageResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve aggregated usage data across all customers for the tenant.
func (a *Usage) GetUsageSummary(ctx context.Context, options UsageGetUsageSummaryOptions) (*UsageResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/usage/summary")

	req.SetQueryParam("start_date", options.StartDate)
	req.SetQueryParam("end_date", options.EndDate)
	if options.MetricId != nil {
		req.SetQueryParam("metric_id", string(*options.MetricId))
	}

	var out UsageResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

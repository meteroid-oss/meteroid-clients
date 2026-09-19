package main

import (
	"context"
	"time"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// getUsage is `GET /api/usage` — current-period usage, straight from Meteroid.
//
// Two Meteroid endpoints, chosen by whether the workspace has a subscription, and the
// choice is reported back in `scope` so the frontend can label the period honestly.
func (a *app) getUsage(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	alias := session.customerAlias

	subscription, err := a.currentSubscription(ctx, alias)
	if err != nil {
		return nil, err
	}

	// Subscription scope: omitting StartDate/EndDate makes Meteroid use the
	// subscription's own billing period, so the numbers line up with the invoice.
	if subscription != nil {
		usage, err := a.meteroid.Usage().GetSubscriptionUsage(ctx, subscription.Id, nil)
		if err != nil {
			return nil, upstream("GET /api/v1/usage/subscription/"+subscription.Id, err)
		}
		return projectUsage("subscription", usage)
	}

	// Customer scope: this endpoint *requires* a date range, and with no subscription
	// there is no billing period to borrow. The demo supplies the current UTC calendar
	// month — a demo convention, not a billing period.
	usage, err := a.meteroid.Usage().GetCustomerUsage(ctx, alias, currentCalendarMonth(time.Now()))
	if err != nil {
		return nil, upstream("GET /api/v1/usage/customer/"+alias, err)
	}
	return projectUsage("customer", usage)
}

func projectUsage(scope string, usage *meteroid.UsageResponse) (*reply, error) {
	metrics := make([]MetricUsage, 0, len(usage.Usage))
	for _, metric := range usage.Usage {
		// Decimals stay strings all the way to the client.
		total, err := normalizeDecimal(metric.TotalValue)
		if err != nil {
			return nil, err
		}
		grouped := make([]GroupedUsage, 0, len(metric.GroupedUsage))
		for _, group := range metric.GroupedUsage {
			value, err := normalizeDecimal(group.Value)
			if err != nil {
				return nil, err
			}
			grouped = append(grouped, GroupedUsage{Dimensions: group.Dimensions, Value: value})
		}
		// Meteroid also returns MetricId; the demo drops it because `metric_code` is the
		// stable identifier application code uses.
		metrics = append(metrics, MetricUsage{
			MetricCode:   metric.MetricCode,
			MetricName:   metric.MetricName,
			TotalValue:   total,
			GroupedUsage: grouped,
		})
	}

	return replyOK(UsageResponse{
		PeriodStart: usage.PeriodStart,
		PeriodEnd:   usage.PeriodEnd,
		Scope:       scope,
		Metrics:     metrics,
	})
}

// currentCalendarMonth is the first of the current UTC month .. today, as YYYY-MM-DD.
func currentCalendarMonth(now time.Time) meteroid.UsageGetCustomerUsageOptions {
	today := now.UTC()
	first := time.Date(today.Year(), today.Month(), 1, 0, 0, 0, 0, time.UTC)
	return meteroid.UsageGetCustomerUsageOptions{
		StartDate: first.Format(time.DateOnly),
		EndDate:   today.Format(time.DateOnly),
	}
}

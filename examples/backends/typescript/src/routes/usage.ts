/** `GET /api/usage` — current-period usage, straight from Meteroid. */

import type { UsageResponse as SdkUsageResponse } from "@meteroid/sdk";

import { normalize } from "../decimal.js";
import type { UsageResponse } from "../dto.js";
import { upstream } from "../error.js";
import { ok, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";
import { currentSubscription } from "../workspace.js";

/**
 * Two Meteroid endpoints, chosen by whether the workspace has a subscription, and the
 * choice is reported back in `scope` so the frontend can label the period honestly.
 */
export async function getUsage(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<UsageResponse>> {
  const { customerAlias: alias } = requireSession(state, request);
  const subscription = await currentSubscription(state, alias);

  // Subscription scope: omitting startDate/endDate makes Meteroid use the
  // subscription's own billing period, so the numbers line up with the invoice.
  if (subscription !== null) {
    const usage = await state.meteroid.usage
      .getSubscriptionUsage(subscription.id)
      .catch(upstream(`GET /api/v1/usage/subscription/${subscription.id}`));
    return ok(project("subscription", usage));
  }

  // Customer scope: this endpoint *requires* a date range, and with no subscription
  // there is no billing period to borrow. The demo supplies the current UTC calendar
  // month — a demo convention, not a billing period.
  const usage = await state.meteroid.usage
    .getCustomerUsage(alias, currentCalendarMonth())
    .catch(upstream(`GET /api/v1/usage/customer/${alias}`));
  return ok(project("customer", usage));
}

function project(scope: UsageResponse["scope"], usage: SdkUsageResponse): UsageResponse {
  return {
    period_start: usage.periodStart,
    period_end: usage.periodEnd,
    scope,
    // Meteroid also returns `metricId`; the demo drops it because `metric_code` is the
    // stable identifier application code uses.
    metrics: usage.usage.map((metric) => ({
      metric_code: metric.metricCode,
      metric_name: metric.metricName,
      // Decimals stay strings all the way to the client.
      total_value: normalize(metric.totalValue),
      grouped_usage: metric.groupedUsage.map((group) => ({
        dimensions: group.dimensions,
        value: normalize(group.value),
      })),
    })),
  };
}

/** First of the current UTC month .. today, as `YYYY-MM-DD`. */
function currentCalendarMonth(now = new Date()): { startDate: string; endDate: string } {
  const today = now.toISOString().slice(0, 10);
  return { startDate: `${today.slice(0, 8)}01`, endDate: today };
}

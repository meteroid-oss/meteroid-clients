package com.scribe.routes;

import com.meteroid.api.UsageGetCustomerUsageOptions;
import com.meteroid.models.MetricUsage;
import com.meteroid.models.Subscription;
import com.meteroid.models.UsageResponse;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.SessionToken;
import com.scribe.Upstream;
import com.scribe.Workspaces;

import io.javalin.http.Context;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** {@code GET /api/usage} — current-period usage, straight from Meteroid. */
public final class UsageRoutes {

    private UsageRoutes() {}

    /**
     * Two Meteroid endpoints, chosen by whether the workspace has a subscription, and the choice is
     * reported back in {@code scope} so the frontend can label the period honestly.
     */
    public static void getUsage(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);
        Subscription subscription = Workspaces.currentSubscription(state, alias);

        String scope;
        UsageResponse usage;
        if (subscription != null) {
            // Subscription scope: omitting start_date/end_date makes Meteroid use the
            // subscription's own billing period, so the numbers line up with the invoice.
            String subscriptionId = subscription.getId();
            usage =
                    Upstream.call(
                            "GET /api/v1/usage/subscription/" + subscriptionId,
                            () -> state.meteroid.getUsage().getSubscriptionUsage(subscriptionId));
            scope = "subscription";
        } else {
            // Customer scope: this endpoint *requires* a date range, and with no subscription there
            // is no billing period to borrow. The demo supplies the current UTC calendar month — a
            // demo convention, not a billing period.
            LocalDate today = LocalDate.now(ZoneOffset.UTC);
            UsageGetCustomerUsageOptions options = new UsageGetCustomerUsageOptions();
            options.setStartDate(today.withDayOfMonth(1).toString());
            options.setEndDate(today.toString());

            usage =
                    Upstream.call(
                            "GET /api/v1/usage/customer/" + alias,
                            () -> state.meteroid.getUsage().getCustomerUsage(alias, options));
            scope = "customer";
        }

        ctx.json(project(scope, usage));
    }

    private static Dto.UsageResponse project(String scope, UsageResponse usage) {
        List<Dto.MetricUsage> metrics = new ArrayList<>();
        for (MetricUsage metric : usage.getUsage()) {
            List<Dto.GroupedUsage> grouped = new ArrayList<>();
            if (metric.getGroupedUsage() != null) {
                for (com.meteroid.models.GroupedUsage group : metric.getGroupedUsage()) {
                    grouped.add(
                            new Dto.GroupedUsage(
                                    group.getDimensions() == null ? Map.of() : group.getDimensions(),
                                    Dto.decimal(group.getValue())));
                }
            }
            metrics.add(
                    new Dto.MetricUsage(
                            // Meteroid also returns `metric_id`; the demo drops it because
                            // `metric_code` is the stable identifier application code uses.
                            metric.getMetricCode(),
                            metric.getMetricName(),
                            // Decimals stay strings all the way to the client.
                            Dto.decimal(metric.getTotalValue()),
                            grouped));
        }
        return new Dto.UsageResponse(usage.getPeriodStart(), usage.getPeriodEnd(), scope, metrics);
    }
}

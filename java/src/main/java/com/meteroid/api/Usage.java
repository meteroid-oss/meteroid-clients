// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.UsageResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Usage {
    private final MeteroidHttpClient client;

    public Usage(MeteroidHttpClient client) {
        this.client = client;
    }

    /** Retrieve aggregated usage data for a customer over a specified period. */
    public UsageResponse getCustomerUsage(final String customerId)
            throws IOException, ApiException {
        return this.getCustomerUsage(customerId, new UsageGetCustomerUsageOptions());
    }

    /** Retrieve aggregated usage data for a customer over a specified period. */
    public UsageResponse getCustomerUsage(
            final String customerId, final UsageGetCustomerUsageOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/usage/customer/%s", customerId));
        if (options.startDate != null) {
            url.addQueryParameter("start_date", options.startDate);
        }
        if (options.endDate != null) {
            url.addQueryParameter("end_date", options.endDate);
        }
        if (options.metricId != null) {
            url.addQueryParameter("metric_id", Utils.serializeQueryParam(options.metricId));
        }
        return this.client.executeRequest("GET", url.build(), null, null, UsageResponse.class);
    }

    /**
     * Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     */
    public UsageResponse getSubscriptionUsage(final String subscriptionId)
            throws IOException, ApiException {
        return this.getSubscriptionUsage(subscriptionId, new UsageGetSubscriptionUsageOptions());
    }

    /**
     * Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     */
    public UsageResponse getSubscriptionUsage(
            final String subscriptionId, final UsageGetSubscriptionUsageOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format("/api/v1/usage/subscription/%s", subscriptionId));
        if (options.startDate != null) {
            url.addQueryParameter("start_date", options.startDate);
        }
        if (options.endDate != null) {
            url.addQueryParameter("end_date", options.endDate);
        }
        if (options.metricId != null) {
            url.addQueryParameter("metric_id", Utils.serializeQueryParam(options.metricId));
        }
        return this.client.executeRequest("GET", url.build(), null, null, UsageResponse.class);
    }

    /** Retrieve aggregated usage data across all customers for the tenant. */
    public UsageResponse getUsageSummary() throws IOException, ApiException {

        return this.getUsageSummary(new UsageGetUsageSummaryOptions());
    }

    /** Retrieve aggregated usage data across all customers for the tenant. */
    public UsageResponse getUsageSummary(final UsageGetUsageSummaryOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/usage/summary");
        if (options.startDate != null) {
            url.addQueryParameter("start_date", options.startDate);
        }
        if (options.endDate != null) {
            url.addQueryParameter("end_date", options.endDate);
        }
        if (options.metricId != null) {
            url.addQueryParameter("metric_id", Utils.serializeQueryParam(options.metricId));
        }
        return this.client.executeRequest("GET", url.build(), null, null, UsageResponse.class);
    }
}

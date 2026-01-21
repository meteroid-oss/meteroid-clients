// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CancelSubscriptionRequest;
import com.meteroid.models.CancelSubscriptionResponse;
import com.meteroid.models.SubscriptionCreateRequest;
import com.meteroid.models.SubscriptionDetails;
import com.meteroid.models.SubscriptionListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Subscriptions {
    private final MeteroidHttpClient client;

    public Subscriptions(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List subscriptions with optional filtering by customer or plan. */
    public SubscriptionListResponse listSubscriptions() throws IOException, ApiException {

        return this.listSubscriptions(new SubscriptionsListSubscriptionsOptions());
    }

    /** List subscriptions with optional filtering by customer or plan. */
    public SubscriptionListResponse listSubscriptions(
            final SubscriptionsListSubscriptionsOptions options) throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/subscriptions");
        if (options.customerId != null) {
            url.addQueryParameter("customer_id", options.customerId);
        }
        if (options.planId != null) {
            url.addQueryParameter("plan_id", Utils.serializeQueryParam(options.planId));
        }
        if (options.statuses != null) {
            url.addQueryParameter("statuses", Utils.serializeQueryParam(options.statuses));
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, SubscriptionListResponse.class);
    }

    /** Create a new subscription for a customer with a specific plan. */
    public SubscriptionDetails createSubscription(
            final SubscriptionCreateRequest subscriptionCreateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/subscriptions");
        return this.client.executeRequest(
                "POST", url.build(), null, subscriptionCreateRequest, SubscriptionDetails.class);
    }

    /**
     * Retrieve detailed information about a subscription including price components and schedules.
     */
    public SubscriptionDetails subscriptionDetails(final String id)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/subscriptions/%s", id));
        return this.client.executeRequest(
                "GET", url.build(), null, null, SubscriptionDetails.class);
    }

    /** Cancel a subscription either immediately or at the end of the billing period. */
    public CancelSubscriptionResponse cancelSubscription(
            final String subscriptionId, final CancelSubscriptionRequest cancelSubscriptionRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format("/api/v1/subscriptions/%s/cancel", subscriptionId));
        return this.client.executeRequest(
                "POST",
                url.build(),
                null,
                cancelSubscriptionRequest,
                CancelSubscriptionResponse.class);
    }
}

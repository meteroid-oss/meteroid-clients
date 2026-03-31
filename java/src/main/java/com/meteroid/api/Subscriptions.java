// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CancelSubscriptionRequest;
import com.meteroid.models.CancelSubscriptionResponse;
import com.meteroid.models.SubscriptionCreateRequest;
import com.meteroid.models.SubscriptionDetails;
import com.meteroid.models.SubscriptionUpdateRequest;
import com.meteroid.models.SubscriptionUpdateResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Subscriptions {
    private final MeteroidHttpClient client;

    public Subscriptions(MeteroidHttpClient client) {
        this.client = client;
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
    public SubscriptionDetails subscriptionDetails(final String subscriptionId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/subscriptions/%s", subscriptionId));
        return this.client.executeRequest(
                "GET", url.build(), null, null, SubscriptionDetails.class);
    }

    /** Update subscription settings like payment configuration, billing options, etc. */
    public SubscriptionUpdateResponse updateSubscription(
            final String subscriptionId, final SubscriptionUpdateRequest subscriptionUpdateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/subscriptions/%s", subscriptionId));
        return this.client.executeRequest(
                "PATCH",
                url.build(),
                null,
                subscriptionUpdateRequest,
                SubscriptionUpdateResponse.class);
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

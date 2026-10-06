// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CancelSubscriptionRequest;
import com.meteroid.models.CancelSubscriptionResponse;
import com.meteroid.models.EffectiveEntitlementListResponse;
import com.meteroid.models.Subscription;
import com.meteroid.models.SubscriptionCreateRequest;
import com.meteroid.models.SubscriptionDetails;
import com.meteroid.models.SubscriptionListResponse;
import com.meteroid.models.SubscriptionStatusEnum;
import com.meteroid.models.SubscriptionUpdateRequest;
import com.meteroid.models.SubscriptionUpdateResponse;

import okhttp3.HttpUrl;

import java.util.List;
import java.util.Objects;

/**
 * The {@code subscriptions} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Subscriptions {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Subscriptions(MeteroidHttpClient client) {
        this.client = client;
        this.withRawResponse = new WithRawResponse();
    }

    /**
     * The same operations, returning the status and headers along with the body.
     *
     * @return the operations
     */
    public WithRawResponse withRawResponse() {
        return withRawResponse;
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @return the response body
     */
    public SubscriptionListResponse list() {
        return list(SubscriptionsListOptions.none(), RequestOptions.none());
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param options the optional parameters
     * @return the response body
     */
    public SubscriptionListResponse list(final SubscriptionsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public SubscriptionListResponse list(final RequestOptions requestOptions) {
        return list(SubscriptionsListOptions.none(), requestOptions);
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public SubscriptionListResponse list(
            final SubscriptionsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<SubscriptionListResponse> exchangeList(
            final SubscriptionsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/subscriptions");
        String value1 = options.customerId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("customer_id", value1);
        }
        String value2 = options.planId().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("plan_id", value2);
        }
        List<SubscriptionStatusEnum> value3 = options.statuses().orElse(null);
        if (value3 != null) {
            Utils.addExplodedQueryParameter(url, "statuses", value3);
        }
        String value4 = options.orderBy().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("order_by", value4);
        }
        Integer value5 = options.page().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value5));
        }
        Integer value6 = options.perPage().orElse(null);
        if (value6 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value6));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(SubscriptionListResponse.class);
    }

    /**
     * Create subscription
     *
     * <p>Create a new subscription for a customer with a specific plan.
     *
     * @param subscriptionCreateRequest the request body
     * @return the response body
     */
    public SubscriptionDetails create(final SubscriptionCreateRequest subscriptionCreateRequest) {
        return create(subscriptionCreateRequest, RequestOptions.none());
    }

    /**
     * Create subscription
     *
     * <p>Create a new subscription for a customer with a specific plan.
     *
     * @param subscriptionCreateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public SubscriptionDetails create(
            final SubscriptionCreateRequest subscriptionCreateRequest,
            final RequestOptions requestOptions) {
        return exchangeCreate(subscriptionCreateRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<SubscriptionDetails> exchangeCreate(
            final SubscriptionCreateRequest subscriptionCreateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionCreateRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/subscriptions").build();
        return client.call("POST", url)
                .json(subscriptionCreateRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429", "500")
                .options(requestOptions)
                .returning(SubscriptionDetails.class);
    }

    /**
     * Get subscription details
     *
     * <p>Retrieve detailed information about a subscription including price components and
     * schedules.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body
     */
    public SubscriptionDetails retrieve(final String subscriptionId) {
        return retrieve(subscriptionId, RequestOptions.none());
    }

    /**
     * Get subscription details
     *
     * <p>Retrieve detailed information about a subscription including price components and
     * schedules.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public SubscriptionDetails retrieve(
            final String subscriptionId, final RequestOptions requestOptions) {
        return exchangeRetrieve(subscriptionId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<SubscriptionDetails> exchangeRetrieve(
            final String subscriptionId, final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/subscriptions")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(SubscriptionDetails.class);
    }

    /**
     * Update subscription settings like payment configuration, billing options, etc.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param subscriptionUpdateRequest the request body
     * @return the response body
     */
    public SubscriptionUpdateResponse update(
            final String subscriptionId,
            final SubscriptionUpdateRequest subscriptionUpdateRequest) {
        return update(subscriptionId, subscriptionUpdateRequest, RequestOptions.none());
    }

    /**
     * Update subscription settings like payment configuration, billing options, etc.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param subscriptionUpdateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public SubscriptionUpdateResponse update(
            final String subscriptionId,
            final SubscriptionUpdateRequest subscriptionUpdateRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(subscriptionId, subscriptionUpdateRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<SubscriptionUpdateResponse> exchangeUpdate(
            final String subscriptionId,
            final SubscriptionUpdateRequest subscriptionUpdateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        Objects.requireNonNull(subscriptionUpdateRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/subscriptions")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId))
                        .build();
        return client.call("PATCH", url)
                .json(subscriptionUpdateRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(SubscriptionUpdateResponse.class);
    }

    /**
     * Cancel subscription
     *
     * <p>Cancel a subscription either immediately or at the end of the billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param cancelSubscriptionRequest the request body
     * @return the response body
     */
    public CancelSubscriptionResponse cancel(
            final String subscriptionId,
            final CancelSubscriptionRequest cancelSubscriptionRequest) {
        return cancel(subscriptionId, cancelSubscriptionRequest, RequestOptions.none());
    }

    /**
     * Cancel subscription
     *
     * <p>Cancel a subscription either immediately or at the end of the billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param cancelSubscriptionRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CancelSubscriptionResponse cancel(
            final String subscriptionId,
            final CancelSubscriptionRequest cancelSubscriptionRequest,
            final RequestOptions requestOptions) {
        return exchangeCancel(subscriptionId, cancelSubscriptionRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CancelSubscriptionResponse> exchangeCancel(
            final String subscriptionId,
            final CancelSubscriptionRequest cancelSubscriptionRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        Objects.requireNonNull(cancelSubscriptionRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/subscriptions")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId))
                        .addPathSegments("cancel")
                        .build();
        return client.call("POST", url)
                .json(cancelSubscriptionRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(CancelSubscriptionResponse.class);
    }

    /**
     * List subscription entitlements
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body
     */
    public EffectiveEntitlementListResponse listEntitlements(final String subscriptionId) {
        return listEntitlements(subscriptionId, RequestOptions.none());
    }

    /**
     * List subscription entitlements
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public EffectiveEntitlementListResponse listEntitlements(
            final String subscriptionId, final RequestOptions requestOptions) {
        return exchangeListEntitlements(subscriptionId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<EffectiveEntitlementListResponse> exchangeListEntitlements(
            final String subscriptionId, final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/subscriptions")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId))
                        .addPathSegments("entitlements")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(EffectiveEntitlementListResponse.class);
    }

    /**
     * Get subscription summary
     *
     * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
     * same shape as list items, for callers that only need status and billing dates.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body
     */
    public Subscription retrieveSummary(final String subscriptionId) {
        return retrieveSummary(subscriptionId, RequestOptions.none());
    }

    /**
     * Get subscription summary
     *
     * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
     * same shape as list items, for callers that only need status and billing dates.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Subscription retrieveSummary(
            final String subscriptionId, final RequestOptions requestOptions) {
        return exchangeRetrieveSummary(subscriptionId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Subscription> exchangeRetrieveSummary(
            final String subscriptionId, final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/subscriptions")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId))
                        .addPathSegments("summary")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(Subscription.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionListResponse> list() {
            return list(SubscriptionsListOptions.none(), RequestOptions.none());
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionListResponse> list(final SubscriptionsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionListResponse> list(final RequestOptions requestOptions) {
            return list(SubscriptionsListOptions.none(), requestOptions);
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionListResponse> list(
                final SubscriptionsListOptions options, final RequestOptions requestOptions) {
            return Subscriptions.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create subscription
         *
         * <p>Create a new subscription for a customer with a specific plan.
         *
         * @param subscriptionCreateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionDetails> create(
                final SubscriptionCreateRequest subscriptionCreateRequest) {
            return create(subscriptionCreateRequest, RequestOptions.none());
        }

        /**
         * Create subscription
         *
         * <p>Create a new subscription for a customer with a specific plan.
         *
         * @param subscriptionCreateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionDetails> create(
                final SubscriptionCreateRequest subscriptionCreateRequest,
                final RequestOptions requestOptions) {
            return Subscriptions.this
                    .exchangeCreate(subscriptionCreateRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Get subscription details
         *
         * <p>Retrieve detailed information about a subscription including price components and
         * schedules.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionDetails> retrieve(final String subscriptionId) {
            return retrieve(subscriptionId, RequestOptions.none());
        }

        /**
         * Get subscription details
         *
         * <p>Retrieve detailed information about a subscription including price components and
         * schedules.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionDetails> retrieve(
                final String subscriptionId, final RequestOptions requestOptions) {
            return Subscriptions.this.exchangeRetrieve(subscriptionId, requestOptions).sendRaw();
        }

        /**
         * Update subscription settings like payment configuration, billing options, etc.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param subscriptionUpdateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionUpdateResponse> update(
                final String subscriptionId,
                final SubscriptionUpdateRequest subscriptionUpdateRequest) {
            return update(subscriptionId, subscriptionUpdateRequest, RequestOptions.none());
        }

        /**
         * Update subscription settings like payment configuration, billing options, etc.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param subscriptionUpdateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<SubscriptionUpdateResponse> update(
                final String subscriptionId,
                final SubscriptionUpdateRequest subscriptionUpdateRequest,
                final RequestOptions requestOptions) {
            return Subscriptions.this
                    .exchangeUpdate(subscriptionId, subscriptionUpdateRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Cancel subscription
         *
         * <p>Cancel a subscription either immediately or at the end of the billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param cancelSubscriptionRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<CancelSubscriptionResponse> cancel(
                final String subscriptionId,
                final CancelSubscriptionRequest cancelSubscriptionRequest) {
            return cancel(subscriptionId, cancelSubscriptionRequest, RequestOptions.none());
        }

        /**
         * Cancel subscription
         *
         * <p>Cancel a subscription either immediately or at the end of the billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param cancelSubscriptionRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CancelSubscriptionResponse> cancel(
                final String subscriptionId,
                final CancelSubscriptionRequest cancelSubscriptionRequest,
                final RequestOptions requestOptions) {
            return Subscriptions.this
                    .exchangeCancel(subscriptionId, cancelSubscriptionRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * List subscription entitlements
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<EffectiveEntitlementListResponse> listEntitlements(
                final String subscriptionId) {
            return listEntitlements(subscriptionId, RequestOptions.none());
        }

        /**
         * List subscription entitlements
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<EffectiveEntitlementListResponse> listEntitlements(
                final String subscriptionId, final RequestOptions requestOptions) {
            return Subscriptions.this
                    .exchangeListEntitlements(subscriptionId, requestOptions)
                    .sendRaw();
        }

        /**
         * Get subscription summary
         *
         * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
         * same shape as list items, for callers that only need status and billing dates.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Subscription> retrieveSummary(final String subscriptionId) {
            return retrieveSummary(subscriptionId, RequestOptions.none());
        }

        /**
         * Get subscription summary
         *
         * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
         * same shape as list items, for callers that only need status and billing dates.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Subscription> retrieveSummary(
                final String subscriptionId, final RequestOptions requestOptions) {
            return Subscriptions.this
                    .exchangeRetrieveSummary(subscriptionId, requestOptions)
                    .sendRaw();
        }
    }
}

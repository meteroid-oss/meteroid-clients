// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CancelSubscriptionRequest;
import com.meteroid.models.CancelSubscriptionResponse;
import com.meteroid.models.EffectiveEntitlementListResponse;
import com.meteroid.models.Subscription;
import com.meteroid.models.SubscriptionCreateRequest;
import com.meteroid.models.SubscriptionDetails;
import com.meteroid.models.SubscriptionListResponse;
import com.meteroid.models.SubscriptionUpdateRequest;
import com.meteroid.models.SubscriptionUpdateResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code subscriptions} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class SubscriptionsAsync {
    private final Subscriptions sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public SubscriptionsAsync(Subscriptions sync) {
        this.sync = sync;
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
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionListResponse> list() {
        return list(SubscriptionsListOptions.none(), RequestOptions.none());
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionListResponse> list(
            final SubscriptionsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionListResponse> list(final RequestOptions requestOptions) {
        return list(SubscriptionsListOptions.none(), requestOptions);
    }

    /**
     * List subscriptions with optional filtering by customer or plan.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionListResponse> list(
            final SubscriptionsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create subscription
     *
     * <p>Create a new subscription for a customer with a specific plan.
     *
     * @param subscriptionCreateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionDetails> create(
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
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionDetails> create(
            final SubscriptionCreateRequest subscriptionCreateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreate(subscriptionCreateRequest, requestOptions).sendAsync();
    }

    /**
     * Get subscription details
     *
     * <p>Retrieve detailed information about a subscription including price components and
     * schedules.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionDetails> retrieve(final String subscriptionId) {
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
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionDetails> retrieve(
            final String subscriptionId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(subscriptionId, requestOptions).sendAsync();
    }

    /**
     * Update subscription settings like payment configuration, billing options, etc.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param subscriptionUpdateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionUpdateResponse> update(
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
     * @return the response body, once received
     */
    public CompletableFuture<SubscriptionUpdateResponse> update(
            final String subscriptionId,
            final SubscriptionUpdateRequest subscriptionUpdateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(subscriptionId, subscriptionUpdateRequest, requestOptions)
                .sendAsync();
    }

    /**
     * Cancel subscription
     *
     * <p>Cancel a subscription either immediately or at the end of the billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param cancelSubscriptionRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CancelSubscriptionResponse> cancel(
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
     * @return the response body, once received
     */
    public CompletableFuture<CancelSubscriptionResponse> cancel(
            final String subscriptionId,
            final CancelSubscriptionRequest cancelSubscriptionRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCancel(subscriptionId, cancelSubscriptionRequest, requestOptions)
                .sendAsync();
    }

    /**
     * List subscription entitlements
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<EffectiveEntitlementListResponse> listEntitlements(
            final String subscriptionId) {
        return listEntitlements(subscriptionId, RequestOptions.none());
    }

    /**
     * List subscription entitlements
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<EffectiveEntitlementListResponse> listEntitlements(
            final String subscriptionId, final RequestOptions requestOptions) {
        return sync.exchangeListEntitlements(subscriptionId, requestOptions).sendAsync();
    }

    /**
     * Get subscription summary
     *
     * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
     * same shape as list items, for callers that only need status and billing dates.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Subscription> retrieveSummary(final String subscriptionId) {
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
     * @return the response body, once received
     */
    public CompletableFuture<Subscription> retrieveSummary(
            final String subscriptionId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieveSummary(subscriptionId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionListResponse>> list() {
            return list(SubscriptionsListOptions.none(), RequestOptions.none());
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionListResponse>> list(
                final SubscriptionsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionListResponse>> list(
                final RequestOptions requestOptions) {
            return list(SubscriptionsListOptions.none(), requestOptions);
        }

        /**
         * List subscriptions with optional filtering by customer or plan.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionListResponse>> list(
                final SubscriptionsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create subscription
         *
         * <p>Create a new subscription for a customer with a specific plan.
         *
         * @param subscriptionCreateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionDetails>> create(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionDetails>> create(
                final SubscriptionCreateRequest subscriptionCreateRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(subscriptionCreateRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get subscription details
         *
         * <p>Retrieve detailed information about a subscription including price components and
         * schedules.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionDetails>> retrieve(
                final String subscriptionId) {
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionDetails>> retrieve(
                final String subscriptionId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(subscriptionId, requestOptions).sendRawAsync();
        }

        /**
         * Update subscription settings like payment configuration, billing options, etc.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param subscriptionUpdateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionUpdateResponse>> update(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<SubscriptionUpdateResponse>> update(
                final String subscriptionId,
                final SubscriptionUpdateRequest subscriptionUpdateRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(subscriptionId, subscriptionUpdateRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Cancel subscription
         *
         * <p>Cancel a subscription either immediately or at the end of the billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param cancelSubscriptionRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CancelSubscriptionResponse>> cancel(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CancelSubscriptionResponse>> cancel(
                final String subscriptionId,
                final CancelSubscriptionRequest cancelSubscriptionRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCancel(subscriptionId, cancelSubscriptionRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * List subscription entitlements
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<EffectiveEntitlementListResponse>> listEntitlements(
                final String subscriptionId) {
            return listEntitlements(subscriptionId, RequestOptions.none());
        }

        /**
         * List subscription entitlements
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<EffectiveEntitlementListResponse>> listEntitlements(
                final String subscriptionId, final RequestOptions requestOptions) {
            return sync.exchangeListEntitlements(subscriptionId, requestOptions).sendRawAsync();
        }

        /**
         * Get subscription summary
         *
         * <p>Retrieve a subscription without its components, add-ons, coupons and entitlements: the
         * same shape as list items, for callers that only need status and billing dates.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Subscription>> retrieveSummary(
                final String subscriptionId) {
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Subscription>> retrieveSummary(
                final String subscriptionId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieveSummary(subscriptionId, requestOptions).sendRawAsync();
        }
    }
}

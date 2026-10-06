// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CancelCheckoutSessionResponse;
import com.meteroid.models.CreateCheckoutSessionRequest;
import com.meteroid.models.CreateCheckoutSessionResponse;
import com.meteroid.models.GetCheckoutSessionResponse;
import com.meteroid.models.ListCheckoutSessionsResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code checkout_sessions} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class CheckoutSessionsAsync {
    private final CheckoutSessions sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public CheckoutSessionsAsync(CheckoutSessions sync) {
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
     * List checkout sessions
     *
     * @return the response body, once received
     */
    public CompletableFuture<ListCheckoutSessionsResponse> list() {
        return list(CheckoutSessionsListOptions.none(), RequestOptions.none());
    }

    /**
     * List checkout sessions
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<ListCheckoutSessionsResponse> list(
            final CheckoutSessionsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List checkout sessions
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ListCheckoutSessionsResponse> list(
            final RequestOptions requestOptions) {
        return list(CheckoutSessionsListOptions.none(), requestOptions);
    }

    /**
     * List checkout sessions
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ListCheckoutSessionsResponse> list(
            final CheckoutSessionsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create a checkout session
     *
     * @param createCheckoutSessionRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CreateCheckoutSessionResponse> create(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest) {
        return create(createCheckoutSessionRequest, RequestOptions.none());
    }

    /**
     * Create a checkout session
     *
     * @param createCheckoutSessionRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CreateCheckoutSessionResponse> create(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreate(createCheckoutSessionRequest, requestOptions).sendAsync();
    }

    /**
     * Get a checkout session by ID
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<GetCheckoutSessionResponse> retrieve(final String id) {
        return retrieve(id, RequestOptions.none());
    }

    /**
     * Get a checkout session by ID
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<GetCheckoutSessionResponse> retrieve(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(id, requestOptions).sendAsync();
    }

    /**
     * Cancel a checkout session
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<CancelCheckoutSessionResponse> cancel(final String id) {
        return cancel(id, RequestOptions.none());
    }

    /**
     * Cancel a checkout session
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CancelCheckoutSessionResponse> cancel(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeCancel(id, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List checkout sessions
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ListCheckoutSessionsResponse>> list() {
            return list(CheckoutSessionsListOptions.none(), RequestOptions.none());
        }

        /**
         * List checkout sessions
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ListCheckoutSessionsResponse>> list(
                final CheckoutSessionsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List checkout sessions
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ListCheckoutSessionsResponse>> list(
                final RequestOptions requestOptions) {
            return list(CheckoutSessionsListOptions.none(), requestOptions);
        }

        /**
         * List checkout sessions
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ListCheckoutSessionsResponse>> list(
                final CheckoutSessionsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create a checkout session
         *
         * @param createCheckoutSessionRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreateCheckoutSessionResponse>> create(
                final CreateCheckoutSessionRequest createCheckoutSessionRequest) {
            return create(createCheckoutSessionRequest, RequestOptions.none());
        }

        /**
         * Create a checkout session
         *
         * @param createCheckoutSessionRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreateCheckoutSessionResponse>> create(
                final CreateCheckoutSessionRequest createCheckoutSessionRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(createCheckoutSessionRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get a checkout session by ID
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<GetCheckoutSessionResponse>> retrieve(
                final String id) {
            return retrieve(id, RequestOptions.none());
        }

        /**
         * Get a checkout session by ID
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<GetCheckoutSessionResponse>> retrieve(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(id, requestOptions).sendRawAsync();
        }

        /**
         * Cancel a checkout session
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CancelCheckoutSessionResponse>> cancel(
                final String id) {
            return cancel(id, RequestOptions.none());
        }

        /**
         * Cancel a checkout session
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CancelCheckoutSessionResponse>> cancel(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeCancel(id, requestOptions).sendRawAsync();
        }
    }
}

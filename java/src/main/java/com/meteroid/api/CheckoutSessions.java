// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CancelCheckoutSessionResponse;
import com.meteroid.models.CheckoutSessionStatus;
import com.meteroid.models.CreateCheckoutSessionRequest;
import com.meteroid.models.CreateCheckoutSessionResponse;
import com.meteroid.models.GetCheckoutSessionResponse;
import com.meteroid.models.ListCheckoutSessionsResponse;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code checkout_sessions} operations, blocking. {@link #withRawResponse()} has the same
 * methods returning the status and headers along with the body.
 */
public final class CheckoutSessions {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public CheckoutSessions(MeteroidHttpClient client) {
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
     * List checkout sessions
     *
     * @return the response body
     */
    public ListCheckoutSessionsResponse list() {
        return list(CheckoutSessionsListOptions.none(), RequestOptions.none());
    }

    /**
     * List checkout sessions
     *
     * @param options the optional parameters
     * @return the response body
     */
    public ListCheckoutSessionsResponse list(final CheckoutSessionsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List checkout sessions
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ListCheckoutSessionsResponse list(final RequestOptions requestOptions) {
        return list(CheckoutSessionsListOptions.none(), requestOptions);
    }

    /**
     * List checkout sessions
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ListCheckoutSessionsResponse list(
            final CheckoutSessionsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ListCheckoutSessionsResponse> exchangeList(
            final CheckoutSessionsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/checkout-sessions");
        String value1 = options.customerId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("customer_id", value1);
        }
        CheckoutSessionStatus value2 = options.status().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("status", Utils.serializeQueryParam(value2));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(ListCheckoutSessionsResponse.class);
    }

    /**
     * Create a checkout session
     *
     * @param createCheckoutSessionRequest the request body
     * @return the response body
     */
    public CreateCheckoutSessionResponse create(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest) {
        return create(createCheckoutSessionRequest, RequestOptions.none());
    }

    /**
     * Create a checkout session
     *
     * @param createCheckoutSessionRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CreateCheckoutSessionResponse create(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest,
            final RequestOptions requestOptions) {
        return exchangeCreate(createCheckoutSessionRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CreateCheckoutSessionResponse> exchangeCreate(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(createCheckoutSessionRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/checkout-sessions").build();
        return client.call("POST", url)
                .json(createCheckoutSessionRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429", "500")
                .options(requestOptions)
                .returning(CreateCheckoutSessionResponse.class);
    }

    /**
     * Get a checkout session by ID
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public GetCheckoutSessionResponse retrieve(final String id) {
        return retrieve(id, RequestOptions.none());
    }

    /**
     * Get a checkout session by ID
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public GetCheckoutSessionResponse retrieve(
            final String id, final RequestOptions requestOptions) {
        return exchangeRetrieve(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<GetCheckoutSessionResponse> exchangeRetrieve(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/checkout-sessions")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(GetCheckoutSessionResponse.class);
    }

    /**
     * Cancel a checkout session
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public CancelCheckoutSessionResponse cancel(final String id) {
        return cancel(id, RequestOptions.none());
    }

    /**
     * Cancel a checkout session
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CancelCheckoutSessionResponse cancel(
            final String id, final RequestOptions requestOptions) {
        return exchangeCancel(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CancelCheckoutSessionResponse> exchangeCancel(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/checkout-sessions")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .addPathSegments("cancel")
                        .build();
        return client.call("POST", url)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(CancelCheckoutSessionResponse.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List checkout sessions
         *
         * @return the status, headers and body
         */
        public ApiResponse<ListCheckoutSessionsResponse> list() {
            return list(CheckoutSessionsListOptions.none(), RequestOptions.none());
        }

        /**
         * List checkout sessions
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<ListCheckoutSessionsResponse> list(
                final CheckoutSessionsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List checkout sessions
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ListCheckoutSessionsResponse> list(final RequestOptions requestOptions) {
            return list(CheckoutSessionsListOptions.none(), requestOptions);
        }

        /**
         * List checkout sessions
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ListCheckoutSessionsResponse> list(
                final CheckoutSessionsListOptions options, final RequestOptions requestOptions) {
            return CheckoutSessions.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create a checkout session
         *
         * @param createCheckoutSessionRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<CreateCheckoutSessionResponse> create(
                final CreateCheckoutSessionRequest createCheckoutSessionRequest) {
            return create(createCheckoutSessionRequest, RequestOptions.none());
        }

        /**
         * Create a checkout session
         *
         * @param createCheckoutSessionRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CreateCheckoutSessionResponse> create(
                final CreateCheckoutSessionRequest createCheckoutSessionRequest,
                final RequestOptions requestOptions) {
            return CheckoutSessions.this
                    .exchangeCreate(createCheckoutSessionRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Get a checkout session by ID
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<GetCheckoutSessionResponse> retrieve(final String id) {
            return retrieve(id, RequestOptions.none());
        }

        /**
         * Get a checkout session by ID
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<GetCheckoutSessionResponse> retrieve(
                final String id, final RequestOptions requestOptions) {
            return CheckoutSessions.this.exchangeRetrieve(id, requestOptions).sendRaw();
        }

        /**
         * Cancel a checkout session
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<CancelCheckoutSessionResponse> cancel(final String id) {
            return cancel(id, RequestOptions.none());
        }

        /**
         * Cancel a checkout session
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CancelCheckoutSessionResponse> cancel(
                final String id, final RequestOptions requestOptions) {
            return CheckoutSessions.this.exchangeCancel(id, requestOptions).sendRaw();
        }
    }
}

// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.UsageResponse;

import okhttp3.HttpUrl;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The {@code usage} operations, blocking. {@link #withRawResponse()} has the same methods returning
 * the status and headers along with the body.
 */
public final class Usage {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Usage(MeteroidHttpClient client) {
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
     * Get customer usage
     *
     * <p>Retrieve aggregated usage data for a customer over a specified period.
     *
     * @param customerId the {@code customer_id} path parameter
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @return the response body
     */
    public UsageResponse retrieveCustomer(
            final String customerId, final LocalDate startDate, final LocalDate endDate) {
        return retrieveCustomer(
                customerId,
                startDate,
                endDate,
                UsageRetrieveCustomerOptions.none(),
                RequestOptions.none());
    }

    /**
     * Get customer usage
     *
     * <p>Retrieve aggregated usage data for a customer over a specified period.
     *
     * @param customerId the {@code customer_id} path parameter
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param options the optional parameters
     * @return the response body
     */
    public UsageResponse retrieveCustomer(
            final String customerId,
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveCustomerOptions options) {
        return retrieveCustomer(customerId, startDate, endDate, options, RequestOptions.none());
    }

    /**
     * Get customer usage
     *
     * <p>Retrieve aggregated usage data for a customer over a specified period.
     *
     * @param customerId the {@code customer_id} path parameter
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveCustomer(
            final String customerId,
            final LocalDate startDate,
            final LocalDate endDate,
            final RequestOptions requestOptions) {
        return retrieveCustomer(
                customerId,
                startDate,
                endDate,
                UsageRetrieveCustomerOptions.none(),
                requestOptions);
    }

    /**
     * Get customer usage
     *
     * <p>Retrieve aggregated usage data for a customer over a specified period.
     *
     * @param customerId the {@code customer_id} path parameter
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveCustomer(
            final String customerId,
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveCustomerOptions options,
            final RequestOptions requestOptions) {
        return exchangeRetrieveCustomer(customerId, startDate, endDate, options, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<UsageResponse> exchangeRetrieveCustomer(
            final String customerId,
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveCustomerOptions options,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(customerId, "customer_id");
        Objects.requireNonNull(startDate, "start_date");
        Objects.requireNonNull(endDate, "end_date");
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/usage/customer")
                        .addPathSegment(Utils.pathSegment("customer_id", customerId));
        url.addQueryParameter("start_date", Utils.serializeQueryParam(startDate));
        url.addQueryParameter("end_date", Utils.serializeQueryParam(endDate));
        String value3 = options.metricId().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("metric_id", value3);
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(UsageResponse.class);
    }

    /**
     * Get subscription usage
     *
     * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @return the response body
     */
    public UsageResponse retrieveSubscription(final String subscriptionId) {
        return retrieveSubscription(
                subscriptionId, UsageRetrieveSubscriptionOptions.none(), RequestOptions.none());
    }

    /**
     * Get subscription usage
     *
     * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param options the optional parameters
     * @return the response body
     */
    public UsageResponse retrieveSubscription(
            final String subscriptionId, final UsageRetrieveSubscriptionOptions options) {
        return retrieveSubscription(subscriptionId, options, RequestOptions.none());
    }

    /**
     * Get subscription usage
     *
     * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveSubscription(
            final String subscriptionId, final RequestOptions requestOptions) {
        return retrieveSubscription(
                subscriptionId, UsageRetrieveSubscriptionOptions.none(), requestOptions);
    }

    /**
     * Get subscription usage
     *
     * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
     * start_date/end_date are omitted, defaults to the current billing period.
     *
     * @param subscriptionId the {@code subscription_id} path parameter
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveSubscription(
            final String subscriptionId,
            final UsageRetrieveSubscriptionOptions options,
            final RequestOptions requestOptions) {
        return exchangeRetrieveSubscription(subscriptionId, options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<UsageResponse> exchangeRetrieveSubscription(
            final String subscriptionId,
            final UsageRetrieveSubscriptionOptions options,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(subscriptionId, "subscription_id");
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/usage/subscription")
                        .addPathSegment(Utils.pathSegment("subscription_id", subscriptionId));
        LocalDate value1 = options.startDate().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("start_date", Utils.serializeQueryParam(value1));
        }
        LocalDate value2 = options.endDate().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("end_date", Utils.serializeQueryParam(value2));
        }
        String value3 = options.metricId().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("metric_id", value3);
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(UsageResponse.class);
    }

    /**
     * Get usage summary
     *
     * <p>Retrieve aggregated usage data across all customers for the tenant.
     *
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @return the response body
     */
    public UsageResponse retrieveSummary(final LocalDate startDate, final LocalDate endDate) {
        return retrieveSummary(
                startDate, endDate, UsageRetrieveSummaryOptions.none(), RequestOptions.none());
    }

    /**
     * Get usage summary
     *
     * <p>Retrieve aggregated usage data across all customers for the tenant.
     *
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param options the optional parameters
     * @return the response body
     */
    public UsageResponse retrieveSummary(
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveSummaryOptions options) {
        return retrieveSummary(startDate, endDate, options, RequestOptions.none());
    }

    /**
     * Get usage summary
     *
     * <p>Retrieve aggregated usage data across all customers for the tenant.
     *
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveSummary(
            final LocalDate startDate,
            final LocalDate endDate,
            final RequestOptions requestOptions) {
        return retrieveSummary(
                startDate, endDate, UsageRetrieveSummaryOptions.none(), requestOptions);
    }

    /**
     * Get usage summary
     *
     * <p>Retrieve aggregated usage data across all customers for the tenant.
     *
     * @param startDate the {@code start_date} required parameter
     * @param endDate the {@code end_date} required parameter
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public UsageResponse retrieveSummary(
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveSummaryOptions options,
            final RequestOptions requestOptions) {
        return exchangeRetrieveSummary(startDate, endDate, options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<UsageResponse> exchangeRetrieveSummary(
            final LocalDate startDate,
            final LocalDate endDate,
            final UsageRetrieveSummaryOptions options,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(startDate, "start_date");
        Objects.requireNonNull(endDate, "end_date");
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/usage/summary");
        url.addQueryParameter("start_date", Utils.serializeQueryParam(startDate));
        url.addQueryParameter("end_date", Utils.serializeQueryParam(endDate));
        String value3 = options.metricId().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("metric_id", value3);
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(UsageResponse.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * Get customer usage
         *
         * <p>Retrieve aggregated usage data for a customer over a specified period.
         *
         * @param customerId the {@code customer_id} path parameter
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveCustomer(
                final String customerId, final LocalDate startDate, final LocalDate endDate) {
            return retrieveCustomer(
                    customerId,
                    startDate,
                    endDate,
                    UsageRetrieveCustomerOptions.none(),
                    RequestOptions.none());
        }

        /**
         * Get customer usage
         *
         * <p>Retrieve aggregated usage data for a customer over a specified period.
         *
         * @param customerId the {@code customer_id} path parameter
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveCustomer(
                final String customerId,
                final LocalDate startDate,
                final LocalDate endDate,
                final UsageRetrieveCustomerOptions options) {
            return retrieveCustomer(customerId, startDate, endDate, options, RequestOptions.none());
        }

        /**
         * Get customer usage
         *
         * <p>Retrieve aggregated usage data for a customer over a specified period.
         *
         * @param customerId the {@code customer_id} path parameter
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveCustomer(
                final String customerId,
                final LocalDate startDate,
                final LocalDate endDate,
                final RequestOptions requestOptions) {
            return retrieveCustomer(
                    customerId,
                    startDate,
                    endDate,
                    UsageRetrieveCustomerOptions.none(),
                    requestOptions);
        }

        /**
         * Get customer usage
         *
         * <p>Retrieve aggregated usage data for a customer over a specified period.
         *
         * @param customerId the {@code customer_id} path parameter
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveCustomer(
                final String customerId,
                final LocalDate startDate,
                final LocalDate endDate,
                final UsageRetrieveCustomerOptions options,
                final RequestOptions requestOptions) {
            return Usage.this
                    .exchangeRetrieveCustomer(
                            customerId, startDate, endDate, options, requestOptions)
                    .sendRaw();
        }

        /**
         * Get subscription usage
         *
         * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
         * start_date/end_date are omitted, defaults to the current billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSubscription(final String subscriptionId) {
            return retrieveSubscription(
                    subscriptionId, UsageRetrieveSubscriptionOptions.none(), RequestOptions.none());
        }

        /**
         * Get subscription usage
         *
         * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
         * start_date/end_date are omitted, defaults to the current billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSubscription(
                final String subscriptionId, final UsageRetrieveSubscriptionOptions options) {
            return retrieveSubscription(subscriptionId, options, RequestOptions.none());
        }

        /**
         * Get subscription usage
         *
         * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
         * start_date/end_date are omitted, defaults to the current billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSubscription(
                final String subscriptionId, final RequestOptions requestOptions) {
            return retrieveSubscription(
                    subscriptionId, UsageRetrieveSubscriptionOptions.none(), requestOptions);
        }

        /**
         * Get subscription usage
         *
         * <p>Retrieve aggregated usage data for a subscription's usage-based components. If
         * start_date/end_date are omitted, defaults to the current billing period.
         *
         * @param subscriptionId the {@code subscription_id} path parameter
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSubscription(
                final String subscriptionId,
                final UsageRetrieveSubscriptionOptions options,
                final RequestOptions requestOptions) {
            return Usage.this
                    .exchangeRetrieveSubscription(subscriptionId, options, requestOptions)
                    .sendRaw();
        }

        /**
         * Get usage summary
         *
         * <p>Retrieve aggregated usage data across all customers for the tenant.
         *
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSummary(
                final LocalDate startDate, final LocalDate endDate) {
            return retrieveSummary(
                    startDate, endDate, UsageRetrieveSummaryOptions.none(), RequestOptions.none());
        }

        /**
         * Get usage summary
         *
         * <p>Retrieve aggregated usage data across all customers for the tenant.
         *
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSummary(
                final LocalDate startDate,
                final LocalDate endDate,
                final UsageRetrieveSummaryOptions options) {
            return retrieveSummary(startDate, endDate, options, RequestOptions.none());
        }

        /**
         * Get usage summary
         *
         * <p>Retrieve aggregated usage data across all customers for the tenant.
         *
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSummary(
                final LocalDate startDate,
                final LocalDate endDate,
                final RequestOptions requestOptions) {
            return retrieveSummary(
                    startDate, endDate, UsageRetrieveSummaryOptions.none(), requestOptions);
        }

        /**
         * Get usage summary
         *
         * <p>Retrieve aggregated usage data across all customers for the tenant.
         *
         * @param startDate the {@code start_date} required parameter
         * @param endDate the {@code end_date} required parameter
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<UsageResponse> retrieveSummary(
                final LocalDate startDate,
                final LocalDate endDate,
                final UsageRetrieveSummaryOptions options,
                final RequestOptions requestOptions) {
            return Usage.this
                    .exchangeRetrieveSummary(startDate, endDate, options, requestOptions)
                    .sendRaw();
        }
    }
}

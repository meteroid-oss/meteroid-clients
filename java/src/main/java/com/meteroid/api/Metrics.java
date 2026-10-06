// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CreateMetricRequest;
import com.meteroid.models.Metric;
import com.meteroid.models.MetricListResponse;
import com.meteroid.models.UpdateMetricRequest;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code metrics} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Metrics {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Metrics(MeteroidHttpClient client) {
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
     * List billable metrics
     *
     * @return the response body
     */
    public MetricListResponse list() {
        return list(MetricsListOptions.none(), RequestOptions.none());
    }

    /**
     * List billable metrics
     *
     * @param options the optional parameters
     * @return the response body
     */
    public MetricListResponse list(final MetricsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List billable metrics
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public MetricListResponse list(final RequestOptions requestOptions) {
        return list(MetricsListOptions.none(), requestOptions);
    }

    /**
     * List billable metrics
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public MetricListResponse list(
            final MetricsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<MetricListResponse> exchangeList(
            final MetricsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/metrics");
        String value1 = options.productFamilyId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("product_family_id", value1);
        }
        String value2 = options.search().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("search", value2);
        }
        String value3 = options.orderBy().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("order_by", value3);
        }
        Integer value4 = options.page().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value4));
        }
        Integer value5 = options.perPage().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value5));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429")
                .options(requestOptions)
                .returning(MetricListResponse.class);
    }

    /**
     * Create a billable metric
     *
     * @param createMetricRequest the request body
     * @return the response body
     */
    public Metric create(final CreateMetricRequest createMetricRequest) {
        return create(createMetricRequest, RequestOptions.none());
    }

    /**
     * Create a billable metric
     *
     * @param createMetricRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Metric create(
            final CreateMetricRequest createMetricRequest, final RequestOptions requestOptions) {
        return exchangeCreate(createMetricRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Metric> exchangeCreate(
            final CreateMetricRequest createMetricRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(createMetricRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/metrics").build();
        return client.call("POST", url)
                .json(createMetricRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429")
                .options(requestOptions)
                .returning(Metric.class);
    }

    /**
     * Get metric details
     *
     * @param metricId the {@code metric_id} path parameter
     * @return the response body
     */
    public Metric retrieve(final String metricId) {
        return retrieve(metricId, RequestOptions.none());
    }

    /**
     * Get metric details
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Metric retrieve(final String metricId, final RequestOptions requestOptions) {
        return exchangeRetrieve(metricId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Metric> exchangeRetrieve(
            final String metricId, final RequestOptions requestOptions) {
        Objects.requireNonNull(metricId, "metric_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/metrics")
                        .addPathSegment(Utils.pathSegment("metric_id", metricId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(Metric.class);
    }

    /**
     * Update a billable metric
     *
     * <p>Partially update metric fields. Code and aggregation_type are immutable.
     *
     * @param metricId the {@code metric_id} path parameter
     * @param updateMetricRequest the request body
     * @return the response body
     */
    public Metric update(final String metricId, final UpdateMetricRequest updateMetricRequest) {
        return update(metricId, updateMetricRequest, RequestOptions.none());
    }

    /**
     * Update a billable metric
     *
     * <p>Partially update metric fields. Code and aggregation_type are immutable.
     *
     * @param metricId the {@code metric_id} path parameter
     * @param updateMetricRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Metric update(
            final String metricId,
            final UpdateMetricRequest updateMetricRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(metricId, updateMetricRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Metric> exchangeUpdate(
            final String metricId,
            final UpdateMetricRequest updateMetricRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(metricId, "metric_id");
        Objects.requireNonNull(updateMetricRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/metrics")
                        .addPathSegment(Utils.pathSegment("metric_id", metricId))
                        .build();
        return client.call("PATCH", url)
                .json(updateMetricRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(Metric.class);
    }

    /**
     * Archive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     */
    public void archive(final String metricId) {
        archive(metricId, RequestOptions.none());
    }

    /**
     * Archive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String metricId, final RequestOptions requestOptions) {
        exchangeArchive(metricId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String metricId, final RequestOptions requestOptions) {
        Objects.requireNonNull(metricId, "metric_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/metrics")
                        .addPathSegment(Utils.pathSegment("metric_id", metricId))
                        .addPathSegments("archive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Unarchive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     */
    public void unarchive(final String metricId) {
        unarchive(metricId, RequestOptions.none());
    }

    /**
     * Unarchive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String metricId, final RequestOptions requestOptions) {
        exchangeUnarchive(metricId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String metricId, final RequestOptions requestOptions) {
        Objects.requireNonNull(metricId, "metric_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/metrics")
                        .addPathSegment(Utils.pathSegment("metric_id", metricId))
                        .addPathSegments("unarchive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List billable metrics
         *
         * @return the status, headers and body
         */
        public ApiResponse<MetricListResponse> list() {
            return list(MetricsListOptions.none(), RequestOptions.none());
        }

        /**
         * List billable metrics
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<MetricListResponse> list(final MetricsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List billable metrics
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<MetricListResponse> list(final RequestOptions requestOptions) {
            return list(MetricsListOptions.none(), requestOptions);
        }

        /**
         * List billable metrics
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<MetricListResponse> list(
                final MetricsListOptions options, final RequestOptions requestOptions) {
            return Metrics.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create a billable metric
         *
         * @param createMetricRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Metric> create(final CreateMetricRequest createMetricRequest) {
            return create(createMetricRequest, RequestOptions.none());
        }

        /**
         * Create a billable metric
         *
         * @param createMetricRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Metric> create(
                final CreateMetricRequest createMetricRequest,
                final RequestOptions requestOptions) {
            return Metrics.this.exchangeCreate(createMetricRequest, requestOptions).sendRaw();
        }

        /**
         * Get metric details
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Metric> retrieve(final String metricId) {
            return retrieve(metricId, RequestOptions.none());
        }

        /**
         * Get metric details
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Metric> retrieve(
                final String metricId, final RequestOptions requestOptions) {
            return Metrics.this.exchangeRetrieve(metricId, requestOptions).sendRaw();
        }

        /**
         * Update a billable metric
         *
         * <p>Partially update metric fields. Code and aggregation_type are immutable.
         *
         * @param metricId the {@code metric_id} path parameter
         * @param updateMetricRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Metric> update(
                final String metricId, final UpdateMetricRequest updateMetricRequest) {
            return update(metricId, updateMetricRequest, RequestOptions.none());
        }

        /**
         * Update a billable metric
         *
         * <p>Partially update metric fields. Code and aggregation_type are immutable.
         *
         * @param metricId the {@code metric_id} path parameter
         * @param updateMetricRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Metric> update(
                final String metricId,
                final UpdateMetricRequest updateMetricRequest,
                final RequestOptions requestOptions) {
            return Metrics.this
                    .exchangeUpdate(metricId, updateMetricRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String metricId) {
            return archive(metricId, RequestOptions.none());
        }

        /**
         * Archive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(
                final String metricId, final RequestOptions requestOptions) {
            return Metrics.this.exchangeArchive(metricId, requestOptions).sendRaw();
        }

        /**
         * Unarchive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String metricId) {
            return unarchive(metricId, RequestOptions.none());
        }

        /**
         * Unarchive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String metricId, final RequestOptions requestOptions) {
            return Metrics.this.exchangeUnarchive(metricId, requestOptions).sendRaw();
        }
    }
}

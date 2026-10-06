// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CreateMetricRequest;
import com.meteroid.models.Metric;
import com.meteroid.models.MetricListResponse;
import com.meteroid.models.UpdateMetricRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code metrics} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class MetricsAsync {
    private final Metrics sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public MetricsAsync(Metrics sync) {
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
     * List billable metrics
     *
     * @return the response body, once received
     */
    public CompletableFuture<MetricListResponse> list() {
        return list(MetricsListOptions.none(), RequestOptions.none());
    }

    /**
     * List billable metrics
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<MetricListResponse> list(final MetricsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List billable metrics
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<MetricListResponse> list(final RequestOptions requestOptions) {
        return list(MetricsListOptions.none(), requestOptions);
    }

    /**
     * List billable metrics
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<MetricListResponse> list(
            final MetricsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create a billable metric
     *
     * @param createMetricRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Metric> create(final CreateMetricRequest createMetricRequest) {
        return create(createMetricRequest, RequestOptions.none());
    }

    /**
     * Create a billable metric
     *
     * @param createMetricRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Metric> create(
            final CreateMetricRequest createMetricRequest, final RequestOptions requestOptions) {
        return sync.exchangeCreate(createMetricRequest, requestOptions).sendAsync();
    }

    /**
     * Get metric details
     *
     * @param metricId the {@code metric_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Metric> retrieve(final String metricId) {
        return retrieve(metricId, RequestOptions.none());
    }

    /**
     * Get metric details
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Metric> retrieve(
            final String metricId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(metricId, requestOptions).sendAsync();
    }

    /**
     * Update a billable metric
     *
     * <p>Partially update metric fields. Code and aggregation_type are immutable.
     *
     * @param metricId the {@code metric_id} path parameter
     * @param updateMetricRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Metric> update(
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
     * @return the response body, once received
     */
    public CompletableFuture<Metric> update(
            final String metricId,
            final UpdateMetricRequest updateMetricRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(metricId, updateMetricRequest, requestOptions).sendAsync();
    }

    /**
     * Archive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(final String metricId) {
        return archive(metricId, RequestOptions.none());
    }

    /**
     * Archive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(
            final String metricId, final RequestOptions requestOptions) {
        return sync.exchangeArchive(metricId, requestOptions).sendAsync();
    }

    /**
     * Unarchive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(final String metricId) {
        return unarchive(metricId, RequestOptions.none());
    }

    /**
     * Unarchive a billable metric
     *
     * @param metricId the {@code metric_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(
            final String metricId, final RequestOptions requestOptions) {
        return sync.exchangeUnarchive(metricId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List billable metrics
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<MetricListResponse>> list() {
            return list(MetricsListOptions.none(), RequestOptions.none());
        }

        /**
         * List billable metrics
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<MetricListResponse>> list(
                final MetricsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List billable metrics
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<MetricListResponse>> list(
                final RequestOptions requestOptions) {
            return list(MetricsListOptions.none(), requestOptions);
        }

        /**
         * List billable metrics
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<MetricListResponse>> list(
                final MetricsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create a billable metric
         *
         * @param createMetricRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> create(
                final CreateMetricRequest createMetricRequest) {
            return create(createMetricRequest, RequestOptions.none());
        }

        /**
         * Create a billable metric
         *
         * @param createMetricRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> create(
                final CreateMetricRequest createMetricRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(createMetricRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get metric details
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> retrieve(final String metricId) {
            return retrieve(metricId, RequestOptions.none());
        }

        /**
         * Get metric details
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> retrieve(
                final String metricId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(metricId, requestOptions).sendRawAsync();
        }

        /**
         * Update a billable metric
         *
         * <p>Partially update metric fields. Code and aggregation_type are immutable.
         *
         * @param metricId the {@code metric_id} path parameter
         * @param updateMetricRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> update(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Metric>> update(
                final String metricId,
                final UpdateMetricRequest updateMetricRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(metricId, updateMetricRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Archive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(final String metricId) {
            return archive(metricId, RequestOptions.none());
        }

        /**
         * Archive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(
                final String metricId, final RequestOptions requestOptions) {
            return sync.exchangeArchive(metricId, requestOptions).sendRawAsync();
        }

        /**
         * Unarchive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(final String metricId) {
            return unarchive(metricId, RequestOptions.none());
        }

        /**
         * Unarchive a billable metric
         *
         * @param metricId the {@code metric_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(
                final String metricId, final RequestOptions requestOptions) {
            return sync.exchangeUnarchive(metricId, requestOptions).sendRawAsync();
        }
    }
}

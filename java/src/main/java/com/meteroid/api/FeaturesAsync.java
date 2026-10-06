// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.Feature;
import com.meteroid.models.FeatureListResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code features} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class FeaturesAsync {
    private final Features sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public FeaturesAsync(Features sync) {
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
     * List features
     *
     * @return the response body, once received
     */
    public CompletableFuture<FeatureListResponse> list() {
        return list(FeaturesListOptions.none(), RequestOptions.none());
    }

    /**
     * List features
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<FeatureListResponse> list(final FeaturesListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List features
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<FeatureListResponse> list(final RequestOptions requestOptions) {
        return list(FeaturesListOptions.none(), requestOptions);
    }

    /**
     * List features
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<FeatureListResponse> list(
            final FeaturesListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Get feature details
     *
     * @param idOrCode the {@code id_or_code} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Feature> retrieve(final String idOrCode) {
        return retrieve(idOrCode, RequestOptions.none());
    }

    /**
     * Get feature details
     *
     * @param idOrCode the {@code id_or_code} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Feature> retrieve(
            final String idOrCode, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(idOrCode, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List features
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<FeatureListResponse>> list() {
            return list(FeaturesListOptions.none(), RequestOptions.none());
        }

        /**
         * List features
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<FeatureListResponse>> list(
                final FeaturesListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List features
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<FeatureListResponse>> list(
                final RequestOptions requestOptions) {
            return list(FeaturesListOptions.none(), requestOptions);
        }

        /**
         * List features
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<FeatureListResponse>> list(
                final FeaturesListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Get feature details
         *
         * @param idOrCode the {@code id_or_code} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Feature>> retrieve(final String idOrCode) {
            return retrieve(idOrCode, RequestOptions.none());
        }

        /**
         * Get feature details
         *
         * @param idOrCode the {@code id_or_code} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Feature>> retrieve(
                final String idOrCode, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(idOrCode, requestOptions).sendRawAsync();
        }
    }
}

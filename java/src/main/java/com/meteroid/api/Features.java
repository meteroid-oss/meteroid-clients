// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.Feature;
import com.meteroid.models.FeatureListResponse;
import com.meteroid.models.FeatureStatus;

import okhttp3.HttpUrl;

import java.util.List;
import java.util.Objects;

/**
 * The {@code features} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Features {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Features(MeteroidHttpClient client) {
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
     * List features
     *
     * @return the response body
     */
    public FeatureListResponse list() {
        return list(FeaturesListOptions.none(), RequestOptions.none());
    }

    /**
     * List features
     *
     * @param options the optional parameters
     * @return the response body
     */
    public FeatureListResponse list(final FeaturesListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List features
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public FeatureListResponse list(final RequestOptions requestOptions) {
        return list(FeaturesListOptions.none(), requestOptions);
    }

    /**
     * List features
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public FeatureListResponse list(
            final FeaturesListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<FeatureListResponse> exchangeList(
            final FeaturesListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/features");
        List<FeatureStatus> value1 = options.statuses().orElse(null);
        if (value1 != null) {
            Utils.addExplodedQueryParameter(url, "statuses", value1);
        }
        String value2 = options.productId().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("product_id", value2);
        }
        String value3 = options.search().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("search", value3);
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
                .returning(FeatureListResponse.class);
    }

    /**
     * Get feature details
     *
     * @param idOrCode the {@code id_or_code} path parameter
     * @return the response body
     */
    public Feature retrieve(final String idOrCode) {
        return retrieve(idOrCode, RequestOptions.none());
    }

    /**
     * Get feature details
     *
     * @param idOrCode the {@code id_or_code} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Feature retrieve(final String idOrCode, final RequestOptions requestOptions) {
        return exchangeRetrieve(idOrCode, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Feature> exchangeRetrieve(
            final String idOrCode, final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrCode, "id_or_code");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/features")
                        .addPathSegment(Utils.pathSegment("id_or_code", idOrCode))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(Feature.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List features
         *
         * @return the status, headers and body
         */
        public ApiResponse<FeatureListResponse> list() {
            return list(FeaturesListOptions.none(), RequestOptions.none());
        }

        /**
         * List features
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<FeatureListResponse> list(final FeaturesListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List features
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<FeatureListResponse> list(final RequestOptions requestOptions) {
            return list(FeaturesListOptions.none(), requestOptions);
        }

        /**
         * List features
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<FeatureListResponse> list(
                final FeaturesListOptions options, final RequestOptions requestOptions) {
            return Features.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Get feature details
         *
         * @param idOrCode the {@code id_or_code} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Feature> retrieve(final String idOrCode) {
            return retrieve(idOrCode, RequestOptions.none());
        }

        /**
         * Get feature details
         *
         * @param idOrCode the {@code id_or_code} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Feature> retrieve(
                final String idOrCode, final RequestOptions requestOptions) {
            return Features.this.exchangeRetrieve(idOrCode, requestOptions).sendRaw();
        }
    }
}

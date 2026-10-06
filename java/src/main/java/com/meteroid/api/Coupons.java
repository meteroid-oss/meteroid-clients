// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.Coupon;
import com.meteroid.models.CouponFilter;
import com.meteroid.models.CouponListResponse;
import com.meteroid.models.CreateCouponRequest;
import com.meteroid.models.UpdateCouponRequest;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code coupons} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Coupons {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Coupons(MeteroidHttpClient client) {
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
     * List coupons
     *
     * @return the response body
     */
    public CouponListResponse list() {
        return list(CouponsListOptions.none(), RequestOptions.none());
    }

    /**
     * List coupons
     *
     * @param options the optional parameters
     * @return the response body
     */
    public CouponListResponse list(final CouponsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List coupons
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CouponListResponse list(final RequestOptions requestOptions) {
        return list(CouponsListOptions.none(), requestOptions);
    }

    /**
     * List coupons
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CouponListResponse list(
            final CouponsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CouponListResponse> exchangeList(
            final CouponsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/coupons");
        String value1 = options.search().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("search", value1);
        }
        CouponFilter value2 = options.filter().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("filter", Utils.serializeQueryParam(value2));
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
                .returning(CouponListResponse.class);
    }

    /**
     * Create a coupon
     *
     * @param createCouponRequest the request body
     * @return the response body
     */
    public Coupon create(final CreateCouponRequest createCouponRequest) {
        return create(createCouponRequest, RequestOptions.none());
    }

    /**
     * Create a coupon
     *
     * @param createCouponRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Coupon create(
            final CreateCouponRequest createCouponRequest, final RequestOptions requestOptions) {
        return exchangeCreate(createCouponRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Coupon> exchangeCreate(
            final CreateCouponRequest createCouponRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(createCouponRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/coupons").build();
        return client.call("POST", url)
                .json(createCouponRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429")
                .options(requestOptions)
                .returning(Coupon.class);
    }

    /**
     * Get coupon details
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body
     */
    public Coupon retrieve(final String couponId) {
        return retrieve(couponId, RequestOptions.none());
    }

    /**
     * Get coupon details
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Coupon retrieve(final String couponId, final RequestOptions requestOptions) {
        return exchangeRetrieve(couponId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Coupon> exchangeRetrieve(
            final String couponId, final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(Coupon.class);
    }

    /**
     * Update a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param updateCouponRequest the request body
     * @return the response body
     */
    public Coupon update(final String couponId, final UpdateCouponRequest updateCouponRequest) {
        return update(couponId, updateCouponRequest, RequestOptions.none());
    }

    /**
     * Update a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param updateCouponRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Coupon update(
            final String couponId,
            final UpdateCouponRequest updateCouponRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(couponId, updateCouponRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Coupon> exchangeUpdate(
            final String couponId,
            final UpdateCouponRequest updateCouponRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        Objects.requireNonNull(updateCouponRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
                        .build();
        return client.call("PATCH", url)
                .json(updateCouponRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(Coupon.class);
    }

    /**
     * Archive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     */
    public void archive(final String couponId) {
        archive(couponId, RequestOptions.none());
    }

    /**
     * Archive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String couponId, final RequestOptions requestOptions) {
        exchangeArchive(couponId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String couponId, final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
                        .addPathSegments("archive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Disable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     */
    public void disable(final String couponId) {
        disable(couponId, RequestOptions.none());
    }

    /**
     * Disable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void disable(final String couponId, final RequestOptions requestOptions) {
        exchangeDisable(couponId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeDisable(
            final String couponId, final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
                        .addPathSegments("disable")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Enable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     */
    public void enable(final String couponId) {
        enable(couponId, RequestOptions.none());
    }

    /**
     * Enable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void enable(final String couponId, final RequestOptions requestOptions) {
        exchangeEnable(couponId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeEnable(
            final String couponId, final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
                        .addPathSegments("enable")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Unarchive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     */
    public void unarchive(final String couponId) {
        unarchive(couponId, RequestOptions.none());
    }

    /**
     * Unarchive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String couponId, final RequestOptions requestOptions) {
        exchangeUnarchive(couponId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String couponId, final RequestOptions requestOptions) {
        Objects.requireNonNull(couponId, "coupon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/coupons")
                        .addPathSegment(Utils.pathSegment("coupon_id", couponId))
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
         * List coupons
         *
         * @return the status, headers and body
         */
        public ApiResponse<CouponListResponse> list() {
            return list(CouponsListOptions.none(), RequestOptions.none());
        }

        /**
         * List coupons
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<CouponListResponse> list(final CouponsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List coupons
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CouponListResponse> list(final RequestOptions requestOptions) {
            return list(CouponsListOptions.none(), requestOptions);
        }

        /**
         * List coupons
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CouponListResponse> list(
                final CouponsListOptions options, final RequestOptions requestOptions) {
            return Coupons.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create a coupon
         *
         * @param createCouponRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> create(final CreateCouponRequest createCouponRequest) {
            return create(createCouponRequest, RequestOptions.none());
        }

        /**
         * Create a coupon
         *
         * @param createCouponRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> create(
                final CreateCouponRequest createCouponRequest,
                final RequestOptions requestOptions) {
            return Coupons.this.exchangeCreate(createCouponRequest, requestOptions).sendRaw();
        }

        /**
         * Get coupon details
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> retrieve(final String couponId) {
            return retrieve(couponId, RequestOptions.none());
        }

        /**
         * Get coupon details
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> retrieve(
                final String couponId, final RequestOptions requestOptions) {
            return Coupons.this.exchangeRetrieve(couponId, requestOptions).sendRaw();
        }

        /**
         * Update a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param updateCouponRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> update(
                final String couponId, final UpdateCouponRequest updateCouponRequest) {
            return update(couponId, updateCouponRequest, RequestOptions.none());
        }

        /**
         * Update a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param updateCouponRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Coupon> update(
                final String couponId,
                final UpdateCouponRequest updateCouponRequest,
                final RequestOptions requestOptions) {
            return Coupons.this
                    .exchangeUpdate(couponId, updateCouponRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String couponId) {
            return archive(couponId, RequestOptions.none());
        }

        /**
         * Archive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(
                final String couponId, final RequestOptions requestOptions) {
            return Coupons.this.exchangeArchive(couponId, requestOptions).sendRaw();
        }

        /**
         * Disable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> disable(final String couponId) {
            return disable(couponId, RequestOptions.none());
        }

        /**
         * Disable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> disable(
                final String couponId, final RequestOptions requestOptions) {
            return Coupons.this.exchangeDisable(couponId, requestOptions).sendRaw();
        }

        /**
         * Enable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> enable(final String couponId) {
            return enable(couponId, RequestOptions.none());
        }

        /**
         * Enable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> enable(
                final String couponId, final RequestOptions requestOptions) {
            return Coupons.this.exchangeEnable(couponId, requestOptions).sendRaw();
        }

        /**
         * Unarchive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String couponId) {
            return unarchive(couponId, RequestOptions.none());
        }

        /**
         * Unarchive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String couponId, final RequestOptions requestOptions) {
            return Coupons.this.exchangeUnarchive(couponId, requestOptions).sendRaw();
        }
    }
}

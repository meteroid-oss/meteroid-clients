// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.Coupon;
import com.meteroid.models.CouponListResponse;
import com.meteroid.models.CreateCouponRequest;
import com.meteroid.models.UpdateCouponRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code coupons} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class CouponsAsync {
    private final Coupons sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public CouponsAsync(Coupons sync) {
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
     * List coupons
     *
     * @return the response body, once received
     */
    public CompletableFuture<CouponListResponse> list() {
        return list(CouponsListOptions.none(), RequestOptions.none());
    }

    /**
     * List coupons
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<CouponListResponse> list(final CouponsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List coupons
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CouponListResponse> list(final RequestOptions requestOptions) {
        return list(CouponsListOptions.none(), requestOptions);
    }

    /**
     * List coupons
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CouponListResponse> list(
            final CouponsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create a coupon
     *
     * @param createCouponRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> create(final CreateCouponRequest createCouponRequest) {
        return create(createCouponRequest, RequestOptions.none());
    }

    /**
     * Create a coupon
     *
     * @param createCouponRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> create(
            final CreateCouponRequest createCouponRequest, final RequestOptions requestOptions) {
        return sync.exchangeCreate(createCouponRequest, requestOptions).sendAsync();
    }

    /**
     * Get coupon details
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> retrieve(final String couponId) {
        return retrieve(couponId, RequestOptions.none());
    }

    /**
     * Get coupon details
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> retrieve(
            final String couponId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(couponId, requestOptions).sendAsync();
    }

    /**
     * Update a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param updateCouponRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> update(
            final String couponId, final UpdateCouponRequest updateCouponRequest) {
        return update(couponId, updateCouponRequest, RequestOptions.none());
    }

    /**
     * Update a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param updateCouponRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Coupon> update(
            final String couponId,
            final UpdateCouponRequest updateCouponRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(couponId, updateCouponRequest, requestOptions).sendAsync();
    }

    /**
     * Archive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(final String couponId) {
        return archive(couponId, RequestOptions.none());
    }

    /**
     * Archive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(
            final String couponId, final RequestOptions requestOptions) {
        return sync.exchangeArchive(couponId, requestOptions).sendAsync();
    }

    /**
     * Disable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> disable(final String couponId) {
        return disable(couponId, RequestOptions.none());
    }

    /**
     * Disable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> disable(
            final String couponId, final RequestOptions requestOptions) {
        return sync.exchangeDisable(couponId, requestOptions).sendAsync();
    }

    /**
     * Enable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> enable(final String couponId) {
        return enable(couponId, RequestOptions.none());
    }

    /**
     * Enable a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> enable(
            final String couponId, final RequestOptions requestOptions) {
        return sync.exchangeEnable(couponId, requestOptions).sendAsync();
    }

    /**
     * Unarchive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(final String couponId) {
        return unarchive(couponId, RequestOptions.none());
    }

    /**
     * Unarchive a coupon
     *
     * @param couponId the {@code coupon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(
            final String couponId, final RequestOptions requestOptions) {
        return sync.exchangeUnarchive(couponId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List coupons
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CouponListResponse>> list() {
            return list(CouponsListOptions.none(), RequestOptions.none());
        }

        /**
         * List coupons
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CouponListResponse>> list(
                final CouponsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List coupons
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CouponListResponse>> list(
                final RequestOptions requestOptions) {
            return list(CouponsListOptions.none(), requestOptions);
        }

        /**
         * List coupons
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CouponListResponse>> list(
                final CouponsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create a coupon
         *
         * @param createCouponRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> create(
                final CreateCouponRequest createCouponRequest) {
            return create(createCouponRequest, RequestOptions.none());
        }

        /**
         * Create a coupon
         *
         * @param createCouponRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> create(
                final CreateCouponRequest createCouponRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(createCouponRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get coupon details
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> retrieve(final String couponId) {
            return retrieve(couponId, RequestOptions.none());
        }

        /**
         * Get coupon details
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> retrieve(
                final String couponId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(couponId, requestOptions).sendRawAsync();
        }

        /**
         * Update a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param updateCouponRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> update(
                final String couponId, final UpdateCouponRequest updateCouponRequest) {
            return update(couponId, updateCouponRequest, RequestOptions.none());
        }

        /**
         * Update a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param updateCouponRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Coupon>> update(
                final String couponId,
                final UpdateCouponRequest updateCouponRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(couponId, updateCouponRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Archive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(final String couponId) {
            return archive(couponId, RequestOptions.none());
        }

        /**
         * Archive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(
                final String couponId, final RequestOptions requestOptions) {
            return sync.exchangeArchive(couponId, requestOptions).sendRawAsync();
        }

        /**
         * Disable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> disable(final String couponId) {
            return disable(couponId, RequestOptions.none());
        }

        /**
         * Disable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> disable(
                final String couponId, final RequestOptions requestOptions) {
            return sync.exchangeDisable(couponId, requestOptions).sendRawAsync();
        }

        /**
         * Enable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> enable(final String couponId) {
            return enable(couponId, RequestOptions.none());
        }

        /**
         * Enable a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> enable(
                final String couponId, final RequestOptions requestOptions) {
            return sync.exchangeEnable(couponId, requestOptions).sendRawAsync();
        }

        /**
         * Unarchive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(final String couponId) {
            return unarchive(couponId, RequestOptions.none());
        }

        /**
         * Unarchive a coupon
         *
         * @param couponId the {@code coupon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(
                final String couponId, final RequestOptions requestOptions) {
            return sync.exchangeUnarchive(couponId, requestOptions).sendRawAsync();
        }
    }
}

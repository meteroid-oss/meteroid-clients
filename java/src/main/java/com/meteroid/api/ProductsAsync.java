// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CreateProductRequest;
import com.meteroid.models.Product;
import com.meteroid.models.ProductListResponse;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.UpdateProductRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code products} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class ProductsAsync {
    private final Products sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public ProductsAsync(Products sync) {
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
     * List products
     *
     * @return the response body, once received
     */
    public CompletableFuture<ProductListResponse> list() {
        return list(ProductsListOptions.none(), RequestOptions.none());
    }

    /**
     * List products
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<ProductListResponse> list(final ProductsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List products
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ProductListResponse> list(final RequestOptions requestOptions) {
        return list(ProductsListOptions.none(), requestOptions);
    }

    /**
     * List products
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ProductListResponse> list(
            final ProductsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create a product
     *
     * @param createProductRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Product> create(final CreateProductRequest createProductRequest) {
        return create(createProductRequest, RequestOptions.none());
    }

    /**
     * Create a product
     *
     * @param createProductRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Product> create(
            final CreateProductRequest createProductRequest, final RequestOptions requestOptions) {
        return sync.exchangeCreate(createProductRequest, requestOptions).sendAsync();
    }

    /**
     * Get product details
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Product> retrieve(final String productId) {
        return retrieve(productId, RequestOptions.none());
    }

    /**
     * Get product details
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Product> retrieve(
            final String productId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(productId, requestOptions).sendAsync();
    }

    /**
     * Update a product
     *
     * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
     *
     * @param productId the {@code product_id} path parameter
     * @param updateProductRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Product> update(
            final String productId, final UpdateProductRequest updateProductRequest) {
        return update(productId, updateProductRequest, RequestOptions.none());
    }

    /**
     * Update a product
     *
     * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
     *
     * @param productId the {@code product_id} path parameter
     * @param updateProductRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Product> update(
            final String productId,
            final UpdateProductRequest updateProductRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(productId, updateProductRequest, requestOptions).sendAsync();
    }

    /**
     * Archive a product
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(final String productId) {
        return archive(productId, RequestOptions.none());
    }

    /**
     * Archive a product
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(
            final String productId, final RequestOptions requestOptions) {
        return sync.exchangeArchive(productId, requestOptions).sendAsync();
    }

    /**
     * List product entitlements
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<ResolvedEntitlementListResponse> listEntitlements(
            final String productId) {
        return listEntitlements(productId, RequestOptions.none());
    }

    /**
     * List product entitlements
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ResolvedEntitlementListResponse> listEntitlements(
            final String productId, final RequestOptions requestOptions) {
        return sync.exchangeListEntitlements(productId, requestOptions).sendAsync();
    }

    /**
     * Unarchive a product
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(final String productId) {
        return unarchive(productId, RequestOptions.none());
    }

    /**
     * Unarchive a product
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(
            final String productId, final RequestOptions requestOptions) {
        return sync.exchangeUnarchive(productId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List products
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ProductListResponse>> list() {
            return list(ProductsListOptions.none(), RequestOptions.none());
        }

        /**
         * List products
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ProductListResponse>> list(
                final ProductsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List products
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ProductListResponse>> list(
                final RequestOptions requestOptions) {
            return list(ProductsListOptions.none(), requestOptions);
        }

        /**
         * List products
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ProductListResponse>> list(
                final ProductsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create a product
         *
         * @param createProductRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> create(
                final CreateProductRequest createProductRequest) {
            return create(createProductRequest, RequestOptions.none());
        }

        /**
         * Create a product
         *
         * @param createProductRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> create(
                final CreateProductRequest createProductRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(createProductRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get product details
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> retrieve(final String productId) {
            return retrieve(productId, RequestOptions.none());
        }

        /**
         * Get product details
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> retrieve(
                final String productId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(productId, requestOptions).sendRawAsync();
        }

        /**
         * Update a product
         *
         * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
         *
         * @param productId the {@code product_id} path parameter
         * @param updateProductRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> update(
                final String productId, final UpdateProductRequest updateProductRequest) {
            return update(productId, updateProductRequest, RequestOptions.none());
        }

        /**
         * Update a product
         *
         * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
         *
         * @param productId the {@code product_id} path parameter
         * @param updateProductRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Product>> update(
                final String productId,
                final UpdateProductRequest updateProductRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(productId, updateProductRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Archive a product
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(final String productId) {
            return archive(productId, RequestOptions.none());
        }

        /**
         * Archive a product
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(
                final String productId, final RequestOptions requestOptions) {
            return sync.exchangeArchive(productId, requestOptions).sendRawAsync();
        }

        /**
         * List product entitlements
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ResolvedEntitlementListResponse>> listEntitlements(
                final String productId) {
            return listEntitlements(productId, RequestOptions.none());
        }

        /**
         * List product entitlements
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ResolvedEntitlementListResponse>> listEntitlements(
                final String productId, final RequestOptions requestOptions) {
            return sync.exchangeListEntitlements(productId, requestOptions).sendRawAsync();
        }

        /**
         * Unarchive a product
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(final String productId) {
            return unarchive(productId, RequestOptions.none());
        }

        /**
         * Unarchive a product
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(
                final String productId, final RequestOptions requestOptions) {
            return sync.exchangeUnarchive(productId, requestOptions).sendRawAsync();
        }
    }
}

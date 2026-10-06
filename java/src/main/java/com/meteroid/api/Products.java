// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CreateProductRequest;
import com.meteroid.models.Product;
import com.meteroid.models.ProductListResponse;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.UpdateProductRequest;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code products} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Products {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Products(MeteroidHttpClient client) {
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
     * List products
     *
     * @return the response body
     */
    public ProductListResponse list() {
        return list(ProductsListOptions.none(), RequestOptions.none());
    }

    /**
     * List products
     *
     * @param options the optional parameters
     * @return the response body
     */
    public ProductListResponse list(final ProductsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List products
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ProductListResponse list(final RequestOptions requestOptions) {
        return list(ProductsListOptions.none(), requestOptions);
    }

    /**
     * List products
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ProductListResponse list(
            final ProductsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ProductListResponse> exchangeList(
            final ProductsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/products");
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
                .returning(ProductListResponse.class);
    }

    /**
     * Create a product
     *
     * @param createProductRequest the request body
     * @return the response body
     */
    public Product create(final CreateProductRequest createProductRequest) {
        return create(createProductRequest, RequestOptions.none());
    }

    /**
     * Create a product
     *
     * @param createProductRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Product create(
            final CreateProductRequest createProductRequest, final RequestOptions requestOptions) {
        return exchangeCreate(createProductRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Product> exchangeCreate(
            final CreateProductRequest createProductRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(createProductRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/products").build();
        return client.call("POST", url)
                .json(createProductRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429")
                .options(requestOptions)
                .returning(Product.class);
    }

    /**
     * Get product details
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body
     */
    public Product retrieve(final String productId) {
        return retrieve(productId, RequestOptions.none());
    }

    /**
     * Get product details
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Product retrieve(final String productId, final RequestOptions requestOptions) {
        return exchangeRetrieve(productId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Product> exchangeRetrieve(
            final String productId, final RequestOptions requestOptions) {
        Objects.requireNonNull(productId, "product_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/products")
                        .addPathSegment(Utils.pathSegment("product_id", productId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(Product.class);
    }

    /**
     * Update a product
     *
     * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
     *
     * @param productId the {@code product_id} path parameter
     * @param updateProductRequest the request body
     * @return the response body
     */
    public Product update(final String productId, final UpdateProductRequest updateProductRequest) {
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
     * @return the response body
     */
    public Product update(
            final String productId,
            final UpdateProductRequest updateProductRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(productId, updateProductRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Product> exchangeUpdate(
            final String productId,
            final UpdateProductRequest updateProductRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(productId, "product_id");
        Objects.requireNonNull(updateProductRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/products")
                        .addPathSegment(Utils.pathSegment("product_id", productId))
                        .build();
        return client.call("PATCH", url)
                .json(updateProductRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(Product.class);
    }

    /**
     * Archive a product
     *
     * @param productId the {@code product_id} path parameter
     */
    public void archive(final String productId) {
        archive(productId, RequestOptions.none());
    }

    /**
     * Archive a product
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String productId, final RequestOptions requestOptions) {
        exchangeArchive(productId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String productId, final RequestOptions requestOptions) {
        Objects.requireNonNull(productId, "product_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/products")
                        .addPathSegment(Utils.pathSegment("product_id", productId))
                        .addPathSegments("archive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * List product entitlements
     *
     * @param productId the {@code product_id} path parameter
     * @return the response body
     */
    public ResolvedEntitlementListResponse listEntitlements(final String productId) {
        return listEntitlements(productId, RequestOptions.none());
    }

    /**
     * List product entitlements
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ResolvedEntitlementListResponse listEntitlements(
            final String productId, final RequestOptions requestOptions) {
        return exchangeListEntitlements(productId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ResolvedEntitlementListResponse> exchangeListEntitlements(
            final String productId, final RequestOptions requestOptions) {
        Objects.requireNonNull(productId, "product_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/products")
                        .addPathSegment(Utils.pathSegment("product_id", productId))
                        .addPathSegments("entitlements")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(ResolvedEntitlementListResponse.class);
    }

    /**
     * Unarchive a product
     *
     * @param productId the {@code product_id} path parameter
     */
    public void unarchive(final String productId) {
        unarchive(productId, RequestOptions.none());
    }

    /**
     * Unarchive a product
     *
     * @param productId the {@code product_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String productId, final RequestOptions requestOptions) {
        exchangeUnarchive(productId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String productId, final RequestOptions requestOptions) {
        Objects.requireNonNull(productId, "product_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/products")
                        .addPathSegment(Utils.pathSegment("product_id", productId))
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
         * List products
         *
         * @return the status, headers and body
         */
        public ApiResponse<ProductListResponse> list() {
            return list(ProductsListOptions.none(), RequestOptions.none());
        }

        /**
         * List products
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<ProductListResponse> list(final ProductsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List products
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ProductListResponse> list(final RequestOptions requestOptions) {
            return list(ProductsListOptions.none(), requestOptions);
        }

        /**
         * List products
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ProductListResponse> list(
                final ProductsListOptions options, final RequestOptions requestOptions) {
            return Products.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create a product
         *
         * @param createProductRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Product> create(final CreateProductRequest createProductRequest) {
            return create(createProductRequest, RequestOptions.none());
        }

        /**
         * Create a product
         *
         * @param createProductRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Product> create(
                final CreateProductRequest createProductRequest,
                final RequestOptions requestOptions) {
            return Products.this.exchangeCreate(createProductRequest, requestOptions).sendRaw();
        }

        /**
         * Get product details
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Product> retrieve(final String productId) {
            return retrieve(productId, RequestOptions.none());
        }

        /**
         * Get product details
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Product> retrieve(
                final String productId, final RequestOptions requestOptions) {
            return Products.this.exchangeRetrieve(productId, requestOptions).sendRaw();
        }

        /**
         * Update a product
         *
         * <p>Partially update product fields. The fee_type is immutable and cannot be changed.
         *
         * @param productId the {@code product_id} path parameter
         * @param updateProductRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Product> update(
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
         * @return the status, headers and body
         */
        public ApiResponse<Product> update(
                final String productId,
                final UpdateProductRequest updateProductRequest,
                final RequestOptions requestOptions) {
            return Products.this
                    .exchangeUpdate(productId, updateProductRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive a product
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String productId) {
            return archive(productId, RequestOptions.none());
        }

        /**
         * Archive a product
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(
                final String productId, final RequestOptions requestOptions) {
            return Products.this.exchangeArchive(productId, requestOptions).sendRaw();
        }

        /**
         * List product entitlements
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listEntitlements(
                final String productId) {
            return listEntitlements(productId, RequestOptions.none());
        }

        /**
         * List product entitlements
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listEntitlements(
                final String productId, final RequestOptions requestOptions) {
            return Products.this.exchangeListEntitlements(productId, requestOptions).sendRaw();
        }

        /**
         * Unarchive a product
         *
         * @param productId the {@code product_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String productId) {
            return unarchive(productId, RequestOptions.none());
        }

        /**
         * Unarchive a product
         *
         * @param productId the {@code product_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String productId, final RequestOptions requestOptions) {
            return Products.this.exchangeUnarchive(productId, requestOptions).sendRaw();
        }
    }
}

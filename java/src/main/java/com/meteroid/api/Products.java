// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CreateProductRequest;
import com.meteroid.models.Product;
import com.meteroid.models.ProductListResponse;
import com.meteroid.models.UpdateProductRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Products {
    private final MeteroidHttpClient client;

    public Products(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public ProductListResponse listProducts() throws IOException, ApiException {

        return this.listProducts(new ProductsListProductsOptions());
    }

    /** */
    public ProductListResponse listProducts(final ProductsListProductsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/products");
        if (options.productFamilyId != null) {
            url.addQueryParameter(
                    "product_family_id", Utils.serializeQueryParam(options.productFamilyId));
        }
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        if (options.orderBy != null) {
            url.addQueryParameter("order_by", options.orderBy);
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, ProductListResponse.class);
    }

    /** */
    public Product createProduct(final CreateProductRequest createProductRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/products");
        return this.client.executeRequest(
                "POST", url.build(), null, createProductRequest, Product.class);
    }

    /** */
    public Product getProduct(final String productId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/products/%s", productId));
        return this.client.executeRequest("GET", url.build(), null, null, Product.class);
    }

    /** Partially update product fields. The fee_type is immutable and cannot be changed. */
    public Product updateProduct(
            final String productId, final UpdateProductRequest updateProductRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/products/%s", productId));
        return this.client.executeRequest(
                "PATCH", url.build(), null, updateProductRequest, Product.class);
    }

    /** */
    public void archiveProduct(final String productId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/products/%s/archive", productId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public void unarchiveProduct(final String productId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/products/%s/unarchive", productId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }
}

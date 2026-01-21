// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.ProductFamily;
import com.meteroid.models.ProductFamilyCreateRequest;
import com.meteroid.models.ProductFamilyListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class ProductFamilies {
    private final MeteroidHttpClient client;

    public ProductFamilies(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public ProductFamilyListResponse listProductFamilies() throws IOException, ApiException {

        return this.listProductFamilies(new ProductFamiliesListProductFamiliesOptions());
    }

    /** */
    public ProductFamilyListResponse listProductFamilies(
            final ProductFamiliesListProductFamiliesOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/product_families");
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, ProductFamilyListResponse.class);
    }

    /** */
    public ProductFamily createProductFamily(
            final ProductFamilyCreateRequest productFamilyCreateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/product_families");
        return this.client.executeRequest(
                "POST", url.build(), null, productFamilyCreateRequest, ProductFamily.class);
    }

    /** Retrieve a single product family by ID or alias. */
    public ProductFamily getProductFamilyByIdOrAlias(final String idOrAlias)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/product_families/%s", idOrAlias));
        return this.client.executeRequest("GET", url.build(), null, null, ProductFamily.class);
    }
}

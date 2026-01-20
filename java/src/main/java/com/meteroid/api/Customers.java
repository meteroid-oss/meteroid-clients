// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.Customer;
import com.meteroid.models.CustomerCreateRequest;
import com.meteroid.models.CustomerListResponse;
import com.meteroid.models.CustomerPatchRequest;
import com.meteroid.models.CustomerPortalTokenResponse;
import com.meteroid.models.CustomerUpdateRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Customers {
    private final MeteroidHttpClient client;

    public Customers(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List customers with optional pagination and search filtering. */
    public CustomerListResponse listCustomers() throws IOException, ApiException {

        return this.listCustomers(new CustomersListCustomersOptions());
    }

    /** List customers with optional pagination and search filtering. */
    public CustomerListResponse listCustomers(final CustomersListCustomersOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/customers");
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        if (options.archived != null) {
            url.addQueryParameter("archived", Utils.serializeQueryParam(options.archived));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, CustomerListResponse.class);
    }

    /** */
    public Customer createCustomer(final CustomerCreateRequest customerCreateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/customers");
        return this.client.executeRequest(
                "POST", url.build(), null, customerCreateRequest, Customer.class);
    }

    /** Retrieve a single customer by ID or alias. */
    public Customer getCustomer(final String idOrAlias) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s", idOrAlias));
        return this.client.executeRequest("GET", url.build(), null, null, Customer.class);
    }

    /** */
    public Customer updateCustomer(
            final String idOrAlias, final CustomerUpdateRequest customerUpdateRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s", idOrAlias));
        return this.client.executeRequest(
                "PUT", url.build(), null, customerUpdateRequest, Customer.class);
    }

    /**
     * No linked entity will be deleted. You need to terminate all active subscriptions before
     * archiving a customer, or the call will fail.
     */
    public void archiveCustomer(final String idOrAlias) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s", idOrAlias));
        this.client.executeRequest("DELETE", url.build(), null, null, null);
    }

    /** Partially update a customer. Only provided fields will be updated. */
    public Customer patchCustomer(
            final String idOrAlias, final CustomerPatchRequest customerPatchRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s", idOrAlias));
        return this.client.executeRequest(
                "PATCH", url.build(), null, customerPatchRequest, Customer.class);
    }

    /**
     * Generates a JWT token that grants access to the customer portal. The token can be used to
     * access invoices, payment methods, and other portal features.
     */
    public CustomerPortalTokenResponse createPortalToken(final String idOrAlias)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s/portal-token", idOrAlias));
        return this.client.executeRequest(
                "POST", url.build(), null, null, CustomerPortalTokenResponse.class);
    }

    /** */
    public void unarchiveCustomer(final String idOrAlias) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/customers/%s/unarchive", idOrAlias));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }
}

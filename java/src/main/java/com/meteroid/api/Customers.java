// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.Customer;
import com.meteroid.models.CustomerCreateRequest;
import com.meteroid.models.CustomerListResponse;
import com.meteroid.models.CustomerPatchRequest;
import com.meteroid.models.CustomerPortalTokenRequest;
import com.meteroid.models.CustomerPortalTokenResponse;
import com.meteroid.models.CustomerUpdateRequest;
import com.meteroid.models.EffectiveEntitlementListResponse;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code customers} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Customers {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Customers(MeteroidHttpClient client) {
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
     * List customers with optional pagination and search filtering.
     *
     * @return the response body
     */
    public CustomerListResponse list() {
        return list(CustomersListOptions.none(), RequestOptions.none());
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param options the optional parameters
     * @return the response body
     */
    public CustomerListResponse list(final CustomersListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomerListResponse list(final RequestOptions requestOptions) {
        return list(CustomersListOptions.none(), requestOptions);
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomerListResponse list(
            final CustomersListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CustomerListResponse> exchangeList(
            final CustomersListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/customers");
        String value1 = options.orderBy().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("order_by", value1);
        }
        Integer value2 = options.page().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value2));
        }
        Integer value3 = options.perPage().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value3));
        }
        String value4 = options.search().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("search", value4);
        }
        Boolean value5 = options.archived().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("archived", Utils.serializeQueryParam(value5));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(CustomerListResponse.class);
    }

    /**
     * Create customer
     *
     * @param customerCreateRequest the request body
     * @return the response body
     */
    public Customer create(final CustomerCreateRequest customerCreateRequest) {
        return create(customerCreateRequest, RequestOptions.none());
    }

    /**
     * Create customer
     *
     * @param customerCreateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Customer create(
            final CustomerCreateRequest customerCreateRequest,
            final RequestOptions requestOptions) {
        return exchangeCreate(customerCreateRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Customer> exchangeCreate(
            final CustomerCreateRequest customerCreateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(customerCreateRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/customers").build();
        return client.call("POST", url)
                .json(customerCreateRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "409",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(Customer.class);
    }

    /**
     * Get customer
     *
     * <p>Retrieve a single customer by ID or alias.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body
     */
    public Customer retrieve(final String idOrAlias) {
        return retrieve(idOrAlias, RequestOptions.none());
    }

    /**
     * Get customer
     *
     * <p>Retrieve a single customer by ID or alias.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Customer retrieve(final String idOrAlias, final RequestOptions requestOptions) {
        return exchangeRetrieve(idOrAlias, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Customer> exchangeRetrieve(
            final String idOrAlias, final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(Customer.class);
    }

    /**
     * Update customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerUpdateRequest the request body
     * @return the response body
     */
    public Customer replace(
            final String idOrAlias, final CustomerUpdateRequest customerUpdateRequest) {
        return replace(idOrAlias, customerUpdateRequest, RequestOptions.none());
    }

    /**
     * Update customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerUpdateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Customer replace(
            final String idOrAlias,
            final CustomerUpdateRequest customerUpdateRequest,
            final RequestOptions requestOptions) {
        return exchangeReplace(idOrAlias, customerUpdateRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Customer> exchangeReplace(
            final String idOrAlias,
            final CustomerUpdateRequest customerUpdateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        Objects.requireNonNull(customerUpdateRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .build();
        return client.call("PUT", url)
                .json(customerUpdateRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(Customer.class);
    }

    /**
     * Archive a customer
     *
     * <p>No linked entity will be deleted. You need to terminate all active subscriptions before
     * archiving a customer, or the call will fail.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     */
    public void archive(final String idOrAlias) {
        archive(idOrAlias, RequestOptions.none());
    }

    /**
     * Archive a customer
     *
     * <p>No linked entity will be deleted. You need to terminate all active subscriptions before
     * archiving a customer, or the call will fail.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String idOrAlias, final RequestOptions requestOptions) {
        exchangeArchive(idOrAlias, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String idOrAlias, final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .build();
        return client.call("DELETE", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Patch customer
     *
     * <p>Partially update a customer. Only provided fields will be updated.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPatchRequest the request body
     * @return the response body
     */
    public Customer update(
            final String idOrAlias, final CustomerPatchRequest customerPatchRequest) {
        return update(idOrAlias, customerPatchRequest, RequestOptions.none());
    }

    /**
     * Patch customer
     *
     * <p>Partially update a customer. Only provided fields will be updated.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPatchRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Customer update(
            final String idOrAlias,
            final CustomerPatchRequest customerPatchRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(idOrAlias, customerPatchRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Customer> exchangeUpdate(
            final String idOrAlias,
            final CustomerPatchRequest customerPatchRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        Objects.requireNonNull(customerPatchRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .build();
        return client.call("PATCH", url)
                .json(customerPatchRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(Customer.class);
    }

    /**
     * List customer entitlements
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body
     */
    public EffectiveEntitlementListResponse listEntitlements(final String idOrAlias) {
        return listEntitlements(idOrAlias, RequestOptions.none());
    }

    /**
     * List customer entitlements
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public EffectiveEntitlementListResponse listEntitlements(
            final String idOrAlias, final RequestOptions requestOptions) {
        return exchangeListEntitlements(idOrAlias, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<EffectiveEntitlementListResponse> exchangeListEntitlements(
            final String idOrAlias, final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .addPathSegments("entitlements")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(EffectiveEntitlementListResponse.class);
    }

    /**
     * Generate a portal token for a customer
     *
     * <p>Generates a JWT token that grants access to the customer portal. The token can be used to
     * access invoices, payment methods, and other portal features.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPortalTokenRequest the request body
     * @return the response body
     */
    public CustomerPortalTokenResponse createPortalToken(
            final String idOrAlias, final CustomerPortalTokenRequest customerPortalTokenRequest) {
        return createPortalToken(idOrAlias, customerPortalTokenRequest, RequestOptions.none());
    }

    /**
     * Generate a portal token for a customer
     *
     * <p>Generates a JWT token that grants access to the customer portal. The token can be used to
     * access invoices, payment methods, and other portal features.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPortalTokenRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomerPortalTokenResponse createPortalToken(
            final String idOrAlias,
            final CustomerPortalTokenRequest customerPortalTokenRequest,
            final RequestOptions requestOptions) {
        return exchangeCreatePortalToken(idOrAlias, customerPortalTokenRequest, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<CustomerPortalTokenResponse> exchangeCreatePortalToken(
            final String idOrAlias,
            final CustomerPortalTokenRequest customerPortalTokenRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        Objects.requireNonNull(customerPortalTokenRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .addPathSegments("portal-token")
                        .build();
        return client.call("POST", url)
                .json(customerPortalTokenRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(CustomerPortalTokenResponse.class);
    }

    /**
     * Restore an archived customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     */
    public void unarchive(final String idOrAlias) {
        unarchive(idOrAlias, RequestOptions.none());
    }

    /**
     * Restore an archived customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String idOrAlias, final RequestOptions requestOptions) {
        exchangeUnarchive(idOrAlias, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String idOrAlias, final RequestOptions requestOptions) {
        Objects.requireNonNull(idOrAlias, "id_or_alias");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/customers")
                        .addPathSegment(Utils.pathSegment("id_or_alias", idOrAlias))
                        .addPathSegments("unarchive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returningNothing();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List customers with optional pagination and search filtering.
         *
         * @return the status, headers and body
         */
        public ApiResponse<CustomerListResponse> list() {
            return list(CustomersListOptions.none(), RequestOptions.none());
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<CustomerListResponse> list(final CustomersListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomerListResponse> list(final RequestOptions requestOptions) {
            return list(CustomersListOptions.none(), requestOptions);
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomerListResponse> list(
                final CustomersListOptions options, final RequestOptions requestOptions) {
            return Customers.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create customer
         *
         * @param customerCreateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Customer> create(final CustomerCreateRequest customerCreateRequest) {
            return create(customerCreateRequest, RequestOptions.none());
        }

        /**
         * Create customer
         *
         * @param customerCreateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Customer> create(
                final CustomerCreateRequest customerCreateRequest,
                final RequestOptions requestOptions) {
            return Customers.this.exchangeCreate(customerCreateRequest, requestOptions).sendRaw();
        }

        /**
         * Get customer
         *
         * <p>Retrieve a single customer by ID or alias.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Customer> retrieve(final String idOrAlias) {
            return retrieve(idOrAlias, RequestOptions.none());
        }

        /**
         * Get customer
         *
         * <p>Retrieve a single customer by ID or alias.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Customer> retrieve(
                final String idOrAlias, final RequestOptions requestOptions) {
            return Customers.this.exchangeRetrieve(idOrAlias, requestOptions).sendRaw();
        }

        /**
         * Update customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerUpdateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Customer> replace(
                final String idOrAlias, final CustomerUpdateRequest customerUpdateRequest) {
            return replace(idOrAlias, customerUpdateRequest, RequestOptions.none());
        }

        /**
         * Update customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerUpdateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Customer> replace(
                final String idOrAlias,
                final CustomerUpdateRequest customerUpdateRequest,
                final RequestOptions requestOptions) {
            return Customers.this
                    .exchangeReplace(idOrAlias, customerUpdateRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive a customer
         *
         * <p>No linked entity will be deleted. You need to terminate all active subscriptions
         * before archiving a customer, or the call will fail.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String idOrAlias) {
            return archive(idOrAlias, RequestOptions.none());
        }

        /**
         * Archive a customer
         *
         * <p>No linked entity will be deleted. You need to terminate all active subscriptions
         * before archiving a customer, or the call will fail.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(
                final String idOrAlias, final RequestOptions requestOptions) {
            return Customers.this.exchangeArchive(idOrAlias, requestOptions).sendRaw();
        }

        /**
         * Patch customer
         *
         * <p>Partially update a customer. Only provided fields will be updated.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPatchRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Customer> update(
                final String idOrAlias, final CustomerPatchRequest customerPatchRequest) {
            return update(idOrAlias, customerPatchRequest, RequestOptions.none());
        }

        /**
         * Patch customer
         *
         * <p>Partially update a customer. Only provided fields will be updated.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPatchRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Customer> update(
                final String idOrAlias,
                final CustomerPatchRequest customerPatchRequest,
                final RequestOptions requestOptions) {
            return Customers.this
                    .exchangeUpdate(idOrAlias, customerPatchRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * List customer entitlements
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<EffectiveEntitlementListResponse> listEntitlements(
                final String idOrAlias) {
            return listEntitlements(idOrAlias, RequestOptions.none());
        }

        /**
         * List customer entitlements
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<EffectiveEntitlementListResponse> listEntitlements(
                final String idOrAlias, final RequestOptions requestOptions) {
            return Customers.this.exchangeListEntitlements(idOrAlias, requestOptions).sendRaw();
        }

        /**
         * Generate a portal token for a customer
         *
         * <p>Generates a JWT token that grants access to the customer portal. The token can be used
         * to access invoices, payment methods, and other portal features.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPortalTokenRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<CustomerPortalTokenResponse> createPortalToken(
                final String idOrAlias,
                final CustomerPortalTokenRequest customerPortalTokenRequest) {
            return createPortalToken(idOrAlias, customerPortalTokenRequest, RequestOptions.none());
        }

        /**
         * Generate a portal token for a customer
         *
         * <p>Generates a JWT token that grants access to the customer portal. The token can be used
         * to access invoices, payment methods, and other portal features.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPortalTokenRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomerPortalTokenResponse> createPortalToken(
                final String idOrAlias,
                final CustomerPortalTokenRequest customerPortalTokenRequest,
                final RequestOptions requestOptions) {
            return Customers.this
                    .exchangeCreatePortalToken(
                            idOrAlias, customerPortalTokenRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Restore an archived customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String idOrAlias) {
            return unarchive(idOrAlias, RequestOptions.none());
        }

        /**
         * Restore an archived customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String idOrAlias, final RequestOptions requestOptions) {
            return Customers.this.exchangeUnarchive(idOrAlias, requestOptions).sendRaw();
        }
    }
}

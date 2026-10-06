// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.Customer;
import com.meteroid.models.CustomerCreateRequest;
import com.meteroid.models.CustomerListResponse;
import com.meteroid.models.CustomerPatchRequest;
import com.meteroid.models.CustomerPortalTokenRequest;
import com.meteroid.models.CustomerPortalTokenResponse;
import com.meteroid.models.CustomerUpdateRequest;
import com.meteroid.models.EffectiveEntitlementListResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code customers} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class CustomersAsync {
    private final Customers sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public CustomersAsync(Customers sync) {
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
     * List customers with optional pagination and search filtering.
     *
     * @return the response body, once received
     */
    public CompletableFuture<CustomerListResponse> list() {
        return list(CustomersListOptions.none(), RequestOptions.none());
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<CustomerListResponse> list(final CustomersListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomerListResponse> list(final RequestOptions requestOptions) {
        return list(CustomersListOptions.none(), requestOptions);
    }

    /**
     * List customers with optional pagination and search filtering.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomerListResponse> list(
            final CustomersListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create customer
     *
     * @param customerCreateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Customer> create(final CustomerCreateRequest customerCreateRequest) {
        return create(customerCreateRequest, RequestOptions.none());
    }

    /**
     * Create customer
     *
     * @param customerCreateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Customer> create(
            final CustomerCreateRequest customerCreateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreate(customerCreateRequest, requestOptions).sendAsync();
    }

    /**
     * Get customer
     *
     * <p>Retrieve a single customer by ID or alias.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Customer> retrieve(final String idOrAlias) {
        return retrieve(idOrAlias, RequestOptions.none());
    }

    /**
     * Get customer
     *
     * <p>Retrieve a single customer by ID or alias.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Customer> retrieve(
            final String idOrAlias, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(idOrAlias, requestOptions).sendAsync();
    }

    /**
     * Update customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerUpdateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Customer> replace(
            final String idOrAlias, final CustomerUpdateRequest customerUpdateRequest) {
        return replace(idOrAlias, customerUpdateRequest, RequestOptions.none());
    }

    /**
     * Update customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerUpdateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Customer> replace(
            final String idOrAlias,
            final CustomerUpdateRequest customerUpdateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeReplace(idOrAlias, customerUpdateRequest, requestOptions).sendAsync();
    }

    /**
     * Archive a customer
     *
     * <p>No linked entity will be deleted. You need to terminate all active subscriptions before
     * archiving a customer, or the call will fail.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(final String idOrAlias) {
        return archive(idOrAlias, RequestOptions.none());
    }

    /**
     * Archive a customer
     *
     * <p>No linked entity will be deleted. You need to terminate all active subscriptions before
     * archiving a customer, or the call will fail.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(
            final String idOrAlias, final RequestOptions requestOptions) {
        return sync.exchangeArchive(idOrAlias, requestOptions).sendAsync();
    }

    /**
     * Patch customer
     *
     * <p>Partially update a customer. Only provided fields will be updated.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPatchRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Customer> update(
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
     * @return the response body, once received
     */
    public CompletableFuture<Customer> update(
            final String idOrAlias,
            final CustomerPatchRequest customerPatchRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(idOrAlias, customerPatchRequest, requestOptions).sendAsync();
    }

    /**
     * List customer entitlements
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<EffectiveEntitlementListResponse> listEntitlements(
            final String idOrAlias) {
        return listEntitlements(idOrAlias, RequestOptions.none());
    }

    /**
     * List customer entitlements
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<EffectiveEntitlementListResponse> listEntitlements(
            final String idOrAlias, final RequestOptions requestOptions) {
        return sync.exchangeListEntitlements(idOrAlias, requestOptions).sendAsync();
    }

    /**
     * Generate a portal token for a customer
     *
     * <p>Generates a JWT token that grants access to the customer portal. The token can be used to
     * access invoices, payment methods, and other portal features.
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param customerPortalTokenRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CustomerPortalTokenResponse> createPortalToken(
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
     * @return the response body, once received
     */
    public CompletableFuture<CustomerPortalTokenResponse> createPortalToken(
            final String idOrAlias,
            final CustomerPortalTokenRequest customerPortalTokenRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreatePortalToken(idOrAlias, customerPortalTokenRequest, requestOptions)
                .sendAsync();
    }

    /**
     * Restore an archived customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(final String idOrAlias) {
        return unarchive(idOrAlias, RequestOptions.none());
    }

    /**
     * Restore an archived customer
     *
     * @param idOrAlias the {@code id_or_alias} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(
            final String idOrAlias, final RequestOptions requestOptions) {
        return sync.exchangeUnarchive(idOrAlias, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List customers with optional pagination and search filtering.
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerListResponse>> list() {
            return list(CustomersListOptions.none(), RequestOptions.none());
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerListResponse>> list(
                final CustomersListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerListResponse>> list(
                final RequestOptions requestOptions) {
            return list(CustomersListOptions.none(), requestOptions);
        }

        /**
         * List customers with optional pagination and search filtering.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerListResponse>> list(
                final CustomersListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create customer
         *
         * @param customerCreateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> create(
                final CustomerCreateRequest customerCreateRequest) {
            return create(customerCreateRequest, RequestOptions.none());
        }

        /**
         * Create customer
         *
         * @param customerCreateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> create(
                final CustomerCreateRequest customerCreateRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(customerCreateRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get customer
         *
         * <p>Retrieve a single customer by ID or alias.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> retrieve(final String idOrAlias) {
            return retrieve(idOrAlias, RequestOptions.none());
        }

        /**
         * Get customer
         *
         * <p>Retrieve a single customer by ID or alias.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> retrieve(
                final String idOrAlias, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(idOrAlias, requestOptions).sendRawAsync();
        }

        /**
         * Update customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerUpdateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> replace(
                final String idOrAlias, final CustomerUpdateRequest customerUpdateRequest) {
            return replace(idOrAlias, customerUpdateRequest, RequestOptions.none());
        }

        /**
         * Update customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerUpdateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> replace(
                final String idOrAlias,
                final CustomerUpdateRequest customerUpdateRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeReplace(idOrAlias, customerUpdateRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Archive a customer
         *
         * <p>No linked entity will be deleted. You need to terminate all active subscriptions
         * before archiving a customer, or the call will fail.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(final String idOrAlias) {
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(
                final String idOrAlias, final RequestOptions requestOptions) {
            return sync.exchangeArchive(idOrAlias, requestOptions).sendRawAsync();
        }

        /**
         * Patch customer
         *
         * <p>Partially update a customer. Only provided fields will be updated.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPatchRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> update(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Customer>> update(
                final String idOrAlias,
                final CustomerPatchRequest customerPatchRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(idOrAlias, customerPatchRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * List customer entitlements
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<EffectiveEntitlementListResponse>> listEntitlements(
                final String idOrAlias) {
            return listEntitlements(idOrAlias, RequestOptions.none());
        }

        /**
         * List customer entitlements
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<EffectiveEntitlementListResponse>> listEntitlements(
                final String idOrAlias, final RequestOptions requestOptions) {
            return sync.exchangeListEntitlements(idOrAlias, requestOptions).sendRawAsync();
        }

        /**
         * Generate a portal token for a customer
         *
         * <p>Generates a JWT token that grants access to the customer portal. The token can be used
         * to access invoices, payment methods, and other portal features.
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param customerPortalTokenRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerPortalTokenResponse>> createPortalToken(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomerPortalTokenResponse>> createPortalToken(
                final String idOrAlias,
                final CustomerPortalTokenRequest customerPortalTokenRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreatePortalToken(
                            idOrAlias, customerPortalTokenRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Restore an archived customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(final String idOrAlias) {
            return unarchive(idOrAlias, RequestOptions.none());
        }

        /**
         * Restore an archived customer
         *
         * @param idOrAlias the {@code id_or_alias} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(
                final String idOrAlias, final RequestOptions requestOptions) {
            return sync.exchangeUnarchive(idOrAlias, requestOptions).sendRawAsync();
        }
    }
}

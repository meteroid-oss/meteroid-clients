// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.AddOn;
import com.meteroid.models.AddOnListResponse;
import com.meteroid.models.CreateAddOnRequest;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.UpdateAddOnRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code add_ons} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class AddOnsAsync {
    private final AddOns sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public AddOnsAsync(AddOns sync) {
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
     * List add-ons
     *
     * @return the response body, once received
     */
    public CompletableFuture<AddOnListResponse> list() {
        return list(AddOnsListOptions.none(), RequestOptions.none());
    }

    /**
     * List add-ons
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<AddOnListResponse> list(final AddOnsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List add-ons
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<AddOnListResponse> list(final RequestOptions requestOptions) {
        return list(AddOnsListOptions.none(), requestOptions);
    }

    /**
     * List add-ons
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<AddOnListResponse> list(
            final AddOnsListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Create an add-on
     *
     * @param createAddOnRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> create(final CreateAddOnRequest createAddOnRequest) {
        return create(createAddOnRequest, RequestOptions.none());
    }

    /**
     * Create an add-on
     *
     * @param createAddOnRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> create(
            final CreateAddOnRequest createAddOnRequest, final RequestOptions requestOptions) {
        return sync.exchangeCreate(createAddOnRequest, requestOptions).sendAsync();
    }

    /**
     * Get add-on details
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> retrieve(final String addonId) {
        return retrieve(addonId, RequestOptions.none());
    }

    /**
     * Get add-on details
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> retrieve(
            final String addonId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(addonId, requestOptions).sendAsync();
    }

    /**
     * Update an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param updateAddOnRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> update(
            final String addonId, final UpdateAddOnRequest updateAddOnRequest) {
        return update(addonId, updateAddOnRequest, RequestOptions.none());
    }

    /**
     * Update an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param updateAddOnRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<AddOn> update(
            final String addonId,
            final UpdateAddOnRequest updateAddOnRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdate(addonId, updateAddOnRequest, requestOptions).sendAsync();
    }

    /**
     * Archive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(final String addonId) {
        return archive(addonId, RequestOptions.none());
    }

    /**
     * Archive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> archive(
            final String addonId, final RequestOptions requestOptions) {
        return sync.exchangeArchive(addonId, requestOptions).sendAsync();
    }

    /**
     * List add-on entitlements
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<ResolvedEntitlementListResponse> listEntitlements(
            final String addonId) {
        return listEntitlements(addonId, RequestOptions.none());
    }

    /**
     * List add-on entitlements
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ResolvedEntitlementListResponse> listEntitlements(
            final String addonId, final RequestOptions requestOptions) {
        return sync.exchangeListEntitlements(addonId, requestOptions).sendAsync();
    }

    /**
     * Unarchive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(final String addonId) {
        return unarchive(addonId, RequestOptions.none());
    }

    /**
     * Unarchive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> unarchive(
            final String addonId, final RequestOptions requestOptions) {
        return sync.exchangeUnarchive(addonId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List add-ons
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOnListResponse>> list() {
            return list(AddOnsListOptions.none(), RequestOptions.none());
        }

        /**
         * List add-ons
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOnListResponse>> list(
                final AddOnsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List add-ons
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOnListResponse>> list(
                final RequestOptions requestOptions) {
            return list(AddOnsListOptions.none(), requestOptions);
        }

        /**
         * List add-ons
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOnListResponse>> list(
                final AddOnsListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Create an add-on
         *
         * @param createAddOnRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> create(
                final CreateAddOnRequest createAddOnRequest) {
            return create(createAddOnRequest, RequestOptions.none());
        }

        /**
         * Create an add-on
         *
         * @param createAddOnRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> create(
                final CreateAddOnRequest createAddOnRequest, final RequestOptions requestOptions) {
            return sync.exchangeCreate(createAddOnRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get add-on details
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> retrieve(final String addonId) {
            return retrieve(addonId, RequestOptions.none());
        }

        /**
         * Get add-on details
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> retrieve(
                final String addonId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(addonId, requestOptions).sendRawAsync();
        }

        /**
         * Update an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param updateAddOnRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> update(
                final String addonId, final UpdateAddOnRequest updateAddOnRequest) {
            return update(addonId, updateAddOnRequest, RequestOptions.none());
        }

        /**
         * Update an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param updateAddOnRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<AddOn>> update(
                final String addonId,
                final UpdateAddOnRequest updateAddOnRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdate(addonId, updateAddOnRequest, requestOptions).sendRawAsync();
        }

        /**
         * Archive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(final String addonId) {
            return archive(addonId, RequestOptions.none());
        }

        /**
         * Archive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> archive(
                final String addonId, final RequestOptions requestOptions) {
            return sync.exchangeArchive(addonId, requestOptions).sendRawAsync();
        }

        /**
         * List add-on entitlements
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ResolvedEntitlementListResponse>> listEntitlements(
                final String addonId) {
            return listEntitlements(addonId, RequestOptions.none());
        }

        /**
         * List add-on entitlements
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ResolvedEntitlementListResponse>> listEntitlements(
                final String addonId, final RequestOptions requestOptions) {
            return sync.exchangeListEntitlements(addonId, requestOptions).sendRawAsync();
        }

        /**
         * Unarchive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(final String addonId) {
            return unarchive(addonId, RequestOptions.none());
        }

        /**
         * Unarchive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> unarchive(
                final String addonId, final RequestOptions requestOptions) {
            return sync.exchangeUnarchive(addonId, requestOptions).sendRawAsync();
        }
    }
}

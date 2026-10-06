// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.AddOn;
import com.meteroid.models.AddOnListResponse;
import com.meteroid.models.CreateAddOnRequest;
import com.meteroid.models.ResolvedEntitlementListResponse;
import com.meteroid.models.UpdateAddOnRequest;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code add_ons} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class AddOns {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public AddOns(MeteroidHttpClient client) {
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
     * List add-ons
     *
     * @return the response body
     */
    public AddOnListResponse list() {
        return list(AddOnsListOptions.none(), RequestOptions.none());
    }

    /**
     * List add-ons
     *
     * @param options the optional parameters
     * @return the response body
     */
    public AddOnListResponse list(final AddOnsListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List add-ons
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public AddOnListResponse list(final RequestOptions requestOptions) {
        return list(AddOnsListOptions.none(), requestOptions);
    }

    /**
     * List add-ons
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public AddOnListResponse list(
            final AddOnsListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<AddOnListResponse> exchangeList(
            final AddOnsListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/addons");
        String value1 = options.search().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("search", value1);
        }
        String value2 = options.currency().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("currency", value2);
        }
        Boolean value3 = options.includeArchived().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("include_archived", Utils.serializeQueryParam(value3));
        }
        String value4 = options.orderBy().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("order_by", value4);
        }
        Integer value5 = options.page().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value5));
        }
        Integer value6 = options.perPage().orElse(null);
        if (value6 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value6));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429")
                .options(requestOptions)
                .returning(AddOnListResponse.class);
    }

    /**
     * Create an add-on
     *
     * @param createAddOnRequest the request body
     * @return the response body
     */
    public AddOn create(final CreateAddOnRequest createAddOnRequest) {
        return create(createAddOnRequest, RequestOptions.none());
    }

    /**
     * Create an add-on
     *
     * @param createAddOnRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public AddOn create(
            final CreateAddOnRequest createAddOnRequest, final RequestOptions requestOptions) {
        return exchangeCreate(createAddOnRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<AddOn> exchangeCreate(
            final CreateAddOnRequest createAddOnRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(createAddOnRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/addons").build();
        return client.call("POST", url)
                .json(createAddOnRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "429")
                .options(requestOptions)
                .returning(AddOn.class);
    }

    /**
     * Get add-on details
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body
     */
    public AddOn retrieve(final String addonId) {
        return retrieve(addonId, RequestOptions.none());
    }

    /**
     * Get add-on details
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public AddOn retrieve(final String addonId, final RequestOptions requestOptions) {
        return exchangeRetrieve(addonId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<AddOn> exchangeRetrieve(
            final String addonId, final RequestOptions requestOptions) {
        Objects.requireNonNull(addonId, "addon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/addons")
                        .addPathSegment(Utils.pathSegment("addon_id", addonId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(AddOn.class);
    }

    /**
     * Update an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param updateAddOnRequest the request body
     * @return the response body
     */
    public AddOn update(final String addonId, final UpdateAddOnRequest updateAddOnRequest) {
        return update(addonId, updateAddOnRequest, RequestOptions.none());
    }

    /**
     * Update an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param updateAddOnRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public AddOn update(
            final String addonId,
            final UpdateAddOnRequest updateAddOnRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdate(addonId, updateAddOnRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<AddOn> exchangeUpdate(
            final String addonId,
            final UpdateAddOnRequest updateAddOnRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(addonId, "addon_id");
        Objects.requireNonNull(updateAddOnRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/addons")
                        .addPathSegment(Utils.pathSegment("addon_id", addonId))
                        .build();
        return client.call("PATCH", url)
                .json(updateAddOnRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "401", "404", "429")
                .options(requestOptions)
                .returning(AddOn.class);
    }

    /**
     * Archive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     */
    public void archive(final String addonId) {
        archive(addonId, RequestOptions.none());
    }

    /**
     * Archive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void archive(final String addonId, final RequestOptions requestOptions) {
        exchangeArchive(addonId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeArchive(
            final String addonId, final RequestOptions requestOptions) {
        Objects.requireNonNull(addonId, "addon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/addons")
                        .addPathSegment(Utils.pathSegment("addon_id", addonId))
                        .addPathSegments("archive")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * List add-on entitlements
     *
     * @param addonId the {@code addon_id} path parameter
     * @return the response body
     */
    public ResolvedEntitlementListResponse listEntitlements(final String addonId) {
        return listEntitlements(addonId, RequestOptions.none());
    }

    /**
     * List add-on entitlements
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ResolvedEntitlementListResponse listEntitlements(
            final String addonId, final RequestOptions requestOptions) {
        return exchangeListEntitlements(addonId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ResolvedEntitlementListResponse> exchangeListEntitlements(
            final String addonId, final RequestOptions requestOptions) {
        Objects.requireNonNull(addonId, "addon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/addons")
                        .addPathSegment(Utils.pathSegment("addon_id", addonId))
                        .addPathSegments("entitlements")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429")
                .options(requestOptions)
                .returning(ResolvedEntitlementListResponse.class);
    }

    /**
     * Unarchive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     */
    public void unarchive(final String addonId) {
        unarchive(addonId, RequestOptions.none());
    }

    /**
     * Unarchive an add-on
     *
     * @param addonId the {@code addon_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void unarchive(final String addonId, final RequestOptions requestOptions) {
        exchangeUnarchive(addonId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeUnarchive(
            final String addonId, final RequestOptions requestOptions) {
        Objects.requireNonNull(addonId, "addon_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/addons")
                        .addPathSegment(Utils.pathSegment("addon_id", addonId))
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
         * List add-ons
         *
         * @return the status, headers and body
         */
        public ApiResponse<AddOnListResponse> list() {
            return list(AddOnsListOptions.none(), RequestOptions.none());
        }

        /**
         * List add-ons
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<AddOnListResponse> list(final AddOnsListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List add-ons
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<AddOnListResponse> list(final RequestOptions requestOptions) {
            return list(AddOnsListOptions.none(), requestOptions);
        }

        /**
         * List add-ons
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<AddOnListResponse> list(
                final AddOnsListOptions options, final RequestOptions requestOptions) {
            return AddOns.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Create an add-on
         *
         * @param createAddOnRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> create(final CreateAddOnRequest createAddOnRequest) {
            return create(createAddOnRequest, RequestOptions.none());
        }

        /**
         * Create an add-on
         *
         * @param createAddOnRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> create(
                final CreateAddOnRequest createAddOnRequest, final RequestOptions requestOptions) {
            return AddOns.this.exchangeCreate(createAddOnRequest, requestOptions).sendRaw();
        }

        /**
         * Get add-on details
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> retrieve(final String addonId) {
            return retrieve(addonId, RequestOptions.none());
        }

        /**
         * Get add-on details
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> retrieve(
                final String addonId, final RequestOptions requestOptions) {
            return AddOns.this.exchangeRetrieve(addonId, requestOptions).sendRaw();
        }

        /**
         * Update an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param updateAddOnRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> update(
                final String addonId, final UpdateAddOnRequest updateAddOnRequest) {
            return update(addonId, updateAddOnRequest, RequestOptions.none());
        }

        /**
         * Update an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param updateAddOnRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<AddOn> update(
                final String addonId,
                final UpdateAddOnRequest updateAddOnRequest,
                final RequestOptions requestOptions) {
            return AddOns.this
                    .exchangeUpdate(addonId, updateAddOnRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(final String addonId) {
            return archive(addonId, RequestOptions.none());
        }

        /**
         * Archive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> archive(
                final String addonId, final RequestOptions requestOptions) {
            return AddOns.this.exchangeArchive(addonId, requestOptions).sendRaw();
        }

        /**
         * List add-on entitlements
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listEntitlements(final String addonId) {
            return listEntitlements(addonId, RequestOptions.none());
        }

        /**
         * List add-on entitlements
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ResolvedEntitlementListResponse> listEntitlements(
                final String addonId, final RequestOptions requestOptions) {
            return AddOns.this.exchangeListEntitlements(addonId, requestOptions).sendRaw();
        }

        /**
         * Unarchive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(final String addonId) {
            return unarchive(addonId, RequestOptions.none());
        }

        /**
         * Unarchive an add-on
         *
         * @param addonId the {@code addon_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> unarchive(
                final String addonId, final RequestOptions requestOptions) {
            return AddOns.this.exchangeUnarchive(addonId, requestOptions).sendRaw();
        }
    }
}

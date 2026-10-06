// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CustomPropertyDefinition;
import com.meteroid.models.CustomPropertyDefinitionCreateRequest;
import com.meteroid.models.CustomPropertyDefinitionListResponse;
import com.meteroid.models.CustomPropertyDefinitionUpdateRequest;
import com.meteroid.models.CustomPropertyEntityType;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code custom_properties} operations, blocking. {@link #withRawResponse()} has the same
 * methods returning the status and headers along with the body.
 */
public final class CustomProperties {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public CustomProperties(MeteroidHttpClient client) {
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
     * List custom property definitions
     *
     * @return the response body
     */
    public CustomPropertyDefinitionListResponse listCustomPropertyDefinitions() {
        return listCustomPropertyDefinitions(
                CustomPropertiesListCustomPropertyDefinitionsOptions.none(), RequestOptions.none());
    }

    /**
     * List custom property definitions
     *
     * @param options the optional parameters
     * @return the response body
     */
    public CustomPropertyDefinitionListResponse listCustomPropertyDefinitions(
            final CustomPropertiesListCustomPropertyDefinitionsOptions options) {
        return listCustomPropertyDefinitions(options, RequestOptions.none());
    }

    /**
     * List custom property definitions
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinitionListResponse listCustomPropertyDefinitions(
            final RequestOptions requestOptions) {
        return listCustomPropertyDefinitions(
                CustomPropertiesListCustomPropertyDefinitionsOptions.none(), requestOptions);
    }

    /**
     * List custom property definitions
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinitionListResponse listCustomPropertyDefinitions(
            final CustomPropertiesListCustomPropertyDefinitionsOptions options,
            final RequestOptions requestOptions) {
        return exchangeListCustomPropertyDefinitions(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CustomPropertyDefinitionListResponse>
            exchangeListCustomPropertyDefinitions(
                    final CustomPropertiesListCustomPropertyDefinitionsOptions options,
                    final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url =
                client.newUrlBuilder().addPathSegments("api/v1/custom-property-definitions");
        CustomPropertyEntityType value1 = options.entityType().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("entity_type", Utils.serializeQueryParam(value1));
        }
        Boolean value2 = options.includeArchived().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("include_archived", Utils.serializeQueryParam(value2));
        }
        Integer value3 = options.page().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value3));
        }
        Integer value4 = options.perPage().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value4));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(CustomPropertyDefinitionListResponse.class);
    }

    /**
     * Create a custom property definition
     *
     * @param customPropertyDefinitionCreateRequest the request body
     * @return the response body
     */
    public CustomPropertyDefinition createCustomPropertyDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest) {
        return createCustomPropertyDefinition(
                customPropertyDefinitionCreateRequest, RequestOptions.none());
    }

    /**
     * Create a custom property definition
     *
     * @param customPropertyDefinitionCreateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinition createCustomPropertyDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest,
            final RequestOptions requestOptions) {
        return exchangeCreateCustomPropertyDefinition(
                        customPropertyDefinitionCreateRequest, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<CustomPropertyDefinition> exchangeCreateCustomPropertyDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(customPropertyDefinitionCreateRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/custom-property-definitions")
                        .build();
        return client.call("POST", url)
                .json(customPropertyDefinitionCreateRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "400", "409", "429", "500")
                .options(requestOptions)
                .returning(CustomPropertyDefinition.class);
    }

    /**
     * Get a custom property definition
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public CustomPropertyDefinition retrieveCustomPropertyDefinition(final String id) {
        return retrieveCustomPropertyDefinition(id, RequestOptions.none());
    }

    /**
     * Get a custom property definition
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinition retrieveCustomPropertyDefinition(
            final String id, final RequestOptions requestOptions) {
        return exchangeRetrieveCustomPropertyDefinition(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CustomPropertyDefinition> exchangeRetrieveCustomPropertyDefinition(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/custom-property-definitions")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "404", "429", "500")
                .options(requestOptions)
                .returning(CustomPropertyDefinition.class);
    }

    /**
     * Update a custom property definition
     *
     * @param id the {@code id} path parameter
     * @param customPropertyDefinitionUpdateRequest the request body
     * @return the response body
     */
    public CustomPropertyDefinition updateCustomPropertyDefinition(
            final String id,
            final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest) {
        return updateCustomPropertyDefinition(
                id, customPropertyDefinitionUpdateRequest, RequestOptions.none());
    }

    /**
     * Update a custom property definition
     *
     * @param id the {@code id} path parameter
     * @param customPropertyDefinitionUpdateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinition updateCustomPropertyDefinition(
            final String id,
            final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdateCustomPropertyDefinition(
                        id, customPropertyDefinitionUpdateRequest, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<CustomPropertyDefinition> exchangeUpdateCustomPropertyDefinition(
            final String id,
            final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(customPropertyDefinitionUpdateRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/custom-property-definitions")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("PUT", url)
                .json(customPropertyDefinitionUpdateRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "404", "429", "500")
                .options(requestOptions)
                .returning(CustomPropertyDefinition.class);
    }

    /**
     * Archive a custom property definition
     *
     * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
     * definition simply stops being enforced on new writes.
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public CustomPropertyDefinition archiveDefinition(final String id) {
        return archiveDefinition(id, RequestOptions.none());
    }

    /**
     * Archive a custom property definition
     *
     * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
     * definition simply stops being enforced on new writes.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CustomPropertyDefinition archiveDefinition(
            final String id, final RequestOptions requestOptions) {
        return exchangeArchiveDefinition(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CustomPropertyDefinition> exchangeArchiveDefinition(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/custom-property-definitions")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("DELETE", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "404", "429", "500")
                .options(requestOptions)
                .returning(CustomPropertyDefinition.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List custom property definitions
         *
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions() {
            return listCustomPropertyDefinitions(
                    CustomPropertiesListCustomPropertyDefinitionsOptions.none(),
                    RequestOptions.none());
        }

        /**
         * List custom property definitions
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
                final CustomPropertiesListCustomPropertyDefinitionsOptions options) {
            return listCustomPropertyDefinitions(options, RequestOptions.none());
        }

        /**
         * List custom property definitions
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
                final RequestOptions requestOptions) {
            return listCustomPropertyDefinitions(
                    CustomPropertiesListCustomPropertyDefinitionsOptions.none(), requestOptions);
        }

        /**
         * List custom property definitions
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
                final CustomPropertiesListCustomPropertyDefinitionsOptions options,
                final RequestOptions requestOptions) {
            return CustomProperties.this
                    .exchangeListCustomPropertyDefinitions(options, requestOptions)
                    .sendRaw();
        }

        /**
         * Create a custom property definition
         *
         * @param customPropertyDefinitionCreateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> createCustomPropertyDefinition(
                final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest) {
            return createCustomPropertyDefinition(
                    customPropertyDefinitionCreateRequest, RequestOptions.none());
        }

        /**
         * Create a custom property definition
         *
         * @param customPropertyDefinitionCreateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> createCustomPropertyDefinition(
                final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest,
                final RequestOptions requestOptions) {
            return CustomProperties.this
                    .exchangeCreateCustomPropertyDefinition(
                            customPropertyDefinitionCreateRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Get a custom property definition
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> retrieveCustomPropertyDefinition(
                final String id) {
            return retrieveCustomPropertyDefinition(id, RequestOptions.none());
        }

        /**
         * Get a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> retrieveCustomPropertyDefinition(
                final String id, final RequestOptions requestOptions) {
            return CustomProperties.this
                    .exchangeRetrieveCustomPropertyDefinition(id, requestOptions)
                    .sendRaw();
        }

        /**
         * Update a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param customPropertyDefinitionUpdateRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> updateCustomPropertyDefinition(
                final String id,
                final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest) {
            return updateCustomPropertyDefinition(
                    id, customPropertyDefinitionUpdateRequest, RequestOptions.none());
        }

        /**
         * Update a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param customPropertyDefinitionUpdateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> updateCustomPropertyDefinition(
                final String id,
                final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest,
                final RequestOptions requestOptions) {
            return CustomProperties.this
                    .exchangeUpdateCustomPropertyDefinition(
                            id, customPropertyDefinitionUpdateRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Archive a custom property definition
         *
         * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
         * definition simply stops being enforced on new writes.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> archiveDefinition(final String id) {
            return archiveDefinition(id, RequestOptions.none());
        }

        /**
         * Archive a custom property definition
         *
         * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
         * definition simply stops being enforced on new writes.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CustomPropertyDefinition> archiveDefinition(
                final String id, final RequestOptions requestOptions) {
            return CustomProperties.this.exchangeArchiveDefinition(id, requestOptions).sendRaw();
        }
    }
}

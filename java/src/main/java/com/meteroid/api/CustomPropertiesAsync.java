// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CustomPropertyDefinition;
import com.meteroid.models.CustomPropertyDefinitionCreateRequest;
import com.meteroid.models.CustomPropertyDefinitionListResponse;
import com.meteroid.models.CustomPropertyDefinitionUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code custom_properties} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class CustomPropertiesAsync {
    private final CustomProperties sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public CustomPropertiesAsync(CustomProperties sync) {
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
     * List custom property definitions
     *
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions() {
        return listCustomPropertyDefinitions(
                CustomPropertiesListCustomPropertyDefinitionsOptions.none(), RequestOptions.none());
    }

    /**
     * List custom property definitions
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
            final CustomPropertiesListCustomPropertyDefinitionsOptions options) {
        return listCustomPropertyDefinitions(options, RequestOptions.none());
    }

    /**
     * List custom property definitions
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
            final RequestOptions requestOptions) {
        return listCustomPropertyDefinitions(
                CustomPropertiesListCustomPropertyDefinitionsOptions.none(), requestOptions);
    }

    /**
     * List custom property definitions
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinitionListResponse> listCustomPropertyDefinitions(
            final CustomPropertiesListCustomPropertyDefinitionsOptions options,
            final RequestOptions requestOptions) {
        return sync.exchangeListCustomPropertyDefinitions(options, requestOptions).sendAsync();
    }

    /**
     * Create a custom property definition
     *
     * @param customPropertyDefinitionCreateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> createCustomPropertyDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest) {
        return createCustomPropertyDefinition(
                customPropertyDefinitionCreateRequest, RequestOptions.none());
    }

    /**
     * Create a custom property definition
     *
     * @param customPropertyDefinitionCreateRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> createCustomPropertyDefinition(
            final CustomPropertyDefinitionCreateRequest customPropertyDefinitionCreateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreateCustomPropertyDefinition(
                        customPropertyDefinitionCreateRequest, requestOptions)
                .sendAsync();
    }

    /**
     * Get a custom property definition
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> retrieveCustomPropertyDefinition(
            final String id) {
        return retrieveCustomPropertyDefinition(id, RequestOptions.none());
    }

    /**
     * Get a custom property definition
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> retrieveCustomPropertyDefinition(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeRetrieveCustomPropertyDefinition(id, requestOptions).sendAsync();
    }

    /**
     * Update a custom property definition
     *
     * @param id the {@code id} path parameter
     * @param customPropertyDefinitionUpdateRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> updateCustomPropertyDefinition(
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
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> updateCustomPropertyDefinition(
            final String id,
            final CustomPropertyDefinitionUpdateRequest customPropertyDefinitionUpdateRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdateCustomPropertyDefinition(
                        id, customPropertyDefinitionUpdateRequest, requestOptions)
                .sendAsync();
    }

    /**
     * Archive a custom property definition
     *
     * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
     * definition simply stops being enforced on new writes.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> archiveDefinition(final String id) {
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
     * @return the response body, once received
     */
    public CompletableFuture<CustomPropertyDefinition> archiveDefinition(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeArchiveDefinition(id, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List custom property definitions
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinitionListResponse>>
                listCustomPropertyDefinitions() {
            return listCustomPropertyDefinitions(
                    CustomPropertiesListCustomPropertyDefinitionsOptions.none(),
                    RequestOptions.none());
        }

        /**
         * List custom property definitions
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinitionListResponse>>
                listCustomPropertyDefinitions(
                        final CustomPropertiesListCustomPropertyDefinitionsOptions options) {
            return listCustomPropertyDefinitions(options, RequestOptions.none());
        }

        /**
         * List custom property definitions
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinitionListResponse>>
                listCustomPropertyDefinitions(final RequestOptions requestOptions) {
            return listCustomPropertyDefinitions(
                    CustomPropertiesListCustomPropertyDefinitionsOptions.none(), requestOptions);
        }

        /**
         * List custom property definitions
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinitionListResponse>>
                listCustomPropertyDefinitions(
                        final CustomPropertiesListCustomPropertyDefinitionsOptions options,
                        final RequestOptions requestOptions) {
            return sync.exchangeListCustomPropertyDefinitions(options, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Create a custom property definition
         *
         * @param customPropertyDefinitionCreateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                createCustomPropertyDefinition(
                        final CustomPropertyDefinitionCreateRequest
                                customPropertyDefinitionCreateRequest) {
            return createCustomPropertyDefinition(
                    customPropertyDefinitionCreateRequest, RequestOptions.none());
        }

        /**
         * Create a custom property definition
         *
         * @param customPropertyDefinitionCreateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                createCustomPropertyDefinition(
                        final CustomPropertyDefinitionCreateRequest
                                customPropertyDefinitionCreateRequest,
                        final RequestOptions requestOptions) {
            return sync.exchangeCreateCustomPropertyDefinition(
                            customPropertyDefinitionCreateRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Get a custom property definition
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                retrieveCustomPropertyDefinition(final String id) {
            return retrieveCustomPropertyDefinition(id, RequestOptions.none());
        }

        /**
         * Get a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                retrieveCustomPropertyDefinition(
                        final String id, final RequestOptions requestOptions) {
            return sync.exchangeRetrieveCustomPropertyDefinition(id, requestOptions).sendRawAsync();
        }

        /**
         * Update a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param customPropertyDefinitionUpdateRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                updateCustomPropertyDefinition(
                        final String id,
                        final CustomPropertyDefinitionUpdateRequest
                                customPropertyDefinitionUpdateRequest) {
            return updateCustomPropertyDefinition(
                    id, customPropertyDefinitionUpdateRequest, RequestOptions.none());
        }

        /**
         * Update a custom property definition
         *
         * @param id the {@code id} path parameter
         * @param customPropertyDefinitionUpdateRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>>
                updateCustomPropertyDefinition(
                        final String id,
                        final CustomPropertyDefinitionUpdateRequest
                                customPropertyDefinitionUpdateRequest,
                        final RequestOptions requestOptions) {
            return sync.exchangeUpdateCustomPropertyDefinition(
                            id, customPropertyDefinitionUpdateRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Archive a custom property definition
         *
         * <p>Soft-deletes the definition. Existing property values on entities are preserved; the
         * definition simply stops being enforced on new writes.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>> archiveDefinition(
                final String id) {
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CustomPropertyDefinition>> archiveDefinition(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeArchiveDefinition(id, requestOptions).sendRawAsync();
        }
    }
}

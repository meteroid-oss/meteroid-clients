// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CreateOAuthAppRequest;
import com.meteroid.models.OAuthApp;
import com.meteroid.models.OAuthAppWithSecret;
import com.meteroid.models.OAuthAppsResponse;
import com.meteroid.models.RotatedSecret;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code oauth_apps} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class OauthAppsAsync {
    private final OauthApps sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public OauthAppsAsync(OauthApps sync) {
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
     * List OAuth apps
     *
     * <p>List all OAuth applications registered for this platform.
     *
     * @return the response body, once received
     */
    public CompletableFuture<OAuthAppsResponse> list() {
        return list(RequestOptions.none());
    }

    /**
     * List OAuth apps
     *
     * <p>List all OAuth applications registered for this platform.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<OAuthAppsResponse> list(final RequestOptions requestOptions) {
        return sync.exchangeList(requestOptions).sendAsync();
    }

    /**
     * Create OAuth app
     *
     * <p>Register a new OAuth application. Returns the app with its client secret (only shown
     * once).
     *
     * @param createOAuthAppRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<OAuthAppWithSecret> create(
            final CreateOAuthAppRequest createOAuthAppRequest) {
        return create(createOAuthAppRequest, RequestOptions.none());
    }

    /**
     * Create OAuth app
     *
     * <p>Register a new OAuth application. Returns the app with its client secret (only shown
     * once).
     *
     * @param createOAuthAppRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<OAuthAppWithSecret> create(
            final CreateOAuthAppRequest createOAuthAppRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreate(createOAuthAppRequest, requestOptions).sendAsync();
    }

    /**
     * Get OAuth app
     *
     * <p>Retrieve an OAuth application by ID.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<OAuthApp> retrieve(final String id) {
        return retrieve(id, RequestOptions.none());
    }

    /**
     * Get OAuth app
     *
     * <p>Retrieve an OAuth application by ID.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<OAuthApp> retrieve(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(id, requestOptions).sendAsync();
    }

    /**
     * Delete OAuth app
     *
     * <p>Delete an OAuth application and revoke all associated tokens.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> delete(final String id) {
        return delete(id, RequestOptions.none());
    }

    /**
     * Delete OAuth app
     *
     * <p>Delete an OAuth application and revoke all associated tokens.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> delete(final String id, final RequestOptions requestOptions) {
        return sync.exchangeDelete(id, requestOptions).sendAsync();
    }

    /**
     * Rotate client secret
     *
     * <p>Generate a new client secret for an OAuth app. The old secret is immediately invalidated.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<RotatedSecret> rotate(final String id) {
        return rotate(id, RequestOptions.none());
    }

    /**
     * Rotate client secret
     *
     * <p>Generate a new client secret for an OAuth app. The old secret is immediately invalidated.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<RotatedSecret> rotate(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeRotate(id, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List OAuth apps
         *
         * <p>List all OAuth applications registered for this platform.
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthAppsResponse>> list() {
            return list(RequestOptions.none());
        }

        /**
         * List OAuth apps
         *
         * <p>List all OAuth applications registered for this platform.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthAppsResponse>> list(
                final RequestOptions requestOptions) {
            return sync.exchangeList(requestOptions).sendRawAsync();
        }

        /**
         * Create OAuth app
         *
         * <p>Register a new OAuth application. Returns the app with its client secret (only shown
         * once).
         *
         * @param createOAuthAppRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthAppWithSecret>> create(
                final CreateOAuthAppRequest createOAuthAppRequest) {
            return create(createOAuthAppRequest, RequestOptions.none());
        }

        /**
         * Create OAuth app
         *
         * <p>Register a new OAuth application. Returns the app with its client secret (only shown
         * once).
         *
         * @param createOAuthAppRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthAppWithSecret>> create(
                final CreateOAuthAppRequest createOAuthAppRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreate(createOAuthAppRequest, requestOptions).sendRawAsync();
        }

        /**
         * Get OAuth app
         *
         * <p>Retrieve an OAuth application by ID.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthApp>> retrieve(final String id) {
            return retrieve(id, RequestOptions.none());
        }

        /**
         * Get OAuth app
         *
         * <p>Retrieve an OAuth application by ID.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OAuthApp>> retrieve(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(id, requestOptions).sendRawAsync();
        }

        /**
         * Delete OAuth app
         *
         * <p>Delete an OAuth application and revoke all associated tokens.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> delete(final String id) {
            return delete(id, RequestOptions.none());
        }

        /**
         * Delete OAuth app
         *
         * <p>Delete an OAuth application and revoke all associated tokens.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> delete(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeDelete(id, requestOptions).sendRawAsync();
        }

        /**
         * Rotate client secret
         *
         * <p>Generate a new client secret for an OAuth app. The old secret is immediately
         * invalidated.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<RotatedSecret>> rotate(final String id) {
            return rotate(id, RequestOptions.none());
        }

        /**
         * Rotate client secret
         *
         * <p>Generate a new client secret for an OAuth app. The old secret is immediately
         * invalidated.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<RotatedSecret>> rotate(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeRotate(id, requestOptions).sendRawAsync();
        }
    }
}

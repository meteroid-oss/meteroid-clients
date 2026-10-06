// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CreateOAuthAppRequest;
import com.meteroid.models.OAuthApp;
import com.meteroid.models.OAuthAppWithSecret;
import com.meteroid.models.OAuthAppsResponse;
import com.meteroid.models.RotatedSecret;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code oauth_apps} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class OauthApps {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public OauthApps(MeteroidHttpClient client) {
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
     * List OAuth apps
     *
     * <p>List all OAuth applications registered for this platform.
     *
     * @return the response body
     */
    public OAuthAppsResponse list() {
        return list(RequestOptions.none());
    }

    /**
     * List OAuth apps
     *
     * <p>List all OAuth applications registered for this platform.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public OAuthAppsResponse list(final RequestOptions requestOptions) {
        return exchangeList(requestOptions).send();
    }

    MeteroidHttpClient.Exchange<OAuthAppsResponse> exchangeList(
            final RequestOptions requestOptions) {
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/oauth-apps").build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(OAuthAppsResponse.class);
    }

    /**
     * Create OAuth app
     *
     * <p>Register a new OAuth application. Returns the app with its client secret (only shown
     * once).
     *
     * @param createOAuthAppRequest the request body
     * @return the response body
     */
    public OAuthAppWithSecret create(final CreateOAuthAppRequest createOAuthAppRequest) {
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
     * @return the response body
     */
    public OAuthAppWithSecret create(
            final CreateOAuthAppRequest createOAuthAppRequest,
            final RequestOptions requestOptions) {
        return exchangeCreate(createOAuthAppRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<OAuthAppWithSecret> exchangeCreate(
            final CreateOAuthAppRequest createOAuthAppRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(createOAuthAppRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/oauth-apps").build();
        return client.call("POST", url)
                .json(createOAuthAppRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(OAuthAppWithSecret.class);
    }

    /**
     * Get OAuth app
     *
     * <p>Retrieve an OAuth application by ID.
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public OAuthApp retrieve(final String id) {
        return retrieve(id, RequestOptions.none());
    }

    /**
     * Get OAuth app
     *
     * <p>Retrieve an OAuth application by ID.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public OAuthApp retrieve(final String id, final RequestOptions requestOptions) {
        return exchangeRetrieve(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<OAuthApp> exchangeRetrieve(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/oauth-apps")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(OAuthApp.class);
    }

    /**
     * Delete OAuth app
     *
     * <p>Delete an OAuth application and revoke all associated tokens.
     *
     * @param id the {@code id} path parameter
     */
    public void delete(final String id) {
        delete(id, RequestOptions.none());
    }

    /**
     * Delete OAuth app
     *
     * <p>Delete an OAuth application and revoke all associated tokens.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void delete(final String id, final RequestOptions requestOptions) {
        exchangeDelete(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeDelete(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/oauth-apps")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("DELETE", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Rotate client secret
     *
     * <p>Generate a new client secret for an OAuth app. The old secret is immediately invalidated.
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public RotatedSecret rotate(final String id) {
        return rotate(id, RequestOptions.none());
    }

    /**
     * Rotate client secret
     *
     * <p>Generate a new client secret for an OAuth app. The old secret is immediately invalidated.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public RotatedSecret rotate(final String id, final RequestOptions requestOptions) {
        return exchangeRotate(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<RotatedSecret> exchangeRotate(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/oauth-apps")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .addPathSegments("rotate")
                        .build();
        return client.call("POST", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(RotatedSecret.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List OAuth apps
         *
         * <p>List all OAuth applications registered for this platform.
         *
         * @return the status, headers and body
         */
        public ApiResponse<OAuthAppsResponse> list() {
            return list(RequestOptions.none());
        }

        /**
         * List OAuth apps
         *
         * <p>List all OAuth applications registered for this platform.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<OAuthAppsResponse> list(final RequestOptions requestOptions) {
            return OauthApps.this.exchangeList(requestOptions).sendRaw();
        }

        /**
         * Create OAuth app
         *
         * <p>Register a new OAuth application. Returns the app with its client secret (only shown
         * once).
         *
         * @param createOAuthAppRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<OAuthAppWithSecret> create(
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
         * @return the status, headers and body
         */
        public ApiResponse<OAuthAppWithSecret> create(
                final CreateOAuthAppRequest createOAuthAppRequest,
                final RequestOptions requestOptions) {
            return OauthApps.this.exchangeCreate(createOAuthAppRequest, requestOptions).sendRaw();
        }

        /**
         * Get OAuth app
         *
         * <p>Retrieve an OAuth application by ID.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<OAuthApp> retrieve(final String id) {
            return retrieve(id, RequestOptions.none());
        }

        /**
         * Get OAuth app
         *
         * <p>Retrieve an OAuth application by ID.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<OAuthApp> retrieve(
                final String id, final RequestOptions requestOptions) {
            return OauthApps.this.exchangeRetrieve(id, requestOptions).sendRaw();
        }

        /**
         * Delete OAuth app
         *
         * <p>Delete an OAuth application and revoke all associated tokens.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> delete(final String id) {
            return delete(id, RequestOptions.none());
        }

        /**
         * Delete OAuth app
         *
         * <p>Delete an OAuth application and revoke all associated tokens.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> delete(final String id, final RequestOptions requestOptions) {
            return OauthApps.this.exchangeDelete(id, requestOptions).sendRaw();
        }

        /**
         * Rotate client secret
         *
         * <p>Generate a new client secret for an OAuth app. The old secret is immediately
         * invalidated.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<RotatedSecret> rotate(final String id) {
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
         * @return the status, headers and body
         */
        public ApiResponse<RotatedSecret> rotate(
                final String id, final RequestOptions requestOptions) {
            return OauthApps.this.exchangeRotate(id, requestOptions).sendRaw();
        }
    }
}

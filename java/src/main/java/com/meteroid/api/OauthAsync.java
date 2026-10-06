// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.IntrospectionRequest;
import com.meteroid.models.RevocationRequest;
import com.meteroid.models.TokenIntrospectionResponse;
import com.meteroid.models.TokenRequest;
import com.meteroid.models.TokenResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code oauth} operations, without blocking: each method returns a {@link CompletableFuture}.
 * Obtained from {@code client.async()}.
 */
public final class OauthAsync {
    private final Oauth sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public OauthAsync(Oauth sync) {
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
     * Introspect token
     *
     * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic auth.
     *
     * @param introspectionRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<TokenIntrospectionResponse> introspect(
            final IntrospectionRequest introspectionRequest) {
        return introspect(introspectionRequest, RequestOptions.none());
    }

    /**
     * Introspect token
     *
     * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic auth.
     *
     * @param introspectionRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<TokenIntrospectionResponse> introspect(
            final IntrospectionRequest introspectionRequest, final RequestOptions requestOptions) {
        return sync.exchangeIntrospect(introspectionRequest, requestOptions).sendAsync();
    }

    /**
     * Revoke token
     *
     * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
     * credentials via HTTP Basic auth.
     *
     * @param revocationRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<Void> revoke(final RevocationRequest revocationRequest) {
        return revoke(revocationRequest, RequestOptions.none());
    }

    /**
     * Revoke token
     *
     * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
     * credentials via HTTP Basic auth.
     *
     * @param revocationRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> revoke(
            final RevocationRequest revocationRequest, final RequestOptions requestOptions) {
        return sync.exchangeRevoke(revocationRequest, requestOptions).sendAsync();
    }

    /**
     * Exchange tokens
     *
     * <p>OAuth 2.0 token endpoint. Supports two grant types: - <code>authorization_code</code>:
     * Exchange an authorization code for tokens - <code>refresh_token</code>: Refresh an access
     * token
     *
     * <p>Authenticate via HTTP Basic auth (<code>client_id:client_secret</code>) or body
     * parameters.
     *
     * @param tokenRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<TokenResponse> token(final TokenRequest tokenRequest) {
        return token(tokenRequest, RequestOptions.none());
    }

    /**
     * Exchange tokens
     *
     * <p>OAuth 2.0 token endpoint. Supports two grant types: - <code>authorization_code</code>:
     * Exchange an authorization code for tokens - <code>refresh_token</code>: Refresh an access
     * token
     *
     * <p>Authenticate via HTTP Basic auth (<code>client_id:client_secret</code>) or body
     * parameters.
     *
     * @param tokenRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<TokenResponse> token(
            final TokenRequest tokenRequest, final RequestOptions requestOptions) {
        return sync.exchangeToken(tokenRequest, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * Introspect token
         *
         * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic
         * auth.
         *
         * @param introspectionRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<TokenIntrospectionResponse>> introspect(
                final IntrospectionRequest introspectionRequest) {
            return introspect(introspectionRequest, RequestOptions.none());
        }

        /**
         * Introspect token
         *
         * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic
         * auth.
         *
         * @param introspectionRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<TokenIntrospectionResponse>> introspect(
                final IntrospectionRequest introspectionRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeIntrospect(introspectionRequest, requestOptions).sendRawAsync();
        }

        /**
         * Revoke token
         *
         * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
         * credentials via HTTP Basic auth.
         *
         * @param revocationRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> revoke(
                final RevocationRequest revocationRequest) {
            return revoke(revocationRequest, RequestOptions.none());
        }

        /**
         * Revoke token
         *
         * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
         * credentials via HTTP Basic auth.
         *
         * @param revocationRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> revoke(
                final RevocationRequest revocationRequest, final RequestOptions requestOptions) {
            return sync.exchangeRevoke(revocationRequest, requestOptions).sendRawAsync();
        }

        /**
         * Exchange tokens
         *
         * <p>OAuth 2.0 token endpoint. Supports two grant types: - <code>authorization_code</code>:
         * Exchange an authorization code for tokens - <code>refresh_token</code>: Refresh an access
         * token
         *
         * <p>Authenticate via HTTP Basic auth (<code>client_id:client_secret</code>) or body
         * parameters.
         *
         * @param tokenRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<TokenResponse>> token(
                final TokenRequest tokenRequest) {
            return token(tokenRequest, RequestOptions.none());
        }

        /**
         * Exchange tokens
         *
         * <p>OAuth 2.0 token endpoint. Supports two grant types: - <code>authorization_code</code>:
         * Exchange an authorization code for tokens - <code>refresh_token</code>: Refresh an access
         * token
         *
         * <p>Authenticate via HTTP Basic auth (<code>client_id:client_secret</code>) or body
         * parameters.
         *
         * @param tokenRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<TokenResponse>> token(
                final TokenRequest tokenRequest, final RequestOptions requestOptions) {
            return sync.exchangeToken(tokenRequest, requestOptions).sendRawAsync();
        }
    }
}

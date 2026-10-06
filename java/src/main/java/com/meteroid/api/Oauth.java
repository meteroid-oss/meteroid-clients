// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.models.IntrospectionRequest;
import com.meteroid.models.RevocationRequest;
import com.meteroid.models.TokenIntrospectionResponse;
import com.meteroid.models.TokenRequest;
import com.meteroid.models.TokenResponse;

import okhttp3.HttpUrl;

import java.util.List;
import java.util.Objects;

/**
 * The {@code oauth} operations, blocking. {@link #withRawResponse()} has the same methods returning
 * the status and headers along with the body.
 */
public final class Oauth {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Oauth(MeteroidHttpClient client) {
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
     * Introspect token
     *
     * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic auth.
     *
     * @param introspectionRequest the request body
     * @return the response body
     */
    public TokenIntrospectionResponse introspect(final IntrospectionRequest introspectionRequest) {
        return introspect(introspectionRequest, RequestOptions.none());
    }

    /**
     * Introspect token
     *
     * <p>Token introspection endpoint (RFC 7662). Requires client credentials via HTTP Basic auth.
     *
     * @param introspectionRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public TokenIntrospectionResponse introspect(
            final IntrospectionRequest introspectionRequest, final RequestOptions requestOptions) {
        return exchangeIntrospect(introspectionRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<TokenIntrospectionResponse> exchangeIntrospect(
            final IntrospectionRequest introspectionRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(introspectionRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/oauth/introspect").build();
        return client.withSecurity(List.of())
                .call("POST", url)
                .form(introspectionRequest, List.of(), List.of())
                .errors(com.meteroid.models.OAuthErrorResponse.class, "401")
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(TokenIntrospectionResponse.class);
    }

    /**
     * Revoke token
     *
     * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
     * credentials via HTTP Basic auth.
     *
     * @param revocationRequest the request body
     */
    public void revoke(final RevocationRequest revocationRequest) {
        revoke(revocationRequest, RequestOptions.none());
    }

    /**
     * Revoke token
     *
     * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
     * credentials via HTTP Basic auth.
     *
     * @param revocationRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     */
    public void revoke(
            final RevocationRequest revocationRequest, final RequestOptions requestOptions) {
        exchangeRevoke(revocationRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeRevoke(
            final RevocationRequest revocationRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(revocationRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/oauth/revoke").build();
        return client.withSecurity(List.of())
                .call("POST", url)
                .form(revocationRequest, List.of(), List.of())
                .errors(com.meteroid.models.OAuthErrorResponse.class, "401")
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returningNothing();
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
     * @return the response body
     */
    public TokenResponse token(final TokenRequest tokenRequest) {
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
     * @return the response body
     */
    public TokenResponse token(
            final TokenRequest tokenRequest, final RequestOptions requestOptions) {
        return exchangeToken(tokenRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<TokenResponse> exchangeToken(
            final TokenRequest tokenRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(tokenRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/oauth/token").build();
        return client.withSecurity(List.of())
                .call("POST", url)
                .form(tokenRequest, List.of(), List.of())
                .errors(com.meteroid.models.OAuthErrorResponse.class, "400", "401")
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(TokenResponse.class);
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
         * @return the status, headers and body
         */
        public ApiResponse<TokenIntrospectionResponse> introspect(
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
         * @return the status, headers and body
         */
        public ApiResponse<TokenIntrospectionResponse> introspect(
                final IntrospectionRequest introspectionRequest,
                final RequestOptions requestOptions) {
            return Oauth.this.exchangeIntrospect(introspectionRequest, requestOptions).sendRaw();
        }

        /**
         * Revoke token
         *
         * <p>Token revocation endpoint (RFC 7009). Always returns 200 per spec. Requires client
         * credentials via HTTP Basic auth.
         *
         * @param revocationRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Void> revoke(final RevocationRequest revocationRequest) {
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
         * @return the status, headers and body
         */
        public ApiResponse<Void> revoke(
                final RevocationRequest revocationRequest, final RequestOptions requestOptions) {
            return Oauth.this.exchangeRevoke(revocationRequest, requestOptions).sendRaw();
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
         * @return the status, headers and body
         */
        public ApiResponse<TokenResponse> token(final TokenRequest tokenRequest) {
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
         * @return the status, headers and body
         */
        public ApiResponse<TokenResponse> token(
                final TokenRequest tokenRequest, final RequestOptions requestOptions) {
            return Oauth.this.exchangeToken(tokenRequest, requestOptions).sendRaw();
        }
    }
}

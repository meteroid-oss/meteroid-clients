// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.ConnectedAccount;
import com.meteroid.models.ConnectedAccountsResponse;
import com.meteroid.models.CreateConnectedAccountRequest;
import com.meteroid.models.CreateOnboardingLinkRequest;
import com.meteroid.models.OnboardingLinkResponse;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code connect} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Connect {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Connect(MeteroidHttpClient client) {
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
     * List connected accounts
     *
     * <p>List all connected accounts for this platform.
     *
     * @return the response body
     */
    public ConnectedAccountsResponse listConnectedAccounts() {
        return listConnectedAccounts(RequestOptions.none());
    }

    /**
     * List connected accounts
     *
     * <p>List all connected accounts for this platform.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ConnectedAccountsResponse listConnectedAccounts(final RequestOptions requestOptions) {
        return exchangeListConnectedAccounts(requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ConnectedAccountsResponse> exchangeListConnectedAccounts(
            final RequestOptions requestOptions) {
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/connected-accounts").build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(ConnectedAccountsResponse.class);
    }

    /**
     * Create connected account
     *
     * <p>Create a new connected account (Express flow). Returns the account and an onboarding link
     * for the user to complete setup.
     *
     * @param createConnectedAccountRequest the request body
     * @return the response body
     */
    public ConnectedAccount createConnectedAccount(
            final CreateConnectedAccountRequest createConnectedAccountRequest) {
        return createConnectedAccount(createConnectedAccountRequest, RequestOptions.none());
    }

    /**
     * Create connected account
     *
     * <p>Create a new connected account (Express flow). Returns the account and an onboarding link
     * for the user to complete setup.
     *
     * @param createConnectedAccountRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ConnectedAccount createConnectedAccount(
            final CreateConnectedAccountRequest createConnectedAccountRequest,
            final RequestOptions requestOptions) {
        return exchangeCreateConnectedAccount(createConnectedAccountRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ConnectedAccount> exchangeCreateConnectedAccount(
            final CreateConnectedAccountRequest createConnectedAccountRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(createConnectedAccountRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/connected-accounts").build();
        return client.call("POST", url)
                .json(createConnectedAccountRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(ConnectedAccount.class);
    }

    /**
     * Get connected account
     *
     * <p>Retrieve a connected account by ID.
     *
     * @param id the {@code id} path parameter
     * @return the response body
     */
    public ConnectedAccount retrieveConnectedAccount(final String id) {
        return retrieveConnectedAccount(id, RequestOptions.none());
    }

    /**
     * Get connected account
     *
     * <p>Retrieve a connected account by ID.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public ConnectedAccount retrieveConnectedAccount(
            final String id, final RequestOptions requestOptions) {
        return exchangeRetrieveConnectedAccount(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<ConnectedAccount> exchangeRetrieveConnectedAccount(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/connected-accounts")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(ConnectedAccount.class);
    }

    /**
     * Disconnect account
     *
     * <p>Revoke a connected account. All associated tokens are invalidated.
     *
     * @param id the {@code id} path parameter
     */
    public void disconnectAccount(final String id) {
        disconnectAccount(id, RequestOptions.none());
    }

    /**
     * Disconnect account
     *
     * <p>Revoke a connected account. All associated tokens are invalidated.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     */
    public void disconnectAccount(final String id, final RequestOptions requestOptions) {
        exchangeDisconnectAccount(id, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Void> exchangeDisconnectAccount(
            final String id, final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/connected-accounts")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .build();
        return client.call("DELETE", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returningNothing();
    }

    /**
     * Create onboarding link
     *
     * <p>Generate a new onboarding link for a connected account. Any existing unused link is
     * invalidated. The link expires after a configured duration.
     *
     * @param id the {@code id} path parameter
     * @param createOnboardingLinkRequest the request body
     * @return the response body
     */
    public OnboardingLinkResponse createOnboardingLink(
            final String id, final CreateOnboardingLinkRequest createOnboardingLinkRequest) {
        return createOnboardingLink(id, createOnboardingLinkRequest, RequestOptions.none());
    }

    /**
     * Create onboarding link
     *
     * <p>Generate a new onboarding link for a connected account. Any existing unused link is
     * invalidated. The link expires after a configured duration.
     *
     * @param id the {@code id} path parameter
     * @param createOnboardingLinkRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public OnboardingLinkResponse createOnboardingLink(
            final String id,
            final CreateOnboardingLinkRequest createOnboardingLinkRequest,
            final RequestOptions requestOptions) {
        return exchangeCreateOnboardingLink(id, createOnboardingLinkRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<OnboardingLinkResponse> exchangeCreateOnboardingLink(
            final String id,
            final CreateOnboardingLinkRequest createOnboardingLinkRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(createOnboardingLinkRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/connected-accounts")
                        .addPathSegment(Utils.pathSegment("id", id))
                        .addPathSegments("onboarding")
                        .build();
        return client.call("POST", url)
                .json(createOnboardingLinkRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "429")
                .options(requestOptions)
                .returning(OnboardingLinkResponse.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List connected accounts
         *
         * <p>List all connected accounts for this platform.
         *
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccountsResponse> listConnectedAccounts() {
            return listConnectedAccounts(RequestOptions.none());
        }

        /**
         * List connected accounts
         *
         * <p>List all connected accounts for this platform.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccountsResponse> listConnectedAccounts(
                final RequestOptions requestOptions) {
            return Connect.this.exchangeListConnectedAccounts(requestOptions).sendRaw();
        }

        /**
         * Create connected account
         *
         * <p>Create a new connected account (Express flow). Returns the account and an onboarding
         * link for the user to complete setup.
         *
         * @param createConnectedAccountRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccount> createConnectedAccount(
                final CreateConnectedAccountRequest createConnectedAccountRequest) {
            return createConnectedAccount(createConnectedAccountRequest, RequestOptions.none());
        }

        /**
         * Create connected account
         *
         * <p>Create a new connected account (Express flow). Returns the account and an onboarding
         * link for the user to complete setup.
         *
         * @param createConnectedAccountRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccount> createConnectedAccount(
                final CreateConnectedAccountRequest createConnectedAccountRequest,
                final RequestOptions requestOptions) {
            return Connect.this
                    .exchangeCreateConnectedAccount(createConnectedAccountRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Get connected account
         *
         * <p>Retrieve a connected account by ID.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccount> retrieveConnectedAccount(final String id) {
            return retrieveConnectedAccount(id, RequestOptions.none());
        }

        /**
         * Get connected account
         *
         * <p>Retrieve a connected account by ID.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<ConnectedAccount> retrieveConnectedAccount(
                final String id, final RequestOptions requestOptions) {
            return Connect.this.exchangeRetrieveConnectedAccount(id, requestOptions).sendRaw();
        }

        /**
         * Disconnect account
         *
         * <p>Revoke a connected account. All associated tokens are invalidated.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Void> disconnectAccount(final String id) {
            return disconnectAccount(id, RequestOptions.none());
        }

        /**
         * Disconnect account
         *
         * <p>Revoke a connected account. All associated tokens are invalidated.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Void> disconnectAccount(
                final String id, final RequestOptions requestOptions) {
            return Connect.this.exchangeDisconnectAccount(id, requestOptions).sendRaw();
        }

        /**
         * Create onboarding link
         *
         * <p>Generate a new onboarding link for a connected account. Any existing unused link is
         * invalidated. The link expires after a configured duration.
         *
         * @param id the {@code id} path parameter
         * @param createOnboardingLinkRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<OnboardingLinkResponse> createOnboardingLink(
                final String id, final CreateOnboardingLinkRequest createOnboardingLinkRequest) {
            return createOnboardingLink(id, createOnboardingLinkRequest, RequestOptions.none());
        }

        /**
         * Create onboarding link
         *
         * <p>Generate a new onboarding link for a connected account. Any existing unused link is
         * invalidated. The link expires after a configured duration.
         *
         * @param id the {@code id} path parameter
         * @param createOnboardingLinkRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<OnboardingLinkResponse> createOnboardingLink(
                final String id,
                final CreateOnboardingLinkRequest createOnboardingLinkRequest,
                final RequestOptions requestOptions) {
            return Connect.this
                    .exchangeCreateOnboardingLink(id, createOnboardingLinkRequest, requestOptions)
                    .sendRaw();
        }
    }
}

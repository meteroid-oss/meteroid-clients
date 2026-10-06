// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.ConnectedAccount;
import com.meteroid.models.ConnectedAccountsResponse;
import com.meteroid.models.CreateConnectedAccountRequest;
import com.meteroid.models.CreateOnboardingLinkRequest;
import com.meteroid.models.OnboardingLinkResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code connect} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class ConnectAsync {
    private final Connect sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public ConnectAsync(Connect sync) {
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
     * List connected accounts
     *
     * <p>List all connected accounts for this platform.
     *
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccountsResponse> listConnectedAccounts() {
        return listConnectedAccounts(RequestOptions.none());
    }

    /**
     * List connected accounts
     *
     * <p>List all connected accounts for this platform.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccountsResponse> listConnectedAccounts(
            final RequestOptions requestOptions) {
        return sync.exchangeListConnectedAccounts(requestOptions).sendAsync();
    }

    /**
     * Create connected account
     *
     * <p>Create a new connected account (Express flow). Returns the account and an onboarding link
     * for the user to complete setup.
     *
     * @param createConnectedAccountRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccount> createConnectedAccount(
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
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccount> createConnectedAccount(
            final CreateConnectedAccountRequest createConnectedAccountRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreateConnectedAccount(createConnectedAccountRequest, requestOptions)
                .sendAsync();
    }

    /**
     * Get connected account
     *
     * <p>Retrieve a connected account by ID.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccount> retrieveConnectedAccount(final String id) {
        return retrieveConnectedAccount(id, RequestOptions.none());
    }

    /**
     * Get connected account
     *
     * <p>Retrieve a connected account by ID.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<ConnectedAccount> retrieveConnectedAccount(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeRetrieveConnectedAccount(id, requestOptions).sendAsync();
    }

    /**
     * Disconnect account
     *
     * <p>Revoke a connected account. All associated tokens are invalidated.
     *
     * @param id the {@code id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<Void> disconnectAccount(final String id) {
        return disconnectAccount(id, RequestOptions.none());
    }

    /**
     * Disconnect account
     *
     * <p>Revoke a connected account. All associated tokens are invalidated.
     *
     * @param id the {@code id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<Void> disconnectAccount(
            final String id, final RequestOptions requestOptions) {
        return sync.exchangeDisconnectAccount(id, requestOptions).sendAsync();
    }

    /**
     * Create onboarding link
     *
     * <p>Generate a new onboarding link for a connected account. Any existing unused link is
     * invalidated. The link expires after a configured duration.
     *
     * @param id the {@code id} path parameter
     * @param createOnboardingLinkRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<OnboardingLinkResponse> createOnboardingLink(
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
     * @return the response body, once received
     */
    public CompletableFuture<OnboardingLinkResponse> createOnboardingLink(
            final String id,
            final CreateOnboardingLinkRequest createOnboardingLinkRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeCreateOnboardingLink(id, createOnboardingLinkRequest, requestOptions)
                .sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List connected accounts
         *
         * <p>List all connected accounts for this platform.
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccountsResponse>> listConnectedAccounts() {
            return listConnectedAccounts(RequestOptions.none());
        }

        /**
         * List connected accounts
         *
         * <p>List all connected accounts for this platform.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccountsResponse>> listConnectedAccounts(
                final RequestOptions requestOptions) {
            return sync.exchangeListConnectedAccounts(requestOptions).sendRawAsync();
        }

        /**
         * Create connected account
         *
         * <p>Create a new connected account (Express flow). Returns the account and an onboarding
         * link for the user to complete setup.
         *
         * @param createConnectedAccountRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccount>> createConnectedAccount(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccount>> createConnectedAccount(
                final CreateConnectedAccountRequest createConnectedAccountRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreateConnectedAccount(
                            createConnectedAccountRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * Get connected account
         *
         * <p>Retrieve a connected account by ID.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccount>> retrieveConnectedAccount(
                final String id) {
            return retrieveConnectedAccount(id, RequestOptions.none());
        }

        /**
         * Get connected account
         *
         * <p>Retrieve a connected account by ID.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<ConnectedAccount>> retrieveConnectedAccount(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeRetrieveConnectedAccount(id, requestOptions).sendRawAsync();
        }

        /**
         * Disconnect account
         *
         * <p>Revoke a connected account. All associated tokens are invalidated.
         *
         * @param id the {@code id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> disconnectAccount(final String id) {
            return disconnectAccount(id, RequestOptions.none());
        }

        /**
         * Disconnect account
         *
         * <p>Revoke a connected account. All associated tokens are invalidated.
         *
         * @param id the {@code id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<Void>> disconnectAccount(
                final String id, final RequestOptions requestOptions) {
            return sync.exchangeDisconnectAccount(id, requestOptions).sendRawAsync();
        }

        /**
         * Create onboarding link
         *
         * <p>Generate a new onboarding link for a connected account. Any existing unused link is
         * invalidated. The link expires after a configured duration.
         *
         * @param id the {@code id} path parameter
         * @param createOnboardingLinkRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OnboardingLinkResponse>> createOnboardingLink(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<OnboardingLinkResponse>> createOnboardingLink(
                final String id,
                final CreateOnboardingLinkRequest createOnboardingLinkRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeCreateOnboardingLink(
                            id, createOnboardingLinkRequest, requestOptions)
                    .sendRawAsync();
        }
    }
}

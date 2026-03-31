// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.ConnectedAccount;
import com.meteroid.models.ConnectedAccountsResponse;
import com.meteroid.models.CreateConnectedAccountRequest;
import com.meteroid.models.CreateOnboardingLinkRequest;
import com.meteroid.models.OnboardingLinkResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Connect {
    private final MeteroidHttpClient client;

    public Connect(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List all connected accounts for this platform. */
    public ConnectedAccountsResponse listConnectedAccounts() throws IOException, ApiException {

        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/connected-accounts");
        return this.client.executeRequest(
                "GET", url.build(), null, null, ConnectedAccountsResponse.class);
    }

    /**
     * Create a new connected account (Express flow). Returns the account and an onboarding link for
     * the user to complete setup.
     */
    public ConnectedAccount createConnectedAccount(
            final CreateConnectedAccountRequest createConnectedAccountRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/connected-accounts");
        return this.client.executeRequest(
                "POST", url.build(), null, createConnectedAccountRequest, ConnectedAccount.class);
    }

    /** Retrieve a connected account by ID. */
    public ConnectedAccount getConnectedAccount(final String id) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/connected-accounts/%s", id));
        return this.client.executeRequest("GET", url.build(), null, null, ConnectedAccount.class);
    }

    /** Revoke a connected account. All associated tokens are invalidated. */
    public void disconnectAccount(final String id) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/connected-accounts/%s", id));
        this.client.executeRequest("DELETE", url.build(), null, null, null);
    }

    /**
     * Generate a new onboarding link for a connected account. Any existing unused link is
     * invalidated. The link expires after a configured duration.
     */
    public OnboardingLinkResponse createOnboardingLink(
            final String id, final CreateOnboardingLinkRequest createOnboardingLinkRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/connected-accounts/%s/onboarding", id));
        return this.client.executeRequest(
                "POST",
                url.build(),
                null,
                createOnboardingLinkRequest,
                OnboardingLinkResponse.class);
    }
}

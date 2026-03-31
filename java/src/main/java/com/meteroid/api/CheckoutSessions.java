// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CancelCheckoutSessionResponse;
import com.meteroid.models.CreateCheckoutSessionRequest;
import com.meteroid.models.CreateCheckoutSessionResponse;
import com.meteroid.models.GetCheckoutSessionResponse;
import com.meteroid.models.ListCheckoutSessionsResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class CheckoutSessions {
    private final MeteroidHttpClient client;

    public CheckoutSessions(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public ListCheckoutSessionsResponse listCheckoutSessions() throws IOException, ApiException {

        return this.listCheckoutSessions(new CheckoutSessionsListCheckoutSessionsOptions());
    }

    /** */
    public ListCheckoutSessionsResponse listCheckoutSessions(
            final CheckoutSessionsListCheckoutSessionsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/checkout-sessions");
        if (options.customerId != null) {
            url.addQueryParameter("customer_id", Utils.serializeQueryParam(options.customerId));
        }
        if (options.status != null) {
            url.addQueryParameter("status", Utils.serializeQueryParam(options.status));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, ListCheckoutSessionsResponse.class);
    }

    /** */
    public CreateCheckoutSessionResponse createCheckoutSession(
            final CreateCheckoutSessionRequest createCheckoutSessionRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/checkout-sessions");
        return this.client.executeRequest(
                "POST",
                url.build(),
                null,
                createCheckoutSessionRequest,
                CreateCheckoutSessionResponse.class);
    }

    /** */
    public GetCheckoutSessionResponse getCheckoutSession(final String id)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/checkout-sessions/%s", id));
        return this.client.executeRequest(
                "GET", url.build(), null, null, GetCheckoutSessionResponse.class);
    }

    /** */
    public CancelCheckoutSessionResponse cancelCheckoutSession(final String id)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/checkout-sessions/%s/cancel", id));
        return this.client.executeRequest(
                "POST", url.build(), null, null, CancelCheckoutSessionResponse.class);
    }
}

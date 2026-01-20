// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.IngestEventsRequest;
import com.meteroid.models.IngestEventsResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Events {
    private final MeteroidHttpClient client;

    public Events(MeteroidHttpClient client) {
        this.client = client;
    }

    /** Ingest usage events for metering and billing purposes. */
    public IngestEventsResponse ingestEvents(final IngestEventsRequest ingestEventsRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/events/ingest");
        return this.client.executeRequest(
                "POST", url.build(), null, ingestEventsRequest, IngestEventsResponse.class);
    }
}

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

    /**
     * Ingest usage events for metering and billing purposes.
     *
     * <p>Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not
     * be double-counted. If timestamps differ across duplicates, the event with the latest
     * timestamp is used.
     *
     * <p>By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to
     * `true` to ingest valid events and receive per-event failure details in the response body.
     */
    public IngestEventsResponse ingestEvents(final IngestEventsRequest ingestEventsRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/events/ingest");
        return this.client.executeRequest(
                "POST", url.build(), null, ingestEventsRequest, IngestEventsResponse.class);
    }
}

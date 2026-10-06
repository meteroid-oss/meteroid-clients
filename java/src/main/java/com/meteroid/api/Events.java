// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.models.IngestEventsRequest;
import com.meteroid.models.IngestEventsResponse;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code events} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Events {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Events(MeteroidHttpClient client) {
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
     * Ingest events
     *
     * <p>Ingest usage events for metering and billing purposes.
     *
     * <p>Events are deduplicated by <code>(event_id, customer_id)</code> — re-sending the same pair
     * will not be double-counted. If timestamps differ across duplicates, the event with the latest
     * timestamp is used.
     *
     * <p>By default, any invalid event rejects the entire batch. Set <code>allow_partial_failures
     * </code> to <code>true</code> to ingest valid events and receive per-event failure details in
     * the response body.
     *
     * @param ingestEventsRequest the request body
     * @return the response body
     */
    public IngestEventsResponse ingest(final IngestEventsRequest ingestEventsRequest) {
        return ingest(ingestEventsRequest, RequestOptions.none());
    }

    /**
     * Ingest events
     *
     * <p>Ingest usage events for metering and billing purposes.
     *
     * <p>Events are deduplicated by <code>(event_id, customer_id)</code> — re-sending the same pair
     * will not be double-counted. If timestamps differ across duplicates, the event with the latest
     * timestamp is used.
     *
     * <p>By default, any invalid event rejects the entire batch. Set <code>allow_partial_failures
     * </code> to <code>true</code> to ingest valid events and receive per-event failure details in
     * the response body.
     *
     * @param ingestEventsRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public IngestEventsResponse ingest(
            final IngestEventsRequest ingestEventsRequest, final RequestOptions requestOptions) {
        return exchangeIngest(ingestEventsRequest, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<IngestEventsResponse> exchangeIngest(
            final IngestEventsRequest ingestEventsRequest, final RequestOptions requestOptions) {
        Objects.requireNonNull(ingestEventsRequest, "body");
        HttpUrl url = client.newUrlBuilder().addPathSegments("api/v1/events/ingest").build();
        return client.call("POST", url)
                .json(ingestEventsRequest)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(IngestEventsResponse.class);
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * Ingest events
         *
         * <p>Ingest usage events for metering and billing purposes.
         *
         * <p>Events are deduplicated by <code>(event_id, customer_id)</code> — re-sending the same
         * pair will not be double-counted. If timestamps differ across duplicates, the event with
         * the latest timestamp is used.
         *
         * <p>By default, any invalid event rejects the entire batch. Set <code>
         * allow_partial_failures</code> to <code>true</code> to ingest valid events and receive
         * per-event failure details in the response body.
         *
         * @param ingestEventsRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<IngestEventsResponse> ingest(
                final IngestEventsRequest ingestEventsRequest) {
            return ingest(ingestEventsRequest, RequestOptions.none());
        }

        /**
         * Ingest events
         *
         * <p>Ingest usage events for metering and billing purposes.
         *
         * <p>Events are deduplicated by <code>(event_id, customer_id)</code> — re-sending the same
         * pair will not be double-counted. If timestamps differ across duplicates, the event with
         * the latest timestamp is used.
         *
         * <p>By default, any invalid event rejects the entire batch. Set <code>
         * allow_partial_failures</code> to <code>true</code> to ingest valid events and receive
         * per-event failure details in the response body.
         *
         * @param ingestEventsRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<IngestEventsResponse> ingest(
                final IngestEventsRequest ingestEventsRequest,
                final RequestOptions requestOptions) {
            return Events.this.exchangeIngest(ingestEventsRequest, requestOptions).sendRaw();
        }
    }
}

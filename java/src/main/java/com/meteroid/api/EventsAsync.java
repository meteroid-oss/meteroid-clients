// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.IngestEventsRequest;
import com.meteroid.models.IngestEventsResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code events} operations, without blocking: each method returns a {@link CompletableFuture}.
 * Obtained from {@code client.async()}.
 */
public final class EventsAsync {
    private final Events sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public EventsAsync(Events sync) {
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
     * @return the response body, once received
     */
    public CompletableFuture<IngestEventsResponse> ingest(
            final IngestEventsRequest ingestEventsRequest) {
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
     * @return the response body, once received
     */
    public CompletableFuture<IngestEventsResponse> ingest(
            final IngestEventsRequest ingestEventsRequest, final RequestOptions requestOptions) {
        return sync.exchangeIngest(ingestEventsRequest, requestOptions).sendAsync();
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<IngestEventsResponse>> ingest(
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
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<IngestEventsResponse>> ingest(
                final IngestEventsRequest ingestEventsRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeIngest(ingestEventsRequest, requestOptions).sendRawAsync();
        }
    }
}

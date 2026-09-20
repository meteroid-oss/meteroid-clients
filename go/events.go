// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// Events groups the events operations of the Meteroid API.
type Events struct {
	client *Client
}

// Ingest usage events for metering and billing purposes.
//
// Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
// double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.
//
// By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body.
func (a *Events) IngestEvents(ctx context.Context, ingestEventsRequest IngestEventsRequest) (*IngestEventsResponse, error) {
	req := newRequest(http.MethodPost, "/api/v1/events/ingest")

	req.SetJSONBody(ingestEventsRequest)

	var out IngestEventsResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

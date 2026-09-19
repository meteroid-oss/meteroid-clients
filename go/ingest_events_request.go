// this file is @generated
package meteroid

type IngestEventsRequest struct {
	// Allow events with timestamps more than 1 day in the past. Defaults to `false`.
	AllowBackfilling *bool `json:"allow_backfilling,omitempty"`

	// Accept the batch even if some events fail validation. Defaults to `false`.
	// When `true`, valid events are ingested and failures are reported in the response body.
	// When `false` (default), any invalid event rejects the entire batch.
	AllowPartialFailures *bool `json:"allow_partial_failures,omitempty"`

	// 1–100 events per request.
	Events RequiredSlice[Event] `json:"events"`
}

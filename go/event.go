// this file is @generated
package meteroid

type Event struct {
	// Billable metric code. Max 512 characters.
	Code string `json:"code"`

	// Meteroid customer ID or external customer alias.
	CustomerId string `json:"customer_id"`

	// Unique event identifier. Max 255 characters. A UUID or ULID is recommended.
	EventId string `json:"event_id"`

	// Arbitrary string key-value pairs used by billable metrics for filtering and aggregation.
	Properties map[string]string `json:"properties,omitempty"`

	// RFC 3339 timestamp. Defaults to ingestion time if omitted.
	// Must be between 24 hours ago and 1 hour from now. Set `allow_backfilling` to remove the past limit.
	Timestamp string `json:"timestamp"`
}

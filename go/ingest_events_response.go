// this file is @generated
package meteroid

type IngestEventsResponse struct {
	// Events that failed to ingest. Omitted when no failures.
	Failures []IngestFailure `json:"failures,omitempty"`
}

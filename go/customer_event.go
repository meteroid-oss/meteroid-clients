// this file is @generated
package meteroid

import "time"

// Event-specific webhook schemas for type-safe webhook payloads
type CustomerEvent struct {
	CustomerEventData

	Id EventId `json:"id"`

	// RFC 3339 timestamp.
	Timestamp time.Time `json:"timestamp"`

	Type EventType `json:"type"`
}

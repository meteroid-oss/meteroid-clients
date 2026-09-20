// this file is @generated
package meteroid

import "time"

type ProductEvent struct {
	ProductEventData

	Id EventId `json:"id"`

	// RFC 3339 timestamp.
	Timestamp time.Time `json:"timestamp"`

	Type EventType `json:"type"`
}

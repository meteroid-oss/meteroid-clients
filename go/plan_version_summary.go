// this file is @generated
package meteroid

import "time"

type PlanVersionSummary struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency string `json:"currency"`

	Id PlanVersionId `json:"id"`

	IsDraft bool `json:"is_draft"`

	Version int32 `json:"version"`
}

// this file is @generated
package meteroid

import "time"

type PlanEventData struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Currency string `json:"currency"`

	Description *string `json:"description,omitempty"`

	Name string `json:"name"`

	PlanId PlanId `json:"plan_id"`

	PlanType PlanTypeEnum `json:"plan_type"`

	Status PlanStatusEnum `json:"status"`

	Version int32 `json:"version"`
}

// this file is @generated
package meteroid

import "time"

type MeteredEntitlementUsage struct {
	Consumed *string `json:"consumed,omitempty"`

	Remaining *string `json:"remaining,omitempty"`

	// RFC 3339 timestamp.
	ResetAt *time.Time `json:"reset_at,omitempty"`
}

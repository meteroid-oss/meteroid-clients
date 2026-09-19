// this file is @generated
package meteroid

type MeteredEntitlementValue struct {
	// Per-entitlement kill switch. `false` means disabled.
	Enabled *bool `json:"enabled,omitempty"`

	// Cap on usage. Null means unlimited.
	Limit *string `json:"limit,omitempty"`

	ResetPeriod *ResetPeriod `json:"reset_period,omitempty"`
}

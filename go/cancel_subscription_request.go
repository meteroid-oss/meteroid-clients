// this file is @generated
package meteroid

type CancelSubscriptionRequest struct {
	// If not provided, the cancellation will be effective at the end of the current billing or committed period.
	EffectiveDate *string `json:"effective_date,omitempty"`

	Reason *string `json:"reason,omitempty"`
}

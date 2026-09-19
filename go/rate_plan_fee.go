// this file is @generated
package meteroid

// Recurring rate fee (e.g., monthly subscription)
type RatePlanFee struct {
	Rates RequiredSlice[TermRate] `json:"rates"`
}

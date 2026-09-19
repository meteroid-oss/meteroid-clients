// this file is @generated
package meteroid

// Slot-based fee (e.g., per-seat pricing)
type SlotPlanFee struct {
	MinimumCount *int32 `json:"minimum_count,omitempty"`

	Quota *int32 `json:"quota,omitempty"`

	Rates RequiredSlice[TermRate] `json:"rates"`

	SlotUnitName string `json:"slot_unit_name"`
}

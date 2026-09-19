// this file is @generated
package meteroid

type SlotFee struct {
	InitialSlots int32 `json:"initial_slots"`

	MaxSlots *int32 `json:"max_slots,omitempty"`

	MinSlots *int32 `json:"min_slots,omitempty"`

	Unit string `json:"unit"`

	UnitRate string `json:"unit_rate"`
}

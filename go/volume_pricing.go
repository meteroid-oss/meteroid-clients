// this file is @generated
package meteroid

type VolumePricing struct {
	BlockSize *int64 `json:"block_size,omitempty"`

	Tiers RequiredSlice[TierRow] `json:"tiers"`
}

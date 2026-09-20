// this file is @generated
package meteroid

type MinimumCommitmentInput struct {
	// Decimal string in the plan currency.
	Amount string `json:"amount"`

	Scope MinimumCommitmentInputScope `json:"scope"`
}

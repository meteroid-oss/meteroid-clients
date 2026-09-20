// this file is @generated
package meteroid

type MinimumCommitment struct {
	// Decimal string in the plan currency, e.g. "100.00".
	Amount string `json:"amount"`

	Scope MinimumCommitmentScope `json:"scope"`
}

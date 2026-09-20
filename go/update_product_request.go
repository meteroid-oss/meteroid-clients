// this file is @generated
package meteroid

type UpdateProductRequest struct {
	Description *string `json:"description,omitempty"`

	FeeStructure *ProductFeeStructure `json:"fee_structure,omitempty"`

	Name *string `json:"name,omitempty"`
}

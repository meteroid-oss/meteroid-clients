// this file is @generated
package meteroid

type CreateProductRequest struct {
	Catalog *bool `json:"catalog,omitempty"`

	Description *string `json:"description,omitempty"`

	FeeStructure ProductFeeStructure `json:"fee_structure"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`
}

// this file is @generated
package meteroid

import "time"

type Product struct {
	// RFC 3339 timestamp.
	ArchivedAt *time.Time `json:"archived_at,omitempty"`

	Catalog bool `json:"catalog"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	FeeStructure ProductFeeStructure `json:"fee_structure"`

	FeeType ProductFeeTypeEnum `json:"fee_type"`

	Id ProductId `json:"id"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`
}

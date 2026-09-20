// this file is @generated
package meteroid

import "time"

type ProductEventData struct {
	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Description *string `json:"description,omitempty"`

	FeeType ProductFeeTypeEnum `json:"fee_type"`

	Name string `json:"name"`

	ProductFamilyId ProductFamilyId `json:"product_family_id"`

	ProductId ProductId `json:"product_id"`
}

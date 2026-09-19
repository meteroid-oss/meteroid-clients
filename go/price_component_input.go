// this file is @generated
package meteroid

type PriceComponentInput struct {
	Fee Fee `json:"fee"`

	Name string `json:"name"`

	ProductId *ProductId `json:"product_id,omitempty"`
}

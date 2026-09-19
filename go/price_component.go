// this file is @generated
package meteroid

type PriceComponent struct {
	Fee *Fee `json:"fee,omitempty"`

	Id PriceComponentId `json:"id"`

	Name string `json:"name"`

	ProductId *ProductId `json:"product_id,omitempty"`
}

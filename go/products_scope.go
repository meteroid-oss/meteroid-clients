// this file is @generated
package meteroid

// Only lines for the listed products count. A product is the identity shared by plan
// components, overrides and ad-hoc extras, so a subscription's billed set is matched uniformly.
type ProductsScope struct {
	ProductIds RequiredSlice[string] `json:"product_ids"`
}

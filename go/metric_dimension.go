// this file is @generated
package meteroid

type MetricDimension struct {
	Key string `json:"key"`

	Values RequiredSlice[string] `json:"values"`
}

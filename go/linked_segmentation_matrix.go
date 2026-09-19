// this file is @generated
package meteroid

type LinkedSegmentationMatrix struct {
	Dimension1Key string `json:"dimension1_key"`

	Dimension2Key string `json:"dimension2_key"`

	Values RequiredMap[[]string] `json:"values"`
}

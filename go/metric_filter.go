// this file is @generated
package meteroid

// A pre-aggregation filter: only events whose `property` matches feed the metric's
// aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple
// filters are ANDed.
type MetricFilter struct {
	Op MetricFilterOperator `json:"op"`

	Property string `json:"property"`

	Values RequiredSlice[string] `json:"values"`
}

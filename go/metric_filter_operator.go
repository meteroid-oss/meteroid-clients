// this file is @generated
package meteroid

// Operator of a pre-aggregation [`MetricFilter`]. `EQUAL`/`NOT_EQUAL` are the single-value
// forms of `IN`/`NOT_IN`. Negation (`NOT_EQUAL`/`NOT_IN`) is presence-required: an event
// missing the property is excluded.
type MetricFilterOperator string

// Known values of MetricFilterOperator.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	MetricFilterOperatorEqual    MetricFilterOperator = "EQUAL"
	MetricFilterOperatorNotEqual MetricFilterOperator = "NOT_EQUAL"
	MetricFilterOperatorIn       MetricFilterOperator = "IN"
	MetricFilterOperatorNotIn    MetricFilterOperator = "NOT_IN"
)

// AllMetricFilterOperatorValues lists every MetricFilterOperator value known to this SDK version.
var AllMetricFilterOperatorValues = []MetricFilterOperator{
	MetricFilterOperatorEqual,
	MetricFilterOperatorNotEqual,
	MetricFilterOperatorIn,
	MetricFilterOperatorNotIn,
}

// String returns the wire representation of the value.
func (e MetricFilterOperator) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e MetricFilterOperator) IsKnown() bool {
	for _, known := range AllMetricFilterOperatorValues {
		if e == known {
			return true
		}
	}
	return false
}

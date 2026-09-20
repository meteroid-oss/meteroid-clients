// this file is @generated
package meteroid

type BillingMetricAggregateEnum string

// Known values of BillingMetricAggregateEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	BillingMetricAggregateEnumCount         BillingMetricAggregateEnum = "COUNT"
	BillingMetricAggregateEnumLatest        BillingMetricAggregateEnum = "LATEST"
	BillingMetricAggregateEnumMax           BillingMetricAggregateEnum = "MAX"
	BillingMetricAggregateEnumMin           BillingMetricAggregateEnum = "MIN"
	BillingMetricAggregateEnumMean          BillingMetricAggregateEnum = "MEAN"
	BillingMetricAggregateEnumSum           BillingMetricAggregateEnum = "SUM"
	BillingMetricAggregateEnumCountDistinct BillingMetricAggregateEnum = "COUNT_DISTINCT"
)

// AllBillingMetricAggregateEnumValues lists every BillingMetricAggregateEnum value known to this SDK version.
var AllBillingMetricAggregateEnumValues = []BillingMetricAggregateEnum{
	BillingMetricAggregateEnumCount,
	BillingMetricAggregateEnumLatest,
	BillingMetricAggregateEnumMax,
	BillingMetricAggregateEnumMin,
	BillingMetricAggregateEnumMean,
	BillingMetricAggregateEnumSum,
	BillingMetricAggregateEnumCountDistinct,
}

// String returns the wire representation of the value.
func (e BillingMetricAggregateEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e BillingMetricAggregateEnum) IsKnown() bool {
	for _, known := range AllBillingMetricAggregateEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

// this file is @generated
package meteroid

type SubscriptionFeeBillingPeriodEnum string

// Known values of SubscriptionFeeBillingPeriodEnum.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	SubscriptionFeeBillingPeriodEnumOneTime    SubscriptionFeeBillingPeriodEnum = "ONE_TIME"
	SubscriptionFeeBillingPeriodEnumMonthly    SubscriptionFeeBillingPeriodEnum = "MONTHLY"
	SubscriptionFeeBillingPeriodEnumQuarterly  SubscriptionFeeBillingPeriodEnum = "QUARTERLY"
	SubscriptionFeeBillingPeriodEnumSemiannual SubscriptionFeeBillingPeriodEnum = "SEMIANNUAL"
	SubscriptionFeeBillingPeriodEnumAnnual     SubscriptionFeeBillingPeriodEnum = "ANNUAL"
)

// AllSubscriptionFeeBillingPeriodEnumValues lists every SubscriptionFeeBillingPeriodEnum value known to this SDK version.
var AllSubscriptionFeeBillingPeriodEnumValues = []SubscriptionFeeBillingPeriodEnum{
	SubscriptionFeeBillingPeriodEnumOneTime,
	SubscriptionFeeBillingPeriodEnumMonthly,
	SubscriptionFeeBillingPeriodEnumQuarterly,
	SubscriptionFeeBillingPeriodEnumSemiannual,
	SubscriptionFeeBillingPeriodEnumAnnual,
}

// String returns the wire representation of the value.
func (e SubscriptionFeeBillingPeriodEnum) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e SubscriptionFeeBillingPeriodEnum) IsKnown() bool {
	for _, known := range AllSubscriptionFeeBillingPeriodEnumValues {
		if e == known {
			return true
		}
	}
	return false
}

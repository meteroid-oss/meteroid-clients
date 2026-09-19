// this file is @generated
package meteroid

// Extra recurring fee
type ExtraRecurringPlanFee struct {
	BillingType BillingType `json:"billing_type"`

	Cadence BillingPeriodEnum `json:"cadence"`

	Quantity int32 `json:"quantity"`

	UnitPrice string `json:"unit_price"`
}

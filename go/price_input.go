// this file is @generated
package meteroid

type PriceInput struct {
	Cadence BillingPeriodEnum `json:"cadence"`

	Currency string `json:"currency"`

	Pricing Pricing `json:"pricing"`
}

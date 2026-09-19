// this file is @generated
package meteroid

import "encoding/json"

type CustomerEventData struct {
	Alias *string `json:"alias,omitempty"`

	BillingEmail *string `json:"billing_email,omitempty"`

	Currency string `json:"currency"`

	// User-defined custom property values, keyed by definition key.
	CustomProperties json.RawMessage `json:"custom_properties"`

	CustomerId CustomerId `json:"customer_id"`

	InvoicingEmails RequiredSlice[string] `json:"invoicing_emails"`

	Name string `json:"name"`

	Phone *string `json:"phone,omitempty"`
}

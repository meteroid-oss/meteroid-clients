// this file is @generated
package meteroid

import "time"

type CustomerDetails struct {
	Alias *string `json:"alias,omitempty"`

	BillingAddress *Address `json:"billing_address,omitempty"`

	Email *string `json:"email,omitempty"`

	Id CustomerId `json:"id"`

	Name string `json:"name"`

	// RFC 3339 timestamp.
	SnapshotAt time.Time `json:"snapshot_at"`

	VatNumber *string `json:"vat_number,omitempty"`
}

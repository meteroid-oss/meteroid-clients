// this file is @generated
package meteroid

import "encoding/json"

type CreateConnectedAccountRequest struct {
	ConnectedOrganizationId string `json:"connected_organization_id"`

	ConnectionType *ConnectionType `json:"connection_type,omitempty"`

	Metadata json.RawMessage `json:"metadata,omitempty"`

	PlatformCustomerId *CustomerId `json:"platform_customer_id,omitempty"`
}

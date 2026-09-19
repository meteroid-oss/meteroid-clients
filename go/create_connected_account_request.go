// this file is @generated
package meteroid

type CreateConnectedAccountRequest struct {
	ConnectedOrganizationId string `json:"connected_organization_id"`

	ConnectionType *ConnectionType `json:"connection_type,omitempty"`

	Metadata map[string]any `json:"metadata,omitempty"`

	PlatformCustomerId *CustomerId `json:"platform_customer_id,omitempty"`
}

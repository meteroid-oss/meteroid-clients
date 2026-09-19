// this file is @generated
package meteroid

import "time"

// A connected account (relationship between platform and connected org)
type ConnectedAccount struct {
	ConnectedOrganizationId *OrganizationId `json:"connected_organization_id,omitempty"`

	ConnectedTenantId *TenantId `json:"connected_tenant_id,omitempty"`

	ConnectionType ConnectionType `json:"connection_type"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Id ConnectedAccountId `json:"id"`

	Metadata map[string]any `json:"metadata,omitempty"`

	// RFC 3339 timestamp.
	OnboardingCompletedAt *time.Time `json:"onboarding_completed_at,omitempty"`

	OnboardingMode OnboardingMode `json:"onboarding_mode"`

	PendingCountry *CountryCode `json:"pending_country,omitempty"`

	// Email of the user being invited (express flow only)
	PendingEmail *string `json:"pending_email,omitempty"`

	// Name of the organization to be created (express flow only)
	PendingOrganizationName *string `json:"pending_organization_name,omitempty"`

	PlatformCustomerId *CustomerId `json:"platform_customer_id,omitempty"`

	PlatformOrganizationId OrganizationId `json:"platform_organization_id"`

	// RFC 3339 timestamp.
	RevokedAt *time.Time `json:"revoked_at,omitempty"`

	Status ConnectionStatus `json:"status"`
}

// this file is @generated
package meteroid

import "time"

// An OAuth application registered by a platform
type OAuthApp struct {
	ClientId string `json:"client_id"`

	ClientSecretHint string `json:"client_secret_hint"`

	// RFC 3339 timestamp.
	CreatedAt time.Time `json:"created_at"`

	Id OAuthAppId `json:"id"`

	IsActive bool `json:"is_active"`

	Name string `json:"name"`

	OrganizationId OrganizationId `json:"organization_id"`

	RedirectUris RequiredSlice[string] `json:"redirect_uris"`

	Scopes RequiredSlice[string] `json:"scopes"`

	// RFC 3339 timestamp.
	UpdatedAt *time.Time `json:"updated_at,omitempty"`
}

// this file is @generated
package meteroid

// Token request (from POST body, application/x-www-form-urlencoded)
type TokenRequest struct {
	// Client ID (if not using HTTP Basic auth)
	ClientId *string `json:"client_id,omitempty"`

	// Client secret (if not using HTTP Basic auth)
	ClientSecret *string `json:"client_secret,omitempty"`

	// Authorization code (for authorization_code grant)
	Code *string `json:"code,omitempty"`

	// PKCE code verifier (for authorization_code grant with PKCE)
	CodeVerifier *string `json:"code_verifier,omitempty"`

	// Grant type: "authorization_code" or "refresh_token"
	GrantType string `json:"grant_type"`

	// Redirect URI (for authorization_code grant, must match the one used in /authorize)
	RedirectUri *string `json:"redirect_uri,omitempty"`

	// Refresh token (for refresh_token grant)
	RefreshToken *string `json:"refresh_token,omitempty"`
}

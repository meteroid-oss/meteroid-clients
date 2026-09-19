// this file is @generated
package meteroid

// Token response as per OAuth 2.0 spec
type TokenResponse struct {
	AccessToken string `json:"access_token"`

	ExpiresIn int64 `json:"expires_in"`

	RefreshToken *string `json:"refresh_token,omitempty"`

	Scope *string `json:"scope,omitempty"`

	TokenType string `json:"token_type"`
}

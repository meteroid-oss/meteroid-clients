// this file is @generated
package meteroid

// Token revocation request
type RevocationRequest struct {
	// The token to revoke
	Token string `json:"token"`

	// Optional hint about the token type (access_token or refresh_token)
	TokenTypeHint *string `json:"token_type_hint,omitempty"`
}

// this file is @generated
package meteroid

// Token introspection response as per RFC 7662
type TokenIntrospectionResponse struct {
	Active bool `json:"active"`

	ClientId *string `json:"client_id,omitempty"`

	Exp *int64 `json:"exp,omitempty"`

	Iat *int64 `json:"iat,omitempty"`

	Scope *string `json:"scope,omitempty"`

	Sub *string `json:"sub,omitempty"`

	TokenType *string `json:"token_type,omitempty"`
}

// this file is @generated
package meteroid

// OAuth 2.0 error response as per RFC 6749 Section 5.2
type OAuthErrorResponse struct {
	Error OAuthErrorCode `json:"error"`

	ErrorDescription *string `json:"error_description,omitempty"`

	ErrorUri *string `json:"error_uri,omitempty"`
}

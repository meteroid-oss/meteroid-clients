// this file is @generated
package meteroid

// OAuth 2.0 error codes as per RFC 6749
type OAuthErrorCode string

// Known values of OAuthErrorCode.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	OAuthErrorCodeInvalidRequest          OAuthErrorCode = "invalid_request"
	OAuthErrorCodeUnauthorizedClient      OAuthErrorCode = "unauthorized_client"
	OAuthErrorCodeAccessDenied            OAuthErrorCode = "access_denied"
	OAuthErrorCodeUnsupportedResponseType OAuthErrorCode = "unsupported_response_type"
	OAuthErrorCodeInvalidScope            OAuthErrorCode = "invalid_scope"
	OAuthErrorCodeServerError             OAuthErrorCode = "server_error"
	OAuthErrorCodeTemporarilyUnavailable  OAuthErrorCode = "temporarily_unavailable"
	OAuthErrorCodeInvalidGrant            OAuthErrorCode = "invalid_grant"
	OAuthErrorCodeInvalidClient           OAuthErrorCode = "invalid_client"
	OAuthErrorCodeUnsupportedGrantType    OAuthErrorCode = "unsupported_grant_type"
)

// AllOAuthErrorCodeValues lists every OAuthErrorCode value known to this SDK version.
var AllOAuthErrorCodeValues = []OAuthErrorCode{
	OAuthErrorCodeInvalidRequest,
	OAuthErrorCodeUnauthorizedClient,
	OAuthErrorCodeAccessDenied,
	OAuthErrorCodeUnsupportedResponseType,
	OAuthErrorCodeInvalidScope,
	OAuthErrorCodeServerError,
	OAuthErrorCodeTemporarilyUnavailable,
	OAuthErrorCodeInvalidGrant,
	OAuthErrorCodeInvalidClient,
	OAuthErrorCodeUnsupportedGrantType,
}

// String returns the wire representation of the value.
func (e OAuthErrorCode) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e OAuthErrorCode) IsKnown() bool {
	for _, known := range AllOAuthErrorCodeValues {
		if e == known {
			return true
		}
	}
	return false
}

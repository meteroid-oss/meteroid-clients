// this file is @generated
package meteroid

type CustomerPortalTokenRequest struct {
	// Token lifetime in seconds. Defaults to 86400 (24 hours).
	// Must be between 60 and 2592000 (30 days).
	ExpiresInSeconds *int32 `json:"expires_in_seconds,omitempty"`
}

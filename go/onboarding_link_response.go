// this file is @generated
package meteroid

import "time"

// Result of creating an onboarding link
type OnboardingLinkResponse struct {
	// RFC 3339 timestamp.
	ExpiresAt time.Time `json:"expires_at"`

	Url string `json:"url"`
}

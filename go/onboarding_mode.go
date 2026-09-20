// this file is @generated
package meteroid

// Onboarding mode for connected accounts
type OnboardingMode string

// Known values of OnboardingMode.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	OnboardingModeExpress OnboardingMode = "express"
	OnboardingModeFull    OnboardingMode = "full"
)

// AllOnboardingModeValues lists every OnboardingMode value known to this SDK version.
var AllOnboardingModeValues = []OnboardingMode{
	OnboardingModeExpress,
	OnboardingModeFull,
}

// String returns the wire representation of the value.
func (e OnboardingMode) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e OnboardingMode) IsKnown() bool {
	for _, known := range AllOnboardingModeValues {
		if e == known {
			return true
		}
	}
	return false
}

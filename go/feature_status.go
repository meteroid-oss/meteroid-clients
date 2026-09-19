// this file is @generated
package meteroid

// Lifecycle status of a feature.
type FeatureStatus string

// Known values of FeatureStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	FeatureStatusActive   FeatureStatus = "ACTIVE"
	FeatureStatusDisabled FeatureStatus = "DISABLED"
	FeatureStatusArchived FeatureStatus = "ARCHIVED"
)

// AllFeatureStatusValues lists every FeatureStatus value known to this SDK version.
var AllFeatureStatusValues = []FeatureStatus{
	FeatureStatusActive,
	FeatureStatusDisabled,
	FeatureStatusArchived,
}

// String returns the wire representation of the value.
func (e FeatureStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e FeatureStatus) IsKnown() bool {
	for _, known := range AllFeatureStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

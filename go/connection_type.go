// this file is @generated
package meteroid

// Type of connection between platform and connected account
type ConnectionType string

// Known values of ConnectionType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ConnectionTypeStandard ConnectionType = "standard"
	ConnectionTypeExpress  ConnectionType = "express"
)

// AllConnectionTypeValues lists every ConnectionType value known to this SDK version.
var AllConnectionTypeValues = []ConnectionType{
	ConnectionTypeStandard,
	ConnectionTypeExpress,
}

// String returns the wire representation of the value.
func (e ConnectionType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ConnectionType) IsKnown() bool {
	for _, known := range AllConnectionTypeValues {
		if e == known {
			return true
		}
	}
	return false
}

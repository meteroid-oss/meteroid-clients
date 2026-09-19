// this file is @generated
package meteroid

// Status of a connected account
type ConnectionStatus string

// Known values of ConnectionStatus.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ConnectionStatusPending   ConnectionStatus = "pending"
	ConnectionStatusActive    ConnectionStatus = "active"
	ConnectionStatusRevoked   ConnectionStatus = "revoked"
	ConnectionStatusSuspended ConnectionStatus = "suspended"
)

// AllConnectionStatusValues lists every ConnectionStatus value known to this SDK version.
var AllConnectionStatusValues = []ConnectionStatus{
	ConnectionStatusPending,
	ConnectionStatusActive,
	ConnectionStatusRevoked,
	ConnectionStatusSuspended,
}

// String returns the wire representation of the value.
func (e ConnectionStatus) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ConnectionStatus) IsKnown() bool {
	for _, known := range AllConnectionStatusValues {
		if e == known {
			return true
		}
	}
	return false
}

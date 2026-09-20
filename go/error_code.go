// this file is @generated
package meteroid

type ErrorCode string

// Known values of ErrorCode.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	ErrorCodeBadRequest          ErrorCode = "BAD_REQUEST"
	ErrorCodeNotFound            ErrorCode = "NOT_FOUND"
	ErrorCodeConflict            ErrorCode = "CONFLICT"
	ErrorCodeForbidden           ErrorCode = "FORBIDDEN"
	ErrorCodeUnauthorized        ErrorCode = "UNAUTHORIZED"
	ErrorCodeTooManyRequests     ErrorCode = "TOO_MANY_REQUESTS"
	ErrorCodeInternalServerError ErrorCode = "INTERNAL_SERVER_ERROR"
)

// AllErrorCodeValues lists every ErrorCode value known to this SDK version.
var AllErrorCodeValues = []ErrorCode{
	ErrorCodeBadRequest,
	ErrorCodeNotFound,
	ErrorCodeConflict,
	ErrorCodeForbidden,
	ErrorCodeUnauthorized,
	ErrorCodeTooManyRequests,
	ErrorCodeInternalServerError,
}

// String returns the wire representation of the value.
func (e ErrorCode) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e ErrorCode) IsKnown() bool {
	for _, known := range AllErrorCodeValues {
		if e == known {
			return true
		}
	}
	return false
}

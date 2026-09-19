package meteroid

import (
	"encoding/json"
	"fmt"
	"strings"
)

// APIError is returned for every non-2xx response from the Meteroid API.
//
// The status code and the raw body are always captured. The body is decoded,
// in this order, as:
//
//  1. a [RestErrorResponse] ({"code": ..., "message": ...}), the shape of
//     every documented non-OAuth error response, into Payload;
//  2. failing that, an [OAuthErrorResponse] ({"error": ..., ...}), the shape
//     of the OAuth endpoints' error responses, into OAuthPayload.
//
// When the body matches neither (not JSON, or missing a required field), both
// are nil and only StatusCode and RawBody are set. Every status, including
// 422, goes through the same path.
//
// Error codes are open string enums: a code this SDK version does not know
// about still decodes (check it with [ErrorCode.IsKnown]).
//
//	var apiErr *meteroid.APIError
//	if errors.As(err, &apiErr) {
//		switch {
//		case apiErr.Payload != nil:
//			log.Printf("status=%d code=%s: %s", apiErr.StatusCode, apiErr.Payload.Code, apiErr.Payload.Message)
//		case apiErr.OAuthPayload != nil:
//			log.Printf("status=%d oauth error=%s", apiErr.StatusCode, apiErr.OAuthPayload.Error)
//		default:
//			log.Printf("status=%d body=%s", apiErr.StatusCode, apiErr.RawBody)
//		}
//	}
type APIError struct {
	// StatusCode is the HTTP status of the response.
	StatusCode int
	// Payload is the decoded [RestErrorResponse], or nil when the body is not
	// one.
	Payload *RestErrorResponse
	// OAuthPayload is the decoded [OAuthErrorResponse], or nil when the body is
	// not one (or was already decoded as a Payload).
	OAuthPayload *OAuthErrorResponse
	// RawBody is the response body exactly as received.
	RawBody []byte
}

func newAPIError(statusCode int, body []byte) *APIError {
	err := &APIError{StatusCode: statusCode, RawBody: body}

	var rest RestErrorResponse
	if decodeWithRequired(body, &rest, "code", "message") {
		err.Payload = &rest
		return err
	}

	var oauth OAuthErrorResponse
	if decodeWithRequired(body, &oauth, "error") {
		err.OAuthPayload = &oauth
	}
	return err
}

// decodeWithRequired decodes a JSON object into out, and reports success only
// when every one of the required fields is present and non-null.
// encoding/json alone would happily decode {} (or another schema's object) into
// a zero-valued struct.
func decodeWithRequired(body []byte, out any, required ...string) bool {
	var fields map[string]json.RawMessage
	if json.Unmarshal(body, &fields) != nil {
		return false
	}
	for _, name := range required {
		raw, ok := fields[name]
		if !ok || string(raw) == "null" {
			return false
		}
	}
	return json.Unmarshal(body, out) == nil
}

func (e *APIError) Error() string {
	var b strings.Builder
	fmt.Fprintf(&b, "meteroid: API error (status %d)", e.StatusCode)

	switch {
	case e.Payload != nil:
		fmt.Fprintf(&b, ": %s (code %s)", e.Payload.Message, e.Payload.Code)
	case e.OAuthPayload != nil:
		fmt.Fprintf(&b, ": %s", e.OAuthPayload.Error)
		if e.OAuthPayload.ErrorDescription != nil {
			fmt.Fprintf(&b, ": %s", *e.OAuthPayload.ErrorDescription)
		}
	case len(e.RawBody) > 0:
		fmt.Fprintf(&b, ": %s", truncate(string(e.RawBody), 512))
	}

	return b.String()
}

// TransportError is returned when the request could not be completed at the
// HTTP level: the connection failed, the server could not be reached, the
// response body could not be read, or the context was cancelled or its
// deadline (or the client's per-attempt [Options.Timeout]) expired. No usable
// response was received, so there is no status code.
//
// It wraps the underlying error, so errors.Is(err, context.Canceled) and
// errors.Is(err, context.DeadlineExceeded) keep working, and errors.As reaches
// the *url.Error or net.Error underneath.
//
//	var transportErr *meteroid.TransportError
//	if errors.As(err, &transportErr) {
//		log.Printf("Meteroid unreachable (%s %s): %v", transportErr.Method, transportErr.Path, transportErr.Err)
//	}
type TransportError struct {
	// Method is the HTTP method of the request.
	Method string
	// Path is the API path template of the operation, e.g.
	// "/api/v1/customers/{id_or_alias}".
	Path string
	// Err is the underlying error, usually from net/http or the context.
	Err error
}

func (e *TransportError) Error() string {
	return fmt.Sprintf("meteroid: %s %s: %v", e.Method, e.Path, e.Err)
}

// Unwrap returns the underlying error.
func (e *TransportError) Unwrap() error { return e.Err }

// DecodeError is returned when the API answered with a 2xx status but the SDK
// could not decode the response body into the expected type. The request
// itself succeeded on the server side: retrying a non-idempotent operation may
// repeat it.
//
// It wraps the error from encoding/json, so errors.As can reach e.g. a
// *json.UnmarshalTypeError or *json.SyntaxError.
type DecodeError struct {
	// StatusCode is the HTTP status of the response.
	StatusCode int
	// RawBody is the response body exactly as received.
	RawBody []byte
	// Err is the decoding error.
	Err error
}

func (e *DecodeError) Error() string {
	return fmt.Sprintf("meteroid: decoding response body (status %d): %v", e.StatusCode, e.Err)
}

// Unwrap returns the underlying decoding error.
func (e *DecodeError) Unwrap() error { return e.Err }

// UnionError reports a tagged union that could not be encoded, because no
// variant was set or because the discriminator is not one this SDK version
// knows about.
type UnionError struct {
	// Union is the name of the union type, e.g. "SubscriptionFee".
	Union string
	// Discriminator is the discriminator value that was set, if any.
	Discriminator string
	// Reason explains what went wrong.
	Reason string
}

func (e *UnionError) Error() string {
	if e.Discriminator == "" {
		return fmt.Sprintf("meteroid: cannot encode %s: %s", e.Union, e.Reason)
	}
	return fmt.Sprintf("meteroid: cannot encode %s variant %q: %s", e.Union, e.Discriminator, e.Reason)
}

func truncate(s string, n int) string {
	if len(s) <= n {
		return s
	}
	return s[:n] + "..."
}

package main

import (
	"errors"
	"fmt"
	"net/http"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// errorCode is the machine-readable identifier of the contract's `ErrorCode` schema.
type errorCode string

const (
	codeBadRequest   errorCode = "BAD_REQUEST"
	codeUnauthorized errorCode = "UNAUTHORIZED"
	codeNotFound     errorCode = "NOT_FOUND"
	// Reserved by the contract; no operation requires a subscription.
	codeNoSubscription          errorCode = "NO_SUBSCRIPTION"
	codeFeatureNotEntitled      errorCode = "FEATURE_NOT_ENTITLED"
	codeQuotaExhausted          errorCode = "QUOTA_EXHAUSTED"
	codeCheckoutUnavailable     errorCode = "CHECKOUT_UNAVAILABLE"
	codeCatalogNotSeeded        errorCode = "CATALOG_NOT_SEEDED"
	codeWebhookSignatureInvalid errorCode = "WEBHOOK_SIGNATURE_INVALID"
	codeUpstreamUnauthorized    errorCode = "UPSTREAM_UNAUTHORIZED"
	codeUpstreamError           errorCode = "UPSTREAM_ERROR"
	codeRateLimited             errorCode = "RATE_LIMITED"
	codeInternal                errorCode = "INTERNAL"
)

var statusByCode = map[errorCode]int{
	codeBadRequest:              http.StatusBadRequest,
	codeWebhookSignatureInvalid: http.StatusBadRequest,
	codeUnauthorized:            http.StatusUnauthorized,
	codeQuotaExhausted:          http.StatusPaymentRequired,
	codeFeatureNotEntitled:      http.StatusForbidden,
	codeNotFound:                http.StatusNotFound,
	codeNoSubscription:          http.StatusConflict,
	codeCheckoutUnavailable:     http.StatusConflict,
	codeRateLimited:             http.StatusTooManyRequests,
	codeInternal:                http.StatusInternalServerError,
	codeUpstreamUnauthorized:    http.StatusBadGateway,
	codeUpstreamError:           http.StatusBadGateway,
	codeCatalogNotSeeded:        http.StatusServiceUnavailable,
}

// apiError is the single error envelope of examples/openapi.yaml, and the only error
// type a handler returns on purpose.
//
// Quota and UpgradePlanCode carry no `omitempty`: both are always serialized, null
// where they do not apply, so a strict client never has to tell an absent key from a
// null one.
type apiError struct {
	Code            errorCode      `json:"code"`
	Message         string         `json:"message"`
	Quota           *QuotaSnapshot `json:"quota"`
	UpgradePlanCode *PlanCode      `json:"upgrade_plan_code"`

	// status is set only where the HTTP status is not the one the code implies (a 413).
	status int
}

func newAPIError(code errorCode, format string, args ...any) *apiError {
	return &apiError{Code: code, Message: fmt.Sprintf(format, args...)}
}

func badRequest(format string, args ...any) *apiError {
	return newAPIError(codeBadRequest, format, args...)
}

func unauthorized(message string) *apiError {
	return newAPIError(codeUnauthorized, "%s", message)
}

func catalogNotSeeded(format string, args ...any) *apiError {
	return newAPIError(codeCatalogNotSeeded, format, args...)
}

func internalError(format string, args ...any) *apiError {
	return newAPIError(codeInternal, format, args...)
}

// Error is the message alone: it is what the startup probe logs, and the code is
// already a field wherever an apiError is looked at as one.
func (e *apiError) Error() string { return e.Message }

func (e *apiError) httpStatus() int {
	if e.status != 0 {
		return e.status
	}
	return statusByCode[e.Code]
}

func (e *apiError) withQuota(quota QuotaSnapshot) *apiError {
	e.Quota = &quota
	return e
}

func (e *apiError) withUpgrade(plan *PlanCode) *apiError {
	e.UpgradePlanCode = plan
	return e
}

func (e *apiError) withStatus(status int) *apiError {
	e.status = status
	return e
}

// upstream translates an SDK failure into this contract's envelope. It sits in the
// `if err != nil` directly under the SDK call it belongs to:
//
//	customer, err := a.meteroid.Customers().GetCustomer(ctx, alias)
//	if err != nil {
//		return nil, upstream("GET /api/v1/customers/"+alias, err)
//	}
//
// The SDK returns a *meteroid.APIError for every non-2xx answer, and its StatusCode is
// what separates "your API key is wrong" (an operator problem) from "Meteroid is
// throttling" (retry) from everything else. When the body parsed as Meteroid's error
// envelope, Payload carries the typed code and message. Anything that is *not* an
// APIError never got an HTTP answer at all: a refused connection, a timeout, or a 2xx
// body the SDK could not decode.
func upstream(context string, err error) error {
	var already *apiError
	if errors.As(err, &already) {
		return already
	}

	var apiErr *meteroid.APIError
	if !errors.As(err, &apiErr) {
		return newAPIError(codeUpstreamError, "Could not reach Meteroid for %s: %v", context, err)
	}

	switch status := apiErr.StatusCode; status {
	case http.StatusUnauthorized, http.StatusForbidden:
		return newAPIError(codeUpstreamUnauthorized,
			"Meteroid rejected the API key on %s (HTTP %d). Check METEROID_API_KEY.", context, status)
	case http.StatusTooManyRequests:
		return newAPIError(codeRateLimited, "Meteroid responded 429 to %s. Retry shortly.", context)
	default:
		detail := string(apiErr.RawBody)
		switch {
		case apiErr.Payload != nil:
			detail = fmt.Sprintf("%s: %s", apiErr.Payload.Code, apiErr.Payload.Message)
		case apiErr.OAuthPayload != nil:
			description := ""
			if apiErr.OAuthPayload.ErrorDescription != nil {
				description = *apiErr.OAuthPayload.ErrorDescription
			}
			detail = fmt.Sprintf("%s: %s", apiErr.OAuthPayload.Error, description)
		}
		return newAPIError(codeUpstreamError, "Meteroid responded %d to %s: %s", status, context, truncate(detail))
	}
}

// isNotFound is true when the SDK error is an upstream 404 — "this object does not
// exist", which for a catalog lookup means "not seeded" rather than "Meteroid is broken".
func isNotFound(err error) bool {
	var apiErr *meteroid.APIError
	return errors.As(err, &apiErr) && apiErr.StatusCode == http.StatusNotFound
}

func truncate(body string) string {
	const limit = 300
	// Runes, not bytes: cutting a multi-byte character in half would not be JSON-safe.
	if runes := []rune(body); len(runes) > limit {
		return string(runes[:limit]) + "…"
	}
	return body
}

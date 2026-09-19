package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"math/big"
	"slices"
	"strings"
	"time"
	"unicode/utf8"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// The wire types of examples/openapi.yaml, one struct per schema.
//
// Two rules from the contract are enforced here by construction:
//
//   - Decimals are strings. Every Meteroid `format: decimal` value is a string produced
//     by normalizeDecimal, never a JSON number — there is no float64 in this file.
//   - Nullable means present-and-null. No response field carries `omitempty`, so a nil
//     pointer is written as `null` rather than dropped, and every list is a
//     meteroid.RequiredSlice, the SDK's own answer to encoding/json writing a nil slice
//     as `null`: it marshals as `[]`. A strict deserializer on the other side never has
//     to distinguish "absent" from "null".
//
// Request bodies are the opposite by design (absent and null are equivalent) and are
// decoded by hand at the bottom of this file.

// ---------------------------------------------------------------- shared

// PlanCode is the stable identifier of a Scribe plan.
type PlanCode string

const (
	planFree  PlanCode = "free"
	planPro   PlanCode = "pro"
	planScale PlanCode = "scale"
)

// planCodes is cheapest first, matching the order GET /api/plans promises.
var planCodes = []PlanCode{planFree, planPro, planScale}

// meteroidPlanName is the exact Meteroid plan **name** each code maps onto. Meteroid
// plans have no user-supplied code, so the seeded name is the lookup key — see
// examples/CATALOG.md.
var meteroidPlanName = map[PlanCode]string{
	planFree:  "Scribe Free",
	planPro:   "Scribe Pro",
	planScale: "Scribe Scale",
}

// nextUp is the plan to offer as an upgrade when this one runs out of quota; nil on
// the top plan, where there is nothing left to sell.
func (c PlanCode) nextUp() *PlanCode {
	switch c {
	case planFree:
		return ptr(planPro)
	case planPro:
		return ptr(planScale)
	default:
		return nil
	}
}

func ptr[T any](value T) *T { return &value }

// ---------------------------------------------------------------- ops

type Health struct {
	Status             string  `json:"status"`
	Backend            string  `json:"backend"`
	MeteroidConfigured bool    `json:"meteroid_configured"`
	Version            *string `json:"version"`
}

// ---------------------------------------------------------------- session

type CreateSessionRequest struct {
	WorkspaceName *string
	Email         *string
}

type Workspace struct {
	ID            string `json:"id"`
	Name          string `json:"name"`
	CustomerID    string `json:"customer_id"`
	CustomerAlias string `json:"customer_alias"`
	Currency      string `json:"currency"`
}

type CreateSessionResponse struct {
	SessionToken string    `json:"session_token"`
	Workspace    Workspace `json:"workspace"`
}

type Subscription struct {
	ID                 string    `json:"id"`
	Status             string    `json:"status"`
	PlanCode           *PlanCode `json:"plan_code"`
	PlanName           string    `json:"plan_name"`
	PlanVersionID      string    `json:"plan_version_id"`
	Currency           string    `json:"currency"`
	CurrentPeriodStart string    `json:"current_period_start"`
	CurrentPeriodEnd   *string   `json:"current_period_end"`
	TrialDurationDays  *int32    `json:"trial_duration_days"`
	CreatedAt          string    `json:"created_at"`
}

type MeResponse struct {
	Workspace    Workspace     `json:"workspace"`
	Subscription *Subscription `json:"subscription"`
	Plan         *Plan         `json:"plan"`
}

// ---------------------------------------------------------------- catalog

type PlanPrice struct {
	ComponentID    string  `json:"component_id"`
	Name           string  `json:"name"`
	Kind           string  `json:"kind"`
	Cadence        *string `json:"cadence"`
	Amount         *string `json:"amount"`
	UnitAmount     *string `json:"unit_amount"`
	IncludedAmount *string `json:"included_amount"`
	UnitName       *string `json:"unit_name"`
	PricingModel   *string `json:"pricing_model"`
}

type PlanFeatureLine struct {
	FeatureCode string `json:"feature_code"`
	Label       string `json:"label"`
}

type Plan struct {
	Code          PlanCode                                `json:"code"`
	Name          string                                  `json:"name"`
	Description   *string                                 `json:"description"`
	PlanID        string                                  `json:"plan_id"`
	PlanVersionID string                                  `json:"plan_version_id"`
	Version       int32                                   `json:"version"`
	Currency      string                                  `json:"currency"`
	IsFree        bool                                    `json:"is_free"`
	TrialDays     *int32                                  `json:"trial_days"`
	Prices        meteroid.RequiredSlice[PlanPrice]       `json:"prices"`
	Features      meteroid.RequiredSlice[PlanFeatureLine] `json:"features"`
}

type PlanListResponse struct {
	Plans meteroid.RequiredSlice[Plan] `json:"plans"`
}

// ---------------------------------------------------------------- checkout

type CreateCheckoutRequest struct {
	PlanCode   PlanCode
	CouponCode *string
}

type CreateCheckoutResponse struct {
	CheckoutURL       string   `json:"checkout_url"`
	CheckoutSessionID string   `json:"checkout_session_id"`
	PlanCode          PlanCode `json:"plan_code"`
	PlanVersionID     string   `json:"plan_version_id"`
	ExpiresAt         *string  `json:"expires_at"`
}

// ----------------------------------------------------------- entitlements

type ResetPeriod struct {
	Type     string  `json:"type"`
	Interval *int32  `json:"interval"`
	Unit     *string `json:"unit"`
}

type QuotaSnapshot struct {
	FeatureCode string  `json:"feature_code"`
	Enabled     bool    `json:"enabled"`
	Limit       *string `json:"limit"`
	Consumed    *string `json:"consumed"`
	Remaining   *string `json:"remaining"`
	ResetAt     *string `json:"reset_at"`
	Unlimited   bool    `json:"unlimited"`
}

// ConfigValue is a typed configuration value, tagged by Kind. Value is a decimal
// string for NUMBER, a bool for BOOLEAN, a string for TEXT and any JSON for JSON.
type ConfigValue struct {
	Kind  string `json:"kind"`
	Value any    `json:"value"`
}

// The three-way entitlement union, tagged by Type exactly as Meteroid tags it.
// Entitlement.Value holds exactly one of these.

type BooleanEntitlementValue struct {
	Type    string `json:"type"`
	Enabled bool   `json:"enabled"`
}

type MeteredEntitlementValue struct {
	Type        string      `json:"type"`
	Enabled     bool        `json:"enabled"`
	Limit       *string     `json:"limit"`
	Consumed    *string     `json:"consumed"`
	Remaining   *string     `json:"remaining"`
	Unlimited   bool        `json:"unlimited"`
	ResetAt     *string     `json:"reset_at"`
	ResetPeriod ResetPeriod `json:"reset_period"`
	MetricCode  *string     `json:"metric_code"`
}

type ConfigEntitlementValue struct {
	Type  string      `json:"type"`
	Value ConfigValue `json:"value"`
}

type Entitlement struct {
	FeatureCode string `json:"feature_code"`
	FeatureName string `json:"feature_name"`
	// One of BooleanEntitlementValue, MeteredEntitlementValue, ConfigEntitlementValue.
	Value any `json:"value"`
}

type EntitlementListResponse struct {
	Entitlements meteroid.RequiredSlice[Entitlement] `json:"entitlements"`
}

// ----------------------------------------------------------- transcription

type CreateTranscriptionRequest struct {
	Title           string
	DurationSeconds int32
}

type Transcription struct {
	ID              string `json:"id"`
	Title           string `json:"title"`
	DurationSeconds int32  `json:"duration_seconds"`
	MinutesBilled   string `json:"minutes_billed"`
	Text            string `json:"text"`
	CreatedAt       string `json:"created_at"`
	EventID         string `json:"event_id"`
}

type CreateTranscriptionResponse struct {
	Transcription Transcription `json:"transcription"`
	Quota         QuotaSnapshot `json:"quota"`
}

type TranscriptionListResponse struct {
	Transcriptions meteroid.RequiredSlice[Transcription] `json:"transcriptions"`
}

// ---------------------------------------------------------------- usage

type GroupedUsage struct {
	Dimensions meteroid.RequiredMap[string] `json:"dimensions"`
	Value      string                       `json:"value"`
}

type MetricUsage struct {
	MetricCode   string                               `json:"metric_code"`
	MetricName   string                               `json:"metric_name"`
	TotalValue   string                               `json:"total_value"`
	GroupedUsage meteroid.RequiredSlice[GroupedUsage] `json:"grouped_usage"`
}

type UsageResponse struct {
	PeriodStart string                              `json:"period_start"`
	PeriodEnd   string                              `json:"period_end"`
	Scope       string                              `json:"scope"`
	Metrics     meteroid.RequiredSlice[MetricUsage] `json:"metrics"`
}

// ---------------------------------------------------------------- portal

type CreatePortalSessionRequest struct {
	ExpiresInSeconds *int32
}

type CreatePortalSessionResponse struct {
	PortalURL        string `json:"portal_url"`
	Token            string `json:"token"`
	ExpiresInSeconds int32  `json:"expires_in_seconds"`
}

// ---------------------------------------------------------------- invoices

type Invoice struct {
	ID            string  `json:"id"`
	InvoiceNumber string  `json:"invoice_number"`
	Status        string  `json:"status"`
	Currency      string  `json:"currency"`
	InvoiceDate   string  `json:"invoice_date"`
	DueDate       *string `json:"due_date"`
	// Minor units. Meteroid models invoice money as an integer, not a decimal.
	Total     int64 `json:"total"`
	AmountDue int64 `json:"amount_due"`
}

type InvoiceListResponse struct {
	Invoices meteroid.RequiredSlice[Invoice] `json:"invoices"`
}

// ---------------------------------------------------------------- webhooks

type WebhookAck struct {
	Received bool    `json:"received"`
	EventID  string  `json:"event_id"`
	Type     *string `json:"type"`
	Handled  bool    `json:"handled"`
}

// ------------------------------------------------------------ timestamps

// timestamp renders an SDK time.Time as RFC 3339. The SDK parses every `format:
// date-time` field, keeping Meteroid's own offset and sub-second digits, so this gives
// back the instant as Meteroid wrote it (minus trailing fractional zeros).
func timestamp(value time.Time) string {
	return value.Format(time.RFC3339Nano)
}

func timestampOpt(value *time.Time) *string {
	if value == nil {
		return nil
	}
	return ptr(timestamp(*value))
}

// ------------------------------------------------------- request decoding
//
// Why not a struct, `json` tags and Decoder.DisallowUnknownFields? Because that is not
// as strict as it looks, and the contract is: encoding/json matches object keys
// case-insensitively (`{"TITLE": …}` would fill `title`), treats `null` for a
// non-pointer field as a silent no-op (`{"title": null}` would pass as ""), and refuses
// `60.0` for an integer although JSON Schema calls that a valid `type: integer`. So the
// body is decoded into untyped JSON — keys verbatim, numbers kept as their literal text
// — and checked field by field against the schema, exactly as the TypeScript backend
// does it. No coercion, no unknown keys, integers are integers.

func decodeCreateSessionRequest(value any) (CreateSessionRequest, error) {
	body, err := strictObject(value, "CreateSessionRequest", "workspace_name", "email")
	if err != nil {
		return CreateSessionRequest{}, err
	}
	var request CreateSessionRequest
	if request.WorkspaceName, err = optionalString(body, "workspace_name"); err != nil {
		return CreateSessionRequest{}, err
	}
	if request.Email, err = optionalString(body, "email"); err != nil {
		return CreateSessionRequest{}, err
	}
	return request, nil
}

func decodeCreateCheckoutRequest(value any) (CreateCheckoutRequest, error) {
	body, err := strictObject(value, "CreateCheckoutRequest", "plan_code", "coupon_code")
	if err != nil {
		return CreateCheckoutRequest{}, err
	}
	planCode, err := requiredString(body, "plan_code")
	if err != nil {
		return CreateCheckoutRequest{}, err
	}
	if !slices.Contains(planCodes, PlanCode(planCode)) {
		return CreateCheckoutRequest{}, invalidBody("unknown plan_code %q, expected one of free, pro, scale", planCode)
	}
	couponCode, err := optionalString(body, "coupon_code")
	if err != nil {
		return CreateCheckoutRequest{}, err
	}
	return CreateCheckoutRequest{PlanCode: PlanCode(planCode), CouponCode: couponCode}, nil
}

func decodeCreateTranscriptionRequest(value any) (CreateTranscriptionRequest, error) {
	body, err := strictObject(value, "CreateTranscriptionRequest", "title", "duration_seconds")
	if err != nil {
		return CreateTranscriptionRequest{}, err
	}
	title, err := requiredString(body, "title")
	if err != nil {
		return CreateTranscriptionRequest{}, err
	}
	durationSeconds, err := requiredInt32(body, "duration_seconds")
	if err != nil {
		return CreateTranscriptionRequest{}, err
	}
	return CreateTranscriptionRequest{Title: title, DurationSeconds: durationSeconds}, nil
}

func decodeCreatePortalSessionRequest(value any) (CreatePortalSessionRequest, error) {
	body, err := strictObject(value, "CreatePortalSessionRequest", "expires_in_seconds")
	if err != nil {
		return CreatePortalSessionRequest{}, err
	}
	if body["expires_in_seconds"] == nil {
		return CreatePortalSessionRequest{}, nil
	}
	expiresInSeconds, err := requiredInt32(body, "expires_in_seconds")
	if err != nil {
		return CreatePortalSessionRequest{}, err
	}
	return CreatePortalSessionRequest{ExpiresInSeconds: &expiresInSeconds}, nil
}

// parseJSON reads exactly one JSON value. Numbers stay json.Number — their literal
// text — so nothing is rounded through a float64 on the way in.
func parseJSON(body []byte) (any, error) {
	// encoding/json would quietly turn invalid UTF-8 into U+FFFD.
	if !utf8.Valid(body) {
		return nil, invalidBody("the request body is not valid UTF-8")
	}
	decoder := json.NewDecoder(bytes.NewReader(body))
	decoder.UseNumber()

	var value any
	if err := decoder.Decode(&value); err != nil {
		if err == io.EOF {
			return nil, invalidBody("unexpected end of JSON input")
		}
		return nil, invalidBody("%v", err)
	}
	// A Decoder reads a *stream* of values, so `{} trailing` needs refusing by hand.
	if _, err := decoder.Token(); err != io.EOF {
		return nil, invalidBody("unexpected data after the JSON value")
	}
	return value, nil
}

func invalidBody(format string, args ...any) *apiError {
	return badRequest("Invalid body: "+format, args...)
}

// strictObject is `additionalProperties: false`: a JSON object, and no key the schema
// does not list.
func strictObject(value any, schema string, allowed ...string) (map[string]any, error) {
	body, ok := value.(map[string]any)
	if !ok {
		return nil, invalidBody("expected a %s object, got %s", schema, kindOf(value))
	}
	for key := range body {
		if !slices.Contains(allowed, key) {
			return nil, invalidBody("unknown field `%s`, expected `%s`", key, strings.Join(allowed, "` or `"))
		}
	}
	return body, nil
}

func requiredString(body map[string]any, key string) (string, error) {
	value, present := body[key]
	if !present {
		return "", invalidBody("missing field `%s`", key)
	}
	// No coercion: `{"title": 123}` is a type error, not the string "123".
	text, ok := value.(string)
	if !ok {
		return "", invalidBody("%s: expected a string, got %s", key, kindOf(value))
	}
	return text, nil
}

func optionalString(body map[string]any, key string) (*string, error) {
	if body[key] == nil {
		return nil, nil
	}
	text, err := requiredString(body, key)
	if err != nil {
		return nil, err
	}
	return &text, nil
}

// requiredInt32: the contract types its integers `format: int32`, so the range is part
// of the type. `60.0` and `6e1` are integers — JSON Schema says so — and big.Rat
// decides that exactly, where a float64 would also wave `60.00000000000000001` through.
func requiredInt32(body map[string]any, key string) (int32, error) {
	value, present := body[key]
	if !present {
		return 0, invalidBody("missing field `%s`", key)
	}
	if number, ok := value.(json.Number); ok {
		if exact, ok := new(big.Rat).SetString(number.String()); ok && exact.IsInt() {
			if n := exact.Num(); n.IsInt64() && n.Int64() >= -2_147_483_647 && n.Int64() <= 2_147_483_647 {
				return int32(n.Int64()), nil
			}
		}
	}
	return 0, invalidBody("%s: expected a 32-bit integer, got %s", key, kindOf(value))
}

func kindOf(value any) string {
	switch value := value.(type) {
	case nil:
		return "null"
	case []any:
		return "an array"
	case map[string]any:
		return "an object"
	case string:
		return fmt.Sprintf("string `%s`", value)
	case json.Number:
		return fmt.Sprintf("number `%s`", value)
	default:
		return fmt.Sprintf("boolean `%v`", value)
	}
}

package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"errors"
	"testing"
	"time"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// The pure pieces: session tokens, configuration, decimals, quota arithmetic, labels,
// wire shapes.

// ---------------------------------------------------------------- session tokens

func TestSessionTokenRoundTripsAnAlias(t *testing.T) {
	for _, alias := range []string{"scribe-demo-8f2a1c", "café-☕-工作区"} {
		got, err := verifyToken("s3cret", mintToken("s3cret", alias))
		if err != nil || got != alias {
			t.Errorf("verifyToken(mintToken(%q)) = %q, %v", alias, got, err)
		}
	}
}

func TestSessionTokenIsTheConstructionTheContractDocuments(t *testing.T) {
	// Spelled out independently of session.go, the way tests/contract/src/session.ts does
	// it, and pinned to the same literal the TypeScript backend's tests pin: tokens
	// minted by one backend must verify on another.
	alias := "scribe-demo-8f2a1c"
	mac := hmac.New(sha256.New, []byte("s3cret"))
	mac.Write([]byte(alias))
	expected := "v1." + base64.RawURLEncoding.EncodeToString([]byte(alias)) + "." + base64.RawURLEncoding.EncodeToString(mac.Sum(nil))

	if got := mintToken("s3cret", alias); got != expected {
		t.Errorf("mintToken = %s, want %s", got, expected)
	}
	if expected != "v1.c2NyaWJlLWRlbW8tOGYyYTFj.r50D_RuGiV8vaYqwra8Kvs1fDBE7cJ3EV1jYTRWQXiY" {
		t.Errorf("the documented construction changed: %s", expected)
	}
}

func TestAnotherDeploymentsSecretIsRejected(t *testing.T) {
	if _, err := verifyToken("other", mintToken("s3cret", "scribe-demo-8f2a1c")); err == nil {
		t.Error("a token signed with another secret verified")
	}
}

func TestTamperedPayloadIsRejected(t *testing.T) {
	token := mintToken("s3cret", "scribe-demo-8f2a1c")
	signature := token[len(token)-43:]
	forged := "v1." + base64.RawURLEncoding.EncodeToString([]byte("someone-else")) + "." + signature
	if _, err := verifyToken("s3cret", forged); err == nil {
		t.Error("a tampered payload verified")
	}
}

func TestStructurallyInvalidTokenIsRejectedNeverPartiallyDecoded(t *testing.T) {
	token := mintToken("s3cret", "alias")
	bad := []string{
		"", "garbage", "v1.only", "v2.YQ.YQ", token + ".extra", token + "=", "v1.!!!.abc", "v1.YQ.*",
		// Go's base64 decoder skips newlines, and outside Strict mode ignores trailing
		// bits: "YR" decodes to the same byte as "YQ".
		"v1.Y\nQ." + token[len(token)-43:], "v1.YR." + token[len(token)-43:],
		// Not UTF-8.
		"v1._w." + base64.RawURLEncoding.EncodeToString(sign("s3cret", "\xff")),
	}
	for _, candidate := range bad {
		_, err := verifyToken("s3cret", candidate)
		var apiErr *apiError
		if !errors.As(err, &apiErr) || apiErr.Code != codeUnauthorized {
			t.Errorf("verifyToken(%q) = %v, want UNAUTHORIZED", candidate, err)
		}
	}
}

// ---------------------------------------------------------------- configuration

func env(values map[string]string) func(string) string {
	return func(key string) string { return values[key] }
}

func TestSessionSecretHasNoDefault(t *testing.T) {
	for _, values := range []map[string]string{{}, {"SCRIBE_SESSION_SECRET": "   "}} {
		if _, err := configFromEnv(env(values)); err == nil {
			t.Errorf("configFromEnv(%v) started without a session secret", values)
		}
	}
}

func TestOnlyTheSessionSecretIsRequired(t *testing.T) {
	config, err := configFromEnv(env(map[string]string{"SCRIBE_SESSION_SECRET": "s"}))
	if err != nil {
		t.Fatal(err)
	}
	if config.meteroidConfigured() || config.meteroidWebhookSecret != "" {
		t.Errorf("config = %+v", config)
	}
	if config.meteroidBaseURL != "https://api.meteroid.com" {
		t.Errorf("meteroidBaseURL = %q", config.meteroidBaseURL)
	}
}

func TestPortWinsOverScribePort(t *testing.T) {
	port := func(values map[string]string) (int, error) {
		values["SCRIBE_SESSION_SECRET"] = "s"
		config, err := configFromEnv(env(values))
		return config.port, err
	}

	if got, _ := port(map[string]string{}); got != 8084 {
		t.Errorf("default port = %d", got)
	}
	if got, _ := port(map[string]string{"SCRIBE_PORT": "9001"}); got != 9001 {
		t.Errorf("SCRIBE_PORT: port = %d", got)
	}
	if got, _ := port(map[string]string{"SCRIBE_PORT": "9001", "PORT": "9002"}); got != 9002 {
		t.Errorf("PORT did not win: port = %d", got)
	}
	for _, bad := range []string{"http", "70000", "0", "+80", "8e3"} {
		if _, err := port(map[string]string{"PORT": bad}); err == nil {
			t.Errorf("PORT=%s was accepted", bad)
		}
	}
}

func TestCurrencyMustBeOneMeteroidKnows(t *testing.T) {
	currency := func(code string) (meteroid.Currency, error) {
		config, err := configFromEnv(env(map[string]string{"SCRIBE_SESSION_SECRET": "s", "SCRIBE_DEFAULT_CURRENCY": code}))
		return config.defaultCurrency, err
	}

	if got, _ := currency(""); got != meteroid.CurrencyUsd {
		t.Errorf("default currency = %q", got)
	}
	if got, _ := currency("eur"); got != meteroid.CurrencyEur {
		t.Errorf("eur = %q", got)
	}
	if _, err := currency("XYZ1"); err == nil {
		t.Error("XYZ1 was accepted")
	}
}

// ---------------------------------------------------------------- decimals

func TestBillableMinutesRoundUpToTwoDecimals(t *testing.T) {
	// 100/60 = 1.666… must never round down: the demo bills what it used.
	cases := map[int32]string{60: "1", 210: "3.5", 100: "1.67", 1: "0.02", 7200: "120"}
	for seconds, want := range cases {
		if got := billableMinutes(seconds); got != want {
			t.Errorf("billableMinutes(%d) = %s, want %s", seconds, got, want)
		}
	}
}

func TestDecimalArithmeticIsExactAndRendersWithoutTrailingZeros(t *testing.T) {
	must := func(value string, err error) string {
		t.Helper()
		if err != nil {
			t.Fatal(err)
		}
		return value
	}
	cases := []struct{ got, want string }{
		{must(normalizeDecimal("3.50")), "3.5"},
		{must(normalizeDecimal("600.000")), "600"},
		{must(normalizeDecimal("-0.0")), "0"},
		{must(normalizeDecimal("0.05")), "0.05"},
		{must(normalizeDecimal("007")), "7"},
		// The classic: 0.1 + 0.2 in binary floating point is 0.30000000000000004.
		{must(addDecimal("0.1", "0.2")), "0.3"},
		{must(subtractDecimal("60", "56.5")), "3.5"},
		{must(subtractDecimal("1", "1.05")), "-0.05"},
		// Beyond what a float64 can hold exactly.
		{must(addDecimal("9007199254740993", "0.0000000001")), "9007199254740993.0000000001"},
	}
	for _, c := range cases {
		if c.got != c.want {
			t.Errorf("got %s, want %s", c.got, c.want)
		}
	}

	if greater, _ := decimalGreaterThan("3.51", "3.5"); !greater {
		t.Error("3.51 > 3.5")
	}
	if greater, _ := decimalGreaterThan("3.50", "3.5"); greater {
		t.Error("3.50 is not greater than 3.5")
	}
}

func TestValueThatIsNotAnExactDecimalIsMeteroidsError(t *testing.T) {
	for _, bad := range []string{"1e3", "", "NaN", ".5", "1.", "1.5\n", "١٢"} {
		_, err := normalizeDecimal(bad)
		var apiErr *apiError
		if !errors.As(err, &apiErr) || apiErr.Code != codeUpstreamError {
			t.Errorf("normalizeDecimal(%q) = %v, want UPSTREAM_ERROR", bad, err)
		}
	}
}

// ---------------------------------------------------------------- quota

func metered(limit, consumed, remaining *string) *meteroid.MeteredEffectiveEntitlementValue {
	return &meteroid.MeteredEffectiveEntitlementValue{
		Spec: meteroid.MeteredEntitlementSpec{
			Enabled:     true,
			Limit:       limit,
			MetricId:    "met_1",
			ResetPeriod: meteroid.NewResetPeriodBillingCycle(meteroid.BillingCycleResetPeriod{}),
		},
		Usage: meteroid.MeteredEntitlementUsage{Consumed: consumed, Remaining: remaining},
	}
}

func TestMeteroidsRemainingIsUsedWhenItHasOne(t *testing.T) {
	quota, err := quotaSnapshot("transcription_minutes", metered(ptr("60"), ptr("15"), ptr("45.0")))
	if err != nil {
		t.Fatal(err)
	}
	if *quota.Remaining != "45" || quota.Unlimited {
		t.Errorf("quota = %+v", quota)
	}
}

func TestRemainingIsDerivedWhenMeteroidHasNoCounter(t *testing.T) {
	quota, _ := quotaSnapshot("transcription_minutes", metered(ptr("60"), ptr("15"), nil))
	if *quota.Remaining != "45" {
		t.Errorf("limit - consumed = %s", *quota.Remaining)
	}
	quota, _ = quotaSnapshot("transcription_minutes", metered(ptr("60"), nil, nil))
	if *quota.Remaining != "60" {
		t.Errorf("limit alone = %s", *quota.Remaining)
	}
}

func TestAbsentLimitIsUnlimitedAndEveryKeyIsStillThere(t *testing.T) {
	quota, err := quotaSnapshot("transcription_minutes", metered(nil, ptr("900"), nil))
	if err != nil {
		t.Fatal(err)
	}
	assertJSON(t, quota, `{
		"feature_code": "transcription_minutes", "enabled": true, "limit": null, "consumed": "900",
		"remaining": null, "reset_at": null, "unlimited": true
	}`)
}

var testQuota = QuotaSnapshot{
	FeatureCode: "transcription_minutes",
	Enabled:     true,
	Limit:       ptr("60"),
	Consumed:    ptr("56.5"),
	Remaining:   ptr("3.5"),
}

func TestQuotaIsProjectedForwardByWhatWasBilled(t *testing.T) {
	projected, err := projectQuota(testQuota, billableMinutes(60))
	if err != nil {
		t.Fatal(err)
	}
	if *projected.Consumed != "57.5" || *projected.Remaining != "2.5" {
		t.Errorf("projected = %s consumed, %s remaining", *projected.Consumed, *projected.Remaining)
	}
	// The snapshot it was projected from is the one a 402 would have carried.
	if *testQuota.Consumed != "56.5" || *testQuota.Remaining != "3.5" {
		t.Error("projectQuota modified its input")
	}
}

func TestUnlimitedQuotaStaysUnlimited(t *testing.T) {
	unlimited := QuotaSnapshot{FeatureCode: "transcription_minutes", Enabled: true, Unlimited: true}
	projected, _ := projectQuota(unlimited, billableMinutes(120))

	if !projected.Unlimited || projected.Limit != nil || projected.Remaining != nil || *projected.Consumed != "2" {
		t.Errorf("projected = %+v", projected)
	}
}

// ---------------------------------------------------------------- labels

func TestFeatureLabels(t *testing.T) {
	meteredValue := func(limit *string, period meteroid.ResetPeriod) meteroid.ResolvedEntitlementValue {
		return meteroid.NewResolvedEntitlementValueMetered(meteroid.MeteredResolvedEntitlementValue{
			Enabled: true, Limit: limit, MetricId: "met_1", ResetPeriod: period,
		})
	}
	billingCycle := meteroid.NewResetPeriodBillingCycle(meteroid.BillingCycleResetPeriod{})
	number := meteroid.NewConfigValueNumber(meteroid.NumberConfigValue{Value: "90"})

	cases := []struct {
		name  string
		value meteroid.ResolvedEntitlementValue
		want  string
	}{
		{"Transcription minutes", meteredValue(ptr("600.00"), billingCycle), "600 transcription minutes per billing cycle"},
		{"Transcription minutes", meteredValue(nil, billingCycle), "Unlimited transcription minutes"},
		{
			"API calls",
			meteredValue(ptr("5"), meteroid.NewResetPeriodSlidingWindow(meteroid.SlidingWindowResetPeriod{Interval: 2, Unit: "HOUR"})),
			"5 aPI calls per rolling 2 hours",
		},
		{"SSO", meteroid.NewResolvedEntitlementValueBoolean(meteroid.BooleanResolvedEntitlementValue{Enabled: true}), "SSO included"},
		{"SSO", meteroid.NewResolvedEntitlementValueBoolean(meteroid.BooleanResolvedEntitlementValue{}), "SSO not included"},
		{"Retention days", meteroid.NewResolvedEntitlementValueConfig(meteroid.ConfigResolvedEntitlementValue{Value: number}), "90 retention days"},
	}
	for _, c := range cases {
		got, err := featureLabel(c.name, c.value)
		if err != nil || got != c.want {
			t.Errorf("featureLabel(%q) = %q, %v; want %q", c.name, got, err, c.want)
		}
	}

	// A variant the SDK decoded without knowing it is reported, never guessed at.
	if _, err := featureLabel("Mystery", meteroid.ResolvedEntitlementValue{Type: "TIERED"}); err == nil {
		t.Error("an unknown entitlement type was labelled")
	}
}

// ---------------------------------------------------------------- wire shapes

func TestNullableResponseFieldsAreSerializedAsNullNotOmitted(t *testing.T) {
	// Every optional SDK field absent. The shape must not change.
	subscription := &meteroid.Subscription{
		CreatedAt:          time.Date(2026, 9, 1, 12, 0, 0, 0, time.UTC),
		Currency:           meteroid.CurrencyUsd,
		CurrentPeriodStart: "2026-09-01",
		Id:                 "sub_1",
		PlanId:             "plan_9",
		PlanName:           "Something bespoke",
		PlanVersionId:      "pv_9",
		Status:             meteroid.SubscriptionStatusEnumPendingActivation,
	}
	assertJSON(t, projectSubscription(subscription, nil), `{
		"id": "sub_1", "status": "PENDING_ACTIVATION", "plan_code": null,
		"plan_name": "Something bespoke", "plan_version_id": "pv_9", "currency": "USD",
		"current_period_start": "2026-09-01", "current_period_end": null,
		"trial_duration_days": null, "created_at": "2026-09-01T12:00:00Z"
	}`)

	assertJSON(t, internalError("boom"), `{"code":"INTERNAL","message":"boom","quota":null,"upgrade_plan_code":null}`)
}

func TestEmptyListsAreSerializedAsArraysNotNull(t *testing.T) {
	// encoding/json writes a nil slice as `null`; the contract says `type: array`.
	assertJSON(t, TranscriptionListResponse{}, `{"transcriptions":[]}`)
	assertJSON(t, PlanListResponse{}, `{"plans":[]}`)
	assertJSON(t, InvoiceListResponse{}, `{"invoices":[]}`)
	assertJSON(t, EntitlementListResponse{}, `{"entitlements":[]}`)
	assertJSON(t, MetricUsage{TotalValue: "0"}, `{"metric_code":"","metric_name":"","total_value":"0","grouped_usage":[]}`)
	assertJSON(t, GroupedUsage{Value: "0"}, `{"dimensions":{},"value":"0"}`)
}

func TestTimestampsKeepMeteroidsOffsetAndPrecision(t *testing.T) {
	for _, wire := range []string{"2026-10-01T00:00:00Z", "2026-10-01T02:00:00.123456+02:00"} {
		parsed, err := time.Parse(time.RFC3339Nano, wire)
		if err != nil {
			t.Fatal(err)
		}
		if got := timestamp(parsed); got != wire {
			t.Errorf("timestamp = %s, want %s", got, wire)
		}
	}
}

func TestTranscriptionHistoryIsNewestFirstPerWorkspace(t *testing.T) {
	store := &transcriptionStore{}
	store.record("a", Transcription{ID: "tr_1"})
	store.record("a", Transcription{ID: "tr_2"})
	store.record("b", Transcription{ID: "tr_3"})

	history := store.list("a")
	if len(history) != 2 || history[0].ID != "tr_2" || history[1].ID != "tr_1" {
		t.Errorf("history = %+v", history)
	}
	if len(store.list("nobody")) != 0 {
		t.Error("an unknown workspace has history")
	}
}

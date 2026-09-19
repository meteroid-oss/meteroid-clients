package main

import (
	"encoding/json"
	"fmt"
	"regexp"
	"testing"
)

// The Meteroid-backed handlers, against a stubbed Meteroid.
//
// There is no tenant to run these against, but the SDK takes a custom http.Client, so
// the wire JSON below goes through the SDK's real decoders and the handlers' real
// projections. What this pins down is the part of the contract that matters most and
// that nothing else can reach offline: the 201 / 402 / 403 / 503 split of the metered
// action, and that a refused request reports **no** usage.

const (
	testAlias        = "scribe-demo-1"
	entitlementsCall = "GET /api/v1/customers/" + testAlias + "/entitlements"
	ingestCall       = "POST /api/v1/events/ingest"
	subscriptionCall = "GET /api/v1/subscriptions"
)

// wire is hand-written Meteroid JSON, decoded so a stub can re-serialize it.
func wire(t *testing.T, document string) stub {
	t.Helper()
	var value any
	if err := json.Unmarshal([]byte(document), &value); err != nil {
		t.Fatalf("bad fixture: %v\n%s", err, document)
	}
	return static(value)
}

// meteredEntitlement is a metered transcription_minutes entitlement plus a config one.
// limit and usage are JSON fragments: `"60"` or `null`, and the usage object.
func meteredEntitlement(t *testing.T, limit, usage string, enabled bool) stub {
	return wire(t, fmt.Sprintf(`{"data": [
		{
			"feature": {"id": "feat_1", "code": "transcription_minutes", "name": "Transcription minutes"},
			"value": {
				"type": "METERED",
				"spec": {"enabled": %t, "limit": %s, "metric_id": "met_1",
				         "reset_period": {"type": "CALENDAR", "interval": 1, "unit": "MONTH"}},
				"usage": %s
			}
		},
		{
			"feature": {"id": "feat_2", "code": "retention_days", "name": "Retention days"},
			"value": {"type": "CONFIG", "value": {"kind": "NUMBER", "value": "90.0"}}
		}
	]}`, enabled, limit, usage))
}

func noSubscriptions(t *testing.T) stub {
	return wire(t, `{"data": [], "pagination_meta": {"page": 0, "per_page": 100, "total_items": 0, "total_pages": 1}}`)
}

func transcribe(t *testing.T, fake *fakeMeteroid, durationSeconds int) testResponse {
	t.Helper()
	return send(t, "POST", "/api/transcriptions", sendOptions{
		headers:  bearer(testAlias),
		body:     fmt.Sprintf(`{"title": " Weekly standup ", "duration_seconds": %d}`, durationSeconds),
		meteroid: fake,
	})
}

func TestTranscriptionWithinQuotaIsBilledReportedAndProjected(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `"60"`, `{"consumed": "56.50", "remaining": "3.50"}`, true),
		ingestCall:       wire(t, `{}`),
	})
	response := transcribe(t, fake, 210)

	if response.status != 201 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	if got := fmt.Sprint(fake.calls); got != fmt.Sprint([]string{entitlementsCall, ingestCall}) {
		t.Errorf("Meteroid calls = %s", got)
	}

	transcription := response.body["transcription"].(map[string]any)
	id, createdAt := transcription["id"].(string), transcription["created_at"].(string)
	if !regexp.MustCompile(`^tr_[0-9a-f]{32}$`).MatchString(id) {
		t.Errorf("id = %s", id)
	}
	if !regexp.MustCompile(`^\d{4}-\d\d-\d\dT\d\d:\d\d:\d\dZ$`).MatchString(createdAt) {
		t.Errorf("created_at = %s", createdAt)
	}
	if transcription["title"] != "Weekly standup" || transcription["minutes_billed"] != "3.5" || transcription["event_id"] != id {
		t.Errorf("transcription = %v", transcription)
	}
	assertJSON(t, response.body["quota"], `{
		"feature_code": "transcription_minutes", "enabled": true, "limit": "60", "consumed": "60",
		"remaining": "0", "reset_at": null, "unlimited": false
	}`)

	// The event Meteroid received: the alias as customer, the minutes as a decimal string.
	assertJSON(t, json.RawMessage(fake.bodies[1]), fmt.Sprintf(`{"events": [{
		"code": "transcription_minutes", "customer_id": %q, "event_id": %q,
		"properties": {"minutes": "3.5"}, "timestamp": %q
	}]}`, testAlias, id, createdAt))

	// And it is in the workspace's history, which never calls Meteroid.
	history := send(t, "GET", "/api/transcriptions", sendOptions{headers: bearer(testAlias), meteroid: fake})
	if history.status != 200 || len(fake.calls) != 2 {
		t.Errorf("history = %d, calls = %v", history.status, fake.calls)
	}
}

func TestRequestLargerThanTheBalanceIs402AndReportsNoUsage(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `"60"`, `{"consumed": "56.5"}`, true),
		subscriptionCall: noSubscriptions(t),
	})
	// 3.5 minutes remain (derived: Meteroid sent no `remaining`); 211 s bills 3.52.
	response := transcribe(t, fake, 211)

	assertErrorEnvelope(t, response, 402, "QUOTA_EXHAUSTED")
	assertJSON(t, response.body["quota"], `{
		"feature_code": "transcription_minutes", "enabled": true, "limit": "60", "consumed": "56.5",
		"remaining": "3.5", "reset_at": null, "unlimited": false
	}`)
	if response.body["upgrade_plan_code"] != "pro" {
		t.Errorf("upgrade_plan_code = %v", response.body["upgrade_plan_code"])
	}
	if fake.called(ingestCall) {
		t.Error("a refused request must not ingest an event")
	}
}

func TestBalanceMayBeSpentExactly(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `"60"`, `{"remaining": "3.5"}`, true),
		ingestCall:       wire(t, `{}`),
	})
	response := transcribe(t, fake, 210)

	if response.status != 201 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	quota := response.body["quota"].(map[string]any)
	if quota["remaining"] != "0" || quota["consumed"] != "3.5" {
		t.Errorf("quota = %v", quota)
	}
}

func TestUnlimitedEntitlementNeverTripsTheQuota(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `null`, `{}`, true),
		ingestCall:       wire(t, `{}`),
	})
	response := transcribe(t, fake, 7200)

	if response.status != 201 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	assertJSON(t, response.body["quota"], `{
		"feature_code": "transcription_minutes", "enabled": true, "limit": null, "consumed": "120",
		"remaining": null, "reset_at": null, "unlimited": true
	}`)
}

func TestMissingOrDisabledEntitlementIs403NamingTheUpgrade(t *testing.T) {
	stubs := map[string]stub{
		"missing":  wire(t, `{"data": []}`),
		"disabled": meteredEntitlement(t, `"60"`, `{}`, false),
	}
	for name, entitlements := range stubs {
		fake := newFakeMeteroid(map[string]stub{entitlementsCall: entitlements, subscriptionCall: noSubscriptions(t)})
		response := transcribe(t, fake, 60)

		assertErrorEnvelope(t, response, 403, "FEATURE_NOT_ENTITLED")
		if response.body["quota"] != nil || response.body["upgrade_plan_code"] != "pro" {
			t.Errorf("%s: body = %s", name, response.raw)
		}
		if fake.called(ingestCall) {
			t.Errorf("%s: a refused request must not ingest an event", name)
		}
	}
}

func TestFailedUpgradeLookupNeverReplacesTheErrorItDecorates(t *testing.T) {
	// No subscriptions stub: that call 404s, and the answer is still the 403.
	fake := newFakeMeteroid(map[string]stub{entitlementsCall: wire(t, `{"data": []}`)})
	response := transcribe(t, fake, 60)

	assertErrorEnvelope(t, response, 403, "FEATURE_NOT_ENTITLED")
	if response.body["upgrade_plan_code"] != "pro" {
		t.Errorf("upgrade_plan_code = %v", response.body["upgrade_plan_code"])
	}
}

func TestFeatureSeededWithTheWrongTypeIsTheOperators503(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: wire(t, `{"data": [{
			"feature": {"id": "feat_1", "code": "transcription_minutes", "name": "Transcription minutes"},
			"value": {"type": "BOOLEAN", "enabled": true}
		}]}`),
	})
	response := transcribe(t, fake, 60)

	assertErrorEnvelope(t, response, 503, "CATALOG_NOT_SEEDED")
	if fake.called(ingestCall) {
		t.Error("a refused request must not ingest an event")
	}
}

func TestRejectedIngestIsUpstreamsErrorAndLeavesNoHistory(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `null`, `{}`, true),
		ingestCall:       wire(t, `{"failures": [{"event_id": "tr_x", "reason": "timestamp too old"}]}`),
	})
	response := transcribe(t, fake, 60)
	assertErrorEnvelope(t, response, 502, "UPSTREAM_ERROR")
}

func TestEntitlementsAreNormalizedOntoTheTaggedUnion(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		entitlementsCall: meteredEntitlement(t, `"60"`, `{"consumed": "1", "reset_at": "2026-10-01T00:00:00Z"}`, true),
		"GET /api/v1/metrics": wire(t, `{
			"data": [{"id": "met_1", "code": "transcription_minutes", "name": "Minutes", "aggregation_type": "SUM",
			          "created_at": "2026-01-01T00:00:00Z", "product_family_id": "pf_1"}],
			"pagination_meta": {"page": 0, "per_page": 100, "total_items": 1, "total_pages": 1}
		}`),
	})
	response := send(t, "GET", "/api/entitlements", sendOptions{headers: bearer(testAlias), meteroid: fake})

	if response.status != 200 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	assertJSON(t, response.body, `{"entitlements": [
		{
			"feature_code": "transcription_minutes",
			"feature_name": "Transcription minutes",
			"value": {
				"type": "METERED", "enabled": true, "limit": "60", "consumed": "1", "remaining": "59",
				"unlimited": false, "reset_at": "2026-10-01T00:00:00Z",
				"reset_period": {"type": "CALENDAR", "interval": 1, "unit": "MONTH"},
				"metric_code": "transcription_minutes"
			}
		},
		{
			"feature_code": "retention_days",
			"feature_name": "Retention days",
			"value": {"type": "CONFIG", "value": {"kind": "NUMBER", "value": "90"}}
		}
	]}`)
}

func TestSessionCreatesOneCustomerAndMintsATokenBoundToItsAlias(t *testing.T) {
	fake := newFakeMeteroid(map[string]stub{
		// Meteroid echoes the customer it was asked to create.
		"POST /api/v1/customers": func(body []byte) any {
			var customer map[string]any
			_ = json.Unmarshal(body, &customer)
			customer["id"] = "cus_1"
			customer["custom_properties"] = map[string]any{}
			customer["invoicing_entity_id"] = "ive_1"
			return customer
		},
	})
	response := send(t, "POST", "/api/session", sendOptions{body: `{"workspace_name":"  Acme  ","email":null}`, meteroid: fake})

	if response.status != 201 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	workspace := response.body["workspace"].(map[string]any)
	alias := workspace["customer_alias"].(string)
	if !regexp.MustCompile(`^scribe-demo-[0-9a-f]{32}$`).MatchString(alias) {
		t.Errorf("alias = %s", alias)
	}
	assertJSON(t, workspace, fmt.Sprintf(
		`{"id": %q, "name": "Acme", "customer_id": "cus_1", "customer_alias": %q, "currency": "USD"}`, alias, alias))

	if bound, err := verifyToken(testSessionSecret, response.body["session_token"].(string)); err != nil || bound != alias {
		t.Errorf("the token is bound to %q (%v), not %q", bound, err, alias)
	}
	assertJSON(t, json.RawMessage(fake.bodies[0]), fmt.Sprintf(
		`{"alias": %q, "currency": "USD", "custom_taxes": [], "invoicing_emails": ["%s@example.invalid"], "name": "Acme"}`,
		alias, alias))
}

func TestPricingTableIsResolvedFromTheSeededCatalogAndCached(t *testing.T) {
	plan := func(id, name, planType, fee string) string {
		return fmt.Sprintf(`{
			"id": %q, "name": %q, "plan_type": %q, "status": "ACTIVE", "currency": "USD", "version": 2,
			"version_id": "pv_%s", "net_terms": 0, "created_at": "2026-01-01T00:00:00Z",
			"available_parameters": {}, "product_family": {"id": "pf_1", "name": "Scribe"},
			"price_components": [{"id": "pc_%s", "name": "Base", "fee": %s}, {"id": "pc_none", "name": "No fee"}]
		}`, id, name, planType, id, id, fee)
	}
	rate := `{"type": "RATE", "rates": [{"term": "ANNUAL", "price": "290.00"}, {"term": "MONTHLY", "price": "29.00"}]}`
	usage := `{"type": "USAGE", "cadence": "MONTHLY", "metric_id": "met_1", "pricing": {"type": "PER_UNIT", "rate": "0.0100"}}`

	feature := wire(t, `{"id": "feat", "code": "x", "name": "X", "status": "ACTIVE", "feature_type": {"type": "BOOLEAN"}}`)
	fake := newFakeMeteroid(map[string]stub{
		"GET /api/v1/features/transcription_minutes": feature,
		"GET /api/v1/features/sso":                   feature,
		"GET /api/v1/features/retention_days":        feature,
		"GET /api/v1/features/seats":                 feature,
		"GET /api/v1/metrics": wire(t, `{
			"data": [{"id": "met_1", "code": "transcription_minutes", "name": "Minutes", "aggregation_type": "SUM",
			          "created_at": "2026-01-01T00:00:00Z", "product_family_id": "pf_1"}],
			"pagination_meta": {"page": 0, "per_page": 100, "total_items": 1, "total_pages": 1}
		}`),
		// `search` is fuzzy: every lookup gets all three back, plus a near miss.
		"GET /api/v1/plans": wire(t, `{"data": [`+
			plan("scale", "Scribe Scale", "STANDARD", usage)+`,`+
			plan("decoy", "Scribe Pro (legacy)", "STANDARD", rate)+`,`+
			plan("pro", "Scribe Pro", "STANDARD", rate)+`,`+
			plan("free", "Scribe Free", "FREE", rate)+
			`], "pagination_meta": {"page": 0, "per_page": 100, "total_items": 4, "total_pages": 1}}`),
		"GET /api/v1/plan-versions/pv_free/entitlements": wire(t, `{"data": []}`),
		"GET /api/v1/plan-versions/pv_pro/entitlements": wire(t, `{"data": [{
			"feature": {"id": "feat_2", "code": "sso", "name": "SSO"}, "value": {"type": "BOOLEAN", "enabled": false}
		}]}`),
		"GET /api/v1/plan-versions/pv_scale/entitlements": wire(t, `{"data": []}`),
	})
	application := newApp(testConfig, fake.client)

	response := send(t, "GET", "/api/plans", sendOptions{app: application})
	if response.status != 200 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	plans := response.body["plans"].([]any)
	if len(plans) != 3 {
		t.Fatalf("plans = %s", response.raw)
	}
	assertJSON(t, plans[1], `{
		"code": "pro", "name": "Scribe Pro", "description": null, "plan_id": "pro", "plan_version_id": "pv_pro",
		"version": 2, "currency": "USD", "is_free": false, "trial_days": null,
		"prices": [{
			"component_id": "pc_pro", "name": "Base", "kind": "RATE", "cadence": "MONTHLY", "amount": "29",
			"unit_amount": null, "included_amount": null, "unit_name": null, "pricing_model": null
		}],
		"features": [{"feature_code": "sso", "label": "SSO not included"}]
	}`)
	assertJSON(t, plans[2].(map[string]any)["prices"], `[{
		"component_id": "pc_scale", "name": "Base", "kind": "USAGE", "cadence": "MONTHLY", "amount": null,
		"unit_amount": "0.01", "included_amount": null, "unit_name": "transcription_minutes", "pricing_model": "PER_UNIT"
	}]`)
	if free := plans[0].(map[string]any); free["is_free"] != true || len(free["features"].([]any)) != 0 {
		t.Errorf("free = %v", free)
	}

	// Once resolved it is cached: a second request costs Meteroid nothing.
	calls := len(fake.calls)
	send(t, "GET", "/api/plans", sendOptions{app: application})
	if len(fake.calls) != calls {
		t.Errorf("the catalog was resolved again: %v", fake.calls[calls:])
	}
}

func TestUnseededFeatureIsNamedAndTheFailureIsNotCached(t *testing.T) {
	fake := newFakeMeteroid(nil)
	application := newApp(testConfig, fake.client)

	for range 2 {
		response := send(t, "GET", "/api/plans", sendOptions{app: application})
		assertErrorEnvelope(t, response, 503, "CATALOG_NOT_SEEDED")
	}
	if len(fake.calls) != 2 {
		t.Errorf("a failure was cached: %v", fake.calls)
	}
}

func TestMeteroidsOwnFailuresMapOntoTheContractsUpstreamCodes(t *testing.T) {
	cases := []struct {
		upstream int
		code     string
		status   int
	}{
		{401, "UPSTREAM_UNAUTHORIZED", 502},
		{403, "UPSTREAM_UNAUTHORIZED", 502},
		{429, "RATE_LIMITED", 429},
		{400, "UPSTREAM_ERROR", 502},
		{500, "UPSTREAM_ERROR", 502},
	}
	for _, c := range cases {
		fake := newFakeMeteroid(nil)
		fake.status = c.upstream

		response := send(t, "GET", "/api/entitlements", sendOptions{headers: bearer(testAlias), meteroid: fake})
		assertErrorEnvelope(t, response, c.status, c.code)
	}
}

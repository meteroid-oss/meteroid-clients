package main

import (
	"fmt"
	"strconv"
	"strings"
	"testing"
	"time"
)

// End-to-end checks that need no Meteroid tenant.
//
// Everything reachable without an API key is exercised here against the shapes
// examples/openapi.yaml promises: the health probe, the session-token gate, the error
// envelope, the 404 fallback, and — the interesting one — webhook signature
// verification, which works offline because the SDK ships a *signer* as well as a
// verifier. The contract suite uses the same trick to test the receiver for real.

func TestHealthReportsTheBackendAndItsConfiguration(t *testing.T) {
	response := send(t, "GET", "/api/health", sendOptions{})

	if response.status != 200 {
		t.Fatalf("status = %d", response.status)
	}
	assertJSON(t, response.body, `{"status":"ok","backend":"go","meteroid_configured":false,"version":"1.0.0"}`)
	if got := response.header.Get("Content-Type"); got != "application/json" {
		t.Errorf("Content-Type = %q", got)
	}
}

func TestMissingSessionTokenIs401(t *testing.T) {
	response := send(t, "GET", "/api/me", sendOptions{})
	assertErrorEnvelope(t, response, 401, "UNAUTHORIZED")
	// Not "<session_token>": the message is meant to be read.
	if !strings.Contains(response.raw, "Bearer <session_token>") {
		t.Errorf("message was HTML-escaped: %s", response.raw)
	}
}

func TestTokenFromAnotherDeploymentIsRejected(t *testing.T) {
	forged := mintToken("some-other-secret", "scribe-demo-1")
	response := send(t, "GET", "/api/me", sendOptions{headers: map[string]string{"Authorization": "Bearer " + forged}})
	assertErrorEnvelope(t, response, 401, "UNAUTHORIZED")
}

func TestAuthorizationThatIsNotABearerTokenIsRejected(t *testing.T) {
	for _, authorization := range []string{"Basic abc", "bearer " + mintToken(testSessionSecret, "a"), "Bearer ", "Bearer garbage"} {
		response := send(t, "GET", "/api/me", sendOptions{headers: map[string]string{"Authorization": authorization}})
		assertErrorEnvelope(t, response, 401, "UNAUTHORIZED")
	}
}

func TestSessionTokenIsCheckedBeforeTheBody(t *testing.T) {
	response := send(t, "POST", "/api/transcriptions", sendOptions{body: "{not json"})
	assertErrorEnvelope(t, response, 401, "UNAUTHORIZED")

	oversized := send(t, "POST", "/api/transcriptions", sendOptions{body: strings.Repeat("x", maxBodyBytes+1)})
	assertErrorEnvelope(t, oversized, 401, "UNAUTHORIZED")
}

func TestUnknownRouteIs404(t *testing.T) {
	// A mux would redirect the second and third of these; the contract says 404.
	for _, path := range []string{"/api/nope", "/", "/api/health/", "/api//health", "/api/%68ealth", "/api/x/../health"} {
		response := send(t, "GET", path, sendOptions{})
		assertErrorEnvelope(t, response, 404, "NOT_FOUND")
	}
}

func TestKnownRouteWithTheWrongMethodIsABare405(t *testing.T) {
	wrong := send(t, "DELETE", "/api/health", sendOptions{})
	if wrong.status != 405 || wrong.header.Get("Allow") != "GET,HEAD" || wrong.raw != "" {
		t.Errorf("DELETE /api/health = %d, Allow %q, body %q", wrong.status, wrong.header.Get("Allow"), wrong.raw)
	}

	both := send(t, "PUT", "/api/transcriptions", sendOptions{})
	if both.header.Get("Allow") != "GET,HEAD,POST" {
		t.Errorf("Allow = %q", both.header.Get("Allow"))
	}

	// HEAD is GET without the body, so it is not allowed where GET is not.
	head := send(t, "HEAD", "/api/session", sendOptions{})
	if head.status != 405 || head.header.Get("Allow") != "POST" {
		t.Errorf("HEAD /api/session = %d, Allow %q", head.status, head.header.Get("Allow"))
	}
	if ok := send(t, "HEAD", "/api/health", sendOptions{}); ok.status != 200 {
		t.Errorf("HEAD /api/health = %d", ok.status)
	}
}

func TestEveryAnswerCarriesCORSAndOptionsIsAPreflight(t *testing.T) {
	simple := send(t, "GET", "/api/nope", sendOptions{})
	if simple.header.Get("Access-Control-Allow-Origin") != "*" || simple.header.Get("Access-Control-Expose-Headers") != "*" {
		t.Errorf("CORS headers missing: %v", simple.header)
	}

	preflight := send(t, "OPTIONS", "/api/checkout", sendOptions{headers: map[string]string{
		"Origin":                        "http://localhost:5173",
		"Access-Control-Request-Method": "POST",
	}})
	if preflight.status != 200 || preflight.raw != "" {
		t.Fatalf("preflight = %d %q", preflight.status, preflight.raw)
	}
	for _, name := range []string{"Access-Control-Allow-Origin", "Access-Control-Allow-Methods", "Access-Control-Allow-Headers"} {
		if preflight.header.Get(name) != "*" {
			t.Errorf("%s = %q", name, preflight.header.Get(name))
		}
	}
	// A preflight is answered whether or not the path exists.
	if unknown := send(t, "OPTIONS", "/api/nope", sendOptions{}); unknown.status != 200 {
		t.Errorf("OPTIONS /api/nope = %d", unknown.status)
	}
}

func TestMalformedBodyIs400(t *testing.T) {
	bodies := []string{
		// `duration_seconds` is required, and unknown fields are rejected.
		`{"title":"x","surprise":true}`,
		`{"title":"x"}`,
		`{not json`,
		`[]`,
		`null`,
		``,
		`   `,
		// One JSON value, and nothing after it.
		`{"title":"x","duration_seconds":60} trailing`,
		`{"title":"x","duration_seconds":60}{}`,
		// Keys are matched exactly; encoding/json on its own would accept this one.
		`{"Title":"x","duration_seconds":60}`,
		// Wrong scalar types are type errors, never coerced.
		`{"title":123,"duration_seconds":60}`,
		`{"title":"x","duration_seconds":"60"}`,
		`{"title":"x","duration_seconds":60.5}`,
		`{"title":"x","duration_seconds":true}`,
		`{"title":null,"duration_seconds":60}`,
		`{"title":"x","duration_seconds":null}`,
		`{"title":"x","duration_seconds":2147483648}`,
		`{"title":"x","duration_seconds":1e400}`,
		// Well-typed, but outside the contract's bounds.
		`{"title":"x","duration_seconds":0}`,
		`{"title":"x","duration_seconds":7201}`,
		`{"title":"   ","duration_seconds":60}`,
		`{"title":"` + strings.Repeat("x", 201) + `","duration_seconds":60}`,
	}
	for _, raw := range bodies {
		fake := newFakeMeteroid(nil)
		response := send(t, "POST", "/api/transcriptions", sendOptions{headers: bearer("scribe-demo-1"), body: raw, meteroid: fake})

		if response.status != 400 {
			t.Errorf("%s: status = %d", raw, response.status)
			continue
		}
		assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
		if len(fake.calls) != 0 {
			t.Errorf("Meteroid was called for %s", raw)
		}
	}
}

func TestIntegerSpelledAsAFloatIsStillAnInteger(t *testing.T) {
	// JSON Schema's `type: integer` is about the value, not the spelling. These get past
	// validation — and then fail on the entitlement read, which has no stub here.
	for _, raw := range []string{`{"title":"x","duration_seconds":60.0}`, `{"title":"x","duration_seconds":6e1}`} {
		fake := newFakeMeteroid(nil)
		response := send(t, "POST", "/api/transcriptions", sendOptions{headers: bearer("scribe-demo-1"), body: raw, meteroid: fake})

		if response.status == 400 || len(fake.calls) == 0 {
			t.Errorf("%s was refused: %d %s", raw, response.status, response.raw)
		}
	}
}

func TestBodyThatIsNotValidUTF8Is400(t *testing.T) {
	response := send(t, "POST", "/api/session", sendOptions{body: "{\"\xff\":1}"})
	assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
}

func TestOptionalBodyRejectsWhatItDoesNotDeclare(t *testing.T) {
	for _, raw := range []string{`{"nope":1}`, `{"workspace_name":123}`, `{"workspace_name":"  "}`, `{"email":false}`, `[]`, `null`, `{} {}`} {
		fake := newFakeMeteroid(nil)
		response := send(t, "POST", "/api/session", sendOptions{body: raw, meteroid: fake})

		if response.status != 400 {
			t.Errorf("%s: status = %d", raw, response.status)
			continue
		}
		assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
		if len(fake.calls) != 0 {
			t.Errorf("Meteroid was called for %s", raw)
		}
	}
}

func TestPlanCodeOutsideTheEnumIsRejectedBeforeTheCatalog(t *testing.T) {
	fake := newFakeMeteroid(nil)
	response := send(t, "POST", "/api/checkout", sendOptions{headers: bearer("scribe-demo-1"), body: `{"plan_code":"gold"}`, meteroid: fake})

	assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
	if len(fake.calls) != 0 {
		t.Errorf("Meteroid was called: %v", fake.calls)
	}
}

func TestOutOfRangePortalLifetimeIsRejectedBeforeMeteroid(t *testing.T) {
	for _, raw := range []string{`{"expires_in_seconds":5}`, `{"expires_in_seconds":2592001}`, `{"expires_in_seconds":"60"}`} {
		fake := newFakeMeteroid(nil)
		response := send(t, "POST", "/api/portal-session", sendOptions{headers: bearer("scribe-demo-1"), body: raw, meteroid: fake})

		assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
		if len(fake.calls) != 0 {
			t.Errorf("Meteroid was called for %s", raw)
		}
	}
}

func TestAbsentNullAndEmptyPortalBodiesMeanTheDefault(t *testing.T) {
	for _, raw := range []string{``, ` `, `{}`, `{"expires_in_seconds":null}`} {
		fake := newFakeMeteroid(map[string]stub{
			"POST /api/v1/customers/scribe-demo-1/portal-token": static(map[string]string{"token": "jwt", "portal_url": "https://portal.test"}),
		})
		response := send(t, "POST", "/api/portal-session", sendOptions{headers: bearer("scribe-demo-1"), body: raw, meteroid: fake})

		if response.status != 201 {
			t.Fatalf("%q: %d %s", raw, response.status, response.raw)
		}
		assertJSON(t, response.body, `{"portal_url":"https://portal.test","token":"jwt","expires_in_seconds":86400}`)
		assertJSON(t, string(fake.bodies[0]), `"{\"expires_in_seconds\":86400}"`)
	}
}

func TestInvalidInvoiceLimitIsRejectedBeforeMeteroid(t *testing.T) {
	for _, query := range []string{"limit=0", "limit=101", "limit=abc", "limit=", "limit=1.5", "foo=1", "limit=1&limit=2", "limit=99999999999", "limit=%zz"} {
		fake := newFakeMeteroid(nil)
		response := send(t, "GET", "/api/invoices?"+query, sendOptions{headers: bearer("scribe-demo-1"), meteroid: fake})

		if response.status != 400 {
			t.Errorf("%s: status = %d", query, response.status)
			continue
		}
		assertErrorEnvelope(t, response, 400, "BAD_REQUEST")
		if len(fake.calls) != 0 {
			t.Errorf("Meteroid was called for %s", query)
		}
	}
}

func TestOversizedBodyIsRefusedInTheEnvelope(t *testing.T) {
	response := send(t, "POST", "/api/session", sendOptions{body: strings.Repeat(" ", maxBodyBytes+1)})

	if response.status != 413 {
		t.Fatalf("status = %d", response.status)
	}
	assertJSON(t, response.body, `{"code":"BAD_REQUEST","message":"The request body exceeds the 2097152-byte limit.","quota":null,"upgrade_plan_code":null}`)

	atTheLimit := send(t, "POST", "/api/session", sendOptions{body: strings.Repeat(" ", maxBodyBytes)})
	if atTheLimit.status == 413 {
		t.Error("a body of exactly the limit was refused")
	}
}

func TestUnreachableMeteroidIs502NotACrash(t *testing.T) {
	// No fake here: the real client, pointed at a port nothing listens on.
	unreachable := testConfig
	unreachable.meteroidBaseURL = "http://127.0.0.1:9"
	response := send(t, "GET", "/api/plans", sendOptions{app: newApp(unreachable, unreachable.meteroidClient())})

	assertErrorEnvelope(t, response, 502, "UPSTREAM_ERROR")
}

// ---------------------------------------------------------------- webhooks

func webhook(t *testing.T, payload string, headers map[string]string) testResponse {
	t.Helper()
	return send(t, "POST", "/api/webhooks/meteroid", sendOptions{headers: headers, body: payload})
}

func TestCorrectlySignedEventIsAccepted(t *testing.T) {
	payload := `{"id":"evt_123","type":"invoice.paid","timestamp":"2026-09-01T12:00:00Z"}`
	response := webhook(t, payload, signed(t, payload, "msg_1", "webhook"))

	if response.status != 202 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	assertJSON(t, response.body, `{"received":true,"event_id":"evt_123","type":"invoice.paid","handled":true}`)
}

func TestRawBytesAreVerifiedNotAReserialization(t *testing.T) {
	// Spacing and key order no JSON serializer would reproduce.
	payload := "{ \"type\" : \"invoice.paid\",\n\t\"id\":\"evt_raw\"   }"
	response := webhook(t, payload, signed(t, payload, "msg_raw", "webhook"))

	if response.status != 202 || response.body["event_id"] != "evt_raw" {
		t.Fatalf("%d %s", response.status, response.raw)
	}
}

func TestUnknownEventTypeIsAcknowledgedNotRejected(t *testing.T) {
	// A receiver that 400s on an unrecognized type breaks the first time Meteroid ships a
	// new one — so this must be a 202 with `handled: false`.
	payload := `{"id":"evt_9","type":"something.invented.later"}`
	response := webhook(t, payload, signed(t, payload, "msg_9", "webhook"))

	if response.status != 202 {
		t.Fatalf("%d %s", response.status, response.raw)
	}
	assertJSON(t, response.body, `{"received":true,"event_id":"evt_9","type":"something.invented.later","handled":false}`)
}

func TestSignedBodyOfAnUnexpectedShapeIsAcknowledgedToo(t *testing.T) {
	for _, payload := range []string{`[1,2]`, `{"id":7,"type":["x"]}`, `"just a string"`, `null`} {
		response := webhook(t, payload, signed(t, payload, "msg_shape", "webhook"))

		if response.status != 202 {
			t.Fatalf("%s: %d %s", payload, response.status, response.raw)
		}
		assertJSON(t, response.body, `{"received":true,"event_id":"msg_shape","type":null,"handled":false}`)
	}
}

func TestEventWithNoIDFallsBackToTheWebhookIDHeader(t *testing.T) {
	payload := `{"type":"subscription.created"}`
	response := webhook(t, payload, signed(t, payload, "msg_42", "webhook"))

	assertJSON(t, response.body, `{"received":true,"event_id":"msg_42","type":"subscription.created","handled":true}`)
}

func TestSvixHeadersAreAcceptedAsAliases(t *testing.T) {
	payload := `{"type":"invoice.finalized"}`
	response := webhook(t, payload, signed(t, payload, "msg_s", "svix"))

	// The id fallback has to follow the alias as well.
	if response.status != 202 || response.body["event_id"] != "msg_s" {
		t.Fatalf("%d %s", response.status, response.raw)
	}
}

func TestBodyThatDoesNotMatchItsSignatureIsRejected(t *testing.T) {
	headers := signed(t, `{"id":"evt_1","type":"invoice.paid"}`, "msg_1", "webhook")
	// One field different from what was signed.
	response := webhook(t, `{"id":"evt_1","type":"invoice.void"}`, headers)

	assertErrorEnvelope(t, response, 400, "WEBHOOK_SIGNATURE_INVALID")
}

func TestStaleAndFutureTimestampsAreRejected(t *testing.T) {
	payload := `{"type":"invoice.paid"}`
	for _, skew := range []time.Duration{-time.Hour, time.Hour} {
		headers := signed(t, payload, "msg_old", "webhook")
		headers["webhook-timestamp"] = strconv.FormatInt(time.Now().Add(skew).Unix(), 10)

		assertErrorEnvelope(t, webhook(t, payload, headers), 400, "WEBHOOK_SIGNATURE_INVALID")
	}
}

func TestUnsignedEventIsRejected(t *testing.T) {
	response := webhook(t, `{"type":"invoice.paid"}`, map[string]string{"Content-Type": "application/json"})
	assertErrorEnvelope(t, response, 400, "WEBHOOK_SIGNATURE_INVALID")
}

func TestCorrectlySignedBodyThatIsNotJSONIsRejected(t *testing.T) {
	for _, payload := range []string{"not json", "", "{} {}", "\xff"} {
		response := webhook(t, payload, signed(t, payload, "msg_nj", "webhook"))
		if response.status != 400 {
			t.Errorf("%q: status = %d", payload, response.status)
			continue
		}
		assertErrorEnvelope(t, response, 400, "WEBHOOK_SIGNATURE_INVALID")
	}
}

func TestMissingOrUnusableWebhookSecret(t *testing.T) {
	// Missing is the operator's problem, not a bad signature.
	missing := testConfig
	missing.meteroidWebhookSecret = ""
	response := send(t, "POST", "/api/webhooks/meteroid", sendOptions{app: newApp(missing, newFakeMeteroid(nil).client), body: "{}"})
	assertErrorEnvelope(t, response, 500, "INTERNAL")

	// One that is not base64 can verify nothing, which is how the other backends see it.
	garbled := testConfig
	garbled.meteroidWebhookSecret = "whsec_!!!"
	response = send(t, "POST", "/api/webhooks/meteroid", sendOptions{app: newApp(garbled, newFakeMeteroid(nil).client), body: "{}"})
	assertErrorEnvelope(t, response, 400, "WEBHOOK_SIGNATURE_INVALID")
}

func TestAPanicIsTheInternalEnvelopeNotADroppedConnection(t *testing.T) {
	// A nil Meteroid client is a bug by construction: the first SDK call dereferences it.
	response := send(t, "GET", "/api/plans", sendOptions{app: newApp(testConfig, nil)})

	assertErrorEnvelope(t, response, 500, "INTERNAL")
	if message := fmt.Sprint(response.body["message"]); message != "Unexpected error handling the request." {
		t.Errorf("the panic leaked into the message: %s", message)
	}
}

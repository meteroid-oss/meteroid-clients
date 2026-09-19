package main

import (
	"bytes"
	"encoding/json"
	"io"
	"net/http"
	"net/http/httptest"
	"sort"
	"strconv"
	"strings"
	"sync"
	"testing"
	"time"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// Shared fixtures for the offline tests.
//
// Nothing here opens a socket. The router is an http.Handler, so the tests call it with
// an httptest.ResponseRecorder; and the SDK takes a custom http.Client, so "Meteroid" is
// an http.RoundTripper that either answers from a table or reports having been called.

const (
	// Any base64 string is a valid Standard Webhooks secret.
	testWebhookSecret = "c2NyaWJlLWRlbW8td2ViaG9vay1zZWNyZXQ="
	testSessionSecret = "test-session-secret"
)

// testConfig has no API key: every Meteroid-backed operation is out of scope unless a
// test stubs it.
var testConfig = config{
	meteroidBaseURL:       "http://meteroid.invalid",
	meteroidWebhookSecret: testWebhookSecret,
	sessionSecret:         testSessionSecret,
	defaultCurrency:       meteroid.CurrencyUsd,
}

// stub is one stubbed Meteroid answer: the JSON body for a request.
type stub func(body []byte) any

func static(body any) stub { return func([]byte) any { return body } }

// fakeMeteroid is a Meteroid whose transport answers from routes (keyed
// "METHOD /path"). A request with no stub is a 404 in Meteroid's own error envelope.
type fakeMeteroid struct {
	client *meteroid.Client

	mu     sync.Mutex
	routes map[string]stub
	// status, when set, is what every request is answered with.
	status int
	// calls is every request the SDK made, as "METHOD /path"; bodies the raw body of each.
	calls  []string
	bodies [][]byte
}

func newFakeMeteroid(routes map[string]stub) *fakeMeteroid {
	fake := &fakeMeteroid{routes: routes}
	fake.client = meteroid.New("test-key", &meteroid.Options{
		ServerURL:     "http://meteroid.test",
		HTTPClient:    &http.Client{Transport: fake},
		RetrySchedule: []time.Duration{},
	})
	return fake
}

func (f *fakeMeteroid) RoundTrip(r *http.Request) (*http.Response, error) {
	var body []byte
	if r.Body != nil {
		body, _ = io.ReadAll(r.Body)
	}
	key := r.Method + " " + r.URL.Path

	f.mu.Lock()
	f.calls = append(f.calls, key)
	f.bodies = append(f.bodies, body)
	f.mu.Unlock()

	status, answer := http.StatusOK, any(nil)
	switch respond, stubbed := f.routes[key]; {
	case f.status != 0:
		status, answer = f.status, map[string]string{"code": "BAD_REQUEST", "message": "nope"}
	case !stubbed:
		status, answer = http.StatusNotFound, map[string]string{"code": "NOT_FOUND", "message": "no stub for " + key}
	default:
		answer = respond(body)
	}

	payload, err := json.Marshal(answer)
	if err != nil {
		return nil, err
	}
	return &http.Response{
		StatusCode: status,
		Header:     http.Header{"Content-Type": {"application/json"}},
		Body:       io.NopCloser(bytes.NewReader(payload)),
		Request:    r,
	}, nil
}

func (f *fakeMeteroid) called(key string) bool {
	f.mu.Lock()
	defer f.mu.Unlock()
	for _, call := range f.calls {
		if call == key {
			return true
		}
	}
	return false
}

type testResponse struct {
	status int
	header http.Header
	raw    string
	// body is the decoded JSON, nil for the few bodiless answers.
	body map[string]any
}

type sendOptions struct {
	headers map[string]string
	body    string
	// app wins over meteroid; with neither, Meteroid is a fake with no stubs at all.
	app      *app
	meteroid *fakeMeteroid
}

func send(t *testing.T, method, target string, options sendOptions) testResponse {
	t.Helper()
	application := options.app
	if application == nil {
		fake := options.meteroid
		if fake == nil {
			fake = newFakeMeteroid(nil)
		}
		application = newApp(testConfig, fake.client)
	}

	request := httptest.NewRequest(method, target, strings.NewReader(options.body))
	for name, value := range options.headers {
		request.Header.Set(name, value)
	}
	recorder := httptest.NewRecorder()
	application.router().ServeHTTP(recorder, request)

	response := testResponse{status: recorder.Code, header: recorder.Header(), raw: recorder.Body.String()}
	if response.raw != "" {
		if err := json.Unmarshal(recorder.Body.Bytes(), &response.body); err != nil {
			t.Fatalf("%s %s answered a body that is not a JSON object: %q", method, target, response.raw)
		}
	}
	return response
}

// assertErrorEnvelope: every error in the contract is the same envelope, with `quota`
// and `upgrade_plan_code` always present — never absent, `null` when they do not apply.
func assertErrorEnvelope(t *testing.T, response testResponse, status int, code string) {
	t.Helper()
	if response.status != status {
		t.Fatalf("status = %d, want %d (body %s)", response.status, status, response.raw)
	}
	if got, want := keys(response.body), []string{"code", "message", "quota", "upgrade_plan_code"}; !equal(got, want) {
		t.Fatalf("envelope keys = %v, want %v", got, want)
	}
	if response.body["code"] != code {
		t.Fatalf("code = %v, want %s (body %s)", response.body["code"], code, response.raw)
	}
	if _, ok := response.body["message"].(string); !ok {
		t.Fatalf("message is not a string: %s", response.raw)
	}
}

func keys(object map[string]any) []string {
	names := make([]string, 0, len(object))
	for name := range object {
		names = append(names, name)
	}
	sort.Strings(names)
	return names
}

func equal(a, b []string) bool {
	return strings.Join(a, "\x00") == strings.Join(b, "\x00")
}

// assertJSON compares a value with the JSON it should serialize to, key for key.
func assertJSON(t *testing.T, got any, want string) {
	t.Helper()
	actual, err := json.Marshal(got)
	if err != nil {
		t.Fatal(err)
	}
	var a, b any
	if err := json.Unmarshal(actual, &a); err != nil {
		t.Fatal(err)
	}
	if err := json.Unmarshal([]byte(want), &b); err != nil {
		t.Fatalf("bad expectation %s: %v", want, err)
	}
	normalizedGot, _ := json.Marshal(a)
	normalizedWant, _ := json.Marshal(b)
	if string(normalizedGot) != string(normalizedWant) {
		t.Fatalf("JSON mismatch\n got: %s\nwant: %s", normalizedGot, normalizedWant)
	}
}

func bearer(alias string) map[string]string {
	return map[string]string{
		"Authorization": "Bearer " + mintToken(testSessionSecret, alias),
		"Content-Type":  "application/json",
	}
}

// signed signs a payload exactly the way Meteroid does, using the SDK's own signer.
func signed(t *testing.T, payload, msgID, prefix string) map[string]string {
	t.Helper()
	webhook, err := meteroid.NewWebhook(testWebhookSecret)
	if err != nil {
		t.Fatal(err)
	}
	now := time.Now()
	return map[string]string{
		"Content-Type":        "application/json",
		prefix + "-id":        msgID,
		prefix + "-timestamp": strconv.FormatInt(now.Unix(), 10),
		prefix + "-signature": webhook.Sign(msgID, now, []byte(payload)),
	}
}

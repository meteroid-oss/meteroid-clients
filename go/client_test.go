package meteroid

import (
	"context"
	"encoding/json"
	"errors"
	"io"
	"net/http"
	"net/http/httptest"
	"net/url"
	"strings"
	"testing"
	"time"
)

func testClient(t *testing.T, handler http.HandlerFunc) *Client {
	t.Helper()

	server := httptest.NewServer(handler)
	t.Cleanup(server.Close)

	return New("test-api-key", &Options{
		ServerURL: server.URL,
		// Keep the tests fast and deterministic.
		RetrySchedule: []time.Duration{},
	})
}

func TestListCustomers(t *testing.T) {
	const body = `{
		"data": [
			{
				"id": "cust_123",
				"name": "Test Customer",
				"currency": "USD",
				"custom_properties": {},
				"preferred_locales": [],
				"custom_taxes": [],
				"invoicing_emails": [],
				"invoicing_entity_id": "inv_1"
			}
		],
		"pagination_meta": {"page":0,"per_page":10,"total_items":1,"total_pages":1}
	}`

	var gotRequest *http.Request
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotRequest = r.Clone(r.Context())
		w.Header().Set("Content-Type", "application/json")
		io.WriteString(w, body)
	})

	response, err := client.Customers().ListCustomers(context.Background(), nil)
	if err != nil {
		t.Fatalf("ListCustomers: %v", err)
	}

	if gotRequest.Method != http.MethodGet {
		t.Errorf("method = %s, want GET", gotRequest.Method)
	}
	if gotRequest.URL.Path != "/api/v1/customers" {
		t.Errorf("path = %s", gotRequest.URL.Path)
	}
	if got := gotRequest.Header.Get("Authorization"); got != "Bearer test-api-key" {
		t.Errorf("authorization = %q", got)
	}
	if got := gotRequest.Header.Get("User-Agent"); got != "meteroid-go/"+Version {
		t.Errorf("user-agent = %q", got)
	}
	if got := gotRequest.Header.Get("Meteroid-Version"); got != APIVersion {
		t.Errorf("meteroid-version = %q", got)
	}

	if len(response.Data) != 1 {
		t.Fatalf("len(data) = %d, want 1", len(response.Data))
	}
	if response.Data[0].Name != "Test Customer" {
		t.Errorf("name = %q", response.Data[0].Name)
	}
	if response.PaginationMeta.TotalItems != 1 {
		t.Errorf("total_items = %d", response.PaginationMeta.TotalItems)
	}
}

// Optional query parameters are only sent when set, and repeated parameters are
// exploded rather than comma-joined.
func TestQueryParameterEncoding(t *testing.T) {
	var gotQuery string
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotQuery = r.URL.RawQuery
		io.WriteString(w, `{"data":[],"pagination_meta":{"page":0,"per_page":10,"total_items":0,"total_pages":0}}`)
	})

	page := int32(2)
	jobType := BatchJobType("INVOICE_ISSUE")
	_, err := client.BatchJobs().ListBatchJobs(context.Background(), &BatchJobsListBatchJobsOptions{
		Page:    &page,
		JobType: &jobType,
		Status:  []BatchJobStatus{BatchJobStatusPending, BatchJobStatusFailed},
	})
	if err != nil {
		t.Fatalf("ListBatchJobs: %v", err)
	}

	for _, want := range []string{"page=2", "job_type=INVOICE_ISSUE", "status=PENDING", "status=FAILED"} {
		if !strings.Contains(gotQuery, want) {
			t.Errorf("query %q is missing %q", gotQuery, want)
		}
	}
	if strings.Contains(gotQuery, "per_page") {
		t.Errorf("unset optional parameter was sent: %q", gotQuery)
	}
}

// Path parameters are substituted and escaped, POST bodies are sent as JSON, and
// an idempotency key is added automatically.
func TestCreateCustomer(t *testing.T) {
	var (
		gotPath string
		gotBody []byte
		gotKey  string
	)
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotPath = r.URL.Path
		gotBody, _ = io.ReadAll(r.Body)
		gotKey = r.Header.Get("idempotency-key")
		w.WriteHeader(http.StatusOK)
		io.WriteString(w, `{"id":"cust_1","name":"Acme","currency":"EUR","custom_properties":{},"custom_taxes":[],"invoicing_emails":[],"invoicing_entity_id":"inv_1","preferred_locales":[]}`)
	})

	customer, err := client.Customers().CreateCustomer(context.Background(), CustomerCreateRequest{
		Name:     Ptr("Acme"),
		Currency: CurrencyEur,
	})
	if err != nil {
		t.Fatalf("CreateCustomer: %v", err)
	}
	if customer.Id != "cust_1" {
		t.Errorf("id = %q", customer.Id)
	}
	if gotPath != "/api/v1/customers" {
		t.Errorf("path = %q", gotPath)
	}
	if !strings.HasPrefix(gotKey, "auto_") {
		t.Errorf("idempotency-key = %q, want an auto_ prefixed key", gotKey)
	}

	var sent map[string]any
	if err := json.Unmarshal(gotBody, &sent); err != nil {
		t.Fatalf("request body is not JSON: %s", gotBody)
	}
	if sent["name"] != "Acme" || sent["currency"] != "EUR" {
		t.Errorf("unexpected request body: %s", gotBody)
	}
	if _, ok := sent["alias"]; ok {
		t.Errorf("unset optional body field was sent: %s", gotBody)
	}
}

// A handful of OAuth endpoints take form-urlencoded bodies rather than JSON.
func TestFormEncodedBody(t *testing.T) {
	var (
		gotContentType string
		gotForm        url.Values
	)
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotContentType = r.Header.Get("Content-Type")
		if err := r.ParseForm(); err != nil {
			t.Errorf("ParseForm: %v", err)
		}
		gotForm = r.PostForm
		w.WriteHeader(http.StatusOK)
	})

	err := client.OAuth().RevokeEndpoint(context.Background(), RevocationRequest{
		Token:         "tok_123",
		TokenTypeHint: Ptr("access_token"),
	})
	if err != nil {
		t.Fatalf("RevokeEndpoint: %v", err)
	}

	if gotContentType != "application/x-www-form-urlencoded" {
		t.Errorf("content-type = %q", gotContentType)
	}
	if gotForm.Get("token") != "tok_123" {
		t.Errorf("token = %q", gotForm.Get("token"))
	}
	if gotForm.Get("token_type_hint") != "access_token" {
		t.Errorf("token_type_hint = %q", gotForm.Get("token_type_hint"))
	}
}

func TestPathParameterEscaping(t *testing.T) {
	var gotPath string
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotPath = r.URL.Path
		io.WriteString(w, `{"id":"cust_1","name":"Acme","currency":"EUR","custom_properties":{},"custom_taxes":[],"invoicing_emails":[],"invoicing_entity_id":"inv_1","preferred_locales":[]}`)
	})

	if _, err := client.Customers().GetCustomer(context.Background(), "alias with spaces/and-slash"); err != nil {
		t.Fatalf("GetCustomer: %v", err)
	}
	if gotPath != "/api/v1/customers/alias with spaces/and-slash" {
		t.Errorf("decoded path = %q", gotPath)
	}
}

func TestAPIErrorIsReturned(t *testing.T) {
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusNotFound)
		io.WriteString(w, `{"code":"NOT_FOUND","message":"no such customer"}`)
	})

	_, err := client.Customers().GetCustomer(context.Background(), "cust_missing")
	if err == nil {
		t.Fatal("expected an error")
	}

	var apiErr *APIError
	if !errors.As(err, &apiErr) {
		t.Fatalf("error is %T, want *APIError", err)
	}
	if apiErr.StatusCode != http.StatusNotFound {
		t.Errorf("status = %d", apiErr.StatusCode)
	}
	want := RestErrorResponse{Code: ErrorCodeNotFound, Message: "no such customer"}
	if apiErr.Payload == nil || *apiErr.Payload != want {
		t.Errorf("payload = %+v, want %+v", apiErr.Payload, want)
	}
	if apiErr.OAuthPayload != nil {
		t.Errorf("oauth payload = %+v, want nil", apiErr.OAuthPayload)
	}
	if string(apiErr.RawBody) != `{"code":"NOT_FOUND","message":"no such customer"}` {
		t.Errorf("raw body = %q", apiErr.RawBody)
	}
	if got := apiErr.Error(); got != "meteroid: API error (status 404): no such customer (code NOT_FOUND)" {
		t.Errorf("message = %q", got)
	}
}

func TestOAuthErrorIsReturned(t *testing.T) {
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusBadRequest)
		io.WriteString(w, `{"error":"invalid_grant"}`)
	})

	_, err := client.Customers().GetCustomer(context.Background(), "cust_123")

	var apiErr *APIError
	if !errors.As(err, &apiErr) {
		t.Fatalf("error is %T, want *APIError", err)
	}
	if apiErr.StatusCode != http.StatusBadRequest {
		t.Errorf("status = %d", apiErr.StatusCode)
	}
	if apiErr.Payload != nil {
		t.Errorf("payload = %+v, want nil", apiErr.Payload)
	}
	if apiErr.OAuthPayload == nil || apiErr.OAuthPayload.Error != OAuthErrorCodeInvalidGrant {
		t.Fatalf("oauth payload = %+v", apiErr.OAuthPayload)
	}
	if apiErr.OAuthPayload.ErrorDescription != nil || apiErr.OAuthPayload.ErrorUri != nil {
		t.Errorf("optional fields should be nil: %+v", apiErr.OAuthPayload)
	}
	if !strings.Contains(apiErr.Error(), "invalid_grant") {
		t.Errorf("message = %q", apiErr.Error())
	}
}

func TestNonJSONErrorKeepsStatusAndBody(t *testing.T) {
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusBadGateway)
		io.WriteString(w, "<html>Bad Gateway</html>")
	})

	_, err := client.Customers().GetCustomer(context.Background(), "cust_123")

	var apiErr *APIError
	if !errors.As(err, &apiErr) {
		t.Fatalf("error is %T, want *APIError", err)
	}
	if apiErr.StatusCode != http.StatusBadGateway {
		t.Errorf("status = %d", apiErr.StatusCode)
	}
	if apiErr.Payload != nil || apiErr.OAuthPayload != nil {
		t.Errorf("expected no payload, got %+v / %+v", apiErr.Payload, apiErr.OAuthPayload)
	}
	if string(apiErr.RawBody) != "<html>Bad Gateway</html>" {
		t.Errorf("raw body = %q", apiErr.RawBody)
	}
	if !strings.Contains(apiErr.Error(), "Bad Gateway") {
		t.Errorf("message = %q", apiErr.Error())
	}
}

// A 422 goes through the same path as every other status: the API does not
// document one, so a body that is neither error schema has no payload.
func TestUnprocessableEntityUsesTheSamePath(t *testing.T) {
	const body = `{"detail":[{"loc":["body","name"],"msg":"field required","type":"missing"}]}`
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusUnprocessableEntity)
		io.WriteString(w, body)
	})

	_, err := client.Customers().CreateCustomer(context.Background(), CustomerCreateRequest{})

	var apiErr *APIError
	if !errors.As(err, &apiErr) {
		t.Fatalf("error is %T, want *APIError", err)
	}
	if apiErr.StatusCode != http.StatusUnprocessableEntity {
		t.Errorf("status = %d", apiErr.StatusCode)
	}
	if apiErr.Payload != nil || apiErr.OAuthPayload != nil {
		t.Errorf("expected no payload, got %+v / %+v", apiErr.Payload, apiErr.OAuthPayload)
	}
	if string(apiErr.RawBody) != body {
		t.Errorf("raw body = %q", apiErr.RawBody)
	}
}

func TestNewAPIErrorDecoding(t *testing.T) {
	cases := []struct {
		name      string
		body      string
		wantRest  bool
		wantOAuth bool
	}{
		{"rest", `{"code":"CONFLICT","message":"exists"}`, true, false},
		// Error codes are open enums: an unknown code still decodes.
		{"rest unknown code", `{"code":"SOMETHING_NEW","message":"x"}`, true, false},
		{"rest missing message", `{"code":"CONFLICT"}`, false, false},
		{"rest null message", `{"code":"CONFLICT","message":null}`, false, false},
		{"rest wrong type", `{"code":"CONFLICT","message":42}`, false, false},
		{"oauth full", `{"error":"invalid_client","error_description":"bad secret","error_uri":null}`, false, true},
		{"empty object", `{}`, false, false},
		{"array", `[]`, false, false},
		{"empty body", ``, false, false},
	}
	for _, tc := range cases {
		t.Run(tc.name, func(t *testing.T) {
			err := newAPIError(400, []byte(tc.body))
			if (err.Payload != nil) != tc.wantRest {
				t.Errorf("payload = %+v, want present=%v", err.Payload, tc.wantRest)
			}
			if (err.OAuthPayload != nil) != tc.wantOAuth {
				t.Errorf("oauth payload = %+v, want present=%v", err.OAuthPayload, tc.wantOAuth)
			}
			if string(err.RawBody) != tc.body {
				t.Errorf("raw body = %q", err.RawBody)
			}
		})
	}

	if err := newAPIError(400, []byte(`{"code":"SOMETHING_NEW","message":"x"}`)); err.Payload.Code.IsKnown() {
		t.Errorf("code %q should not be known", err.Payload.Code)
	}
}

// 5xx responses are retried; 4xx responses are not.
func TestRetries(t *testing.T) {
	var attempts int
	server := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		attempts++
		if attempts < 3 {
			w.WriteHeader(http.StatusInternalServerError)
			io.WriteString(w, `{"code":"INTERNAL_SERVER_ERROR","message":"transient"}`)
			return
		}
		io.WriteString(w, `{"id":"cust_1","name":"Acme","currency":"EUR","custom_properties":{},"custom_taxes":[],"invoicing_emails":[],"invoicing_entity_id":"inv_1","preferred_locales":[]}`)
	}))
	defer server.Close()

	client := New("test-api-key", &Options{
		ServerURL:     server.URL,
		RetrySchedule: []time.Duration{time.Millisecond, time.Millisecond},
	})

	if _, err := client.Customers().GetCustomer(context.Background(), "cust_1"); err != nil {
		t.Fatalf("GetCustomer: %v", err)
	}
	if attempts != 3 {
		t.Errorf("attempts = %d, want 3", attempts)
	}
}

func TestClientErrorsAreNotRetried(t *testing.T) {
	var attempts int
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		attempts++
		w.WriteHeader(http.StatusBadRequest)
		io.WriteString(w, `{"code":"BAD_REQUEST","message":"nope"}`)
	})

	if _, err := client.Customers().GetCustomer(context.Background(), "cust_1"); err == nil {
		t.Fatal("expected an error")
	}
	if attempts != 1 {
		t.Errorf("attempts = %d, want 1", attempts)
	}
}

func TestContextCancellation(t *testing.T) {
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		<-r.Context().Done()
	})

	ctx, cancel := context.WithTimeout(context.Background(), 20*time.Millisecond)
	defer cancel()

	_, err := client.Customers().GetCustomer(ctx, "cust_1")
	if err == nil {
		t.Fatal("expected the request to fail once the context is cancelled")
	}
	var transportErr *TransportError
	if !errors.As(err, &transportErr) {
		t.Fatalf("error is %T (%v), want *TransportError", err, err)
	}
	if !errors.Is(err, context.DeadlineExceeded) {
		t.Errorf("errors.Is(err, context.DeadlineExceeded) = false for %v", err)
	}
	if transportErr.Method != http.MethodGet || transportErr.Path != "/api/v1/customers/{id_or_alias}" {
		t.Errorf("method/path = %s %s", transportErr.Method, transportErr.Path)
	}
}

// An explicit cancel, both during the round trip and while waiting between
// retries, surfaces as a *TransportError wrapping context.Canceled.
func TestExplicitCancellationIsATransportError(t *testing.T) {
	t.Run("in flight", func(t *testing.T) {
		ctx, cancel := context.WithCancel(context.Background())
		client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
			cancel()
			<-r.Context().Done()
		})

		_, err := client.Customers().GetCustomer(ctx, "cust_1")
		var transportErr *TransportError
		if !errors.As(err, &transportErr) {
			t.Fatalf("error is %T (%v), want *TransportError", err, err)
		}
		if !errors.Is(err, context.Canceled) {
			t.Errorf("errors.Is(err, context.Canceled) = false for %v", err)
		}
	})

	t.Run("between retries", func(t *testing.T) {
		ctx, cancel := context.WithCancel(context.Background())
		server := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			w.WriteHeader(http.StatusServiceUnavailable)
		}))
		defer server.Close()
		client := New("test-api-key", &Options{ServerURL: server.URL, RetrySchedule: []time.Duration{time.Hour}})

		// Cancel once the 503 is back and the client is waiting to retry.
		timer := time.AfterFunc(50*time.Millisecond, cancel)
		defer timer.Stop()

		_, err := client.Customers().GetCustomer(ctx, "cust_1")
		var transportErr *TransportError
		if !errors.As(err, &transportErr) {
			t.Fatalf("error is %T (%v), want *TransportError", err, err)
		}
		if !errors.Is(err, context.Canceled) {
			t.Errorf("errors.Is(err, context.Canceled) = false for %v", err)
		}
	})
}

// A server that cannot be reached is a *TransportError wrapping the net/http
// error, not an *APIError or a *DecodeError.
func TestUnreachableServerIsATransportError(t *testing.T) {
	server := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {}))
	serverURL := server.URL
	server.Close()

	client := New("test-api-key", &Options{ServerURL: serverURL, RetrySchedule: []time.Duration{}})
	_, err := client.Customers().GetCustomer(context.Background(), "cust_1")

	var transportErr *TransportError
	if !errors.As(err, &transportErr) {
		t.Fatalf("error is %T (%v), want *TransportError", err, err)
	}
	var urlErr *url.Error
	if !errors.As(err, &urlErr) {
		t.Errorf("TransportError does not unwrap to the *url.Error: %v", err)
	}
	var apiErr *APIError
	var decodeErr *DecodeError
	if errors.As(err, &apiErr) || errors.As(err, &decodeErr) {
		t.Errorf("transport failure also matched APIError/DecodeError: %v", err)
	}
	if errors.Is(err, context.Canceled) || errors.Is(err, context.DeadlineExceeded) {
		t.Errorf("connection refused reported as a context error: %v", err)
	}
}

// A 2xx response the SDK cannot decode is a *DecodeError carrying the status,
// the raw body and the json error.
func TestUndecodableResponseIsADecodeError(t *testing.T) {
	const body = `{"id":"cust_1","name":42}`
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusCreated)
		io.WriteString(w, body)
	})

	_, err := client.Customers().GetCustomer(context.Background(), "cust_1")

	var decodeErr *DecodeError
	if !errors.As(err, &decodeErr) {
		t.Fatalf("error is %T (%v), want *DecodeError", err, err)
	}
	if decodeErr.StatusCode != http.StatusCreated {
		t.Errorf("status = %d, want %d", decodeErr.StatusCode, http.StatusCreated)
	}
	if string(decodeErr.RawBody) != body {
		t.Errorf("raw body = %s, want %s", decodeErr.RawBody, body)
	}
	var typeErr *json.UnmarshalTypeError
	if !errors.As(err, &typeErr) {
		t.Errorf("DecodeError does not unwrap to the *json.UnmarshalTypeError: %v", err)
	}
	var apiErr *APIError
	var transportErr *TransportError
	if errors.As(err, &apiErr) || errors.As(err, &transportErr) {
		t.Errorf("decode failure also matched APIError/TransportError: %v", err)
	}

	// Malformed JSON too.
	client = testClient(t, func(w http.ResponseWriter, r *http.Request) {
		io.WriteString(w, `<html>not json</html>`)
	})
	_, err = client.Customers().GetCustomer(context.Background(), "cust_1")
	var syntaxErr *json.SyntaxError
	if !errors.As(err, &decodeErr) || decodeErr.StatusCode != http.StatusOK || !errors.As(err, &syntaxErr) {
		t.Errorf("malformed body: error is %T (%v), want *DecodeError wrapping *json.SyntaxError", err, err)
	}
}

func TestWithToken(t *testing.T) {
	var gotAuth string
	client := testClient(t, func(w http.ResponseWriter, r *http.Request) {
		gotAuth = r.Header.Get("Authorization")
		io.WriteString(w, `{"id":"cust_1","name":"Acme","currency":"EUR","custom_properties":{},"custom_taxes":[],"invoicing_emails":[],"invoicing_entity_id":"inv_1","preferred_locales":[]}`)
	})

	if _, err := client.WithToken("other-key").Customers().GetCustomer(context.Background(), "cust_1"); err != nil {
		t.Fatalf("GetCustomer: %v", err)
	}
	if gotAuth != "Bearer other-key" {
		t.Errorf("authorization = %q", gotAuth)
	}
}

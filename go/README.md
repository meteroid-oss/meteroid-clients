# Meteroid Go SDK

Official Go SDK for the [Meteroid](https://meteroid.com) billing API.

Depends on the standard library only.

## Installation

```sh
go get github.com/meteroid-oss/meteroid-clients/go@v0.26.0
```

```go
import meteroid "github.com/meteroid-oss/meteroid-clients/go"
```

The import path ends in `/go`, so the package must be imported with an explicit
name: the package itself is called `meteroid`.

Requires Go 1.22 or later.

## Quick Start

```go
package main

import (
	"context"
	"fmt"
	"log"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

func main() {
	client := meteroid.New("your-api-key", nil)

	customers, err := client.Customers().ListCustomers(context.Background(), nil)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf("Found %d customers\n", customers.PaginationMeta.TotalItems)
	for _, customer := range customers.Data {
		fmt.Printf("- %s (%s)\n", customer.Name, customer.Id)
	}
}
```

## Available APIs

| Accessor                    | Description                       |
| --------------------------- | --------------------------------- |
| `client.Customers()`        | Manage customers                  |
| `client.Subscriptions()`    | Manage subscriptions              |
| `client.Invoices()`         | Access invoices and download PDFs |
| `client.Plans()`            | Manage plans and plan versions    |
| `client.Products()`         | Manage products                   |
| `client.ProductFamilies()`  | Manage product families           |
| `client.AddOns()`           | Manage add-ons                    |
| `client.Coupons()`          | Manage coupons                    |
| `client.CreditNotes()`      | Access credit notes               |
| `client.Events()`           | Send usage events                 |
| `client.Metrics()`          | Manage billable metrics           |
| `client.Usage()`            | Query aggregated usage            |
| `client.Features()`         | Manage features and entitlements  |
| `client.CheckoutSessions()` | Create checkout sessions          |
| `client.CustomProperties()` | Manage custom property definitions|
| `client.BatchJobs()`        | Inspect batch import jobs         |
| `client.Connect()`          | Manage connected accounts         |
| `client.OAuth()`            | OAuth token endpoints             |
| `client.OAuthApps()`        | Manage OAuth applications         |

Every method takes a `context.Context` as its first argument.

## Examples

### Creating a customer

```go
customer, err := client.Customers().CreateCustomer(ctx, meteroid.CustomerCreateRequest{
	Name:            meteroid.Ptr("Acme Corp"),
	Currency:        meteroid.CurrencyEur,
	Alias:           meteroid.Ptr("acme"),
	InvoicingEmails: []string{"billing@acme.com"},
})
if err != nil {
	return err
}
fmt.Println("Created customer:", customer.Id)
```

Optional fields are pointers. Use [`meteroid.Ptr`](#optional-fields) to take the
address of a literal.

### Listing with pagination and filters

```go
page := int32(0)
perPage := int32(10)

customers, err := client.Customers().ListCustomers(ctx, &meteroid.CustomersListCustomersOptions{
	Page:    &page,
	PerPage: &perPage,
	Search:  meteroid.Ptr("acme"),
})
```

The API paginates with `page` / `per_page`; `PaginationMeta` on the response
carries `TotalItems` and `TotalPages` so you can drive the loop yourself.

### Downloading an invoice PDF

```go
pdf, err := client.Invoices().DownloadInvoicePdf(ctx, "invoice_id")
if err != nil {
	return err
}
return os.WriteFile("invoice.pdf", pdf, 0o644)
```

### Sending usage events

```go
_, err := client.Events().IngestEvents(ctx, meteroid.IngestEventsRequest{
	Events: []meteroid.Event{{
		EventId:    "unique_event_id",
		Code:       "api_call",
		CustomerId: "cus_123",
		Timestamp:  time.Now().Format(time.RFC3339),
		Properties: map[string]string{"endpoint": "/api/v1/users"},
	}},
})
```

## Configuration

```go
client := meteroid.New("your-api-key", &meteroid.Options{
	// Self-hosted instance.
	ServerURL: "https://your-meteroid-instance.com",

	// Per-attempt deadline; negative disables it.
	Timeout: 30 * time.Second,

	// Retries on 5xx responses and network errors.
	NumRetries: 3,

	// Or an explicit schedule, which takes precedence over NumRetries.
	// An empty (non-nil) slice disables retries.
	RetrySchedule: []time.Duration{100 * time.Millisecond, 500 * time.Millisecond, time.Second},

	// Bring your own transport.
	HTTPClient: &http.Client{Transport: myTransport},

	// Log one line per request/response to stderr.
	Debug: true,
})
```

`client.WithToken("other-key")` returns a copy that authenticates differently
while reusing the same HTTP client and settings.

A `Client` is safe for concurrent use by multiple goroutines.

## Optional fields

Optional scalars and structs are pointers, so `nil` means "not sent". Since Go
cannot take the address of a literal, the SDK ships a `Ptr` helper:

```go
options := &meteroid.CustomersListCustomersOptions{
	Search:  meteroid.Ptr("acme"),
	PerPage: meteroid.Ptr(int32(10)),
}
```

Slices and maps are never pointers. On an *optional* field, a `nil` slice or map
is omitted from the payload. Fields the API marks required and non-nullable use
the `RequiredSlice[T]` / `RequiredMap[V]` types instead, which serialize a `nil`
value as `[]` / `{}` rather than as `null`, so leaving one unset still produces a
valid request. They are defined types over `[]T` and `map[string]V`: plain slice
and map literals assign to them, and `len`, indexing, `range` and `append` all
work as usual.

Fields the API declares as arbitrary JSON (entitlement JSON config values,
`custom_properties`, `metadata`, custom property `default_value`, ...) are
`json.RawMessage`: the value may be an object, an array, a scalar or `null`, and
it is kept exactly as received. Decode it into the type you expect, and set it
with any JSON you like:

```go
if cfg := value.Config; cfg != nil && cfg.Value.Json != nil {
	var settings struct{ Seats int `json:"seats"` }
	if err := json.Unmarshal(cfg.Value.Json.Value, &settings); err != nil { /* ... */ }
}

props, _ := json.Marshal(map[string]string{"tier": "gold"})
req.CustomProperties = props
```

An unset (`nil`) required one is sent as `null`; an unset optional one is
omitted.

Timestamps are `time.Time` and serialize as RFC 3339.

## Tagged unions

Polymorphic API types (`SubscriptionFee`, `ConfigValue`, `Fee`, …) are structs
carrying a discriminator plus one pointer per variant:

```go
fee := meteroid.NewSubscriptionFeeRate(meteroid.RateFee{Rate: "42.00"})

switch fee.Type {
case meteroid.SubscriptionFeeRate:
	fmt.Println("rate:", fee.Rate.Rate)
case meteroid.SubscriptionFeeUsage:
	fmt.Println("usage metric:", fee.Usage.MetricId)
default:
	// A variant added to the API after this SDK version: every variant pointer
	// is nil. fee.IsKnown() is false and fee.Raw() holds its JSON.
	log.Printf("unhandled fee type %q: %s", fee.Type, fee.Raw())
}
```

A variant this SDK version does not know about decodes without error, so new API
variants never break an older build, but it decodes with **every variant pointer
nil**. Always give such a `switch` a `default:` branch (or check `IsKnown()`
first) rather than dereferencing a pointer unconditionally. Every union has:

- `IsKnown() bool`: false when the discriminator is not one of the union's
  constants;
- `Raw() json.RawMessage`: the JSON of an unknown variant, `nil` for a known one.

An unknown variant also re-encodes with every field and value intact. The
re-encoded bytes are not necessarily identical to the ones received:
`encoding/json` compacts whitespace and escapes `<`, `>` and `&` as `\u003c`,
`\u003e` and `\u0026`.

## Enums

String enums are defined string types with a constant per known value:

```go
if customer.Currency == meteroid.CurrencyEur { /* ... */ }
if !customer.Currency.IsKnown() { /* value added by a newer API version */ }
```

Unknown values decode as-is rather than failing.

## Error handling

A failed call returns one of three error types, all usable with `errors.As`:

| Type                         | When                                                                                     | Carries                                  |
| ---------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------- |
| `*meteroid.APIError`         | Meteroid answered with a non-2xx status                                                  | `StatusCode`, `RawBody`, decoded payload |
| `*meteroid.TransportError`   | No usable response: connection failure, unreadable body, cancelled or timed-out context | `Method`, `Path`, the wrapped `Err`      |
| `*meteroid.DecodeError`      | Meteroid answered 2xx but the SDK could not decode the body                              | `StatusCode`, `RawBody`, the `json` error |

`TransportError` and `DecodeError` wrap their cause, so
`errors.Is(err, context.Canceled)` / `errors.Is(err, context.DeadlineExceeded)`
keep working for cancellation, and `errors.As` reaches the underlying
`*url.Error` or `*json.UnmarshalTypeError`. A `DecodeError` means the request
succeeded on the server: don't blindly retry a non-idempotent call on it.

```go
var (
	transportErr *meteroid.TransportError
	decodeErr    *meteroid.DecodeError
)
switch {
case errors.Is(err, context.Canceled):
	// the caller gave up
case errors.As(err, &transportErr):
	log.Printf("Meteroid unreachable: %v", transportErr.Err)
case errors.As(err, &decodeErr):
	log.Printf("unexpected response (status %d): %s", decodeErr.StatusCode, decodeErr.RawBody)
}
```

Every non-2xx response is returned as a `*meteroid.APIError`:

```go
customer, err := client.Customers().GetCustomer(ctx, "missing")
if err != nil {
	var apiErr *meteroid.APIError
	if errors.As(err, &apiErr) {
		switch {
		case apiErr.Payload != nil: // {"code": ..., "message": ...}
			fmt.Println(apiErr.StatusCode, apiErr.Payload.Code, apiErr.Payload.Message)
		case apiErr.OAuthPayload != nil: // {"error": ..., "error_description": ...}
			fmt.Println(apiErr.StatusCode, apiErr.OAuthPayload.Error)
		default:
			fmt.Printf("status %d: %s\n", apiErr.StatusCode, apiErr.RawBody)
		}
	}
	return err
}
```

The body is decoded as a `RestErrorResponse` (the shape of every documented
error) or, failing that, an `OAuthErrorResponse` (the OAuth endpoints). When it
matches neither, both are nil. `StatusCode` and `RawBody` are always populated,
whatever the status and whatever the body.

`ErrorCode` and `OAuthErrorCode` are open string enums like every other enum in
this SDK: a code added by a newer API version still decodes, and
`apiErr.Payload.Code.IsKnown()` reports `false` for it.

## Webhooks

Meteroid signs webhooks following the
[Standard Webhooks](https://www.standardwebhooks.com) specification. Both the
standard `webhook-*` headers and the Svix-branded `svix-*` headers are accepted.

```go
wh, err := meteroid.NewWebhook(os.Getenv("METEROID_WEBHOOK_SECRET"))
if err != nil {
	log.Fatal(err)
}

http.HandleFunc("/webhooks", func(w http.ResponseWriter, r *http.Request) {
	body, err := io.ReadAll(r.Body)
	if err != nil {
		http.Error(w, "bad request", http.StatusBadRequest)
		return
	}

	if err := wh.Verify(body, r.Header); err != nil {
		http.Error(w, "invalid signature", http.StatusBadRequest)
		return
	}

	// body is authentic; decode and handle it
	w.WriteHeader(http.StatusNoContent)
})
```

Verification enforces a five minute timestamp tolerance.

## Development

The models and resource methods under `go/` are generated from
[`spec/openapi.json`](../spec/openapi.json) by the templates in
`codegen/templates/go/`. Regenerate them from the repository root:

```sh
./regen_openapi.py
```

Do not edit files carrying the generated-file marker comment on their first
line; the regeneration overwrites them.

## License

MIT

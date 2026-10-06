# Meteroid Go SDK

Meteroid billing API client

Requires Go 1.23 or later.

```sh
go get github.com/meteroid-oss/meteroid-clients/go
```

Every method of the API is listed in [api.md](api.md).

## Usage

```go
import meteroid "github.com/meteroid-oss/meteroid-clients/go"

client := meteroid.New("your-api-key", nil)

addOn, err := client.AddOns().Retrieve(ctx, "addon_id")
if err != nil {
	return err
}
fmt.Println(addOn)
```

Every API area hangs off the client as an accessor method, and every method takes a
`context.Context` first. Required parameters are arguments; optional ones go in an options struct
whose fields are pointers (`meteroid.Ptr(v)`), `nil` to send none. Request bodies are
structs of the package:

```go
onboardingLinkResponse, err := client.Connect().CreateOnboardingLink(ctx, "id", meteroid.CreateOnboardingLinkRequest{RedirectURL: "redirect_url"})
```

Models keep the properties this SDK version does not know in `ExtraFields`, and send them back.

### Environment

`New("", nil)` reads the token from `METEROID_API_KEY`, and `METEROID_BASE_URL`
overrides the default server. Explicit arguments win:
`meteroid.New(token, &meteroid.Options{ServerURL: "https://..."})`. When the API
declares no server, `meteroid.DefaultServerURL` is empty and every call fails with a
`*RequestError` naming both settings until one of them is set.

### Errors

Every error is a `meteroid.SDKError`. A non-2xx response is an `*meteroid.APIError`,
whose `Body` is the error body decoded as the schema the operation declares (else plain JSON);
a timeout is a `*TimeoutError`, a failed connection a `*TransportError`, an undecodable response a
`*DecodeError`:

```go
_, err := client.AddOns().Retrieve(ctx, "addon_id")
var apiErr *meteroid.APIError
switch {
case errors.Is(err, meteroid.ErrNotFound):
	// ...
case errors.As(err, &apiErr):
	log.Printf("status %d, request %s", apiErr.StatusCode, apiErr.RequestID())
}
```

### Raw responses

`WithResponseInto` gives the `*http.Response` of a call, for its status and headers:

```go
var resp *http.Response
addOn, err := client.AddOns().Retrieve(ctx, "addon_id", meteroid.WithResponseInto(&resp))
log.Print(resp.Header.Get("X-Request-Id"))
```

### Retries and timeouts

Connection errors, timeouts, 408, 429 and 5xx responses are retried twice with jittered backoff,
honoring `Retry-After` and `retry-after-ms`, when the request is idempotent or carries an
`Idempotency-Key` (POST requests get one). Each attempt times out after `DefaultTimeout`.
`Options` sets them for the client (`MaxRetries`, `Timeout`), and request options for one call:
`meteroid.WithMaxRetries(0)`, `meteroid.WithTimeout(time.Minute)`,
`meteroid.WithIdempotencyKey(key)`, `meteroid.WithHeader(name, value)`.
`Options.Logger` logs every attempt at debug level.

```go
addOn, err := client.AddOns().Retrieve(ctx, "addon_id", meteroid.WithMaxRetries(0), meteroid.WithTimeout(5*time.Second))
```

- Source: https://github.com/meteroid-oss/meteroid-clients
- License: MIT

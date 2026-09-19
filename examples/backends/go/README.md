# Scribe — Go backend

An implementation of [`examples/openapi.yaml`](../../openapi.yaml), written by hand on top of the
[Meteroid Go SDK](../../../go) from this repository. Stack: **`net/http` and the standard library**,
Go ≥ 1.22. The SDK is the only dependency, and it depends on nothing itself — there is no `go.sum`
because there is nothing to checksum.

It is hand-written on purpose. Generated server scaffolding would bury the six Meteroid calls this
demo exists to show under a pile of dispatch code; conformance to the contract is enforced by the
contract suite instead of by a generator. There is no web framework for the same reason: twelve
routes fit in one table ([`app.go`](app.go)), and a handler needs nothing a framework would add —
except the raw body bytes, which frameworks tend to take away.

It mirrors [`../rust`](../rust) and [`../typescript`](../typescript) file for file and behaves
identically: same routes, status codes, error envelope, session tokens, catalog resolution and quota
arithmetic. Reading them side by side shows what changes between languages, which is the SDK call
and nothing else.

---

## Run it

From `examples/`:

```bash
cp .env.example .env          # then fill it in — see below
```

With a Go toolchain (1.22 or later):

```bash
cd backends/go
set -a && . ../../.env && set +a      # export the configuration into your shell
go run .
# Scribe (go) listening on http://localhost:8084
```

Without one, through Docker. The backend depends on the SDK **by path**
(`replace github.com/meteroid-oss/meteroid-clients/go => ../../../go`), the way the Rust backend
uses `path = "../../../rust"`, so whatever builds it has to see the repository root, not just this
directory:

```bash
# from the repository root: build an image (context = the repository root) …
docker build -f examples/backends/go/Dockerfile -t scribe-backend-go .
docker run --rm -p 8084:8084 --env-file examples/.env scribe-backend-go

# … or skip the image and `go run` inside the stock golang one
docker run --rm -p 8084:8084 --env-file examples/.env -u "$(id -u):$(id -g)" \
  -e HOME=/tmp -e GOCACHE=/tmp/gocache -e GOFLAGS=-buildvcs=false \
  -v "$PWD":/w -w /w/examples/backends/go golang:1.24 go run .
```

`--env-file` reads `KEY=value` literally — no quotes, no `export`. Inside a container
`localhost` is the container: to reach a Meteroid running on the host, use `--network host`
instead of `-p 8084:8084`. On an SELinux host, add `:z` to the `-v` mount.

Nothing is hard-coded; every knob is an environment variable.

| Variable | Required | Default | What it is |
| --- | --- | --- | --- |
| `METEROID_API_KEY` | to do anything useful | — | Server-side Meteroid API key. Never reaches the browser. |
| `METEROID_BASE_URL` | no | `https://api.meteroid.com` | Meteroid API base URL. |
| `METEROID_WEBHOOK_SECRET` | for `/api/webhooks/meteroid` | — | Signing secret (`whsec_…`) of the webhook endpoint you created in the dashboard. |
| `SCRIBE_SESSION_SECRET` | **yes** | — | HMAC key for demo session tokens. Not a Meteroid credential. `openssl rand -hex 32`. |
| `SCRIBE_DEFAULT_CURRENCY` | no | `USD` | Currency new demo customers are created with. **Must equal the seeded plans' currency.** |
| `PORT` (or `SCRIBE_PORT`) | no | `8084` | Listen port. `PORT` wins. |

`SCRIBE_SESSION_SECRET` is the only hard requirement to start: a predictable default would let
anyone mint a session token for any workspace, so the process refuses to boot without one. A
missing `METEROID_API_KEY` is a warning rather than a failure — the server still starts so that
`GET /api/health` can tell you `meteroid_configured: false` instead of leaving you to guess from a
wall of 502s. A missing `METEROID_WEBHOOK_SECRET` makes the webhook receiver answer `500 INTERNAL`
rather than pretend every signature is bad.

Share `SCRIBE_SESSION_SECRET` across backends and one session token works against all of them,
which is what lets the contract suite reuse a session when it runs against each backend in turn.

## Before the first request: seed the catalog

The demo **never creates catalog objects.** Features and plan-version entitlements are read-only
over Meteroid's REST API, so the product family, billable metric, four features and three plans are
seeded once, by hand, in the dashboard — see [`examples/CATALOG.md`](../../CATALOG.md).

The backend resolves them at startup and logs exactly what is missing:

```
ERROR Meteroid catalog is not usable yet: No published plan named "Scribe Pro" (plan_code=pro).
Seed the catalog per examples/CATALOG.md.
```

That probe runs once the port is open, so an unreachable Meteroid never holds it closed. Failures
are not cached: seed the tenant while the server is running and the next request picks it up. Until
then, the operations that need the catalog answer `503 CATALOG_NOT_SEEDED` with the same message.

---

## Where to read

One flat `main` package; the files mirror the Rust and TypeScript layout. The handlers are written
so that **the Meteroid SDK call is the line worth reading** and everything around it is framing. In
rough order of interest:

| File | What it shows |
| --- | --- |
| [`routes_transcriptions.go`](routes_transcriptions.go) | The metered action: read the entitlement, gate on the remaining balance, then report consumption with `a.meteroid.Events().IngestEvents(ctx, …)`. This is the demo. |
| [`entitlements.go`](entitlements.go) | Normalizing Meteroid's three-way `EffectiveEntitlementValue` union — a `switch` on `value.Type`, then the one non-nil variant pointer — and the quota arithmetic. |
| [`decimal.go`](decimal.go) | Exact decimal arithmetic on strings. The SDK types every decimal as `string` and, being standard-library only, stops there; this is the ~130 lines of `math/big` you need to subtract two of them. |
| [`catalog.go`](catalog.go) | Resolving a catalog you are not allowed to create, and flattening Meteroid's six-variant `Fee` union into a pricing table. |
| [`routes_webhooks.go`](routes_webhooks.go) | `meteroid.NewWebhook(secret)` then `Verify(body, r.header)` over the **raw** request bytes. |
| [`routes_checkout.go`](routes_checkout.go) | One call to create a hosted checkout session. |
| [`session.go`](session.go) | The demo's stateless session token. Nothing to do with Meteroid; it exists so the demo needs no user database. |
| [`apierror.go`](apierror.go) | Mapping SDK failures onto the contract's one error envelope — `upstream(context, err)` sits in the `if err != nil` under each SDK call and uses `errors.As` on the SDK's `*meteroid.APIError` to separate "your API key is wrong" from "Meteroid is throttling". |
| [`dto.go`](dto.go) | The wire types, and the hand-written request decoders. |
| [`app.go`](app.go) | The route table, CORS, the bare `405`, the 2 MiB body limit, and turning every error — a panic included — into the envelope. |

Every SDK call takes the request's `context.Context`, so a client that goes away cancels the
Meteroid calls made on its behalf.

Five things are worth calling out because they are easy to get subtly wrong in Go specifically:

**Decimals are strings, end to end — and never a `float64`.** Every Meteroid `format: decimal` value
stays a `string` on the wire and goes through `big.Int` in arithmetic. `strconv.ParseFloat` anywhere
in a quota calculation is how a 0.1-minute clip eventually bills wrong. There is no `float64` in
this backend.

**A nil slice is `null`, and `omitempty` is an absent key.** The contract says nullable means
present-and-null and a list is always a list. So no response field carries `omitempty` (a nil
pointer is then written as `null`), and every list in `dto.go` is a `meteroid.RequiredSlice[T]` —
the SDK's own fix for `encoding/json` writing a nil slice as `null` — so a fresh workspace's
`{"transcriptions": []}` cannot come out as `{"transcriptions": null}`.

**`DisallowUnknownFields` is not as strict as it sounds.** `encoding/json` matches object keys
case-insensitively (`{"TITLE": …}` fills a field tagged `title`), treats `null` for a non-pointer
field as a silent no-op (`{"title": null}` decodes as `""`), and a `Decoder` stops after the first
value, so `{…} trailing` passes. The decoders at the bottom of `dto.go` therefore read untyped JSON
with `UseNumber`, check it key by key, and refuse anything after the value: no coercion, no unknown
keys, integers are integers.

**`encoding/json` escapes `<` and `>`.** `Missing Authorization: Bearer <session_token> header.`
would go out as `Bearer <session_token>`. Same JSON, but these messages are meant to be
read, so `writeJSON` turns `SetEscapeHTML` off.

**Verify webhooks over the raw bytes.** The handler passes the request's bytes straight to the SDK
and only then parses them. `Verify` answers "authentic", not "JSON", so the parse is the receiver's
job — and a correctly signed body that is not JSON is the same `400` as a bad signature.

### Why a route table and not `http.ServeMux`

Go 1.22's method patterns (`mux.HandleFunc("POST /api/checkout", …)`) would route this API, but the
contract pins down the edges a mux decides for itself, and the other backends already agree on them:

* an unknown path is `404` in the error envelope — `ServeMux` answers `/api//health` with a `301` to
  the cleaned path instead;
* a known path with the wrong method is a bare `405` with `Allow: GET,HEAD` and no body — `ServeMux`
  writes `Allow: GET, HEAD` and a `Method Not Allowed` text body;
* every `OPTIONS`, known path or not, is a CORS preflight.

So `app.go` matches `r.URL.EscapedPath()` exactly against a map, as the TypeScript backend does.

---

## Tests

```bash
go test ./...                                   # 65 tests, offline
go vet ./... && test -z "$(gofmt -l .)"         # the lint the Makefile runs
```

or, without a Go toolchain, from the repository root:

```bash
docker run --rm -u "$(id -u):$(id -g)" -e HOME=/tmp -e GOCACHE=/tmp/gocache -e GOFLAGS=-buildvcs=false \
  -v "$PWD":/w -w /w/examples/backends/go golang:1.24 \
  sh -c 'test -z "$(gofmt -l .)" && go vet ./... && go test ./...'
```

65 tests, none of which need a Meteroid tenant or a network. Like the other backends', they cover
the parts of the contract that are reachable offline — health, the session-token gate, the error
envelope, the 404 fallback, strict request validation, quota arithmetic, decimal rounding, response
nullability — plus the whole webhook path, which works offline because the SDK ships a **signer** as
well as a verifier.

They are split the way the TypeScript backend's are:

* [`api_test.go`](api_test.go) drives the router through `httptest.NewRecorder` — no socket.
* [`units_test.go`](units_test.go) covers the pure pieces, including the session token pinned to
  the same literal the TypeScript tests pin, so a change to either side is caught.
* [`meteroid_test.go`](meteroid_test.go) puts a stub `http.RoundTripper` under the *real* SDK
  (`meteroid.Options.HTTPClient`) and drives the metered action through its `201` / `402` / `403` /
  `503` outcomes — asserting, among other things, that a refused request ingests no event — and the
  catalog through resolution, exact-name matching and caching. Those stubs are hand-written wire
  JSON, not recorded responses, so they prove the handlers and the SDK's decoders agree with each
  other, not that either agrees with a live Meteroid.

Everything that actually talks to Meteroid is exercised by [`examples/tests/contract`](../../tests)
against a live tenant, not here.

---

## Notes and known rough edges

* **Plans are resolved by exact name.** Meteroid plans carry no user-supplied code, and
  `GET /api/v1/plans?search=` is a fuzzy match, so `catalog.go` filters on exact name equality
  against the names in `CATALOG.md`. Renaming a plan in the dashboard breaks the demo with
  `CATALOG_NOT_SEEDED`.
* **Usage counters are eventually consistent.** The `quota` in a `201` from `POST /api/transcriptions`
  is this backend's optimistic projection of the entitlement it just read. `GET /api/usage` is the
  authority once it catches up, and may briefly disagree.
* **The 402 path needs a finite limit.** On a plan whose `transcription_minutes` entitlement is
  unlimited, `QUOTA_EXHAUSTED` is unreachable by construction — test it on a `free` workspace.
* **The webhook envelope is unverified.** Meteroid publishes no schema for webhook payloads
  anywhere in `spec/openapi.json`, so the receiver reads `id` and `type` if they are there and
  acknowledges everything else with `handled: false`. It never rejects a correctly signed body for
  its shape.
* **Timestamps are re-rendered, but faithfully.** The SDK parses every `date-time` into a
  `time.Time`, which keeps Meteroid's offset and sub-second digits, and `time.RFC3339Nano` writes
  them back: `2026-10-01T00:00:00Z` stays exactly that, where the TypeScript backend's
  `toISOString()` makes it `…00.000Z`. Only trailing fractional zeros are lost (`.500Z` → `.5Z`).
* **`60.0` is an integer here**, as in the TypeScript backend and as JSON Schema defines
  `type: integer`; serde rejects it, so this is a place the Rust backend differs. `big.Rat` decides
  it exactly, so `60.00000000000000001` is still refused.
* **An unknown union variant is an upstream error.** The SDK decodes a `Fee`, entitlement or config
  variant it has never heard of without failing (tag set, every variant pointer nil). The
  contract's unions are closed, so there is nothing truthful to project such a value onto and it
  becomes `502 UPSTREAM_ERROR` naming the tag, rather than a nil dereference or a silent skip.
* **Wrong method and oversized body.** A known path with the wrong method is a bare `405` with an
  `Allow` header, exactly as the other backends answer it; the contract has no error code for it. A
  body over 2 MiB is `413` in the standard envelope (`BAD_REQUEST`).

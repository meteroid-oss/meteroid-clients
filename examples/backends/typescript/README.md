# Scribe — TypeScript backend

An implementation of [`examples/openapi.yaml`](../../openapi.yaml), written by hand on top of the
[`@meteroid/sdk`](../../../typescript) TypeScript SDK from this repository. Stack: **plain
`node:http`**, strict TypeScript, ESM, Node ≥ 20. The SDK is the only runtime dependency.

It is hand-written on purpose. Generated server scaffolding would bury the six Meteroid calls this
demo exists to show under a pile of dispatch code; conformance to the contract is enforced by the
contract suite instead of by a generator. There is no web framework for the same reason: twelve
routes fit in one table ([`app.ts`](src/app.ts)), and a handler needs nothing a framework would add
— except the raw body bytes, which frameworks tend to take away.

It mirrors [`../rust`](../rust) file for file and behaves identically: same routes, status codes,
error envelope, session tokens, catalog resolution and quota arithmetic. Reading the two side by
side shows what changes between languages, which is the SDK call and nothing else.

---

## Run it

From `examples/`:

```bash
cp .env.example .env          # then fill it in — see below
make run-typescript
# Scribe (typescript) listening on http://localhost:8082
```

`make` handles the one wrinkle: the backend depends on the SDK **by path**
(`"@meteroid/sdk": "file:../../../typescript"`), the way the Rust backend uses
`path = "../../../rust"` — but an npm package is imported through its compiled `dist/`, which is
build output and not committed. So the SDK has to be installed and built once before the backend can
import it. Without `make`:

```bash
npm run build:sdk                     # npm ci + tsc in ../../../typescript; writes only ignored files
npm ci
set -a && . ../../.env && set +a      # export the configuration into your shell
npm start                             # tsx src/main.ts
```

Nothing is hard-coded; every knob is an environment variable.

| Variable | Required | Default | What it is |
| --- | --- | --- | --- |
| `METEROID_API_KEY` | to do anything useful | — | Server-side Meteroid API key. Never reaches the browser. |
| `METEROID_BASE_URL` | no | `https://api.meteroid.com` | Meteroid API base URL. |
| `METEROID_WEBHOOK_SECRET` | for `/api/webhooks/meteroid` | — | Signing secret (`whsec_…`) of the webhook endpoint you created in the dashboard. |
| `SCRIBE_SESSION_SECRET` | **yes** | — | HMAC key for demo session tokens. Not a Meteroid credential. `openssl rand -hex 32`. |
| `SCRIBE_DEFAULT_CURRENCY` | no | `USD` | Currency new demo customers are created with. **Must equal the seeded plans' currency.** |
| `PORT` (or `SCRIBE_PORT`) | no | `8082` | Listen port. `PORT` wins. |

`SCRIBE_SESSION_SECRET` is the only hard requirement to start: a predictable default would let
anyone mint a session token for any workspace, so the process refuses to boot without one. A
missing `METEROID_API_KEY` is a warning rather than a failure — the server still starts so that
`GET /api/health` can tell you `meteroid_configured: false` instead of leaving you to guess from a
wall of 502s. A missing `METEROID_WEBHOOK_SECRET` makes the webhook receiver answer `500 INTERNAL`
rather than pretend every signature is bad.

Share `SCRIBE_SESSION_SECRET` across backends and one session token works against all of them,
which is what lets the contract suite reuse a session when it runs against Rust, Java and
TypeScript in turn.

## Before the first request: seed the catalog

The demo **never creates catalog objects.** Features and plan-version entitlements are read-only
over Meteroid's REST API, so the product family, billable metric, four features and three plans are
seeded once, by hand, in the dashboard — see [`examples/CATALOG.md`](../../CATALOG.md).

The backend resolves them at startup and logs exactly what is missing:

```
ERROR scribe_backend: Meteroid catalog is not usable yet: No published plan named "Scribe Pro"
(plan_code=pro). Seed the catalog per examples/CATALOG.md.
```

That probe runs once the port is open, so an unreachable Meteroid never holds it closed. Failures
are not cached: seed the tenant while the server is running and the next request picks it up. Until
then, the operations that need the catalog answer `503 CATALOG_NOT_SEEDED` with the same message.

---

## Where to read

The handlers are written so that **the Meteroid SDK call is the line worth reading** and everything
around it is framing. In rough order of interest:

| File | What it shows |
| --- | --- |
| [`routes/transcriptions.ts`](src/routes/transcriptions.ts) | The metered action: read the entitlement, gate on the remaining balance, then report consumption with `meteroid.events.ingestEvents(…)`. This is the demo. |
| [`entitlements.ts`](src/entitlements.ts) | Normalizing Meteroid's three-way `EffectiveEntitlementValue` union — a `switch` on `value.type` that the compiler checks for exhaustiveness — and the quota arithmetic. |
| [`decimal.ts`](src/decimal.ts) | Exact decimal arithmetic on strings. The SDK types every decimal as `string` and stops there; this is the ~80 lines you need to subtract two of them. |
| [`catalog.ts`](src/catalog.ts) | Resolving a catalog you are not allowed to create, and flattening Meteroid's six-variant `Fee` union into a pricing table. |
| [`routes/webhooks.ts`](src/routes/webhooks.ts) | `new Webhook(secret).verify(rawBody, headers)` verifying a Standard Webhooks signature over the **raw** request bytes. |
| [`routes/checkout.ts`](src/routes/checkout.ts) | One call to create a hosted checkout session. |
| [`session.ts`](src/session.ts) | The demo's stateless session token. Nothing to do with Meteroid; it exists so the demo needs no user database. |
| [`error.ts`](src/error.ts) | Mapping SDK failures onto the contract's one error envelope — `upstream(context)` sits in the `.catch(…)` under each SDK call and separates "your API key is wrong" from "Meteroid is throttling". |
| [`dto.ts`](src/dto.ts) | The wire types, and the hand-written request decoders: `JSON.parse` validates nothing, so unknown keys and wrong scalar types are rejected here. |

Four things are worth calling out because they are easy to get subtly wrong in TypeScript
specifically:

**Decimals are strings, end to end — and never a `number`.** Every Meteroid `format: decimal` value
stays a `string` on the wire and goes through `bigint` in arithmetic. `Number("0.1") + Number("0.2")`
anywhere in a quota calculation is how a 0.1-minute clip eventually bills wrong.

**Nullable means present-and-null — and `undefined` is the enemy.** The SDK leaves an absent optional
field `undefined`, and `JSON.stringify` silently drops an `undefined` key. No response type in
`dto.ts` declares a property with `?`, and `exactOptionalPropertyTypes` is on, so a projection that
forgets its `?? null` does not compile.

**`JSON.parse` does not validate.** `{"title": 123}` parses fine and a careless handler would
forward it. The decoders at the bottom of `dto.ts` are this backend's `deny_unknown_fields`: no
coercion, no unknown keys, integers are integers.

**Verify webhooks over the raw bytes.** The handler passes the request `Buffer` straight to the SDK.
Parsing the JSON and re-serializing it before verifying is the classic bug — and the usual way to
hit it in Node is a body-parsing middleware that ran first. There is none here to forget about.

---

## Tests

```bash
npm test             # node:test, through tsx
npm run typecheck    # tsc --noEmit over src/ and test/
```

57 tests, none of which need a Meteroid tenant or a network. Like the Rust backend's, they cover the
parts of the contract that are reachable offline — health, the session-token gate, the error
envelope, the 404 fallback, strict request validation, quota arithmetic, decimal rounding, response
nullability — plus the whole webhook path, which works offline because the SDK ships a **signer** as
well as a verifier.

They also go one step further than the Rust ones can cheaply go: the SDK accepts a custom `fetch`,
so [`test/meteroid.test.ts`](test/meteroid.test.ts) puts a stubbed Meteroid under the *real* SDK and
drives the metered action through its `201` / `402` / `403` / `503` outcomes — asserting, among
other things, that a refused request ingests no event. Those stubs are hand-written wire JSON, not
recorded responses, so they prove the handlers and the SDK's deserializers agree with each other,
not that either agrees with a live Meteroid.

Everything that actually talks to Meteroid is exercised by [`examples/tests/contract`](../../tests)
against a live tenant, not here.

---

## Notes and known rough edges

* **Plans are resolved by exact name.** Meteroid plans carry no user-supplied code, and
  `GET /api/v1/plans?search=` is a fuzzy match, so `catalog.ts` filters on exact name equality
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
* **Timestamps are re-rendered.** The SDK parses every `date-time` into a `Date`, so
  `subscription.created_at`, `reset_at` and `expires_at` come back out through `toISOString()` —
  always UTC, always milliseconds — where the Rust backend passes Meteroid's string through
  untouched. Same instant, not always the same text.
* **`60.0` is an integer here.** `JSON.parse` cannot tell `60` from `60.0`, so
  `{"duration_seconds": 60.0}` is accepted where serde rejects it. JSON Schema agrees with
  `JSON.parse` — `60.0` *is* a valid `type: integer` — so this is the contract's reading, but it is
  a place the two backends differ.
* **Wrong method and oversized body.** A known path with the wrong method is a bare `405` with an
  `Allow` header, exactly as axum answers it; the contract has no error code for it. A body over
  2 MiB is `413` in the standard envelope (`BAD_REQUEST`), where axum answers in plain text.

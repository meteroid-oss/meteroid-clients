# Scribe — Rust backend

The reference implementation of [`examples/openapi.yaml`](../../openapi.yaml), written by hand on
top of the [`meteroid-rs`](../../../rust) SDK from this repository. Stack: **axum + tokio**, the
default choice for an async HTTP service in Rust.

It is hand-written on purpose. Generated server scaffolding would bury the six Meteroid calls this
demo exists to show under a pile of dispatch code; conformance to the contract is enforced by the
contract suite instead of by a generator.

---

## Run it

```bash
cp ../../.env.example ../../.env      # then fill it in — see below
set -a && . ../../.env && set +a      # export it into your shell
cargo run
# Scribe (rust) listening on http://localhost:8080
```

Nothing is hard-coded; every knob is an environment variable.

| Variable | Required | Default | What it is |
| --- | --- | --- | --- |
| `METEROID_API_KEY` | to do anything useful | — | Server-side Meteroid API key. Never reaches the browser. |
| `METEROID_BASE_URL` | no | `https://api.meteroid.com` | Meteroid API base URL. |
| `METEROID_WEBHOOK_SECRET` | for `/api/webhooks/meteroid` | — | Signing secret (`whsec_…`) of the webhook endpoint you created in the dashboard. |
| `SCRIBE_SESSION_SECRET` | **yes** | — | HMAC key for demo session tokens. Not a Meteroid credential. `openssl rand -hex 32`. |
| `SCRIBE_DEFAULT_CURRENCY` | no | `USD` | Currency new demo customers are created with. **Must equal the seeded plans' currency.** |
| `PORT` (or `SCRIBE_PORT`) | no | `8080` | Listen port. `PORT` wins. |

`SCRIBE_SESSION_SECRET` is the only hard requirement to start: a predictable default would let
anyone mint a session token for any workspace, so the process refuses to boot without one. A
missing `METEROID_API_KEY` is a warning rather than a failure — the server still starts so that
`GET /api/health` can tell you `meteroid_configured: false` instead of leaving you to guess from a
wall of 502s.

Share `SCRIBE_SESSION_SECRET` across backends and one session token works against all of them,
which is what lets the contract suite reuse a session when it runs against Rust, Java and
TypeScript in turn.

## Before the first request: seed the catalog

The demo **never creates catalog objects.** Features and plan-version entitlements are read-only
over Meteroid's REST API, so the product family, billable metric, four features and three plans are
seeded once, by hand, in the dashboard — see [`examples/CATALOG.md`](../../CATALOG.md).

The backend resolves them at startup and logs exactly what is missing:

```
ERROR scribe_backend: Meteroid catalog is not usable yet: CatalogNotSeeded: No published plan
named "Scribe Pro" (plan_code=pro). Seed the catalog per examples/CATALOG.md.
```

That probe runs in the background, so an unreachable Meteroid never holds the port closed. Failures
are not cached: seed the tenant while the server is running and the next request picks it up. Until
then, the operations that need the catalog answer `503 CATALOG_NOT_SEEDED` with the same message.

---

## Where to read

The handlers are written so that **the Meteroid SDK call is the line worth reading** and everything
around it is framing. In rough order of interest:

| File | What it shows |
| --- | --- |
| [`routes/transcriptions.rs`](src/routes/transcriptions.rs) | The metered action: read the entitlement, gate on the remaining balance, then report consumption with `events().ingest_events(…)`. This is the demo. |
| [`entitlements.rs`](src/entitlements.rs) | Normalizing Meteroid's three-way `EffectiveEntitlementValue` union, and the exact-decimal quota arithmetic. |
| [`catalog.rs`](src/catalog.rs) | Resolving a catalog you are not allowed to create, and flattening Meteroid's six-variant `Fee` union into a pricing table. |
| [`routes/webhooks.rs`](src/routes/webhooks.rs) | `meteroid_rs::webhooks::Webhook` verifying a Standard Webhooks signature over the **raw** request bytes. |
| [`routes/checkout.rs`](src/routes/checkout.rs) | One call to create a hosted checkout session. |
| [`session.rs`](src/session.rs) | The demo's stateless session token. Nothing to do with Meteroid; it exists so the demo needs no user database. |
| [`error.rs`](src/error.rs) | Mapping SDK failures onto the contract's one error envelope — the bit that separates "your API key is wrong" from "Meteroid is throttling". |

Three things are worth calling out because they are easy to get subtly wrong:

**Decimals are strings, end to end.** Every Meteroid `format: decimal` value stays a `String` on
the wire and a `rust_decimal::Decimal` in arithmetic. A `f64` anywhere in a quota calculation is
how a 0.1-minute clip eventually bills wrong.

**Nullable means present-and-null.** No `skip_serializing_if` appears anywhere in `dto.rs`: every
response serializes every key, `null` where the value is absent, so a strict deserializer on the
other side never has to tell "missing" from "null". `contract_samples.rs` fails the build if that
ever regresses.

**Verify webhooks over the raw bytes.** The handler takes `Bytes`, not `Json<T>`. Parsing the JSON
and re-serializing it before verifying is the classic bug: any difference in key order or spacing
breaks the signature.

---

## Tests

```bash
cargo test
cargo clippy --all-targets -- -D warnings
```

28 tests, none of which need a Meteroid tenant. They cover the parts of the contract that are
reachable offline — health, the session-token gate, the error envelope, the 404 fallback, quota
arithmetic, decimal rounding, response nullability — plus the whole webhook path, which works
offline because the SDK ships a **signer** as well as a verifier, so a test can produce a validly
signed payload.

Everything that actually talks to Meteroid is exercised by [`examples/tests/contract`](../../tests)
against a live tenant, not here.

To re-check the serialized shapes against the contract itself:

```bash
SCRIBE_SAMPLE_OUT=/tmp/samples.json cargo test dumps_one_sample_per_response_schema
# then validate /tmp/samples.json against examples/openapi.yaml with any JSON Schema tool
```

---

## Notes and known rough edges

* **Plans are resolved by exact name.** Meteroid plans carry no user-supplied code, and
  `GET /api/v1/plans?search=` is a fuzzy match, so `catalog.rs` filters on exact name equality
  against the names in `CATALOG.md`. Renaming a plan in the dashboard breaks the demo with
  `CATALOG_NOT_SEEDED`. If Meteroid ever adds a plan code, this is the first thing to switch over.
* **Usage counters are eventually consistent.** The `quota` in a `201` from `POST /api/transcriptions`
  is this backend's optimistic projection of the entitlement it just read. `GET /api/usage` is the
  authority once it catches up, and may briefly disagree.
* **The 402 path needs a finite limit.** On a plan whose `transcription_minutes` entitlement is
  unlimited, `QUOTA_EXHAUSTED` is unreachable by construction — test it on a `free` workspace.
* **The webhook envelope is unverified.** Meteroid publishes no schema for webhook payloads
  anywhere in `spec/openapi.json`, so the receiver reads `id` and `type` if they are there and
  acknowledges everything else with `handled: false`. It never rejects a correctly signed body for
  its shape.

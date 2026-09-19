# Scribe — Java backend

The Java implementation of [`examples/openapi.yaml`](../../openapi.yaml), written by hand on top of
the [`meteroid-java`](../../../java) SDK from this repository. Stack: **Javalin 6** (Jetty
underneath) — a route is a lambda, so nothing stands between you and the Meteroid SDK call.

It is hand-written on purpose. Generated server scaffolding would bury the six Meteroid calls this
demo exists to show under a pile of dispatch code; conformance to the contract is enforced by the
contract suite instead of by a generator.

The file layout deliberately mirrors [`backends/rust/src/`](../rust/src), so you can read the two
side by side and see the same shape in two languages:

| Rust | Java |
| --- | --- |
| `src/main.rs` | `com/scribe/Main.java` |
| `src/config.rs` | `com/scribe/Config.java` |
| `src/state.rs` | `com/scribe/AppState.java` |
| `src/dto.rs` | `com/scribe/Dto.java` + `PlanCode.java` |
| `src/error.rs` | `com/scribe/ApiError.java` + `ErrorCode.java` + `Upstream.java` |
| `src/session.rs` | `com/scribe/SessionToken.java` |
| `src/catalog.rs` | `com/scribe/Catalog.java` + `CatalogCache.java` + `MetricCache.java` |
| `src/entitlements.rs` | `com/scribe/Entitlements.java` |
| `src/workspace.rs` | `com/scribe/Workspaces.java` |
| `src/routes/*.rs` | `com/scribe/routes/*Routes.java` |

---

## Run it

```bash
cp ../../.env.example ../../.env      # then fill it in — see below
set -a && . ../../.env && set +a      # export it into your shell
PORT=8081 ./gradlew run
# Scribe (java) listening on http://localhost:8081
```

The SDK is wired as a Gradle **composite build** — `settings.gradle` does
`includeBuild('../../../java')` with an explicit dependency substitution onto
`com.meteroid:meteroid`. There is nothing to publish or install first: edit the SDK and this example
picks the change up on the next build, exactly like the Rust backend's `path = "../../../rust"`.

Requires **JDK 17 or newer** (Javalin 6's floor). There is no toolchain block, so the build uses
whatever JDK you already have.

Nothing is hard-coded; every knob is an environment variable, and they are the same ones the Rust
backend reads, so one `.env` drives either.

| Variable | Required | Default | What it is |
| --- | --- | --- | --- |
| `METEROID_API_KEY` | to do anything useful | — | Server-side Meteroid API key. Never reaches the browser. |
| `METEROID_BASE_URL` | no | `https://api.meteroid.com` | Meteroid API base URL. |
| `METEROID_WEBHOOK_SECRET` | for `/api/webhooks/meteroid` | — | Signing secret (`whsec_…`) of the webhook endpoint you created in the dashboard. |
| `SCRIBE_SESSION_SECRET` | **yes** | — | HMAC key for demo session tokens. Not a Meteroid credential. `openssl rand -hex 32`. |
| `SCRIBE_DEFAULT_CURRENCY` | no | `USD` | Currency new demo customers are created with. **Must equal the seeded plans' currency.** |
| `PORT` (or `SCRIBE_PORT`) | no | `8081` | Listen port. `PORT` wins. |

`SCRIBE_SESSION_SECRET` is the only hard requirement to start: a predictable default would let
anyone mint a session token for any workspace, so the process refuses to boot without one. A missing
`METEROID_API_KEY` is a warning rather than a failure — the server still starts so that
`GET /api/health` can tell you `meteroid_configured: false` instead of leaving you to guess from a
wall of 502s.

Share `SCRIBE_SESSION_SECRET` across backends and one session token works against all of them.
The token format is fixed by the contract (`v1.<b64url(alias)>.<b64url(hmac_sha256(secret, alias))>`),
so a session minted by the Rust backend is accepted here and vice versa — which is what lets the
contract suite reuse one session when it runs against Rust, then Java, then TypeScript.

## Before the first request: seed the catalog

The demo **never creates catalog objects.** Features and plan-version entitlements are read-only over
Meteroid's REST API, so the product family, billable metric, four features and three plans are seeded
once, by hand, in the dashboard — see [`examples/CATALOG.md`](../../CATALOG.md).

The backend resolves them at startup and logs exactly what is missing:

```
ERROR com.scribe.Main - Meteroid catalog is not usable yet: No published plan named "Scribe Pro"
(plan_code=pro). Seed the catalog per examples/CATALOG.md.
```

That probe runs on a daemon thread, so an unreachable Meteroid never holds the port closed. Failures
are not cached: seed the tenant while the server is running and the next request picks it up. Until
then, the operations that need the catalog answer `503 CATALOG_NOT_SEEDED` with the same message.

---

## Where to read

The handlers are written so that **the Meteroid SDK call is the line worth reading** and everything
around it is framing. In rough order of interest:

| File | What it shows |
| --- | --- |
| [`routes/TranscriptionRoutes.java`](src/main/java/com/scribe/routes/TranscriptionRoutes.java) | The metered action: read the entitlement, gate on the remaining balance, then report consumption with `getEvents().ingestEvents(…)`. This is the demo. |
| [`Entitlements.java`](src/main/java/com/scribe/Entitlements.java) | Normalizing Meteroid's three-way `EffectiveEntitlementValue` union, and the exact-decimal quota arithmetic. |
| [`Catalog.java`](src/main/java/com/scribe/Catalog.java) | Resolving a catalog you are not allowed to create, and flattening Meteroid's six-variant `Fee` union into a pricing table. |
| [`routes/WebhookRoutes.java`](src/main/java/com/scribe/routes/WebhookRoutes.java) | `com.meteroid.Webhook` verifying a Standard Webhooks signature over the **raw** request body. |
| [`routes/CheckoutRoutes.java`](src/main/java/com/scribe/routes/CheckoutRoutes.java) | One call to create a hosted checkout session. |
| [`SessionToken.java`](src/main/java/com/scribe/SessionToken.java) | The demo's stateless session token. Nothing to do with Meteroid; it exists so the demo needs no user database. |
| [`Upstream.java`](src/main/java/com/scribe/Upstream.java) + [`ApiError.java`](src/main/java/com/scribe/ApiError.java) | Mapping SDK failures onto the contract's one error envelope — the bit that separates "your API key is wrong" from "Meteroid is throttling". |

Four things are worth calling out because they are easy to get subtly wrong.

**Decimals are strings, end to end.** Every Meteroid `format: decimal` value stays a `String` on the
wire and a `java.math.BigDecimal` in arithmetic. A `double` anywhere in a quota calculation is how a
0.1-minute clip eventually bills wrong. Note `Dto.decimal` uses `stripTrailingZeros().toPlainString()`,
not `toString()`: the latter renders a stripped `600` as `6E+2`, which the contract's `Decimal`
pattern rejects.

**Nullable means present-and-null.** The `ObjectMapper` in [`Json.java`](src/main/java/com/scribe/Json.java)
is deliberately left at Jackson's default inclusion, so every response serializes every key, `null`
where the value is absent. A stray `@JsonInclude(NON_NULL)` would silently drop keys and break a
strict client; `ContractSamplesTest` fails the build if that ever regresses.

**Verify webhooks over the raw body.** The handler reads `ctx.body()` and hands those exact
characters to the verifier. Parsing the JSON and re-serializing it first is the classic bug — any
difference in key order or spacing breaks the signature — and there is a test that signs one
spelling and posts another to prove the receiver notices.

**Checked exceptions live in one place.** Every SDK method declares `IOException` and `ApiException`.
Rather than repeat that `try/catch` in ten handlers, calls go through `Upstream.call("GET /api/v1/plans", …)`,
which names the Meteroid endpoint for the operator-facing error message. It is the Java shape of the
Rust backend's `error::upstream`.

**On the SDK facade:** `com.meteroid.Meteroid` declares its API groups as private fields, but the
class carries Lombok's `@Getter`, so `meteroid.getCustomers()`, `getPlans()`, `getEvents()` and the
rest are all generated and public. (The `meteroid.getCustomer()` in the SDK's own javadoc is a typo —
the getter is named after the field, so every group is plural.) There is no need to construct
`Customers`/`Plans` by hand or to build the `Authorization` header yourself.

---

## Tests

```bash
./gradlew test
```

40 tests, none of which need a Meteroid tenant. They cover the parts of the contract that are
reachable offline — health, the session-token gate, request validation, the error envelope, the 404
fallback, quota arithmetic, decimal rounding, response nullability — plus the whole webhook path,
which works offline because the SDK ships a **signer** as well as a verifier, so a test can produce a
validly signed payload.

Everything that actually talks to Meteroid is exercised by [`examples/tests/contract`](../../tests)
against a live tenant, not here.

To re-check the serialized shapes against the contract itself:

```bash
SCRIBE_SAMPLE_OUT=/tmp/samples.json ./gradlew cleanTest test --tests '*ContractSamplesTest*'
# then validate /tmp/samples.json against examples/openapi.yaml with any JSON Schema tool
```

Compilation runs with `-Xlint:all -Werror`, the moral equivalent of the Rust backend's
`cargo clippy -D warnings`.

---

## Notes and known rough edges

* **Plans are resolved by exact name.** Meteroid plans carry no user-supplied code, and
  `GET /api/v1/plans?search=` is a fuzzy match, so `Catalog.java` filters on exact name equality
  against the names in `CATALOG.md`. Renaming a plan in the dashboard breaks the demo with
  `CATALOG_NOT_SEEDED`. If Meteroid ever adds a plan code, this is the first thing to switch over.
* **Usage counters are eventually consistent.** The `quota` in a `201` from
  `POST /api/transcriptions` is this backend's optimistic projection of the entitlement it just read.
  `GET /api/usage` is the authority once it catches up, and may briefly disagree.
* **The 402 path needs a finite limit.** On a plan whose `transcription_minutes` entitlement is
  unlimited, `QUOTA_EXHAUSTED` is unreachable by construction — test it on a `free` workspace.
* **The webhook envelope is unverified.** Meteroid publishes no schema for webhook payloads anywhere
  in `spec/openapi.json`, so the receiver reads `id` and `type` if they are there and acknowledges
  everything else with `handled: false`. It never rejects a correctly signed body for its shape.
* **`GET /api/transcriptions` is per-process memory.** Restarting the backend empties it; the usage
  it reported to Meteroid survives.
* **`standardwebhooks` is declared here, not inherited.** `com.meteroid.Webhook.verify` throws
  `WebhookVerificationException`, which lives in that library, but the SDK depends on it with
  `implementation` — so a consumer that needs to *catch* it has to declare the dependency itself.
  `build.gradle` pins the same version the SDK uses.

# Scribe — a Meteroid SDK example app

**Scribe** is a fictional metered AI transcription SaaS. It exists to show what using Meteroid
actually looks like end to end: a pricing table, self-serve checkout, feature gating against live
entitlements, usage reporting, a customer portal, invoices, and a signed webhook receiver.

It is designed once and implemented N times — one backend per SDK, behind one shared HTTP contract.

```
                    ┌──────────────► backends/rust        :8080 ──┐
                    ├──────────────► backends/java        :8081 ──┤
one SPA ──► BASE_URL ├──────────────► backends/typescript  :8082 ──┼──► Meteroid
                    ├──────────────► backends/python      :8083 ──┤
                    └──────────────► backends/go          :8084 ──┘
       ▲                                     ▲
       └── tests/e2e (Playwright)            └── tests/contract (schema-validating HTTP)
```

---

## Quickstart

You need a Meteroid tenant with the catalog from **[CATALOG.md](CATALOG.md)** seeded, and an API key.
**Read CATALOG.md first — nothing works without it.** The demo never creates catalog objects; it
resolves them and fails loudly if they are missing.

```bash
cd examples
cp .env.example .env          # fill in METEROID_API_KEY, METEROID_WEBHOOK_SECRET,
                              # and SCRIBE_SESSION_SECRET (openssl rand -hex 32)
make help                     # every target, and which port each backend uses
```

Then, in three terminals:

```bash
make run-rust                 # or run-java / run-typescript / run-python / run-go
make run-frontend             # the SPA on :5173, pointed at the Rust backend
make test-contract            # the contract suite, against the same backend
```

Point everything at another backend instead by passing `BACKEND=java`, `typescript`, `python` or `go`:

```bash
make run-java
make run-frontend  BACKEND=java
make test-contract BACKEND=java
```

Sanity check before anything else:

```bash
make health                             # {"status":"ok","backend":"rust",...}
curl -s localhost:8080/api/plans | jq '.plans[].code'    # -> "free" "pro" "scale"
```

If `/api/plans` answers `CATALOG_NOT_SEEDED`, the message names exactly what is missing. Go back to
CATALOG.md.

Everything that can be checked without a live tenant:

```bash
make check      # contract lint, 4 tsc typechecks + mypy, clippy -D warnings + fmt, gradle build,
                # ruff, gofmt + go vet
```

---

## Why one frontend and N backends

The interesting part of a billing integration is the twenty lines where your server talks to
Meteroid. Everything around it — routing, session plumbing, a pricing page — is noise that differs
per language for reasons that have nothing to do with billing.

So the demo factors it out. There is **one** SPA and **one** contract suite. Every backend
implements the same HTTP contract, [`openapi.yaml`](openapi.yaml), and the frontend and tests point
at whichever one is running via `BASE_URL`. Reading two backends side by side shows you exactly what
changes between languages, which is the SDK call and nothing else.

The backends are **hand-written on purpose.** Generated server scaffolding would bury the SDK calls
under layers of framework, and those calls are the entire point. In every handler the Meteroid call
is meant to be the most visible line in the function.

Conformance is enforced by tests rather than by a generator — see
[How conformance is enforced](#how-conformance-is-enforced).

## Why "metered AI transcription"

It is the smallest product that needs all three Meteroid feature types at once, and the quota wall
is the one place a billing system reaches into a product's hot path.

---

## What each feature exercises

Every row is a screen in the SPA, an operation in `openapi.yaml`, and one or two SDK calls. Rust
method names are shown as `client.customers().create_customer(..)`; the Java equivalents are the
same groups and methods in camelCase, reached through Lombok-generated getters
(`meteroid.getCustomers().createCustomer(..)`). **The TypeScript calls are the Java ones without
the getter**: the groups are plain properties and the method names are identical —
`meteroid.customers.createCustomer(..)`, `meteroid.events.ingestEvents(..)` — so they are not
repeated in the table. The one that differs is the webhook verifier, `new Webhook(secret).verify(..)`
from `@meteroid/sdk`. **Python** uses the Rust names on its asyncio client
(`meteroid.customers.create_customer(..)`), and **Go** the exported form with a `context.Context`
first (`client.Customers.CreateCustomer(ctx, ..)`).

| Demo feature | Demo endpoint | Meteroid REST | SDK call (Rust · Java) |
| --- | --- | --- | --- |
| Create a workspace | `POST /api/session` | `POST /api/v1/customers` | `customers().create_customer` · `getCustomers().createCustomer` |
| Who am I / current plan | `GET /api/me` | `GET /api/v1/customers/{alias}`, `GET /api/v1/subscriptions` | `customers().get_customer`, `subscriptions().list_subscriptions` · `getCustomer`, `getSubscriptions().listSubscriptions` |
| Pricing table | `GET /api/plans` | `GET /api/v1/plans`, `GET /api/v1/plan-versions/{id}/entitlements` | `plans().list_plans`, `plans().list_plan_version_entitlements` · `getPlans().listPlans`, `listPlanVersionEntitlements` |
| Subscribe / upgrade | `POST /api/checkout` | `POST /api/v1/checkout-sessions` | `checkout_sessions().create_checkout_session` · `getCheckoutSessions().createCheckoutSession` |
| Feature gating (all three types) | `GET /api/entitlements` | `GET /api/v1/customers/{alias}/entitlements` | `customers().get_effective_entitlements` · `getCustomers().getEffectiveEntitlements` |
| **Metered action + quota wall** | `POST /api/transcriptions` | entitlement read, then `POST /api/v1/events/ingest` | `customers().get_effective_entitlements`, `events().ingest_events` · `getEvents().ingestEvents` |
| Usage dashboard | `GET /api/usage` | `GET /api/v1/usage/subscription/{id}` or `/usage/customer/{id}` | `usage().get_subscription_usage`, `usage().get_customer_usage` · `getUsage().getSubscriptionUsage`, `getCustomerUsage` |
| Customer portal | `POST /api/portal-session` | `POST /api/v1/customers/{alias}/portal-token` | `customers().create_portal_token` · `getCustomers().createPortalToken` |
| Invoices | `GET /api/invoices` | `GET /api/v1/invoices` | `invoices().list_invoices` · `getInvoices().listInvoices` |
| Webhook receiver | `POST /api/webhooks/meteroid` | — (inbound) | `meteroid_rs::webhooks::Webhook::verify` · `com.meteroid.Webhook.verify` · `Webhook.verify` from `@meteroid/sdk` |
| Catalog resolution (startup) | — | `GET /api/v1/features/{code}`, `GET /api/v1/metrics` | `features().get_feature`, `metrics().list_metrics` · `getFeatures().getFeature`, `getMetrics().listMetrics` |
| Liveness | `GET /api/health` | — | — |

The three Meteroid feature types, and where each becomes visible:

| Feature type | Code | What it does in Scribe |
| --- | --- | --- |
| Metered | `transcription_minutes` | `POST /api/transcriptions` refuses with **`402 QUOTA_EXHAUSTED`** when the balance runs out, and the SPA turns that into a paywall naming the next plan up |
| Boolean | `sso` | Only Scale unlocks it; lower plans get `403 FEATURE_NOT_ENTITLED` |
| Config | `retention_days`, `seats` | Typed values that visibly change on upgrade |

**Look at the quota path first.** It is the reason entitlements exist. `POST /api/transcriptions`
reads the effective entitlement, compares the requested minutes against the remaining balance in
exact decimal arithmetic, and only then ingests the usage event — a request that would exceed the
quota reports `402` and sends no event at all.

---

## Layout

```
examples/
  openapi.yaml            the demo backend's contract — the single source of truth
  lint_contract.py        enforces the contract's modelling rules (run after editing the YAML)
  CATALOG.md              what the operator seeds in Meteroid, once, by hand
  .env.example            every environment variable, documented, with no secrets
  Makefile                run any backend, the SPA, or either suite
  frontend/               one SPA, targets a configurable BASE_URL
  backends/
    rust/                 hand-written, uses meteroid-rs            (port 8080)
    java/                 hand-written, uses meteroid-java          (port 8081)
    typescript/           hand-written, uses @meteroid/sdk          (port 8082)
    python/               hand-written, uses meteroid (asyncio)     (port 8083)
    go/                   hand-written, uses meteroid-clients/go    (port 8084)
  tests/
    contract/             schema-validating HTTP suite, run once per BASE_URL
    e2e/                  Playwright happy path through the SPA
```

### The contract is deliberately strict

`openapi.yaml` is OpenAPI 3.1, written to be transcribed by hand into statically typed backends:

* Every object sets `additionalProperties: false` and lists `required`.
* **In responses, `required` lists every property.** Optionality is the type union `[T, "null"]`,
  never an absent key, so no decoder ever distinguishes "absent" from "null". Request bodies are the
  opposite by design: absent, `null` and no body at all are equivalent.
* Every union is tagged with an explicit discriminator *and* a `const` tag on each variant, so an
  internally-tagged decoder works with no discriminator support.
* Every Meteroid `format: decimal` stays a **string**. Invoice money is the deliberate exception:
  Meteroid models it as an integer count of minor units and this contract does not convert. (It is
  `int32` upstream; the contract widens to `int64` so a future upstream widening is not breaking
  here.) Do not "fix" this for consistency.

The one open schema is the inbound webhook envelope. Meteroid publishes no schema for webhook
payloads at all — they are not in `spec/openapi.json` — so that schema requires nothing, allows
anything, and the signature does the gatekeeping.

Those rules are machine-checked, because a rule nobody enforces is a comment:

```bash
make lint-contract
```

`lint_contract.py` checks what `redocly` cannot: that no decimal became a JSON number, that every
response property is in `required`, that every union variant carries a `const` tag and matches
exactly one branch, that every non-2xx uses the shared `Error` envelope. It also runs payloads that
must be accepted and payloads that must be rejected, so the union rules are tested, not asserted.

---

## The catalog is seeded once, out of band

Meteroid's REST API has **no** `POST /api/v1/features`, and entitlements are GET-only on plan
versions, products and add-ons. Features and entitlements are therefore created in the Meteroid
dashboard, once per tenant.

The demo resolves them by stable identifier on every run — features by `code`, the metric by `code`,
plans by **exact `name`** (Meteroid plans have no code) — and fails with `503 CATALOG_NOT_SEEDED`
naming the missing object rather than degrading silently.

Each demo *session* creates one new Meteroid **customer**, which is expected and cheap. There is no
user auth to build: `POST /api/session` mints a session token bound to that customer's alias, and
every other endpoint takes it as a bearer token. The token is a stateless HMAC over the alias, so
all backends mint tokens the others accept — which is also how the test suites get a handle on a
workspace an operator subscribed by hand.

---

## How conformance is enforced

Not by a generator — by tests.

`tests/contract/` is a black-box HTTP suite that takes a `BASE_URL` and, for every operation in
`openapi.yaml`, drives it and validates the response against the contract's own schema. Strictness
is what makes it worth anything: `additionalProperties: false` means an extra field is a failure,
the tagged unions mean a mis-shaped entitlement is a failure, and the string decimals mean a backend
that leaks a JSON number is a failure.

Run it against each backend in turn — same suite, same assertions, different port:

```bash
make test-contract BACKEND=rust
make test-contract BACKEND=java
make test-contract BACKEND=typescript
```

The suite reports per-test results, so **the sharpest check available without a tenant is running it
against two backends and diffing the outcomes test-for-test.** They must agree on every one; a
single disagreement is a real behavioural divergence. (That check is how the Jackson
string-coercion bug below was found.)

Two paths get special handling:

* **Quota exhaustion** — the suite reads the remaining balance, asks for one hundredth of a minute
  more than that, and asserts the `402` carries a populated `quota` snapshot plus the
  `upgrade_plan_code` the `free → pro → scale` ladder dictates. This is the one behaviour every
  backend must get identically right, and it needs a plan with a finite limit — Free, whose limit
  CATALOG.md seeds at 30 for exactly this reason.
* **Webhooks** — every SDK used here exposes a webhook *signer* as well as a verifier, so the
  suite signs its own payloads with `METEROID_WEBHOOK_SECRET` and exercises the receiver like any
  other endpoint, with no live tenant and no tunnel. The negative cases matter most: tampered body,
  wrong secret, missing or malformed headers, stale and future timestamps — all must come back
  `400 WEBHOOK_SIGNATURE_INVALID`.

`tests/e2e/` is a short Playwright run through the SPA, covering only what genuinely needs a
browser: that checkout actually leaves for Meteroid's hosted page and survives coming back, that the
portal opens in a new tab carrying a working token, and that a `402` renders as a paywall naming the
right plan rather than a generic error toast.

The frontend and the e2e suite meet at `tests/e2e/support/selectors.ts`. **Those `data-testid`
values are API**: rename a heading or restructure a component freely, but changing a testid means
changing it in both places.

---

## Notes for whoever writes a backend

Things about the Meteroid API that are not obvious until you hit them. The contract's operation
descriptions spell each one out.

* **Two lookups belong at startup, not per request.** A `metric_id` → `metric_code` map from
  `GET /api/v1/metrics` (entitlements and usage price components identify metrics by id only), and a
  `GET /api/v1/features/{code}` probe for the four seeded codes — without the latter, an unseeded
  tenant and an unsubscribed workspace are indistinguishable and you report a misleading `403`.
* **`GET /api/v1/usage/customer/{id}` requires `start_date` and `end_date`;** the subscription-scoped
  one does not. The customer-scoped fallback period is therefore the demo's choice, not Meteroid's.
* **Plans resolve by exact name**, since Meteroid plans carry no code and `search` is fuzzy. Narrow
  the result client-side and check the currency while you are there.
* **Verify webhooks over the raw request bytes.** Re-serializing the parsed JSON first will fail on
  any payload whose key order differs — which is most of them.
* **Turn off your JSON library's scalar coercion.** Jackson will quietly turn `{"name": 123}` into
  the string `"123"`, so the Java backend accepted malformed bodies that serde rejected. See
  `Json.java` for the three lines that fix it. Whatever language you add next, check this first.
  (TypeScript has the same problem in a purer form — `JSON.parse` validates nothing at all — so
  `backends/typescript/src/dto.ts` decodes request bodies by hand.)
* **Decimals are strings in every SDK, but only some languages hand you arithmetic.** Rust gets
  `rust_decimal`, Java gets `BigDecimal`; the TypeScript SDK types decimals as `string` and stops
  there, so the quota check needs its own exact subtraction (`backends/typescript/src/decimal.ts`,
  on `bigint`). Reaching for `Number()` is the bug the contract's string rule exists to prevent.

Two SDK ergonomics wrinkles in Java:

* `com.meteroid.Meteroid` declares its API groups as private fields, but the class carries Lombok's
  `@Getter`, so the accessors *are* generated and the facade works —
  `meteroid.getCustomers().createCustomer(..)`. What does not exist is the `meteroid.getCustomer()`
  its own javadoc shows (singular); getters are named after the fields, so every group is plural.
* `com.meteroid.Webhook.verify` throws `com.standardwebhooks.exceptions.WebhookVerificationException`,
  and the SDK depends on standard-webhooks with Gradle's `implementation`, so that class is *not* on
  a consumer's compile classpath. To catch it you must declare `com.standardwebhooks:standardwebhooks`
  yourself — `backends/java/build.gradle` does, pinned to the version the SDK uses. The real fix is
  `api` instead of `implementation` in `java/build.gradle`.

And three in TypeScript:

* **`date-time` fields are `Date`s.** The SDK parses them, so a backend that only wants to pass
  `created_at` or `reset_at` along has to re-render it with `toISOString()` — same instant, but
  always UTC with milliseconds, where Rust and Java forward Meteroid's own string.
* **Absent optional fields are `undefined`, and `JSON.stringify` drops `undefined` keys.** The
  contract's "nullable means present-and-null" rule therefore needs a `?? null` on every optional
  field a handler projects. `backends/typescript` makes the compiler enforce it
  (`exactOptionalPropertyTypes`, and no `?` in any response type).
* **`Webhook.verify` throws two kinds of error.** `WebhookVerificationError` for everything about the
  signature, but a bare `SyntaxError` for a correctly signed body that is not JSON, and it returns
  `undefined` for a signed empty body. A receiver has to map all three to the same `400`.

Three in Python:

* **Catching `MeteroidError` does not catch everything.** A 2xx body the SDK cannot decode raises
  `json.JSONDecodeError` or `ModelParseError`, both plain `ValueError`s, so `scribe/error.py` wraps
  the SDK line in a broader catch.
* **Decimal fields accept more than decimals.** `"NaN"`, `"Infinity"` and a bare JSON number all
  deserialize into a `Decimal` without complaint, and `str(Decimal)` can print an exponent.
  `scribe/decimals.py` refuses non-finite values and renders plain digits.
* **`Webhook.verify` returns `None`**, where TypeScript and Java hand back the parsed payload; parse
  the raw bytes yourself, after verifying.

And three in Go:

* **`JsonConfigValue.Value` is a map**, but the spec allows any JSON. An array or scalar config value
  fails to decode and takes the whole entitlements response with it.
* **An unknown union variant decodes "successfully"** with every variant pointer nil. Every `switch`
  over a union needs a `default:`, or it is a nil dereference the day Meteroid adds a variant.
* **Transport and decode failures are both untyped `fmt.Errorf`s** with no status, so a backend
  cannot tell "Meteroid is down" from "Meteroid answered something the SDK could not read".

---

## Adding a backend

TypeScript, Python and Go were each added after the first two, and each took exactly what the layout
promises: one more directory answering `openapi.yaml` on its own port, a value in the contract's
`Health.backend` enum, and a few Makefile lines. The SPA and both suites were not touched.

* **`backends/python`** is a bare ASGI app on uvicorn over the SDK's asyncio client; `uv` runs it.
* **`backends/go`** is `net/http` and nothing else. `make` uses a local `go` when there is one and
  the `golang` image otherwise, so no Go install is required.

Each was checked the way TypeScript was, below: the contract suite against the new backend and an
existing one with identical configuration, outcomes diffed per test, plus a hundred-odd raw error-path
probes compared for status, headers and body shape. Session tokens are byte-identical across all five.

### TypeScript

`backends/typescript/` was a placeholder until the TypeScript SDK landed in this repository. Filling
it took exactly what the layout promised: one more backend answering `openapi.yaml` on port 8082 —
plain `node:http`, the SDK as its only runtime dependency — and nothing else changed. Port 8082 and
`"backend": "typescript"` were already reserved in `.env.example`, the Makefile and the contract;
the SPA and both test suites take a `BASE_URL` and neither knows nor cares what answers.

How it was checked, given that there is no tenant: the contract suite was run against the Rust and
the TypeScript backend with identical configuration and an unreachable Meteroid, and the per-test
outcomes were diffed. All 110 agree: the same 57 pass (the harness, health, the 404 envelope, every
missing-token check, the whole webhook file), the same 33 fail because creating a session needs
Meteroid and answers `502`, and the same 20 skip. That is evidence the two backends *behave alike*
where they can be reached, not that either is right against a live tenant.

The one build wrinkle is that an npm package is consumed through its compiled `dist/`, which is not
committed, so `make` builds the SDK (`npm ci` + `tsc` in `../typescript`, writing only gitignored
files) before installing the backend. See [`backends/typescript/README.md`](backends/typescript/README.md).

---

## Configuration

Every backend reads the same variables. See [`.env.example`](.env.example) for the annotated list,
including the test-only ones.

| Variable | Required | Purpose |
| --- | --- | --- |
| `METEROID_API_KEY` | yes | Server-side Meteroid credential. Never reaches the browser. |
| `METEROID_BASE_URL` | no | Defaults to `https://api.meteroid.com`. |
| `METEROID_WEBHOOK_SECRET` | yes | `whsec_…` from the dashboard endpoint. Verifies inbound webhooks; the contract suite signs with it. |
| `SCRIBE_SESSION_SECRET` | yes | HMAC key for session tokens. No default — every backend refuses to start without it. |
| `SCRIBE_DEFAULT_CURRENCY` | no | Currency for created customers. Must match the seeded plans (`USD`). |
| `PORT` / `SCRIBE_PORT` | no | `PORT` wins. Left unset in `.env.example` on purpose — each backend defaults to its own port so they can run side by side, and setting it globally would collide them. |
| `VITE_API_BASE_URL` | frontend | Which backend the SPA talks to. |
| `BASE_URL` | tests | Which backend the suites drive. Keep in step with `VITE_API_BASE_URL`. |

No secret is committed, and nothing reads a credential from anywhere but the environment.

---

## Status

| Piece | State |
| --- | --- |
| `openapi.yaml` | done — `redocly lint` clean, cross-checked operation by operation against `spec/openapi.json` |
| `CATALOG.md` | done |
| `backends/rust` | done — all 12 operations, `clippy -D warnings` clean, 28 offline tests |
| `backends/java` | done — all 12 operations, `-Xlint:all -Werror` clean, 40 offline tests |
| `backends/typescript` | done — all 12 operations, `tsc --strict` clean, 57 offline tests (incl. the metered path against a stubbed Meteroid) |
| `backends/python` | done — all 12 operations, `mypy --strict` + ruff clean, 133 offline tests |
| `backends/go` | done — all 12 operations, `gofmt` + `go vet` clean, 65 offline tests |
| `frontend` | done — all 12 operations consumed, types generated from `openapi.yaml` and committed |
| `tests/contract` | done — 110 tests over all 12 operations, every response validated against `openapi.yaml` |
| `tests/e2e` | done — 3 specs; needs a browser (`npm --prefix tests/e2e run browsers`) and a hand-provisioned subscribed workspace |

**Nothing here has been exercised against a live Meteroid tenant** — there is none in the development
environment. Every Meteroid-backed path is verified only insofar as it compiles, typechecks, lints,
and returns a contract-shaped error when Meteroid is unreachable. The first run against a real tenant
should be treated as the real test.

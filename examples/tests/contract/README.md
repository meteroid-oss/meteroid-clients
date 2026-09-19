# Scribe contract suite

One black-box HTTP suite, run once per backend. It drives every operation in
[`examples/openapi.yaml`](../../openapi.yaml) against a `BASE_URL` and validates every response
against the contract's own schemas.

```bash
./run.sh http://localhost:8080    # rust
./run.sh http://localhost:8081    # java
./run.sh http://localhost:8082    # typescript
```

Same assertions, different port. That is the whole idea: conformance between the backends is
enforced by this suite, not by a code generator.

> **This suite has never been executed against a live Meteroid tenant.** There is no tenant and no
> API key in the environment it was written in. What *has* been verified is listed under
> [What is and is not verified](#what-is-and-is-not-verified) — including a full green run against a
> conforming mock backend, and a mutation test proving the suite fails when a backend is wrong. But
> no assertion here has ever seen a real Meteroid response, and the first real run should be read
> with that in mind.

## What it needs

| | |
| --- | --- |
| A backend running | Rust, Java or TypeScript — whichever `BASE_URL` points at. |
| A live Meteroid tenant | The backend calls Meteroid on almost every request. There is no mock mode. |
| A Meteroid API key | In the **backend's** environment, never the suite's. The suite never talks to Meteroid directly. |
| The catalog seeded | Per [`examples/CATALOG.md`](../../CATALOG.md). The demo never creates catalog objects; a missing one is a `503 CATALOG_NOT_SEEDED` and the suite reports which object. |

Each run creates a handful of new Meteroid **customers** (one per `POST /api/session`) and, on a
subscribed workspace, ingests a few usage events and creates checkout sessions. It never creates,
edits or deletes a catalog object. Run it against a development tenant.

## Configuration

Everything is environment variables. `run.sh` also reads `examples/.env` if present; values already
in the environment win.

| Variable | Required | What it does |
| --- | --- | --- |
| `BASE_URL` | yes | The backend to drive. Defaults to `http://localhost:8080`. |
| `METEROID_WEBHOOK_SECRET` | for the webhook tests | The `whsec_…` the **backend** verifies with. The suite signs its own payloads with it. Without it, the webhook tests skip. |
| `SCRIBE_SUBSCRIBED_SESSION_TOKEN` | for the metered tests | A session token for a workspace that has completed checkout. |
| `SCRIBE_SESSION_SECRET` + `SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS` | alternative to the above | The backend's session secret plus the alias of a subscribed customer; the suite mints the token itself. |
| `SCRIBE_EXPECT_BACKEND` | no | `rust` \| `java` \| `typescript`. Asserts `/api/health` reports it — set it in CI so a mis-pointed `BASE_URL` fails instead of silently testing the wrong backend twice. |
| `SCRIBE_REQUEST_TIMEOUT_MS` | no | Per-request timeout, default 20000. |
| `SCRIBE_USAGE_SETTLE_MS` | no | How long to wait for Meteroid's usage counters, default 15000. |

### Why a subscribed workspace has to be handed in

The suite creates its own workspace through `POST /api/session`, and that workspace has **no
subscription** — completing a Meteroid checkout means a hosted page, a browser and a card, which a
test suite cannot do. An unsubscribed workspace is genuinely useful (it is how the `403
FEATURE_NOT_ENTITLED` path, the null-subscription shape of `/api/me` and the customer-scoped usage
fallback get tested), but the metered action, the quota wall and invoice contents need a real
subscription.

So an operator sets one up once, by hand, and points the suite at it:

1. Start a backend, `curl -XPOST localhost:8080/api/session`, and keep the `customer_alias`.
2. `curl -XPOST localhost:8080/api/checkout -H 'authorization: Bearer <token>' -d '{"plan_code":"free"}'`
   and complete the returned `checkout_url` in a browser.
3. Export `SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS=<that alias>` and `SCRIBE_SESSION_SECRET=<the backend's>`.

Use the **Free** plan for it. `CATALOG.md` seeds Free with a limit of 30 transcription minutes
precisely so the `402 QUOTA_EXHAUSTED` wall is reachable; on Scale the entitlement is unlimited by
design and the quota tests skip themselves with a note saying so.

Every skip prints what is missing and how to supply it. A run that skips a lot is not a green run —
read the notes.

## What it checks

**Every response is validated against the schema in `openapi.yaml`.** Not against a copy of it:
`src/spec.ts` loads the YAML, hands the whole document to Ajv, and compiles validators by JSON
Pointer, so the schema under test is literally the one the contract declares. Nothing is transcribed
into an assertion, because a transcribed schema drifts the moment somebody edits the YAML.

Because the contract is strict, that check is worth a lot on its own:

* `additionalProperties: false` everywhere — an extra field is a failure.
* every response property is in `required` — an omitted key is a failure, even a nullable one.
* every union tagged with a `const` — a mis-shaped entitlement is a failure.
* every Meteroid decimal is a string — a leaked JSON number is a failure.
* the status has to be one the contract *declares* for that operation — an undeclared 200 is a
  failure even when it looks reasonable.

On top of that, the cross-field rules a schema cannot express, mostly the ones the contract states
in prose and two hand-written backends could easily read differently:

| File | What it pins down |
| --- | --- |
| `00-harness.test.ts` | The suite testing itself. **Runs offline.** |
| `01-health.test.ts` | Which backend is answering; an unmatched route still uses the error envelope. |
| `02-session.test.ts` | No body == `{}` == explicit nulls; a fresh workspace has no subscription and no plan; four ways to fail auth. |
| `03-plans.test.ts` | `free`/`pro`/`scale` in order, one currency across all three, and every `PlanPrice` flattening rule. |
| `04-entitlements.test.ts` | `unlimited` mirrors `limit`; a limited entitlement always reports a balance; `reset_period` interval and unit are null together. |
| `05-checkout.test.ts` | Checkout targets the same `plan_version_id` the pricing table advertised. |
| `06-transcriptions.test.ts` | The centerpiece: 403 vs 402 vs 201, exact decimal billing, the balance decrement, the upsell ladder. |
| `07-usage.test.ts` | `scope` is `customer` without a subscription and `subscription` with one. |
| `08-portal.test.ts` | The 60..2592000 range is the backend's job, not Meteroid's. |
| `09-invoices.test.ts` | Invoice money is an **integer in minor units** — the one place the decimals-are-strings rule does not apply. |
| `10-webhooks.test.ts` | Signed payloads accepted; **nine ways of being unsigned or wrongly signed rejected.** |

### The three outcomes of the metered action

This is the assertion the whole demo exists for, and the one most likely to differ between two
hand-written backends:

```
403 FEATURE_NOT_ENTITLED   the plan does not grant it        → "upgrade to get this"
402 QUOTA_EXHAUSTED        granted, used up, + a snapshot    → "upgrade to get more"
201 + quota                allowed, billed, reported         → the usage bar moves
```

A backend that collapses 402 into 403 still "works". The product it powers can no longer tell a
paywall from an upsell. The suite asserts the status, the machine-readable code, the populated
`quota` snapshot on the 402, and that `upgrade_plan_code` follows the contract's fixed
`free → pro → scale` ladder.

### Webhooks, without a tunnel

Both SDKs expose a webhook **signer** as well as a verifier, so the receiver is driven like any
other endpoint: `src/webhook.ts` implements Standard Webhooks signing directly
(`HMAC-SHA256` over `${webhook-id}.${webhook-timestamp}.${raw body}`, header `v1,<base64>`) and
signs test payloads with `METEROID_WEBHOOK_SECRET`. No live tenant, no ngrok, no waiting.

The signer is checked offline against the published test vector, so a green webhook run means the
backend accepted a signature the SDKs would also produce.

**The negative cases are the point.** A receiver that accepts everything passes every happy-path
test ever written and lets anyone mark an invoice paid. The suite asserts rejection for: a tampered
body, the wrong secret, a missing signature header, a missing `webhook-id`, four malformed
signatures, a `v2` version tag, a stale timestamp, a future timestamp, a non-numeric timestamp, an
unsigned request, and a signed body that is not JSON — all as `400 WEBHOOK_SIGNATURE_INVALID`, never
the `401` the contract reserves for a bad session token.

And the opposite rule, which is just as easy to get wrong: a *correctly signed* body is never
rejected for its shape. Meteroid owns the event envelope and publishes no schema for it, so unknown
types and unexpected fields are acknowledged with `handled: false`.

## Running it

```bash
./run.sh                                   # BASE_URL from the environment
./run.sh http://localhost:8081             # a specific backend
./run.sh http://localhost:8080 -t webhook  # anything after the URL goes to vitest

npm test                                   # vitest directly
npm run typecheck                          # tsc --noEmit
npm run list                               # collect without running — needs no server
```

`run.sh` loads `examples/.env`, probes `/api/health` first, and refuses to run if nothing answers —
thirty connection errors are less useful than one sentence. It reports which optional variables are
missing, and therefore which tests will skip.

To run against every backend in turn:

```bash
for port in 8080 8081; do ./run.sh "http://localhost:$port" || exit 1; done
```

## What is and is not verified

Verified, in the environment this was written in:

* `npx tsc --noEmit` is clean.
* `npx vitest list` collects all tests with no server running.
* With no server, **every** failure is a `BackendUnreachableError` wrapping `ECONNREFUSED` — no code
  errors — and `00-harness.test.ts` still passes, which is the signal that a red run is
  environmental rather than broken.
* Against a **throwaway mock backend** written to conform to the contract: 110/110 passing, with no
  skips. So the suite's plumbing — signing, decimals, the quota arithmetic, the schema wiring —
  executes and agrees with a conforming implementation.
* **Mutation tested.** Nine defects were seeded into that mock and the suite caught all nine: a
  decimal emitted as a JSON number, an extra response property, a nullable field omitted instead of
  nulled, quota exhaustion reported as 403, an accepted invalid webhook signature, an undeclared
  status code, an accepted unknown request property, a missing `upgrade_plan_code`, and a balance
  that was never decremented.

Not verified, and it matters:

* **Nothing has run against a live Meteroid tenant or a real backend.** The mock is a fixture the
  same author wrote from the same contract; it can only prove internal consistency. If the contract
  itself misdescribes Meteroid, the mock and the suite agree with each other and are both wrong.
* Real Meteroid webhook traffic has never been seen. The envelope shape is a guess — Meteroid
  publishes no schema for webhook payloads — so the receiver is written to degrade to
  `handled: false` rather than reject, and the suite asserts exactly that.
* Timing assumptions around eventually-consistent usage counters (`SCRIBE_USAGE_SETTLE_MS`) are
  guesses. `07-usage.test.ts` deliberately *reports* rather than fails when a counter has not
  settled; if it never settles on a real tenant, the ingested metric code does not match the seeded
  billable metric, and that is worth chasing.

## Notes for whoever maintains this

* **Vitest claims `BASE_URL`.** It is Vite's public-base-path variable, and inside a test worker
  `process.env.BASE_URL` has been overwritten with `/`. `vitest.config.ts` captures the real value
  in the parent process and forwards it as `SCRIBE_BASE_URL`; `src/env.ts` reads both. Do not
  "simplify" that away.
* **The whole run is one process** (`pool: 'forks'`, `maxWorkers: 1`, `isolate: false`). The suite
  shares one demo workspace across all files, held in a module-level promise in `src/session.ts`.
  Isolated or parallel files would each create their own Meteroid customer on every run.
* **Add an operation to the contract and the suite fails until you test it.** `src/api.ts` is keyed
  by `operationId`, and `00-harness.test.ts` asserts those keys equal the contract's operation ids
  *and* that each one is called from a test file.
* Never compare a decimal with `Number()`. `src/decimal.ts` does exact `bigint` arithmetic on the
  strings, which is the same rule the contract imposes on the backends.

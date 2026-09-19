# Scribe — Python backend

An implementation of [`examples/openapi.yaml`](../../openapi.yaml), written by hand on top of the
[`meteroid`](../../../python) Python SDK from this repository. Stack: **a bare ASGI callable on
`uvicorn`**, Python ≥ 3.11, fully type hinted (`mypy --strict`). The SDK and uvicorn are the only
runtime dependencies.

It is hand-written on purpose. Generated server scaffolding would bury the six Meteroid calls this
demo exists to show under a pile of dispatch code; conformance to the contract is enforced by the
contract suite instead of by a generator. There is no web framework for the same reason: the SDK
ships an asyncio client (`MeteroidAsync`), so all the backend needs is something that speaks HTTP to
an `async def` — and twelve routes fit in one table ([`app.py`](scribe/app.py)), over one small
ASGI callable ([`http.py`](scribe/http.py)) that hands every handler the raw body bytes, which is
the one thing frameworks tend to take away.

It mirrors [`../rust`](../rust) and [`../typescript`](../typescript) file for file and behaves
identically: same routes, status codes, error envelope, session tokens, catalog resolution and quota
arithmetic. Reading them side by side shows what changes between languages, which is the SDK call
and nothing else.

---

## Run it

From `examples/`:

```bash
cp .env.example .env          # then fill it in — see below
make run-python
# Scribe (python) listening on http://localhost:8083
```

The backend depends on the SDK **by path** (`meteroid = { path = "../../../python", editable = true }`
under `[tool.uv.sources]`), the way the Rust backend uses `path = "../../../rust"`. The SDK is pure
Python, so there is nothing to build first, and an editable install writes nothing into `python/`.
Without `make`, with [`uv`](https://docs.astral.sh/uv/):

```bash
uv sync                               # .venv/ from the committed uv.lock
set -a && . ../../.env && set +a      # export the configuration into your shell
uv run python -m scribe
```

Nothing is hard-coded; every knob is an environment variable.

| Variable | Required | Default | What it is |
| --- | --- | --- | --- |
| `METEROID_API_KEY` | to do anything useful | — | Server-side Meteroid API key. Never reaches the browser. |
| `METEROID_BASE_URL` | no | `https://api.meteroid.com` | Meteroid API base URL. |
| `METEROID_WEBHOOK_SECRET` | for `/api/webhooks/meteroid` | — | Signing secret (`whsec_…`) of the webhook endpoint you created in the dashboard. |
| `SCRIBE_SESSION_SECRET` | **yes** | — | HMAC key for demo session tokens. Not a Meteroid credential. `openssl rand -hex 32`. |
| `SCRIBE_DEFAULT_CURRENCY` | no | `USD` | Currency new demo customers are created with. **Must equal the seeded plans' currency.** |
| `PORT` (or `SCRIBE_PORT`) | no | `8083` | Listen port. `PORT` wins. |

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
| [`routes/transcriptions.py`](scribe/routes/transcriptions.py) | The metered action: read the entitlement, gate on the remaining balance, then report consumption with `meteroid.events.ingest_events(…)`. This is the demo. |
| [`entitlements.py`](scribe/entitlements.py) | Normalizing Meteroid's three-way `EffectiveEntitlementValue` union — a `match` on the variant's class that `mypy` checks for exhaustiveness through `assert_never` — and the quota arithmetic. |
| [`decimals.py`](scribe/decimals.py) | The two things `decimal.Decimal` does not do for you: render without an exponent, and refuse to round silently. |
| [`catalog.py`](scribe/catalog.py) | Resolving a catalog you are not allowed to create, and flattening Meteroid's six-variant `Fee` union into a pricing table. |
| [`routes/webhooks.py`](scribe/routes/webhooks.py) | `Webhook(secret).verify(raw_body, headers)` verifying a Standard Webhooks signature over the **raw** request bytes. |
| [`routes/checkout.py`](scribe/routes/checkout.py) | One call to create a hosted checkout session. |
| [`session.py`](scribe/session.py) | The demo's stateless session token. Nothing to do with Meteroid; it exists so the demo needs no user database. |
| [`error.py`](scribe/error.py) | Mapping SDK failures onto the contract's one error envelope — `with upstream(context):` wraps each SDK call and separates "your API key is wrong" from "Meteroid is throttling". |
| [`dto.py`](scribe/dto.py) | The wire types as total `TypedDict`s, and the hand-written request decoders: `json.loads` validates nothing, so unknown keys and wrong scalar types are rejected here. |

Five things are worth calling out because they are easy to get subtly wrong in Python specifically:

**Decimals are `Decimal`, end to end — and never a `float`.** The SDK hands every Meteroid
`format: decimal` over as a `decimal.Decimal`, so the quota check is ordinary arithmetic. Two traps
remain. `str(Decimal("1E+3"))` is `"1E+3"` and `normalize()` *produces* exponents, so rendering goes
through `format(value, "f")`. And `Decimal` arithmetic rounds to 28 significant digits without
saying so; `decimals.py` does its sums in a context that traps `Inexact` instead.

**`True` is an `int`.** `isinstance(True, int)` holds, so a careless `duration_seconds` check reads
`{"duration_seconds": true}` as one second. The decoders in `dto.py` turn `bool` away by name before
they look for an integer.

**`json.loads` is looser than JSON.** It accepts `NaN`, `Infinity` and `-Infinity`, and given bytes
it sniffs UTF-16 and UTF-32. `routes/__init__.py` decodes strictly as UTF-8 and passes a
`parse_constant` that refuses the three non-numbers — for webhook bodies too.

**Nullable means present-and-null.** Every response type in `dto.py` is a total `TypedDict` with no
`NotRequired`, so `mypy` refuses a projection that leaves a key out, and `None` serializes as `null`.
(The SDK's own `to_dict()` *drops* `None` fields, which is right for requests to Meteroid and is why
no response here is built from it.)

**Verify webhooks over the raw bytes.** The handler passes the request `bytes` straight to the SDK
and only parses them afterwards. Parsing the JSON and re-serializing it before verifying is the
classic bug — and the usual way to hit it is a framework that read the body first. There is none
here to forget about.

---

## Tests

```bash
uv run pytest                                          # 133 tests, offline
uv run mypy                                            # --strict, over scribe/ and tests/
uv run ruff check . && uv run ruff format --check .
```

None of the tests needs a Meteroid tenant or a network. Like the other backends', they cover the
parts of the contract that are reachable offline — health, the session-token gate, the error
envelope, the 404 fallback, strict request validation, quota arithmetic, decimal rounding, response
nullability — plus the whole webhook path, which works offline because the SDK ships a **signer** as
well as a verifier. They drive the router in-process; no socket is opened.

Like the TypeScript backend's, they also put a stubbed Meteroid under the *real* SDK: the client
accepts an `httpx.AsyncClient`, so [`tests/test_meteroid.py`](tests/test_meteroid.py) gives it an
`httpx.MockTransport` and drives the metered action through its `201` / `402` / `403` / `503`
outcomes — asserting, among other things, that a refused request ingests no event. Those stubs are
hand-written wire JSON, not recorded responses, so they prove the handlers and the SDK's
deserializers agree with each other, not that either agrees with a live Meteroid.

Everything that actually talks to Meteroid is exercised by [`examples/tests/contract`](../../tests)
against a live tenant, not here.

---

## Notes and known rough edges

* **Plans are resolved by exact name.** Meteroid plans carry no user-supplied code, and
  `GET /api/v1/plans?search=` is a fuzzy match, so `catalog.py` filters on exact name equality
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
* **Timestamps are re-rendered.** The SDK parses every `date-time` into a `datetime`, so
  `subscription.created_at`, `reset_at` and `expires_at` come back out in UTC with a `Z`
  (`2026-10-01T00:00:00Z`, fractional seconds only when there are some) — where the Rust backend
  passes Meteroid's string through untouched and the TypeScript one always prints milliseconds.
  Same instant, not always the same text.
* **`60.0` is an integer here.** JSON Schema says `60.0` and `6e1` are valid `type: integer`
  values, and the TypeScript backend cannot tell them from `60` anyway, so this backend accepts them
  too (and echoes `60`), where serde rejects them. `60.5`, `true` and `"60"` are rejected everywhere.
* **The SDK is more forgiving about decimals than the other three.** It builds them with
  `Decimal(str(value))`, which accepts a JSON *number*, `"1e3"`, and even `"NaN"`. This backend
  renders the first two exactly (`"1000"`) and answers `502 UPSTREAM_ERROR` for a non-finite one;
  the TypeScript backend answers `502` for all three.
* **Wrong method and oversized body.** A known path with the wrong method is a bare `405` with an
  `Allow` header, exactly as axum answers it; the contract has no error code for it. A body over
  2 MiB is `413` in the standard envelope (`BAD_REQUEST`). It is read to the end first, so the
  client sees the answer rather than a broken pipe.
* **`SIGTERM` is abrupt in the log.** Ctrl-C drains connections, closes the SDK's connection pool
  and logs `Shutting down.`; on `SIGTERM` uvicorn drains and then re-raises the signal, so the
  process ends without that line.

# Scribe demo — Meteroid catalog

The Scribe demo **never creates catalog objects**. It resolves them, by the exact identifiers on
this page, every time it starts and on every request that needs them. If something here is missing,
every affected endpoint fails loudly with `503 CATALOG_NOT_SEEDED` and a message naming the
identifier it looked up.

Seed this **once** per tenant, by hand. The only thing the demo creates at runtime is a **customer**,
one per demo session — that is expected, and the same API key is reused indefinitely.

> **One currency, everywhere.** Meteroid will not check a customer out against a plan version in a
> different currency. Whatever you seed the plans in must equal `SCRIBE_DEFAULT_CURRENCY` in `.env`
> (which is what the demo creates its customers with). This page uses `USD`; if you seed in `EUR`,
> change the env var too. A mismatch surfaces at checkout as `503 CATALOG_NOT_SEEDED`.

---

## 1. What can and cannot be created over the REST API

This is the constraint that shapes the whole demo. Meteroid's REST API is *read-only* for features
and entitlements — they exist, but there is no `POST`.

| Object | REST | Endpoint | Where you seed it |
| --- | --- | --- | --- |
| Product family | writable | `POST /api/v1/product_families` | Dashboard or API |
| Billable metric | writable | `POST /api/v1/metrics` | Dashboard or API |
| Plan + version | writable | `POST /api/v1/plans`, `POST /api/v1/plans/{id}/publish` | Dashboard or API |
| Product | writable | `POST /api/v1/products` | Dashboard or API |
| Customer | writable | `POST /api/v1/customers` | **Created by the demo at runtime** |
| Subscription | writable | `POST /api/v1/subscriptions` | Created by Meteroid on checkout completion |
| **Feature** | **read-only** | `GET /api/v1/features`, `GET /api/v1/features/{id_or_code}` | **Dashboard only** |
| **Plan-version entitlement** | **read-only** | `GET /api/v1/plan-versions/{id}/entitlements` | **Dashboard only** |
| **Product entitlement** | **read-only** | `GET /api/v1/products/{id}/entitlements` | **Dashboard only** |
| **Add-on entitlement** | **read-only** | `GET /api/v1/addons/{id}/entitlements` | **Dashboard only** |
| **Webhook endpoint + secret** | **not in the REST API** | — | **Dashboard only** |

> **The four features and every entitlement value below must be created in the Meteroid dashboard.**
> There is no API call that will do it, and no amount of retrying will change that.

---

## 2. Product family

| Field | Value |
| --- | --- |
| Name | `Scribe` |

`ProductFamilyCreateRequest` only accepts a `name` — the alias is derived server-side, so do not
assume it is `scribe`. Nothing in the demo resolves the product family at runtime; it exists to
scope the metric and the plans. Look up its id once while seeding:

```bash
curl -sH "Authorization: Bearer $METEROID_API_KEY" \
  "$METEROID_BASE_URL/api/v1/product_families?search=Scribe"
```

---

## 3. Billable metric

One metric. Its **code** is hard-coded in every backend as the `code` of the events it ingests.

| Field | Value |
| --- | --- |
| Code | `transcription_minutes` |
| Name | `Transcription minutes` |
| Aggregation type | `SUM` |
| Aggregation key | `minutes` |
| Product family | `Scribe` |
| Segmentation matrix | none |
| Unit conversion | none |

The backends ingest one event per transcription:

```json
{
  "event_id": "tr_01J9Z4X0000000000000000000",
  "code": "transcription_minutes",
  "customer_id": "scribe-demo-8f2a1c",
  "timestamp": "2026-09-01T12:00:00Z",
  "properties": { "minutes": "3.5" }
}
```

Notes that matter:

* `customer_id` carries the **customer alias**, not the Meteroid id. Meteroid accepts either; the
  demo uses the alias on purpose, to show that events can reference your own identifier.
* `properties` values are **strings**, always — including numbers. `SUM` over `aggregation_key:
  minutes` parses `"3.5"` as a decimal.
* `event_id` is derived from the transcription id, so a retried ingest is idempotent. Meteroid caps
  it at 255 characters.
* Event timestamps must be within `24h ago .. 1h ahead` unless `allow_backfilling` is set. The demo
  always sends `now`, so a machine with a badly skewed clock will see ingest rejections.
* The metric's **id**, not just its code, matters at runtime: Meteroid identifies the metric behind a
  metered entitlement (`MeteredEntitlementSpec.metric_id`) and behind a `USAGE`/`CAPACITY` price
  component by id only. Backends build a `metric_id` → `metric_code` map once at startup from
  `GET /api/v1/metrics` so that `GET /api/entitlements` and `GET /api/plans` can show a code. An
  unresolvable id is not fatal — the field is nullable — but it does leave a blank in the UI.

Seeding it over the API (optional — the dashboard is fine too):

```bash
curl -sX POST -H "Authorization: Bearer $METEROID_API_KEY" -H 'Content-Type: application/json' \
  "$METEROID_BASE_URL/api/v1/metrics" -d '{
    "name": "Transcription minutes",
    "code": "transcription_minutes",
    "aggregation_type": "SUM",
    "aggregation_key": "minutes",
    "product_family_id": "<product family id>"
  }'
```

---

## 4. Features — **dashboard only**

Four features. The **code** is the contract: it is what the backends gate on and what
`GET /api/entitlements` returns as `feature_code`. Names are cosmetic; codes are not.

| Code | Type | Value type | Bound to | Used by |
| --- | --- | --- | --- | --- |
| `transcription_minutes` | `METERED` | — | metric `transcription_minutes` | `POST /api/transcriptions` quota check |
| `sso` | `BOOLEAN` | — | — | frontend gate on the "Single sign-on" settings card |
| `retention_days` | `CONFIG` | `NUMBER` | — | frontend copy: "transcripts kept for N days" |
| `seats` | `CONFIG` | `NUMBER` | — | frontend copy: "N seats included" |

`retention_days` and `seats` are `NUMBER` config features, so Meteroid returns their value as a
**decimal string** (`{"kind": "NUMBER", "value": "90"}`). The demo contract preserves that; do not
seed them as `TEXT` unless you want the frontend to render them differently.

**The feature *type* matters as much as the code.** `transcription_minutes` must be `METERED`: it
is the entitlement `POST /api/transcriptions` enforces, and the quota check reads its `limit` and
live usage counters. Seeding it as `BOOLEAN` or `CONFIG` by mistake does not silently degrade —
the backends answer `503 CATALOG_NOT_SEEDED` saying so, rather than letting an operator error look
like "your plan doesn't include that".

Meteroid's `ConfigValueType` also has `MAP` and `SELECT`. The demo normalizes `MAP` onto `JSON` and
`SELECT` onto `TEXT`, so a feature seeded as either still renders — it just arrives under the
normalized `kind`.

Backends look these four codes up **once at startup** with `GET /api/v1/features/{code}`. That check
is what makes an unseeded tenant report `503 CATALOG_NOT_SEEDED` instead of a misleading
`403 FEATURE_NOT_ENTITLED` on the first transcription: at request time, an unsubscribed workspace and
an unseeded tenant look identical (both have no entitlements).

---

## 5. Plans

Meteroid plans have **no user-supplied code**. `Plan` carries `id`, `name` and `version_id`, and
`GET /api/v1/plans` only filters by `search` (plan name), status and type. So the demo's stable
`plan_code` is mapped onto the plan **name**, and the name must match *exactly*, including case:

| `plan_code` | Meteroid plan name | Plan type | Currency |
| --- | --- | --- | --- |
| `free` | `Scribe Free` | `FREE` | `USD` |
| `pro` | `Scribe Pro` | `STANDARD` | `USD` |
| `scale` | `Scribe Scale` | `STANDARD` | `USD` |

Resolution performed by every backend:

1. `GET /api/v1/plans?search=<name>&status=ACTIVE`
2. Take the entry whose `name` equals `<name>` exactly (`search` is a fuzzy match — "Scribe" alone
   would return all three).
3. Use its `version_id` as the `plan_version_id` for checkout.
4. Check its `currency` against `SCRIBE_DEFAULT_CURRENCY`.
5. Anything else → `503 CATALOG_NOT_SEEDED`.

That one call is enough for the whole pricing table: `GET /api/v1/plans` returns full `Plan` objects,
`price_components` and `version_id` included. Only the marketing bullets need a second call, to
`GET /api/v1/plan-versions/{version_id}/entitlements`.

**Each plan must be published.** A draft plan has no usable published version and checkout against
it will fail. **Renaming a plan in the dashboard breaks the demo** — the name *is* the lookup key, so
a rename is equivalent to deleting the plan as far as the backends are concerned.

Optionally give `Scribe Pro` a trial (`TrialConfig.duration_days`); it surfaces as `Plan.trial_days`
and `Subscription.trial_duration_days`. Meteroid exposes a trial *duration*, never a trial end date,
which is why the contract reports days rather than a timestamp.

### Price components

Illustrative pricing — adjust the amounts freely, the demo reads whatever you seed. Only the shape
matters: `free` must cost nothing, and at least one plan should carry a usage fee so the invoice and
usage screens have something to show.

| Plan | Component | Fee type | Amount |
| --- | --- | --- | --- |
| `Scribe Free` | Free monthly | `RATE`, `MONTHLY` | `0` |
| `Scribe Pro` | Pro monthly | `RATE`, `MONTHLY` | `29` |
| `Scribe Scale` | Scale monthly | `RATE`, `MONTHLY` | `99` |
| `Scribe Scale` | Transcription minutes | `USAGE`, `MONTHLY`, metric `transcription_minutes` | `0.01` per unit |

`GET /api/plans` flattens these into a display-only `PlanPrice` list, so a `CAPACITY` component
(N minutes included, overage above) works just as well if you prefer to demo committed usage.

Two flattening details worth knowing before you seed something fancier:

* A `RATE` or `SLOT` component can carry a price **per billing term**. The pricing table shows one:
  the term matching the plan's cadence, else the first. Seeding monthly-only keeps the table honest.
* A `USAGE` component only has a single displayable unit price when its pricing model is `PER_UNIT`.
  Seed `TIERED`, `VOLUME`, `PACKAGE` or `MATRIX` and the table shows the model name with no number —
  by design, not a bug.

### Entitlements per plan version — **dashboard only**

Attach these to each plan's **published version**. This table is the demo's entire feature-gating
story, and it is the thing most likely to be half-seeded, so check it twice.

| Feature | `Scribe Free` | `Scribe Pro` | `Scribe Scale` |
| --- | --- | --- | --- |
| `transcription_minutes` (metered) | enabled, limit `30`, reset `BILLING_CYCLE` | enabled, limit `600`, reset `BILLING_CYCLE` | enabled, **limit unset (unlimited)**, reset `BILLING_CYCLE` |
| `sso` (boolean) | `false` | `false` | `true` |
| `retention_days` (config number) | `7` | `90` | `365` |
| `seats` (config number) | `1` | `5` | `25` |

What each row buys you in the demo:

* **Free and Pro have a finite limit** — that is what makes `402 QUOTA_EXHAUSTED` reachable. Free's
  limit of 30 minutes is deliberately small so a demo can exhaust it in three or four clicks.
* **Scale is unlimited** — `limit` unset means `QuotaSnapshot.unlimited` is `true`, the quota check
  short-circuits, and every minute flows through the `USAGE` price component onto the invoice
  instead. It is the "metered billing, not metered gating" half of the story.
* **`sso` is only true on Scale** — the boolean gate the frontend greys out, and the reason
  `403 FEATURE_NOT_ENTITLED` exists alongside `402`.
* **The config values differ on all three plans** — otherwise nothing visibly changes on upgrade.

A note on reset periods: `BILLING_CYCLE` (and `NEVER`) carry no interval, while `CALENDAR`,
`FIXED_WINDOW` and `SLIDING_WINDOW` carry an `interval` + `unit` pair
(`HOUR`/`DAY`/`WEEK`/`MONTH`/`YEAR`). The demo's `ResetPeriod` keeps all three fields and nulls the
pair for the first two, so any of the five reset periods is safe to seed.

---

## 6. Webhook endpoint — **dashboard only**

Add an endpoint in the Meteroid dashboard pointing at the running backend:

```
POST <your backend base URL>/api/webhooks/meteroid
```

Subscribe at least to `invoice.created`, `invoice.finalized`, `invoice.paid`,
`subscription.created`, `subscription.updated`, `subscription.cancelled`. Every other type is
acknowledged with `handled: false`; unknown types are never an error.

> **The payload shape is not specified anywhere.** Webhook payloads do not appear in
> `spec/openapi.json`, so the demo's `MeteroidWebhookEvent` schema (an `id`, a dotted `type`, a
> `timestamp`, plus whatever else) is an expectation, not a contract. That is why the receiver
> requires no property and never rejects a correctly signed body for its shape — the signature is the
> gate, and anything unrecognized is acked with `handled: false`. If the real event names differ from
> the list above, fix the list; the receiver will not break either way.

Copy the generated signing secret (`whsec_…`) into `METEROID_WEBHOOK_SECRET` for every backend you
run. The contract suite does not need a live tenant to exercise this endpoint — both SDKs ship a
webhook **signer** as well as a verifier, so the suite signs its own payloads with the same secret.

For local development the endpoint needs to be reachable from Meteroid (a tunnel, or a Meteroid
instance on the same host).

---

## 7. Verification checklist

Run these against the seeded tenant before starting a demo. Every one must return the expected
object; each maps directly onto a `CATALOG_NOT_SEEDED` message a backend would otherwise produce.

```bash
export METEROID_BASE_URL=https://api.meteroid.com
export METEROID_API_KEY=...    # never commit this

auth=(-sH "Authorization: Bearer $METEROID_API_KEY")

# 1. the metric exists, with the exact code the backends ingest against.
#    Note its `id` too — that is the key the metric_id -> metric_code map is built on.
curl "${auth[@]}" "$METEROID_BASE_URL/api/v1/metrics?search=transcription_minutes"

# 2. the four features exist, by code (GET-only endpoint — seeded in the dashboard).
#    This is exactly the startup check each backend performs.
for f in transcription_minutes sso retention_days seats; do
  curl "${auth[@]}" "$METEROID_BASE_URL/api/v1/features/$f"
done

# 3. the three plans exist, are ACTIVE, and have a published version.
#    Check `name` matches EXACTLY and `currency` matches SCRIBE_DEFAULT_CURRENCY.
for p in "Scribe Free" "Scribe Pro" "Scribe Scale"; do
  curl "${auth[@]}" -G "$METEROID_BASE_URL/api/v1/plans" \
    --data-urlencode "search=$p" --data-urlencode "status=ACTIVE"
done

# 4. each published version carries its four entitlements
curl "${auth[@]}" "$METEROID_BASE_URL/api/v1/plan-versions/<plan_version_id>/entitlements"
```

The one thing this checklist cannot verify is the webhook endpoint: Meteroid exposes no REST API for
webhook endpoints or their secrets, so section 6 has to be confirmed in the dashboard by eye.

A faster end-to-end check once a backend is running:

```bash
curl -s localhost:8080/api/plans | jq '.plans[] | {code, name, plan_version_id, features}'
```

Three plans, each with four `features` lines, means the catalog is seeded correctly.

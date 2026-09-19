# Scribe end-to-end tests

Three Playwright tests. That is the whole suite, and it is meant to stay that way.

## Why it is so small

`tests/contract` drives every operation in `examples/openapi.yaml` against a backend and validates
each response body against its schema. It is faster, it needs no browser, it produces better failure
messages, and it runs against every backend in turn. Anything it can test, it should test.

What it cannot see is the browser: a redirect that leaves the app, a token that has to be accepted
by a different origin, and a UI state that only exists as a reaction to a `402`. So that is exactly
what lives here, and nothing else.

| Spec | What only a browser can prove |
| --- | --- |
| `checkout.spec.ts` | The SPA reads `checkout_url` and actually navigates to Meteroid's hosted page — and the app still works when the visitor comes back. |
| `portal.spec.ts` | The minted portal token is accepted by the Meteroid portal on its own origin. A token for the wrong customer passes every schema check and fails here. |
| `quota.spec.ts` | A `402 QUOTA_EXHAUSTED` renders as a paywall naming the upgrade plan, not as a generic error toast. |

If you are about to add a fourth test, check first whether it belongs in `tests/contract`. It almost
certainly does.

## Run it nightly, not per-PR

**This suite needs a live Meteroid sandbox.** It creates real customers, mints real portal tokens,
and reports real usage events. That makes it unsuitable for pull-request CI:

* it is slow, and gated on a third party's uptime;
* it is rate-limited, so parallel PR runs will produce `429`s;
* the quota test needs a hand-provisioned fixture workspace (below), which no PR can create;
* a failure often means "the sandbox is having a bad night", which is a terrible signal to block a
  merge on.

Put it in a scheduled job. Per-PR conformance is `tests/contract`'s job, and it does it better.

## What it needs

1. **A seeded Meteroid tenant** — everything in `examples/CATALOG.md`. Nothing works without it; a
   backend on an unseeded tenant answers `503 CATALOG_NOT_SEEDED` and `checkout.spec.ts` will say so.
2. **A backend running** on `BASE_URL` — any of them, that is the point.
3. **The frontend running** on `FRONTEND_URL`, with its `VITE_API_BASE_URL` pointed at that same
   backend. Nothing checks that the two agree, so check it yourself.
4. **A payment connector configured in Meteroid**, for `checkout.spec.ts`. Without one, Meteroid
   either refuses to create the session or returns one with no hosted URL, which the backend
   correctly reports as `409 CHECKOUT_UNAVAILABLE`. The test will fail on the `201` assertion.
5. **Chromium** — `npm run browsers`.

## Running

```bash
cd examples/tests/e2e
npm install
npm run browsers            # playwright install --with-deps chromium

BASE_URL=http://localhost:8080 FRONTEND_URL=http://localhost:5173 npm test
```

The same script covers every backend — only `BASE_URL` changes, plus the frontend's
`VITE_API_BASE_URL`:

```bash
BASE_URL=http://localhost:8081 npm test    # java
BASE_URL=http://localhost:8082 npm test    # typescript
```

Useful while working on it:

```bash
npm run list                # enumerate tests without running anything
npm run typecheck           # tsc --noEmit
npx playwright test --ui    # the interactive runner
npx playwright test --debug specs/quota.spec.ts
```

## Configuration

| Variable | Default | Purpose |
| --- | --- | --- |
| `BASE_URL` | `http://localhost:8080` | The demo backend under test. Same variable the contract suite uses. |
| `FRONTEND_URL` | `http://localhost:5173` | The SPA under test. |
| `SCRIBE_SUBSCRIBED_SESSION_TOKEN` | *(unset)* | Session token for a workspace already subscribed to **Free**. Without it, `quota.spec.ts` skips. Shared with `tests/contract`, which needs the same fixture. |
| `SCRIBE_E2E_CHECKOUT_PLAN` | `pro` | Which paid plan `checkout.spec.ts` starts a checkout for. |

### The fixture workspace, and why you have to make it by hand

`quota.spec.ts` needs a workspace that is already subscribed to a plan with a *finite*
`transcription_minutes` limit — Free, whose limit `CATALOG.md` deliberately sets to 30 minutes.

Getting a workspace into that state means completing a hosted Meteroid checkout, which is a payment
form on Meteroid's own domain. This suite does not automate it, on purpose: a test that fills in
someone else's payment page breaks every time they redesign it, and it would be testing Meteroid
rather than Scribe.

So provision one by hand, once:

1. Open the SPA, create a workspace, and check out on **Free**.
2. Read the session token out of `localStorage` under `scribe.session_token`.
3. Export it as `SCRIBE_SUBSCRIBED_SESSION_TOKEN` in the nightly job.

Session tokens are stateless HMACs over the customer alias (see `openapi.yaml`), so the value never
expires and one fixture serves every run. It does need to survive `SCRIBE_SESSION_SECRET` changing —
rotate the secret and you must re-mint the token.

The spec skips itself, with the reason printed, when:

* `SCRIBE_SUBSCRIBED_SESSION_TOKEN` is unset;
* the workspace has no `METERED` `transcription_minutes` entitlement (not subscribed, or not seeded);
* the entitlement is unlimited — on Scale the `402` is unreachable by design.

A skip is not a pass. If the nightly run reports three skips, the fixture is wrong.

## The frontend contract

`examples/openapi.yaml` pins the HTTP surface between the frontend and the backends. Nothing pins
the surface between these tests and the frontend, so `support/selectors.ts` is that contract, and
the SPA has to honour it.

**These `data-testid` attributes are API.** Rename a heading, restructure a component, swap the CSS
framework — none of that may change a value in `selectors.ts` without changing it here too. Testids
are used instead of text or CSS because text is copy and changes for product reasons, and CSS is
layout and changes for design reasons; neither should be able to break a billing test.

| Test id | On | Notes |
| --- | --- | --- |
| `pricing-table` | The pricing table root | Present once plans have loaded. |
| `checkout-{code}` | Per-plan checkout button | `checkout-free`, `checkout-pro`, `checkout-scale`. |
| `manage-billing` | Portal button | Must open the portal in a **new tab**. |
| `transcribe-title` | Title input | |
| `transcribe-duration` | Duration input | Value in **seconds**, 1..7200, matching `duration_seconds`. |
| `transcribe-submit` | Submit button | |
| `quota-meter` | The quota widget | Rendered from `QuotaSnapshot`. |
| `quota-remaining` | Remaining balance | Text is the API's decimal string, unrounded. |
| `quota-exhausted` | The paywall panel | Visible only after a `402`. |
| `upgrade-plan-code` | Plan code in the paywall | Text is exactly `upgrade_plan_code` from the error body. |
| `upgrade-cta` | The upgrade button | Starts a checkout for that plan. |

Two more things the SPA must do, which the tests depend on:

* **Keep the session token in `localStorage` under `scribe.session_token`**, as the bare token
  string. The tests write it directly to skip workspace creation.
* **Open the portal with the token in the URL** — `?token=…` or `#token=…`, either is accepted. The
  contract says only "the frontend opens `portal_url` with the `token`" and does not fix the
  mechanism, so `portal.spec.ts` asserts the origin and that the token is present somewhere in the
  URL, and stays out of the argument.

## No sleeps

There is no `waitForTimeout` anywhere in this suite, and there should never be one. Playwright's
assertions retry until the condition holds or the deadline passes, so a fast sandbox finishes fast
and a slow one still passes. Where the tests need a specific moment they wait for the event that
defines it — `waitForResponse` on the exact API call, `waitForURL` for the redirect,
`context.waitForEvent('page')` for the portal tab — and the session token is injected with
`addInitScript`, which runs before any page script, so there is never a signed-out flash to wait out.

One consequence worth knowing: Meteroid's usage counters are eventually consistent. `quota.spec.ts`
never asserts that `GET /api/usage` agrees with the quota in a `201` — those two are allowed to
disagree for a few seconds, and a test that insisted otherwise would flake nightly.

## Status

Written against the contract, and **never executed** — this repository's development environment has
no Meteroid tenant, no API key, no running backend and no frontend. "Verified" here means it
typechecks and Playwright enumerates the tests. The first real run will be the first time any of
these assertions has met a live page, and the selector contract above is a proposal to the frontend
until the frontend exists to honour it.

# @meteroid/browser

Meteroid in the browser: the signed-in customer's entitlements, usage and subscriptions,
and the billing portal embeds, for any frontend framework. For React, use
[`@meteroid/react`](https://github.com/meteroid-oss/meteroid-clients/tree/main/react), built on this package.

The browser never holds your API key. Your backend mints a short-lived token scoped to
the signed-in customer, and this package calls Meteroid with it. The token only reads
that customer's own data.

```
your backend ── API key ──▶ POST /api/v1/customers/{id}/portal-token ──▶ { token, expires_at, api_url, portal_url, … }
     ▲                                                                              │
     └──── GET /billing-token (your route, your auth, returns the response as-is) ◀─┘
browser: @meteroid/browser ──▶ GET {api_url}/api/client/v1/…   (Authorization: Bearer <token>)
                          └──▶ iframe {portal_url}/portal/customer?embed=…
```

- No runtime dependencies (it only needs `fetch`), about 6 KB gzipped.
- ESM and CommonJS, side-effect free, safe to import during server rendering.
- A `<script>` build for pages without a bundler.

## Installation

```bash
npm install @meteroid/browser
```

## Quick start

### 1. Add a token route to your backend

The route authenticates the user with your own auth, looks up their Meteroid customer
and returns the minted token. Return Meteroid's response as it is: the SDK reads
`token`, `expires_at`, `api_url` and `portal_url` from it, in `snake_case` or
`camelCase`.

**TypeScript** (Express, with [`@meteroid/sdk`](https://github.com/meteroid-oss/meteroid-clients/tree/main/typescript))

```typescript
import express from "express";
import { Meteroid } from "@meteroid/sdk";

const app = express();
// Server-side only: never send this key to a browser.
const meteroid = new Meteroid(process.env.METEROID_API_KEY!);

app.get("/billing-token", requireUser, async (req, res) => {
  const token = await meteroid.customers.createPortalToken(req.user.meteroidCustomerId, {
    expiresInSeconds: 3600,
  });
  res.set("Cache-Control", "no-store").json(token);
});
```

**Python** (FastAPI, with [`meteroid`](https://github.com/meteroid-oss/meteroid-clients/tree/main/python))

```python
import os

from fastapi import Depends, FastAPI, Response
from meteroid import MeteroidAsync
from meteroid.models import CustomerPortalTokenRequest

app = FastAPI()
# Server-side only: never send this key to a browser.
meteroid = MeteroidAsync(os.environ["METEROID_API_KEY"])


@app.get("/billing-token")
async def billing_token(response: Response, user=Depends(current_user)):
    token = await meteroid.customers.create_portal_token(
        user.meteroid_customer_id,
        CustomerPortalTokenRequest(expires_in_seconds=3600),
    )
    response.headers["Cache-Control"] = "no-store"
    return token.to_dict()
```

**Go** (`net/http`, with [`meteroid-clients/go`](https://github.com/meteroid-oss/meteroid-clients/tree/main/go))

```go
// Server-side only: never send this key to a browser.
client := meteroid.New(os.Getenv("METEROID_API_KEY"), nil)

http.HandleFunc("GET /billing-token", func(w http.ResponseWriter, r *http.Request) {
	user := currentUser(r) // your authentication
	ttl := int32(3600)
	token, err := client.Customers().CreatePortalToken(r.Context(), user.MeteroidCustomerID,
		meteroid.CustomerPortalTokenRequest{ExpiresInSeconds: &ttl})
	if err != nil {
		http.Error(w, "billing unavailable", http.StatusBadGateway)
		return
	}
	w.Header().Set("Content-Type", "application/json")
	w.Header().Set("Cache-Control", "no-store")
	json.NewEncoder(w).Encode(token)
})
```

Any other language works the same way: call `POST /api/v1/customers/{id_or_alias}/portal-token`
with your API key and pass the JSON response through.

A page that only reads billing state (feature gates, usage meters) is best served by a
read-only token (`"scopes": ["read"]` in the request body) with a short lifetime, such as
one hour. Embeds that change the plan or the payment methods need the `manage` scope,
which tokens get by default.

### 2. Use it in the browser

```typescript
import { createMeteroid } from "@meteroid/browser";

const meteroid = createMeteroid({
  getToken: () => fetch("/billing-token").then((r) => r.json()),
});

meteroid.subscribe(() => {
  const sso = meteroid.check("sso");
  document.querySelector("#sso-settings")!.toggleAttribute("hidden", !sso.hasAccess);

  const calls = meteroid.check("api_calls");
  if (calls.usage) {
    console.log(`${calls.usage.consumed} of ${calls.usage.limit ?? "unlimited"} API calls`);
  }
});

meteroid.mountEmbed("#billing", { view: "plan" });
```

## The token

`getToken` is called when the client first needs a token, about 60 seconds before the
current one expires, and once more when the API answers `401 TOKEN_EXPIRED`. Concurrent
needs share a single call. It may resolve to:

- the token string alone;
- the token response of `POST /api/v1/customers/{id_or_alias}/portal-token`, as the REST
  API returns it (`token`, `expires_at`, `api_url`, `portal_url`) or as `@meteroid/sdk`
  returns it (`token`, `expiresAt`, `apiUrl`, `portalUrl`). Other fields are ignored.

The expiry is read from the response, or else from the token's `exp` claim. Short-lived
tokens are renewed at half their lifetime rather than 60 seconds before expiry. When
renewing fails, the current token is used until it actually expires.

`apiUrl` and `portalUrl` default to the token's `api_url` and `portal_url`, then to
`https://api.meteroid.com` and `https://app.meteroid.com`. Pass them explicitly to
override both, e.g. for a self-hosted instance:

```typescript
createMeteroid({ getToken, apiUrl: "http://localhost:8084", portalUrl: "http://localhost:5173" });
```

## Reading billing state

### The store

The client keeps a snapshot of the customer's entitlements, profile and subscriptions:

```typescript
const unsubscribe = meteroid.subscribe(() => render(meteroid.getSnapshot()));

const { entitlements, customer, subscriptions } = meteroid.getSnapshot();
// each is { status: "loading" | "ready" | "error", data, error }
```

- The first subscriber starts the store: it loads everything, then reloads when the
  window regains focus (at most every 30 seconds) and after every change made in an
  embed of this client. The last subscriber to leave stops it.
- `refresh()` reloads on demand. It never rejects: failures land in the snapshot.
- After a successful load, a failed reload keeps the data (`status` stays `"ready"`) and
  only sets `error`.
- `subscribe`, `getSnapshot` and `getServerSnapshot` follow the contract of React's
  `useSyncExternalStore`, so the store plugs into any framework.

### Checking a feature

`check(featureCode, { fallback })` answers synchronously from the snapshot:

```typescript
const { status, hasAccess, isFallback, entitlement, usage, value } = meteroid.check("api_calls");
```

| Field | |
| --- | --- |
| `status` | `"loading"`, `"ready"` or `"error"` |
| `hasAccess` | whether the customer can use the feature (see below); `fallback` (default `false`) while the entitlements are not loaded |
| `isFallback` | `true` when `hasAccess` is the fallback |
| `entitlement` | the `EffectiveEntitlement`, or `undefined` when the customer has none for this feature |
| `usage` | metered features: `{ consumed, limit, remaining, resetAt, unknown }` |
| `value` | config features: the `ConfigValue` |

| Entitlement | Access when |
| --- | --- |
| Boolean | `enabled` |
| Metered | `enabled`, and one of: no `limit` (unlimited); `remaining > 0`; no `remaining`, and `consumed < limit`; a `limit` but no usage figures (then `usage.unknown` is `true`) |
| Config | present |
| No entitlement for the feature | never |

Decimals (`consumed`, `limit`, `remaining`, number config values) are strings, exactly
as the API sends them, and are compared without going through floating point.
`compareDecimal(a, b)` does the same for your own comparisons.

### Direct calls

```typescript
const customer = await meteroid.customer.get(); // ClientCustomer
const { data: entitlements } = await meteroid.entitlements.list(); // EffectiveEntitlement[]
const { data: subscriptions } = await meteroid.subscriptions.list(); // ClientSubscription[]
```

These call `GET {apiUrl}/api/client/v1/customer`, `/entitlements` and `/subscriptions`.
The entitlements use the same schema as the server API (`GET
/api/v1/customers/{id}/entitlements`), so `@meteroid/sdk` results can seed the client
(`initialEntitlements`). Fields are `camelCase` in TypeScript, like in `@meteroid/sdk`.

Requests carry only the `Authorization` header. A `429` is retried once after its
`Retry-After` delay, and later requests wait for that delay too.

### Errors

Failed calls throw an `ApiException` with the HTTP `status`, the raw `body`, and
`restError` (`{ code, message }`) when the body is a documented error:

```typescript
import { ApiException, ErrorCode } from "@meteroid/browser";

try {
  await meteroid.customer.get();
} catch (err) {
  if (err instanceof ApiException && err.restError?.code === ErrorCode.Unauthorized) {
    // the token route returned a token Meteroid does not accept
  }
}
```

## Embeds

The billing portal can be embedded as a whole or as a single view. Embeds are how
customers change their plan, pay and manage payment methods.

```typescript
const embed = meteroid.mountEmbed("#billing", { view: "plan", theme: "light" });

embed.on("plan_changed", ({ subscriptionId }) => toast("Plan updated"));
// later
embed.destroy();
```

`meteroid.mountEmbed` shares the client's token (an expired token is replaced in the
iframe without a reload) and refreshes the store after every change, so gates follow.
Without a client, `mountEmbed(target, { token })` or `mountEmbed(target, { getToken })`
from the package works the same way, `portalUrl` included.

| Option | |
| --- | --- |
| `view` | `portal` (default), `plan`, `subscriptions`, `subscription`, `usage`, `invoices`, `payment-methods` |
| `theme` | `light` or `dark` |
| `accent` | hex accent color, e.g. `#C6F94E` |
| `radius` | `Sharp`, `Modern` or `Rounded` |
| `bg`, `surface`, `text`, `border` | hex colors |
| `count` | rows per page of the `invoices` view |
| `subscriptionId` | the subscription of the `subscription` view |
| `branding` | `false` hides the "Powered by Meteroid" attribution |
| `height` | initial height in pixels (default 240); the embed then sizes itself |
| `className` | class of the iframe |
| `onNavigate` | handle navigation yourself, see below |

### Events

| Event | Payload | When |
| --- | --- | --- |
| `ready` | `{ view }` | first render |
| `resize` | `{ height }` | the content changed size (the iframe follows) |
| `navigate` | `{ target, url? }` | a link was followed, with `onNavigate` only |
| `plan_changed` | `{ subscriptionId }` | a plan change was confirmed, directly or after checkout |
| `subscription_canceled` | `{ subscriptionId }` | a cancellation was confirmed |
| `payment_method_added` | `{}` | a payment method was saved |
| `checkout_opened`, `checkout_completed` | `{ subscriptionId? }` | around a checkout that needs payment |
| `token_expired` | `{}` | the embed's token expired (it gets a new one when possible) |
| `error` | `{ error }` | no token could be fetched, so nothing was loaded |

Payloads carry ids only. The embed only posts to your page's origin, and the SDK only
accepts messages from its own iframe on the portal's origin.

### Navigation and checkout

By default, links in compact views open the full portal in a new tab, and a checkout
opens in a new tab from the customer's click. Pass `onNavigate` to decide yourself: the
embed then sends `navigate`, with `target: "checkout"` and its `url` for a checkout, e.g.
for a full-page redirect on pages served with `Cross-Origin-Opener-Policy: same-origin`.

```typescript
meteroid.mountEmbed("#billing", {
  view: "plan",
  onNavigate: ({ target, url }) => {
    if (target === "checkout" && url) location.assign(url);
    else router.push(`/billing/${target}`);
  },
});
```

Against a portal older than this protocol, embeds keep resizing and navigating; the other
events are not sent.

## `<script>` tag

Without a bundler, load the IIFE build: it sets `window.Meteroid` (`createMeteroid`,
`mountEmbed`, `buildEmbedUrl`, `ApiException`).

```html
<script src="https://cdn.jsdelivr.net/npm/@meteroid/browser/dist/meteroid.global.js"></script>
<script>
  const meteroid = Meteroid.createMeteroid({
    getToken: () => fetch("/billing-token").then((r) => r.json()),
  });
  meteroid.mountEmbed("#billing", { view: "invoices" });
</script>
```

It also mounts embeds declared in the markup, and keeps the API of the portal's
`/embed.js` (`mountBillingPortal(target, { token, baseUrl, … })`):

```html
<div data-meteroid-portal data-token="…" data-view="plan" data-portal-url="https://app.meteroid.com"></div>
```

## Server rendering

Importing the package touches no browser API, and a client does nothing until it is
used. `initialEntitlements` (for instance from `meteroid.customers.getEffectiveEntitlements`
in `@meteroid/sdk`) makes the entitlements available from the first render, and
`getServerSnapshot()` returns that initial state for hydration.

## Types

The models (`ClientCustomer`, `ClientSubscription`, `EffectiveEntitlement`, …) are
generated from `spec/client/v1/openapi.json` into `src/models` (`./regen_openapi.py` at
the repository root; edit the templates in `codegen/templates/typescript`, not the
generated files). They are exported from the package root, like the rest of the API
(`EntitlementCheck`, `EmbedEvents`, `TokenResponse`, …).

## Development

The package is part of the npm workspace at the repository root.

```bash
npm install         # at the repository root
npm run check       # biome format + lint
npm run typecheck   # tsc --noEmit
npm test            # unit tests, then the built package (ESM, CommonJS, <script>, size)
npm run build       # dist/: index.mjs, index.cjs, meteroid.global.js, types
```

## License

MIT

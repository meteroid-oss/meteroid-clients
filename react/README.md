# @meteroid/react

React bindings for Meteroid: gate features, show usage and embed the billing portal for
the signed-in customer. Built on
[`@meteroid/browser`](https://github.com/meteroid-oss/meteroid-clients/tree/main/browser),
about 1.5 KB gzipped on top of it.

```tsx
import { BillingEmbed, Gate, MeteroidProvider, UsageMeter } from "@meteroid/react";

<MeteroidProvider getToken={() => fetch("/billing-token").then((r) => r.json())} customerKey={org.id}>
  <Gate feature="sso" fallback={<UpgradePrompt />}>
    <SsoSettings />
  </Gate>
  <UsageMeter feature="api_calls" />
  <BillingEmbed view="plan" onPlanChanged={() => toast("Plan updated")} />
</MeteroidProvider>;
```

The browser never holds your API key: your backend mints a short-lived token for the
signed-in customer, which only reads that customer's own billing data.

## Installation

```bash
npm install @meteroid/react
```

React 18 or newer. `@meteroid/browser` comes with it.

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

A page that only reads billing state (gates, meters) is best served by a read-only token
(`"scopes": ["read"]` in the request body) with a short lifetime, such as one hour.
Embeds that change the plan or the payment methods need the `manage` scope, which tokens
get by default.

### 2. Wrap your app

```tsx
import { MeteroidProvider } from "@meteroid/react";

export function Providers({ org, children }: { org: Org; children: React.ReactNode }) {
  return (
    <MeteroidProvider
      getToken={() => fetch("/billing-token").then((r) => r.json())}
      customerKey={org.id}
    >
      {children}
    </MeteroidProvider>
  );
}
```

| Prop | |
| --- | --- |
| `getToken` | fetches a token from your backend. Called when needed, ahead of expiry and when the API reports it expired; an inline function is fine |
| `customerKey` | identifies the signed-in customer: when it changes, all billing state is reset |
| `initialEntitlements` | entitlements loaded on the server, see [Server rendering](#server-rendering) |
| `apiUrl` | REST API base URL. Defaults to the token's `api_url`, then `https://api.meteroid.com` |
| `portalUrl` | portal base URL, for embeds. Defaults to the token's `portal_url`, then `https://app.meteroid.com` |

Billing state loads when the first hook or component mounts, then reloads when the
window regains focus (at most every 30 seconds) and after every change made in an embed.

## Hooks

### `useEntitlement(featureCode, { fallback? })`

```tsx
const { status, hasAccess, isFallback, entitlement, usage, value } = useEntitlement("api_calls");
```

| Field | |
| --- | --- |
| `status` | `"loading"`, `"ready"` or `"error"` |
| `hasAccess` | whether the customer can use the feature; `fallback` (default `false`) until the entitlements are loaded |
| `isFallback` | `true` when `hasAccess` is the fallback |
| `entitlement` | the `EffectiveEntitlement`, or `undefined` when the customer has none for this feature |
| `usage` | metered features: `{ consumed, limit, remaining, resetAt, unknown }` |
| `value` | config features: the `ConfigValue` (`{ kind, value }`) |

| Entitlement | Access when |
| --- | --- |
| Boolean | `enabled` |
| Metered | `enabled`, and one of: no `limit` (unlimited); `remaining > 0`; no `remaining`, and `consumed < limit`; a `limit` but no usage figures (then `usage.unknown` is `true`) |
| Config | present |
| No entitlement for the feature | never |

Decimals (`consumed`, `limit`, `remaining`) are strings, as the API sends them, and are
compared without going through floating point.

### Others

| Hook | Returns |
| --- | --- |
| `useEntitlements()` | `{ status, data: EffectiveEntitlement[], error }` |
| `useCustomer()` | `{ status, data: ClientCustomer, error }` |
| `useSubscriptions()` | `{ status, data: ClientSubscription[], error }` |
| `useMeteroid()` | the `@meteroid/browser` client, e.g. `useMeteroid().refresh()` |

After a successful load, a failed reload keeps `data` (`status` stays `"ready"`) and only
sets `error`. The hooks are built on `useSyncExternalStore`; a component re-renders only
when the resource it reads changes.

## Components

### `<Gate>`

```tsx
<Gate feature="sso" fallback={<UpgradePrompt />} loading={<Spinner />}>
  <SsoSettings />
</Gate>
```

Renders `loading` (default: nothing) until the entitlements are known, then the children
when the customer has access, `fallback` (default: nothing) otherwise.

### `<UsageMeter>`

With a render prop, draw it yourself. The state is `useEntitlement`'s plus `ratio`, the
consumed share of the limit in [0, 1] (for display: it goes through floats; `undefined`
when unlimited or unknown):

```tsx
<UsageMeter feature="api_calls">
  {({ usage, ratio }) => <ProgressBar value={ratio ?? 0} label={`${usage?.consumed} calls`} />}
</UsageMeter>
```

Without one, it renders unstyled markup:

```html
<div data-meteroid-usage-meter data-meteroid-feature="api_calls" data-meteroid-status="ready"
     data-meteroid-access="granted" style="--meteroid-usage-ratio: 0.1234; --meteroid-usage-percent: 12.34%">
  <span data-meteroid-usage-label>API calls</span>
  <span data-meteroid-usage-value>1234 / 10000</span>
  <meter data-meteroid-usage-bar min="0" max="1" value="0.1234"></meter>
</div>
```

`data-meteroid-unlimited` and `data-meteroid-unknown` flag unlimited features and missing
usage figures; `data-meteroid-status` is `loading` until the entitlements are known.

```css
[data-meteroid-usage-meter] { display: grid; gap: 4px; }
[data-meteroid-usage-meter][data-meteroid-access="denied"] [data-meteroid-usage-value] { color: crimson; }
```

### `<BillingEmbed>` and `<BillingPortal>`

```tsx
<BillingEmbed
  view="plan"
  theme="light"
  onPlanChanged={({ subscriptionId }) => toast("Plan updated")}
  onCheckoutCompleted={() => analytics.track("upgraded")}
/>

<BillingPortal accent="#C6F94E" />
```

`view` is one of `portal`, `plan`, `subscriptions`, `subscription` (with
`subscriptionId`), `usage`, `invoices` (with `count`) and `payment-methods`;
`<BillingPortal>` is the full portal. They take the appearance options of
`mountEmbed` (`theme`, `accent`, `radius`, `bg`, `surface`, `text`, `border`, `branding`,
`height`) plus `className` and `style` for the element they mount in, and typed
callbacks:

| Callback | Payload |
| --- | --- |
| `onReady` | `{ view }` |
| `onPlanChanged` | `{ subscriptionId }` |
| `onSubscriptionCanceled` | `{ subscriptionId }` |
| `onPaymentMethodAdded` | `{}` |
| `onCheckoutOpened`, `onCheckoutCompleted` | `{ subscriptionId? }` |
| `onNavigate` | `{ target, url? }` |
| `onError` | `{ error }`: no token could be fetched |

Every change refreshes the provider's state, so gates and meters follow without a
reload. Passing `onNavigate` makes the embed ask instead of navigating: compact views
then post the portal page to open (`target`), and a checkout posts
`target: "checkout"` with its `url`, e.g. for a full-page redirect.

## Typed feature codes

Declare your feature codes once, and `feature` props and `useEntitlement` only accept
them:

```ts
// meteroid.d.ts
import "@meteroid/react";

declare module "@meteroid/react" {
  interface Register {
    featureCode: "sso" | "api_calls" | "seats";
  }
}
```

## Server rendering

Nothing touches `window` at import or during render: on the server, gates render their
`loading` state and embeds an empty placeholder. Pass `initialEntitlements` to render
gates with the real answer from the start; the type is the one `@meteroid/sdk` returns,
so its result passes straight through.

With the Next.js App Router, the components are client components (the package is marked
`"use client"`), so a server component can render the provider:

```tsx
// app/(app)/layout.tsx
import { Meteroid } from "@meteroid/sdk";
import { BillingProvider } from "./billing-provider";

const meteroid = new Meteroid(process.env.METEROID_API_KEY!);

export default async function Layout({ children }: { children: React.ReactNode }) {
  const user = await currentUser();
  const entitlements = await meteroid.customers.getEffectiveEntitlements(user.meteroidCustomerId);
  return (
    <BillingProvider customerKey={user.meteroidCustomerId} initialEntitlements={entitlements}>
      {children}
    </BillingProvider>
  );
}
```

```tsx
// billing-provider.tsx
"use client";
import { MeteroidProvider, type MeteroidProviderProps } from "@meteroid/react";

export function BillingProvider(props: Omit<MeteroidProviderProps, "getToken">) {
  return <MeteroidProvider getToken={() => fetch("/billing-token").then((r) => r.json())} {...props} />;
}
```

(`getToken` is a function, so it cannot cross from a server component; the small client
wrapper supplies it.)

## Development

The package is part of the npm workspace at the repository root, and resolves
`@meteroid/browser` to its build.

```bash
npm install                    # at the repository root
npm run build -w browser       # @meteroid/browser, which this package builds against
npm run check                  # biome format + lint
npm run typecheck              # tsc --noEmit, and the typed feature codes
npm test                       # rendering tests (jsdom, server), then the built package
npm run build                  # dist/: index.mjs, index.cjs, types
```

## License

MIT

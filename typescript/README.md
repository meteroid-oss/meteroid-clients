# Meteroid TypeScript SDK

The official TypeScript/JavaScript SDK for the [Meteroid](https://meteroid.com) billing and
subscription management API.

Everything under `src/api` and `src/models` is generated from `spec/openapi.json` by
`./regen_openapi.py` at the root of this repository — edit the templates in
`codegen/templates/typescript`, not the generated files.

## Installation

```bash
npm install @meteroid/sdk
# or
yarn add @meteroid/sdk
# or
pnpm add @meteroid/sdk
```

Current version: `0.26.0`.

## Quick start

```typescript
import { Currency, Meteroid } from "@meteroid/sdk";

const meteroid = new Meteroid("your-api-key");

// List customers
const customers = await meteroid.customers.listCustomers({ page: 0, perPage: 10 });

// Create a customer
const customer = await meteroid.customers.createCustomer({
  name: "Acme Inc",
  alias: "acme-inc",
  currency: Currency.Eur,
  billingEmail: "billing@acme.com",
  invoicingEmails: [],
  customTaxes: [],
});

// Fetch by id or alias
const fetched = await meteroid.customers.getCustomer("acme-inc");
```

## Configuration

```typescript
const meteroid = new Meteroid("your-api-key", {
  // Point at a different environment. Defaults to https://api.meteroid.com
  serverUrl: "https://your-custom-api.example.com",
  // Per-request timeout in milliseconds. Unset means no timeout.
  requestTimeout: 30_000,
  // Number of retries on 5xx / network failures. Default: 2
  numRetries: 3,
  // Or an explicit backoff schedule, in milliseconds (mutually exclusive with numRetries)
  // retryScheduleInMs: [100, 500, 1000],
  // A custom fetch, useful for tests, proxies, or Cloudflare Workers
  // fetch: myFetch,
});
```

Requests are authenticated with the bearer token you pass to the constructor. `POST` requests
get an automatic `idempotency-key` header when you do not supply one.

## Resources

The client exposes one property per API resource:

| Property | Methods |
| --- | --- |
| `addOns` | `listAddons`, `createAddon`, `getAddon`, `updateAddon`, `archiveAddon`, `unarchiveAddon`, `listAddOnEntitlements` |
| `batchJobs` | `listBatchJobs`, `getBatchJob`, `listBatchJobFailures` |
| `checkoutSessions` | `listCheckoutSessions`, `createCheckoutSession`, `getCheckoutSession`, `cancelCheckoutSession` |
| `connect` | `listConnectedAccounts`, `createConnectedAccount`, `getConnectedAccount`, `disconnectAccount`, `createOnboardingLink` |
| `coupons` | `listCoupons`, `createCoupon`, `getCoupon`, `updateCoupon`, `archiveCoupon`, `unarchiveCoupon`, `disableCoupon`, `enableCoupon` |
| `creditNotes` | `listCreditNotes`, `getCreditNoteById`, `patchCreditNoteCustomProperties`, `downloadCreditNotePdf` |
| `customProperties` | `listDefinitions`, `createDefinition`, `getDefinition`, `updateDefinition`, `archiveDefinition` |
| `customers` | `listCustomers`, `createCustomer`, `getCustomer`, `updateCustomer`, `patchCustomer`, `archiveCustomer`, `unarchiveCustomer`, `getEffectiveEntitlements`, `createPortalToken` |
| `events` | `ingestEvents` |
| `features` | `listFeatures`, `getFeature` |
| `invoices` | `listInvoices`, `getInvoiceById`, `patchInvoiceCustomProperties`, `downloadInvoicePdf` |
| `metrics` | `listMetrics`, `createMetric`, `getMetric`, `updateMetric`, `archiveMetric`, `unarchiveMetric` |
| `oAuth` | `introspectEndpoint`, `revokeEndpoint`, `tokenEndpoint` |
| `oAuthApps` | `listOauthApps`, `createOauthApp`, `getOauthApp`, `deleteOauthApp`, `rotateClientSecret` |
| `plans` | `listPlans`, `createPlan`, `getPlanDetails`, `replacePlan`, `patchPlan`, `publishPlan`, `archivePlan`, `unarchivePlan`, `listPlanVersions`, `listPlanVersionEntitlements`, `setPlanMinimum`, `deletePlanMinimum` |
| `productFamilies` | `listProductFamilies`, `createProductFamily`, `getProductFamilyByIdOrAlias` |
| `products` | `listProducts`, `createProduct`, `getProduct`, `updateProduct`, `archiveProduct`, `unarchiveProduct`, `listProductEntitlements` |
| `subscriptions` | `listSubscriptions`, `createSubscription`, `subscriptionDetails`, `updateSubscription`, `cancelSubscription`, `listSubscriptionEntitlements` |
| `usage` | `getCustomerUsage`, `getSubscriptionUsage`, `getUsageSummary` |

### Subscriptions

```typescript
import { SubscriptionActivationConditionEnum } from "@meteroid/sdk";

const subscription = await meteroid.subscriptions.createSubscription({
  customerIdOrAlias: "acme-inc",
  planId: "plan_...",
  startDate: "2026-01-01",
  activationCondition: SubscriptionActivationConditionEnum.OnStart,
});

const details = await meteroid.subscriptions.subscriptionDetails(subscription.id);

await meteroid.subscriptions.cancelSubscription(details.id, {
  reason: "Customer requested cancellation",
});
```

### Usage events

```typescript
await meteroid.events.ingestEvents({
  events: [
    {
      eventId: "evt_123",
      code: "api_call",
      customerId: "acme-inc",
      timestamp: new Date().toISOString(),
      properties: { endpoint: "/api/v1/users", method: "GET" },
    },
  ],
});
```

### Invoice and credit-note PDFs

PDF downloads return raw bytes:

```typescript
const pdf: Uint8Array = await meteroid.invoices.downloadInvoicePdf("inv_...");
await fs.promises.writeFile("invoice.pdf", pdf);
```

## Webhook verification

With Express (or anything else built on Node's `http` module), pass `req.headers` as is:

```typescript
import express from "express";
import { Webhook, WebhookVerificationError } from "@meteroid/sdk";

const app = express();
const webhook = new Webhook("whsec_your_webhook_secret");

// `express.raw` keeps the body as the raw bytes that were signed.
app.post("/webhooks/meteroid", express.raw({ type: "*/*" }), (req, res) => {
  try {
    const event = webhook.verify(req.body, req.headers);
    console.log("Received event:", event);
    res.status(200).send("OK");
  } catch (err) {
    if (err instanceof WebhookVerificationError) {
      res.status(400).send("Invalid signature");
    } else {
      throw err;
    }
  }
});
```

With the fetch API (Next.js route handlers, Cloudflare Workers, Deno, Bun), pass the `Headers`:

```typescript
export async function POST(request: Request): Promise<Response> {
  try {
    const event = webhook.verify(await request.text(), request.headers);
    console.log("Received event:", event);
    return new Response("OK");
  } catch (err) {
    if (err instanceof WebhookVerificationError) {
      return new Response("Invalid signature", { status: 400 });
    }
    throw err;
  }
}
```

`verify` takes either a plain header object (values may be `string`, `string[]` or `undefined`,
as in Node's `IncomingHttpHeaders`) or a `Headers` instance, and matches header names
case-insensitively. It accepts both the Standard Webhooks headers and the legacy Svix aliases.
The `webhook-*` header wins when both are present:

- `webhook-id` / `svix-id`
- `webhook-signature` / `svix-signature`
- `webhook-timestamp` / `svix-timestamp`

The payload must be the **raw** request body — parsing it first breaks the signature.

`verify` returns the parsed JSON body (`unknown`). Every failure — missing headers, a bad or stale
signature, or a correctly signed body that is not JSON — throws a `WebhookVerificationError`.

## Error handling

```typescript
import { ApiException, ErrorCode } from "@meteroid/sdk";

try {
  await meteroid.customers.getCustomer("does-not-exist");
} catch (err) {
  if (!(err instanceof ApiException)) throw err;

  if (err.restError?.code === ErrorCode.NotFound) {
    console.error("not found:", err.restError.message);
  } else if (err.restError) {
    console.error(`${err.status} ${err.restError.code}: ${err.restError.message}`);
  } else if (err.oauthError) {
    // Only the OAuth endpoints return this shape.
    console.error(`${err.status} ${err.oauthError.error}: ${err.oauthError.errorDescription}`);
  } else {
    // Not a documented error body (proxy page, unknown error code, ...).
    console.error(`${err.status}: ${err.body}`);
  }
}
```

Every non-2xx response throws an `ApiException`. Its body is parsed as a `RestErrorResponse`
(`restError`: `code` + `message`) or, failing that, an `OAuthErrorResponse` (`oauthError`). The HTTP
`status`, the response `headers` and the raw `body` string are always set, including when the body
matches neither shape — which is also the case if the server sends an `ErrorCode` this SDK version
does not know yet.

5xx responses are retried (see `numRetries` / `retryScheduleInMs`); once retries are exhausted the
last response is thrown as an `ApiException`.

## Types

Every model and every request/response type is exported from the package root:

```typescript
import type {
  Customer,
  CustomerCreateRequest,
  Invoice,
  Plan,
  Subscription,
  Fee,
} from "@meteroid/sdk";
```

### Conventions

- **Field names** are `lowerCamelCase` in TypeScript and are mapped to the wire's `snake_case`
  by the generated serializers.
- **`date-time`** fields are `Date` (see [Dates and times](#dates-and-times)). **`date`** fields
  (`start_date`, `invoice_date`, …) are ISO `YYYY-MM-DD` strings.
- **Decimal** fields (`rate`, `flat_fee`, `unit_price`, …) are `string` (see
  [Decimals](#decimals)).
- **Enums** are TypeScript `enum`s whose values are the wire strings
  (`InvoiceStatus.Closed === "CLOSED"`). Because they are nominal, pass the enum member
  (`Currency.Eur`) rather than a bare string literal.

### Decimals

Decimal fields are strings on purpose: the API sends them as exact decimal strings, and converting
them to `number` would silently lose precision (`0.1 + 0.2 !== 0.3`). Pass them through as they are,
and use a decimal library such as [`decimal.js`](https://www.npmjs.com/package/decimal.js) or
[`big.js`](https://www.npmjs.com/package/big.js) when you need arithmetic:

```typescript
import Decimal from "decimal.js";

const amount = new Decimal(subLineItem.unitPrice).times(subLineItem.quantity); // exact
```

The SDK itself does not depend on any decimal library.

### Dates and times

`date-time` fields are JavaScript `Date`s, so they have **millisecond** precision: when the API sends
microseconds, the extra digits are truncated.

Every date-time the API sends is in UTC. Some fields come without a UTC offset (e.g.
`2026-09-19T10:00:00.123456`); the SDK reads those as UTC rather than local time, which is what
`new Date(...)` would do with them. `toISOString()` always renders a `Date` in UTC
(`2026-09-19T10:00:00.123Z`), while `toString()` and `toLocaleString()` use the local time zone.

### Discriminated unions

Polymorphic schemas are discriminated unions. Most use `type` as the tag; the config-entitlement
values use `kind`:

```typescript
import type { Fee } from "@meteroid/sdk";

function describe(fee: Fee): string {
  switch (fee.type) {
    case "RATE":
      return `rate ${fee.rates.length} tier(s)`;
    case "USAGE":
      return `usage on metric ${fee.metricId}`;
    default:
      return fee.type;
  }
}
```

Each variant is also exported by name (`FeeRate`, `FeeUsage`, `ConfigValueNumber`, …).

## Environment support

- **Node.js**: 18.0.0 or newer (uses the global `fetch`)
- **Browsers**: any browser with `fetch`
- **Cloudflare Workers**: supported (the `credentials` option is omitted where unavailable)
- **Deno / Bun**: supported via npm compatibility

## Development

```bash
npm install
npm run typecheck   # tsc --noEmit
npm run check       # biome format + lint + assists
npm run build       # emit dist/
npm test            # unit tests, then the built package from an ES module
```

Regenerating the client (from the repository root):

```bash
./regen_openapi.py
```

## License

MIT

## Links

- [Meteroid documentation](https://docs.meteroid.com)
- [GitHub repository](https://github.com/meteroid-oss/meteroid-clients)
- [Report an issue](https://github.com/meteroid-oss/meteroid-clients/issues)

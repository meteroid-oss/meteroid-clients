# Meteroid TypeScript SDK

Meteroid billing API client

```sh
npm install @meteroid/sdk
```

The package ships ESM and CommonJS builds and runs on Node.js 20+, Deno, Bun, browsers and edge
runtimes: it only needs `fetch`. Every method of the API is listed in [api.md](api.md).

## Usage

```ts
import { Meteroid } from "@meteroid/sdk";

const client = new Meteroid({ apiKey: "your-api-key" });

const addOn = await client.addOns.retrieve("addon_id");
console.log(addOn);
```

Without `apiKey`, the client reads the `METEROID_API_KEY` environment variable, and
without `baseURL` the `METEROID_BASE_URL` one, then the API's default server URL. When the
API declares no server, one of them is required. The other options are `timeout` (milliseconds),
`maxRetries`, `defaultHeaders`, `defaultQuery`, `fetch`, `middleware` and `debug`.

Every API area is a property of the client, and every method takes a last `RequestOptions`
argument: `{ signal, headers, query, timeout, maxRetries, idempotencyKey }`.

## Models

Models are plain objects with camelCase properties, converted from and to their JSON form by
`XSerializer.parse(json)` and `XSerializer.serialize(value)`. Properties the API sends that this
version of the SDK does not know are kept under their JSON names, and sent back when the object
is serialized: `(value as typeof value & { new_field?: string }).new_field`.

## Errors

Everything the SDK throws is a `MeteroidError`:

| Error | When |
|---|---|
| `APIError` | A non-2xx response: `status`, `headers`, `requestId`, `body` (the raw text) and `error` (the body parsed with its declared schema, else as JSON) |
| `BadRequestError`, `AuthenticationError`, `PermissionDeniedError`, `NotFoundError`, `ConflictError`, `UnprocessableEntityError`, `RateLimitError`, `InternalServerError` | `APIError`s of statuses 400, 401, 403, 404, 409, 422, 429 and 5xx |
| `APIConnectionError` | No response: DNS, TLS or network failure, with the transport error as `cause` |
| `APIConnectionTimeoutError` | No response within the timeout (an `APIConnectionError`) |
| `APIUserAbortError` | The call's `signal` aborted |
| `APIDecodeError` | A successful response that is not valid JSON or not the expected event stream |

```ts
import { NotFoundError } from "@meteroid/sdk";

try {
  await client.addOns.retrieve("addon_id");
} catch (error) {
  if (error instanceof NotFoundError) {
    console.log(error.status, error.requestId, error.error);
  }
}
```

## Raw responses

Every method returns an `APIPromise`: await it for the parsed body, or ask for the HTTP response
too.

```ts
const { data, response, requestId } = await client.addOns.retrieve("addon_id").withResponse();
const raw: Response = await client.addOns.retrieve("addon_id").asResponse(); // body unread
```

## Retries and timeouts

Connection errors, timeouts, 408, 429 and 5xx responses are retried twice with exponential
backoff, honouring `Retry-After` and `retry-after-ms`, when the request is idempotent or carries
an `Idempotency-Key` (POST requests get one automatically). Each attempt times out after
`timeout` milliseconds (`Infinity` waits forever).

```ts
const client = new Meteroid({ maxRetries: 5, timeout: 20_000 });
await client.addOns.retrieve("addon_id", { maxRetries: 0, timeout: 5_000 });
```

`middleware` wraps every attempt, for logging, caching or custom headers, and `fetch` replaces
the `fetch` implementation.

- Source: https://github.com/meteroid-oss/meteroid-clients
- License: Apache-2.0

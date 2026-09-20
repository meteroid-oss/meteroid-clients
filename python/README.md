# Meteroid Python SDK

Official Python SDK for the [Meteroid](https://meteroid.com) billing API.

Requires Python 3.9+. The only runtime dependency is [`httpx`](https://www.python-httpx.org/);
models are plain dataclasses, fully type hinted, and the package ships `py.typed`.

## Installation

```bash
pip install meteroid
```

## Quick Start

```python
from meteroid import Meteroid

client = Meteroid("your-api-key")

customers = client.customers.list_customers()
print(f"Found {len(customers.data)} customers")
```

### Asyncio

Every resource is also available on an asyncio client with the same method names:

```python
import asyncio
from meteroid import MeteroidAsync


async def main() -> None:
    async with MeteroidAsync("your-api-key") as client:
        customers = await client.customers.list_customers()
        print(f"Found {len(customers.data)} customers")


asyncio.run(main())
```

## Available APIs

| Resource                    | Description                       |
| --------------------------- | --------------------------------- |
| `client.customers`          | Manage customers                  |
| `client.subscriptions`      | Manage subscriptions              |
| `client.invoices`           | Access invoices and download PDFs |
| `client.plans`              | List available plans              |
| `client.product_families`   | Manage product families           |
| `client.events`             | Send usage events                 |
| `client.metrics`            | Manage billable metrics           |
| `client.usage`              | Read aggregated usage             |
| `client.features`           | List features                     |
| `client.checkout_sessions`  | Create checkout sessions          |

The full list is exported from `meteroid.api`.

## Examples

### Creating a Customer

```python
from meteroid import Meteroid
from meteroid.models import Currency, CustomerCreateRequest

client = Meteroid("your-api-key")

customer = client.customers.create_customer(
    CustomerCreateRequest(
        name="Acme Corp",
        currency=Currency.USD,
        custom_taxes=[],
        invoicing_emails=["billing@acme.com"],
        alias="acme",
    )
)
print(f"Created customer: {customer.id}")
```

Query parameters are passed as keyword arguments:

```python
customers = client.customers.list_customers(page=0, per_page=10, search="acme")
for customer in customers.data:
    print(f"Customer: {customer.name} ({customer.id})")
```

### Downloading an Invoice PDF

```python
pdf_bytes = client.invoices.download_invoice_pdf("invoice_id")
with open("invoice.pdf", "wb") as fh:
    fh.write(pdf_bytes)
```

## Metering and Entitlements

The calls a usage-based integration needs: ingest events, read the metrics
and features they feed, and check what a customer is entitled to.

```python
import uuid
from datetime import datetime, timezone

from meteroid import Meteroid
from meteroid.models import (
    BooleanEffectiveEntitlementValue,
    ConfigEffectiveEntitlementValue,
    Event,
    IngestEventsRequest,
    MeteredEffectiveEntitlementValue,
)

client = Meteroid("your-api-key")

# 1. Ingest usage events. `code` is the billable metric code; `properties` are
#    string key-value pairs the metric can filter and aggregate on.
result = client.events.ingest_events(
    IngestEventsRequest(
        events=[
            Event(
                event_id=str(uuid.uuid4()),  # idempotency key for the event
                code="api_call",
                customer_id="acme",  # customer ID or alias
                timestamp=datetime.now(timezone.utc).isoformat(),
                properties={"endpoint": "/v1/users", "method": "GET"},
            )
        ],
        allow_partial_failures=True,
    )
)
for failure in result.failures or []:
    print(f"event {failure.event_id} rejected: {failure.reason}")

# 2. Read the metrics and the usage they aggregate.
metrics = client.metrics.list_metrics(search="api")
for summary in metrics.data:
    print(summary.code, summary.aggregation_type)

usage = client.usage.get_customer_usage(
    "acme", start_date="2026-09-01", end_date="2026-09-30"
)
for metric_usage in usage.usage:
    print(metric_usage.metric_code, metric_usage.total_value)  # a Decimal

# 3. List the features entitlements are granted on.
features = client.features.list_features()
for feature in features.data:
    print(feature.code, feature.feature_type)

# 4. Resolve what the customer is entitled to right now.
entitlements = client.customers.get_effective_entitlements("acme")
for entitlement in entitlements.data:
    value = entitlement.value.content
    if isinstance(value, BooleanEffectiveEntitlementValue):
        print(entitlement.feature.code, "enabled" if value.enabled else "disabled")
    elif isinstance(value, MeteredEffectiveEntitlementValue):
        print(entitlement.feature.code, value.usage.consumed, "/", value.spec.limit)
    elif isinstance(value, ConfigEffectiveEntitlementValue):
        print(entitlement.feature.code, value.value.content.value)
```

A feature is also available by ID or code with `client.features.get_feature(...)`,
and a metric with `client.metrics.get_metric(...)`. `client.usage.get_subscription_usage`
reads usage for a single subscription.

## Configuration

```python
from meteroid import Meteroid, MeteroidOptions

client = Meteroid(
    "your-api-key",
    MeteroidOptions(
        # For self-hosted instances
        server_url="https://your-meteroid-instance.com",
        # Seconds; None disables the timeout
        timeout=30.0,
        # Retries on 5xx / transport failures (default: 2)
        num_retries=3,
        # Or take full control of the backoff, in seconds
        # retry_schedule=[0.1, 0.5, 1.0],
    ),
)
```

`client.close()` releases the underlying connection pool (`await client.aclose()`
on the async client); both clients also work as context managers. You can pass
your own `httpx.Client` / `httpx.AsyncClient` as the third argument if you need
custom transports or proxies.

The `timeout` is applied per request, so it is honoured with a caller-supplied
`httpx` client too — and it takes precedence over that client's own timeout. Pass
`timeout=None` to disable it and let your client decide.

### Timeouts and retries

`num_retries` / `retry_schedule` cover HTTP 5xx responses *and* transport
failures, **including client-side timeouts**: each attempt gets the full
`timeout`, so a request can take up to `timeout * (1 + len(retry_schedule))` plus
the backoff delays before `NetworkException` is raised. This is a deliberate
divergence from the Rust SDK, which propagates a timeout immediately without
retrying. Retries are safe here because every attempt reuses the same
auto-generated `idempotency-key`. Set `num_retries=0` for one attempt only.

## Models

Models are dataclasses with explicit JSON (de)serialization:

```python
from meteroid.models import Customer

customer = Customer.from_json(raw_json)   # or Customer.from_dict(payload)
payload = customer.to_dict()              # None-valued fields are omitted
```

### Tagged unions

Discriminated unions (for example `Fee` or `ConfigValue`) carry the
discriminator and the decoded variant side by side:

```python
from meteroid.models import Fee, RatePlanFee

fee = Fee(type="RATE", content=RatePlanFee(rates=[]))
assert fee.to_dict()["type"] == "RATE"
```

To work with the variant, narrow on `content`, not on the discriminator: the
type checker does not link the two fields, so checking `type == "RATE"` leaves
`content` typed as the full union. `isinstance` works on every Python version:

```python
from meteroid.models import (
    BooleanConfigValue,
    ConfigValue,
    JsonConfigValue,
    NumberConfigValue,
    TextConfigValue,
)


def describe(config: ConfigValue) -> str:
    content = config.content
    if isinstance(content, NumberConfigValue):
        return f"number {content.value:f}"  # a Decimal
    if isinstance(content, BooleanConfigValue):
        return "on" if content.value else "off"
    if isinstance(content, TextConfigValue):
        return content.value.upper()
    # Only `JsonConfigValue` is left; its value is any JSON (dict, list,
    # scalar or None).
    return f"json {content.value!r}"
```

On Python 3.10+, `match` does the same:

```python
def describe(config: ConfigValue) -> str:
    match config.content:
        case NumberConfigValue(value=number):
            return f"number {number}"
        case BooleanConfigValue(value=flag):
            return "on" if flag else "off"
        case TextConfigValue(value=text):
            return text
        case JsonConfigValue(value=data):
            return f"json {data!r}"
```

A discriminator value this SDK version does not know raises
`ModelParseError` (wrapped in `ResponseDecodeError` when it comes from an API
response).

## Error Handling

```python
from meteroid import ApiException, Meteroid
from meteroid.models import ErrorCode

client = Meteroid("your-api-key")

try:
    customer = client.customers.get_customer("invalid-id")
except ApiException as exc:
    if exc.code is ErrorCode.NOT_FOUND:
        ...
    print(f"HTTP error {exc.status_code}: {exc.code} {exc.message}")
```

Every non-2xx response raises `meteroid.ApiException`. Its body is decoded as a
`RestErrorResponse` (`code` + `message`), or as an `OAuthErrorResponse` for the
OAuth endpoints (`error`, `error_description`); `exc.payload` holds the result,
and `exc.code` / `exc.message` read either one. When the body matches neither --
not JSON, or an error code newer than this SDK -- `payload`, `code` and
`message` are `None`, while `exc.status_code` and `exc.raw_body` are always set.

`meteroid.NetworkException` is raised when the request never reached the API
(connection error or timeout, after retries are exhausted).

Every exception the SDK raises derives from `meteroid.MeteroidError`, so a
single `except MeteroidError` covers them all:

```text
MeteroidError
├── ApiException               non-2xx response: status_code, raw_body, payload, code, message
├── NetworkException           no response: connection error or timeout, after retries
├── ResponseDecodeError        2xx body that is not JSON or does not match its model:
│                              status_code, raw_body; the cause is chained (__cause__)
├── ModelParseError            Model.from_dict / from_json got an invalid payload
├── WebhookVerificationError   webhook signature missing, stale or invalid
└── InvalidWebhookSecretError  Webhook(...) secret is not valid base64, or is empty
```

`ResponseDecodeError`, `ModelParseError` and `InvalidWebhookSecretError` are
also `ValueError`s. Invalid arguments are rejected with the usual built-in
exceptions before any request is sent: serializing a non-finite `Decimal`
(`NaN`, `Infinity`) raises `ValueError`, for example.

## Webhooks

Signature verification supports both Standard Webhooks (`webhook-*`) and Svix
(`svix-*`) headers:

```python
from meteroid import Webhook, WebhookVerificationError

wh = Webhook("whsec_your_webhook_secret")
try:
    wh.verify(request_body, request_headers)
except WebhookVerificationError:
    ...  # reject the delivery
```

The secret is accepted with or without its `whsec_` prefix, or as the raw key
bytes. A secret that is not valid base64, or decodes to an empty key, raises
`InvalidWebhookSecretError` when the `Webhook` is built.

## Development

```bash
cd python
uv venv && uv pip install -e '.[dev]'
uv run ruff check . && uv run ruff format --check .
uv run mypy
uv run pytest
```

The `meteroid/api/*.py` and `meteroid/models/*.py` modules (except the
hand-written `api/common.py`) are generated from
`spec/openapi.json` by `./regen_openapi.py` at the repository root.

## License

MIT

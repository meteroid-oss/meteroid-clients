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

### Sending Usage Events

```python
from meteroid.models import Event, IngestEventsRequest

client.events.ingest_events(
    IngestEventsRequest(
        events=[
            Event(
                code="api_call",
                customer_id="customer_id",
                event_id="unique_event_id",
                timestamp="2024-01-15T10:30:00Z",
                properties={"endpoint": "/api/v1/users", "method": "GET"},
            )
        ]
    )
)
```

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

Discriminated unions (for example `Fee`) carry the discriminator and the decoded
variant side by side:

```python
from meteroid.models import Fee, RatePlanFee

fee = Fee(type="RATE", content=RatePlanFee(rates=[]))
assert fee.to_dict()["type"] == "RATE"
```

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

## Development

```bash
cd python
uv venv && uv pip install -e '.[dev]'
uv run ruff check . && uv run ruff format --check .
uv run mypy
uv run pytest
```

The `meteroid/api/*.py` and `meteroid/models/*.py` modules (except the
hand-written `api/common.py` and `models/errors.py`) are generated from
`spec/openapi.json` by `./regen_openapi.py` at the repository root.

## License

MIT

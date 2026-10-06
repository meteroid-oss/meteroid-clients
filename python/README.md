# Meteroid Python SDK

Meteroid billing API client

## Installation

```sh
pip install meteroid
```

Python 3.10 or newer. The SDK depends on `httpx` only and is fully typed. Every method of the API
is listed in [api.md](api.md).

## Usage

```python
from meteroid import Meteroid

client = Meteroid(api_key="your-api-key")

add_on = client.add_ons.retrieve("addon_id")
print(add_on)
```

Without `api_key`, the client reads `METEROID_API_KEY`, and `METEROID_BASE_URL`
overrides the default base URL (required, or `base_url=`, when the API has none). Every argument
is a keyword argument. The constructor also takes `base_url`, `timeout`,
`max_retries`, `default_headers`, `http_client` (an `httpx.Client` of yours), `middleware`, and
the credentials the API accepts (`token_provider`, `basic_auth`, `api_keys`). Close the client,
or use it as a context manager, to release its connections.

`AsyncMeteroid` has the same resources for asyncio:

```python
from meteroid import AsyncMeteroid

async with AsyncMeteroid() as client:
    add_on = await client.add_ons.retrieve("addon_id")
```

## Requests

The fields of a JSON or form request body are keyword arguments, next to the query and header
parameters; path parameters come first:

```python
client.connect.create_onboarding_link("id", redirect_url="redirect_url")
```

An optional argument left out is not sent; `None` sends `null` where the API accepts it. An enum
argument takes the enum or its value as a string. Other bodies (lists, unions, files) are one
`body` argument.

Every method also takes, for that request only, `extra_headers=`, `extra_query=`, `extra_body=`
(merged into the body), `timeout=` and `max_retries=`. These headers, like `default_headers`, win
over the client's credentials.

## Models

Models are keyword-only dataclasses with `from_dict`/`to_dict`. In models requests send, an
optional field that accepts `null` defaults to `UNSET` (from `meteroid.models`): it is
left out of the request, while `None` sends `null`; in response models it is simply `None` when
absent. A field holding a string or an object, such as an expandable id, is typed `str | Model`.
A discriminated union is the union of its variant models (`Circle | Square | UnknownVariant`),
decoded into the variant the tag names; when its variants share fields, it is a model holding the
discriminator and the variant, and passing `content=` alone fills in the tag.

Properties the API added after this SDK was generated are kept in `extra_fields` (and read
as attributes at runtime), and sent back when the model is serialized. A property named
after a model member, such as `extra_fields` or `to_dict`, gets a trailing `_`.

Multipart bodies take `Upload(content, filename, content_type)` files, and binary bodies bytes or
file objects.

## Raw responses

Prefix a call with `with_raw_response` for the HTTP response next to the decoded result:

```python
response = client.with_raw_response.add_ons.retrieve("addon_id")
print(response.status_code, response.headers, response.request_id)
add_on = response.parse()
```

## Errors

Every error derives from `MeteroidError`. A non-2xx response raises an `APIStatusError`
subclass named after its status (`BadRequestError`, `AuthenticationError`,
`PermissionDeniedError`, `NotFoundError`, `ConflictError`, `UnprocessableEntityError`,
`RateLimitError`, `InternalServerError`), whose `body` is the error response decoded into its
schema (its JSON when the API declares none) and `request_id` the id to quote to support.

```python
from meteroid import APIConnectionError, APITimeoutError, NotFoundError

try:
    client.add_ons.retrieve("addon_id")
except NotFoundError as error:
    print(error.status_code, error.request_id, error.body)
except APITimeoutError:
    ...  # the request timed out, after retries
except APIConnectionError:
    ...  # no response, after retries
```

A successful response that does not decode raises `APIResponseValidationError`.

## Retries and timeouts

Connection errors, timeouts, 408, 429 and 5xx responses are retried twice with exponential
backoff, honoring `Retry-After`, when replaying the request is safe: for idempotent methods
and requests with an `Idempotency-Key` header, which every POST gets. Requests time out after
60 seconds.

```python
client = Meteroid(max_retries=5, timeout=20.0)
client.with_options(max_retries=0).add_ons.retrieve("addon_id")
client.add_ons.retrieve("addon_id", timeout=5.0, max_retries=0)  # for one call
```

## Middleware

`middleware=[...]` wraps every HTTP attempt: a callable receiving the `httpx.Request` and
`next`, returning an `httpx.Response`, to cache, log or sign requests.

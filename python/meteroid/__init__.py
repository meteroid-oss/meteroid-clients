"""Meteroid Billing SDK for Python.

The main entry points are :class:`meteroid.Meteroid` (sync) and
:class:`meteroid.MeteroidAsync` (asyncio).

Example
-------
::

    from meteroid import Meteroid

    client = Meteroid("your-api-key")
    customers = client.customers.list_customers()
    print(f"Found {len(customers.data)} customers")
"""

from . import models
from ._version import __version__
from .api import Meteroid, MeteroidAsync, MeteroidOptions
from .errors import (
    ApiException,
    MeteroidError,
    ModelParseError,
    NetworkException,
    ResponseDecodeError,
)
from .webhooks import Webhook, WebhookVerificationError

__all__ = [
    "ApiException",
    "Meteroid",
    "MeteroidAsync",
    "MeteroidError",
    "MeteroidOptions",
    "ModelParseError",
    "NetworkException",
    "ResponseDecodeError",
    "Webhook",
    "WebhookVerificationError",
    "__version__",
    "models",
]

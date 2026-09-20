# this file is @generated
"""Meteroid API client."""

import dataclasses
import typing as t

import httpx

from .add_ons import AddOns, AddOnsAsync
from .batch_jobs import BatchJobs, BatchJobsAsync
from .checkout_sessions import CheckoutSessions, CheckoutSessionsAsync
from .common import (
    DEFAULT_NUM_RETRIES,
    DEFAULT_SERVER_URL,
    DEFAULT_TIMEOUT,
    Configuration,
    default_retry_schedule,
)
from .connect import Connect, ConnectAsync
from .coupons import Coupons, CouponsAsync
from .credit_notes import CreditNotes, CreditNotesAsync
from .custom_properties import CustomProperties, CustomPropertiesAsync
from .customers import Customers, CustomersAsync
from .events import Events, EventsAsync
from .features import Features, FeaturesAsync
from .invoices import Invoices, InvoicesAsync
from .metrics import Metrics, MetricsAsync
from .o_auth import OAuth, OAuthAsync
from .o_auth_apps import OAuthApps, OAuthAppsAsync
from .plans import Plans, PlansAsync
from .product_families import ProductFamilies, ProductFamiliesAsync
from .products import Products, ProductsAsync
from .subscriptions import Subscriptions, SubscriptionsAsync
from .usage import Usage, UsageAsync


@dataclasses.dataclass
class MeteroidOptions:
    """Options for configuring the Meteroid client."""

    server_url: t.Optional[str] = None
    """Custom server URL. Defaults to `https://api.meteroid.com`."""

    timeout: t.Optional[float] = DEFAULT_TIMEOUT
    """Timeout for HTTP requests, in seconds. `None` disables the timeout."""

    num_retries: t.Optional[int] = None
    """Number of retries on server-side errors or timeouts. Defaults to 2."""

    retry_schedule: t.Optional[t.List[float]] = None
    """Explicit list of delays (seconds) before each retry. Takes precedence
    over `num_retries`."""


def _build_configuration(
    token: str, options: t.Optional[MeteroidOptions]
) -> Configuration:
    options = options if options is not None else MeteroidOptions()
    if options.retry_schedule is not None:
        retry_schedule = list(options.retry_schedule)
    else:
        num_retries = (
            options.num_retries
            if options.num_retries is not None
            else DEFAULT_NUM_RETRIES
        )
        retry_schedule = default_retry_schedule(num_retries)
    return Configuration(
        base_path=(options.server_url or DEFAULT_SERVER_URL).rstrip("/"),
        bearer_access_token=token,
        timeout=options.timeout,
        retry_schedule=retry_schedule,
    )


class Meteroid:
    """Synchronous Meteroid API client.

    Example
    -------
    ::

        from meteroid import Meteroid

        client = Meteroid("your-api-key")
        customers = client.customers.list_customers()
    """

    _cfg: Configuration
    _httpx_client: httpx.Client
    _owns_httpx_client: bool

    def __init__(
        self,
        token: str,
        options: t.Optional[MeteroidOptions] = None,
        httpx_client: t.Optional[httpx.Client] = None,
    ) -> None:
        self._cfg = _build_configuration(token, options)
        self._owns_httpx_client = httpx_client is None
        self._httpx_client = (
            httpx_client
            if httpx_client is not None
            else httpx.Client(timeout=self._cfg.timeout)
        )

    def with_token(self, token: str) -> "Meteroid":
        """Return a client using a different token but the same connection pool."""
        clone = Meteroid.__new__(Meteroid)
        clone._cfg = dataclasses.replace(self._cfg, bearer_access_token=token)
        clone._httpx_client = self._httpx_client
        clone._owns_httpx_client = False
        return clone

    def close(self) -> None:
        if self._owns_httpx_client:
            self._httpx_client.close()

    def __enter__(self) -> "Meteroid":
        return self

    def __exit__(self, *exc_info: t.Any) -> None:
        self.close()

    @property
    def add_ons(self) -> AddOns:
        """Access the add ons API."""
        return AddOns(self._cfg, self._httpx_client)

    @property
    def batch_jobs(self) -> BatchJobs:
        """Access the batch jobs API."""
        return BatchJobs(self._cfg, self._httpx_client)

    @property
    def checkout_sessions(self) -> CheckoutSessions:
        """Access the checkout sessions API."""
        return CheckoutSessions(self._cfg, self._httpx_client)

    @property
    def connect(self) -> Connect:
        """Access the connect API."""
        return Connect(self._cfg, self._httpx_client)

    @property
    def coupons(self) -> Coupons:
        """Access the coupons API."""
        return Coupons(self._cfg, self._httpx_client)

    @property
    def credit_notes(self) -> CreditNotes:
        """Access the credit notes API."""
        return CreditNotes(self._cfg, self._httpx_client)

    @property
    def custom_properties(self) -> CustomProperties:
        """Access the custom properties API."""
        return CustomProperties(self._cfg, self._httpx_client)

    @property
    def customers(self) -> Customers:
        """Access the customers API."""
        return Customers(self._cfg, self._httpx_client)

    @property
    def events(self) -> Events:
        """Access the events API."""
        return Events(self._cfg, self._httpx_client)

    @property
    def features(self) -> Features:
        """Access the features API."""
        return Features(self._cfg, self._httpx_client)

    @property
    def invoices(self) -> Invoices:
        """Access the invoices API."""
        return Invoices(self._cfg, self._httpx_client)

    @property
    def metrics(self) -> Metrics:
        """Access the metrics API."""
        return Metrics(self._cfg, self._httpx_client)

    @property
    def o_auth(self) -> OAuth:
        """Access the o auth API."""
        return OAuth(self._cfg, self._httpx_client)

    @property
    def o_auth_apps(self) -> OAuthApps:
        """Access the o auth apps API."""
        return OAuthApps(self._cfg, self._httpx_client)

    @property
    def plans(self) -> Plans:
        """Access the plans API."""
        return Plans(self._cfg, self._httpx_client)

    @property
    def product_families(self) -> ProductFamilies:
        """Access the product families API."""
        return ProductFamilies(self._cfg, self._httpx_client)

    @property
    def products(self) -> Products:
        """Access the products API."""
        return Products(self._cfg, self._httpx_client)

    @property
    def subscriptions(self) -> Subscriptions:
        """Access the subscriptions API."""
        return Subscriptions(self._cfg, self._httpx_client)

    @property
    def usage(self) -> Usage:
        """Access the usage API."""
        return Usage(self._cfg, self._httpx_client)


class MeteroidAsync:
    """Asyncio Meteroid API client.

    Example
    -------
    ::

        from meteroid import MeteroidAsync

        async with MeteroidAsync("your-api-key") as client:
            customers = await client.customers.list_customers()
    """

    _cfg: Configuration
    _httpx_client: httpx.AsyncClient
    _owns_httpx_client: bool

    def __init__(
        self,
        token: str,
        options: t.Optional[MeteroidOptions] = None,
        httpx_client: t.Optional[httpx.AsyncClient] = None,
    ) -> None:
        self._cfg = _build_configuration(token, options)
        self._owns_httpx_client = httpx_client is None
        self._httpx_client = (
            httpx_client
            if httpx_client is not None
            else httpx.AsyncClient(timeout=self._cfg.timeout)
        )

    def with_token(self, token: str) -> "MeteroidAsync":
        """Return a client using a different token but the same connection pool."""
        clone = MeteroidAsync.__new__(MeteroidAsync)
        clone._cfg = dataclasses.replace(self._cfg, bearer_access_token=token)
        clone._httpx_client = self._httpx_client
        clone._owns_httpx_client = False
        return clone

    async def aclose(self) -> None:
        if self._owns_httpx_client:
            await self._httpx_client.aclose()

    async def __aenter__(self) -> "MeteroidAsync":
        return self

    async def __aexit__(self, *exc_info: t.Any) -> None:
        await self.aclose()

    @property
    def add_ons(self) -> AddOnsAsync:
        """Access the add ons API."""
        return AddOnsAsync(self._cfg, self._httpx_client)

    @property
    def batch_jobs(self) -> BatchJobsAsync:
        """Access the batch jobs API."""
        return BatchJobsAsync(self._cfg, self._httpx_client)

    @property
    def checkout_sessions(self) -> CheckoutSessionsAsync:
        """Access the checkout sessions API."""
        return CheckoutSessionsAsync(self._cfg, self._httpx_client)

    @property
    def connect(self) -> ConnectAsync:
        """Access the connect API."""
        return ConnectAsync(self._cfg, self._httpx_client)

    @property
    def coupons(self) -> CouponsAsync:
        """Access the coupons API."""
        return CouponsAsync(self._cfg, self._httpx_client)

    @property
    def credit_notes(self) -> CreditNotesAsync:
        """Access the credit notes API."""
        return CreditNotesAsync(self._cfg, self._httpx_client)

    @property
    def custom_properties(self) -> CustomPropertiesAsync:
        """Access the custom properties API."""
        return CustomPropertiesAsync(self._cfg, self._httpx_client)

    @property
    def customers(self) -> CustomersAsync:
        """Access the customers API."""
        return CustomersAsync(self._cfg, self._httpx_client)

    @property
    def events(self) -> EventsAsync:
        """Access the events API."""
        return EventsAsync(self._cfg, self._httpx_client)

    @property
    def features(self) -> FeaturesAsync:
        """Access the features API."""
        return FeaturesAsync(self._cfg, self._httpx_client)

    @property
    def invoices(self) -> InvoicesAsync:
        """Access the invoices API."""
        return InvoicesAsync(self._cfg, self._httpx_client)

    @property
    def metrics(self) -> MetricsAsync:
        """Access the metrics API."""
        return MetricsAsync(self._cfg, self._httpx_client)

    @property
    def o_auth(self) -> OAuthAsync:
        """Access the o auth API."""
        return OAuthAsync(self._cfg, self._httpx_client)

    @property
    def o_auth_apps(self) -> OAuthAppsAsync:
        """Access the o auth apps API."""
        return OAuthAppsAsync(self._cfg, self._httpx_client)

    @property
    def plans(self) -> PlansAsync:
        """Access the plans API."""
        return PlansAsync(self._cfg, self._httpx_client)

    @property
    def product_families(self) -> ProductFamiliesAsync:
        """Access the product families API."""
        return ProductFamiliesAsync(self._cfg, self._httpx_client)

    @property
    def products(self) -> ProductsAsync:
        """Access the products API."""
        return ProductsAsync(self._cfg, self._httpx_client)

    @property
    def subscriptions(self) -> SubscriptionsAsync:
        """Access the subscriptions API."""
        return SubscriptionsAsync(self._cfg, self._httpx_client)

    @property
    def usage(self) -> UsageAsync:
        """Access the usage API."""
        return UsageAsync(self._cfg, self._httpx_client)

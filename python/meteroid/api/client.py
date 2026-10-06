# this file is @generated
"""Meteroid API client."""

from __future__ import annotations

import dataclasses
import os
import typing as t

import httpx

from ..serialization import UNSET, Unset
from ._auth import SecurityScheme, TokenProvider
from .common import DEFAULT_MAX_RETRIES, DEFAULT_TIMEOUT, Configuration, Timeout
from .middleware import AsyncMiddleware, SyncMiddleware

# Each resource's module is imported the first time it is used.
if t.TYPE_CHECKING:
    from .add_ons import (
        AddOns,
        AddOnsWithRawResponse,
        AsyncAddOns,
        AsyncAddOnsWithRawResponse,
    )
    from .batch_jobs import (
        AsyncBatchJobs,
        AsyncBatchJobsWithRawResponse,
        BatchJobs,
        BatchJobsWithRawResponse,
    )
    from .checkout_sessions import (
        AsyncCheckoutSessions,
        AsyncCheckoutSessionsWithRawResponse,
        CheckoutSessions,
        CheckoutSessionsWithRawResponse,
    )
    from .connect import (
        AsyncConnect,
        AsyncConnectWithRawResponse,
        Connect,
        ConnectWithRawResponse,
    )
    from .coupons import (
        AsyncCoupons,
        AsyncCouponsWithRawResponse,
        Coupons,
        CouponsWithRawResponse,
    )
    from .credit_notes import (
        AsyncCreditNotes,
        AsyncCreditNotesWithRawResponse,
        CreditNotes,
        CreditNotesWithRawResponse,
    )
    from .custom_properties import (
        AsyncCustomProperties,
        AsyncCustomPropertiesWithRawResponse,
        CustomProperties,
        CustomPropertiesWithRawResponse,
    )
    from .customers import (
        AsyncCustomers,
        AsyncCustomersWithRawResponse,
        Customers,
        CustomersWithRawResponse,
    )
    from .events import (
        AsyncEvents,
        AsyncEventsWithRawResponse,
        Events,
        EventsWithRawResponse,
    )
    from .features import (
        AsyncFeatures,
        AsyncFeaturesWithRawResponse,
        Features,
        FeaturesWithRawResponse,
    )
    from .invoices import (
        AsyncInvoices,
        AsyncInvoicesWithRawResponse,
        Invoices,
        InvoicesWithRawResponse,
    )
    from .metrics import (
        AsyncMetrics,
        AsyncMetricsWithRawResponse,
        Metrics,
        MetricsWithRawResponse,
    )
    from .oauth import (
        AsyncOauth,
        AsyncOauthWithRawResponse,
        Oauth,
        OauthWithRawResponse,
    )
    from .oauth_apps import (
        AsyncOauthApps,
        AsyncOauthAppsWithRawResponse,
        OauthApps,
        OauthAppsWithRawResponse,
    )
    from .plans import (
        AsyncPlans,
        AsyncPlansWithRawResponse,
        Plans,
        PlansWithRawResponse,
    )
    from .product_families import (
        AsyncProductFamilies,
        AsyncProductFamiliesWithRawResponse,
        ProductFamilies,
        ProductFamiliesWithRawResponse,
    )
    from .products import (
        AsyncProducts,
        AsyncProductsWithRawResponse,
        Products,
        ProductsWithRawResponse,
    )
    from .subscriptions import (
        AsyncSubscriptions,
        AsyncSubscriptionsWithRawResponse,
        Subscriptions,
        SubscriptionsWithRawResponse,
    )
    from .usage import (
        AsyncUsage,
        AsyncUsageWithRawResponse,
        Usage,
        UsageWithRawResponse,
    )

__all__ = [
    "AsyncMeteroid",
    "AsyncMeteroidWithRawResponse",
    "Meteroid",
    "MeteroidWithRawResponse",
]

DEFAULT_BASE_URL = "https://api.meteroid.com"


SECURITY_SCHEMES: dict[str, SecurityScheme] = {
    "bearer_auth": SecurityScheme("bearer"),
}


def _configuration(
    *,
    api_key: str | None,
    base_url: str | httpx.URL | None,
    timeout: Timeout | Unset,
    max_retries: int | None,
    default_headers: t.Mapping[str, str] | None,
    token_provider: TokenProvider | None,
) -> Configuration:
    """The configuration of a client: its arguments, else the environment."""
    base_url = base_url or os.environ.get("METEROID_BASE_URL") or DEFAULT_BASE_URL
    return Configuration(
        base_path=str(base_url).rstrip("/"),
        bearer_access_token=api_key
        if api_key is not None
        else os.environ.get("METEROID_API_KEY"),
        token_provider=token_provider,
        security_schemes=SECURITY_SCHEMES,
        security=[["bearer_auth"]],
        timeout=DEFAULT_TIMEOUT if isinstance(timeout, Unset) else timeout,
        max_retries=DEFAULT_MAX_RETRIES if max_retries is None else max_retries,
        default_headers=dict(default_headers or {}),
    )


class Meteroid:
    """Meteroid API client.

    Credentials and the base URL default to the ``METEROID_API_KEY`` and
    ``METEROID_BASE_URL`` environment variables.

    Example
    -------
    ::

        from meteroid import Meteroid

        client = Meteroid(api_key="your-api-key")
        # Access the generated resources through client.
    """

    _cfg: Configuration
    _httpx_client: httpx.Client
    _owns_httpx_client: bool

    def __init__(
        self,
        *,
        api_key: str | None = None,
        base_url: str | httpx.URL | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
        default_headers: t.Mapping[str, str] | None = None,
        http_client: httpx.Client | None = None,
        token_provider: TokenProvider | None = None,
        middleware: t.Sequence[SyncMiddleware] | None = None,
    ) -> None:
        """Creates a client.

        :param api_key: The token of the API, read from ``METEROID_API_KEY`` when ``None``.
        :param base_url: Defaults to ``METEROID_BASE_URL``, else ``https://api.meteroid.com``.
        :param timeout: Of each attempt, in seconds (60 by default); ``None`` waits.
        :param max_retries: Retries of a failed idempotent request (2 by default).
        :param default_headers: Sent with every request.
        :param http_client: The ``httpx`` client to send requests with, left open by :meth:`close`.
        :param token_provider: Called before each request for a fresh bearer token,
            such as an OAuth2 access token; it wins over ``api_key``.
        :param middleware: Wraps every HTTP attempt: caching, logging, signing.
        """
        self._cfg = _configuration(
            api_key=api_key,
            base_url=base_url,
            timeout=timeout,
            max_retries=max_retries,
            default_headers=default_headers,
            token_provider=token_provider,
        )
        self._cfg.middleware = list(middleware or ())
        self._owns_httpx_client = http_client is None
        self._httpx_client = (
            http_client
            if http_client is not None
            else httpx.Client(timeout=self._cfg.timeout)
        )

    def with_options(
        self,
        *,
        api_key: str | None = None,
        base_url: str | httpx.URL | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
        default_headers: t.Mapping[str, str] | None = None,
    ) -> Meteroid:
        """A copy of this client with these options changed, sharing its connection pool.

        ``client.with_options(max_retries=0).items.list()`` changes them for one call.
        """
        cfg = dataclasses.replace(self._cfg)
        if api_key is not None:
            cfg.bearer_access_token = api_key
        if base_url is not None:
            cfg.base_path = str(base_url).rstrip("/")
        if not isinstance(timeout, Unset):
            cfg.timeout = timeout
        if max_retries is not None:
            cfg.max_retries = max_retries
        if default_headers is not None:
            cfg.default_headers = {**cfg.default_headers, **default_headers}
        clone = Meteroid.__new__(Meteroid)
        clone._cfg = cfg
        clone._httpx_client = self._httpx_client
        clone._owns_httpx_client = False
        return clone

    @property
    def with_raw_response(self) -> MeteroidWithRawResponse:
        """The resources, whose methods return an :class:`APIResponse` with the status and headers."""
        return MeteroidWithRawResponse(self)

    def close(self) -> None:
        """Closes the connection pool, unless it is the ``http_client`` given."""
        if self._owns_httpx_client:
            self._httpx_client.close()

    def __enter__(self) -> Meteroid:
        return self

    def __exit__(self, *exc_info: object) -> None:
        self.close()

    @property
    def add_ons(self) -> AddOns:
        """The add ons API."""
        from .add_ons import AddOns

        return AddOns(self._cfg, self._httpx_client)

    @property
    def batch_jobs(self) -> BatchJobs:
        """The batch jobs API."""
        from .batch_jobs import BatchJobs

        return BatchJobs(self._cfg, self._httpx_client)

    @property
    def checkout_sessions(self) -> CheckoutSessions:
        """The checkout sessions API."""
        from .checkout_sessions import CheckoutSessions

        return CheckoutSessions(self._cfg, self._httpx_client)

    @property
    def connect(self) -> Connect:
        """The connect API."""
        from .connect import Connect

        return Connect(self._cfg, self._httpx_client)

    @property
    def coupons(self) -> Coupons:
        """The coupons API."""
        from .coupons import Coupons

        return Coupons(self._cfg, self._httpx_client)

    @property
    def credit_notes(self) -> CreditNotes:
        """The credit notes API."""
        from .credit_notes import CreditNotes

        return CreditNotes(self._cfg, self._httpx_client)

    @property
    def custom_properties(self) -> CustomProperties:
        """The custom properties API."""
        from .custom_properties import CustomProperties

        return CustomProperties(self._cfg, self._httpx_client)

    @property
    def customers(self) -> Customers:
        """The customers API."""
        from .customers import Customers

        return Customers(self._cfg, self._httpx_client)

    @property
    def events(self) -> Events:
        """The events API."""
        from .events import Events

        return Events(self._cfg, self._httpx_client)

    @property
    def features(self) -> Features:
        """The features API."""
        from .features import Features

        return Features(self._cfg, self._httpx_client)

    @property
    def invoices(self) -> Invoices:
        """The invoices API."""
        from .invoices import Invoices

        return Invoices(self._cfg, self._httpx_client)

    @property
    def metrics(self) -> Metrics:
        """The metrics API."""
        from .metrics import Metrics

        return Metrics(self._cfg, self._httpx_client)

    @property
    def oauth(self) -> Oauth:
        """The oauth API."""
        from .oauth import Oauth

        return Oauth(self._cfg, self._httpx_client)

    @property
    def oauth_apps(self) -> OauthApps:
        """The oauth apps API."""
        from .oauth_apps import OauthApps

        return OauthApps(self._cfg, self._httpx_client)

    @property
    def plans(self) -> Plans:
        """The plans API."""
        from .plans import Plans

        return Plans(self._cfg, self._httpx_client)

    @property
    def product_families(self) -> ProductFamilies:
        """The product families API."""
        from .product_families import ProductFamilies

        return ProductFamilies(self._cfg, self._httpx_client)

    @property
    def products(self) -> Products:
        """The products API."""
        from .products import Products

        return Products(self._cfg, self._httpx_client)

    @property
    def subscriptions(self) -> Subscriptions:
        """The subscriptions API."""
        from .subscriptions import Subscriptions

        return Subscriptions(self._cfg, self._httpx_client)

    @property
    def usage(self) -> Usage:
        """The usage API."""
        from .usage import Usage

        return Usage(self._cfg, self._httpx_client)


class MeteroidWithRawResponse:
    """The resources of :class:`Meteroid`, whose methods return an :class:`APIResponse`."""

    def __init__(self, client: Meteroid) -> None:
        self._client = client

    @property
    def add_ons(self) -> AddOnsWithRawResponse:
        """The add ons API."""
        from .add_ons import AddOnsWithRawResponse

        return AddOnsWithRawResponse(self._client.add_ons)

    @property
    def batch_jobs(self) -> BatchJobsWithRawResponse:
        """The batch jobs API."""
        from .batch_jobs import BatchJobsWithRawResponse

        return BatchJobsWithRawResponse(self._client.batch_jobs)

    @property
    def checkout_sessions(self) -> CheckoutSessionsWithRawResponse:
        """The checkout sessions API."""
        from .checkout_sessions import CheckoutSessionsWithRawResponse

        return CheckoutSessionsWithRawResponse(self._client.checkout_sessions)

    @property
    def connect(self) -> ConnectWithRawResponse:
        """The connect API."""
        from .connect import ConnectWithRawResponse

        return ConnectWithRawResponse(self._client.connect)

    @property
    def coupons(self) -> CouponsWithRawResponse:
        """The coupons API."""
        from .coupons import CouponsWithRawResponse

        return CouponsWithRawResponse(self._client.coupons)

    @property
    def credit_notes(self) -> CreditNotesWithRawResponse:
        """The credit notes API."""
        from .credit_notes import CreditNotesWithRawResponse

        return CreditNotesWithRawResponse(self._client.credit_notes)

    @property
    def custom_properties(self) -> CustomPropertiesWithRawResponse:
        """The custom properties API."""
        from .custom_properties import CustomPropertiesWithRawResponse

        return CustomPropertiesWithRawResponse(self._client.custom_properties)

    @property
    def customers(self) -> CustomersWithRawResponse:
        """The customers API."""
        from .customers import CustomersWithRawResponse

        return CustomersWithRawResponse(self._client.customers)

    @property
    def events(self) -> EventsWithRawResponse:
        """The events API."""
        from .events import EventsWithRawResponse

        return EventsWithRawResponse(self._client.events)

    @property
    def features(self) -> FeaturesWithRawResponse:
        """The features API."""
        from .features import FeaturesWithRawResponse

        return FeaturesWithRawResponse(self._client.features)

    @property
    def invoices(self) -> InvoicesWithRawResponse:
        """The invoices API."""
        from .invoices import InvoicesWithRawResponse

        return InvoicesWithRawResponse(self._client.invoices)

    @property
    def metrics(self) -> MetricsWithRawResponse:
        """The metrics API."""
        from .metrics import MetricsWithRawResponse

        return MetricsWithRawResponse(self._client.metrics)

    @property
    def oauth(self) -> OauthWithRawResponse:
        """The oauth API."""
        from .oauth import OauthWithRawResponse

        return OauthWithRawResponse(self._client.oauth)

    @property
    def oauth_apps(self) -> OauthAppsWithRawResponse:
        """The oauth apps API."""
        from .oauth_apps import OauthAppsWithRawResponse

        return OauthAppsWithRawResponse(self._client.oauth_apps)

    @property
    def plans(self) -> PlansWithRawResponse:
        """The plans API."""
        from .plans import PlansWithRawResponse

        return PlansWithRawResponse(self._client.plans)

    @property
    def product_families(self) -> ProductFamiliesWithRawResponse:
        """The product families API."""
        from .product_families import ProductFamiliesWithRawResponse

        return ProductFamiliesWithRawResponse(self._client.product_families)

    @property
    def products(self) -> ProductsWithRawResponse:
        """The products API."""
        from .products import ProductsWithRawResponse

        return ProductsWithRawResponse(self._client.products)

    @property
    def subscriptions(self) -> SubscriptionsWithRawResponse:
        """The subscriptions API."""
        from .subscriptions import SubscriptionsWithRawResponse

        return SubscriptionsWithRawResponse(self._client.subscriptions)

    @property
    def usage(self) -> UsageWithRawResponse:
        """The usage API."""
        from .usage import UsageWithRawResponse

        return UsageWithRawResponse(self._client.usage)


class AsyncMeteroid:
    """Asyncio Meteroid API client.

    Credentials and the base URL default to the ``METEROID_API_KEY`` and
    ``METEROID_BASE_URL`` environment variables.

    Example
    -------
    ::

        from meteroid import AsyncMeteroid

        async with AsyncMeteroid(api_key="your-api-key") as client:
            pass  # Access the generated resources through client.
    """

    _cfg: Configuration
    _httpx_client: httpx.AsyncClient
    _owns_httpx_client: bool

    def __init__(
        self,
        *,
        api_key: str | None = None,
        base_url: str | httpx.URL | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
        default_headers: t.Mapping[str, str] | None = None,
        http_client: httpx.AsyncClient | None = None,
        token_provider: TokenProvider | None = None,
        middleware: t.Sequence[AsyncMiddleware] | None = None,
    ) -> None:
        """Creates a client.

        :param api_key: The token of the API, read from ``METEROID_API_KEY`` when ``None``.
        :param base_url: Defaults to ``METEROID_BASE_URL``, else ``https://api.meteroid.com``.
        :param timeout: Of each attempt, in seconds (60 by default); ``None`` waits.
        :param max_retries: Retries of a failed idempotent request (2 by default).
        :param default_headers: Sent with every request.
        :param http_client: The ``httpx`` client to send requests with, left open by :meth:`close`.
        :param token_provider: Called before each request for a fresh bearer token,
            such as an OAuth2 access token; it wins over ``api_key``.
        :param middleware: Wraps every HTTP attempt: caching, logging, signing.
        """
        self._cfg = _configuration(
            api_key=api_key,
            base_url=base_url,
            timeout=timeout,
            max_retries=max_retries,
            default_headers=default_headers,
            token_provider=token_provider,
        )
        self._cfg.async_middleware = list(middleware or ())
        self._owns_httpx_client = http_client is None
        self._httpx_client = (
            http_client
            if http_client is not None
            else httpx.AsyncClient(timeout=self._cfg.timeout)
        )

    def with_options(
        self,
        *,
        api_key: str | None = None,
        base_url: str | httpx.URL | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
        default_headers: t.Mapping[str, str] | None = None,
    ) -> AsyncMeteroid:
        """A copy of this client with these options changed, sharing its connection pool.

        ``client.with_options(max_retries=0).items.list()`` changes them for one call.
        """
        cfg = dataclasses.replace(self._cfg)
        if api_key is not None:
            cfg.bearer_access_token = api_key
        if base_url is not None:
            cfg.base_path = str(base_url).rstrip("/")
        if not isinstance(timeout, Unset):
            cfg.timeout = timeout
        if max_retries is not None:
            cfg.max_retries = max_retries
        if default_headers is not None:
            cfg.default_headers = {**cfg.default_headers, **default_headers}
        clone = AsyncMeteroid.__new__(AsyncMeteroid)
        clone._cfg = cfg
        clone._httpx_client = self._httpx_client
        clone._owns_httpx_client = False
        return clone

    @property
    def with_raw_response(self) -> AsyncMeteroidWithRawResponse:
        """The resources, whose methods return an :class:`APIResponse` with the status and headers."""
        return AsyncMeteroidWithRawResponse(self)

    async def aclose(self) -> None:
        """Closes the connection pool, unless it is the ``http_client`` given."""
        if self._owns_httpx_client:
            await self._httpx_client.aclose()

    async def __aenter__(self) -> AsyncMeteroid:
        return self

    async def __aexit__(self, *exc_info: object) -> None:
        await self.aclose()

    @property
    def add_ons(self) -> AsyncAddOns:
        """The add ons API."""
        from .add_ons import AsyncAddOns

        return AsyncAddOns(self._cfg, self._httpx_client)

    @property
    def batch_jobs(self) -> AsyncBatchJobs:
        """The batch jobs API."""
        from .batch_jobs import AsyncBatchJobs

        return AsyncBatchJobs(self._cfg, self._httpx_client)

    @property
    def checkout_sessions(self) -> AsyncCheckoutSessions:
        """The checkout sessions API."""
        from .checkout_sessions import AsyncCheckoutSessions

        return AsyncCheckoutSessions(self._cfg, self._httpx_client)

    @property
    def connect(self) -> AsyncConnect:
        """The connect API."""
        from .connect import AsyncConnect

        return AsyncConnect(self._cfg, self._httpx_client)

    @property
    def coupons(self) -> AsyncCoupons:
        """The coupons API."""
        from .coupons import AsyncCoupons

        return AsyncCoupons(self._cfg, self._httpx_client)

    @property
    def credit_notes(self) -> AsyncCreditNotes:
        """The credit notes API."""
        from .credit_notes import AsyncCreditNotes

        return AsyncCreditNotes(self._cfg, self._httpx_client)

    @property
    def custom_properties(self) -> AsyncCustomProperties:
        """The custom properties API."""
        from .custom_properties import AsyncCustomProperties

        return AsyncCustomProperties(self._cfg, self._httpx_client)

    @property
    def customers(self) -> AsyncCustomers:
        """The customers API."""
        from .customers import AsyncCustomers

        return AsyncCustomers(self._cfg, self._httpx_client)

    @property
    def events(self) -> AsyncEvents:
        """The events API."""
        from .events import AsyncEvents

        return AsyncEvents(self._cfg, self._httpx_client)

    @property
    def features(self) -> AsyncFeatures:
        """The features API."""
        from .features import AsyncFeatures

        return AsyncFeatures(self._cfg, self._httpx_client)

    @property
    def invoices(self) -> AsyncInvoices:
        """The invoices API."""
        from .invoices import AsyncInvoices

        return AsyncInvoices(self._cfg, self._httpx_client)

    @property
    def metrics(self) -> AsyncMetrics:
        """The metrics API."""
        from .metrics import AsyncMetrics

        return AsyncMetrics(self._cfg, self._httpx_client)

    @property
    def oauth(self) -> AsyncOauth:
        """The oauth API."""
        from .oauth import AsyncOauth

        return AsyncOauth(self._cfg, self._httpx_client)

    @property
    def oauth_apps(self) -> AsyncOauthApps:
        """The oauth apps API."""
        from .oauth_apps import AsyncOauthApps

        return AsyncOauthApps(self._cfg, self._httpx_client)

    @property
    def plans(self) -> AsyncPlans:
        """The plans API."""
        from .plans import AsyncPlans

        return AsyncPlans(self._cfg, self._httpx_client)

    @property
    def product_families(self) -> AsyncProductFamilies:
        """The product families API."""
        from .product_families import AsyncProductFamilies

        return AsyncProductFamilies(self._cfg, self._httpx_client)

    @property
    def products(self) -> AsyncProducts:
        """The products API."""
        from .products import AsyncProducts

        return AsyncProducts(self._cfg, self._httpx_client)

    @property
    def subscriptions(self) -> AsyncSubscriptions:
        """The subscriptions API."""
        from .subscriptions import AsyncSubscriptions

        return AsyncSubscriptions(self._cfg, self._httpx_client)

    @property
    def usage(self) -> AsyncUsage:
        """The usage API."""
        from .usage import AsyncUsage

        return AsyncUsage(self._cfg, self._httpx_client)


class AsyncMeteroidWithRawResponse:
    """The resources of :class:`AsyncMeteroid`, whose methods return an :class:`APIResponse`."""

    def __init__(self, client: AsyncMeteroid) -> None:
        self._client = client

    @property
    def add_ons(self) -> AsyncAddOnsWithRawResponse:
        """The add ons API."""
        from .add_ons import AsyncAddOnsWithRawResponse

        return AsyncAddOnsWithRawResponse(self._client.add_ons)

    @property
    def batch_jobs(self) -> AsyncBatchJobsWithRawResponse:
        """The batch jobs API."""
        from .batch_jobs import AsyncBatchJobsWithRawResponse

        return AsyncBatchJobsWithRawResponse(self._client.batch_jobs)

    @property
    def checkout_sessions(self) -> AsyncCheckoutSessionsWithRawResponse:
        """The checkout sessions API."""
        from .checkout_sessions import AsyncCheckoutSessionsWithRawResponse

        return AsyncCheckoutSessionsWithRawResponse(self._client.checkout_sessions)

    @property
    def connect(self) -> AsyncConnectWithRawResponse:
        """The connect API."""
        from .connect import AsyncConnectWithRawResponse

        return AsyncConnectWithRawResponse(self._client.connect)

    @property
    def coupons(self) -> AsyncCouponsWithRawResponse:
        """The coupons API."""
        from .coupons import AsyncCouponsWithRawResponse

        return AsyncCouponsWithRawResponse(self._client.coupons)

    @property
    def credit_notes(self) -> AsyncCreditNotesWithRawResponse:
        """The credit notes API."""
        from .credit_notes import AsyncCreditNotesWithRawResponse

        return AsyncCreditNotesWithRawResponse(self._client.credit_notes)

    @property
    def custom_properties(self) -> AsyncCustomPropertiesWithRawResponse:
        """The custom properties API."""
        from .custom_properties import AsyncCustomPropertiesWithRawResponse

        return AsyncCustomPropertiesWithRawResponse(self._client.custom_properties)

    @property
    def customers(self) -> AsyncCustomersWithRawResponse:
        """The customers API."""
        from .customers import AsyncCustomersWithRawResponse

        return AsyncCustomersWithRawResponse(self._client.customers)

    @property
    def events(self) -> AsyncEventsWithRawResponse:
        """The events API."""
        from .events import AsyncEventsWithRawResponse

        return AsyncEventsWithRawResponse(self._client.events)

    @property
    def features(self) -> AsyncFeaturesWithRawResponse:
        """The features API."""
        from .features import AsyncFeaturesWithRawResponse

        return AsyncFeaturesWithRawResponse(self._client.features)

    @property
    def invoices(self) -> AsyncInvoicesWithRawResponse:
        """The invoices API."""
        from .invoices import AsyncInvoicesWithRawResponse

        return AsyncInvoicesWithRawResponse(self._client.invoices)

    @property
    def metrics(self) -> AsyncMetricsWithRawResponse:
        """The metrics API."""
        from .metrics import AsyncMetricsWithRawResponse

        return AsyncMetricsWithRawResponse(self._client.metrics)

    @property
    def oauth(self) -> AsyncOauthWithRawResponse:
        """The oauth API."""
        from .oauth import AsyncOauthWithRawResponse

        return AsyncOauthWithRawResponse(self._client.oauth)

    @property
    def oauth_apps(self) -> AsyncOauthAppsWithRawResponse:
        """The oauth apps API."""
        from .oauth_apps import AsyncOauthAppsWithRawResponse

        return AsyncOauthAppsWithRawResponse(self._client.oauth_apps)

    @property
    def plans(self) -> AsyncPlansWithRawResponse:
        """The plans API."""
        from .plans import AsyncPlansWithRawResponse

        return AsyncPlansWithRawResponse(self._client.plans)

    @property
    def product_families(self) -> AsyncProductFamiliesWithRawResponse:
        """The product families API."""
        from .product_families import AsyncProductFamiliesWithRawResponse

        return AsyncProductFamiliesWithRawResponse(self._client.product_families)

    @property
    def products(self) -> AsyncProductsWithRawResponse:
        """The products API."""
        from .products import AsyncProductsWithRawResponse

        return AsyncProductsWithRawResponse(self._client.products)

    @property
    def subscriptions(self) -> AsyncSubscriptionsWithRawResponse:
        """The subscriptions API."""
        from .subscriptions import AsyncSubscriptionsWithRawResponse

        return AsyncSubscriptionsWithRawResponse(self._client.subscriptions)

    @property
    def usage(self) -> AsyncUsageWithRawResponse:
        """The usage API."""
        from .usage import AsyncUsageWithRawResponse

        return AsyncUsageWithRawResponse(self._client.usage)

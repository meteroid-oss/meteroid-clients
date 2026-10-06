# this file is @generated
"""Usage API."""

from __future__ import annotations

import typing as t
from datetime import date

from .. import models as _models
from ..models import (
    BillableMetricId,
    UsageResponse,
)
from ..serialization import UNSET, Unset
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
    serialize_query_params,
)


class AsyncUsage(ApiBaseAsync):
    """Usage API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncUsageWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncUsageWithRawResponse(self)

    async def retrieve_customer(
        self,
        customer_id: str,
        *,
        start_date: date,
        end_date: date,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get customer usage

        Retrieve aggregated usage data for a customer over a specified period."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/customer/{customer_id}",
                path_params={
                    "customer_id": customer_id,
                },
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)

    async def retrieve_subscription(
        self,
        subscription_id: str,
        *,
        start_date: date | None = None,
        end_date: date | None = None,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get subscription usage

        Retrieve aggregated usage data for a subscription's usage-based components.
        If start_date/end_date are omitted, defaults to the current billing period."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/subscription/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
                },
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)

    async def retrieve_summary(
        self,
        *,
        start_date: date,
        end_date: date,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get usage summary

        Retrieve aggregated usage data across all customers for the tenant."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/summary",
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)


class AsyncUsageWithRawResponse:
    """The methods of :class:`AsyncUsage`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncUsage) -> None:
        self.retrieve_customer = async_to_raw_response_wrapper(
            resource.retrieve_customer
        )
        self.retrieve_subscription = async_to_raw_response_wrapper(
            resource.retrieve_subscription
        )
        self.retrieve_summary = async_to_raw_response_wrapper(resource.retrieve_summary)


class Usage(ApiBaseSync):
    """Usage API."""

    @property
    def with_raw_response(self) -> UsageWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return UsageWithRawResponse(self)

    def retrieve_customer(
        self,
        customer_id: str,
        *,
        start_date: date,
        end_date: date,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get customer usage

        Retrieve aggregated usage data for a customer over a specified period."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/customer/{customer_id}",
                path_params={
                    "customer_id": customer_id,
                },
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)

    def retrieve_subscription(
        self,
        subscription_id: str,
        *,
        start_date: date | None = None,
        end_date: date | None = None,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get subscription usage

        Retrieve aggregated usage data for a subscription's usage-based components.
        If start_date/end_date are omitted, defaults to the current billing period."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/subscription/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
                },
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)

    def retrieve_summary(
        self,
        *,
        start_date: date,
        end_date: date,
        metric_id: BillableMetricId | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> UsageResponse:
        """Get usage summary

        Retrieve aggregated usage data across all customers for the tenant."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/usage/summary",
                query_params=serialize_query_params(
                    {
                        "start_date": start_date,
                        "end_date": end_date,
                        "metric_id": metric_id,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, UsageResponse)


class UsageWithRawResponse:
    """The methods of :class:`Usage`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Usage) -> None:
        self.retrieve_customer = to_raw_response_wrapper(resource.retrieve_customer)
        self.retrieve_subscription = to_raw_response_wrapper(
            resource.retrieve_subscription
        )
        self.retrieve_summary = to_raw_response_wrapper(resource.retrieve_summary)

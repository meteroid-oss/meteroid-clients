# this file is @generated
import typing as t

from ..models import (
    BillableMetricId,
    UsageResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class UsageAsync(ApiBaseAsync):
    """usage API."""

    async def get_customer_usage(
        self,
        customer_id: str,
        *,
        start_date: str,
        end_date: str,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data for a customer over a specified period."""
        response = await self._request_asyncio(
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
        )
        return UsageResponse.from_dict(response.json())

    async def get_subscription_usage(
        self,
        subscription_id: str,
        *,
        start_date: t.Optional[str] = None,
        end_date: t.Optional[str] = None,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data for a subscription's usage-based components.
        If start_date/end_date are omitted, defaults to the current billing period."""
        response = await self._request_asyncio(
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
        )
        return UsageResponse.from_dict(response.json())

    async def get_usage_summary(
        self,
        *,
        start_date: str,
        end_date: str,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data across all customers for the tenant."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/usage/summary",
            query_params=serialize_query_params(
                {
                    "start_date": start_date,
                    "end_date": end_date,
                    "metric_id": metric_id,
                },
            ),
        )
        return UsageResponse.from_dict(response.json())


class Usage(ApiBaseSync):
    """usage API."""

    def get_customer_usage(
        self,
        customer_id: str,
        *,
        start_date: str,
        end_date: str,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data for a customer over a specified period."""
        response = self._request_sync(
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
        )
        return UsageResponse.from_dict(response.json())

    def get_subscription_usage(
        self,
        subscription_id: str,
        *,
        start_date: t.Optional[str] = None,
        end_date: t.Optional[str] = None,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data for a subscription's usage-based components.
        If start_date/end_date are omitted, defaults to the current billing period."""
        response = self._request_sync(
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
        )
        return UsageResponse.from_dict(response.json())

    def get_usage_summary(
        self,
        *,
        start_date: str,
        end_date: str,
        metric_id: t.Optional[BillableMetricId] = None,
    ) -> UsageResponse:
        """Retrieve aggregated usage data across all customers for the tenant."""
        response = self._request_sync(
            method="get",
            path="/api/v1/usage/summary",
            query_params=serialize_query_params(
                {
                    "start_date": start_date,
                    "end_date": end_date,
                    "metric_id": metric_id,
                },
            ),
        )
        return UsageResponse.from_dict(response.json())

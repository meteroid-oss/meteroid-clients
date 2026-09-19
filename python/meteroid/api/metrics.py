# this file is @generated
import typing as t

from ..models import (
    CreateMetricRequest,
    Metric,
    MetricListResponse,
    ProductFamilyId,
    UpdateMetricRequest,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class MetricsAsync(ApiBaseAsync):
    """metrics API."""

    async def list_metrics(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> MetricListResponse:
        """:param search: Search by metric name or code
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/metrics",
            query_params=serialize_query_params(
                {
                    "product_family_id": product_family_id,
                    "search": search,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return decode_response(response, MetricListResponse)

    async def create_metric(
        self,
        create_metric_request: CreateMetricRequest,
    ) -> Metric:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/metrics",
            json_body=create_metric_request.to_dict(),
        )
        return decode_response(response, Metric)

    async def get_metric(
        self,
        metric_id: str,
    ) -> Metric:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/metrics/{metric_id}",
            path_params={
                "metric_id": metric_id,
            },
        )
        return decode_response(response, Metric)

    async def update_metric(
        self,
        metric_id: str,
        update_metric_request: UpdateMetricRequest,
    ) -> Metric:
        """Partially update metric fields. Code and aggregation_type are immutable."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/metrics/{metric_id}",
            path_params={
                "metric_id": metric_id,
            },
            json_body=update_metric_request.to_dict(),
        )
        return decode_response(response, Metric)

    async def archive_metric(
        self,
        metric_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/metrics/{metric_id}/archive",
            path_params={
                "metric_id": metric_id,
            },
        )

    async def unarchive_metric(
        self,
        metric_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/metrics/{metric_id}/unarchive",
            path_params={
                "metric_id": metric_id,
            },
        )


class Metrics(ApiBaseSync):
    """metrics API."""

    def list_metrics(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> MetricListResponse:
        """:param search: Search by metric name or code
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/metrics",
            query_params=serialize_query_params(
                {
                    "product_family_id": product_family_id,
                    "search": search,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return decode_response(response, MetricListResponse)

    def create_metric(
        self,
        create_metric_request: CreateMetricRequest,
    ) -> Metric:
        response = self._request_sync(
            method="post",
            path="/api/v1/metrics",
            json_body=create_metric_request.to_dict(),
        )
        return decode_response(response, Metric)

    def get_metric(
        self,
        metric_id: str,
    ) -> Metric:
        response = self._request_sync(
            method="get",
            path="/api/v1/metrics/{metric_id}",
            path_params={
                "metric_id": metric_id,
            },
        )
        return decode_response(response, Metric)

    def update_metric(
        self,
        metric_id: str,
        update_metric_request: UpdateMetricRequest,
    ) -> Metric:
        """Partially update metric fields. Code and aggregation_type are immutable."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/metrics/{metric_id}",
            path_params={
                "metric_id": metric_id,
            },
            json_body=update_metric_request.to_dict(),
        )
        return decode_response(response, Metric)

    def archive_metric(
        self,
        metric_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/metrics/{metric_id}/archive",
            path_params={
                "metric_id": metric_id,
            },
        )

    def unarchive_metric(
        self,
        metric_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/metrics/{metric_id}/unarchive",
            path_params={
                "metric_id": metric_id,
            },
        )

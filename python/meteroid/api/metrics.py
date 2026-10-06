# this file is @generated
"""Metrics API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    BillingMetricAggregateEnum,
    BillingMetricAggregateEnumLiteral,
    CreateMetricRequest,
    Metric,
    MetricFilter,
    MetricListResponse,
    MetricSegmentationMatrix,
    ProductFamilyId,
    ProductId,
    UnitConversion,
    UpdateMetricRequest,
)
from ..serialization import UNSET, Unset, to_json_value
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
    serialize_query_params,
)


class AsyncMetrics(ApiBaseAsync):
    """Metrics API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncMetricsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncMetricsWithRawResponse(self)

    async def list(
        self,
        *,
        product_family_id: ProductFamilyId | None = None,
        search: str | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> MetricListResponse:
        """List billable metrics

        :param search: Search by metric name or code
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
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
        return decode_response(response, MetricListResponse)

    async def create(
        self,
        *,
        aggregation_type: BillingMetricAggregateEnum
        | BillingMetricAggregateEnumLiteral,
        code: str,
        name: str,
        product_family_id: ProductFamilyId,
        aggregation_key: str | None | Unset = UNSET,
        description: str | None | Unset = UNSET,
        filters: builtins.list[MetricFilter] | None | Unset = UNSET,
        product_id: ProductId | None | Unset = UNSET,
        segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET,
        unit_conversion: UnitConversion | None | Unset = UNSET,
        usage_group_key: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Create a billable metric

        :param filters: Pre-aggregation property filters. Optional and backward-compatible; omit for none."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics",
                json_body=to_json_value(
                    CreateMetricRequest(
                        aggregation_key=aggregation_key,
                        aggregation_type=t.cast(
                            "BillingMetricAggregateEnum", aggregation_type
                        ),
                        code=code,
                        description=description,
                        filters=filters,
                        name=name,
                        product_family_id=product_family_id,
                        product_id=product_id,
                        segmentation_matrix=segmentation_matrix,
                        unit_conversion=unit_conversion,
                        usage_group_key=usage_group_key,
                    ),
                    CreateMetricRequest,
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
        return decode_response(response, Metric)

    async def retrieve(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Get metric details"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/metrics/{metric_id}",
                path_params={
                    "metric_id": metric_id,
                },
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
        return decode_response(response, Metric)

    async def update(
        self,
        metric_id: str,
        *,
        description: str | None | Unset = UNSET,
        filters: builtins.list[MetricFilter] | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET,
        unit_conversion: UnitConversion | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Update a billable metric

        Partially update metric fields. Code and aggregation_type are immutable.

        :param filters: Absent = leave filters untouched; present (even empty) = replace them."""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/metrics/{metric_id}",
                path_params={
                    "metric_id": metric_id,
                },
                json_body=to_json_value(
                    UpdateMetricRequest(
                        description=description,
                        filters=filters,
                        name=name,
                        segmentation_matrix=segmentation_matrix,
                        unit_conversion=unit_conversion,
                    ),
                    UpdateMetricRequest,
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
        return decode_response(response, Metric)

    async def archive(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a billable metric"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics/{metric_id}/archive",
                path_params={
                    "metric_id": metric_id,
                },
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

    async def unarchive(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a billable metric"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics/{metric_id}/unarchive",
                path_params={
                    "metric_id": metric_id,
                },
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


class AsyncMetricsWithRawResponse:
    """The methods of :class:`AsyncMetrics`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncMetrics) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update = async_to_raw_response_wrapper(resource.update)
        self.archive = async_to_raw_response_wrapper(resource.archive)
        self.unarchive = async_to_raw_response_wrapper(resource.unarchive)


class Metrics(ApiBaseSync):
    """Metrics API."""

    @property
    def with_raw_response(self) -> MetricsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return MetricsWithRawResponse(self)

    def list(
        self,
        *,
        product_family_id: ProductFamilyId | None = None,
        search: str | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> MetricListResponse:
        """List billable metrics

        :param search: Search by metric name or code
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
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
        return decode_response(response, MetricListResponse)

    def create(
        self,
        *,
        aggregation_type: BillingMetricAggregateEnum
        | BillingMetricAggregateEnumLiteral,
        code: str,
        name: str,
        product_family_id: ProductFamilyId,
        aggregation_key: str | None | Unset = UNSET,
        description: str | None | Unset = UNSET,
        filters: builtins.list[MetricFilter] | None | Unset = UNSET,
        product_id: ProductId | None | Unset = UNSET,
        segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET,
        unit_conversion: UnitConversion | None | Unset = UNSET,
        usage_group_key: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Create a billable metric

        :param filters: Pre-aggregation property filters. Optional and backward-compatible; omit for none."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics",
                json_body=to_json_value(
                    CreateMetricRequest(
                        aggregation_key=aggregation_key,
                        aggregation_type=t.cast(
                            "BillingMetricAggregateEnum", aggregation_type
                        ),
                        code=code,
                        description=description,
                        filters=filters,
                        name=name,
                        product_family_id=product_family_id,
                        product_id=product_id,
                        segmentation_matrix=segmentation_matrix,
                        unit_conversion=unit_conversion,
                        usage_group_key=usage_group_key,
                    ),
                    CreateMetricRequest,
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
        return decode_response(response, Metric)

    def retrieve(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Get metric details"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/metrics/{metric_id}",
                path_params={
                    "metric_id": metric_id,
                },
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
        return decode_response(response, Metric)

    def update(
        self,
        metric_id: str,
        *,
        description: str | None | Unset = UNSET,
        filters: builtins.list[MetricFilter] | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET,
        unit_conversion: UnitConversion | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Metric:
        """Update a billable metric

        Partially update metric fields. Code and aggregation_type are immutable.

        :param filters: Absent = leave filters untouched; present (even empty) = replace them."""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/metrics/{metric_id}",
                path_params={
                    "metric_id": metric_id,
                },
                json_body=to_json_value(
                    UpdateMetricRequest(
                        description=description,
                        filters=filters,
                        name=name,
                        segmentation_matrix=segmentation_matrix,
                        unit_conversion=unit_conversion,
                    ),
                    UpdateMetricRequest,
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
        return decode_response(response, Metric)

    def archive(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a billable metric"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics/{metric_id}/archive",
                path_params={
                    "metric_id": metric_id,
                },
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

    def unarchive(
        self,
        metric_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a billable metric"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/metrics/{metric_id}/unarchive",
                path_params={
                    "metric_id": metric_id,
                },
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


class MetricsWithRawResponse:
    """The methods of :class:`Metrics`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Metrics) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update = to_raw_response_wrapper(resource.update)
        self.archive = to_raw_response_wrapper(resource.archive)
        self.unarchive = to_raw_response_wrapper(resource.unarchive)

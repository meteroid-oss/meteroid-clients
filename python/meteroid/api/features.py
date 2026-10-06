# this file is @generated
"""Features API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    Feature,
    FeatureListResponse,
    FeatureStatus,
    ProductId,
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


class AsyncFeatures(ApiBaseAsync):
    """Features API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncFeaturesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncFeaturesWithRawResponse(self)

    async def list(
        self,
        *,
        statuses: builtins.list[FeatureStatus] | None = None,
        product_id: ProductId | None = None,
        search: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> FeatureListResponse:
        """List features

        :param statuses: Filter by feature status. Repeat the param to select multiple, omit to return all.
        :param product_id: Filter by product. Omit to return features across all products.
        :param search: Search by feature name.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/features",
                query_params=serialize_query_params(
                    {
                        "statuses": statuses,
                        "product_id": product_id,
                        "search": search,
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
        return decode_response(response, FeatureListResponse)

    async def retrieve(
        self,
        id_or_code: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Feature:
        """Get feature details"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/features/{id_or_code}",
                path_params={
                    "id_or_code": id_or_code,
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
        return decode_response(response, Feature)


class AsyncFeaturesWithRawResponse:
    """The methods of :class:`AsyncFeatures`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncFeatures) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)


class Features(ApiBaseSync):
    """Features API."""

    @property
    def with_raw_response(self) -> FeaturesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return FeaturesWithRawResponse(self)

    def list(
        self,
        *,
        statuses: builtins.list[FeatureStatus] | None = None,
        product_id: ProductId | None = None,
        search: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> FeatureListResponse:
        """List features

        :param statuses: Filter by feature status. Repeat the param to select multiple, omit to return all.
        :param product_id: Filter by product. Omit to return features across all products.
        :param search: Search by feature name.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/features",
                query_params=serialize_query_params(
                    {
                        "statuses": statuses,
                        "product_id": product_id,
                        "search": search,
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
        return decode_response(response, FeatureListResponse)

    def retrieve(
        self,
        id_or_code: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Feature:
        """Get feature details"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/features/{id_or_code}",
                path_params={
                    "id_or_code": id_or_code,
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
        return decode_response(response, Feature)


class FeaturesWithRawResponse:
    """The methods of :class:`Features`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Features) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)

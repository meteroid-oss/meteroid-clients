# this file is @generated
"""Product families API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    ProductFamily,
    ProductFamilyCreateRequest,
    ProductFamilyListResponse,
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


class AsyncProductFamilies(ApiBaseAsync):
    """Product families API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncProductFamiliesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncProductFamiliesWithRawResponse(self)

    async def list(
        self,
        *,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        search: str | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamilyListResponse:
        """List product families

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/product_families",
                query_params=serialize_query_params(
                    {
                        "order_by": order_by,
                        "page": page,
                        "per_page": per_page,
                        "search": search,
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
        return decode_response(response, ProductFamilyListResponse)

    async def create(
        self,
        *,
        name: str,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamily:
        """Create product family"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/product_families",
                json_body=to_json_value(
                    ProductFamilyCreateRequest(
                        name=name,
                    ),
                    ProductFamilyCreateRequest,
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
        return decode_response(response, ProductFamily)

    async def retrieve(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamily:
        """Get product family

        Retrieve a single product family by ID or alias."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/product_families/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
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
        return decode_response(response, ProductFamily)


class AsyncProductFamiliesWithRawResponse:
    """The methods of :class:`AsyncProductFamilies`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncProductFamilies) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)


class ProductFamilies(ApiBaseSync):
    """Product families API."""

    @property
    def with_raw_response(self) -> ProductFamiliesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return ProductFamiliesWithRawResponse(self)

    def list(
        self,
        *,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        search: str | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamilyListResponse:
        """List product families

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/product_families",
                query_params=serialize_query_params(
                    {
                        "order_by": order_by,
                        "page": page,
                        "per_page": per_page,
                        "search": search,
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
        return decode_response(response, ProductFamilyListResponse)

    def create(
        self,
        *,
        name: str,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamily:
        """Create product family"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/product_families",
                json_body=to_json_value(
                    ProductFamilyCreateRequest(
                        name=name,
                    ),
                    ProductFamilyCreateRequest,
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
        return decode_response(response, ProductFamily)

    def retrieve(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ProductFamily:
        """Get product family

        Retrieve a single product family by ID or alias."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/product_families/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
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
        return decode_response(response, ProductFamily)


class ProductFamiliesWithRawResponse:
    """The methods of :class:`ProductFamilies`, returning an :class:`APIResponse`."""

    def __init__(self, resource: ProductFamilies) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)

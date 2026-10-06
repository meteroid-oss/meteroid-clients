# this file is @generated
"""Products API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    CreateProductRequest,
    Product,
    ProductFamilyId,
    ProductFeeStructure,
    ProductListResponse,
    ResolvedEntitlementListResponse,
    UpdateProductRequest,
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


class AsyncProducts(ApiBaseAsync):
    """Products API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncProductsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncProductsWithRawResponse(self)

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
    ) -> ProductListResponse:
        """List products

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products",
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
        return decode_response(response, ProductListResponse)

    async def create(
        self,
        *,
        fee_structure: ProductFeeStructure,
        name: str,
        product_family_id: ProductFamilyId,
        catalog: bool | None = None,
        description: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Create a product"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products",
                json_body=to_json_value(
                    CreateProductRequest(
                        catalog=catalog,
                        description=description,
                        fee_structure=fee_structure,
                        name=name,
                        product_family_id=product_family_id,
                    ),
                    CreateProductRequest,
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
        return decode_response(response, Product)

    async def retrieve(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Get product details"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products/{product_id}",
                path_params={
                    "product_id": product_id,
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
        return decode_response(response, Product)

    async def update(
        self,
        product_id: str,
        *,
        description: str | None | Unset = UNSET,
        fee_structure: ProductFeeStructure | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Update a product

        Partially update product fields. The fee_type is immutable and cannot be changed."""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/products/{product_id}",
                path_params={
                    "product_id": product_id,
                },
                json_body=to_json_value(
                    UpdateProductRequest(
                        description=description,
                        fee_structure=fee_structure,
                        name=name,
                    ),
                    UpdateProductRequest,
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
        return decode_response(response, Product)

    async def archive(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a product"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products/{product_id}/archive",
                path_params={
                    "product_id": product_id,
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

    async def list_entitlements(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ResolvedEntitlementListResponse:
        """List product entitlements"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products/{product_id}/entitlements",
                path_params={
                    "product_id": product_id,
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
        return decode_response(response, ResolvedEntitlementListResponse)

    async def unarchive(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a product"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products/{product_id}/unarchive",
                path_params={
                    "product_id": product_id,
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


class AsyncProductsWithRawResponse:
    """The methods of :class:`AsyncProducts`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncProducts) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update = async_to_raw_response_wrapper(resource.update)
        self.archive = async_to_raw_response_wrapper(resource.archive)
        self.list_entitlements = async_to_raw_response_wrapper(
            resource.list_entitlements
        )
        self.unarchive = async_to_raw_response_wrapper(resource.unarchive)


class Products(ApiBaseSync):
    """Products API."""

    @property
    def with_raw_response(self) -> ProductsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return ProductsWithRawResponse(self)

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
    ) -> ProductListResponse:
        """List products

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products",
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
        return decode_response(response, ProductListResponse)

    def create(
        self,
        *,
        fee_structure: ProductFeeStructure,
        name: str,
        product_family_id: ProductFamilyId,
        catalog: bool | None = None,
        description: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Create a product"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products",
                json_body=to_json_value(
                    CreateProductRequest(
                        catalog=catalog,
                        description=description,
                        fee_structure=fee_structure,
                        name=name,
                        product_family_id=product_family_id,
                    ),
                    CreateProductRequest,
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
        return decode_response(response, Product)

    def retrieve(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Get product details"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products/{product_id}",
                path_params={
                    "product_id": product_id,
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
        return decode_response(response, Product)

    def update(
        self,
        product_id: str,
        *,
        description: str | None | Unset = UNSET,
        fee_structure: ProductFeeStructure | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Product:
        """Update a product

        Partially update product fields. The fee_type is immutable and cannot be changed."""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/products/{product_id}",
                path_params={
                    "product_id": product_id,
                },
                json_body=to_json_value(
                    UpdateProductRequest(
                        description=description,
                        fee_structure=fee_structure,
                        name=name,
                    ),
                    UpdateProductRequest,
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
        return decode_response(response, Product)

    def archive(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a product"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products/{product_id}/archive",
                path_params={
                    "product_id": product_id,
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

    def list_entitlements(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ResolvedEntitlementListResponse:
        """List product entitlements"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/products/{product_id}/entitlements",
                path_params={
                    "product_id": product_id,
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
        return decode_response(response, ResolvedEntitlementListResponse)

    def unarchive(
        self,
        product_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a product"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/products/{product_id}/unarchive",
                path_params={
                    "product_id": product_id,
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


class ProductsWithRawResponse:
    """The methods of :class:`Products`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Products) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update = to_raw_response_wrapper(resource.update)
        self.archive = to_raw_response_wrapper(resource.archive)
        self.list_entitlements = to_raw_response_wrapper(resource.list_entitlements)
        self.unarchive = to_raw_response_wrapper(resource.unarchive)

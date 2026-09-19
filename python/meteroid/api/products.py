# this file is @generated
import typing as t

from ..models import (
    CreateProductRequest,
    Product,
    ProductFamilyId,
    ProductListResponse,
    ResolvedEntitlementListResponse,
    UpdateProductRequest,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class ProductsAsync(ApiBaseAsync):
    """products API."""

    async def list_products(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> ProductListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
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
        )
        return ProductListResponse.from_dict(response.json())

    async def create_product(
        self,
        create_product_request: CreateProductRequest,
    ) -> Product:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/products",
            json_body=create_product_request.to_dict(),
        )
        return Product.from_dict(response.json())

    async def get_product(
        self,
        product_id: str,
    ) -> Product:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/products/{product_id}",
            path_params={
                "product_id": product_id,
            },
        )
        return Product.from_dict(response.json())

    async def update_product(
        self,
        product_id: str,
        update_product_request: UpdateProductRequest,
    ) -> Product:
        """Partially update product fields. The fee_type is immutable and cannot be changed."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/products/{product_id}",
            path_params={
                "product_id": product_id,
            },
            json_body=update_product_request.to_dict(),
        )
        return Product.from_dict(response.json())

    async def archive_product(
        self,
        product_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/products/{product_id}/archive",
            path_params={
                "product_id": product_id,
            },
        )

    async def list_product_entitlements(
        self,
        product_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/products/{product_id}/entitlements",
            path_params={
                "product_id": product_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    async def unarchive_product(
        self,
        product_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/products/{product_id}/unarchive",
            path_params={
                "product_id": product_id,
            },
        )


class Products(ApiBaseSync):
    """products API."""

    def list_products(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> ProductListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `name.asc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
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
        )
        return ProductListResponse.from_dict(response.json())

    def create_product(
        self,
        create_product_request: CreateProductRequest,
    ) -> Product:
        response = self._request_sync(
            method="post",
            path="/api/v1/products",
            json_body=create_product_request.to_dict(),
        )
        return Product.from_dict(response.json())

    def get_product(
        self,
        product_id: str,
    ) -> Product:
        response = self._request_sync(
            method="get",
            path="/api/v1/products/{product_id}",
            path_params={
                "product_id": product_id,
            },
        )
        return Product.from_dict(response.json())

    def update_product(
        self,
        product_id: str,
        update_product_request: UpdateProductRequest,
    ) -> Product:
        """Partially update product fields. The fee_type is immutable and cannot be changed."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/products/{product_id}",
            path_params={
                "product_id": product_id,
            },
            json_body=update_product_request.to_dict(),
        )
        return Product.from_dict(response.json())

    def archive_product(
        self,
        product_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/products/{product_id}/archive",
            path_params={
                "product_id": product_id,
            },
        )

    def list_product_entitlements(
        self,
        product_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/products/{product_id}/entitlements",
            path_params={
                "product_id": product_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    def unarchive_product(
        self,
        product_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/products/{product_id}/unarchive",
            path_params={
                "product_id": product_id,
            },
        )

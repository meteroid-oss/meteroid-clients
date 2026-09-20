# this file is @generated
import typing as t

from ..models import (
    ProductFamily,
    ProductFamilyCreateRequest,
    ProductFamilyListResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class ProductFamiliesAsync(ApiBaseAsync):
    """product families API."""

    async def list_product_families(
        self,
        *,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
        search: t.Optional[str] = None,
    ) -> ProductFamilyListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
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
        )
        return decode_response(response, ProductFamilyListResponse)

    async def create_product_family(
        self,
        product_family_create_request: ProductFamilyCreateRequest,
    ) -> ProductFamily:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/product_families",
            json_body=product_family_create_request.to_dict(),
        )
        return decode_response(response, ProductFamily)

    async def get_product_family_by_id_or_alias(
        self,
        id_or_alias: str,
    ) -> ProductFamily:
        """Retrieve a single product family by ID or alias."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/product_families/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, ProductFamily)


class ProductFamilies(ApiBaseSync):
    """product families API."""

    def list_product_families(
        self,
        *,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
        search: t.Optional[str] = None,
    ) -> ProductFamilyListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
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
        )
        return decode_response(response, ProductFamilyListResponse)

    def create_product_family(
        self,
        product_family_create_request: ProductFamilyCreateRequest,
    ) -> ProductFamily:
        response = self._request_sync(
            method="post",
            path="/api/v1/product_families",
            json_body=product_family_create_request.to_dict(),
        )
        return decode_response(response, ProductFamily)

    def get_product_family_by_id_or_alias(
        self,
        id_or_alias: str,
    ) -> ProductFamily:
        """Retrieve a single product family by ID or alias."""
        response = self._request_sync(
            method="get",
            path="/api/v1/product_families/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, ProductFamily)

# this file is @generated
import typing as t

from ..models import (
    Coupon,
    CouponFilter,
    CouponListResponse,
    CreateCouponRequest,
    UpdateCouponRequest,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class CouponsAsync(ApiBaseAsync):
    """coupons API."""

    async def list_coupons(
        self,
        *,
        search: t.Optional[str] = None,
        filter: t.Optional[CouponFilter] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CouponListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/coupons",
            query_params=serialize_query_params(
                {
                    "search": search,
                    "filter": filter,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return CouponListResponse.from_dict(response.json())

    async def create_coupon(
        self,
        create_coupon_request: CreateCouponRequest,
    ) -> Coupon:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/coupons",
            json_body=create_coupon_request.to_dict(),
        )
        return Coupon.from_dict(response.json())

    async def get_coupon(
        self,
        coupon_id: str,
    ) -> Coupon:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/coupons/{coupon_id}",
            path_params={
                "coupon_id": coupon_id,
            },
        )
        return Coupon.from_dict(response.json())

    async def update_coupon(
        self,
        coupon_id: str,
        update_coupon_request: UpdateCouponRequest,
    ) -> Coupon:
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/coupons/{coupon_id}",
            path_params={
                "coupon_id": coupon_id,
            },
            json_body=update_coupon_request.to_dict(),
        )
        return Coupon.from_dict(response.json())

    async def archive_coupon(
        self,
        coupon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/coupons/{coupon_id}/archive",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    async def disable_coupon(
        self,
        coupon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/coupons/{coupon_id}/disable",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    async def enable_coupon(
        self,
        coupon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/coupons/{coupon_id}/enable",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    async def unarchive_coupon(
        self,
        coupon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/coupons/{coupon_id}/unarchive",
            path_params={
                "coupon_id": coupon_id,
            },
        )


class Coupons(ApiBaseSync):
    """coupons API."""

    def list_coupons(
        self,
        *,
        search: t.Optional[str] = None,
        filter: t.Optional[CouponFilter] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CouponListResponse:
        """:param order_by: Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/coupons",
            query_params=serialize_query_params(
                {
                    "search": search,
                    "filter": filter,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return CouponListResponse.from_dict(response.json())

    def create_coupon(
        self,
        create_coupon_request: CreateCouponRequest,
    ) -> Coupon:
        response = self._request_sync(
            method="post",
            path="/api/v1/coupons",
            json_body=create_coupon_request.to_dict(),
        )
        return Coupon.from_dict(response.json())

    def get_coupon(
        self,
        coupon_id: str,
    ) -> Coupon:
        response = self._request_sync(
            method="get",
            path="/api/v1/coupons/{coupon_id}",
            path_params={
                "coupon_id": coupon_id,
            },
        )
        return Coupon.from_dict(response.json())

    def update_coupon(
        self,
        coupon_id: str,
        update_coupon_request: UpdateCouponRequest,
    ) -> Coupon:
        response = self._request_sync(
            method="patch",
            path="/api/v1/coupons/{coupon_id}",
            path_params={
                "coupon_id": coupon_id,
            },
            json_body=update_coupon_request.to_dict(),
        )
        return Coupon.from_dict(response.json())

    def archive_coupon(
        self,
        coupon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/coupons/{coupon_id}/archive",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    def disable_coupon(
        self,
        coupon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/coupons/{coupon_id}/disable",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    def enable_coupon(
        self,
        coupon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/coupons/{coupon_id}/enable",
            path_params={
                "coupon_id": coupon_id,
            },
        )

    def unarchive_coupon(
        self,
        coupon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/coupons/{coupon_id}/unarchive",
            path_params={
                "coupon_id": coupon_id,
            },
        )

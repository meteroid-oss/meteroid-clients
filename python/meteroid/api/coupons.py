# this file is @generated
"""Coupons API."""

from __future__ import annotations

import builtins
import typing as t
from datetime import datetime

from .. import models as _models
from ..models import (
    Coupon,
    CouponDiscount,
    CouponFilter,
    CouponListResponse,
    CreateCouponRequest,
    PlanId,
    UpdateCouponRequest,
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


class AsyncCoupons(ApiBaseAsync):
    """Coupons API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncCouponsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncCouponsWithRawResponse(self)

    async def list(
        self,
        *,
        search: str | None = None,
        filter: CouponFilter | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CouponListResponse:
        """List coupons

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
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
        return decode_response(response, CouponListResponse)

    async def create(
        self,
        *,
        code: str,
        discount: CouponDiscount,
        description: str | None | Unset = UNSET,
        expires_at: datetime | None | Unset = UNSET,
        plan_ids: builtins.list[PlanId] | None = None,
        recurring_value: int | None | Unset = UNSET,
        redemption_limit: int | None | Unset = UNSET,
        reusable: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Create a coupon"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons",
                json_body=to_json_value(
                    CreateCouponRequest(
                        code=code,
                        description=description,
                        discount=discount,
                        expires_at=expires_at,
                        plan_ids=plan_ids,
                        recurring_value=recurring_value,
                        redemption_limit=redemption_limit,
                        reusable=reusable,
                    ),
                    CreateCouponRequest,
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
        return decode_response(response, Coupon)

    async def retrieve(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Get coupon details"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/coupons/{coupon_id}",
                path_params={
                    "coupon_id": coupon_id,
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
        return decode_response(response, Coupon)

    async def update(
        self,
        coupon_id: str,
        *,
        description: str | None | Unset = UNSET,
        discount: CouponDiscount | None | Unset = UNSET,
        plan_ids: builtins.list[PlanId] | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Update a coupon"""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/coupons/{coupon_id}",
                path_params={
                    "coupon_id": coupon_id,
                },
                json_body=to_json_value(
                    UpdateCouponRequest(
                        description=description,
                        discount=discount,
                        plan_ids=plan_ids,
                    ),
                    UpdateCouponRequest,
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
        return decode_response(response, Coupon)

    async def archive(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a coupon"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/archive",
                path_params={
                    "coupon_id": coupon_id,
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

    async def disable(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Disable a coupon"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/disable",
                path_params={
                    "coupon_id": coupon_id,
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

    async def enable(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Enable a coupon"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/enable",
                path_params={
                    "coupon_id": coupon_id,
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
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a coupon"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/unarchive",
                path_params={
                    "coupon_id": coupon_id,
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


class AsyncCouponsWithRawResponse:
    """The methods of :class:`AsyncCoupons`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncCoupons) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update = async_to_raw_response_wrapper(resource.update)
        self.archive = async_to_raw_response_wrapper(resource.archive)
        self.disable = async_to_raw_response_wrapper(resource.disable)
        self.enable = async_to_raw_response_wrapper(resource.enable)
        self.unarchive = async_to_raw_response_wrapper(resource.unarchive)


class Coupons(ApiBaseSync):
    """Coupons API."""

    @property
    def with_raw_response(self) -> CouponsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return CouponsWithRawResponse(self)

    def list(
        self,
        *,
        search: str | None = None,
        filter: CouponFilter | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CouponListResponse:
        """List coupons

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
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
        return decode_response(response, CouponListResponse)

    def create(
        self,
        *,
        code: str,
        discount: CouponDiscount,
        description: str | None | Unset = UNSET,
        expires_at: datetime | None | Unset = UNSET,
        plan_ids: builtins.list[PlanId] | None = None,
        recurring_value: int | None | Unset = UNSET,
        redemption_limit: int | None | Unset = UNSET,
        reusable: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Create a coupon"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons",
                json_body=to_json_value(
                    CreateCouponRequest(
                        code=code,
                        description=description,
                        discount=discount,
                        expires_at=expires_at,
                        plan_ids=plan_ids,
                        recurring_value=recurring_value,
                        redemption_limit=redemption_limit,
                        reusable=reusable,
                    ),
                    CreateCouponRequest,
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
        return decode_response(response, Coupon)

    def retrieve(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Get coupon details"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/coupons/{coupon_id}",
                path_params={
                    "coupon_id": coupon_id,
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
        return decode_response(response, Coupon)

    def update(
        self,
        coupon_id: str,
        *,
        description: str | None | Unset = UNSET,
        discount: CouponDiscount | None | Unset = UNSET,
        plan_ids: builtins.list[PlanId] | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Coupon:
        """Update a coupon"""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/coupons/{coupon_id}",
                path_params={
                    "coupon_id": coupon_id,
                },
                json_body=to_json_value(
                    UpdateCouponRequest(
                        description=description,
                        discount=discount,
                        plan_ids=plan_ids,
                    ),
                    UpdateCouponRequest,
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
        return decode_response(response, Coupon)

    def archive(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a coupon"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/archive",
                path_params={
                    "coupon_id": coupon_id,
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

    def disable(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Disable a coupon"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/disable",
                path_params={
                    "coupon_id": coupon_id,
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

    def enable(
        self,
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Enable a coupon"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/enable",
                path_params={
                    "coupon_id": coupon_id,
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
        coupon_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Unarchive a coupon"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/coupons/{coupon_id}/unarchive",
                path_params={
                    "coupon_id": coupon_id,
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


class CouponsWithRawResponse:
    """The methods of :class:`Coupons`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Coupons) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update = to_raw_response_wrapper(resource.update)
        self.archive = to_raw_response_wrapper(resource.archive)
        self.disable = to_raw_response_wrapper(resource.disable)
        self.enable = to_raw_response_wrapper(resource.enable)
        self.unarchive = to_raw_response_wrapper(resource.unarchive)

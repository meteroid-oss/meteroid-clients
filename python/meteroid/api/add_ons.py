# this file is @generated
import typing as t

from ..models import (
    AddOn,
    AddOnListResponse,
    CreateAddOnRequest,
    ResolvedEntitlementListResponse,
    UpdateAddOnRequest,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class AddOnsAsync(ApiBaseAsync):
    """add ons API."""

    async def list_addons(
        self,
        *,
        search: t.Optional[str] = None,
        currency: t.Optional[str] = None,
        include_archived: t.Optional[bool] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> AddOnListResponse:
        """:param include_archived: Include archived add-ons in the results (default: false)
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/addons",
            query_params=serialize_query_params(
                {
                    "search": search,
                    "currency": currency,
                    "include_archived": include_archived,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return AddOnListResponse.from_dict(response.json())

    async def create_addon(
        self,
        create_add_on_request: CreateAddOnRequest,
    ) -> AddOn:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/addons",
            json_body=create_add_on_request.to_dict(),
        )
        return AddOn.from_dict(response.json())

    async def get_addon(
        self,
        addon_id: str,
    ) -> AddOn:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/addons/{addon_id}",
            path_params={
                "addon_id": addon_id,
            },
        )
        return AddOn.from_dict(response.json())

    async def update_addon(
        self,
        addon_id: str,
        update_add_on_request: UpdateAddOnRequest,
    ) -> AddOn:
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/addons/{addon_id}",
            path_params={
                "addon_id": addon_id,
            },
            json_body=update_add_on_request.to_dict(),
        )
        return AddOn.from_dict(response.json())

    async def archive_addon(
        self,
        addon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/addons/{addon_id}/archive",
            path_params={
                "addon_id": addon_id,
            },
        )

    async def list_add_on_entitlements(
        self,
        addon_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/addons/{addon_id}/entitlements",
            path_params={
                "addon_id": addon_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    async def unarchive_addon(
        self,
        addon_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/addons/{addon_id}/unarchive",
            path_params={
                "addon_id": addon_id,
            },
        )


class AddOns(ApiBaseSync):
    """add ons API."""

    def list_addons(
        self,
        *,
        search: t.Optional[str] = None,
        currency: t.Optional[str] = None,
        include_archived: t.Optional[bool] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> AddOnListResponse:
        """:param include_archived: Include archived add-ons in the results (default: false)
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/addons",
            query_params=serialize_query_params(
                {
                    "search": search,
                    "currency": currency,
                    "include_archived": include_archived,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return AddOnListResponse.from_dict(response.json())

    def create_addon(
        self,
        create_add_on_request: CreateAddOnRequest,
    ) -> AddOn:
        response = self._request_sync(
            method="post",
            path="/api/v1/addons",
            json_body=create_add_on_request.to_dict(),
        )
        return AddOn.from_dict(response.json())

    def get_addon(
        self,
        addon_id: str,
    ) -> AddOn:
        response = self._request_sync(
            method="get",
            path="/api/v1/addons/{addon_id}",
            path_params={
                "addon_id": addon_id,
            },
        )
        return AddOn.from_dict(response.json())

    def update_addon(
        self,
        addon_id: str,
        update_add_on_request: UpdateAddOnRequest,
    ) -> AddOn:
        response = self._request_sync(
            method="patch",
            path="/api/v1/addons/{addon_id}",
            path_params={
                "addon_id": addon_id,
            },
            json_body=update_add_on_request.to_dict(),
        )
        return AddOn.from_dict(response.json())

    def archive_addon(
        self,
        addon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/addons/{addon_id}/archive",
            path_params={
                "addon_id": addon_id,
            },
        )

    def list_add_on_entitlements(
        self,
        addon_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/addons/{addon_id}/entitlements",
            path_params={
                "addon_id": addon_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    def unarchive_addon(
        self,
        addon_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/addons/{addon_id}/unarchive",
            path_params={
                "addon_id": addon_id,
            },
        )

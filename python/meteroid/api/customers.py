# this file is @generated
import typing as t

from ..models import (
    Customer,
    CustomerCreateRequest,
    CustomerListResponse,
    CustomerPatchRequest,
    CustomerPortalTokenRequest,
    CustomerPortalTokenResponse,
    CustomerUpdateRequest,
    EffectiveEntitlementListResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class CustomersAsync(ApiBaseAsync):
    """customers API."""

    async def list_customers(
        self,
        *,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
        search: t.Optional[str] = None,
        archived: t.Optional[bool] = None,
    ) -> CustomerListResponse:
        """List customers with optional pagination and search filtering.

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/customers",
            query_params=serialize_query_params(
                {
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                    "search": search,
                    "archived": archived,
                },
            ),
        )
        return decode_response(response, CustomerListResponse)

    async def create_customer(
        self,
        customer_create_request: CustomerCreateRequest,
    ) -> Customer:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/customers",
            json_body=customer_create_request.to_dict(),
        )
        return decode_response(response, Customer)

    async def get_customer(
        self,
        id_or_alias: str,
    ) -> Customer:
        """Retrieve a single customer by ID or alias."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, Customer)

    async def update_customer(
        self,
        id_or_alias: str,
        customer_update_request: CustomerUpdateRequest,
    ) -> Customer:
        response = await self._request_asyncio(
            method="put",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_update_request.to_dict(),
        )
        return decode_response(response, Customer)

    async def archive_customer(
        self,
        id_or_alias: str,
    ) -> None:
        """No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail."""
        await self._request_asyncio(
            method="delete",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )

    async def patch_customer(
        self,
        id_or_alias: str,
        customer_patch_request: CustomerPatchRequest,
    ) -> Customer:
        """Partially update a customer. Only provided fields will be updated."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_patch_request.to_dict(),
        )
        return decode_response(response, Customer)

    async def get_effective_entitlements(
        self,
        id_or_alias: str,
    ) -> EffectiveEntitlementListResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/customers/{id_or_alias}/entitlements",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, EffectiveEntitlementListResponse)

    async def create_portal_token(
        self,
        id_or_alias: str,
        customer_portal_token_request: CustomerPortalTokenRequest,
    ) -> CustomerPortalTokenResponse:
        """Generates a JWT token that grants access to the customer portal.
        The token can be used to access invoices, payment methods, and other portal features."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/customers/{id_or_alias}/portal-token",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_portal_token_request.to_dict(),
        )
        return decode_response(response, CustomerPortalTokenResponse)

    async def unarchive_customer(
        self,
        id_or_alias: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/customers/{id_or_alias}/unarchive",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )


class Customers(ApiBaseSync):
    """customers API."""

    def list_customers(
        self,
        *,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
        search: t.Optional[str] = None,
        archived: t.Optional[bool] = None,
    ) -> CustomerListResponse:
        """List customers with optional pagination and search filtering.

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/customers",
            query_params=serialize_query_params(
                {
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                    "search": search,
                    "archived": archived,
                },
            ),
        )
        return decode_response(response, CustomerListResponse)

    def create_customer(
        self,
        customer_create_request: CustomerCreateRequest,
    ) -> Customer:
        response = self._request_sync(
            method="post",
            path="/api/v1/customers",
            json_body=customer_create_request.to_dict(),
        )
        return decode_response(response, Customer)

    def get_customer(
        self,
        id_or_alias: str,
    ) -> Customer:
        """Retrieve a single customer by ID or alias."""
        response = self._request_sync(
            method="get",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, Customer)

    def update_customer(
        self,
        id_or_alias: str,
        customer_update_request: CustomerUpdateRequest,
    ) -> Customer:
        response = self._request_sync(
            method="put",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_update_request.to_dict(),
        )
        return decode_response(response, Customer)

    def archive_customer(
        self,
        id_or_alias: str,
    ) -> None:
        """No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail."""
        self._request_sync(
            method="delete",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )

    def patch_customer(
        self,
        id_or_alias: str,
        customer_patch_request: CustomerPatchRequest,
    ) -> Customer:
        """Partially update a customer. Only provided fields will be updated."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/customers/{id_or_alias}",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_patch_request.to_dict(),
        )
        return decode_response(response, Customer)

    def get_effective_entitlements(
        self,
        id_or_alias: str,
    ) -> EffectiveEntitlementListResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/customers/{id_or_alias}/entitlements",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )
        return decode_response(response, EffectiveEntitlementListResponse)

    def create_portal_token(
        self,
        id_or_alias: str,
        customer_portal_token_request: CustomerPortalTokenRequest,
    ) -> CustomerPortalTokenResponse:
        """Generates a JWT token that grants access to the customer portal.
        The token can be used to access invoices, payment methods, and other portal features."""
        response = self._request_sync(
            method="post",
            path="/api/v1/customers/{id_or_alias}/portal-token",
            path_params={
                "id_or_alias": id_or_alias,
            },
            json_body=customer_portal_token_request.to_dict(),
        )
        return decode_response(response, CustomerPortalTokenResponse)

    def unarchive_customer(
        self,
        id_or_alias: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/customers/{id_or_alias}/unarchive",
            path_params={
                "id_or_alias": id_or_alias,
            },
        )

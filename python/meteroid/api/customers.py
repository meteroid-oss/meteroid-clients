# this file is @generated
"""Customers API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    Address,
    Currency,
    CurrencyLiteral,
    Customer,
    CustomerCreateRequest,
    CustomerListResponse,
    CustomerPatchRequest,
    CustomerPortalTokenRequest,
    CustomerPortalTokenResponse,
    CustomerType,
    CustomerTypeLiteral,
    CustomerUpdateRequest,
    CustomTaxRate,
    EffectiveEntitlementListResponse,
    InvoicingEntityId,
    ShippingAddress,
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


class AsyncCustomers(ApiBaseAsync):
    """Customers API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncCustomersWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncCustomersWithRawResponse(self)

    async def list(
        self,
        *,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        search: str | None = None,
        archived: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomerListResponse:
        """List customers with optional pagination and search filtering.

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
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
        return decode_response(response, CustomerListResponse)

    async def create(
        self,
        *,
        currency: Currency | CurrencyLiteral,
        custom_taxes: builtins.list[CustomTaxRate],
        invoicing_emails: builtins.list[str],
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        connected_account_id: str | None | Unset = UNSET,
        custom_properties: t.Any = None,
        customer_type: CustomerType | CustomerTypeLiteral | None = None,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_entity_id: InvoicingEntityId | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None = None,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Create customer

        :param custom_properties: User-defined custom property values, keyed by definition `key`. Validated against the tenant's `CUSTOMER` property definitions. Omit to leave unset.
        :param customer_type: `INDIVIDUAL` requires `first_name`, `last_name`, and a billing-address country.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param name: Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. The first one the renderer has a template for wins, so an unsupported entry alongside a supported one just falls through; a list of only unsupported ones is rejected."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers",
                json_body=to_json_value(
                    CustomerCreateRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        connected_account_id=connected_account_id,
                        currency=t.cast("Currency", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast("CustomerType | None", customer_type),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerCreateRequest,
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
        return decode_response(response, Customer)

    async def retrieve(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Get customer

        Retrieve a single customer by ID or alias."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/customers/{id_or_alias}",
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
        return decode_response(response, Customer)

    async def replace(
        self,
        id_or_alias: str,
        *,
        currency: Currency | CurrencyLiteral,
        custom_taxes: builtins.list[CustomTaxRate],
        invoicing_emails: builtins.list[str],
        invoicing_entity_id: InvoicingEntityId,
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        custom_properties: t.Any = None,
        customer_type: CustomerType | CustomerTypeLiteral | None | Unset = UNSET,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None = None,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Update customer

        :param custom_properties: User-defined custom property values (full replace). Omit to leave unchanged.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param first_name: Omit to keep the stored value (a full replace does not blank a person's name).
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param name: Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to reset to that default (full-replace update)."""
        response = await self._request(
            ApiRequest(
                method="put",
                path="/api/v1/customers/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerUpdateRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        currency=t.cast("Currency", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast(
                            "CustomerType | None | Unset", customer_type
                        ),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerUpdateRequest,
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
        return decode_response(response, Customer)

    async def archive(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a customer

        No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail."""
        await self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/customers/{id_or_alias}",
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

    async def update(
        self,
        id_or_alias: str,
        *,
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        currency: Currency | CurrencyLiteral | None | Unset = UNSET,
        custom_properties: t.Any = None,
        custom_taxes: builtins.list[CustomTaxRate] | None | Unset = UNSET,
        customer_type: CustomerType | CustomerTypeLiteral | None | Unset = UNSET,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_emails: builtins.list[str] | None | Unset = UNSET,
        invoicing_entity_id: InvoicingEntityId | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Patch customer

        Partially update a customer. Only provided fields will be updated.

        :param custom_properties: Partial update of custom property values (merge; send a key with `null` to remove it). Omit to leave unchanged.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave unchanged, send `[]` to reset to that default."""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/customers/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerPatchRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        currency=t.cast("Currency | None | Unset", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast(
                            "CustomerType | None | Unset", customer_type
                        ),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerPatchRequest,
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
        return decode_response(response, Customer)

    async def list_entitlements(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> EffectiveEntitlementListResponse:
        """List customer entitlements"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/customers/{id_or_alias}/entitlements",
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
        return decode_response(response, EffectiveEntitlementListResponse)

    async def create_portal_token(
        self,
        id_or_alias: str,
        *,
        expires_in_seconds: int | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomerPortalTokenResponse:
        """Generate a portal token for a customer

        Generates a JWT token that grants access to the customer portal.
        The token can be used to access invoices, payment methods, and other portal features.

        :param expires_in_seconds: Token lifetime in seconds. Defaults to 86400 (24 hours). Must be between 60 and 2592000 (30 days)."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers/{id_or_alias}/portal-token",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerPortalTokenRequest(
                        expires_in_seconds=expires_in_seconds,
                    ),
                    CustomerPortalTokenRequest,
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
        return decode_response(response, CustomerPortalTokenResponse)

    async def unarchive(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Restore an archived customer"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers/{id_or_alias}/unarchive",
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


class AsyncCustomersWithRawResponse:
    """The methods of :class:`AsyncCustomers`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncCustomers) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.replace = async_to_raw_response_wrapper(resource.replace)
        self.archive = async_to_raw_response_wrapper(resource.archive)
        self.update = async_to_raw_response_wrapper(resource.update)
        self.list_entitlements = async_to_raw_response_wrapper(
            resource.list_entitlements
        )
        self.create_portal_token = async_to_raw_response_wrapper(
            resource.create_portal_token
        )
        self.unarchive = async_to_raw_response_wrapper(resource.unarchive)


class Customers(ApiBaseSync):
    """Customers API."""

    @property
    def with_raw_response(self) -> CustomersWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return CustomersWithRawResponse(self)

    def list(
        self,
        *,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        search: str | None = None,
        archived: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomerListResponse:
        """List customers with optional pagination and search filtering.

        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `email`, `alias`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
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
        return decode_response(response, CustomerListResponse)

    def create(
        self,
        *,
        currency: Currency | CurrencyLiteral,
        custom_taxes: builtins.list[CustomTaxRate],
        invoicing_emails: builtins.list[str],
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        connected_account_id: str | None | Unset = UNSET,
        custom_properties: t.Any = None,
        customer_type: CustomerType | CustomerTypeLiteral | None = None,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_entity_id: InvoicingEntityId | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None = None,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Create customer

        :param custom_properties: User-defined custom property values, keyed by definition `key`. Validated against the tenant's `CUSTOMER` property definitions. Omit to leave unset.
        :param customer_type: `INDIVIDUAL` requires `first_name`, `last_name`, and a billing-address country.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param name: Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. The first one the renderer has a template for wins, so an unsupported entry alongside a supported one just falls through; a list of only unsupported ones is rejected."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers",
                json_body=to_json_value(
                    CustomerCreateRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        connected_account_id=connected_account_id,
                        currency=t.cast("Currency", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast("CustomerType | None", customer_type),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerCreateRequest,
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
        return decode_response(response, Customer)

    def retrieve(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Get customer

        Retrieve a single customer by ID or alias."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/customers/{id_or_alias}",
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
        return decode_response(response, Customer)

    def replace(
        self,
        id_or_alias: str,
        *,
        currency: Currency | CurrencyLiteral,
        custom_taxes: builtins.list[CustomTaxRate],
        invoicing_emails: builtins.list[str],
        invoicing_entity_id: InvoicingEntityId,
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        custom_properties: t.Any = None,
        customer_type: CustomerType | CustomerTypeLiteral | None | Unset = UNSET,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None = None,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Update customer

        :param custom_properties: User-defined custom property values (full replace). Omit to leave unchanged.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param first_name: Omit to keep the stored value (a full replace does not blank a person's name).
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param name: Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`.
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to reset to that default (full-replace update)."""
        response = self._request(
            ApiRequest(
                method="put",
                path="/api/v1/customers/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerUpdateRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        currency=t.cast("Currency", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast(
                            "CustomerType | None | Unset", customer_type
                        ),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerUpdateRequest,
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
        return decode_response(response, Customer)

    def archive(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Archive a customer

        No linked entity will be deleted. You need to terminate all active subscriptions before archiving a customer, or the call will fail."""
        self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/customers/{id_or_alias}",
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

    def update(
        self,
        id_or_alias: str,
        *,
        alias: str | None | Unset = UNSET,
        billing_address: Address | None | Unset = UNSET,
        billing_email: str | None | Unset = UNSET,
        currency: Currency | CurrencyLiteral | None | Unset = UNSET,
        custom_properties: t.Any = None,
        custom_taxes: builtins.list[CustomTaxRate] | None | Unset = UNSET,
        customer_type: CustomerType | CustomerTypeLiteral | None | Unset = UNSET,
        exemption_reason: str | None | Unset = UNSET,
        first_name: str | None | Unset = UNSET,
        invoicing_emails: builtins.list[str] | None | Unset = UNSET,
        invoicing_entity_id: InvoicingEntityId | None | Unset = UNSET,
        invoicing_language: str | None | Unset = UNSET,
        is_tax_exempt: bool | None | Unset = UNSET,
        last_name: str | None | Unset = UNSET,
        legal_number: str | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        phone: str | None | Unset = UNSET,
        preferred_locales: builtins.list[str] | None | Unset = UNSET,
        shipping_address: ShippingAddress | None | Unset = UNSET,
        vat_number: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Customer:
        """Patch customer

        Partially update a customer. Only provided fields will be updated.

        :param custom_properties: Partial update of custom property values (merge; send a key with `null` to remove it). Omit to leave unchanged.
        :param exemption_reason: Free-text legal exemption mention surfaced on exempt invoices.
        :param invoicing_language: Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.
        :param legal_number: BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
        :param preferred_locales: Preferred document languages, most-preferred first (BCP-47 tags, e.g. `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave unchanged, send `[]` to reset to that default."""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/customers/{id_or_alias}",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerPatchRequest(
                        alias=alias,
                        billing_address=billing_address,
                        billing_email=billing_email,
                        currency=t.cast("Currency | None | Unset", currency),
                        custom_properties=custom_properties,
                        custom_taxes=custom_taxes,
                        customer_type=t.cast(
                            "CustomerType | None | Unset", customer_type
                        ),
                        exemption_reason=exemption_reason,
                        first_name=first_name,
                        invoicing_emails=invoicing_emails,
                        invoicing_entity_id=invoicing_entity_id,
                        invoicing_language=invoicing_language,
                        is_tax_exempt=is_tax_exempt,
                        last_name=last_name,
                        legal_number=legal_number,
                        name=name,
                        phone=phone,
                        preferred_locales=preferred_locales,
                        shipping_address=shipping_address,
                        vat_number=vat_number,
                    ),
                    CustomerPatchRequest,
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
        return decode_response(response, Customer)

    def list_entitlements(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> EffectiveEntitlementListResponse:
        """List customer entitlements"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/customers/{id_or_alias}/entitlements",
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
        return decode_response(response, EffectiveEntitlementListResponse)

    def create_portal_token(
        self,
        id_or_alias: str,
        *,
        expires_in_seconds: int | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomerPortalTokenResponse:
        """Generate a portal token for a customer

        Generates a JWT token that grants access to the customer portal.
        The token can be used to access invoices, payment methods, and other portal features.

        :param expires_in_seconds: Token lifetime in seconds. Defaults to 86400 (24 hours). Must be between 60 and 2592000 (30 days)."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers/{id_or_alias}/portal-token",
                path_params={
                    "id_or_alias": id_or_alias,
                },
                json_body=to_json_value(
                    CustomerPortalTokenRequest(
                        expires_in_seconds=expires_in_seconds,
                    ),
                    CustomerPortalTokenRequest,
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
        return decode_response(response, CustomerPortalTokenResponse)

    def unarchive(
        self,
        id_or_alias: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Restore an archived customer"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/customers/{id_or_alias}/unarchive",
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


class CustomersWithRawResponse:
    """The methods of :class:`Customers`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Customers) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.replace = to_raw_response_wrapper(resource.replace)
        self.archive = to_raw_response_wrapper(resource.archive)
        self.update = to_raw_response_wrapper(resource.update)
        self.list_entitlements = to_raw_response_wrapper(resource.list_entitlements)
        self.create_portal_token = to_raw_response_wrapper(resource.create_portal_token)
        self.unarchive = to_raw_response_wrapper(resource.unarchive)

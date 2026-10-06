# this file is @generated
"""Invoices API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    EInvoicingStatus,
    Invoice,
    InvoiceCustomPropertiesRequest,
    InvoiceListResponse,
    InvoiceStatus,
    SubscriptionId,
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


class AsyncInvoices(ApiBaseAsync):
    """Invoices API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncInvoicesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncInvoicesWithRawResponse(self)

    async def list(
        self,
        *,
        customer_id: str | None = None,
        subscription_id: SubscriptionId | None = None,
        statuses: builtins.list[InvoiceStatus] | None = None,
        einvoicing_status: EInvoicingStatus | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> InvoiceListResponse:
        """List invoices with optional filtering by customer, subscription, or status.

        :param customer_id: Filter by customer ID or alias
        :param einvoicing_status: Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not opted in carry no status and match neither.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "subscription_id": subscription_id,
                        "statuses": statuses,
                        "einvoicing_status": einvoicing_status,
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
        return decode_response(response, InvoiceListResponse)

    async def retrieve(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Get invoice

        Retrieve a single invoice with its payment transactions."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}",
                path_params={
                    "invoice_id": invoice_id,
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
        return decode_response(response, Invoice)

    async def update_custom_properties(
        self,
        invoice_id: str,
        *,
        custom_properties: t.Any,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Update invoice custom properties

        Merge custom property values onto an invoice (send a key with `null` to remove it).
        Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the invoice
        is finalized."""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/invoices/{invoice_id}/custom-properties",
                path_params={
                    "invoice_id": invoice_id,
                },
                json_body=to_json_value(
                    InvoiceCustomPropertiesRequest(
                        custom_properties=custom_properties,
                    ),
                    InvoiceCustomPropertiesRequest,
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
        return decode_response(response, Invoice)

    async def download(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download invoice PDF

        Download the PDF document for an invoice."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}/download",
                path_params={
                    "invoice_id": invoice_id,
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
        return response.content

    async def refresh(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Refresh invoice

        Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
        Drafts are also refreshed periodically in the background; use this to force it, e.g. after
        ingesting late events. Rejected while a payment for the invoice is in progress or when the
        invoice was merged into a consolidated parent."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/invoices/{invoice_id}/refresh",
                path_params={
                    "invoice_id": invoice_id,
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
        return decode_response(response, Invoice)

    async def download_xml(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download invoice e-invoice XML

        Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
        Factur-X the same XML is also embedded in the PDF."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}/xml",
                path_params={
                    "invoice_id": invoice_id,
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
        return response.content


class AsyncInvoicesWithRawResponse:
    """The methods of :class:`AsyncInvoices`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncInvoices) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update_custom_properties = async_to_raw_response_wrapper(
            resource.update_custom_properties
        )
        self.download = async_to_raw_response_wrapper(resource.download)
        self.refresh = async_to_raw_response_wrapper(resource.refresh)
        self.download_xml = async_to_raw_response_wrapper(resource.download_xml)


class Invoices(ApiBaseSync):
    """Invoices API."""

    @property
    def with_raw_response(self) -> InvoicesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return InvoicesWithRawResponse(self)

    def list(
        self,
        *,
        customer_id: str | None = None,
        subscription_id: SubscriptionId | None = None,
        statuses: builtins.list[InvoiceStatus] | None = None,
        einvoicing_status: EInvoicingStatus | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> InvoiceListResponse:
        """List invoices with optional filtering by customer, subscription, or status.

        :param customer_id: Filter by customer ID or alias
        :param einvoicing_status: Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not opted in carry no status and match neither.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "subscription_id": subscription_id,
                        "statuses": statuses,
                        "einvoicing_status": einvoicing_status,
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
        return decode_response(response, InvoiceListResponse)

    def retrieve(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Get invoice

        Retrieve a single invoice with its payment transactions."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}",
                path_params={
                    "invoice_id": invoice_id,
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
        return decode_response(response, Invoice)

    def update_custom_properties(
        self,
        invoice_id: str,
        *,
        custom_properties: t.Any,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Update invoice custom properties

        Merge custom property values onto an invoice (send a key with `null` to remove it).
        Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the invoice
        is finalized."""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/invoices/{invoice_id}/custom-properties",
                path_params={
                    "invoice_id": invoice_id,
                },
                json_body=to_json_value(
                    InvoiceCustomPropertiesRequest(
                        custom_properties=custom_properties,
                    ),
                    InvoiceCustomPropertiesRequest,
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
        return decode_response(response, Invoice)

    def download(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download invoice PDF

        Download the PDF document for an invoice."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}/download",
                path_params={
                    "invoice_id": invoice_id,
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
        return response.content

    def refresh(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Invoice:
        """Refresh invoice

        Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
        Drafts are also refreshed periodically in the background; use this to force it, e.g. after
        ingesting late events. Rejected while a payment for the invoice is in progress or when the
        invoice was merged into a consolidated parent."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/invoices/{invoice_id}/refresh",
                path_params={
                    "invoice_id": invoice_id,
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
        return decode_response(response, Invoice)

    def download_xml(
        self,
        invoice_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download invoice e-invoice XML

        Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
        Factur-X the same XML is also embedded in the PDF."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/invoices/{invoice_id}/xml",
                path_params={
                    "invoice_id": invoice_id,
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
        return response.content


class InvoicesWithRawResponse:
    """The methods of :class:`Invoices`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Invoices) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update_custom_properties = to_raw_response_wrapper(
            resource.update_custom_properties
        )
        self.download = to_raw_response_wrapper(resource.download)
        self.refresh = to_raw_response_wrapper(resource.refresh)
        self.download_xml = to_raw_response_wrapper(resource.download_xml)

# this file is @generated
import typing as t

from ..models import (
    EInvoicingStatus,
    Invoice,
    InvoiceCustomPropertiesRequest,
    InvoiceListResponse,
    InvoiceStatus,
    SubscriptionId,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class InvoicesAsync(ApiBaseAsync):
    """invoices API."""

    async def list_invoices(
        self,
        *,
        customer_id: t.Optional[str] = None,
        subscription_id: t.Optional[SubscriptionId] = None,
        statuses: t.Optional[t.List[InvoiceStatus]] = None,
        einvoicing_status: t.Optional[EInvoicingStatus] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> InvoiceListResponse:
        """List invoices with optional filtering by customer, subscription, or status.

        :param customer_id: Filter by customer ID or alias
        :param einvoicing_status: Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not opted in carry no status and match neither.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
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
        )
        return InvoiceListResponse.from_dict(response.json())

    async def get_invoice_by_id(
        self,
        invoice_id: str,
    ) -> Invoice:
        """Retrieve a single invoice with its payment transactions."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/invoices/{invoice_id}",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return Invoice.from_dict(response.json())

    async def patch_invoice_custom_properties(
        self,
        invoice_id: str,
        invoice_custom_properties_request: InvoiceCustomPropertiesRequest,
    ) -> Invoice:
        """Merge custom property values onto an invoice (send a key with `null` to remove it).
        Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the invoice
        is finalized."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/invoices/{invoice_id}/custom-properties",
            path_params={
                "invoice_id": invoice_id,
            },
            json_body=invoice_custom_properties_request.to_dict(),
        )
        return Invoice.from_dict(response.json())

    async def download_invoice_pdf(
        self,
        invoice_id: str,
    ) -> bytes:
        """Download the PDF document for an invoice."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/invoices/{invoice_id}/download",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return response.content

    async def refresh_invoice(
        self,
        invoice_id: str,
    ) -> Invoice:
        """Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
        Drafts are also refreshed periodically in the background; use this to force it, e.g. after
        ingesting late events. Rejected while a payment for the invoice is in progress or when the
        invoice was merged into a consolidated parent."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/invoices/{invoice_id}/refresh",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return Invoice.from_dict(response.json())

    async def download_invoice_xml(
        self,
        invoice_id: str,
    ) -> bytes:
        """Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
        Factur-X the same XML is also embedded in the PDF."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/invoices/{invoice_id}/xml",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return response.content


class Invoices(ApiBaseSync):
    """invoices API."""

    def list_invoices(
        self,
        *,
        customer_id: t.Optional[str] = None,
        subscription_id: t.Optional[SubscriptionId] = None,
        statuses: t.Optional[t.List[InvoiceStatus]] = None,
        einvoicing_status: t.Optional[EInvoicingStatus] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> InvoiceListResponse:
        """List invoices with optional filtering by customer, subscription, or status.

        :param customer_id: Filter by customer ID or alias
        :param einvoicing_status: Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not opted in carry no status and match neither.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
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
        )
        return InvoiceListResponse.from_dict(response.json())

    def get_invoice_by_id(
        self,
        invoice_id: str,
    ) -> Invoice:
        """Retrieve a single invoice with its payment transactions."""
        response = self._request_sync(
            method="get",
            path="/api/v1/invoices/{invoice_id}",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return Invoice.from_dict(response.json())

    def patch_invoice_custom_properties(
        self,
        invoice_id: str,
        invoice_custom_properties_request: InvoiceCustomPropertiesRequest,
    ) -> Invoice:
        """Merge custom property values onto an invoice (send a key with `null` to remove it).
        Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the invoice
        is finalized."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/invoices/{invoice_id}/custom-properties",
            path_params={
                "invoice_id": invoice_id,
            },
            json_body=invoice_custom_properties_request.to_dict(),
        )
        return Invoice.from_dict(response.json())

    def download_invoice_pdf(
        self,
        invoice_id: str,
    ) -> bytes:
        """Download the PDF document for an invoice."""
        response = self._request_sync(
            method="get",
            path="/api/v1/invoices/{invoice_id}/download",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return response.content

    def refresh_invoice(
        self,
        invoice_id: str,
    ) -> Invoice:
        """Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
        Drafts are also refreshed periodically in the background; use this to force it, e.g. after
        ingesting late events. Rejected while a payment for the invoice is in progress or when the
        invoice was merged into a consolidated parent."""
        response = self._request_sync(
            method="post",
            path="/api/v1/invoices/{invoice_id}/refresh",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return Invoice.from_dict(response.json())

    def download_invoice_xml(
        self,
        invoice_id: str,
    ) -> bytes:
        """Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
        Factur-X the same XML is also embedded in the PDF."""
        response = self._request_sync(
            method="get",
            path="/api/v1/invoices/{invoice_id}/xml",
            path_params={
                "invoice_id": invoice_id,
            },
        )
        return response.content

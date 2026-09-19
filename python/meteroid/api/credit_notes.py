# this file is @generated
import typing as t

from ..models import (
    CreditNote,
    CreditNoteCustomPropertiesRequest,
    CreditNoteListResponse,
    CreditNoteStatus,
    CustomerId,
    InvoiceId,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class CreditNotesAsync(ApiBaseAsync):
    """credit notes API."""

    async def list_credit_notes(
        self,
        *,
        customer_id: t.Optional[CustomerId] = None,
        invoice_id: t.Optional[InvoiceId] = None,
        status: t.Optional[CreditNoteStatus] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CreditNoteListResponse:
        """List a tenant's credit notes, optionally filtered by customer, invoice or status.

        :param customer_id: Filter by customer ID
        :param invoice_id: Filter by invoice ID
        :param search: Free-text search over credit note number.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/credit-notes",
            query_params=serialize_query_params(
                {
                    "customer_id": customer_id,
                    "invoice_id": invoice_id,
                    "status": status,
                    "search": search,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return CreditNoteListResponse.from_dict(response.json())

    async def get_credit_note_by_id(
        self,
        credit_note_id: str,
    ) -> CreditNote:
        """Retrieve a single credit note by ID."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/credit-notes/{credit_note_id}",
            path_params={
                "credit_note_id": credit_note_id,
            },
        )
        return CreditNote.from_dict(response.json())

    async def patch_credit_note_custom_properties(
        self,
        credit_note_id: str,
        credit_note_custom_properties_request: CreditNoteCustomPropertiesRequest,
    ) -> CreditNote:
        """Merge custom property values onto a credit note (send a key with `null` to remove it).
        Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the credit
        note is finalized."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/credit-notes/{credit_note_id}/custom-properties",
            path_params={
                "credit_note_id": credit_note_id,
            },
            json_body=credit_note_custom_properties_request.to_dict(),
        )
        return CreditNote.from_dict(response.json())

    async def download_credit_note_pdf(
        self,
        credit_note_id: str,
    ) -> bytes:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/credit-notes/{credit_note_id}/download",
            path_params={
                "credit_note_id": credit_note_id,
            },
        )
        return response.content


class CreditNotes(ApiBaseSync):
    """credit notes API."""

    def list_credit_notes(
        self,
        *,
        customer_id: t.Optional[CustomerId] = None,
        invoice_id: t.Optional[InvoiceId] = None,
        status: t.Optional[CreditNoteStatus] = None,
        search: t.Optional[str] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CreditNoteListResponse:
        """List a tenant's credit notes, optionally filtered by customer, invoice or status.

        :param customer_id: Filter by customer ID
        :param invoice_id: Filter by invoice ID
        :param search: Free-text search over credit note number.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/credit-notes",
            query_params=serialize_query_params(
                {
                    "customer_id": customer_id,
                    "invoice_id": invoice_id,
                    "status": status,
                    "search": search,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return CreditNoteListResponse.from_dict(response.json())

    def get_credit_note_by_id(
        self,
        credit_note_id: str,
    ) -> CreditNote:
        """Retrieve a single credit note by ID."""
        response = self._request_sync(
            method="get",
            path="/api/v1/credit-notes/{credit_note_id}",
            path_params={
                "credit_note_id": credit_note_id,
            },
        )
        return CreditNote.from_dict(response.json())

    def patch_credit_note_custom_properties(
        self,
        credit_note_id: str,
        credit_note_custom_properties_request: CreditNoteCustomPropertiesRequest,
    ) -> CreditNote:
        """Merge custom property values onto a credit note (send a key with `null` to remove it).
        Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the credit
        note is finalized."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/credit-notes/{credit_note_id}/custom-properties",
            path_params={
                "credit_note_id": credit_note_id,
            },
            json_body=credit_note_custom_properties_request.to_dict(),
        )
        return CreditNote.from_dict(response.json())

    def download_credit_note_pdf(
        self,
        credit_note_id: str,
    ) -> bytes:
        response = self._request_sync(
            method="get",
            path="/api/v1/credit-notes/{credit_note_id}/download",
            path_params={
                "credit_note_id": credit_note_id,
            },
        )
        return response.content

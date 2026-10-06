# this file is @generated
"""Credit notes API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    CreditNote,
    CreditNoteCustomPropertiesRequest,
    CreditNoteListResponse,
    CreditNoteStatus,
    CustomerId,
    InvoiceId,
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


class AsyncCreditNotes(ApiBaseAsync):
    """Credit notes API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncCreditNotesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncCreditNotesWithRawResponse(self)

    async def list(
        self,
        *,
        customer_id: CustomerId | None = None,
        invoice_id: InvoiceId | None = None,
        status: CreditNoteStatus | None = None,
        search: str | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNoteListResponse:
        """List credit notes

        List a tenant's credit notes, optionally filtered by customer, invoice or status.

        :param customer_id: Filter by customer ID
        :param invoice_id: Filter by invoice ID
        :param search: Free-text search over credit note number.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
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
        return decode_response(response, CreditNoteListResponse)

    async def retrieve(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNote:
        """Get credit note

        Retrieve a single credit note by ID."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}",
                path_params={
                    "credit_note_id": credit_note_id,
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
        return decode_response(response, CreditNote)

    async def update_custom_properties(
        self,
        credit_note_id: str,
        *,
        custom_properties: t.Any,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNote:
        """Update credit note custom properties

        Merge custom property values onto a credit note (send a key with `null` to remove it).
        Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the credit
        note is finalized."""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/credit-notes/{credit_note_id}/custom-properties",
                path_params={
                    "credit_note_id": credit_note_id,
                },
                json_body=to_json_value(
                    CreditNoteCustomPropertiesRequest(
                        custom_properties=custom_properties,
                    ),
                    CreditNoteCustomPropertiesRequest,
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
        return decode_response(response, CreditNote)

    async def download(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """`GET /api/v1/credit-notes/{credit_note_id}/download`."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}/download",
                path_params={
                    "credit_note_id": credit_note_id,
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

    async def download_xml(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download credit note e-invoice XML

        Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
        Factur-X the same XML is also embedded in the PDF."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}/xml",
                path_params={
                    "credit_note_id": credit_note_id,
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


class AsyncCreditNotesWithRawResponse:
    """The methods of :class:`AsyncCreditNotes`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncCreditNotes) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update_custom_properties = async_to_raw_response_wrapper(
            resource.update_custom_properties
        )
        self.download = async_to_raw_response_wrapper(resource.download)
        self.download_xml = async_to_raw_response_wrapper(resource.download_xml)


class CreditNotes(ApiBaseSync):
    """Credit notes API."""

    @property
    def with_raw_response(self) -> CreditNotesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return CreditNotesWithRawResponse(self)

    def list(
        self,
        *,
        customer_id: CustomerId | None = None,
        invoice_id: InvoiceId | None = None,
        status: CreditNoteStatus | None = None,
        search: str | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNoteListResponse:
        """List credit notes

        List a tenant's credit notes, optionally filtered by customer, invoice or status.

        :param customer_id: Filter by customer ID
        :param invoice_id: Filter by invoice ID
        :param search: Free-text search over credit note number.
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
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
        return decode_response(response, CreditNoteListResponse)

    def retrieve(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNote:
        """Get credit note

        Retrieve a single credit note by ID."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}",
                path_params={
                    "credit_note_id": credit_note_id,
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
        return decode_response(response, CreditNote)

    def update_custom_properties(
        self,
        credit_note_id: str,
        *,
        custom_properties: t.Any,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreditNote:
        """Update credit note custom properties

        Merge custom property values onto a credit note (send a key with `null` to remove it).
        Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
        status — custom properties are external workflow metadata and stay editable after the credit
        note is finalized."""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/credit-notes/{credit_note_id}/custom-properties",
                path_params={
                    "credit_note_id": credit_note_id,
                },
                json_body=to_json_value(
                    CreditNoteCustomPropertiesRequest(
                        custom_properties=custom_properties,
                    ),
                    CreditNoteCustomPropertiesRequest,
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
        return decode_response(response, CreditNote)

    def download(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """`GET /api/v1/credit-notes/{credit_note_id}/download`."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}/download",
                path_params={
                    "credit_note_id": credit_note_id,
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

    def download_xml(
        self,
        credit_note_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> bytes:
        """Download credit note e-invoice XML

        Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
        Factur-X the same XML is also embedded in the PDF."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/credit-notes/{credit_note_id}/xml",
                path_params={
                    "credit_note_id": credit_note_id,
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


class CreditNotesWithRawResponse:
    """The methods of :class:`CreditNotes`, returning an :class:`APIResponse`."""

    def __init__(self, resource: CreditNotes) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update_custom_properties = to_raw_response_wrapper(
            resource.update_custom_properties
        )
        self.download = to_raw_response_wrapper(resource.download)
        self.download_xml = to_raw_response_wrapper(resource.download_xml)

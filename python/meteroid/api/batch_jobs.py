# this file is @generated
"""Batch jobs API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    BatchJobChunkId,
    BatchJobDetailResponse,
    BatchJobFailuresResponse,
    BatchJobListResponse,
    BatchJobStatus,
    BatchJobType,
)
from ..serialization import UNSET, Unset
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
    serialize_query_params,
)


class AsyncBatchJobs(ApiBaseAsync):
    """Batch jobs API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncBatchJobsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncBatchJobsWithRawResponse(self)

    async def list(
        self,
        *,
        job_type: BatchJobType | None = None,
        status: builtins.list[BatchJobStatus] | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobListResponse:
        """List batch jobs with optional filtering by type and status.

        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs",
                query_params=serialize_query_params(
                    {
                        "job_type": job_type,
                        "status": status,
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
        return decode_response(response, BatchJobListResponse)

    async def retrieve(
        self,
        batch_job_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobDetailResponse:
        """Get batch job detail

        Retrieve a single batch job with its chunks and failures."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs/{batch_job_id}",
                path_params={
                    "batch_job_id": batch_job_id,
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
        return decode_response(response, BatchJobDetailResponse)

    async def list_failures(
        self,
        batch_job_id: str,
        *,
        chunk_id: BatchJobChunkId | None = None,
        limit: int | None = None,
        offset: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobFailuresResponse:
        """List batch job failures

        Retrieve paginated failures for a batch job."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs/{batch_job_id}/failures",
                path_params={
                    "batch_job_id": batch_job_id,
                },
                query_params=serialize_query_params(
                    {
                        "chunk_id": chunk_id,
                        "limit": limit,
                        "offset": offset,
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
        return decode_response(response, BatchJobFailuresResponse)


class AsyncBatchJobsWithRawResponse:
    """The methods of :class:`AsyncBatchJobs`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncBatchJobs) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.list_failures = async_to_raw_response_wrapper(resource.list_failures)


class BatchJobs(ApiBaseSync):
    """Batch jobs API."""

    @property
    def with_raw_response(self) -> BatchJobsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return BatchJobsWithRawResponse(self)

    def list(
        self,
        *,
        job_type: BatchJobType | None = None,
        status: builtins.list[BatchJobStatus] | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobListResponse:
        """List batch jobs with optional filtering by type and status.

        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs",
                query_params=serialize_query_params(
                    {
                        "job_type": job_type,
                        "status": status,
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
        return decode_response(response, BatchJobListResponse)

    def retrieve(
        self,
        batch_job_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobDetailResponse:
        """Get batch job detail

        Retrieve a single batch job with its chunks and failures."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs/{batch_job_id}",
                path_params={
                    "batch_job_id": batch_job_id,
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
        return decode_response(response, BatchJobDetailResponse)

    def list_failures(
        self,
        batch_job_id: str,
        *,
        chunk_id: BatchJobChunkId | None = None,
        limit: int | None = None,
        offset: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> BatchJobFailuresResponse:
        """List batch job failures

        Retrieve paginated failures for a batch job."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/batch-jobs/{batch_job_id}/failures",
                path_params={
                    "batch_job_id": batch_job_id,
                },
                query_params=serialize_query_params(
                    {
                        "chunk_id": chunk_id,
                        "limit": limit,
                        "offset": offset,
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
        return decode_response(response, BatchJobFailuresResponse)


class BatchJobsWithRawResponse:
    """The methods of :class:`BatchJobs`, returning an :class:`APIResponse`."""

    def __init__(self, resource: BatchJobs) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.list_failures = to_raw_response_wrapper(resource.list_failures)

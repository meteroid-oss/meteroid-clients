# this file is @generated
import typing as t

from ..models import (
    BatchJobChunkId,
    BatchJobDetailResponse,
    BatchJobFailuresResponse,
    BatchJobListResponse,
    BatchJobStatus,
    BatchJobType,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class BatchJobsAsync(ApiBaseAsync):
    """batch jobs API."""

    async def list_batch_jobs(
        self,
        *,
        job_type: t.Optional[BatchJobType] = None,
        status: t.Optional[t.List[BatchJobStatus]] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> BatchJobListResponse:
        """List batch jobs with optional filtering by type and status.

        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
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
        )
        return decode_response(response, BatchJobListResponse)

    async def get_batch_job(
        self,
        batch_job_id: str,
    ) -> BatchJobDetailResponse:
        """Retrieve a single batch job with its chunks and failures."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/batch-jobs/{batch_job_id}",
            path_params={
                "batch_job_id": batch_job_id,
            },
        )
        return decode_response(response, BatchJobDetailResponse)

    async def list_batch_job_failures(
        self,
        batch_job_id: str,
        *,
        chunk_id: t.Optional[BatchJobChunkId] = None,
        limit: t.Optional[int] = None,
        offset: t.Optional[int] = None,
    ) -> BatchJobFailuresResponse:
        """Retrieve paginated failures for a batch job."""
        response = await self._request_asyncio(
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
        )
        return decode_response(response, BatchJobFailuresResponse)


class BatchJobs(ApiBaseSync):
    """batch jobs API."""

    def list_batch_jobs(
        self,
        *,
        job_type: t.Optional[BatchJobType] = None,
        status: t.Optional[t.List[BatchJobStatus]] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> BatchJobListResponse:
        """List batch jobs with optional filtering by type and status.

        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
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
        )
        return decode_response(response, BatchJobListResponse)

    def get_batch_job(
        self,
        batch_job_id: str,
    ) -> BatchJobDetailResponse:
        """Retrieve a single batch job with its chunks and failures."""
        response = self._request_sync(
            method="get",
            path="/api/v1/batch-jobs/{batch_job_id}",
            path_params={
                "batch_job_id": batch_job_id,
            },
        )
        return decode_response(response, BatchJobDetailResponse)

    def list_batch_job_failures(
        self,
        batch_job_id: str,
        *,
        chunk_id: t.Optional[BatchJobChunkId] = None,
        limit: t.Optional[int] = None,
        offset: t.Optional[int] = None,
    ) -> BatchJobFailuresResponse:
        """Retrieve paginated failures for a batch job."""
        response = self._request_sync(
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
        )
        return decode_response(response, BatchJobFailuresResponse)

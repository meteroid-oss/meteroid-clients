// this file is @generated

import type { BatchJobChunkId } from "../models/batchJobChunkId.js";
import {
  type BatchJobDetailResponse,
  BatchJobDetailResponseSerializer,
} from "../models/batchJobDetailResponse.js";
import {
  type BatchJobFailuresResponse,
  BatchJobFailuresResponseSerializer,
} from "../models/batchJobFailuresResponse.js";
import {
  type BatchJobListResponse,
  BatchJobListResponseSerializer,
} from "../models/batchJobListResponse.js";
import type { BatchJobStatus } from "../models/batchJobStatus.js";
import type { BatchJobType } from "../models/batchJobType.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface BatchJobsListOptions {
  jobType?: BatchJobType | undefined;
  status?: BatchJobStatus[] | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The query and header parameters of `listFailures`. */
export interface BatchJobsListFailuresOptions {
  chunkId?: BatchJobChunkId | undefined;
  limit?: number | undefined;
  offset?: number | undefined;
}

/** The batch jobs operations, reached through the client's `batchJobs`. */
export class BatchJobs {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List batch jobs with optional filtering by type and status. */
  public list(
    options?: BatchJobsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<BatchJobListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/batch-jobs");

    request.setQueryParam("job_type", options?.jobType);
    request.setExplodedQueryParam("status", options?.status);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      BatchJobListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get batch job detail
   *
   * Retrieve a single batch job with its chunks and failures.
   */
  public retrieve(
    batchJobId: string,
    requestOptions?: RequestOptions
  ): APIPromise<BatchJobDetailResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/batch-jobs/{batch_job_id}");

    request.setPathParam("batch_job_id", batchJobId);
    return request.send(
      this.requestCtx,
      BatchJobDetailResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * List batch job failures
   *
   * Retrieve paginated failures for a batch job.
   */
  public listFailures(
    batchJobId: string,
    options?: BatchJobsListFailuresOptions,
    requestOptions?: RequestOptions
  ): APIPromise<BatchJobFailuresResponse> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/batch-jobs/{batch_job_id}/failures"
    );

    request.setPathParam("batch_job_id", batchJobId);
    request.setQueryParam("chunk_id", options?.chunkId);
    request.setQueryParam("limit", options?.limit);
    request.setQueryParam("offset", options?.offset);
    return request.send(
      this.requestCtx,
      BatchJobFailuresResponseSerializer.parse,
      requestOptions
    );
  }
}

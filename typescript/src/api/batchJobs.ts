// this file is @generated
import type { BatchJobChunkId } from "../models/batchJobChunkId";
import {
  type BatchJobDetailResponse,
  BatchJobDetailResponseSerializer,
} from "../models/batchJobDetailResponse";
import {
  type BatchJobFailuresResponse,
  BatchJobFailuresResponseSerializer,
} from "../models/batchJobFailuresResponse";
import {
  type BatchJobListResponse,
  BatchJobListResponseSerializer,
} from "../models/batchJobListResponse";
import type { BatchJobStatus } from "../models/batchJobStatus";
import type { BatchJobType } from "../models/batchJobType";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface BatchJobsListBatchJobsOptions {
  jobType?: BatchJobType;
  status?: BatchJobStatus[];
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export interface BatchJobsListBatchJobFailuresOptions {
  chunkId?: BatchJobChunkId;
  limit?: number;
  offset?: number;
}

export class BatchJobs {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List batch jobs with optional filtering by type and status. */
  public listBatchJobs(
    options?: BatchJobsListBatchJobsOptions
  ): Promise<BatchJobListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/batch-jobs");

    request.setQueryParam("job_type", options?.jobType);
    request.setExplodedQueryParam("status", options?.status);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, BatchJobListResponseSerializer._fromJsonObject);
  }

  /** Retrieve a single batch job with its chunks and failures. */
  public getBatchJob(batchJobId: string): Promise<BatchJobDetailResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/batch-jobs/{batch_job_id}"
    );

    request.setPathParam("batch_job_id", batchJobId);
    return request.send(
      this.requestCtx,
      BatchJobDetailResponseSerializer._fromJsonObject
    );
  }

  /** Retrieve paginated failures for a batch job. */
  public listBatchJobFailures(
    batchJobId: string,
    options?: BatchJobsListBatchJobFailuresOptions
  ): Promise<BatchJobFailuresResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/batch-jobs/{batch_job_id}/failures"
    );

    request.setPathParam("batch_job_id", batchJobId);
    request.setQueryParam("chunk_id", options?.chunkId);
    request.setQueryParam("limit", options?.limit);
    request.setQueryParam("offset", options?.offset);
    return request.send(
      this.requestCtx,
      BatchJobFailuresResponseSerializer._fromJsonObject
    );
  }
}

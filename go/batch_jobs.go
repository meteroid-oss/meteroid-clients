// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// BatchJobsListBatchJobsOptions carries the query and header parameters of
// BatchJobs.ListBatchJobs.
//
// Optional parameters are pointers; leave them nil to omit them.
type BatchJobsListBatchJobsOptions struct {
	JobType *BatchJobType

	Status []BatchJobStatus

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// BatchJobsListBatchJobFailuresOptions carries the query and header parameters of
// BatchJobs.ListBatchJobFailures.
//
// Optional parameters are pointers; leave them nil to omit them.
type BatchJobsListBatchJobFailuresOptions struct {
	ChunkId *BatchJobChunkId

	Limit *int32

	Offset *int32
}

// BatchJobs groups the batch jobs operations of the Meteroid API.
type BatchJobs struct {
	client *Client
}

// List batch jobs with optional filtering by type and status.
func (a *BatchJobs) ListBatchJobs(ctx context.Context, options *BatchJobsListBatchJobsOptions) (*BatchJobListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/batch-jobs")

	if options != nil {
		if options.JobType != nil {
			req.SetQueryParam("job_type", string(*options.JobType))
		}

		if len(options.Status) > 0 {
			for _, item := range options.Status {
				req.AddQueryParam("status", string(item))
			}
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out BatchJobListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a single batch job with its chunks and failures.
func (a *BatchJobs) GetBatchJob(ctx context.Context, batchJobId string) (*BatchJobDetailResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/batch-jobs/{batch_job_id}")
	req.SetPathParam("batch_job_id", batchJobId)

	var out BatchJobDetailResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve paginated failures for a batch job.
func (a *BatchJobs) ListBatchJobFailures(ctx context.Context, batchJobId string, options *BatchJobsListBatchJobFailuresOptions) (*BatchJobFailuresResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/batch-jobs/{batch_job_id}/failures")
	req.SetPathParam("batch_job_id", batchJobId)

	if options != nil {
		if options.ChunkId != nil {
			req.SetQueryParam("chunk_id", string(*options.ChunkId))
		}
		if options.Limit != nil {
			req.SetQueryParam("limit", formatInt(int64(*options.Limit)))
		}
		if options.Offset != nil {
			req.SetQueryParam("offset", formatInt(int64(*options.Offset)))
		}
	}

	var out BatchJobFailuresResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

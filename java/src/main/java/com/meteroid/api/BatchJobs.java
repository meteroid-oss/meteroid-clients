// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.BatchJobDetailResponse;
import com.meteroid.models.BatchJobFailuresResponse;
import com.meteroid.models.BatchJobListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class BatchJobs {
    private final MeteroidHttpClient client;

    public BatchJobs(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List batch jobs with optional filtering by type and status. */
    public BatchJobListResponse listBatchJobs() throws IOException, ApiException {

        return this.listBatchJobs(new BatchJobsListBatchJobsOptions());
    }

    /** List batch jobs with optional filtering by type and status. */
    public BatchJobListResponse listBatchJobs(final BatchJobsListBatchJobsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/batch-jobs");
        if (options.jobType != null) {
            url.addQueryParameter("job_type", Utils.serializeQueryParam(options.jobType));
        }
        if (options.status != null) {
            url.addQueryParameter("status", Utils.serializeQueryParam(options.status));
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, BatchJobListResponse.class);
    }

    /** Retrieve a single batch job with its chunks and failures. */
    public BatchJobDetailResponse getBatchJob(final String batchJobId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/batch-jobs/%s", batchJobId));
        return this.client.executeRequest(
                "GET", url.build(), null, null, BatchJobDetailResponse.class);
    }

    /** Retrieve paginated failures for a batch job. */
    public BatchJobFailuresResponse listBatchJobFailures(final String batchJobId)
            throws IOException, ApiException {
        return this.listBatchJobFailures(batchJobId, new BatchJobsListBatchJobFailuresOptions());
    }

    /** Retrieve paginated failures for a batch job. */
    public BatchJobFailuresResponse listBatchJobFailures(
            final String batchJobId, final BatchJobsListBatchJobFailuresOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/batch-jobs/%s/failures", batchJobId));
        if (options.chunkId != null) {
            url.addQueryParameter("chunk_id", Utils.serializeQueryParam(options.chunkId));
        }
        if (options.limit != null) {
            url.addQueryParameter("limit", Utils.serializeQueryParam(options.limit));
        }
        if (options.offset != null) {
            url.addQueryParameter("offset", Utils.serializeQueryParam(options.offset));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, BatchJobFailuresResponse.class);
    }
}

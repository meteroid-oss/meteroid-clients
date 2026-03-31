// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.BatchJobDetailResponse;
import com.meteroid.models.BatchJobFailuresResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class BatchJobs {
    private final MeteroidHttpClient client;

    public BatchJobs(MeteroidHttpClient client) {
        this.client = client;
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

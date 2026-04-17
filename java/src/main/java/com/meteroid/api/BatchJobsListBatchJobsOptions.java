// this file is @generated
package com.meteroid.api;

import com.meteroid.models.BatchJobStatus;
import com.meteroid.models.BatchJobType;

import lombok.Data;

import java.util.List;

@Data
public class BatchJobsListBatchJobsOptions {
    BatchJobType jobType;
    List<BatchJobStatus> status;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

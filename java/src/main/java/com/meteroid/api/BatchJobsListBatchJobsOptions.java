// this file is @generated
package com.meteroid.api;

import lombok.Data;

import java.util.List;

@Data
public class BatchJobsListBatchJobsOptions {
    String jobType;
    List<String> status;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

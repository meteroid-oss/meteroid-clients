// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class MetricsListMetricsOptions {
    String productFamilyId;

    /** Search by metric name or code */
    String search;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `name`, `code`, `created_at`.
     * Direction: `asc` or `desc`. Default: `name.asc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

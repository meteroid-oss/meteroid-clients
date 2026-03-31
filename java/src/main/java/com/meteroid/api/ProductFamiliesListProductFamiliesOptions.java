// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class ProductFamiliesListProductFamiliesOptions {
    /**
     * Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction:
     * `asc` or `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;

    String search;
}

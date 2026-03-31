// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class CouponsListCouponsOptions {
    String search;
    String filter;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `code`, `created_at`, `expires_at`.
     * Direction: `asc` or `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

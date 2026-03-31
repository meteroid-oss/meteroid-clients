// this file is @generated
package com.meteroid.api;

import lombok.Data;

@Data
public class AddOnsListAddonsOptions {
    String search;
    String currency;

    /** Include archived add-ons in the results (default: false) */
    Boolean includeArchived;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `name`, `created_at`. Direction:
     * `asc` or `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

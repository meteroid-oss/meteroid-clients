// this file is @generated
package com.meteroid.api;

import com.meteroid.models.PlanStatusEnum;
import com.meteroid.models.PlanTypeEnum;

import lombok.Data;

import java.util.List;

@Data
public class PlansListPlansOptions {
    String productFamilyId;

    /** Search by plan name */
    String search;

    /** Filter by plan status (can be repeated) */
    List<PlanStatusEnum> status;

    /** Filter by plan type (can be repeated) */
    List<PlanTypeEnum> planType;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `name`, `status`, `plan_type`,
     * `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

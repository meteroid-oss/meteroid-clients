// this file is @generated
package com.meteroid.api;

import com.meteroid.models.SubscriptionStatusEnum;

import lombok.Data;

import java.util.List;

@Data
public class SubscriptionsListSubscriptionsOptions {
    /** Filter by customer ID or alias */
    String customerId;

    String planId;
    List<SubscriptionStatusEnum> statuses;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`,
     * `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or
     * `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

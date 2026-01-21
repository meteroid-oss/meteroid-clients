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

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

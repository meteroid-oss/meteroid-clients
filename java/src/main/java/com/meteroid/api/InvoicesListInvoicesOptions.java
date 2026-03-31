// this file is @generated
package com.meteroid.api;

import lombok.Data;

import java.util.List;

@Data
public class InvoicesListInvoicesOptions {
    /** Filter by customer ID or alias */
    String customerId;

    String subscriptionId;
    List<String> statuses;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`,
     * `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default:
     * `invoice_date.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

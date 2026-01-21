// this file is @generated
package com.meteroid.api;

import com.meteroid.models.InvoiceStatus;

import lombok.Data;

import java.util.List;

@Data
public class InvoicesListInvoicesOptions {
    /** Filter by customer ID or alias */
    String customerId;

    String subscriptionId;
    List<InvoiceStatus> statuses;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

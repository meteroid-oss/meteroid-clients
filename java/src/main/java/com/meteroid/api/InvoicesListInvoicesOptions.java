// this file is @generated
package com.meteroid.api;

import com.meteroid.models.EInvoicingStatus;
import com.meteroid.models.InvoiceStatus;

import lombok.Data;

import java.util.List;

@Data
public class InvoicesListInvoicesOptions {
    /** Filter by customer ID or alias */
    String customerId;

    String subscriptionId;
    List<InvoiceStatus> statuses;

    /**
     * Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not
     * opted in carry no status and match neither.
     */
    EInvoicingStatus einvoicingStatus;

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

// this file is @generated
package com.meteroid.api;

import com.meteroid.models.CreditNoteStatus;

import lombok.Data;

@Data
public class CreditNotesListCreditNotesOptions {
    /** Filter by customer ID */
    String customerId;

    /** Filter by invoice ID */
    String invoiceId;

    CreditNoteStatus status;

    /** Free-text search over credit note number. */
    String search;

    /**
     * Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`,
     * `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
     */
    String orderBy;

    /** Page number (0-indexed) */
    Integer page;

    /** Number of items per page */
    Integer perPage;
}

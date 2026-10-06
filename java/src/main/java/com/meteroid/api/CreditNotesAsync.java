// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.models.CreditNote;
import com.meteroid.models.CreditNoteCustomPropertiesRequest;
import com.meteroid.models.CreditNoteListResponse;

import java.util.concurrent.CompletableFuture;

/**
 * The {@code credit_notes} operations, without blocking: each method returns a {@link
 * CompletableFuture}. Obtained from {@code client.async()}.
 */
public final class CreditNotesAsync {
    private final CreditNotes sync;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code sync}.
     *
     * @param sync the blocking operations
     */
    public CreditNotesAsync(CreditNotes sync) {
        this.sync = sync;
        this.withRawResponse = new WithRawResponse();
    }

    /**
     * The same operations, returning the status and headers along with the body.
     *
     * @return the operations
     */
    public WithRawResponse withRawResponse() {
        return withRawResponse;
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @return the response body, once received
     */
    public CompletableFuture<CreditNoteListResponse> list() {
        return list(CreditNotesListOptions.none(), RequestOptions.none());
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param options the optional parameters
     * @return the response body, once received
     */
    public CompletableFuture<CreditNoteListResponse> list(final CreditNotesListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CreditNoteListResponse> list(final RequestOptions requestOptions) {
        return list(CreditNotesListOptions.none(), requestOptions);
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CreditNoteListResponse> list(
            final CreditNotesListOptions options, final RequestOptions requestOptions) {
        return sync.exchangeList(options, requestOptions).sendAsync();
    }

    /**
     * Get credit note
     *
     * <p>Retrieve a single credit note by ID.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<CreditNote> retrieve(final String creditNoteId) {
        return retrieve(creditNoteId, RequestOptions.none());
    }

    /**
     * Get credit note
     *
     * <p>Retrieve a single credit note by ID.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CreditNote> retrieve(
            final String creditNoteId, final RequestOptions requestOptions) {
        return sync.exchangeRetrieve(creditNoteId, requestOptions).sendAsync();
    }

    /**
     * Update credit note custom properties
     *
     * <p>Merge custom property values onto a credit note (send a key with <code>null</code> to
     * remove it). Values are validated against the tenant's <code>CREDIT_NOTE</code> property
     * definitions. Allowed at any status — custom properties are external workflow metadata and
     * stay editable after the credit note is finalized.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param creditNoteCustomPropertiesRequest the request body
     * @return the response body, once received
     */
    public CompletableFuture<CreditNote> updateCustomProperties(
            final String creditNoteId,
            final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest) {
        return updateCustomProperties(
                creditNoteId, creditNoteCustomPropertiesRequest, RequestOptions.none());
    }

    /**
     * Update credit note custom properties
     *
     * <p>Merge custom property values onto a credit note (send a key with <code>null</code> to
     * remove it). Values are validated against the tenant's <code>CREDIT_NOTE</code> property
     * definitions. Allowed at any status — custom properties are external workflow metadata and
     * stay editable after the credit note is finalized.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param creditNoteCustomPropertiesRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<CreditNote> updateCustomProperties(
            final String creditNoteId,
            final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest,
            final RequestOptions requestOptions) {
        return sync.exchangeUpdateCustomProperties(
                        creditNoteId, creditNoteCustomPropertiesRequest, requestOptions)
                .sendAsync();
    }

    /**
     * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<byte[]> download(final String creditNoteId) {
        return download(creditNoteId, RequestOptions.none());
    }

    /**
     * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<byte[]> download(
            final String creditNoteId, final RequestOptions requestOptions) {
        return sync.exchangeDownload(creditNoteId, requestOptions).sendAsync();
    }

    /**
     * Download credit note e-invoice XML
     *
     * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For Factur-X
     * the same XML is also embedded in the PDF.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body, once received
     */
    public CompletableFuture<byte[]> downloadXml(final String creditNoteId) {
        return downloadXml(creditNoteId, RequestOptions.none());
    }

    /**
     * Download credit note e-invoice XML
     *
     * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For Factur-X
     * the same XML is also embedded in the PDF.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body, once received
     */
    public CompletableFuture<byte[]> downloadXml(
            final String creditNoteId, final RequestOptions requestOptions) {
        return sync.exchangeDownloadXml(creditNoteId, requestOptions).sendAsync();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNoteListResponse>> list() {
            return list(CreditNotesListOptions.none(), RequestOptions.none());
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param options the optional parameters
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNoteListResponse>> list(
                final CreditNotesListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNoteListResponse>> list(
                final RequestOptions requestOptions) {
            return list(CreditNotesListOptions.none(), requestOptions);
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNoteListResponse>> list(
                final CreditNotesListOptions options, final RequestOptions requestOptions) {
            return sync.exchangeList(options, requestOptions).sendRawAsync();
        }

        /**
         * Get credit note
         *
         * <p>Retrieve a single credit note by ID.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNote>> retrieve(final String creditNoteId) {
            return retrieve(creditNoteId, RequestOptions.none());
        }

        /**
         * Get credit note
         *
         * <p>Retrieve a single credit note by ID.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNote>> retrieve(
                final String creditNoteId, final RequestOptions requestOptions) {
            return sync.exchangeRetrieve(creditNoteId, requestOptions).sendRawAsync();
        }

        /**
         * Update credit note custom properties
         *
         * <p>Merge custom property values onto a credit note (send a key with <code>null</code> to
         * remove it). Values are validated against the tenant's <code>CREDIT_NOTE</code> property
         * definitions. Allowed at any status — custom properties are external workflow metadata and
         * stay editable after the credit note is finalized.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param creditNoteCustomPropertiesRequest the request body
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNote>> updateCustomProperties(
                final String creditNoteId,
                final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest) {
            return updateCustomProperties(
                    creditNoteId, creditNoteCustomPropertiesRequest, RequestOptions.none());
        }

        /**
         * Update credit note custom properties
         *
         * <p>Merge custom property values onto a credit note (send a key with <code>null</code> to
         * remove it). Values are validated against the tenant's <code>CREDIT_NOTE</code> property
         * definitions. Allowed at any status — custom properties are external workflow metadata and
         * stay editable after the credit note is finalized.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param creditNoteCustomPropertiesRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<CreditNote>> updateCustomProperties(
                final String creditNoteId,
                final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest,
                final RequestOptions requestOptions) {
            return sync.exchangeUpdateCustomProperties(
                            creditNoteId, creditNoteCustomPropertiesRequest, requestOptions)
                    .sendRawAsync();
        }

        /**
         * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<byte[]>> download(final String creditNoteId) {
            return download(creditNoteId, RequestOptions.none());
        }

        /**
         * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<byte[]>> download(
                final String creditNoteId, final RequestOptions requestOptions) {
            return sync.exchangeDownload(creditNoteId, requestOptions).sendRawAsync();
        }

        /**
         * Download credit note e-invoice XML
         *
         * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
         * Factur-X the same XML is also embedded in the PDF.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<byte[]>> downloadXml(final String creditNoteId) {
            return downloadXml(creditNoteId, RequestOptions.none());
        }

        /**
         * Download credit note e-invoice XML
         *
         * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
         * Factur-X the same XML is also embedded in the PDF.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body, once received
         */
        public CompletableFuture<ApiResponse<byte[]>> downloadXml(
                final String creditNoteId, final RequestOptions requestOptions) {
            return sync.exchangeDownloadXml(creditNoteId, requestOptions).sendRawAsync();
        }
    }
}

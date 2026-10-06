// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.CreditNote;
import com.meteroid.models.CreditNoteCustomPropertiesRequest;
import com.meteroid.models.CreditNoteListResponse;
import com.meteroid.models.CreditNoteStatus;

import okhttp3.HttpUrl;

import java.util.Objects;

/**
 * The {@code credit_notes} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class CreditNotes {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public CreditNotes(MeteroidHttpClient client) {
        this.client = client;
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
     * @return the response body
     */
    public CreditNoteListResponse list() {
        return list(CreditNotesListOptions.none(), RequestOptions.none());
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param options the optional parameters
     * @return the response body
     */
    public CreditNoteListResponse list(final CreditNotesListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CreditNoteListResponse list(final RequestOptions requestOptions) {
        return list(CreditNotesListOptions.none(), requestOptions);
    }

    /**
     * List credit notes
     *
     * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CreditNoteListResponse list(
            final CreditNotesListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CreditNoteListResponse> exchangeList(
            final CreditNotesListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/credit-notes");
        String value1 = options.customerId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("customer_id", value1);
        }
        String value2 = options.invoiceId().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("invoice_id", value2);
        }
        CreditNoteStatus value3 = options.status().orElse(null);
        if (value3 != null) {
            url.addQueryParameter("status", Utils.serializeQueryParam(value3));
        }
        String value4 = options.search().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("search", value4);
        }
        String value5 = options.orderBy().orElse(null);
        if (value5 != null) {
            url.addQueryParameter("order_by", value5);
        }
        Integer value6 = options.page().orElse(null);
        if (value6 != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(value6));
        }
        Integer value7 = options.perPage().orElse(null);
        if (value7 != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(value7));
        }
        return client.call("GET", url.build())
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "429", "500")
                .options(requestOptions)
                .returning(CreditNoteListResponse.class);
    }

    /**
     * Get credit note
     *
     * <p>Retrieve a single credit note by ID.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body
     */
    public CreditNote retrieve(final String creditNoteId) {
        return retrieve(creditNoteId, RequestOptions.none());
    }

    /**
     * Get credit note
     *
     * <p>Retrieve a single credit note by ID.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public CreditNote retrieve(final String creditNoteId, final RequestOptions requestOptions) {
        return exchangeRetrieve(creditNoteId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<CreditNote> exchangeRetrieve(
            final String creditNoteId, final RequestOptions requestOptions) {
        Objects.requireNonNull(creditNoteId, "credit_note_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/credit-notes")
                        .addPathSegment(Utils.pathSegment("credit_note_id", creditNoteId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(CreditNote.class);
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
     * @return the response body
     */
    public CreditNote updateCustomProperties(
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
     * @return the response body
     */
    public CreditNote updateCustomProperties(
            final String creditNoteId,
            final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdateCustomProperties(
                        creditNoteId, creditNoteCustomPropertiesRequest, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<CreditNote> exchangeUpdateCustomProperties(
            final String creditNoteId,
            final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(creditNoteId, "credit_note_id");
        Objects.requireNonNull(creditNoteCustomPropertiesRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/credit-notes")
                        .addPathSegment(Utils.pathSegment("credit_note_id", creditNoteId))
                        .addPathSegments("custom-properties")
                        .build();
        return client.call("PATCH", url)
                .json(creditNoteCustomPropertiesRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(CreditNote.class);
    }

    /**
     * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body
     */
    public byte[] download(final String creditNoteId) {
        return download(creditNoteId, RequestOptions.none());
    }

    /**
     * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public byte[] download(final String creditNoteId, final RequestOptions requestOptions) {
        return exchangeDownload(creditNoteId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<byte[]> exchangeDownload(
            final String creditNoteId, final RequestOptions requestOptions) {
        Objects.requireNonNull(creditNoteId, "credit_note_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/credit-notes")
                        .addPathSegment(Utils.pathSegment("credit_note_id", creditNoteId))
                        .addPathSegments("download")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returningBytes();
    }

    /**
     * Download credit note e-invoice XML
     *
     * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For Factur-X
     * the same XML is also embedded in the PDF.
     *
     * @param creditNoteId the {@code credit_note_id} path parameter
     * @return the response body
     */
    public byte[] downloadXml(final String creditNoteId) {
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
     * @return the response body
     */
    public byte[] downloadXml(final String creditNoteId, final RequestOptions requestOptions) {
        return exchangeDownloadXml(creditNoteId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<byte[]> exchangeDownloadXml(
            final String creditNoteId, final RequestOptions requestOptions) {
        Objects.requireNonNull(creditNoteId, "credit_note_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/credit-notes")
                        .addPathSegment(Utils.pathSegment("credit_note_id", creditNoteId))
                        .addPathSegments("xml")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returningBytes();
    }

    /** The operations, returning the status and headers along with the body. */
    public final class WithRawResponse {
        private WithRawResponse() {}

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @return the status, headers and body
         */
        public ApiResponse<CreditNoteListResponse> list() {
            return list(CreditNotesListOptions.none(), RequestOptions.none());
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<CreditNoteListResponse> list(final CreditNotesListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CreditNoteListResponse> list(final RequestOptions requestOptions) {
            return list(CreditNotesListOptions.none(), requestOptions);
        }

        /**
         * List credit notes
         *
         * <p>List a tenant's credit notes, optionally filtered by customer, invoice or status.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CreditNoteListResponse> list(
                final CreditNotesListOptions options, final RequestOptions requestOptions) {
            return CreditNotes.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Get credit note
         *
         * <p>Retrieve a single credit note by ID.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<CreditNote> retrieve(final String creditNoteId) {
            return retrieve(creditNoteId, RequestOptions.none());
        }

        /**
         * Get credit note
         *
         * <p>Retrieve a single credit note by ID.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<CreditNote> retrieve(
                final String creditNoteId, final RequestOptions requestOptions) {
            return CreditNotes.this.exchangeRetrieve(creditNoteId, requestOptions).sendRaw();
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
         * @return the status, headers and body
         */
        public ApiResponse<CreditNote> updateCustomProperties(
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
         * @return the status, headers and body
         */
        public ApiResponse<CreditNote> updateCustomProperties(
                final String creditNoteId,
                final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest,
                final RequestOptions requestOptions) {
            return CreditNotes.this
                    .exchangeUpdateCustomProperties(
                            creditNoteId, creditNoteCustomPropertiesRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> download(final String creditNoteId) {
            return download(creditNoteId, RequestOptions.none());
        }

        /**
         * {@code GET /api/v1/credit-notes/{credit_note_id}/download}.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> download(
                final String creditNoteId, final RequestOptions requestOptions) {
            return CreditNotes.this.exchangeDownload(creditNoteId, requestOptions).sendRaw();
        }

        /**
         * Download credit note e-invoice XML
         *
         * <p>Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
         * Factur-X the same XML is also embedded in the PDF.
         *
         * @param creditNoteId the {@code credit_note_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> downloadXml(final String creditNoteId) {
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
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> downloadXml(
                final String creditNoteId, final RequestOptions requestOptions) {
            return CreditNotes.this.exchangeDownloadXml(creditNoteId, requestOptions).sendRaw();
        }
    }
}

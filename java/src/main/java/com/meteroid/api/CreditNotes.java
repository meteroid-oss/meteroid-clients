// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.CreditNote;
import com.meteroid.models.CreditNoteCustomPropertiesRequest;
import com.meteroid.models.CreditNoteListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class CreditNotes {
    private final MeteroidHttpClient client;

    public CreditNotes(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List a tenant's credit notes, optionally filtered by customer, invoice or status. */
    public CreditNoteListResponse listCreditNotes() throws IOException, ApiException {

        return this.listCreditNotes(new CreditNotesListCreditNotesOptions());
    }

    /** List a tenant's credit notes, optionally filtered by customer, invoice or status. */
    public CreditNoteListResponse listCreditNotes(final CreditNotesListCreditNotesOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/credit-notes");
        if (options.customerId != null) {
            url.addQueryParameter("customer_id", Utils.serializeQueryParam(options.customerId));
        }
        if (options.invoiceId != null) {
            url.addQueryParameter("invoice_id", Utils.serializeQueryParam(options.invoiceId));
        }
        if (options.status != null) {
            url.addQueryParameter("status", Utils.serializeQueryParam(options.status));
        }
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        if (options.orderBy != null) {
            url.addQueryParameter("order_by", options.orderBy);
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, CreditNoteListResponse.class);
    }

    /** Retrieve a single credit note by ID. */
    public CreditNote getCreditNoteById(final String creditNoteId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/credit-notes/%s", creditNoteId));
        return this.client.executeRequest("GET", url.build(), null, null, CreditNote.class);
    }

    /**
     * Merge custom property values onto a credit note (send a key with `null` to remove it). Values
     * are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any status
     * — custom properties are external workflow metadata and stay editable after the credit note is
     * finalized.
     */
    public CreditNote patchCreditNoteCustomProperties(
            final String creditNoteId,
            final CreditNoteCustomPropertiesRequest creditNoteCustomPropertiesRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format(
                                        "/api/v1/credit-notes/%s/custom-properties", creditNoteId));
        return this.client.executeRequest(
                "PATCH", url.build(), null, creditNoteCustomPropertiesRequest, CreditNote.class);
    }

    /** */
    public byte[] downloadCreditNotePdf(final String creditNoteId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format("/api/v1/credit-notes/%s/download", creditNoteId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }

    /**
     * Download the structured e-invoice (EN 16931 XML) issued with a credit note. For Factur-X the
     * same XML is also embedded in the PDF.
     */
    public byte[] downloadCreditNoteXml(final String creditNoteId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/credit-notes/%s/xml", creditNoteId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }
}

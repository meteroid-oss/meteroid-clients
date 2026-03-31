// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.Invoice;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Invoices {
    private final MeteroidHttpClient client;

    public Invoices(MeteroidHttpClient client) {
        this.client = client;
    }

    /** Retrieve a single invoice with its payment transactions. */
    public Invoice getInvoiceById(final String invoiceId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/invoices/%s", invoiceId));
        return this.client.executeRequest("GET", url.build(), null, null, Invoice.class);
    }

    /** Download the PDF document for an invoice. */
    public byte[] downloadInvoicePdf(final String invoiceId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/invoices/%s/download", invoiceId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }
}

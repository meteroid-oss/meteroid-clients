// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.Invoice;
import com.meteroid.models.InvoiceListResponse;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Invoices {
    private final MeteroidHttpClient client;

    public Invoices(MeteroidHttpClient client) {
        this.client = client;
    }

    /** List invoices with optional filtering by customer, subscription, or status. */
    public InvoiceListResponse listInvoices() throws IOException, ApiException {

        return this.listInvoices(new InvoicesListInvoicesOptions());
    }

    /** List invoices with optional filtering by customer, subscription, or status. */
    public InvoiceListResponse listInvoices(final InvoicesListInvoicesOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/invoices");
        if (options.customerId != null) {
            url.addQueryParameter("customer_id", options.customerId);
        }
        if (options.subscriptionId != null) {
            url.addQueryParameter(
                    "subscription_id", Utils.serializeQueryParam(options.subscriptionId));
        }
        if (options.statuses != null) {
            url.addQueryParameter("statuses", Utils.serializeQueryParam(options.statuses));
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest(
                "GET", url.build(), null, null, InvoiceListResponse.class);
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

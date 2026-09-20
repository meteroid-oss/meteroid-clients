// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.Invoice;
import com.meteroid.models.InvoiceCustomPropertiesRequest;
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
            Utils.addExplodedQueryParameter(url, "statuses", options.statuses);
        }
        if (options.einvoicingStatus != null) {
            url.addQueryParameter(
                    "einvoicing_status", Utils.serializeQueryParam(options.einvoicingStatus));
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

    /**
     * Merge custom property values onto an invoice (send a key with `null` to remove it). Values
     * are validated against the tenant's `INVOICE` property definitions. Allowed at any status —
     * custom properties are external workflow metadata and stay editable after the invoice is
     * finalized.
     */
    public Invoice patchInvoiceCustomProperties(
            final String invoiceId,
            final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format("/api/v1/invoices/%s/custom-properties", invoiceId));
        return this.client.executeRequest(
                "PATCH", url.build(), null, invoiceCustomPropertiesRequest, Invoice.class);
    }

    /** Download the PDF document for an invoice. */
    public byte[] downloadInvoicePdf(final String invoiceId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/invoices/%s/download", invoiceId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }

    /**
     * Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
     * Drafts are also refreshed periodically in the background; use this to force it, e.g. after
     * ingesting late events. Rejected while a payment for the invoice is in progress or when the
     * invoice was merged into a consolidated parent.
     */
    public Invoice refreshInvoice(final String invoiceId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/invoices/%s/refresh", invoiceId));
        return this.client.executeRequest("POST", url.build(), null, null, Invoice.class);
    }

    /**
     * Download the structured e-invoice (EN 16931 XML) issued with an invoice. For Factur-X the
     * same XML is also embedded in the PDF.
     */
    public byte[] downloadInvoiceXml(final String invoiceId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/invoices/%s/xml", invoiceId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }
}

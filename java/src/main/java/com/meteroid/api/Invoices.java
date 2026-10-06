// this file is @generated
package com.meteroid.api;

import com.meteroid.ApiResponse;
import com.meteroid.RequestOptions;
import com.meteroid.internal.MeteroidHttpClient;
import com.meteroid.internal.Utils;
import com.meteroid.models.EInvoicingStatus;
import com.meteroid.models.Invoice;
import com.meteroid.models.InvoiceCustomPropertiesRequest;
import com.meteroid.models.InvoiceListResponse;
import com.meteroid.models.InvoiceStatus;

import okhttp3.HttpUrl;

import java.util.List;
import java.util.Objects;

/**
 * The {@code invoices} operations, blocking. {@link #withRawResponse()} has the same methods
 * returning the status and headers along with the body.
 */
public final class Invoices {
    private final MeteroidHttpClient client;
    private final WithRawResponse withRawResponse;

    /**
     * The operations, sending through {@code client}.
     *
     * @param client the HTTP client of the SDK
     */
    public Invoices(MeteroidHttpClient client) {
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
     * List invoices with optional filtering by customer, subscription, or status.
     *
     * @return the response body
     */
    public InvoiceListResponse list() {
        return list(InvoicesListOptions.none(), RequestOptions.none());
    }

    /**
     * List invoices with optional filtering by customer, subscription, or status.
     *
     * @param options the optional parameters
     * @return the response body
     */
    public InvoiceListResponse list(final InvoicesListOptions options) {
        return list(options, RequestOptions.none());
    }

    /**
     * List invoices with optional filtering by customer, subscription, or status.
     *
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public InvoiceListResponse list(final RequestOptions requestOptions) {
        return list(InvoicesListOptions.none(), requestOptions);
    }

    /**
     * List invoices with optional filtering by customer, subscription, or status.
     *
     * @param options the optional parameters
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public InvoiceListResponse list(
            final InvoicesListOptions options, final RequestOptions requestOptions) {
        return exchangeList(options, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<InvoiceListResponse> exchangeList(
            final InvoicesListOptions options, final RequestOptions requestOptions) {
        Objects.requireNonNull(options, "options");
        HttpUrl.Builder url = client.newUrlBuilder().addPathSegments("api/v1/invoices");
        String value1 = options.customerId().orElse(null);
        if (value1 != null) {
            url.addQueryParameter("customer_id", value1);
        }
        String value2 = options.subscriptionId().orElse(null);
        if (value2 != null) {
            url.addQueryParameter("subscription_id", value2);
        }
        List<InvoiceStatus> value3 = options.statuses().orElse(null);
        if (value3 != null) {
            Utils.addExplodedQueryParameter(url, "statuses", value3);
        }
        EInvoicingStatus value4 = options.einvoicingStatus().orElse(null);
        if (value4 != null) {
            url.addQueryParameter("einvoicing_status", Utils.serializeQueryParam(value4));
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
                .returning(InvoiceListResponse.class);
    }

    /**
     * Get invoice
     *
     * <p>Retrieve a single invoice with its payment transactions.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @return the response body
     */
    public Invoice retrieve(final String invoiceId) {
        return retrieve(invoiceId, RequestOptions.none());
    }

    /**
     * Get invoice
     *
     * <p>Retrieve a single invoice with its payment transactions.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Invoice retrieve(final String invoiceId, final RequestOptions requestOptions) {
        return exchangeRetrieve(invoiceId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Invoice> exchangeRetrieve(
            final String invoiceId, final RequestOptions requestOptions) {
        Objects.requireNonNull(invoiceId, "invoice_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/invoices")
                        .addPathSegment(Utils.pathSegment("invoice_id", invoiceId))
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returning(Invoice.class);
    }

    /**
     * Update invoice custom properties
     *
     * <p>Merge custom property values onto an invoice (send a key with <code>null</code> to remove
     * it). Values are validated against the tenant's <code>INVOICE</code> property definitions.
     * Allowed at any status — custom properties are external workflow metadata and stay editable
     * after the invoice is finalized.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param invoiceCustomPropertiesRequest the request body
     * @return the response body
     */
    public Invoice updateCustomProperties(
            final String invoiceId,
            final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest) {
        return updateCustomProperties(
                invoiceId, invoiceCustomPropertiesRequest, RequestOptions.none());
    }

    /**
     * Update invoice custom properties
     *
     * <p>Merge custom property values onto an invoice (send a key with <code>null</code> to remove
     * it). Values are validated against the tenant's <code>INVOICE</code> property definitions.
     * Allowed at any status — custom properties are external workflow metadata and stay editable
     * after the invoice is finalized.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param invoiceCustomPropertiesRequest the request body
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Invoice updateCustomProperties(
            final String invoiceId,
            final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest,
            final RequestOptions requestOptions) {
        return exchangeUpdateCustomProperties(
                        invoiceId, invoiceCustomPropertiesRequest, requestOptions)
                .send();
    }

    MeteroidHttpClient.Exchange<Invoice> exchangeUpdateCustomProperties(
            final String invoiceId,
            final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest,
            final RequestOptions requestOptions) {
        Objects.requireNonNull(invoiceId, "invoice_id");
        Objects.requireNonNull(invoiceCustomPropertiesRequest, "body");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/invoices")
                        .addPathSegment(Utils.pathSegment("invoice_id", invoiceId))
                        .addPathSegments("custom-properties")
                        .build();
        return client.call("PATCH", url)
                .json(invoiceCustomPropertiesRequest)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(Invoice.class);
    }

    /**
     * Download invoice PDF
     *
     * <p>Download the PDF document for an invoice.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @return the response body
     */
    public byte[] download(final String invoiceId) {
        return download(invoiceId, RequestOptions.none());
    }

    /**
     * Download invoice PDF
     *
     * <p>Download the PDF document for an invoice.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public byte[] download(final String invoiceId, final RequestOptions requestOptions) {
        return exchangeDownload(invoiceId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<byte[]> exchangeDownload(
            final String invoiceId, final RequestOptions requestOptions) {
        Objects.requireNonNull(invoiceId, "invoice_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/invoices")
                        .addPathSegment(Utils.pathSegment("invoice_id", invoiceId))
                        .addPathSegments("download")
                        .build();
        return client.call("GET", url)
                .errors(com.meteroid.models.RestErrorResponse.class, "401", "404", "429", "500")
                .options(requestOptions)
                .returningBytes();
    }

    /**
     * Refresh invoice
     *
     * <p>Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
     * Drafts are also refreshed periodically in the background; use this to force it, e.g. after
     * ingesting late events. Rejected while a payment for the invoice is in progress or when the
     * invoice was merged into a consolidated parent.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @return the response body
     */
    public Invoice refresh(final String invoiceId) {
        return refresh(invoiceId, RequestOptions.none());
    }

    /**
     * Refresh invoice
     *
     * <p>Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
     * Drafts are also refreshed periodically in the background; use this to force it, e.g. after
     * ingesting late events. Rejected while a payment for the invoice is in progress or when the
     * invoice was merged into a consolidated parent.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public Invoice refresh(final String invoiceId, final RequestOptions requestOptions) {
        return exchangeRefresh(invoiceId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<Invoice> exchangeRefresh(
            final String invoiceId, final RequestOptions requestOptions) {
        Objects.requireNonNull(invoiceId, "invoice_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/invoices")
                        .addPathSegment(Utils.pathSegment("invoice_id", invoiceId))
                        .addPathSegments("refresh")
                        .build();
        return client.call("POST", url)
                .errors(
                        com.meteroid.models.RestErrorResponse.class,
                        "400",
                        "401",
                        "404",
                        "429",
                        "500")
                .options(requestOptions)
                .returning(Invoice.class);
    }

    /**
     * Download invoice e-invoice XML
     *
     * <p>Download the structured e-invoice (EN 16931 XML) issued with an invoice. For Factur-X the
     * same XML is also embedded in the PDF.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @return the response body
     */
    public byte[] downloadXml(final String invoiceId) {
        return downloadXml(invoiceId, RequestOptions.none());
    }

    /**
     * Download invoice e-invoice XML
     *
     * <p>Download the structured e-invoice (EN 16931 XML) issued with an invoice. For Factur-X the
     * same XML is also embedded in the PDF.
     *
     * @param invoiceId the {@code invoice_id} path parameter
     * @param requestOptions headers, timeout and retries of this call
     * @return the response body
     */
    public byte[] downloadXml(final String invoiceId, final RequestOptions requestOptions) {
        return exchangeDownloadXml(invoiceId, requestOptions).send();
    }

    MeteroidHttpClient.Exchange<byte[]> exchangeDownloadXml(
            final String invoiceId, final RequestOptions requestOptions) {
        Objects.requireNonNull(invoiceId, "invoice_id");
        HttpUrl url =
                client.newUrlBuilder()
                        .addPathSegments("api/v1/invoices")
                        .addPathSegment(Utils.pathSegment("invoice_id", invoiceId))
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
         * List invoices with optional filtering by customer, subscription, or status.
         *
         * @return the status, headers and body
         */
        public ApiResponse<InvoiceListResponse> list() {
            return list(InvoicesListOptions.none(), RequestOptions.none());
        }

        /**
         * List invoices with optional filtering by customer, subscription, or status.
         *
         * @param options the optional parameters
         * @return the status, headers and body
         */
        public ApiResponse<InvoiceListResponse> list(final InvoicesListOptions options) {
            return list(options, RequestOptions.none());
        }

        /**
         * List invoices with optional filtering by customer, subscription, or status.
         *
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<InvoiceListResponse> list(final RequestOptions requestOptions) {
            return list(InvoicesListOptions.none(), requestOptions);
        }

        /**
         * List invoices with optional filtering by customer, subscription, or status.
         *
         * @param options the optional parameters
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<InvoiceListResponse> list(
                final InvoicesListOptions options, final RequestOptions requestOptions) {
            return Invoices.this.exchangeList(options, requestOptions).sendRaw();
        }

        /**
         * Get invoice
         *
         * <p>Retrieve a single invoice with its payment transactions.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> retrieve(final String invoiceId) {
            return retrieve(invoiceId, RequestOptions.none());
        }

        /**
         * Get invoice
         *
         * <p>Retrieve a single invoice with its payment transactions.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> retrieve(
                final String invoiceId, final RequestOptions requestOptions) {
            return Invoices.this.exchangeRetrieve(invoiceId, requestOptions).sendRaw();
        }

        /**
         * Update invoice custom properties
         *
         * <p>Merge custom property values onto an invoice (send a key with <code>null</code> to
         * remove it). Values are validated against the tenant's <code>INVOICE</code> property
         * definitions. Allowed at any status — custom properties are external workflow metadata and
         * stay editable after the invoice is finalized.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param invoiceCustomPropertiesRequest the request body
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> updateCustomProperties(
                final String invoiceId,
                final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest) {
            return updateCustomProperties(
                    invoiceId, invoiceCustomPropertiesRequest, RequestOptions.none());
        }

        /**
         * Update invoice custom properties
         *
         * <p>Merge custom property values onto an invoice (send a key with <code>null</code> to
         * remove it). Values are validated against the tenant's <code>INVOICE</code> property
         * definitions. Allowed at any status — custom properties are external workflow metadata and
         * stay editable after the invoice is finalized.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param invoiceCustomPropertiesRequest the request body
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> updateCustomProperties(
                final String invoiceId,
                final InvoiceCustomPropertiesRequest invoiceCustomPropertiesRequest,
                final RequestOptions requestOptions) {
            return Invoices.this
                    .exchangeUpdateCustomProperties(
                            invoiceId, invoiceCustomPropertiesRequest, requestOptions)
                    .sendRaw();
        }

        /**
         * Download invoice PDF
         *
         * <p>Download the PDF document for an invoice.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> download(final String invoiceId) {
            return download(invoiceId, RequestOptions.none());
        }

        /**
         * Download invoice PDF
         *
         * <p>Download the PDF document for an invoice.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> download(
                final String invoiceId, final RequestOptions requestOptions) {
            return Invoices.this.exchangeDownload(invoiceId, requestOptions).sendRaw();
        }

        /**
         * Refresh invoice
         *
         * <p>Recompute a draft invoice against current usage, credits, coupons and tax, and return
         * it. Drafts are also refreshed periodically in the background; use this to force it, e.g.
         * after ingesting late events. Rejected while a payment for the invoice is in progress or
         * when the invoice was merged into a consolidated parent.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> refresh(final String invoiceId) {
            return refresh(invoiceId, RequestOptions.none());
        }

        /**
         * Refresh invoice
         *
         * <p>Recompute a draft invoice against current usage, credits, coupons and tax, and return
         * it. Drafts are also refreshed periodically in the background; use this to force it, e.g.
         * after ingesting late events. Rejected while a payment for the invoice is in progress or
         * when the invoice was merged into a consolidated parent.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<Invoice> refresh(
                final String invoiceId, final RequestOptions requestOptions) {
            return Invoices.this.exchangeRefresh(invoiceId, requestOptions).sendRaw();
        }

        /**
         * Download invoice e-invoice XML
         *
         * <p>Download the structured e-invoice (EN 16931 XML) issued with an invoice. For Factur-X
         * the same XML is also embedded in the PDF.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> downloadXml(final String invoiceId) {
            return downloadXml(invoiceId, RequestOptions.none());
        }

        /**
         * Download invoice e-invoice XML
         *
         * <p>Download the structured e-invoice (EN 16931 XML) issued with an invoice. For Factur-X
         * the same XML is also embedded in the PDF.
         *
         * @param invoiceId the {@code invoice_id} path parameter
         * @param requestOptions headers, timeout and retries of this call
         * @return the status, headers and body
         */
        public ApiResponse<byte[]> downloadXml(
                final String invoiceId, final RequestOptions requestOptions) {
            return Invoices.this.exchangeDownloadXml(invoiceId, requestOptions).sendRaw();
        }
    }
}

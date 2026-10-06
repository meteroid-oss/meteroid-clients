// this file is @generated

import type { EInvoicingStatus } from "../models/eInvoicingStatus.js";
import { type Invoice, InvoiceSerializer } from "../models/invoice.js";
import {
  type InvoiceCustomPropertiesRequest,
  InvoiceCustomPropertiesRequestSerializer,
} from "../models/invoiceCustomPropertiesRequest.js";
import {
  type InvoiceListResponse,
  InvoiceListResponseSerializer,
} from "../models/invoiceListResponse.js";
import type { InvoiceStatus } from "../models/invoiceStatus.js";
import type { SubscriptionId } from "../models/subscriptionId.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface InvoicesListOptions {
  /** Filter by customer ID or alias */
  customerId?: string | undefined;
  subscriptionId?: SubscriptionId | undefined;
  statuses?: InvoiceStatus[] | undefined;
  /**
   * Only invoices whose e-invoice was generated, or failed. Invoices from entities that
   * had not opted in carry no status and match neither.
   */
  einvoicingStatus?: EInvoicingStatus | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The invoices operations, reached through the client's `invoices`. */
export class Invoices {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List invoices with optional filtering by customer, subscription, or status. */
  public list(
    options?: InvoicesListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<InvoiceListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/invoices");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("subscription_id", options?.subscriptionId);
    request.setExplodedQueryParam("statuses", options?.statuses);
    request.setQueryParam("einvoicing_status", options?.einvoicingStatus);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      InvoiceListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get invoice
   *
   * Retrieve a single invoice with its payment transactions.
   */
  public retrieve(
    invoiceId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Invoice> {
    const request = new MeteroidRequest("GET", "/api/v1/invoices/{invoice_id}");

    request.setPathParam("invoice_id", invoiceId);
    return request.send(this.requestCtx, InvoiceSerializer.parse, requestOptions);
  }

  /**
   * Update invoice custom properties
   *
   * Merge custom property values onto an invoice (send a key with `null` to remove it).
   * Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
   * status — custom properties are external workflow metadata and stay editable after the invoice
   * is finalized.
   */
  public updateCustomProperties(
    invoiceId: string,
    invoiceCustomPropertiesRequest: InvoiceCustomPropertiesRequest,
    requestOptions?: RequestOptions
  ): APIPromise<Invoice> {
    const request = new MeteroidRequest(
      "PATCH",
      "/api/v1/invoices/{invoice_id}/custom-properties"
    );

    request.setPathParam("invoice_id", invoiceId);
    request.setBody(
      InvoiceCustomPropertiesRequestSerializer.serialize(invoiceCustomPropertiesRequest)
    );
    return request.send(this.requestCtx, InvoiceSerializer.parse, requestOptions);
  }

  /**
   * Download invoice PDF
   *
   * Download the PDF document for an invoice.
   */
  public download(
    invoiceId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Uint8Array> {
    const request = new MeteroidRequest("GET", "/api/v1/invoices/{invoice_id}/download");

    request.setPathParam("invoice_id", invoiceId);
    return request.sendBinary(this.requestCtx, requestOptions);
  }

  /**
   * Refresh invoice
   *
   * Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
   * Drafts are also refreshed periodically in the background; use this to force it, e.g. after
   * ingesting late events. Rejected while a payment for the invoice is in progress or when the
   * invoice was merged into a consolidated parent.
   */
  public refresh(
    invoiceId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Invoice> {
    const request = new MeteroidRequest("POST", "/api/v1/invoices/{invoice_id}/refresh");

    request.setPathParam("invoice_id", invoiceId);
    return request.send(this.requestCtx, InvoiceSerializer.parse, requestOptions);
  }

  /**
   * Download invoice e-invoice XML
   *
   * Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
   * Factur-X the same XML is also embedded in the PDF.
   */
  public downloadXml(
    invoiceId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Uint8Array> {
    const request = new MeteroidRequest("GET", "/api/v1/invoices/{invoice_id}/xml");

    request.setPathParam("invoice_id", invoiceId);
    return request.sendBinary(this.requestCtx, requestOptions);
  }
}

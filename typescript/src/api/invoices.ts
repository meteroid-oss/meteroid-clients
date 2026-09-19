// this file is @generated
import type { EInvoicingStatus } from "../models/eInvoicingStatus";
import { type Invoice, InvoiceSerializer } from "../models/invoice";
import {
  type InvoiceCustomPropertiesRequest,
  InvoiceCustomPropertiesRequestSerializer,
} from "../models/invoiceCustomPropertiesRequest";
import {
  type InvoiceListResponse,
  InvoiceListResponseSerializer,
} from "../models/invoiceListResponse";
import type { InvoiceStatus } from "../models/invoiceStatus";
import type { SubscriptionId } from "../models/subscriptionId";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface InvoicesListInvoicesOptions {
  /** Filter by customer ID or alias */
  customerId?: string;
  subscriptionId?: SubscriptionId;
  statuses?: InvoiceStatus[];
  /**
   * Only invoices whose e-invoice was generated, or failed. Invoices from entities that
   * had not opted in carry no status and match neither.
   */
  einvoicingStatus?: EInvoicingStatus;
  /** Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class Invoices {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List invoices with optional filtering by customer, subscription, or status. */
  public listInvoices(
    options?: InvoicesListInvoicesOptions
  ): Promise<InvoiceListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/invoices");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("subscription_id", options?.subscriptionId);
    request.setExplodedQueryParam("statuses", options?.statuses);
    request.setQueryParam("einvoicing_status", options?.einvoicingStatus);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(this.requestCtx, InvoiceListResponseSerializer._fromJsonObject);
  }

  /** Retrieve a single invoice with its payment transactions. */
  public getInvoiceById(invoiceId: string): Promise<Invoice> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/invoices/{invoice_id}");

    request.setPathParam("invoice_id", invoiceId);
    return request.send(this.requestCtx, InvoiceSerializer._fromJsonObject);
  }

  /**
   * Merge custom property values onto an invoice (send a key with `null` to remove it).
   * Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
   * status — custom properties are external workflow metadata and stay editable after the invoice
   * is finalized.
   */
  public patchInvoiceCustomProperties(
    invoiceId: string,
    invoiceCustomPropertiesRequest: InvoiceCustomPropertiesRequest
  ): Promise<Invoice> {
    const request = new MeteroidRequest(
      HttpMethod.PATCH,
      "/api/v1/invoices/{invoice_id}/custom-properties"
    );

    request.setPathParam("invoice_id", invoiceId);
    request.setBody(
      InvoiceCustomPropertiesRequestSerializer._toJsonObject(
        invoiceCustomPropertiesRequest
      )
    );
    return request.send(this.requestCtx, InvoiceSerializer._fromJsonObject);
  }

  /** Download the PDF document for an invoice. */
  public downloadInvoicePdf(invoiceId: string): Promise<Uint8Array> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/invoices/{invoice_id}/download"
    );

    request.setPathParam("invoice_id", invoiceId);
    return request.sendBinary(this.requestCtx);
  }

  /**
   * Recompute a draft invoice against current usage, credits, coupons and tax, and return it.
   * Drafts are also refreshed periodically in the background; use this to force it, e.g. after
   * ingesting late events. Rejected while a payment for the invoice is in progress or when the
   * invoice was merged into a consolidated parent.
   */
  public refreshInvoice(invoiceId: string): Promise<Invoice> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/invoices/{invoice_id}/refresh"
    );

    request.setPathParam("invoice_id", invoiceId);
    return request.send(this.requestCtx, InvoiceSerializer._fromJsonObject);
  }

  /**
   * Download the structured e-invoice (EN 16931 XML) issued with an invoice. For
   * Factur-X the same XML is also embedded in the PDF.
   */
  public downloadInvoiceXml(invoiceId: string): Promise<Uint8Array> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/invoices/{invoice_id}/xml"
    );

    request.setPathParam("invoice_id", invoiceId);
    return request.sendBinary(this.requestCtx);
  }
}

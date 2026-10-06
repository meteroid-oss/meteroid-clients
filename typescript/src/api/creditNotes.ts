// this file is @generated

import { type CreditNote, CreditNoteSerializer } from "../models/creditNote.js";
import {
  type CreditNoteCustomPropertiesRequest,
  CreditNoteCustomPropertiesRequestSerializer,
} from "../models/creditNoteCustomPropertiesRequest.js";
import {
  type CreditNoteListResponse,
  CreditNoteListResponseSerializer,
} from "../models/creditNoteListResponse.js";
import type { CreditNoteStatus } from "../models/creditNoteStatus.js";
import type { CustomerId } from "../models/customerId.js";
import type { InvoiceId } from "../models/invoiceId.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface CreditNotesListOptions {
  /** Filter by customer ID */
  customerId?: CustomerId | undefined;
  /** Filter by invoice ID */
  invoiceId?: InvoiceId | undefined;
  status?: CreditNoteStatus | undefined;
  /** Free-text search over credit note number. */
  search?: string | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The credit notes operations, reached through the client's `creditNotes`. */
export class CreditNotes {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * List credit notes
   *
   * List a tenant's credit notes, optionally filtered by customer, invoice or status.
   */
  public list(
    options?: CreditNotesListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<CreditNoteListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/credit-notes");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("invoice_id", options?.invoiceId);
    request.setQueryParam("status", options?.status);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      CreditNoteListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get credit note
   *
   * Retrieve a single credit note by ID.
   */
  public retrieve(
    creditNoteId: string,
    requestOptions?: RequestOptions
  ): APIPromise<CreditNote> {
    const request = new MeteroidRequest("GET", "/api/v1/credit-notes/{credit_note_id}");

    request.setPathParam("credit_note_id", creditNoteId);
    return request.send(this.requestCtx, CreditNoteSerializer.parse, requestOptions);
  }

  /**
   * Update credit note custom properties
   *
   * Merge custom property values onto a credit note (send a key with `null` to remove it).
   * Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
   * status — custom properties are external workflow metadata and stay editable after the credit
   * note is finalized.
   */
  public updateCustomProperties(
    creditNoteId: string,
    creditNoteCustomPropertiesRequest: CreditNoteCustomPropertiesRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CreditNote> {
    const request = new MeteroidRequest(
      "PATCH",
      "/api/v1/credit-notes/{credit_note_id}/custom-properties"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    request.setBody(
      CreditNoteCustomPropertiesRequestSerializer.serialize(
        creditNoteCustomPropertiesRequest
      )
    );
    return request.send(this.requestCtx, CreditNoteSerializer.parse, requestOptions);
  }

  /** `GET /api/v1/credit-notes/{credit_note_id}/download`. */
  public download(
    creditNoteId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Uint8Array> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/credit-notes/{credit_note_id}/download"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    return request.sendBinary(this.requestCtx, requestOptions);
  }

  /**
   * Download credit note e-invoice XML
   *
   * Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
   * Factur-X the same XML is also embedded in the PDF.
   */
  public downloadXml(
    creditNoteId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Uint8Array> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/credit-notes/{credit_note_id}/xml"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    return request.sendBinary(this.requestCtx, requestOptions);
  }
}

// this file is @generated
import { type CreditNote, CreditNoteSerializer } from "../models/creditNote";
import {
  type CreditNoteCustomPropertiesRequest,
  CreditNoteCustomPropertiesRequestSerializer,
} from "../models/creditNoteCustomPropertiesRequest";
import {
  type CreditNoteListResponse,
  CreditNoteListResponseSerializer,
} from "../models/creditNoteListResponse";
import type { CreditNoteStatus } from "../models/creditNoteStatus";
import type { CustomerId } from "../models/customerId";
import type { InvoiceId } from "../models/invoiceId";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface CreditNotesListCreditNotesOptions {
  /** Filter by customer ID */
  customerId?: CustomerId;
  /** Filter by invoice ID */
  invoiceId?: InvoiceId;
  status?: CreditNoteStatus;
  /** Free-text search over credit note number. */
  search?: string;
  /** Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class CreditNotes {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List a tenant's credit notes, optionally filtered by customer, invoice or status. */
  public listCreditNotes(
    options?: CreditNotesListCreditNotesOptions
  ): Promise<CreditNoteListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/credit-notes");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("invoice_id", options?.invoiceId);
    request.setQueryParam("status", options?.status);
    request.setQueryParam("search", options?.search);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      CreditNoteListResponseSerializer._fromJsonObject
    );
  }

  /** Retrieve a single credit note by ID. */
  public getCreditNoteById(creditNoteId: string): Promise<CreditNote> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/credit-notes/{credit_note_id}"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    return request.send(this.requestCtx, CreditNoteSerializer._fromJsonObject);
  }

  /**
   * Merge custom property values onto a credit note (send a key with `null` to remove it).
   * Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
   * status — custom properties are external workflow metadata and stay editable after the credit
   * note is finalized.
   */
  public patchCreditNoteCustomProperties(
    creditNoteId: string,
    creditNoteCustomPropertiesRequest: CreditNoteCustomPropertiesRequest
  ): Promise<CreditNote> {
    const request = new MeteroidRequest(
      HttpMethod.PATCH,
      "/api/v1/credit-notes/{credit_note_id}/custom-properties"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    request.setBody(
      CreditNoteCustomPropertiesRequestSerializer._toJsonObject(
        creditNoteCustomPropertiesRequest
      )
    );
    return request.send(this.requestCtx, CreditNoteSerializer._fromJsonObject);
  }

  /**  */
  public downloadCreditNotePdf(creditNoteId: string): Promise<Uint8Array> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/credit-notes/{credit_note_id}/download"
    );

    request.setPathParam("credit_note_id", creditNoteId);
    return request.sendBinary(this.requestCtx);
  }
}

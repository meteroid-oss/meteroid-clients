// this file is @generated
import { parseDateTime } from "../datetime";
import { type CreditNoteId, CreditNoteIdSerializer } from "./creditNoteId";
import { type CreditNoteStatus, CreditNoteStatusSerializer } from "./creditNoteStatus";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId";
import { type InvoiceLineItem, InvoiceLineItemSerializer } from "./invoiceLineItem";
import { type TaxBreakdownItem, TaxBreakdownItemSerializer } from "./taxBreakdownItem";

export interface CreditNoteEventData {
  createdAt: Date;

  creditNoteId: CreditNoteId;

  /** Absent while the credit note is a draft — the number is assigned at finalization. */
  creditNoteNumber?: string | null;

  creditedAmountCents: number;

  currency: string;

  /** User-defined custom property values, keyed by definition key. */
  customProperties: unknown;

  customerId: CustomerId;

  invoiceId: InvoiceId;

  /** Number of the invoice being credited. */
  invoiceNumber?: string | null;

  /** Credited line items (negated amounts). */
  lineItems: InvoiceLineItem[];

  memo?: string | null;

  reason?: string | null;

  refundedAmountCents: number;

  status: CreditNoteStatus;

  subtotal: number;

  taxAmount: number;

  /** Per-rate tax (VAT) breakdown for the credited amount. */
  taxBreakdown: TaxBreakdownItem[];

  total: number;
}

export const CreditNoteEventDataSerializer = {
  _fromJsonObject(object: any): CreditNoteEventData {
    return {
      createdAt: parseDateTime(object["created_at"]),
      creditNoteId: CreditNoteIdSerializer._fromJsonObject(object["credit_note_id"]),
      creditNoteNumber: object["credit_note_number"],
      creditedAmountCents: object["credited_amount_cents"],
      currency: object["currency"],
      customProperties: object["custom_properties"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      invoiceId: InvoiceIdSerializer._fromJsonObject(object["invoice_id"]),
      invoiceNumber: object["invoice_number"],
      lineItems: object["line_items"].map((item: any) =>
        InvoiceLineItemSerializer._fromJsonObject(item)
      ),
      memo: object["memo"],
      reason: object["reason"],
      refundedAmountCents: object["refunded_amount_cents"],
      status: CreditNoteStatusSerializer._fromJsonObject(object["status"]),
      subtotal: object["subtotal"],
      taxAmount: object["tax_amount"],
      taxBreakdown: object["tax_breakdown"].map((item: any) =>
        TaxBreakdownItemSerializer._fromJsonObject(item)
      ),
      total: object["total"],
    };
  },

  _toJsonObject(self: CreditNoteEventData): any {
    return {
      created_at: self.createdAt,
      credit_note_id: CreditNoteIdSerializer._toJsonObject(self.creditNoteId),
      credit_note_number: self.creditNoteNumber,
      credited_amount_cents: self.creditedAmountCents,
      currency: self.currency,
      custom_properties: self.customProperties,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      invoice_id: InvoiceIdSerializer._toJsonObject(self.invoiceId),
      invoice_number: self.invoiceNumber,
      line_items: self.lineItems.map((item: any) =>
        InvoiceLineItemSerializer._toJsonObject(item)
      ),
      memo: self.memo,
      reason: self.reason,
      refunded_amount_cents: self.refundedAmountCents,
      status: CreditNoteStatusSerializer._toJsonObject(self.status),
      subtotal: self.subtotal,
      tax_amount: self.taxAmount,
      tax_breakdown: self.taxBreakdown.map((item: any) =>
        TaxBreakdownItemSerializer._toJsonObject(item)
      ),
      total: self.total,
    };
  },
};

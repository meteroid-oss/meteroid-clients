// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CreditNoteId, CreditNoteIdSerializer } from "./creditNoteId.js";
import { type CreditNoteStatus, CreditNoteStatusSerializer } from "./creditNoteStatus.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId.js";
import { type InvoiceLineItem, InvoiceLineItemSerializer } from "./invoiceLineItem.js";
import { type TaxBreakdownItem, TaxBreakdownItemSerializer } from "./taxBreakdownItem.js";

export interface CreditNoteEventData {
  createdAt: Date;
  creditNoteId: CreditNoteId;
  /** Absent while the credit note is a draft — the number is assigned at finalization. */
  creditNoteNumber?: string | null | undefined;
  creditedAmountCents: number;
  currency: string;
  /** User-defined custom property values, keyed by definition key. */
  customProperties: unknown;
  customerId: CustomerId;
  invoiceId: InvoiceId;
  /** Number of the invoice being credited. */
  invoiceNumber?: string | null | undefined;
  /** Credited line items (negated amounts). */
  lineItems: InvoiceLineItem[];
  memo?: string | null | undefined;
  reason?: string | null | undefined;
  refundedAmountCents: number;
  status: CreditNoteStatus;
  subtotal: number;
  taxAmount: number;
  /** Per-rate tax (VAT) breakdown for the credited amount. */
  taxBreakdown: TaxBreakdownItem[];
  total: number;
}

/** Converts `CreditNoteEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditNoteEventDataSerializer = {
  parse(json: any): CreditNoteEventData {
    return {
      ...extraProperties(json, [
        "created_at",
        "credit_note_id",
        "credit_note_number",
        "credited_amount_cents",
        "currency",
        "custom_properties",
        "customer_id",
        "invoice_id",
        "invoice_number",
        "line_items",
        "memo",
        "reason",
        "refunded_amount_cents",
        "status",
        "subtotal",
        "tax_amount",
        "tax_breakdown",
        "total",
      ]),
      createdAt: parseDateTime(json["created_at"]),
      creditNoteId: CreditNoteIdSerializer.parse(json["credit_note_id"]),
      creditNoteNumber: json["credit_note_number"],
      creditedAmountCents: json["credited_amount_cents"],
      currency: json["currency"],
      customProperties: json["custom_properties"],
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      invoiceId: InvoiceIdSerializer.parse(json["invoice_id"]),
      invoiceNumber: json["invoice_number"],
      lineItems: json["line_items"].map((item: any) =>
        InvoiceLineItemSerializer.parse(item)
      ),
      memo: json["memo"],
      reason: json["reason"],
      refundedAmountCents: json["refunded_amount_cents"],
      status: CreditNoteStatusSerializer.parse(json["status"]),
      subtotal: json["subtotal"],
      taxAmount: json["tax_amount"],
      taxBreakdown: json["tax_breakdown"].map((item: any) =>
        TaxBreakdownItemSerializer.parse(item)
      ),
      total: json["total"],
    };
  },

  serialize(value: CreditNoteEventData): any {
    return {
      ...extraProperties(value, [
        "createdAt",
        "creditNoteId",
        "creditNoteNumber",
        "creditedAmountCents",
        "currency",
        "customProperties",
        "customerId",
        "invoiceId",
        "invoiceNumber",
        "lineItems",
        "memo",
        "reason",
        "refundedAmountCents",
        "status",
        "subtotal",
        "taxAmount",
        "taxBreakdown",
        "total",
      ]),
      created_at: value.createdAt,
      credit_note_id: CreditNoteIdSerializer.serialize(value.creditNoteId),
      credit_note_number: value.creditNoteNumber,
      credited_amount_cents: value.creditedAmountCents,
      currency: value.currency,
      custom_properties: value.customProperties,
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      invoice_id: InvoiceIdSerializer.serialize(value.invoiceId),
      invoice_number: value.invoiceNumber,
      line_items: value.lineItems.map((item: any) =>
        InvoiceLineItemSerializer.serialize(item)
      ),
      memo: value.memo,
      reason: value.reason,
      refunded_amount_cents: value.refundedAmountCents,
      status: CreditNoteStatusSerializer.serialize(value.status),
      subtotal: value.subtotal,
      tax_amount: value.taxAmount,
      tax_breakdown: value.taxBreakdown.map((item: any) =>
        TaxBreakdownItemSerializer.serialize(item)
      ),
      total: value.total,
    };
  },
};

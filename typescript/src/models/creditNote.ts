// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CreditNoteId, CreditNoteIdSerializer } from "./creditNoteId.js";
import { type CreditNoteStatus, CreditNoteStatusSerializer } from "./creditNoteStatus.js";
import { type CreditType, CreditTypeSerializer } from "./creditType.js";
import { type Currency, CurrencySerializer } from "./currency.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId.js";
import { type InvoiceLineItem, InvoiceLineItemSerializer } from "./invoiceLineItem.js";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId.js";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId.js";
import { type TaxBreakdownItem, TaxBreakdownItemSerializer } from "./taxBreakdownItem.js";

export interface CreditNote {
  createdAt: Date;
  creditNoteNumber: string;
  creditType: CreditType;
  creditedAmountCents: number;
  currency: Currency;
  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: unknown;
  customerId: CustomerId;
  finalizedAt?: Date | null | undefined;
  id: CreditNoteId;
  invoiceId: InvoiceId;
  invoiceNumber: string;
  lineItems: InvoiceLineItem[];
  memo?: string | null | undefined;
  planVersionId?: PlanVersionId | null | undefined;
  reason?: string | null | undefined;
  refundedAmountCents: number;
  status: CreditNoteStatus;
  subscriptionId?: SubscriptionId | null | undefined;
  subtotal: number;
  taxAmount: number;
  taxBreakdown: TaxBreakdownItem[];
  total: number;
  updatedAt?: Date | null | undefined;
  voidedAt?: Date | null | undefined;
}

/** Converts `CreditNote` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditNoteSerializer = {
  parse(json: any): CreditNote {
    return {
      ...extraProperties(json, [
        "created_at",
        "credit_note_number",
        "credit_type",
        "credited_amount_cents",
        "currency",
        "custom_properties",
        "customer_id",
        "finalized_at",
        "id",
        "invoice_id",
        "invoice_number",
        "line_items",
        "memo",
        "plan_version_id",
        "reason",
        "refunded_amount_cents",
        "status",
        "subscription_id",
        "subtotal",
        "tax_amount",
        "tax_breakdown",
        "total",
        "updated_at",
        "voided_at",
      ]),
      createdAt: parseDateTime(json["created_at"]),
      creditNoteNumber: json["credit_note_number"],
      creditType: CreditTypeSerializer.parse(json["credit_type"]),
      creditedAmountCents: json["credited_amount_cents"],
      currency: CurrencySerializer.parse(json["currency"]),
      customProperties: json["custom_properties"],
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      finalizedAt:
        json["finalized_at"] != null
          ? parseDateTime(json["finalized_at"])
          : json["finalized_at"],
      id: CreditNoteIdSerializer.parse(json["id"]),
      invoiceId: InvoiceIdSerializer.parse(json["invoice_id"]),
      invoiceNumber: json["invoice_number"],
      lineItems: json["line_items"].map((item: any) =>
        InvoiceLineItemSerializer.parse(item)
      ),
      memo: json["memo"],
      planVersionId:
        json["plan_version_id"] != null
          ? PlanVersionIdSerializer.parse(json["plan_version_id"])
          : json["plan_version_id"],
      reason: json["reason"],
      refundedAmountCents: json["refunded_amount_cents"],
      status: CreditNoteStatusSerializer.parse(json["status"]),
      subscriptionId:
        json["subscription_id"] != null
          ? SubscriptionIdSerializer.parse(json["subscription_id"])
          : json["subscription_id"],
      subtotal: json["subtotal"],
      taxAmount: json["tax_amount"],
      taxBreakdown: json["tax_breakdown"].map((item: any) =>
        TaxBreakdownItemSerializer.parse(item)
      ),
      total: json["total"],
      updatedAt:
        json["updated_at"] != null
          ? parseDateTime(json["updated_at"])
          : json["updated_at"],
      voidedAt:
        json["voided_at"] != null ? parseDateTime(json["voided_at"]) : json["voided_at"],
    };
  },

  serialize(value: CreditNote): any {
    return {
      ...extraProperties(value, [
        "createdAt",
        "creditNoteNumber",
        "creditType",
        "creditedAmountCents",
        "currency",
        "customProperties",
        "customerId",
        "finalizedAt",
        "id",
        "invoiceId",
        "invoiceNumber",
        "lineItems",
        "memo",
        "planVersionId",
        "reason",
        "refundedAmountCents",
        "status",
        "subscriptionId",
        "subtotal",
        "taxAmount",
        "taxBreakdown",
        "total",
        "updatedAt",
        "voidedAt",
      ]),
      created_at: value.createdAt,
      credit_note_number: value.creditNoteNumber,
      credit_type: CreditTypeSerializer.serialize(value.creditType),
      credited_amount_cents: value.creditedAmountCents,
      currency: CurrencySerializer.serialize(value.currency),
      custom_properties: value.customProperties,
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      finalized_at: value.finalizedAt,
      id: CreditNoteIdSerializer.serialize(value.id),
      invoice_id: InvoiceIdSerializer.serialize(value.invoiceId),
      invoice_number: value.invoiceNumber,
      line_items: value.lineItems.map((item: any) =>
        InvoiceLineItemSerializer.serialize(item)
      ),
      memo: value.memo,
      plan_version_id:
        value.planVersionId != null
          ? PlanVersionIdSerializer.serialize(value.planVersionId)
          : value.planVersionId,
      reason: value.reason,
      refunded_amount_cents: value.refundedAmountCents,
      status: CreditNoteStatusSerializer.serialize(value.status),
      subscription_id:
        value.subscriptionId != null
          ? SubscriptionIdSerializer.serialize(value.subscriptionId)
          : value.subscriptionId,
      subtotal: value.subtotal,
      tax_amount: value.taxAmount,
      tax_breakdown: value.taxBreakdown.map((item: any) =>
        TaxBreakdownItemSerializer.serialize(item)
      ),
      total: value.total,
      updated_at: value.updatedAt,
      voided_at: value.voidedAt,
    };
  },
};

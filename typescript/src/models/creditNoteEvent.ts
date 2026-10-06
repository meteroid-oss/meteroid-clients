// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import {
  type CreditNoteEventData,
  CreditNoteEventDataSerializer,
} from "./creditNoteEventData.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";

export interface CreditNoteEvent extends CreditNoteEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `CreditNoteEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditNoteEventSerializer = {
  parse(json: any): CreditNoteEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
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
      ...pickProperties(CreditNoteEventDataSerializer.parse(json), [
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
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: CreditNoteEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
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
      ...pickProperties(CreditNoteEventDataSerializer.serialize(value), [
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
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
import { type InvoiceEventData, InvoiceEventDataSerializer } from "./invoiceEventData.js";

export interface InvoiceEvent extends InvoiceEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `InvoiceEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceEventSerializer = {
  parse(json: any): InvoiceEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "consolidated_into_invoice_id",
        "created_at",
        "currency",
        "custom_properties",
        "customer_id",
        "invoice_id",
        "invoice_number",
        "parent_invoice_id",
        "status",
        "tax_amount",
        "total",
      ]),
      ...pickProperties(InvoiceEventDataSerializer.parse(json), [
        "consolidatedIntoInvoiceId",
        "createdAt",
        "currency",
        "customProperties",
        "customerId",
        "invoiceId",
        "invoiceNumber",
        "parentInvoiceId",
        "status",
        "taxAmount",
        "total",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: InvoiceEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "consolidatedIntoInvoiceId",
        "createdAt",
        "currency",
        "customProperties",
        "customerId",
        "invoiceId",
        "invoiceNumber",
        "parentInvoiceId",
        "status",
        "taxAmount",
        "total",
      ]),
      ...pickProperties(InvoiceEventDataSerializer.serialize(value), [
        "consolidated_into_invoice_id",
        "created_at",
        "currency",
        "custom_properties",
        "customer_id",
        "invoice_id",
        "invoice_number",
        "parent_invoice_id",
        "status",
        "tax_amount",
        "total",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

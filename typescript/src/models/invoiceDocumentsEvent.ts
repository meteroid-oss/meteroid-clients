// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
import {
  type InvoiceDocumentsEventData,
  InvoiceDocumentsEventDataSerializer,
} from "./invoiceDocumentsEventData.js";

export interface InvoiceDocumentsEvent extends InvoiceDocumentsEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `InvoiceDocumentsEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceDocumentsEventSerializer = {
  parse(json: any): InvoiceDocumentsEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "customer_id",
        "einvoicing_error",
        "einvoicing_findings",
        "einvoicing_profile",
        "einvoicing_status",
        "invoice_id",
        "pdf_document_id",
        "xml_document_id",
      ]),
      ...pickProperties(InvoiceDocumentsEventDataSerializer.parse(json), [
        "customerId",
        "einvoicingError",
        "einvoicingFindings",
        "einvoicingProfile",
        "einvoicingStatus",
        "invoiceId",
        "pdfDocumentId",
        "xmlDocumentId",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: InvoiceDocumentsEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "customerId",
        "einvoicingError",
        "einvoicingFindings",
        "einvoicingProfile",
        "einvoicingStatus",
        "invoiceId",
        "pdfDocumentId",
        "xmlDocumentId",
      ]),
      ...pickProperties(InvoiceDocumentsEventDataSerializer.serialize(value), [
        "customer_id",
        "einvoicing_error",
        "einvoicing_findings",
        "einvoicing_profile",
        "einvoicing_status",
        "invoice_id",
        "pdf_document_id",
        "xml_document_id",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

// this file is @generated
import { parseDateTime } from "../datetime";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
import {
  type InvoiceDocumentsEventData,
  InvoiceDocumentsEventDataSerializer,
} from "./invoiceDocumentsEventData";

export interface InvoiceDocumentsEvent {
  flattenInvoicedocumentseventdata: InvoiceDocumentsEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const InvoiceDocumentsEventSerializer = {
  _fromJsonObject(object: any): InvoiceDocumentsEvent {
    return {
      flattenInvoicedocumentseventdata:
        InvoiceDocumentsEventDataSerializer._fromJsonObject(
          object["__flatten_invoicedocumentseventdata"]
        ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: InvoiceDocumentsEvent): any {
    return {
      __flatten_invoicedocumentseventdata:
        InvoiceDocumentsEventDataSerializer._toJsonObject(
          self.flattenInvoicedocumentseventdata
        ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

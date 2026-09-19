// this file is @generated
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
import { type InvoiceEventData, InvoiceEventDataSerializer } from "./invoiceEventData";

export interface InvoiceEvent {
  flattenInvoiceeventdata: InvoiceEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const InvoiceEventSerializer = {
  _fromJsonObject(object: any): InvoiceEvent {
    return {
      flattenInvoiceeventdata: InvoiceEventDataSerializer._fromJsonObject(
        object["__flatten_invoiceeventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: new Date(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: InvoiceEvent): any {
    return {
      __flatten_invoiceeventdata: InvoiceEventDataSerializer._toJsonObject(
        self.flattenInvoiceeventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

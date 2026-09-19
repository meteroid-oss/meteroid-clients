// this file is @generated
import { type CustomerEventData, CustomerEventDataSerializer } from "./customerEventData";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
/** Event-specific webhook schemas for type-safe webhook payloads */
export interface CustomerEvent {
  flattenCustomereventdata: CustomerEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const CustomerEventSerializer = {
  _fromJsonObject(object: any): CustomerEvent {
    return {
      flattenCustomereventdata: CustomerEventDataSerializer._fromJsonObject(
        object["__flatten_customereventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: new Date(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: CustomerEvent): any {
    return {
      __flatten_customereventdata: CustomerEventDataSerializer._toJsonObject(
        self.flattenCustomereventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

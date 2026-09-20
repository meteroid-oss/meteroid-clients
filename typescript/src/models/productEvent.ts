// this file is @generated
import { parseDateTime } from "../datetime";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
import { type ProductEventData, ProductEventDataSerializer } from "./productEventData";

export interface ProductEvent {
  flattenProducteventdata: ProductEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const ProductEventSerializer = {
  _fromJsonObject(object: any): ProductEvent {
    return {
      flattenProducteventdata: ProductEventDataSerializer._fromJsonObject(
        object["__flatten_producteventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: ProductEvent): any {
    return {
      __flatten_producteventdata: ProductEventDataSerializer._toJsonObject(
        self.flattenProducteventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

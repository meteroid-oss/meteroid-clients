// this file is @generated
import { parseDateTime } from "../datetime";
import { type AddOnEventData, AddOnEventDataSerializer } from "./addOnEventData";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";

export interface AddOnEvent {
  flattenAddoneventdata: AddOnEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const AddOnEventSerializer = {
  _fromJsonObject(object: any): AddOnEvent {
    return {
      flattenAddoneventdata: AddOnEventDataSerializer._fromJsonObject(
        object["__flatten_addoneventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: AddOnEvent): any {
    return {
      __flatten_addoneventdata: AddOnEventDataSerializer._toJsonObject(
        self.flattenAddoneventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

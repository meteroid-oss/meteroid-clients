// this file is @generated
import { parseDateTime } from "../datetime";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
import { type PlanEventData, PlanEventDataSerializer } from "./planEventData";

export interface PlanEvent {
  flattenPlaneventdata: PlanEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const PlanEventSerializer = {
  _fromJsonObject(object: any): PlanEvent {
    return {
      flattenPlaneventdata: PlanEventDataSerializer._fromJsonObject(
        object["__flatten_planeventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: PlanEvent): any {
    return {
      __flatten_planeventdata: PlanEventDataSerializer._toJsonObject(
        self.flattenPlaneventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

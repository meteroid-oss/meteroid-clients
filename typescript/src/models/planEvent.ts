// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
import { type PlanEventData, PlanEventDataSerializer } from "./planEventData.js";

export interface PlanEvent extends PlanEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `PlanEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanEventSerializer = {
  parse(json: any): PlanEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "created_at",
        "currency",
        "description",
        "name",
        "plan_id",
        "plan_type",
        "status",
        "version",
      ]),
      ...pickProperties(PlanEventDataSerializer.parse(json), [
        "createdAt",
        "currency",
        "description",
        "name",
        "planId",
        "planType",
        "status",
        "version",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: PlanEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "createdAt",
        "currency",
        "description",
        "name",
        "planId",
        "planType",
        "status",
        "version",
      ]),
      ...pickProperties(PlanEventDataSerializer.serialize(value), [
        "created_at",
        "currency",
        "description",
        "name",
        "plan_id",
        "plan_type",
        "status",
        "version",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

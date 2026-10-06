// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type AddOnEventData, AddOnEventDataSerializer } from "./addOnEventData.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";

export interface AddOnEvent extends AddOnEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `AddOnEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const AddOnEventSerializer = {
  parse(json: any): AddOnEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "add_on_id",
        "created_at",
        "description",
        "fee_type",
        "max_instances_per_subscription",
        "name",
        "price_id",
        "product_id",
        "self_serviceable",
      ]),
      ...pickProperties(AddOnEventDataSerializer.parse(json), [
        "addOnId",
        "createdAt",
        "description",
        "feeType",
        "maxInstancesPerSubscription",
        "name",
        "priceId",
        "productId",
        "selfServiceable",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: AddOnEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "addOnId",
        "createdAt",
        "description",
        "feeType",
        "maxInstancesPerSubscription",
        "name",
        "priceId",
        "productId",
        "selfServiceable",
      ]),
      ...pickProperties(AddOnEventDataSerializer.serialize(value), [
        "add_on_id",
        "created_at",
        "description",
        "fee_type",
        "max_instances_per_subscription",
        "name",
        "price_id",
        "product_id",
        "self_serviceable",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

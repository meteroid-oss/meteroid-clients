// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
import { type QuoteEventData, QuoteEventDataSerializer } from "./quoteEventData.js";

export interface QuoteEvent extends QuoteEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `QuoteEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const QuoteEventSerializer = {
  parse(json: any): QuoteEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "customer_id",
        "quote_id",
        "subscription_id",
      ]),
      ...pickProperties(QuoteEventDataSerializer.parse(json), [
        "customerId",
        "quoteId",
        "subscriptionId",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: QuoteEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "customerId",
        "quoteId",
        "subscriptionId",
      ]),
      ...pickProperties(QuoteEventDataSerializer.serialize(value), [
        "customer_id",
        "quote_id",
        "subscription_id",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

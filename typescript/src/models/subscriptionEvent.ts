// this file is @generated
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";
import {
  type SubscriptionEventData,
  SubscriptionEventDataSerializer,
} from "./subscriptionEventData";

export interface SubscriptionEvent {
  flattenSubscriptioneventdata: SubscriptionEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const SubscriptionEventSerializer = {
  _fromJsonObject(object: any): SubscriptionEvent {
    return {
      flattenSubscriptioneventdata: SubscriptionEventDataSerializer._fromJsonObject(
        object["__flatten_subscriptioneventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: new Date(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: SubscriptionEvent): any {
    return {
      __flatten_subscriptioneventdata: SubscriptionEventDataSerializer._toJsonObject(
        self.flattenSubscriptioneventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

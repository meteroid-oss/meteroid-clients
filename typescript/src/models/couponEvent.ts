// this file is @generated
import { parseDateTime } from "../datetime";
import { type CouponEventData, CouponEventDataSerializer } from "./couponEventData";
import { type EventId, EventIdSerializer } from "./eventId";
import { type EventType, EventTypeSerializer } from "./eventType";

export interface CouponEvent {
  flattenCouponeventdata: CouponEventData;

  id: EventId;

  timestamp: Date;

  type: EventType;
}

export const CouponEventSerializer = {
  _fromJsonObject(object: any): CouponEvent {
    return {
      flattenCouponeventdata: CouponEventDataSerializer._fromJsonObject(
        object["__flatten_couponeventdata"]
      ),
      id: EventIdSerializer._fromJsonObject(object["id"]),
      timestamp: parseDateTime(object["timestamp"]),
      type: EventTypeSerializer._fromJsonObject(object["type"]),
    };
  },

  _toJsonObject(self: CouponEvent): any {
    return {
      __flatten_couponeventdata: CouponEventDataSerializer._toJsonObject(
        self.flattenCouponeventdata
      ),
      id: EventIdSerializer._toJsonObject(self.id),
      timestamp: self.timestamp,
      type: EventTypeSerializer._toJsonObject(self.type),
    };
  },
};

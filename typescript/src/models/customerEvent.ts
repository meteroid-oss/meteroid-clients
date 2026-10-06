// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import {
  type CustomerEventData,
  CustomerEventDataSerializer,
} from "./customerEventData.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
/** Event-specific webhook schemas for type-safe webhook payloads */
export interface CustomerEvent extends CustomerEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `CustomerEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerEventSerializer = {
  parse(json: any): CustomerEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "alias",
        "billing_email",
        "currency",
        "custom_properties",
        "customer_id",
        "invoicing_emails",
        "name",
        "phone",
      ]),
      ...pickProperties(CustomerEventDataSerializer.parse(json), [
        "alias",
        "billingEmail",
        "currency",
        "customProperties",
        "customerId",
        "invoicingEmails",
        "name",
        "phone",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: CustomerEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "alias",
        "billingEmail",
        "currency",
        "customProperties",
        "customerId",
        "invoicingEmails",
        "name",
        "phone",
      ]),
      ...pickProperties(CustomerEventDataSerializer.serialize(value), [
        "alias",
        "billing_email",
        "currency",
        "custom_properties",
        "customer_id",
        "invoicing_emails",
        "name",
        "phone",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};

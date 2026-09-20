// this file is @generated

export interface Event {
  /** Billable metric code. Max 512 characters. */
  code: string;

  /** Meteroid customer ID or external customer alias. */
  customerId: string;

  /** Unique event identifier. Max 255 characters. A UUID or ULID is recommended. */
  eventId: string;

  /** Arbitrary string key-value pairs used by billable metrics for filtering and aggregation. */
  properties?: { [key: string]: string };

  /**
   * RFC 3339 timestamp. Defaults to ingestion time if omitted.
   * Must be between 24 hours ago and 1 hour from now. Set `allow_backfilling` to remove the past limit.
   */
  timestamp: string;
}

export const EventSerializer = {
  _fromJsonObject(object: any): Event {
    return {
      code: object["code"],
      customerId: object["customer_id"],
      eventId: object["event_id"],
      properties: object["properties"],
      timestamp: object["timestamp"],
    };
  },

  _toJsonObject(self: Event): any {
    return {
      code: self.code,
      customer_id: self.customerId,
      event_id: self.eventId,
      properties: self.properties,
      timestamp: self.timestamp,
    };
  },
};

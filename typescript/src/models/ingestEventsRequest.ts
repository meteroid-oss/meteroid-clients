// this file is @generated
import { type Event, EventSerializer } from "./event";

export interface IngestEventsRequest {
  /** Allow events with timestamps more than 1 day in the past. Defaults to `false`. */
  allowBackfilling?: boolean | null;

  /**
   * Accept the batch even if some events fail validation. Defaults to `false`.
   * When `true`, valid events are ingested and failures are reported in the response body.
   * When `false` (default), any invalid event rejects the entire batch.
   */
  allowPartialFailures?: boolean | null;

  /** 1–100 events per request. */
  events: Event[];
}

export const IngestEventsRequestSerializer = {
  _fromJsonObject(object: any): IngestEventsRequest {
    return {
      allowBackfilling: object["allow_backfilling"],
      allowPartialFailures: object["allow_partial_failures"],
      events: object["events"].map((item: any) => EventSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: IngestEventsRequest): any {
    return {
      allow_backfilling: self.allowBackfilling,
      allow_partial_failures: self.allowPartialFailures,
      events: self.events.map((item: any) => EventSerializer._toJsonObject(item)),
    };
  },
};

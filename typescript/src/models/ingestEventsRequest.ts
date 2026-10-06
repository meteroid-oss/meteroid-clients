// this file is @generated
import { extraProperties } from "../json.js";
import { type Event, EventSerializer } from "./event.js";

export interface IngestEventsRequest {
  /** Allow events with timestamps more than 1 day in the past. Defaults to `false`. */
  allowBackfilling?: boolean | null | undefined;
  /**
   * Accept the batch even if some events fail validation. Defaults to `false`.
   * When `true`, valid events are ingested and failures are reported in the response body.
   * When `false` (default), any invalid event rejects the entire batch.
   */
  allowPartialFailures?: boolean | null | undefined;
  /** 1–100 events per request. */
  events: Event[];
}

/** Converts `IngestEventsRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const IngestEventsRequestSerializer = {
  parse(json: any): IngestEventsRequest {
    return {
      ...extraProperties(json, ["allow_backfilling", "allow_partial_failures", "events"]),
      allowBackfilling: json["allow_backfilling"],
      allowPartialFailures: json["allow_partial_failures"],
      events: json["events"].map((item: any) => EventSerializer.parse(item)),
    };
  },

  serialize(value: IngestEventsRequest): any {
    return {
      ...extraProperties(value, ["allowBackfilling", "allowPartialFailures", "events"]),
      allow_backfilling: value.allowBackfilling,
      allow_partial_failures: value.allowPartialFailures,
      events: value.events.map((item: any) => EventSerializer.serialize(item)),
    };
  },
};

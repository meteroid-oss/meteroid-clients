// this file is @generated
import { extraProperties } from "../json.js";

export interface IngestFailure {
  eventId: string;
  reason: string;
}

/** Converts `IngestFailure` values from (`parse`) and to (`serialize`) their JSON form. */
export const IngestFailureSerializer = {
  parse(json: any): IngestFailure {
    return {
      ...extraProperties(json, ["event_id", "reason"]),
      eventId: json["event_id"],
      reason: json["reason"],
    };
  },

  serialize(value: IngestFailure): any {
    return {
      ...extraProperties(value, ["eventId", "reason"]),
      event_id: value.eventId,
      reason: value.reason,
    };
  },
};

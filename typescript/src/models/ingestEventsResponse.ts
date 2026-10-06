// this file is @generated
import { extraProperties } from "../json.js";
import { type IngestFailure, IngestFailureSerializer } from "./ingestFailure.js";

export interface IngestEventsResponse {
  /** Events that failed to ingest. Omitted when no failures. */
  failures?: IngestFailure[] | undefined;
}

/** Converts `IngestEventsResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const IngestEventsResponseSerializer = {
  parse(json: any): IngestEventsResponse {
    return {
      ...extraProperties(json, ["failures"]),
      failures:
        json["failures"] != null
          ? json["failures"].map((item: any) => IngestFailureSerializer.parse(item))
          : undefined,
    };
  },

  serialize(value: IngestEventsResponse): any {
    return {
      ...extraProperties(value, ["failures"]),
      failures:
        value.failures != null
          ? value.failures.map((item: any) => IngestFailureSerializer.serialize(item))
          : undefined,
    };
  },
};

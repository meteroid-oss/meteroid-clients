// this file is @generated
import { type IngestFailure, IngestFailureSerializer } from "./ingestFailure";

export interface IngestEventsResponse {
  /** Events that failed to ingest. Omitted when no failures. */
  failures?: IngestFailure[];
}

export const IngestEventsResponseSerializer = {
  _fromJsonObject(object: any): IngestEventsResponse {
    return {
      failures:
        object["failures"] != null
          ? object["failures"].map((item: any) =>
              IngestFailureSerializer._fromJsonObject(item)
            )
          : undefined,
    };
  },

  _toJsonObject(self: IngestEventsResponse): any {
    return {
      failures:
        self.failures != null
          ? self.failures.map((item: any) => IngestFailureSerializer._toJsonObject(item))
          : undefined,
    };
  },
};

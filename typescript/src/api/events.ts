// this file is @generated

import {
  type IngestEventsRequest,
  IngestEventsRequestSerializer,
} from "../models/ingestEventsRequest.js";
import {
  type IngestEventsResponse,
  IngestEventsResponseSerializer,
} from "../models/ingestEventsResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The events operations, reached through the client's `events`. */
export class Events {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * Ingest events
   *
   * Ingest usage events for metering and billing purposes.
   *
   * Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
   * double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.
   *
   * By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body.
   */
  public ingest(
    ingestEventsRequest: IngestEventsRequest,
    requestOptions?: RequestOptions
  ): APIPromise<IngestEventsResponse> {
    const request = new MeteroidRequest("POST", "/api/v1/events/ingest");

    request.setBody(IngestEventsRequestSerializer.serialize(ingestEventsRequest));
    return request.send(
      this.requestCtx,
      IngestEventsResponseSerializer.parse,
      requestOptions
    );
  }
}

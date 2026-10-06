// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { parseJson, IngestEventsRequestSerializer } from "../../src/index.js";
import { mock } from "./mock.js";

test("events.ingest", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: "{}",
  });
  await client.events.ingest(
    IngestEventsRequestSerializer.parse(
      parseJson(
        '{"events":[{"code":"sample","customer_id":"sample","event_id":"sample","timestamp":"sample"}]}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/events/ingest"]);
});

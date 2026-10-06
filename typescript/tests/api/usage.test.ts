// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { mock } from "./mock.js";

test("usage.retrieve_subscription", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"period_end":"1999-12-31","period_start":"2024-02-29","usage":[{"grouped_usage":[{"dimensions":{"alpha":"sample"},"value":"12345.6789"}],"metric_code":"sample","metric_id":"billable_metric_id_44","metric_name":"sample","total_value":"12345.6789"}]}',
  });
  await client.usage.retrieveSubscription("subscription_id");
  assert.deepEqual(requests, ["GET /api/v1/usage/subscription/subscription_id"]);
});

// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { mock } from "./mock.js";

test("features.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","feature_type":{"type":"BOOLEAN"},"id":"feature_id_0","name":"sample","status":"DISABLED"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.features.list();
  assert.deepEqual(requests, ["GET /api/v1/features"]);
});

test("features.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"code":"sample","created_at":"2024-03-15T10:30:45.123+02:00","feature_type":{"type":"BOOLEAN"},"id":"feature_id_90","name":"sample","status":"ARCHIVED"}',
  });
  await client.features.retrieve("id_or_code");
  assert.deepEqual(requests, ["GET /api/v1/features/id_or_code"]);
});

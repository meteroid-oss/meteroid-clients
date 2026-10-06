// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { parseJson, CreateCheckoutSessionRequestSerializer } from "../../src/index.js";
import { mock } from "./mock.js";

test("checkout_sessions.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"sessions":[{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}]}',
  });
  await client.checkoutSessions.list();
  assert.deepEqual(requests, ["GET /api/v1/checkout-sessions"]);
});

test("checkout_sessions.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
  });
  await client.checkoutSessions.create(
    CreateCheckoutSessionRequestSerializer.parse(
      parseJson('{"customer_id":"sample","plan_version_id":"plan_version_id_2"}')
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/checkout-sessions"]);
});

test("checkout_sessions.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
  });
  await client.checkoutSessions.retrieve("id");
  assert.deepEqual(requests, ["GET /api/v1/checkout-sessions/id"]);
});

test("checkout_sessions.cancel", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
  });
  await client.checkoutSessions.cancel("id");
  assert.deepEqual(requests, ["POST /api/v1/checkout-sessions/id/cancel"]);
});

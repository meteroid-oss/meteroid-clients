// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreateConnectedAccountRequestSerializer,
  CreateOnboardingLinkRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("connect.list_connected_accounts", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"connection_type":"standard","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_67","onboarding_mode":"full","platform_organization_id":"organization_id_23","status":"active"}]}',
  });
  await client.connect.listConnectedAccounts();
  assert.deepEqual(requests, ["GET /api/v1/connected-accounts"]);
});

test("connect.create_connected_account", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}',
  });
  await client.connect.createConnectedAccount(
    CreateConnectedAccountRequestSerializer.parse(
      parseJson('{"connected_organization_id":"00000000-0000-0000-0000-000000000000"}')
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/connected-accounts"]);
});

test("connect.retrieve_connected_account", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}',
  });
  await client.connect.retrieveConnectedAccount("id");
  assert.deepEqual(requests, ["GET /api/v1/connected-accounts/id"]);
});

test("connect.disconnect_account", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.connect.disconnectAccount("id");
  assert.deepEqual(requests, ["DELETE /api/v1/connected-accounts/id"]);
});

test("connect.create_onboarding_link", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"expires_at":"2023-12-31T23:59:59.999-05:30","url":"sample"}',
  });
  await client.connect.createOnboardingLink(
    "id",
    CreateOnboardingLinkRequestSerializer.parse(parseJson('{"redirect_url":"sample"}'))
  );
  assert.deepEqual(requests, ["POST /api/v1/connected-accounts/id/onboarding"]);
});

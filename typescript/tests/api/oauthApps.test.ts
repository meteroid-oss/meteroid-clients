// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { parseJson, CreateOAuthAppRequestSerializer } from "../../src/index.js";
import { mock } from "./mock.js";

test("oauth_apps.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]}]}',
  });
  await client.oauthApps.list();
  assert.deepEqual(requests, ["GET /api/v1/oauth-apps"]);
});

test("oauth_apps.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"app":{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]},"client_secret":"sample"}',
  });
  await client.oauthApps.create(
    CreateOAuthAppRequestSerializer.parse(
      parseJson('{"name":"sample","redirect_uris":["sample"]}')
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/oauth-apps"]);
});

test("oauth_apps.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"client_id":"sample","client_secret_hint":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"o_auth_app_id_44","is_active":false,"name":"sample","organization_id":"organization_id_13","redirect_uris":["sample"],"scopes":["sample"]}',
  });
  await client.oauthApps.retrieve("id");
  assert.deepEqual(requests, ["GET /api/v1/oauth-apps/id"]);
});

test("oauth_apps.delete", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.oauthApps.delete("id");
  assert.deepEqual(requests, ["DELETE /api/v1/oauth-apps/id"]);
});

test("oauth_apps.rotate", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"client_secret":"sample","client_secret_hint":"sample"}',
  });
  await client.oauthApps.rotate("id");
  assert.deepEqual(requests, ["POST /api/v1/oauth-apps/id/rotate"]);
});

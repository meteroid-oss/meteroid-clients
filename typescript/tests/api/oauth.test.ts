// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  IntrospectionRequestSerializer,
  RevocationRequestSerializer,
  TokenRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("oauth.introspect", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"active":false}',
  });
  await client.oauth.introspect(
    IntrospectionRequestSerializer.parse(parseJson('{"token":"sample"}'))
  );
  assert.deepEqual(requests, ["POST /api/v1/oauth/introspect"]);
});

test("oauth.revoke", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.oauth.revoke(
    RevocationRequestSerializer.parse(parseJson('{"token":"sample"}'))
  );
  assert.deepEqual(requests, ["POST /api/v1/oauth/revoke"]);
});

test("oauth.token", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"access_token":"sample","expires_in":9007199254740993,"token_type":"sample"}',
  });
  await client.oauth.token(
    TokenRequestSerializer.parse(parseJson('{"grant_type":"sample"}'))
  );
  assert.deepEqual(requests, ["POST /api/v1/oauth/token"]);
});

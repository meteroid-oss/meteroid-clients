// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreateAddOnRequestSerializer,
  UpdateAddOnRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("add_ons.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","id":"add_on_id_0","name":"sample","price_id":"price_id_47","product_id":"product_id_67","self_serviceable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.addOns.list();
  assert.deepEqual(requests, ["GET /api/v1/addons"]);
});

test("add_ons.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
  });
  await client.addOns.create(
    CreateAddOnRequestSerializer.parse(
      parseJson('{"name":"sample","price_id":"price_id_44","product_id":"product_id_47"}')
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/addons"]);
});

test("add_ons.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
  });
  await client.addOns.retrieve("addon_id");
  assert.deepEqual(requests, ["GET /api/v1/addons/addon_id"]);
});

test("add_ons.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
  });
  await client.addOns.update(
    "addon_id",
    UpdateAddOnRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PATCH /api/v1/addons/addon_id"]);
});

test("add_ons.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.addOns.archive("addon_id");
  assert.deepEqual(requests, ["POST /api/v1/addons/addon_id/archive"]);
});

test("add_ons.list_entitlements", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
  });
  await client.addOns.listEntitlements("addon_id");
  assert.deepEqual(requests, ["GET /api/v1/addons/addon_id/entitlements"]);
});

test("add_ons.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.addOns.unarchive("addon_id");
  assert.deepEqual(requests, ["POST /api/v1/addons/addon_id/unarchive"]);
});

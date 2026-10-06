// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreateProductRequestSerializer,
  UpdateProductRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("products.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"catalog":false,"created_at":"2024-03-15T10:30:45.123+02:00","fee_structure":{"type":"RATE"},"fee_type":"CAPACITY","id":"product_id_78","name":"sample","product_family_id":"product_family_id_47"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.products.list();
  assert.deepEqual(requests, ["GET /api/v1/products"]);
});

test("products.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
  });
  await client.products.create(
    CreateProductRequestSerializer.parse(
      parseJson(
        '{"fee_structure":{"type":"RATE"},"name":"sample","product_family_id":"product_family_id_47"}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/products"]);
});

test("products.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
  });
  await client.products.retrieve("product_id");
  assert.deepEqual(requests, ["GET /api/v1/products/product_id"]);
});

test("products.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
  });
  await client.products.update(
    "product_id",
    UpdateProductRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PATCH /api/v1/products/product_id"]);
});

test("products.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.products.archive("product_id");
  assert.deepEqual(requests, ["POST /api/v1/products/product_id/archive"]);
});

test("products.list_entitlements", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
  });
  await client.products.listEntitlements("product_id");
  assert.deepEqual(requests, ["GET /api/v1/products/product_id/entitlements"]);
});

test("products.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.products.unarchive("product_id");
  assert.deepEqual(requests, ["POST /api/v1/products/product_id/unarchive"]);
});

// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { parseJson, ProductFamilyCreateRequestSerializer } from "../../src/index.js";
import { mock } from "./mock.js";

test("product_families.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"id":"product_family_id_9","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.productFamilies.list();
  assert.deepEqual(requests, ["GET /api/v1/product_families"]);
});

test("product_families.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"id":"product_family_id_35","name":"sample"}',
  });
  await client.productFamilies.create(
    ProductFamilyCreateRequestSerializer.parse(parseJson('{"name":"sample"}'))
  );
  assert.deepEqual(requests, ["POST /api/v1/product_families"]);
});

test("product_families.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"id":"product_family_id_35","name":"sample"}',
  });
  await client.productFamilies.retrieve("id_or_alias");
  assert.deepEqual(requests, ["GET /api/v1/product_families/id_or_alias"]);
});

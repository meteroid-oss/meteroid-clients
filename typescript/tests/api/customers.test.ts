// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CustomerCreateRequestSerializer,
  CustomerUpdateRequestSerializer,
  CustomerPatchRequestSerializer,
  CustomerPortalTokenRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("customers.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"currency":"TMT","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_67","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_27","name":"sample","preferred_locales":["sample"]}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.customers.list();
  assert.deepEqual(requests, ["GET /api/v1/customers"]);
});

test("customers.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
  });
  await client.customers.create(
    CustomerCreateRequestSerializer.parse(
      parseJson(
        '{"currency":"MMK","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"]}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/customers"]);
});

test("customers.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
  });
  await client.customers.retrieve("id_or_alias");
  assert.deepEqual(requests, ["GET /api/v1/customers/id_or_alias"]);
});

test("customers.replace", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
  });
  await client.customers.replace(
    "id_or_alias",
    CustomerUpdateRequestSerializer.parse(
      parseJson(
        '{"currency":"COP","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_1"}'
      )
    )
  );
  assert.deepEqual(requests, ["PUT /api/v1/customers/id_or_alias"]);
});

test("customers.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.customers.archive("id_or_alias");
  assert.deepEqual(requests, ["DELETE /api/v1/customers/id_or_alias"]);
});

test("customers.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
  });
  await client.customers.update(
    "id_or_alias",
    CustomerPatchRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PATCH /api/v1/customers/id_or_alias"]);
});

test("customers.list_entitlements", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
  });
  await client.customers.listEntitlements("id_or_alias");
  assert.deepEqual(requests, ["GET /api/v1/customers/id_or_alias/entitlements"]);
});

test("customers.create_portal_token", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"portal_url":"sample","token":"sample"}',
  });
  await client.customers.createPortalToken(
    "id_or_alias",
    CustomerPortalTokenRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["POST /api/v1/customers/id_or_alias/portal-token"]);
});

test("customers.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.customers.unarchive("id_or_alias");
  assert.deepEqual(requests, ["POST /api/v1/customers/id_or_alias/unarchive"]);
});

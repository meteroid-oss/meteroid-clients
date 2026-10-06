// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreatePlanRequestSerializer,
  MinimumCommitmentSerializer,
  ReplacePlanRequestSerializer,
  PatchPlanRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("plans.list_plan_version_entitlements", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
  });
  await client.plans.listPlanVersionEntitlements("plan_version_id");
  assert.deepEqual(requests, ["GET /api/v1/plan-versions/plan_version_id/entitlements"]);
});

test("plans.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"available_parameters":{},"created_at":"2024-03-15T10:30:45.123+02:00","currency":"sample","id":"plan_id_78","name":"sample","net_terms":-2147483648,"plan_type":"FREE","price_components":[{"id":"price_component_id_82","name":"sample"}],"product_family":{"id":"product_family_id_59","name":"sample"},"status":"INACTIVE","version":-2147483648,"version_id":"plan_version_id_31"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.plans.list();
  assert.deepEqual(requests, ["GET /api/v1/plans"]);
});

test("plans.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
  });
  await client.plans.create(
    CreatePlanRequestSerializer.parse(
      parseJson(
        '{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample","plan_type":"CUSTOM","product_family_id":"product_family_id_40","status":"INACTIVE"}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/plans"]);
});

test("plans.update_version_minimum", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"amount":"sample","scope":{"type":"all_components"}}',
  });
  await client.plans.updateVersionMinimum(
    "plan_version_id",
    MinimumCommitmentSerializer.parse(
      parseJson('{"amount":"sample","scope":{"type":"all_components"}}')
    )
  );
  assert.deepEqual(requests, ["PUT /api/v1/plans/versions/plan_version_id/minimum"]);
});

test("plans.delete_version_minimum", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.plans.deleteVersionMinimum("plan_version_id");
  assert.deepEqual(requests, ["DELETE /api/v1/plans/versions/plan_version_id/minimum"]);
});

test("plans.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
  });
  await client.plans.retrieve("plan_id");
  assert.deepEqual(requests, ["GET /api/v1/plans/plan_id"]);
});

test("plans.replace", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
  });
  await client.plans.replace(
    "plan_id",
    ReplacePlanRequestSerializer.parse(
      parseJson(
        '{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample"}'
      )
    )
  );
  assert.deepEqual(requests, ["PUT /api/v1/plans/plan_id"]);
});

test("plans.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
  });
  await client.plans.update("plan_id", PatchPlanRequestSerializer.parse(parseJson("{}")));
  assert.deepEqual(requests, ["PATCH /api/v1/plans/plan_id"]);
});

test("plans.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.plans.archive("plan_id");
  assert.deepEqual(requests, ["POST /api/v1/plans/plan_id/archive"]);
});

test("plans.publish", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
  });
  await client.plans.publish("plan_id");
  assert.deepEqual(requests, ["POST /api/v1/plans/plan_id/publish"]);
});

test("plans.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.plans.unarchive("plan_id");
  assert.deepEqual(requests, ["POST /api/v1/plans/plan_id/unarchive"]);
});

test("plans.list_versions", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_version_id_2","is_draft":true,"version":-2147483648}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.plans.listVersions("plan_id");
  assert.deepEqual(requests, ["GET /api/v1/plans/plan_id/versions"]);
});

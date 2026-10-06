// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreateMetricRequestSerializer,
  UpdateMetricRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("metrics.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"aggregation_type":"COUNT","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_78","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.metrics.list();
  assert.deepEqual(requests, ["GET /api/v1/metrics"]);
});

test("metrics.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
  });
  await client.metrics.create(
    CreateMetricRequestSerializer.parse(
      parseJson(
        '{"aggregation_type":"LATEST","code":"sample","name":"sample","product_family_id":"product_family_id_13"}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/metrics"]);
});

test("metrics.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
  });
  await client.metrics.retrieve("metric_id");
  assert.deepEqual(requests, ["GET /api/v1/metrics/metric_id"]);
});

test("metrics.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
  });
  await client.metrics.update(
    "metric_id",
    UpdateMetricRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PATCH /api/v1/metrics/metric_id"]);
});

test("metrics.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.metrics.archive("metric_id");
  assert.deepEqual(requests, ["POST /api/v1/metrics/metric_id/archive"]);
});

test("metrics.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.metrics.unarchive("metric_id");
  assert.deepEqual(requests, ["POST /api/v1/metrics/metric_id/unarchive"]);
});

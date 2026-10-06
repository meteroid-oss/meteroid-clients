// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreateCouponRequestSerializer,
  UpdateCouponRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("coupons.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"code":"sample","created_at":"2024-03-15T10:30:45.123+02:00","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_25","plan_ids":["plan_id_47"],"redemption_count":-2147483648,"reusable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.coupons.list();
  assert.deepEqual(requests, ["GET /api/v1/coupons"]);
});

test("coupons.create", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
  });
  await client.coupons.create(
    CreateCouponRequestSerializer.parse(
      parseJson(
        '{"code":"sample","discount":{"type":"PERCENTAGE","percentage":"sample"}}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/coupons"]);
});

test("coupons.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
  });
  await client.coupons.retrieve("coupon_id");
  assert.deepEqual(requests, ["GET /api/v1/coupons/coupon_id"]);
});

test("coupons.update", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
  });
  await client.coupons.update(
    "coupon_id",
    UpdateCouponRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PATCH /api/v1/coupons/coupon_id"]);
});

test("coupons.archive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.coupons.archive("coupon_id");
  assert.deepEqual(requests, ["POST /api/v1/coupons/coupon_id/archive"]);
});

test("coupons.disable", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.coupons.disable("coupon_id");
  assert.deepEqual(requests, ["POST /api/v1/coupons/coupon_id/disable"]);
});

test("coupons.enable", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.coupons.enable("coupon_id");
  assert.deepEqual(requests, ["POST /api/v1/coupons/coupon_id/enable"]);
});

test("coupons.unarchive", async () => {
  const { client, requests } = mock({
    status: 204,
    contentType: null,
    body: "",
  });
  await client.coupons.unarchive("coupon_id");
  assert.deepEqual(requests, ["POST /api/v1/coupons/coupon_id/unarchive"]);
});

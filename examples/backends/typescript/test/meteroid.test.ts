/**
 * The Meteroid-backed handlers, against a stubbed Meteroid.
 *
 * There is no tenant to run these against, but the SDK takes a custom `fetch`, so the
 * wire JSON below goes through the SDK's real deserializers and the handlers' real
 * projections. What this pins down is the part of the contract that matters most and
 * that nothing else can reach offline: the 201 / 402 / 403 / 503 split of the metered
 * action, and that a refused request reports **no** usage.
 */

import assert from "node:assert/strict";
import { test } from "node:test";

import { Meteroid } from "@meteroid/sdk";

import { mint, verify } from "../src/session.js";
import { AppState } from "../src/state.js";
import { assertErrorEnvelope, CONFIG, fakeMeteroid, SESSION_SECRET, send, type Stub } from "./support.js";

const ALIAS = "scribe-demo-1";
const HEADERS = {
  authorization: `Bearer ${mint(SESSION_SECRET, ALIAS)}`,
  "content-type": "application/json",
};
const PAGE = { page: 0, per_page: 100, total_items: 0, total_pages: 1 };

const meteredEntitlement = (limit: string | null, usage: Record<string, unknown>, enabled = true) => ({
  data: [
    {
      feature: { id: "feat_1", code: "transcription_minutes", name: "Transcription minutes" },
      value: {
        type: "METERED",
        spec: { enabled, limit, metric_id: "met_1", reset_period: { type: "CALENDAR", interval: 1, unit: "MONTH" } },
        usage,
      },
    },
    {
      feature: { id: "feat_2", code: "retention_days", name: "Retention days" },
      value: { type: "CONFIG", value: { kind: "NUMBER", value: "90.0" } },
    },
  ],
});

const ENTITLEMENTS = `GET /api/v1/customers/${ALIAS}/entitlements`;
const INGEST = "POST /api/v1/events/ingest";
const NO_SUBSCRIPTIONS: Record<string, Stub> = {
  "GET /api/v1/subscriptions": { data: [], pagination_meta: PAGE },
};

const transcribe = (meteroid: ReturnType<typeof fakeMeteroid>, durationSeconds: number) =>
  send("POST", "/api/transcriptions", {
    headers: HEADERS,
    body: JSON.stringify({ title: " Weekly standup ", duration_seconds: durationSeconds }),
    state: new AppState(CONFIG, meteroid.client),
  });

test("a transcription within quota is billed, reported to Meteroid, and projected", async () => {
  const meteroid = fakeMeteroid({
    [ENTITLEMENTS]: meteredEntitlement("60", { consumed: "56.50", remaining: "3.50" }),
    [INGEST]: {},
  });
  const { status, body } = await transcribe(meteroid, 210);

  assert.equal(status, 201);
  assert.deepEqual(meteroid.calls, [ENTITLEMENTS, INGEST]);
  assert.equal(body.transcription.title, "Weekly standup");
  assert.equal(body.transcription.minutes_billed, "3.5");
  assert.equal(body.transcription.event_id, body.transcription.id);
  assert.deepEqual(body.quota, {
    feature_code: "transcription_minutes",
    enabled: true,
    limit: "60",
    consumed: "60",
    remaining: "0",
    reset_at: null,
    unlimited: false,
  });

  // The event Meteroid received: the alias as customer, the minutes as a decimal string.
  const [event] = (meteroid.bodies[1] as { events: Record<string, unknown>[] }).events;
  assert.deepEqual(event, {
    code: "transcription_minutes",
    customer_id: ALIAS,
    event_id: body.transcription.id,
    properties: { minutes: "3.5" },
    timestamp: body.transcription.created_at,
  });
  assert.match(body.transcription.created_at, /^\d{4}-\d\d-\d\dT\d\d:\d\d:\d\dZ$/);
});

test("a request larger than the balance is 402 with a live snapshot, and reports no usage", async () => {
  const meteroid = fakeMeteroid({
    [ENTITLEMENTS]: meteredEntitlement("60", { consumed: "56.5" }),
    ...NO_SUBSCRIPTIONS,
  });
  // 3.5 minutes remain (derived: Meteroid sent no `remaining`); 211 s bills 3.52.
  const { status, body } = await transcribe(meteroid, 211);

  assert.equal(status, 402);
  assertErrorEnvelope(body, "QUOTA_EXHAUSTED");
  assert.equal(body.quota.remaining, "3.5");
  assert.equal(body.quota.limit, "60");
  assert.equal(body.upgrade_plan_code, "pro");
  assert.ok(!meteroid.calls.includes(INGEST), "a refused request must not ingest an event");
});

test("the balance may be spent exactly", async () => {
  const meteroid = fakeMeteroid({
    [ENTITLEMENTS]: meteredEntitlement("60", { remaining: "3.5" }),
    [INGEST]: {},
  });
  const { status, body } = await transcribe(meteroid, 210);

  assert.equal(status, 201);
  assert.equal(body.quota.remaining, "0");
  assert.equal(body.quota.consumed, "3.5");
});

test("an unlimited entitlement never trips the quota", async () => {
  const meteroid = fakeMeteroid({ [ENTITLEMENTS]: meteredEntitlement(null, {}), [INGEST]: {} });
  const { status, body } = await transcribe(meteroid, 7200);

  assert.equal(status, 201);
  assert.equal(body.quota.unlimited, true);
  assert.equal(body.quota.limit, null);
  assert.equal(body.quota.remaining, null);
  assert.equal(body.quota.consumed, "120");
});

test("a missing or disabled entitlement is 403 naming the upgrade", async () => {
  const stubs = [{ data: [] }, meteredEntitlement("60", {}, false)];
  for (const entitlements of stubs) {
    const meteroid = fakeMeteroid({ [ENTITLEMENTS]: entitlements, ...NO_SUBSCRIPTIONS });
    const { status, body } = await transcribe(meteroid, 60);

    assert.equal(status, 403);
    assertErrorEnvelope(body, "FEATURE_NOT_ENTITLED");
    assert.equal(body.quota, null);
    assert.equal(body.upgrade_plan_code, "pro");
    assert.ok(!meteroid.calls.includes(INGEST));
  }
});

test("a failed upgrade lookup never replaces the error it decorates", async () => {
  // No subscriptions stub: that call 404s, and the answer is still the 403.
  const meteroid = fakeMeteroid({ [ENTITLEMENTS]: { data: [] } });
  const { status, body } = await transcribe(meteroid, 60);

  assert.equal(status, 403);
  assert.equal(body.upgrade_plan_code, "pro");
});

test("a feature seeded with the wrong type is the operator's 503, never a paywall", async () => {
  const meteroid = fakeMeteroid({
    [ENTITLEMENTS]: {
      data: [
        {
          feature: { id: "feat_1", code: "transcription_minutes", name: "Transcription minutes" },
          value: { type: "BOOLEAN", enabled: true },
        },
      ],
    },
  });
  const { status, body } = await transcribe(meteroid, 60);

  assert.equal(status, 503);
  assertErrorEnvelope(body, "CATALOG_NOT_SEEDED");
});

test("entitlements are normalized onto the tagged union, decimals as strings", async () => {
  const meteroid = fakeMeteroid({
    [ENTITLEMENTS]: meteredEntitlement("60", { consumed: "1", reset_at: "2026-10-01T00:00:00Z" }),
    "GET /api/v1/metrics": {
      data: [{ id: "met_1", code: "transcription_minutes", name: "Minutes", aggregation_type: "SUM", created_at: "2026-01-01T00:00:00Z", product_family_id: "pf_1" }],
      pagination_meta: PAGE,
    },
  });
  const { status, body } = await send("GET", "/api/entitlements", {
    headers: HEADERS,
    meteroid: meteroid.client,
  });

  assert.equal(status, 200);
  assert.deepEqual(body.entitlements, [
    {
      feature_code: "transcription_minutes",
      feature_name: "Transcription minutes",
      value: {
        type: "METERED",
        enabled: true,
        limit: "60",
        consumed: "1",
        remaining: "59",
        unlimited: false,
        reset_at: "2026-10-01T00:00:00.000Z",
        reset_period: { type: "CALENDAR", interval: 1, unit: "MONTH" },
        metric_code: "transcription_minutes",
      },
    },
    {
      feature_code: "retention_days",
      feature_name: "Retention days",
      // A decimal, as a string — never a JSON number.
      value: { type: "CONFIG", value: { kind: "NUMBER", value: "90" } },
    },
  ]);
});

test("a session creates one Meteroid customer and mints a token bound to its alias", async () => {
  const meteroid = fakeMeteroid({
    "POST /api/v1/customers": ({ body }: { body: unknown }) => ({
      ...(body as object),
      id: "cus_1",
      custom_properties: {},
      invoicing_entity_id: "ive_1",
    }),
  });
  const { status, body } = await send("POST", "/api/session", {
    body: '{"workspace_name":"  Acme  ","email":null}',
    meteroid: meteroid.client,
  });

  assert.equal(status, 201);
  const alias: string = body.workspace.customer_alias;
  assert.match(alias, /^scribe-demo-[0-9a-f]{32}$/);
  assert.deepEqual(body.workspace, { id: alias, name: "Acme", customer_id: "cus_1", customer_alias: alias, currency: "USD" });
  assert.equal(verify(SESSION_SECRET, body.session_token), alias);
  assert.deepEqual(meteroid.bodies[0], {
    alias,
    currency: "USD",
    custom_taxes: [],
    invoicing_emails: [`${alias}@example.invalid`],
    name: "Acme",
  });
});

test("Meteroid's own failures map onto the contract's upstream codes", async () => {
  const cases: [number, string, number][] = [
    [401, "UPSTREAM_UNAUTHORIZED", 502],
    [403, "UPSTREAM_UNAUTHORIZED", 502],
    [429, "RATE_LIMITED", 429],
    [400, "UPSTREAM_ERROR", 502],
    [500, "UPSTREAM_ERROR", 502],
  ];
  for (const [upstreamStatus, code, expected] of cases) {
    const client = new Meteroid("k", {
      serverUrl: "http://meteroid.test",
      numRetries: 0,
      fetch: async () => Response.json({ code: "BAD_REQUEST", message: "nope" }, { status: upstreamStatus }),
    });
    const { status, body } = await send("GET", "/api/transcriptions", { headers: HEADERS, meteroid: client });
    assert.equal(status, 200, "history never calls Meteroid");
    assert.deepEqual(body, { transcriptions: [] });

    const failed = await send("GET", "/api/entitlements", { headers: HEADERS, meteroid: client });
    assert.equal(failed.status, expected, String(upstreamStatus));
    assertErrorEnvelope(failed.body, code);
  }
});
